package com.example.invoice.service;

import com.example.invoice.entity.Invoice;

import java.util.List;

/**
 * @Classname invoiceService
 * @Description TODO
 * @Date 2022/3/16 17:50
 * @Author by fuxf
 */

public interface InvoiceService {

    /**
     * @param invoice
     * @return
     */
    List<Invoice> findByModel(Invoice invoice);

    int insertModel(Invoice invoice);
}
