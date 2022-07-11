package com.order_management;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

interface orderManagement {

	public class Methods {
		static DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
		static Date now = new Date();
		private static final String filePath = "C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt";
		private static String path = null;

		static public ArrayList<Order> getOrderList() {

			ArrayList<Order> list = new ArrayList<Order>();
			try {
				File file = new File(filePath);
				Scanner readfile = new Scanner(file);
				StringTokenizer token = null; //
				DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd'@'HH:mm:ss");
				Calendar getDateTime = Calendar.getInstance();
				getDateTime.setTime(new Date()); // Using today's date
				getDateTime.add(Calendar.DATE, 5); // Adding 5 days
				String output = dtf.format(getDateTime.getTime());

				String orderId = "";
				String orderDescription = "";
				String deliveryAddress = "";
				LocalDateTime orderDate;
				double amount = 0.0;
				String status = "";
				String deliveryDatetime;

				while (readfile.hasNextLine()) {
					token = new StringTokenizer(readfile.nextLine(), "\t");
					orderId = token.nextToken();
					orderDescription = token.nextToken();
					deliveryAddress = token.nextToken();
					orderDate = LocalDateTime.parse(token.nextToken(), DateTimeFormatter.ISO_DATE_TIME);
					amount = Double.parseDouble(token.nextToken());
					status = token.nextToken();
					deliveryDatetime = token.nextToken();

					Order object = new Order(orderId, orderDescription, deliveryAddress, orderDate, amount,
							deliveryDatetime, status);

					list.add(object);

				}
			} catch (Exception e) {
				System.out.println();
			}
			return list;
		}

		static public ArrayList<Order> getOrderListPrint() {

			ArrayList<Order> list = new ArrayList<Order>();
			try {
				File file = new File(filePath);
				Scanner readfile = new Scanner(file);
				StringTokenizer token = null; //

				Calendar getDateTime = Calendar.getInstance();
				getDateTime.setTime(new Date()); // Using today's date
				getDateTime.add(Calendar.DATE, 5); // Adding 5 days
				// String output = dtf.format(getDateTime.getTime());

				String orderId = "";
				String orderDescription = "";
				String deliveryAddress = "";
				LocalDateTime orderDate;
				double amount = 0.0;
				String status = "";
				String deliveryDatetime;
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"|Order id |Order Description|Delivery Address|   Order date          |        Amount   |      Status       |  Delivery date   |");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
				while (readfile.hasNextLine()) {
					token = new StringTokenizer(readfile.nextLine(), "\t");
					orderId = token.nextToken();
					orderDescription = token.nextToken();
					deliveryAddress = token.nextToken();
					orderDate = LocalDateTime.parse(token.nextToken(), DateTimeFormatter.ISO_DATE_TIME);
					amount = Double.parseDouble(token.nextToken());
					status = token.nextToken();
					deliveryDatetime = token.nextToken();
					;

					Order object = new Order(orderId, orderDescription, deliveryAddress, orderDate, amount,
							deliveryDatetime, status);

					list.add(object);

					System.out.println(object);
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------------------------------------");
				}
			} catch (Exception e) {
				System.out.println();
			}
			return list;

		}

		static SortFuction sort = new SortFuction();

