package com.mvcprime.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvcprime.domain.Product;
import com.mvcprime.service.ProductManager;

@Component
@Scope("session")
public class ProductBean {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
    private ProductManager productManager;

	private List<Product> lista;
	private int priceIncrease;
	
	@PostConstruct
	public void init() {
		lista = new ArrayList<Product>();
		priceIncrease = 15;
	}
	
	public String onsubmit()
    {
        int increase = priceIncrease;
        logger.info("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Incrementado!"));
        return "index";
    }

	public List<Product> getLista() {
		lista = productManager.getProducts();
		return lista;
	}
	public void setLista(List<Product> lista) {
		this.lista = lista;
	}

	public int getPriceIncrease() {
		return priceIncrease;
	}

	public void setPriceIncrease(int priceIncrease) {
		this.priceIncrease = priceIncrease;
	}
	
	
	

	
	
	
	
}
