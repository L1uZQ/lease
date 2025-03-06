package com.l1uzq.lease.web.app.service;

public interface SmsService {
    void sendCode(String phone, String code);
}