		public void writeToFile(ArrayList<Order> viewList) throws IOException {

			FileWriter writer = new FileWriter("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt", true);
			Writer write = new BufferedWriter(writer);
			try {
				for (int i = 0; i < viewList.size(); i++) {
					writer.write(viewList.get(i).toString() + "\n");
				}
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public void Add_order() throws IOException {
			Scanner scan = new Scanner(System.in);
			int flag = 1;
			outer: while (flag == 1) {
				double amount = 0.0;
				ArrayList<Order> list = new ArrayList<Order>();

				ArrayList<Order> getIdList = Methods.getOrderList();
				ArrayList IDlist = new ArrayList();

				System.out.println("Enter Order Id ");
				String orderId = scan.next();

				Scanner readArray = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList getlist = new ArrayList();

				while (readArray.hasNext()) {
					getlist.add(readArray.next());
				}

				if ((getlist.contains(orderId))) {

					System.out.println("Duplicate Order Id. Please enter unique order id");
					flag = 1;
					continue outer;
				}

				System.out.println("Enter Order Description ");
				scan.nextLine();
				String orderDescription = scan.nextLine();
				System.out.println("Enter Order Delivery Address ");
				String deliveryAddress = scan.nextLine();

				inner: while (true) {
					try {
						System.out.println("Enter the Amount ");
						amount = scan.nextDouble();
						if (amount <= 0.0) {
							System.out.println("Enter valid Amount");
							continue inner;
						}
						break inner;
					} catch (Exception e) {
						System.out.println("please enter valid amount! please fill the details again ");
						scan.nextLine();
						continue inner;

					}
				}

				LocalDateTime orderDate = LocalDateTime.now();
				System.out.println("order time = " + dtf.format(new Date()));

				Calendar getDateTime = Calendar.getInstance();
				getDateTime.setTime(new Date()); // Using today's date
				getDateTime.add(Calendar.DATE, 5); // Adding 5 days
				String deliveryDateTime = dtf.format(getDateTime.getTime());
				System.out.println("Delivery Time = " + deliveryDateTime);
				System.out.println("Order stuts : In_Progress");
				String status = "In_Progress";
				Order obj = new Order(orderId, orderDescription, deliveryAddress, orderDate, amount, deliveryDateTime,
						status);
				list.add(obj);
				System.out.println("enterde data");
				System.out.println(obj);
				writeToFile(list);

				System.out.println("Order Added Successfully");
				flag = 0;
			}
			System.out.println("Do you want to enter more order details(Y/N)");
			String charecter = scan.next();
			if (charecter.charAt(0) == 'y' || charecter.charAt(0) == 'Y') {
				// list.clear();
				Add_order();

			} else if (charecter.charAt(0) == 'n' || charecter.charAt(0) == 'N') {
				return;
			}

		}

//	public void ViewOrderList() {
//		ArrayList<Order> viewList;
//		
//		try {
//			viewList = Methods.getOrderList();
//			for (Order x : viewList) {
//
//				System.out.println(x.getOrderID()  + x.getOrderDescription()  + x.getDeliveryAddress()
//						 + x.getAmount()  + x.getOrderDate()   + x.getDeliveryDateTime()  
//						+ x.getStatus());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

		public int ViewOrderList(String id) {

			ArrayList<Order> viewList;
			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList list = new ArrayList();

				while (scan.hasNext()) {
					list.add(scan.next());
				}

				if (!(list.contains(id))) {

					System.out.println("ID not found! Please enter valid Order Id");
					return 1;
				}
				viewList = getOrderList();

				for (Order getValue : viewList) {

					if (getValue.getOrderID().equals(id)) {
						System.out.println("-----------------------------------------------------");
						System.out.println("Order Detail:");
						System.out.println("-----------------------------------------------------");
						System.out.println("OrderId: " + getValue.getOrderID());
						System.out.println("Order Description: " + getValue.getOrderDescription());
						System.out.println("Delivery Address: " + getValue.getDeliveryAddress());
						System.out.println("Order Date: " + getValue.getOrderDate());
						System.out.println("Amount: " + getValue.getAmount());
						System.out.println("Delivery Datetime: " + getValue.getDeliveryDateTime());
						System.out.println("Status: " + getValue.getStatus());
						System.out.println("-----------------------------------------------------");
					}

				}
				return 0;// Methods.main(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

		public void sortOrder() {
			Scanner scan = new Scanner(System.in);
			int flag = 1;
			outer: while (flag == 1) {
				System.out.println("******** Choose Sort Order Property********* ");
				System.out.println("  1.Order Id ");
				System.out.println("  2.Order Desc  ");
				System.out.println("  3.DeliveryAddress");
				System.out.println("  4.Amount  ");
				System.out.println("  5.Order Date ");
				System.out.println("  6.Delivery Datetime  ");
				System.out.println("  7.Exit  ");

				String ch = scan.next();
				if (!(ch.matches("[0-7]+"))) {
					System.out.println("please choose valid option");
					sortOrder();
				}

				switch (ch) {
				case "1":

					sort.sortByOrderId();
					break;
				case "2":

					sort.sortByDescription();
					break;
				case "3":
					sort.sortByDeliverAdress();
					break;
				case "4":
					sort.sortByAmount();
					break;
				case "5":
					sort.sortByOrderDate();
					break;
				case "6":
					sort.sortByDeliverDate();
					break;
				case "7":
					flag = 0;
					return;
				default:
					flag = 1;
					continue outer;
				}
			}
		}

		public void DeleteById() throws IOException {
			Scanner scan = new Scanner(System.in);
			int flag = 1;
			outer: while (flag == 1) {
				System.out.println("Enter the Order id ");
				String deleteID = scan.next();

				ArrayList<Order> viewList = getOrderList();
				System.out.println(viewList);
				Scanner readArray = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList list = new ArrayList();

				while (readArray.hasNext()) {
					list.add(readArray.next());
				}

				if (!(list.contains(deleteID))) {

					System.out.println("Please enter valid Order Id");
					continue outer;
				}
				for (Order getValue : viewList) {
					// System.out.println(x.getOrderID());
					if (getValue.getOrderID().equals(deleteID)) {

						viewList.remove(getValue);
						System.out.println(viewList);
						System.out.println("order Delete Successfully ");
						break;
					}

				}
				PrintWriter writer = new PrintWriter(filePath);
				writer.print("");

				writeToFile(viewList);

				// System.out.println("Order deleted Succussfull");
				flag = 0;
			}
			System.out.println("Do you want to delete another order(Y/N) ");
			String ch1 = scan.next();
			if (ch1.equalsIgnoreCase("y")) {
				DeleteById();
			} else if (ch1.equalsIgnoreCase("n")) {
				main1();

			}

		}

		private void main1() {
			return;
		}

		public void MarkAsDel() throws IOException {
			Scanner scan = new Scanner(System.in);
			int flag = 1;
			outer: while (flag == 1) {
				// DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");

				System.out.println("Enter the Order id ");
				String markAsDel = scan.next();
				ArrayList<Order> viewList = getOrderList();
				System.out.println(viewList);
				System.out.println(markAsDel);
				Scanner readArray = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList list = new ArrayList();

				while (readArray.hasNext()) {
					list.add(readArray.next());
				}

				if (!(list.contains(markAsDel))) {

					System.out.println("Id not Found! Please enter valid Order Id");
					// flag = 1;
					continue outer;
				}
				for (Order getValue : viewList) {
					if (getValue.getOrderID().equals(markAsDel) && getValue.getStatus().equals("Cancelled")) {
						System.out.println("Order is already cancelled cannot marked as delivered! please reorder");
						continue outer;

					} else if (getValue.getOrderID().equals(markAsDel) && getValue.getStatus().equals("Delivered")) {
						System.out.println("Order is already delivered on " + getValue.getDeliveryDateTime());
						continue outer;

					}

					if (getValue.getOrderID().equals(markAsDel)) {

						getValue.setStatus("Delivered");
						getValue.setDeliveryDateTime(dtf.format(new Date()));
						System.out.println(viewList);
						System.out.println("order marked as delivered Successfully ");
						flag = 0;
						break;
					}

				}
				PrintWriter writer = new PrintWriter(filePath);
				writer.print("");

				writeToFile(viewList);
			}
			System.out.println("Do you want to mark another order(Y/N) as delivered");
			String ch1 = scan.next();
			if (ch1.equalsIgnoreCase("y")) {
				MarkAsDel();
			} else if (ch1.equalsIgnoreCase("n")) {
				return;
			}

		}

		public void CancleById() throws IOException {

			Scanner scan = new Scanner(System.in);
			int flag = 1;
			outer: while (flag == 1) {
				System.out.println("Enter the Order id ");
				String cancel = scan.next();

				ArrayList<Order> viewList = getOrderList();
				System.out.println(viewList);
				Scanner readArray = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList list = new ArrayList();

				while (readArray.hasNext()) {
					list.add(readArray.next());
				}

				if (!(list.contains(cancel))) {

					System.out.println(" ID not foiund! Please enter valid Order Id");
					continue outer;
				}
				for (Order x : viewList) {
					if (x.getOrderID().equals(cancel) && x.getStatus().equals("Cancelled")) {
						System.out.println("Order is already cancelled");
						continue outer;
					} else if (x.getOrderID().equals(cancel) && x.getStatus().equals("Delivered")) {
						System.out.println("Order is already cancelled");
						continue outer;
					} else if (x.getOrderID().equals(cancel)) {

						x.setStatus("Cancelled");
						x.setDeliveryDateTime(null);
						System.out.println(viewList);
						System.out.println("order marked as delivered Successfully ");

						break;
					}

				}
				PrintWriter writer = new PrintWriter(filePath);
				writer.print("");

				writeToFile(viewList);
				flag = 0;
			}
			System.out.println("Do you want to mark another order(Y/N) as delivered");
			String ch1 = scan.next();
			if (ch1.equalsIgnoreCase("y")) {
				CancleById();
			} else if (ch1.equalsIgnoreCase("n")) {
				return;
			}

		}

		static String createFileStamp() {
			try {
				String filename, filename1;

				filename1 = new SimpleDateFormat("yyyy-MMdd-HHmm'.txt'").format(new Date());
				filename = "Order_Report_" + filename1;
				File file = new File("C://Users//Sathisha Narayana//Desktop//Reports//" + filename);
				boolean value = file.createNewFile();
				System.out.println(file.getAbsolutePath());
				path = file.getAbsolutePath();
				if (value)
					System.out.println("file created");
				else
					System.out.println("file exist");

			} catch (Exception e) {
			}
			return path;

		}

		public void GenReport() throws IOException {
			String path2 = "C:\\Users\\Sathisha Narayana\\Desktop\\GenaralReport.txt";
			ArrayList<Order> data = Methods.getOrderList();
			createFileStamp();
			PrintWriter writer1 = new PrintWriter(path2);
			writer1.print("");

			FileWriter writer = new FileWriter(path2, true);
			Writer write = new BufferedWriter(writer);

			try {
				for (int i = 0; i < data.size(); i++) {
					writer.write(data.get(i).toString() + "\n");
				}
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.println("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt");
			System.out.println("Report generated successfully");
		}

		public static void byStatus(String str) throws IOException {
			Scanner Scan = new Scanner(System.in);
			ArrayList<Order> data = Methods.getOrderList();

			createFileStamp();

			FileWriter filewriter = new FileWriter(path, true);
			Writer rwrite = new BufferedWriter(filewriter);

			for (Order getLine : data) {
				if ((getLine.getStatus().equals(str))) {
					System.out.println(getLine);
					filewriter.write(getLine + "\n");
				}

			}
			filewriter.close();

		}

	}

}
