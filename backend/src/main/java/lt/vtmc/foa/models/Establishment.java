package lt.vtmc.foa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="establishments")
public class Establishment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    private String establishmentName;
    
    @NotBlank
    private String code;

    @NotBlank
    private String address;
    
    
//    @OneToMany(
//    	mappedBy = "establishment")
//    
//    private List<Menu> menus;

	public Establishment() {

	}
	public Establishment(Long id, @NotBlank String establishmentName, @NotBlank String code, @NotBlank String address) {
		super();
		this.id = id;
		this.establishmentName = establishmentName;
		this.code = code;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
