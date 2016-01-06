package com.kohls.compprice.service.impl;

import com.jaunt.Document;
import com.jaunt.NotFound;
import org.springframework.stereotype.Service;

/**
 * Created by tkmaw80 on 1/5/16.
 */
@Service("toysRUsPriceRetrieverService")
public class ToysRUsPriceRetriever extends BasePriceRetriever {
    private String TOYSRUS_URL="http://www.toysrus.com/search/controller.jsp";
    private String UPC_PARAM_KEY="kw=";

    public ToysRUsPriceRetriever() {
        super.url = this.TOYSRUS_URL;
    }

    @Override
    public String getPrice(String upc) {
        Document htmlDoc = super.sendPOST(url, UPC_PARAM_KEY+upc);
        String value="not found";

        try {
            value = htmlDoc.findFirst("<li class='retail fl '>").findFirst("<span>").innerHTML();
        } catch (NotFound notFound) {
            System.out.println(upc + " is not found in Toysrus");
        }
        return value;

    }
}
