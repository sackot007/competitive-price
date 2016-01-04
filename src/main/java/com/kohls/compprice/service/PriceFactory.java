package com.kohls.compprice.service;

import com.kohls.compprice.service.impl.AmazonPriceRetriever;

/**
 * Created by global on 1/4/16.
 */
public class PriceFactory {

    public final static int AMAZON_PRICE = 0;
    public final static int TARGET_PRICE = 1;


    public static PriceRetriever getPriceRetrieverBean(ApplicationContext context,int competitorID)
    {
        PriceRetriever priceRetriever = null;
        switch (competitorID)
        {
            case AMAZON_PRICE:
                priceRetriever = (AmazonPriceRetriever)context.getBean("amazonPriceRetrieverService");
                break;
            case TARGET_PRICE:
                priceRetriever = (AmazonPriceRetriever)context.getBean("targetPriceRetrieverService");
                break;

        }
        return priceRetriever;
    }

}
