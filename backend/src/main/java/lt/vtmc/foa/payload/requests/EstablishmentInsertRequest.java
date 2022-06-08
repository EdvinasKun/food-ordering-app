package lt.vtmc.foa.payload.requests;

import javax.validation.constraints.NotBlank;

public class EstablishmentInsertRequest {

	
    @NotBlank
    private String establishmentName;

    @NotBlank
    private String code;

    @NotBlank
    private String address;

	@Override
	public String toString() {
		return "EstablishmentInsertRequest [establishmentName=" + establishmentName + ", code=" + code + ", address="
				+ address + "]";
	}

	public String getEstablishmentName() {
		return establishmentName;
	}

	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
    
    
}
