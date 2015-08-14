package com.provenir.automation.framework.utility;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	    public static ExtentReports extent;
	    
	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            
	            
	            // optional
	            extent.config()
	                .documentTitle("Automation Report")
	                .reportTitle("Regression")
	                .reportHeadline("Smoke");
	               
	            
	            
	        }
	        return extent;
	    }
	}

