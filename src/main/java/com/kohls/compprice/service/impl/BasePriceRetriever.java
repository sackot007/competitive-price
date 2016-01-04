package com.kohls.compprice.service.impl;

import com.jaunt.Document;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.kohls.compprice.service.PriceRetriever;
import org.springframework.stereotype.Service;

/**
 * Created by tkmaw80 on 12/26/15.
 */
@Service
public class BasePriceRetriever implements PriceRetriever {
    protected String url;

    @Override
    public String getPrice(String upc) {
        return null;
    }

    public Document callURL(String urlwithUpc) {
        UserAgent userAgent = new UserAgent();

        try {
            userAgent.visit(urlwithUpc);

        } catch (ResponseException e) {
            e.printStackTrace();
        }
        return userAgent.doc;

    }


    @Override
    public String getCodeString() {
        return null;
    }
}
