package lt.vtmc.foa.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vtmc.foa.models.Establishment;
import lt.vtmc.foa.payload.requests.EstablishmentInsertRequest;
import lt.vtmc.foa.payload.requests.EstablishmentUpdateRequest;
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
		establishment.setCode(establishmentRequest.getCode());
		establishment.setAddress(establishmentRequest.getAddress());
		establishmentRepository.save(establishment);
		return new EstablishmentResponse(
				establishment.getId(),
				establishment.getEstablishmentName(),
				establishment.getCode().toString(),
				establishment.getAddress());
		
	}

	public EstablishmentResponse deleteEstablishment(String id) {
		
		establishmentRepository.delete(establishmentRepository.getById(Long.valueOf(id)));
		
		return null;
	}
	public List<Establishment> getAllEstablishments() {
		return establishmentRepository.findAll();
	}

	public EstablishmentResponse updateEstablishment(Long id, EstablishmentUpdateRequest establishmentUpdateRequest) {
		Establishment updatingEstablishment = establishmentRepository.getById(id);
		//Establishment updatingEstablishment = establishmentRepository.getById(Long.valueOf(establishmentUpdateRequest.getEstablishmentId()));
		String establishmentName = establishmentUpdateRequest.getEstablishmentName();
        String updatingEstablishmentName = establishmentName.substring(0, 1).toUpperCase() + establishmentName.substring(1);
        updatingEstablishment.setEstablishmentName(updatingEstablishmentName);
        updatingEstablishment.setCode(establishmentUpdateRequest.getCode());
        updatingEstablishment.setAddress(establishmentUpdateRequest.getAddress());
        establishmentRepository.save(updatingEstablishment);
        return new EstablishmentResponse(
                updatingEstablishment.getId(),
                updatingEstablishmentName,
                establishmentUpdateRequest.getCode(),
                establishmentUpdateRequest.getAddress());
	}
}
