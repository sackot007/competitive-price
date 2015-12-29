package com.kohls.compprice.service.impl;

import com.jaunt.Document;
import com.jaunt.NotFound;
import org.springframework.stereotype.Service;

/**
 * Created by tkmaw80 on 12/26/15.
 */
@Service("targetPriceRetrieverService")
public class TargetPriceRetriever extends BasePriceRetriever {
    private String TARGET_URL="http://www.target.com/s?searchTerm=";

    public TargetPriceRetriever () {
        super.url=TARGET_URL;
    }
    @Override
    public String getPrice(String upc) {
        Document htmlDoc = super.callURL(url + upc);
        String value="not found";

        try {
            value = htmlDoc.findFirst("<p class='price price-label'>").innerHTML();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }
        return value;
    }


}
