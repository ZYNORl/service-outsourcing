package com.example.serve;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

@SpringBootTest
class ServeApplicationTests {

    @Test
    void contextLoads() {
        try{

            Credential cred = new Credential("AKIDLWTD6P0O3TeaUGl7ZtxgHLD40n8GIwEP", "KRpVxA8wVqthQv0qIVAWfaEH4x1p0Pgg");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {"+8616650343227"};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setTemplateID("908910");
            req.setSign("山楂树之恋");

            String[] templateParamSet1 = {"3344"};
            req.setTemplateParamSet(templateParamSet1);

            req.setSmsSdkAppid("1400502965");

            SendSmsResponse resp = client.SendSms(req);

            System.out.println(SendSmsResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }

}
