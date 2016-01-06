package com.kohls.compprice.profile.impl;

import com.kohls.compprice.model.ProductPrice;
import com.kohls.compprice.profile.CategoryServiceProfiler;
import com.kohls.compprice.service.PriceRetriever;

import java.util.Map;

/**
 * Created by tkmaw80 on 1/5/16.
 */
public class CategoryServiceProfilerImpl implements CategoryServiceProfiler {
    private Map<String, PriceRetriever> priceRetrievers;
    private ProductPrice productPrice = new ProductPrice();

    public void setPriceRetrievers(Map<String, PriceRetriever> priceRetrievers) {
        this.priceRetrievers = priceRetrievers;
    }

    @Override
    public ProductPrice apply(String upc) {
        productPrice.setUpc(upc);
        for (Map.Entry<String, PriceRetriever> entry : priceRetrievers.entrySet())
            productPrice.addCompetitorPrice(entry.getKey(), entry.getValue().getPrice(upc));
        return productPrice;
    }
}
