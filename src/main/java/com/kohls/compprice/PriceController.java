package com.kohls.compprice;

import com.kohls.compprice.model.ProductPrice;
import com.kohls.compprice.service.PriceFactory;
import com.kohls.compprice.service.PriceRetriever;
import com.kohls.compprice.service.impl.AmazonPriceRetriever;
import com.kohls.compprice.service.impl.TargetPriceRetriever;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/price")
public class PriceController {
	private PriceRetriever priceRetriever;
	@RequestMapping(value = "/{upc}", method = RequestMethod.GET)
	public @ResponseBody
	ProductPrice getPrice(@PathVariable String upc) {
		ApplicationContext context = new ClassPathXmlApplicationContext("../mvc-dispatcher-servlet.xml");
		ProductPrice productPrice = new ProductPrice();
		productPrice.setUpc(upc);
		priceRetriever = (AmazonPriceRetriever)context.getBean("amazonPriceRetrieverService");
		productPrice.addCompetitorPrice("amazon", priceRetriever.getPrice(upc));
		priceRetriever = (TargetPriceRetriever)context.getBean("targetPriceRetrieverService");
		productPrice.addCompetitorPrice("target", priceRetriever.getPrice(upc));
		return productPrice;

	}

	//Method to get specific comparative price,
	// TODO: I am not aware of how RequestMapping works, hence Sachin please update the request mapping.
	// Request = localhost:8080/upc?comparativeID=PriceFactory.AMAZON_PRICE
	
	@RequestMapping(value = "/{upc}?....", method = RequestMethod.GET)
	public @ResponseBody
	ProductPrice getSpecificPrice(@PathVariable String upcCode,int comparativeID)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("../mvc-dispatcher-servlet.xml");
		priceRetriever = PriceFactory.getPriceRetrieverBean(context,comparativeID);
		ProductPrice productPrice = new ProductPrice();
		productPrice.setUpc(upcCode);
		productPrice.addCompetitorPrice(priceRetriever.getCodeString(), priceRetriever.getPrice(upc));
		return productPrice;
	}
}