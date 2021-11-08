package com.mayank.loan.controller;

import com.mayank.loan.entity.Loan;
import com.mayank.loan.exception.ResourceNotFoundException;
import com.mayank.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class LoanController {
	@Autowired
	private LoanRepository loanRepository;

	@GetMapping("/loan")
	public List<Loan> getAllLoan() {
		return loanRepository.findAll();
	}

	@GetMapping("/loan/{product_id}")
	public ResponseEntity<Loan> getProductById(@PathVariable(value = "product_id") int product_id)
			throws ResourceNotFoundException {
		Loan loan = loanRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for the id :- " + product_id));
		return ResponseEntity.ok().body(loan);
	}

	@PostMapping("/loan")
	public Loan createLoan(@RequestBody Loan loan) {
		loan.setCreatedOn();
		loan.setUpdatedOn();
		return loanRepository.save(loan);
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/loan/getemi/{product_id}")
	public int getMul(@PathVariable(value = "product_id") int product_id) throws ResourceNotFoundException {
		Loan loan = loanRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for the id :- " + product_id));

		double r = (loan.getRate() / 1200);
		double emi;
		emi = loan.getPrincipal_amount() * r * (Math.pow(1 + r, loan.getTenure()))
				/ (Math.pow(1 + r, loan.getTenure()) - 1);
		return (int) Math.round(emi);

	}

	@DeleteMapping("/loan/{product_id}")
	public Map<String, Boolean> deleteLoan(@PathVariable(value = "product_id") int product_id)
			throws ResourceNotFoundException {
		Loan loan = loanRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for the id :- " + product_id));

		loanRepository.delete(loan);
		Map<String, Boolean> response = new HashMap();
		response.put("deleted", true);
		return response;
	}

	@PutMapping("/loan/{product_id}")
	public ResponseEntity<Loan> updateLoan(@PathVariable(value = "product_id") int product_id,
			@RequestBody Loan loanDetails) throws ResourceNotFoundException {
		Loan loan = loanRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for the id :- " + product_id));

		loan.setProduct_name(loanDetails.getProduct_name());
		loan.setPrincipal_amount(loanDetails.getPrincipal_amount());
		loan.setTenure(loanDetails.getTenure());
		loan.setRate(loanDetails.getRate());
		loan.setActive(loanDetails.isActive());
		loan.setUpdatedBy(loanDetails.getUpdatedBy());
		loan.setUpdatedOn();

		final Loan updatedLoan = loanRepository.save(loan);
		return ResponseEntity.ok(updatedLoan);
	}

}
