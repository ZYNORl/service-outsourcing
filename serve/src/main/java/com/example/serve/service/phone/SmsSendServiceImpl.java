package com.example.serve.service.phone;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.springframework.stereotype.Service;

@Service
public class SmsSendServiceImpl implements  SmsSendService{
    @Override
    public boolean sendSms(String[] phoneNumber, String TemplateID, String Sign, String[] templateParam, String SmsSdkAppid) {
        try{

            Credential cred = new Credential("AKIDLWTD6P0O3TeaUGl7ZtxgHLD40n8GIwEP", "KRpVxA8wVqthQv0qIVAWfaEH4x1p0Pgg");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();

            req.setPhoneNumberSet(phoneNumber);
            req.setTemplateID(TemplateID);
            req.setSign(Sign);
            //String[] templateParamSet1 = {"3344"};
            req.setTemplateParamSet(templateParam);

            req.setSmsSdkAppid(SmsSdkAppid);

            SendSmsResponse resp = client.SendSms(req);
            System.out.println(SendSmsResponse.toJsonString(resp));
            return true;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
