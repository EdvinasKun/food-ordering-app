package lt.vtmc.foa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Menu {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    
    @NotBlank
    private String menuName;
    
    @ManyToOne
    @JoinColumn(name = "establishments_id")

    private Establishment establishment;
    
    //api/establishments/{id}/menus
    
}
