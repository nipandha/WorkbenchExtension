/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

/**
 *
 * @author hp
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;

public class GETReq {

	public static void main(String args[])
	{
		get();
	
	}

	public static String get() {
		String url = "http://localhost:8080//";
		URL request_url;
		try {
			request_url = new URL(url);
			HttpURLConnection http_conn = (HttpURLConnection)request_url.openConnection();
			http_conn.setFollowRedirects(true);
			http_conn.setConnectTimeout(10000000);
			http_conn.setReadTimeout(10000000);
			http_conn.setInstanceFollowRedirects(true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(http_conn.getInputStream()));
                        String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
                        //String f=new File(response.toString(),"presentation").getAbsolutePath();
			return response.toString();

			//System.out.println(String.valueOf(.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}