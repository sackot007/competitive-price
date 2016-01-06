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
public abstract class BasePriceRetriever implements PriceRetriever {
    protected String url;
    final UserAgent userAgent = new UserAgent();

    @Override
    public abstract String getPrice(String upc);

    public Document callURL(String urlwithUpc) {
        try {
            userAgent.visit(urlwithUpc);

        } catch (ResponseException e) {
            e.printStackTrace();
        }
        return userAgent.doc;

    }

    public Document sendPOST(String url, String postParams) {
        try {
            userAgent.sendPOST(url, postParams);
        } catch (ResponseException e) {
            e.printStackTrace();
        }
        return userAgent.doc;

    }
}
