package com.order_management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortFuction implements Comparator {
	static Scanner scan = new Scanner(System.in);

	public  void sortByOrderId() {
		System.out.println("******** Choose Sort Order *********");
		System.out.println("            1).Ascending            ");
		System.out.println("            2).Descending             ");
		System.out.println("Choose option");
		
		int option = scan.nextInt();
		switch (option) {
		case 1:
			class ascendingID implements Comparator<Order>{
				@Override 
				public int compare(Order a , Order b) {
					return a.getOrderID().compareTo(b.getOrderID());
				}
			}
			ArrayList<Order> getList = Methods.getOrderList();
			Collections.sort(getList,new ascendingID());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int i=0; i<getList.size(); i++) {
				System.out.println(getList.get(i));
			}
			System.out.println();
			System.out.println("Successfully Sorted by order ID  in ascending Order\n");
			break;
		case 2:
			class descendingID implements Comparator<Order>{
			@Override 
			public int compare(Order a , Order b) {
				return b.getOrderID().compareTo(a.getOrderID());
			}
		}
		ArrayList<Order> getList1 = Methods.getOrderList();
		Collections.sort(getList1,new descendingID());
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0; i<getList1.size(); i++) {
			System.out.println(getList1.get(i));
		}
		System.out.println();
		System.out.println("Successfully Sorted by order ID in descending Order\n");
		break;
		
		default:
			break;
		}
	}	
		public  void sortByAmount() {
			System.out.println("******** Choose Sort Order *********");
			System.out.println("            1).Ascending            ");
			System.out.println("            2).Descending             ");
			System.out.println("Choose option");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				class ascendingAmount implements Comparator<Order>{
					@Override 
					public int compare(Order a , Order b) {
						return a.getAmount().compareTo(b.getAmount());
					}
				}
				ArrayList<Order> getList = Methods.getOrderList();
				Collections.sort(getList,new ascendingAmount());
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0; i<getList.size(); i++) {
					System.out.println(getList.get(i));
				}
				System.out.println();
				System.out.println("Successfully Sorted by amount  in ascending Order\n");
				break;
			case 2:
				class descendingAount implements Comparator<Order>{
				@Override 
				public int compare(Order a , Order b) {
					return b.getAmount().compareTo(a.getAmount());
				}
			}
			ArrayList<Order> getList1 = Methods.getOrderList();
			Collections.sort(getList1,new descendingAount());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int i=0; i<getList1.size(); i++) {
				System.out.println(getList1.get(i));
			}
			System.out.println();
			System.out.println("Successfully Sorted by amount  in descending Order\n");
			break;

			default:
				break;
			}
		}
 


		public  void sortByDescription() {
			System.out.println("******** Choose Sort Order *********");
			System.out.println("            1).Ascending            ");
			System.out.println("            2).Descending             ");
			System.out.println("Choose option");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				class ascendingDesc implements Comparator<Order>{
					@Override 
					public int compare(Order a , Order b) {
						return a.getOrderDescription().compareTo(b.getOrderDescription());
					}
				}
				ArrayList<Order> getList = Methods.getOrderList();
				Collections.sort(getList,new ascendingDesc());
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0; i<getList.size(); i++) {
					System.out.println(getList.get(i));
				}
				System.out.println();
				System.out.println("Successfully Sorted by order description  in ascending Order\n");
				break;
			case 2:
				class descendingDesc implements Comparator<Order>{
				@Override 
				public int compare(Order a , Order b) {
					return b.getOrderDescription().compareTo(a.getOrderDescription());
				}
			}
			ArrayList<Order> getList1 = Methods.getOrderList();
			Collections.sort(getList1,new descendingDesc());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int i=0; i<getList1.size(); i++) {
				System.out.println(getList1.get(i));
			}
			System.out.println();
			System.out.println("Successfully Sorted by delivery description  in descending Order\n");
			break;

			default:
				break;
			}
		}





		public  void sortByDeliverAdress() {
			System.out.println("******** Choose Sort Order *********");
			System.out.println("            1).Ascending            ");
			System.out.println("            2).Descending             ");
			System.out.println("Choose option");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				class ascendingDeliveryAdress implements Comparator<Order>{
					@Override 
					public int compare(Order a , Order b) {
						return a.getDeliveryAddress().compareTo(b.getDeliveryAddress());
					}
				}
				ArrayList<Order> getList = Methods.getOrderList();
				Collections.sort(getList,new ascendingDeliveryAdress());
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0; i<getList.size(); i++) {
					System.out.println(getList.get(i));
				}
				System.out.println();
				System.out.println("Successfully Sorted by delivery address in ascending Order\n");
				break;
			case 2:
				class descendingDeliveryAdress implements Comparator<Order>{
				@Override 
				public int compare(Order a , Order b) {
					return b.getDeliveryAddress().compareTo(a.getDeliveryAddress());
				}
			}
			ArrayList<Order> getList1 = Methods.getOrderList();
			Collections.sort(getList1,new descendingDeliveryAdress());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int i=0; i<getList1.size(); i++) {
				System.out.println(getList1.get(i));
			}
			System.out.println();
			System.out.println("Successfully Sorted by delivery address in desscending Order\n");
			break;

			default:
				break;
			}
		}
		
		public  void sortByOrderDate() {
			System.out.println("******** Choose Sort Order *********");
			System.out.println("            1).Ascending            ");
			System.out.println("            2).Descending             ");
			System.out.println("Choose option");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				class ascendingOrderDate implements Comparator<Order>{
					@Override 
					public int compare(Order a , Order b) {
						return a.getOrderDate().compareTo(b.getOrderDate());
					}
				}
				ArrayList<Order> getList = Methods.getOrderList();
				Collections.sort(getList,new ascendingOrderDate());
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0; i<getList.size(); i++) {
					System.out.println(getList.get(i));
				}
				System.out.println();
				System.out.println("Successfully Sorted by order date  in ascending Order\n");
				break;
			case 2:
				class descendingOrderDate implements Comparator<Order>{
				@Override 
				public int compare(Order a , Order b) {
					return b.getOrderDate().compareTo(a.getOrderDate());
				}
			}
			ArrayList<Order> getList1 = Methods.getOrderList();
			Collections.sort(getList1,new descendingOrderDate());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int i=0; i<getList1.size(); i++) {
				System.out.println(getList1.get(i));
			}
			System.out.println();
			System.out.println("Successfully Sorted by order date  in descending Order\n");
			break;

			default:
				break;
			}
		}




		public  void sortByDeliverDate() {
			System.out.println("******** Choose Sort Order *********");
			System.out.println("            1).Ascending            ");
			System.out.println("            2).Descending             ");
			System.out.println("Choose option");
			
			int option = scan.nextInt();
			switch (option) {
			case 1:
				class ascendingByDeliverDate implements Comparator<Order>{
					@Override 
					public int compare(Order a , Order b) {
						return a.getDeliveryDateTime().compareTo(b.getDeliveryDateTime());
					}
				}
				ArrayList<Order> getList = Methods.getOrderList();
				Collections.sort(getList,new ascendingByDeliverDate());
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0; i<getList.size(); i++) {
					System.out.println(getList.get(i));
				}
				System.out.println();
				System.out.println("Successfully Sorted by delivery date  in ascending Order\n");
				break;
			case 2:
				class descendingDeliveryDate implements Comparator<Order>{
				@Override 
				public int compare(Order a , Order b) {
					return b.getDeliveryDateTime().compareTo(a.getDeliveryDateTime());
				}
			}
			ArrayList<Order> getList1 = Methods.getOrderList();
			Collections.sort(getList1,new descendingDeliveryDate());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int i=0; i<getList1.size(); i++) {
				System.out.println(getList1.get(i));
			}
			System.out.println();
			System.out.println("Successfully Sorted by delivery date  in descending Order\n");
			break;

			default:
				break;
			}
		}
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}





























































		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}



