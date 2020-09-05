package com.capg.pbms.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.pbms.transaction.model.Cheque;
import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.repo.TransactionRepo;
import com.capg.pbms.transaction.service.ITransactionService;
import com.capg.pbms.transaction.service.TransactionService;

@SpringBootTest(classes = TransactionServiceTest.class)
class TransactionServiceTest {
	
	@Autowired
	static ITransactionService service;
	static Transaction trans;
	static Cheque cheque;

	@BeforeEach
	void setUp() {
		service=new TransactionService();
		cheque =new Cheque(1234567, 50000, 3000, LocalDateTime.now(), 53000);
		trans = new Transaction(1111111, 123456789012l, 50000, 2000, LocalDateTime.now(), 52000, cheque);
	}
	@Test
	void testDebitUsingSlip(){
		Transaction transaction=new Transaction(1111111, 123456789012l, 50000, 2000, LocalDateTime.now(), 52000, cheque);
		assertEquals(trans,transaction);
		
	}
	@Test
	void testCreditUsingSlip(){
		Transaction transaction=new Transaction(111111, 123456789012l, 50000, 2000, LocalDateTime.now(), 52000, cheque);
		assertNotEquals(trans,transaction);
		
	}
	@Test
	void testDebitUsingCheque() {
		Cheque cheque1=new Cheque(1234567, 50000, 3000, LocalDateTime.now(), 53000);
		assertNotEquals(cheque, cheque1);
	}
	

	}
