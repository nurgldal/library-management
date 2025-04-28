package com.example.libraryManagement.service;

import com.example.libraryManagement.model.Member;
import com.example.libraryManagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Get all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get a specific member by id
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    // Create a new member (used in controller)
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // Update an existing member (used in controller)
    public Member updateMember(Long id, Member member) {
        if (memberRepository.existsById(id)) {
            member.setId(id);  // Ensure the ID is set before saving
            return memberRepository.save(member);
        }
        return null;  // Return null if member not found
    }

    // Delete a member
    public boolean deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;  // Member deleted
        }
        return false;  // Member not found
    }
}
