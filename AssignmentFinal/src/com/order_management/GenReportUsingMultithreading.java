package com.order_management;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class GenReportUsingMultithreading extends Methods implements Runnable  {

	private volatile String path = null;
	private String str;

	public GenReportUsingMultithreading (String str) {
		this.str = str;
	}

	public void run() {
		System.out.println("multithreading is running");

		Methods obj = new Methods();
		//path = Methods.createFileStamp();
		System.out.println(path);
		try {

			ArrayList  StoreTrimdLines = new ArrayList();

			ArrayList  List = new ArrayList(
					Files.readAllLines(Paths.get("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt")));

			String Lines = null;
			for (int i = 0; i < List.size(); i++) {
				Lines = (String) List.get(i);

				String TrimmedSrting = Lines.trim();

				if (TrimmedSrting.endsWith(str)) {
					StoreTrimdLines.add(Lines + "\n");
				}
			}
			System.out.println(path);
			FileWriter fileWriter = new FileWriter(path, true);
			for (int i = 0; i < StoreTrimdLines.size(); i++) {
					String str = String.valueOf(StoreTrimdLines.get(i));
				fileWriter.write( str );
				if ((i + 1) % 7 == 0) {
					fileWriter.write("\n");
				}
			}
			fileWriter.write("\n");
			fileWriter.close();
			System.out.println("Report Generated Successfully");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}



}
