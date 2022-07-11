package com.order_management;

import java.io.IOException;
import java.util.Scanner;

public class GenerateReportUsingMultiThread implements Runnable {
	Scanner scan = new Scanner(System.in);
	Methods object = new Methods();
	@Override
	public void run() {
		System.out.println(" ******** Choose Report Generation Option ********* ");
		System.out.println("                1).Export All                       ");
		System.out.println("                2).By Status ");
		int choice = scan.nextInt();
		switch(choice) {
		case 1:
			try {
				object.GenReport();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("******** Choose Status********* ");
			System.out.println("         1).InProgress			");
			System.out.println("         2).Delivered 			");
			System.out.println("         3).Cancelled		    ");
			int makeChoice = scan.nextInt();
			switch(makeChoice) {
			case 1:
				try {
					Methods.byStatus("In_Progress");
					System.out.println("Report genarated succussfully");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					Methods.byStatus("Delivered");
					System.out.println("Report genarated succussfully");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					Methods.byStatus("Cancelled");
					System.out.println("Report genarated succussfully");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			}
			
		}
	}

}
