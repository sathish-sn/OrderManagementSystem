//package com.order_management;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class readOrder {
//	private static ArrayList<Order> orderList = new ArrayList<Order>();
//	
//	
//
//	public static ArrayList<Order> getOrderList() {
//		return readOrder.orderList;
//	}
//
//	
//	public static void setOrderList(ArrayList<Order> orderList) {
//		readOrder.orderList = orderList;
//	}
//	
//	public static void readOrders() {
//		ArrayList<Order> list = new ArrayList<Order>();
//		try {
//		File file = new File("C:\\Users\\Sathisha Narayana\\Desktop\\OrderManagement.txt");
//		Scanner readfile = new Scanner(file);
//		StringTokenizer token = null; //
//		
//		String orderId = "";
//	 	String orderDescription = "";
//		String deliveryAddress = "";
//	 	LocalDateTime orderDate;
//	 	double amount = 0.0;
//	 	String status = "";
//	 	LocalDateTime deliveryDatetime;
//	 	
//	 	while(readfile.hasNextLine()) {
//	 		token = new StringTokenizer(readfile.nextLine(),"\t");
//	 		orderId = token.nextToken();
//	 		orderDescription = token.nextToken();
//	 		deliveryAddress = token.nextToken();
//	 		orderDate = LocalDateTime.parse(token.nextToken(),DateTimeFormatter.BASIC_ISO_DATE);
//	 		amount = Double.parseDouble(token.nextToken());
//	 		status = token.nextToken();
//	 		deliveryDatetime = LocalDateTime.now().plusDays(5);
//	 		
//	 		Order obj = new Order(orderId, orderDescription, deliveryAddress, orderDate, amount, status, deliveryDatetime);
//	 		
//	 		orderList.add(obj);
//	 		//System.out.println(orderList);
//	 	}
//	 	}catch(Exception e) {
//	 		e.printStackTrace();
//	 	}
//		}
//	
//
//}
