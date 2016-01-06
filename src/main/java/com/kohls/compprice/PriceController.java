package com.kohls.compprice;

import com.kohls.compprice.model.ProductPrice;
import com.kohls.compprice.profile.CategoryServiceProfiler;
import com.kohls.compprice.service.PriceRetriever;
import com.kohls.compprice.service.impl.AmazonPriceRetriever;
import com.kohls.compprice.service.impl.BestBuyPriceRetriever;
import com.kohls.compprice.service.impl.TargetPriceRetriever;
import com.kohls.compprice.service.impl.ToysRUsPriceRetriever;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/price")
public class PriceController implements BeanFactoryAware {
	private BeanFactory beanFactory;
	private CategoryServiceProfiler categoryServiceProfiler;
	@RequestMapping(value = "/{upc}", method = RequestMethod.GET)
	public @ResponseBody
	ProductPrice getPrice(@PathVariable String upc, @RequestParam("category") String category) {
//		ProductPrice productPrice = new ProductPrice();
//		productPrice.setUpc(upc);
//		priceRetriever = (AmazonPriceRetriever)beanFactory.getBean("amazonPriceRetrieverService");
//		productPrice.addCompetitorPrice("amazon", priceRetriever.getPrice(upc));
//		priceRetriever = (TargetPriceRetriever)beanFactory.getBean("targetPriceRetrieverService");
//		productPrice.addCompetitorPrice("target", priceRetriever.getPrice(upc));
//		priceRetriever = (ToysRUsPriceRetriever)beanFactory.getBean("toysRUsPriceRetrieverService");
//		productPrice.addCompetitorPrice("toysrus", priceRetriever.getPrice(upc));
//		priceRetriever = (BestBuyPriceRetriever)beanFactory.getBean("bestBuyPriceRetrieverService");
//		productPrice.addCompetitorPrice("bestbuy", priceRetriever.getPrice(upc));
		categoryServiceProfiler = (CategoryServiceProfiler) beanFactory.getBean(category+"CategoryPriceProfiler");
		return categoryServiceProfiler.apply(upc);

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}