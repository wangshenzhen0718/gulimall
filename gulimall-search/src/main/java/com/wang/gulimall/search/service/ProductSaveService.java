package com.wang.gulimall.search.service;

import com.wang.common.to.es.SkuEsModel;

import java.util.List;

public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws Exception;
}