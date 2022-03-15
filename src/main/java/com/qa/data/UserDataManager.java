package com.qa.data;

import com.pageObjects.LoginPage;

public class UserDataManager  {

	
	
    public static Login getPMLogin(String environment) {
        switch (environment) {
            case "DT2":
                return new Login("", "");
            case "STG":
                return new Login("balachandra.thalner@gmail.com","balachandra");
        }
        return null;

    }
    public static Login getSupplierLogin(String environment) {
        switch (environment) {
            case "DT2":
                return new Login("","");
            case "STG":
                return new Login("","");
        }
        return null;
    }

    public static Login getReviewerLogin(String environment) {
        switch (environment) {
        case "DT2":
            return new Login("","");
        case "STG":
     
        }
        return null;
    }


    public static Login getIntegrationManagerLogin(String environment) {
        switch (environment) {
        case "DT2":
            return new Login("","");
        case "STG":
     
        }
        return null;
    }

    public static Login getNetworkManagerLogin(String environment) {
        switch (environment) {
        case "DT2":
            return new Login("","");
        case "STG":
             }
        return null;

    }

    //MNOPSUser1
}

