package com.example.Do_An_Java.repostories;

import com.example.Do_An_Java.entities.ItemInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemInvoiceRepository extends JpaRepository<ItemInvoice, Long> {
}
