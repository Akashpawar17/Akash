package com.capg.pbms.transaction.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.service.TransactionService;

/**
 * The TransactionController class implements for accessing Transaction
 * Management System services
 *
 * @author :P.AkashPawar
 * @since :2020-08-18
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/transaction")
public class TransactionController {
	// Tells the application context to inject an instance of TransactionService
	
	@Autowired
	TransactionService service;

	@PostMapping("/debitwithslip/{accNumber}/amount/{amount}")
	public Transaction debitUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InsufficienBalanceException, AccountNotFoundException {

		return service.debitUsingSlip(accNumber, amount, transaction);
	}

	@PostMapping("/creditwithslip/{accNumber}/amount/{amount}")
	public Transaction creditUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InsufficienBalanceException, AccountNotFoundException {
		return service.creditUsingSlip(accNumber, amount, transaction);
	}

	@PostMapping("/creditwithcheque/{accNumber}/amount/{amount}")
	public Transaction creditUsingCheque(@PathVariable("accNumber") long accNumber,
			@PathVariable("amount") double amount, @RequestBody Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException, ChequeBounceException {
		return service.creditUsingCheque(accNumber, amount, transaction);
	}

	@PostMapping("/debitwithcheque/{accNumber}/amount/{amount}")
	public Transaction debitUsingCheque(@PathVariable("accNumber") long accNumber,
			@PathVariable("amount") double amount, @RequestBody Transaction transaction)
			throws InsufficienBalanceException, ChequeBounceException, AccountNotFoundException {
		return service.debitUsingCheque(accNumber, amount, transaction);
	}

	@GetMapping("/getAll")
	public List<Transaction> getAllTrans() {
		return service.getAllTrans();
	}
}
