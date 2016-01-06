package com.kohls.compprice.profile;

import com.kohls.compprice.model.ProductPrice;
import com.kohls.compprice.service.PriceRetriever;

/**
 * Created by tkmaw80 on 1/5/16.
 */
public interface CategoryServiceProfiler {
    ProductPrice apply(String upc);
}
