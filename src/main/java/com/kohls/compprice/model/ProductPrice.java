package com.kohls.compprice.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tkmaw80 on 12/26/15.
 */
public class ProductPrice {
    String upc;
    List<CompetitorPrice> competitorPrices = new ArrayList<CompetitorPrice>();

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public void addCompetitorPrice(String vendorCd, String vendorPrice) {
        competitorPrices.add(new CompetitorPrice(vendorCd, vendorPrice));
    }

    public List<CompetitorPrice> getCompetitorPrices() {
        return competitorPrices;
    }

    public void setCompetitorPrices(List<CompetitorPrice> competitorPrices) {
        this.competitorPrices = competitorPrices;
    }

    class CompetitorPrice {
        String vendorCd;
        String vendorPrice;

        public CompetitorPrice(String vendorCd, String vendorPrice) {
            this.vendorCd = vendorCd;
            this.vendorPrice = StringUtils.trimAllWhitespace(vendorPrice);
        }

        public String getVendorCd() {
            return vendorCd;
        }

        public String getVendorPrice() {
            return vendorPrice;
        }

    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String val = null;
        try {
            val = objectMapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }
}
