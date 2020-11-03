package utils.enums;

public enum UserRoles {
	 ADMIN("admin"),
	 OFFICE_MANAGER("irodavezető"),
	 REGIONAL_REPRESENTATIVE("területi képviselő"),
	 WAREHOUSE_EMPLOYEE("operátor"),
	 VISITOR("látogató");
	
	   private String role;
	   
	   UserRoles(String role) {
	      this.role = role;
	   }
	   public String getRole() {
	      return this.role;
	   }
}
