package com.company.TestManager.Tests._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class CreateAuctionUnitTest3 extends UnitTest {
    public CreateAuctionUnitTest3(Test test) {
        super(test, "no 'category_id' field entered or the value exists, Server will return code 1001");
    }

    @Override
    public void test() throws IOException {
        this.params.put("category_id", "");
        this.params.put("start_date", "2023-06-18 11:03:38");
        this.params.put("end_date", "2023-06-20 11:03:38");
        this.params.put("title_ni", "Tui xach "+Util.randomAlphabetString(20));

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertionManager.assertEquals(res.code, 1001);
        this.assertionManager.assertInstanceOf(res.message, String.class);
        this.assertionManager.assertEquals(res.data, null);

    }
}
