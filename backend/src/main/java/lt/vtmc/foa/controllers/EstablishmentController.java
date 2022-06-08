package lt.vtmc.foa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.foa.models.Establishment;
import lt.vtmc.foa.payload.requests.EstablishmentInsertRequest;
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
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstablishmentResponse insertEstablishment(@RequestBody EstablishmentInsertRequest establishmentInsertRequest) {
		return this.establishmentService.saveEstablishment(establishmentInsertRequest);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstablishmentResponse deleteEstablishment(@PathVariable String id) {
		return this.establishmentService.deleteEstablishment(id);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Establishment>> getAllIncomeByUserId() {
		return ResponseEntity.ok().body(this.establishmentService.getAllEstablishments());
	}
}
