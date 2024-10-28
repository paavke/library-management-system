package com.library.services;

import com.library.entities.Badge;
import com.library.entities.Member;
import com.library.repositories.BadgeRepository;
import com.library.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Set<Badge> getBadgesByUserId(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return member.getBadges();
    }


    public void assignBadgeToMember(Long memberId, Long badgeId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Badge badge = badgeRepository.findById(badgeId)
                .orElseThrow(() -> new RuntimeException("Badge not found"));

        member.getBadges().add(badge);
        memberRepository.save(member);
    }
}
