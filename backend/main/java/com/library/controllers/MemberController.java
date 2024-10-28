package com.library.controllers;

import com.library.entities.Member;
import com.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping("/")
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        return memberService.updateMember(id, updatedMember);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
