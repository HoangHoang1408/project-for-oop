package com.company.TestManager.Tests._27ReadNews.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._27ReadNews.ReadNewsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class ReadNewsUnitTest1 extends UnitTest {
    public ReadNewsUnitTest1(Test test) {
        super(test, "Read the notice from the version auction");
    }

    @Override
    public void test() throws IOException {
        ReadNewsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, ReadNewsResponse.class, getAccessToken());
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertEquals(res.data.is_read, "1");
    }
}
