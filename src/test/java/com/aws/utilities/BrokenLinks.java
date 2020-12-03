package com.aws.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenLinks {
	public void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			int responseCode = httpURLConnection.getResponseCode();
			if(responseCode == 200) {
				System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
			}
			if(responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
				
			// TODO: handle exception
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
	}

}
