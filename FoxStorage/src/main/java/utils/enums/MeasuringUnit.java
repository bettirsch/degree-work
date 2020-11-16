package utils.enums;

public enum MeasuringUnit {
	 PIECE("db"),
	 PACKAGE("csg"),
	 PAIR("pár");
	
	   private String measuringUnit;
	   
	   MeasuringUnit(String measuringUnit) {
	      this.measuringUnit = measuringUnit;
	   }
	   public String getMeasuringUnit() {
	      return this.measuringUnit;
	   }
}
