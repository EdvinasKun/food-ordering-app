package lt.vtmc.foa.security.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lt.vtmc.foa.models.Establishment;
import lt.vtmc.foa.payload.requests.EstablishmentInsertRequest;
import lt.vtmc.foa.payload.responses.EstablishmentResponse;
import lt.vtmc.foa.repositories.EstablishmentRepository;

@Service
public class EstablishmentService {

	private final EstablishmentRepository establishmentRepository;
	
	@Autowired
	public EstablishmentService(EstablishmentRepository establishmentRepository) {
		this.establishmentRepository = establishmentRepository;
	}
	
	public EstablishmentResponse saveEstablishment(EstablishmentInsertRequest establishmentRequest) {
		
		
		//String establishmentName = establishmentRequest.getEstablishmentName();
		Establishment establishment = new Establishment(
				//establishmentName.substring(0, 1).toUpperCase() + establishmentName.substring(1), 
			
				);
		
		establishment.setEstablishmentName(establishmentRequest.getEstablishmentName());
		establishment.setCode(Long.parseLong(establishmentRequest.getCode()));
		establishment.setAddress(establishmentRequest.getAddress());
		establishmentRepository.save(establishment);
		return new EstablishmentResponse(
				establishment.getId().toString(),
				establishment.getEstablishmentName(),
				establishment.getCode().toString(),
				establishment.getAddress());
		
	}

	public EstablishmentResponse deleteEstablishment(String id) {
		
		establishmentRepository.delete(establishmentRepository.getById(Long.valueOf(id)));
		
		return null;
	}
}
