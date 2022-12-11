package com.nsag.irrigationsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="irrigation_sensor")
public class IrrigationSensor {
	// define fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="sesnor_number")
		private String sensorNumber;
		
		@Column(name="size")
		private Double size;
		
		@Column(name="sensor_status")
		private int sensorStatus;
	
		
		
			
		// define constructors
		
		public IrrigationSensor() {
			
		}

		public IrrigationSensor(String sensorNumber,int sensorStatus,Double size) {
			this.sensorNumber = sensorNumber;
			this.sensorStatus = sensorStatus;
			this.size = size;
		}
		
		public IrrigationSensor(int sensorStatus) {
			this.sensorStatus = sensorStatus;
		}

		// define getter/setter
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSensorNumber() {
			return sensorNumber;
		}

		public void setSensorNumber(String sensorNumber) {
			this.sensorNumber = sensorNumber;
		}

		public Double getSize() {
			return size;
		}

		public void setSize(Double size) {
			this.size = size;
		}

		public int getSensorStatus() {
			return sensorStatus;
		}

		public void setSensorStatus(int sensorStatus) {
			this.sensorStatus = sensorStatus;
		}

		

		// define tostring
		
		
		@Override
		public String toString() {
			return "IrrigationSensor [id=" + id + ", sensorNumber=" + sensorNumber + ", size=" + size
					+ ", sensorStatus=" + sensorStatus + "]";
		}

		
		
		
		
		
}
