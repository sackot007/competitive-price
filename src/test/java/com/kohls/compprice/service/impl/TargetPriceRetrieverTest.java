package com.kohls.compprice.service.impl;

import com.kohls.compprice.service.PriceRetriever;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by tkmaw80 on 12/26/15.
 */
public class TargetPriceRetrieverTest extends TestCase {

    public void testGetPrice() throws Exception {
        ApplicationContext context =
                new FileSystemXmlApplicationContext(new String[] {"/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"});
        PriceRetriever priceRetriever = (TargetPriceRetriever) context.getBean("targetPriceRetrieverService");
        System.out.print(priceRetriever.getPrice("622356533027"));

    }


}