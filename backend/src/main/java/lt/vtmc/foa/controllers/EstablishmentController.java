package lt.vtmc.foa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.foa.models.Establishment;
import lt.vtmc.foa.payload.requests.EstablishmentInsertRequest;
import lt.vtmc.foa.payload.requests.EstablishmentUpdateRequest;
import lt.vtmc.foa.payload.responses.EstablishmentResponse;
import lt.vtmc.foa.security.services.EstablishmentService;

@CrossOrigin
@RestController
@RequestMapping("/api/establishment")
public class EstablishmentController {

	private final EstablishmentService establishmentService;
	
	@Autowired
	public EstablishmentController(EstablishmentService establishmentService) {
		this.establishmentService = establishmentService;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstablishmentResponse insertEstablishment(@Valid @RequestBody EstablishmentInsertRequest establishmentInsertRequest) {
		return this.establishmentService.saveEstablishment(establishmentInsertRequest);
	}
	//(path = "/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstablishmentResponse updateEstablishment(@Valid @RequestBody EstablishmentUpdateRequest establishmentUpdateRequest, @PathVariable Long id) {
		return this.establishmentService.updateEstablishment(id, establishmentUpdateRequest);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstablishmentResponse deleteEstablishment(@PathVariable String id) {
		return this.establishmentService.deleteEstablishment(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Establishment>> getAllEstablishments() {
		return ResponseEntity.ok().body(this.establishmentService.getAllEstablishments());
	}

}
