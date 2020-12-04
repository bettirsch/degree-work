package dto;

import java.util.List;

public class FormDto{
	
	private FormHeadReadDto formHeadDto;
	
	private List<FormItemReadDto> formItemDtos;

	public FormDto(FormHeadReadDto formHeadDto, List<FormItemReadDto> formItemDtos) {
		super();
		this.formHeadDto = formHeadDto;
		this.formItemDtos = formItemDtos;
	}

	public FormHeadReadDto getFormHeadDto() {
		return formHeadDto;
	}

	public void setFormHeadDto(FormHeadReadDto formHeadDto) {
		this.formHeadDto = formHeadDto;
	}

	public List<FormItemReadDto> getFormItemDtos() {
		return formItemDtos;
	}

	public void setFormItemDtos(List<FormItemReadDto> formItemDtos) {
		this.formItemDtos = formItemDtos;
	}

}
