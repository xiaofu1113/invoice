package com.example.invoice.service.impl;

import com.example.invoice.entity.Invoice;
import com.example.invoice.mapper.InvoiceMapper;
import com.example.invoice.model.InvoiceExample;
import com.example.invoice.service.InvoiceService;
import lombok.var;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname InvoiceServiceImpl
 * @Description TODO
 * @Date 2022/3/16 17:51
 * @Author by fuxf
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Resource
    private InvoiceMapper invoiceMapper;

    @Override
    public List<Invoice> findByModel(Invoice invoice) {
        InvoiceExample temp = new InvoiceExample();
        final var criteria = temp.createCriteria();
        criteria.andInvoiceCodeEqualTo(invoice.getInvoiceCode());
        criteria.andInvoiceNoEqualTo(invoice.getInvoiceNo());
        criteria.andInvoiceAmountEqualTo(invoice.getInvoiceAmount());
        return invoiceMapper.selectByExample(temp);
    }


    @Override
    public int insertModel(Invoice invoice) {
        return invoiceMapper.insertSelective(invoice);
    }
}
