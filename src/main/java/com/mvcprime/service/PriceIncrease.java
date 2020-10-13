package com.mvcprime.service;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ManagedBean(name="priceIncreaseMB")
@RequestScoped
public class PriceIncrease implements Serializable{

	private static final long serialVersionUID = 1L;
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Min(0)
    @Max(50)
    private int percentage;

    public void setPercentage(int i) {
        percentage = i;
        logger.info("Percentage set to " + i);
    }

    public int getPercentage() {
        return percentage;
    }
}
