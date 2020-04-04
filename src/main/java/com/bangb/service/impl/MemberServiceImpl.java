package com.bangb.service.impl;

import org.springframework.stereotype.Service;

import com.bangb.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public void query() {
        System.out.println("this is a logic 。。。。");
    }
}
