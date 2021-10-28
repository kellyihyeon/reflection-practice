package com.github.kelly.reflections.service;

import com.github.kelly.reflections.Service;

@Service
public class SuccessService {

    public void getSuccessMessage() {
        System.out.println("SuccessService - getSuccessMessage: Hi, there?");
    }
}
