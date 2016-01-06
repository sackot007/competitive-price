package com.kohls.compprice.service.impl;

import com.jaunt.Document;
import com.jaunt.NotFound;
import org.springframework.stereotype.Service;

/**
 * Created by tkmaw80 on 1/5/16.
 */
@Service("bestBuyPriceRetrieverService")
public class BestBuyPriceRetriever extends BasePriceRetriever {
    private String BESTBUY_URL="http://www.bestbuy.com/site/searchpage.jsp?id=pcat17071&st=";

    public BestBuyPriceRetriever() {
        super.url=this.BESTBUY_URL;
    }

    @Override
    public String getPrice(String upc) {
        Document htmlDoc = super.callURL(url + upc);
        String value="not found";

        try {
            value = htmlDoc.findFirst("<div class='medium-item-price'>").innerText();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }
        return value;

    }
}
