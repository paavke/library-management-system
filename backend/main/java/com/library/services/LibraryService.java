package com.library.services;

import com.library.entities.Book;
import com.library.entities.Loan;
import com.library.entities.Member;
import com.library.repositories.BookRepository;
import com.library.repositories.LoanRepository;
import com.library.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private static final int MAX_BOOKS_ALLOWED = 5;
    private static final long LATE_FEE_THRESHOLD = 14;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private NotificationService notificationService;

    public List<Book> getAvailableBooks() {
        return bookRepository.findByIsLoanedFalse();
    }

    public void loanBook(Long bookId, Long memberId) {
        Book book = getBookById(bookId);
        if (book.isLoaned()) {
            throw new RuntimeException("Book is already loaned.");
        }

        Member member = getMemberById(memberId);
        if (member.getTotalBooksLoaned() >= MAX_BOOKS_ALLOWED) {
            throw new RuntimeException("Member cannot borrow more than " + MAX_BOOKS_ALLOWED + " books.");
        }

        Loan loan = new Loan(book, member);
        member.incrementBooksLoaned();
        book.loanBook();

        loanRepository.save(loan);
        bookRepository.save(book);
        memberRepository.save(member);

        notificationService.sendLoanNotification(member.getEmail(), book.getTitle());
    }

    public void returnBook(Long bookId, Long memberId) {
        Book book = getBookById(bookId);
        Member member = getMemberById(memberId);

        for (Loan loan : member.getLoans()) {
            if (loan.getBook().getId().equals(bookId) && !loan.isReturned()) {
                loan.returnBook();
                member.decrementBooksLoaned();
                book.returnBook();

                bookRepository.save(book);
                memberRepository.save(member);

                long daysLate = loan.getDaysLate();
                if (daysLate > LATE_FEE_THRESHOLD) {
                    notificationService.sendLateReturnNotification(member.getEmail(), book.getTitle(), daysLate - LATE_FEE_THRESHOLD);
                }
                return;
            }
        }
        throw new RuntimeException("No active loan found for this book and member.");
    }

    private Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found."));
    }

    private Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found."));
    }

    public List<Loan> getActiveLoans() {
        return loanRepository.findByIsReturnedFalse();
    }
}
