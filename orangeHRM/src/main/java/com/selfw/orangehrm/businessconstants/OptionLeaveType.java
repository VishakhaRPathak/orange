package com.selfw.orangehrm.businessconstants;

public enum OptionLeaveType {

	CANBEREAVEMENT("CAN - Bereavement"),
	CANMATTERNITY("CAN - Matternity"),
	CANPERSONAL("CAN - Personal"),
	CANVACATION("CAN - Vacation"),
	CANFMLA("CAN - FMLA"),
	CASUALLEAVE("Casual Leave"),
	USBEREAVEMENT("US - Bereavement"),
	USMATTERNITY("US - Matternity"),
	USPERSONAL("US - Personal"),
	USVACATION("US - Vacation"),
	USFMLA("US - FMLA");
	
	private final String option;
	
	OptionLeaveType(String option) {
		this.option = option;
	}
	public String option() {
		return option;
	}
}
