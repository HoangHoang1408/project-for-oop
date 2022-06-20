package com.company.TestManager.Tests._7GetListAuctionsByStatus;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.Tests._6GetListAuctions.GetListAuctionsResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.ConnectionUtil;
import com.company.utils.Util;

import java.io.IOException;
import java.util.List;

public class GetListAuctionsByStatusTest extends Test {

    public GetListAuctionsByStatusTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new GetListAuctionsByStatusUnitTest1(this),
                new GetListAuctionsByStatusUnitTest2(this),
                new GetListAuctionsByStatusUnitTest3(this),
                new GetListAuctionsByStatusUnitTest4(this),
                new GetListAuctionsByStatusUnitTest5(this),
                new GetListAuctionsByStatusUnitTest6(this),
                new GetListAuctionsByStatusUnitTest7(this)
        ));
    }

    public static class GetListAuctionsByStatusUnitTest1 extends UnitTest {
        public GetListAuctionsByStatusUnitTest1(Test test) {
            super(test, "Can find auctions with status 4");
        }

        @Override
        protected void test() throws IOException {
            String index = "1";
            String count = "5";
            this.params.put("index", index);
            this.params.put("count", count);
            GetListAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + "/4", this.params, GetListAuctionsResponse.class, null);
            this.assertionManager.assertEquals(res.code, 1000);
            this.assertionManager.assertNotEquals(res.data.auctions, null);
            this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        }
    }

    public static class GetListAuctionsByStatusUnitTest2 extends UnitTest {
        public GetListAuctionsByStatusUnitTest2(Test test) {
            super(test, "Can find auctions with status 1");
        }

        @Override
        protected void test() throws IOException {
            String index = "1";
            String count = "5";
            this.params.put("index", index);
            this.params.put("count", count);
            GetListAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + "/1", this.params, GetListAuctionsResponse.class, null);
            this.assertionManager.assertEquals(res.code, 1000);
            this.assertionManager.assertNotEquals(res.data.auctions, null);
            this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        }
    }

    public static class GetListAuctionsByStatusUnitTest3 extends UnitTest {
        public GetListAuctionsByStatusUnitTest3(Test test) {
            super(test, "Can find auctions with status 2");
        }

        @Override
        protected void test() throws IOException {
            String index = "1";
            String count = "5";
            this.params.put("index", index);
            this.params.put("count", count);
            GetListAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + "/2", this.params, GetListAuctionsResponse.class, null);
            this.assertionManager.assertEquals(res.code, 1000);
            this.assertionManager.assertNotEquals(res.data.auctions, null);
            this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        }
    }

    public static class GetListAuctionsByStatusUnitTest4 extends UnitTest {
        public GetListAuctionsByStatusUnitTest4(Test test) {
            super(test, "Can find auctions with status 3");
        }

        @Override
        protected void test() throws IOException {
            String index = "1";
            String count = "5";
            this.params.put("index", index);
            this.params.put("count", count);
            GetListAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + "/3", this.params, GetListAuctionsResponse.class, null);
            this.assertionManager.assertEquals(res.code, 1000);
            this.assertionManager.assertNotEquals(res.data.auctions, null);
            this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        }
    }

    public static class GetListAuctionsByStatusUnitTest5 extends UnitTest {
        public GetListAuctionsByStatusUnitTest5(Test test) {
            super(test, "Can find auctions with status 5");
        }

        @Override
        protected void test() throws IOException {
            String index = "1";
            String count = "5";
            this.params.put("index", index);
            this.params.put("count", count);
            GetListAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + "/5", this.params, GetListAuctionsResponse.class, null);
            this.assertionManager.assertEquals(res.code, 1000);
            this.assertionManager.assertNotEquals(res.data.auctions, null);
            this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        }
    }

    public static class GetListAuctionsByStatusUnitTest6 extends UnitTest {
        public GetListAuctionsByStatusUnitTest6(Test test) {
            super(test, "Can find auctions with status 6");
        }

        @Override
        protected void test() throws IOException {
            String index = "1";
            String count = "5";
            this.params.put("index", index);
            this.params.put("count", count);
            GetListAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + "/6", this.params, GetListAuctionsResponse.class, null);
            this.assertionManager.assertEquals(res.code, 1000);
            this.assertionManager.assertNotEquals(res.data.auctions, null);
            this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        }
    }

    public static class GetListAuctionsByStatusUnitTest7 extends UnitTest {
        public GetListAuctionsByStatusUnitTest7(Test test) {
            super(test, "Can handle wrong status id");
        }

        @Override
        protected void test() throws IOException {
            String index = "1";
            String count = "5";
            this.params.put("index", index);
            this.params.put("count", count);
            GetListAuctionsResponse res = ConnectionUtil.sendGetRequest(this.fullURLString + Util.randomAlphabetOrNumberString(3, 3), this.params, GetListAuctionsResponse.class, null);
            this.assertionManager.assertEquals(res.code, 1000);
            this.assertionManager.assertNotEquals(res.data.auctions, null);
            this.assertionManager.assertBoolean(res.data.auctions.size() <= Integer.parseInt(count));
        }
    }
}
