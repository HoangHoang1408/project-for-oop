package com.company.TestManager.Tests._20GetListBrands;

import com.company.TestManager.BaseResponse;

import java.util.ArrayList;

public class GetListBrandResponse extends BaseResponse {
    public Data data;

    static class Data {
        public ArrayList<Brand> brands;
    }

    static class Brand {
        public String brand_id;
        public String name;
        public String brand_info;
    }
}
