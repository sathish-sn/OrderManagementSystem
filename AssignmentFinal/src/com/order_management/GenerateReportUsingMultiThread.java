//package com.order_management;
//
//import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.Writer;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.order_management.OrderManagement.Methods;
//
//public  class GenerateReportUsingMultiThread implements Runnable , OrderManagement{
//	static ArrayList<Order> data1 = new  ArrayList<Order>();
//	static ArrayList<Order> data2 = new  ArrayList<Order>();
//	ArrayList<Order> data = Methods.getOrderList();
//	static	String path2 = "C:\\Users\\Sathisha Narayana\\Desktop\\GenaralReport.txt";
//	Scanner scan = new Scanner(System.in);
//	Methods object = new Methods();
//	//ArrayList<Order> data = Methods.getOrderList();
//	
//
//	@Override
//	public void run() {
//		
//		for(int i=0; i<data.size()/2; i++) {
//			data1.add(data.get(i));
//		}
//
//		
//	
//		FileWriter writer = null;
//		PrintWriter writer1;
//		
//		try {
//			writer1 = new PrintWriter(path2);
//		
//	//	writer1.print("");
//		
//
//		 writer = new FileWriter(path2, true);
//		Writer write = new BufferedWriter(writer);
//	}catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//		try {
//			for (int i = 0; i < data.size(); i++) {
//				writer.write(data1.get(i).toString() + "\n");
//			}
//			writer.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Report generated successfully");
//	
//	
//	}
//	
//
//}
