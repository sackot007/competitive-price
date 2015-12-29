package com.kohls.compprice.service.impl;

import com.jaunt.Document;
import com.jaunt.NotFound;
import org.springframework.stereotype.Service;

/**
 * Created by tkmaw80 on 12/26/15.
 */
@Service("amazonPriceRetrieverService")
public class AmazonPriceRetriever extends BasePriceRetriever {
    private String AMAZON_URL="http://www.amazon.com/s/ref=nb_sb_noss?field-keywords=";

    public AmazonPriceRetriever () {
        super.url=AMAZON_URL;
    }
    @Override
    public String getPrice(String upc) {
        Document htmlDoc = super.callURL(url + upc);
        String value="not found";

        try {
            value = htmlDoc.findFirst("<span class='a-size-base a-color-price s-price a-text-bold'>").innerHTML();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }
        return value;
    }


}
