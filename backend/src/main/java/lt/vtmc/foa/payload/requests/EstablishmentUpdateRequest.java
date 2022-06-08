package lt.vtmc.foa.payload.requests;

import javax.validation.constraints.NotBlank;

public class EstablishmentUpdateRequest {

    @NotBlank
    private String establishmentId;
    
    @NotBlank
    private String establishmentName;

    @NotBlank
    private String code;

    @NotBlank
    private String address;

	public String getEstablishmentId() {
		return establishmentId;
	}

	public String getEstablishmentName() {
		return establishmentName;
	}

	public String getCode() {
		return code;
	}

	public String getAddress() {
		return address;
	}
    
    
}
