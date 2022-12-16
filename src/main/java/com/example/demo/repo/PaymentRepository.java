package com.example.demo.repo;

import com.example.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Modifying
    @Query(value = "INSERT INTO payment (username, batch, payment_for_month) VALUES(?1, ?2, ?3)",
            nativeQuery = true)
    @Transactional
    void addPayment(String username, String batch, String paymentForMonth);
}
