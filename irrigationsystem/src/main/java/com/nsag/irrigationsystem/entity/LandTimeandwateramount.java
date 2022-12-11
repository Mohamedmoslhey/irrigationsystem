package com.nsag.irrigationsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="land_timeandwateramount")
public class LandTimeandwateramount {
	// define fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
			
		@Column(name="size")
		private Double size;
		
		@Column(name="time_slot")
		private String timeSlot;
		
		@Column(name="water_amount")
		private Double waterAmount;
			
		// define constructors
		
		public LandTimeandwateramount() {
			
		}

		public LandTimeandwateramount(Double size,String timeSlot,Double waterAmount) {
			this.size = size;
			this.timeSlot = timeSlot;
			this.waterAmount = waterAmount;
		}

		// define getter/setter
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
		public Double getSize() {
			return size;
		}

		public void setSize(Double size) {
			this.size = size;
		}

		public String getTimeSlot() {
			return timeSlot;
		}

		public void setTimeSlot(String timeSlot) {
			this.timeSlot = timeSlot;
		}

		public Double getWaterAmount() {
			return waterAmount;
		}

		public void setWaterAmount(Double waterAmount) {
			this.waterAmount = waterAmount;
		}
		// define tostring

		@Override
		public String toString() {
			return "LandTimeandwateramount [id=" + id + ", size=" + size + ", timeSlot=" + timeSlot + ", waterAmount="
					+ waterAmount + "]";
		}
		
		
}
