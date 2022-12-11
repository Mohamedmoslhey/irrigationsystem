package com.nsag.irrigationsystem.entity;

import java.util.Arrays;

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
@Table(name="land_plots")
public class LandPlots {
	// define fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="plot_number")
		private String plotNumber;
		
		@Column(name="size")
		private Double size;
		
		@Column(name="plot_status")
		private String plotStatus;
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="land_timeandwateramount_id")
		private LandTimeandwateramount landTimeandwateramount;
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="irrigation_sensor_id")
		private IrrigationSensor irrigationSensor;
			
		// define constructors
		
		public LandPlots() {
			
		}

		public LandPlots(String plotNumber, Double size) {
			this.plotNumber = plotNumber;
			this.size = size;
		}

		// define getter/setter
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPlotNumber() {
			return plotNumber;
		}

		public void setPlotNumber(String plotNumber) {
			this.plotNumber = plotNumber;
		}

		public Double getSize() {
			return size;
		}

		public void setSize(Double size) {
			this.size = size;
		}
		
		

		public LandTimeandwateramount getLandTimeandwateramount() {
			return landTimeandwateramount;
		}

		public void setLandTimeandwateramount(LandTimeandwateramount landTimeandwateramount) {
			this.landTimeandwateramount = landTimeandwateramount;
		}
		
		
		
		public IrrigationSensor getIrrigationSensor() {
			return irrigationSensor;
		}

		public void setIrrigationSensor(IrrigationSensor irrigationSensor) {
			this.irrigationSensor = irrigationSensor;
		}

		public String getPlotStatus() {
			return plotStatus;
		}

		public void setPlotStatus(String plotStatus) {
			this.plotStatus = plotStatus;
		}
		
		// define tostring
		
		@Override
		public String toString() {
			return "LandPlots [id=" + id + ", plotNumber=" + plotNumber + ", size=" + size + ", plotStatus="
					+ plotStatus + ", landTimeandwateramount=" + landTimeandwateramount
					+ ", irrigationSensor=" + irrigationSensor + "]";
		}
		
}
