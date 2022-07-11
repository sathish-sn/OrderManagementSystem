package com.order_management;

import java.io.Serializable;
import java.time.LocalDateTime;
class Order implements Serializable{
		private String orderID;
		private String orderDescription;
		private String deliveryAddress;
		private LocalDateTime orderDate;
		private Double Amount;
		private String deliveryDateTime;
		private String status;
		
	
		
		
		public String getOrderID() {
			return orderID;
		}
		
		public void setOrderID(String orderID) {
			this.orderID = orderID;
		}
		
		public String getOrderDescription() {
			return orderDescription;
		}
		
		public void setOrderDescription(String orderDescription) {
			this.orderDescription = orderDescription;
		}
		
		public String getDeliveryAddress() {
			return deliveryAddress;
		}
	
		public void setDeliveryAddress(String deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
		}
		
		public LocalDateTime getOrderDate() {
			return orderDate;
		}
		
		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}
	
		public Double getAmount() {
			return Amount;
		}
		
		public void setAmount(Double amount) {
			Amount = amount;
		}
	
		public String getDeliveryDateTime() {
			return deliveryDateTime;
		}
		
		public void setDeliveryDateTime(String localDateTime) {
			this.deliveryDateTime = localDateTime;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return orderID + "\t"  + orderDescription + "\t\t" + deliveryAddress + "\t" + orderDate + "\t\t\t" + Amount + "\t" + status + "\t" + deliveryDateTime ;
		}
//		public Order(String orderId, String orderDescription, String deliveryAddress, LocalDateTime orderDate,
//				double amount, LocalDateTime deliveryDatetime ,String status ) {
//			super();
//			this.orderID = orderId;
//			this.orderDescription = orderDescription;
//			this.deliveryAddress = deliveryAddress;
//			this.orderDate = orderDate;
//			this.Amount = amount;
//			this.status = status;
//			this.deliveryDateTime = deliveryDatetime;
//		}

		public Order(String orderId, String orderDescription, String deliveryAddress, LocalDateTime orderDate,
				double amount, String deliveryDatetime,String status) {
			super();
			this.orderID = orderId;
			this.orderDescription = orderDescription;
			this.deliveryAddress = deliveryAddress;
			this.orderDate = orderDate;
			this.Amount = amount;
			this.deliveryDateTime = deliveryDatetime;
			this.status = status;
			
			
		}
		
		
	}


