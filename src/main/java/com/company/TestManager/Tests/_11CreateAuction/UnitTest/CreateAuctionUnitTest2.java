package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest2 extends UnitTest {
    public CreateAuctionUnitTest2(Test test) {
        super(test, "not input yet, Server will return code 1004");
    }

    @Override
    public void test() throws IOException {
        this.params = this.generateDefaultParams();

        CreateAuctionResponse res = sendPostRequest(CreateAuctionResponse.class);
        this.assertionManager.assertEquals(res.code, 1004);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);

    }
}