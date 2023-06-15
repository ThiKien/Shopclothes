package com.example.Do_An_Java.repostories;

import com.example.Do_An_Java.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long>{
}