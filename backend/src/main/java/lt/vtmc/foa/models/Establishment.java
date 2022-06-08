package lt.vtmc.foa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="establishments")
public class Establishment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @NotBlank
    private String establishmentName;
    
    @NotNull
    private Long code;

    @NotBlank
    private String address;

	public Establishment() {

	}
	public Establishment(Long id, @NotBlank String establishmentName, @NotBlank Long code, @NotBlank String address) {
		super();
		Id = id;
		this.establishmentName = establishmentName;
		this.code = code;
		this.address = address;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEstablishmentName() {
		return establishmentName;
	}

	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}
