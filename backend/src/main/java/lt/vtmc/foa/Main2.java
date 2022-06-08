package lt.vtmc.foa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import lt.vtmc.foa.models.ERole;
import lt.vtmc.foa.models.Role;
import lt.vtmc.foa.models.User;
import lt.vtmc.foa.payload.requests.SignupRequest;
import lt.vtmc.foa.repositories.RoleRepository;
import lt.vtmc.foa.repositories.UserRepository;

public class Main2 {

//	@Bean
//	public CommandLineRunner initialData(RoleRepository roleRepo, UserRepository userRepo, SignupRequest signUpRequest) {
//		return args -> {
//	
//			if(roleRepo.findByName(ERole.ROLE_USER).isEmpty()){
//				roleRepo.save(new Role(ERole.ROLE_USER));
//			}
//			if(userRepo.findByUsername("admin").isEmpty()) {
//				 User user = new User(signUpRequest.getUsername(),
//	                     signUpRequest.getEmail(),
//	                     encoder.encode(signUpRequest.getPassword()));
//			}
//
//		};
//	}
}
