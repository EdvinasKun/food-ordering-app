package lt.vtmc.foa.payload.responses;


public class EstablishmentResponse {


    private String establishmentId;
    

    private String establishmentName;


    private Long code;

    public EstablishmentResponse() {

	}
    
    public EstablishmentResponse(String establishmentId, String establishmentName, Long code, String address) {
		super();
		this.establishmentId = establishmentId;
		this.establishmentName = establishmentName;
		this.code = code;
		this.address = address;
	}


	public String getEstablishmentId() {
		return establishmentId;
	}


	public String getEstablishmentName() {
		return establishmentName;
	}


	public Long getCode() {
		return code;
	}


	public String getAddress() {
		return address;
	}


	public void setEstablishmentId(String establishmentId) {
		this.establishmentId = establishmentId;
	}


	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	private String address;
}
