package utils.enums;

public enum MeasuringUnit {
	 PIECE("darab"),
	 PACKAGE("csomag"),
	 PAIR("pár"),
	 TRAIL("rekesz"),
	 BOTTLE("üveg");
	
	   private String measuringUnit;
	   
	   MeasuringUnit(String measuringUnit) {
	      this.measuringUnit = measuringUnit;
	   }
	   public String getMeasuringUnit() {
	      return this.measuringUnit;
	   }
}
