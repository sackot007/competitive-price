package com.kohls.compprice.service;

/**
 * Created by tkmaw80 on 12/26/15.
 */
public interface PriceRetriever {
    String getPrice(String upc);
    String getCodeString();
}
