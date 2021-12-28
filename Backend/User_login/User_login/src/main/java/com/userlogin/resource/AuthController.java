package com.userlogin.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userlogin.model.AuthenticationRequest;
import com.userlogin.model.AuthenticationResponse;
import com.userlogin.model.Booking;
import com.userlogin.model.Train;
import com.userlogin.model.UserModel;
import com.userlogin.repository.UserRepository;
import com.userlogin.service.UserService;
import com.userlogin.utils.JwtUtils;

@RestController
@CrossOrigin("http://localhost:3000")
public class AuthController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	AuthenticationManager authenticates;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	JwtUtils jwtutil;
	
	@PostMapping("/subs")
	private ResponseEntity<AuthenticationResponse>subscribeClient(@RequestBody AuthenticationRequest authreq){
		UserModel usermodel =new UserModel();
//		UserModel oldusermodel=new UserModel();
//		oldusermodel=userrepo.findByusername(authreq.getUsername());
//		try {
//			
//			if (oldusermodel.getUsername() == authreq.getUsername()) {
//				throw new Exception("Username already present");
//			}
//					
//		}
//		catch(Exception e) {
//			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
//					("Username must be unique ") , HttpStatus.OK);
//		}
		
		usermodel.setUsername(authreq.getUsername());
		usermodel.setPassword(authreq.getPassword());
		
		
		try {
			userrepo.save(usermodel);
		}
		catch(Exception e){
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
					("Error during subscription ") , HttpStatus.OK);
		}
		
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
				("Successful subs for client " +authreq.getUsername()), HttpStatus.OK);
//		return ResponseEntity.ok(new AuthenticationResponse());
	}
	
	
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authreq){
		String username=authreq.getUsername();
		String password= authreq.getPassword();
		try {
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				
		}
		catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse(" Invalid Credentials..!"));
		}
		
		UserDetails userdetails= userservice.loadUserByUsername(username);
		
		String jwt = jwtutil.generateToken(userdetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping("/test")
	private String testingtoken() {
		try {
			return "Testing Successful...!";	
		}
		catch(Exception e) {
			return "Please login first..!";
		}
	}
	
	@GetMapping("/dashboard")
	private String dashboard() {
		return "Welcome to dashboard...!";
	}
	
	@GetMapping("/alltrains")
	public List<Train> getAllTrains(){
		String baseurl="http://localhost:9002/trains/findAll";
		Train[] train=restTemplate.getForObject(baseurl, Train[].class);
		
		return Arrays.asList(train);
	}
	
/*	@PostMapping("/bookTrain")
	public Booking bookTrain() {
		String baseurl="http://localhost:9003/trains/add";
		Booking booking=restTemplate.getForObject(baseurl, Booking.class);
		return booking;*/

}