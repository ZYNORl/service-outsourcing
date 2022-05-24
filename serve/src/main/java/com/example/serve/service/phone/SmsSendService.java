package com.example.serve.service.phone;

public interface SmsSendService {
    public boolean sendSms(String[] phoneNumber, String TemplateID, String Sign, String[] templateParam,String SmsSdkAppid);
}
