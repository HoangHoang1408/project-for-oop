package com.company.Tests.Login;

import com.company.BaseURL;
import com.company.Tests.Login.UnitTests.LoginUnitTest1;
import com.company.Tests.Login.UnitTests.LoginUnitTest2;
import com.company.Tests.Login.UnitTests.LoginUnitTest3;
import com.company.Tests.Test;

import java.util.List;

// class kế thừa class test với mục đích thêm các unit test
public class LoginTest extends Test {
    public LoginTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
//    phương thức cần phải ghi đè từ phương thức của class cha
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new LoginUnitTest1(this), new LoginUnitTest2(this), new LoginUnitTest3(this)));
    }
}
