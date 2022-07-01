package com.company.TestManager.Tests._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.Tests._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.Tests._13CreateItem.CreateItemResponse;
import com.company.TestManager.Tests._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;
import com.company.constants.Constant;

import java.io.IOException;

public class CreateItemUnitTest9 extends UnitTest {
    public CreateItemUnitTest9(Test test) {
        super(test, "If more than 10 characters are entered in the series field, the response code will be 1001 and the data should be null");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = Connection.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION, this.params, CreateAuctionResponse.class, CreateItemTest.accessToken);

        this.params = CreateItemTest.generateDefaultParams();
        String series = this.params.get("series");
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, CreateItemTest.accessToken);
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction1 = Connection.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION, this.params, CreateAuctionResponse.class, CreateItemTest.accessToken);
        this.params = CreateItemTest.generateDefaultParams();
        CreateItemResponse res1 = Connection.sendPostRequest(this.fullURLString + "/" + resAuction1.data.auction_id, this.params, CreateItemResponse.class, CreateItemTest.accessToken);
        this.assertion.assertNotEquals(res1, null);
        this.assertion.assertEquals(res1.code, 1001);
        this.assertion.assertEquals(res1.data, null);


    }
}
