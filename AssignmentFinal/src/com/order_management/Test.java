package com.order_management;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import com.order_management.OrderManagement.Methods;

public class Test extends Thread implements OrderManagement,Runnable{
	
	static ArrayList<Order> data1 = new ArrayList<Order>();
	static ArrayList<Order> data2 = new ArrayList<Order>();
	ArrayList<Order> data = Methods.getOrderList();
	static String path2 = "C:\\Users\\Sathisha Narayana\\Desktop\\GenaralReport.txt";
	Scanner scan = new Scanner(System.in);
	Methods object = new Methods();
	String path = Methods.createFileStamp();
	public void clearFile() {
		PrintWriter writer1;
		try {
			System.out.println("clearing file");
			writer1 = new PrintWriter(path);
			writer1.print("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		
	}
	public void run() {
		synchronized(this) {
			//clearFile();
			System.out.println("test- thread1");
		for (int i = 0; i < data.size() / 2; i++) {
			data1.add(data.get(i));
		}
			FileWriter writer = null;
			PrintWriter writer1;
           System.out.println(data1);
			try {
				
				writer = new FileWriter(path, true);
				Writer write = new BufferedWriter(writer);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				for (int j = 0; j < data1.size(); j++) {
					writer.write(data1.get(j).toString() + "\n");
				}
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}//System.out.println("Report generated successfully");
		}
	

	public class Test1 extends Thread {
		
		public void run() {
			synchronized(this) {
				//clearFile();
				System.out.println("test1-thread2");
			for (int i = data.size() / 2; i < data.size(); i++) {
				data2.add(data.get(i));
			}
				FileWriter writer = null;
				PrintWriter writer1;
				System.out.println(data2);
				try {
					writer1 = new PrintWriter(path);


					writer = new FileWriter(path, true);
					Writer write = new BufferedWriter(writer);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					for (int j = 0; j < data2.size(); j++) {
						writer.write(data2.get(j).toString() + "\n");
					}
					writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Report generated successfully");
			}

		}
	}

		public class Test2 extends Thread {
			public void run() {
				synchronized(this) {
					System.out.println("test2");
					ArrayList<Order> data = Methods.getOrderList();
					ArrayList<Order> getData = new ArrayList<>();
					//String path = Methods.createFileStamp();
					System.out.println("path = "+path);
					for (Order getLine : data) {
						if ((getLine.getStatus().equals("In_Progress"))) {
							getData.add(getLine);
							
						}
						}
					System.out.println(getData);
						FileWriter writer = null;
						PrintWriter writer1;
					//	System.out.println(data2);
						try {
							writer1 = new PrintWriter(path);

							//writer1.print("");

							writer = new FileWriter(path, true);
							Writer write = new BufferedWriter(writer);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							for (int j = 0; j < getData.size()/2; j++) {
								writer.write(getData.get(j).toString() + "\n");
								System.out.println(getData.get(j));
							}
							writer.close();

						} catch (IOException e) {
							e.printStackTrace();
						}
					//	System.out.println("Report generated successfully");
					}
			}
		}
			public class Test3 extends Thread {
				public void run() {
					synchronized(this) {
						
						try {
							sleep(3000);
						} catch (InterruptedException e2) {
							e2.printStackTrace();
						}
						System.out.println("test2");
						ArrayList<Order> data = Methods.getOrderList();
						ArrayList<Order> getData = new ArrayList<>();
						System.out.println("path = "+path);
						try {
						FileWriter filewriter = new FileWriter(path, true);
						Writer rwrite = new BufferedWriter(filewriter);
						for (Order getLine : data) {
							if ((getLine.getStatus().equals("In_Progress"))) {
								getData.add(getLine);
								//System.out.println(getLine);
								filewriter.write(getLine + "\n");
							}
							}
						System.out.println(getData);
							FileWriter writer = null;
							PrintWriter writer1;
							try {
								writer1 = new PrintWriter(path);

								//writer1.print("");

								writer = new FileWriter(path, true);
								Writer write = new BufferedWriter(writer);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							try {
								for (int j = getData.size(); j < getData.size(); j++) {
									writer.write(getData.get(j).toString() + "\n");
									System.out.println(getData.get(j));
								}
								writer.close();

							} catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("Report generated successfully");
						}catch(Exception e) {
							System.out.println("file not found");
						}
					}
				}
			}
				public class Test4 extends Thread {
					
					public void run() {

						synchronized(this) {
							System.out.println("test4");
							ArrayList<Order> data = Methods.getOrderList();
							ArrayList<Order> getData = new ArrayList<>();
							//String path = Methods.createFileStamp();
							System.out.println("path = "+path);
							for (Order getLine : data) {
								if ((getLine.getStatus().equals("Delivered"))) {
									getData.add(getLine);
									//System.out.println(getLine);
									//filewriter.write(getLine + "\n");
								}
								}
							System.out.println(getData);
								FileWriter writer = null;
								PrintWriter writer1;
							//	System.out.println(data2);
								try {
									writer1 = new PrintWriter(path);

									//writer1.print("");

									writer = new FileWriter(path, true);
									Writer write = new BufferedWriter(writer);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									for (int j = 0; j < getData.size()/2; j++) {
										writer.write(getData.get(j).toString() + "\n");
										System.out.println(getData.get(j));
									}
									writer.close();

								} catch (IOException e) {
									e.printStackTrace();
								}
							//	System.out.println("Report generated successfully");
							}
					

					}

				}

				public class Test5 extends Thread {
					public void run() {

						synchronized(this) {
							
							try {
								sleep(3000);
							} catch (InterruptedException e2) {
								e2.printStackTrace();
							}
							System.out.println("test5");
							ArrayList<Order> data = Methods.getOrderList();
							ArrayList<Order> getData = new ArrayList<>();
							System.out.println("path = "+path);
							try {
							FileWriter filewriter = new FileWriter(path, true);
							Writer rwrite = new BufferedWriter(filewriter);
							for (Order getLine : data) {
								if ((getLine.getStatus().equals("Delivered"))) {
									getData.add(getLine);
									//System.out.println(getLine);
									filewriter.write(getLine + "\n");
								}
								}
							System.out.println(getData);
								FileWriter writer = null;
								PrintWriter writer1;
								try {
									writer1 = new PrintWriter(path);

									//writer1.print("");

									writer = new FileWriter(path, true);
									Writer write = new BufferedWriter(writer);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								try {
									for (int j = getData.size()/2; j < getData.size(); j++) {
										writer.write(getData.get(j).toString() + "\n");
										System.out.println(getData.get(j));
									}
									writer.close();

								} catch (IOException e) {
									e.printStackTrace();
								}
								System.out.println("Report generated successfully");
							}catch(Exception e) {
								System.out.println("file not found");
							}
						}
					

					}
				}
					public class Test6 extends Thread {
						public void run() {

							synchronized(this) {
								System.out.println("test2");
								ArrayList<Order> data = Methods.getOrderList();
								ArrayList<Order> getData = new ArrayList<>();
								//String path = Methods.createFileStamp();
								System.out.println("path = "+path);
								for (Order getLine : data) {
									if ((getLine.getStatus().equals("Cancelled"))) {
										getData.add(getLine);
										//System.out.println(getLine);
										//filewriter.write(getLine + "\n");
									}
									}
								System.out.println(getData);
									FileWriter writer = null;
									PrintWriter writer1;
								//	System.out.println(data2);
									try {
										writer1 = new PrintWriter(path);

										//writer1.print("");

										writer = new FileWriter(path, true);
										Writer write = new BufferedWriter(writer);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try {
										for (int j = 0; j < getData.size()/2; j++) {
											writer.write(getData.get(j).toString() + "\n");
											System.out.println(getData.get(j));
										}
										writer.close();

									} catch (IOException e) {
										e.printStackTrace();
									}
								//	System.out.println("Report generated successfully");
								}
						

						}
					}
						public class Test7 extends Thread {
							public void run() {

								synchronized(this) {
									
									try {
										sleep(3000);
									} catch (InterruptedException e2) {
										e2.printStackTrace();
									}
									System.out.println("test2");
									ArrayList<Order> data = Methods.getOrderList();
									ArrayList<Order> getData = new ArrayList<>();
									System.out.println("path = "+path);
									try {
									FileWriter filewriter = new FileWriter(path, true);
									Writer rwrite = new BufferedWriter(filewriter);
									for (Order getLine : data) {
										if ((getLine.getStatus().equals("Cancelled"))) {
											getData.add(getLine);
											//System.out.println(getLine);
											filewriter.write(getLine + "\n");
										}
										}
									System.out.println(getData);
										FileWriter writer = null;
										PrintWriter writer1;
										try {
											writer1 = new PrintWriter(path);

											//writer1.print("");

											writer = new FileWriter(path, true);
											Writer write = new BufferedWriter(writer);
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											for (int j = getData.size()/2 ; j < getData.size(); j++) {
												writer.write(getData.get(j).toString() + "\n");
												System.out.println(getData.get(j));
											}
											writer.close();

										} catch (IOException e) {
											e.printStackTrace();
										}
										System.out.println("Report generated successfully");
									}catch(Exception e) {
										System.out.println("file not found");
									}
								}
							

							}

						}
					
				}
			
		
	
	


