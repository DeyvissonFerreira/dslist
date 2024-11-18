package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.validation.DifferentIndexes;

@DifferentIndexes(message = "sourceIndex e targetIndex não podem ter o mesmo valor.")
public class ReplacementDTO {
	
	private Integer sourceIndex;
	private Integer targetIndex;
	
	
	public Integer getSourceIndex() {
		return sourceIndex;
	}
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	public Integer getTargetIndex() {
		return targetIndex;
	}
	public void setTargetIndex(Integer targetIndex) {
		this.targetIndex = targetIndex;
	}
	
	

}
