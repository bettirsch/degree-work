package dto;

public class ImageDto extends BaseDto {

	private String imageName;
    
    private String note;
    
    private Boolean inactive;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	@Override
	public String toString() {
		return "ImageDto [imageName=" + imageName + ", note=" + note + ", inactive=" + inactive + "]";
	}
	
}
