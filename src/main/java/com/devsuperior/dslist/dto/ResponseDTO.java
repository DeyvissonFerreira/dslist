package com.devsuperior.dslist.dto;


public class ResponseDTO {

    private String field;
    private String message;
    
    public ResponseDTO() {}
    
    public ResponseDTO(String field, String error) {
		this.field = field;
		this.message = error;
	}



	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return message;
	}

	public void setError(String error) {
		this.message = error;
	}
    
    

}