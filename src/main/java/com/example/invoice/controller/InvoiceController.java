package com.example.invoice.controller;

import com.example.invoice.entity.Invoice;
import com.example.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Classname InvoiceController
 * @Description TODO
 * @Date 2022/3/16 17:48
 * @Author by fuxf
 */
@Slf4j
@RestController
@RequestMapping("query")
public class InvoiceController {

    @Resource
    private InvoiceService invoiceService;

    @PostMapping("invoice")
    public String queryModel(@RequestBody Invoice invoice) {
        Assert.notNull(invoice, "获取不到入参");
        final var byModel = invoiceService.findByModel(invoice);
        if (byModel.size() > 0) {
            LocalDateTime ldt = byModel.get(0).getCreateTime().toInstant()
                    .atZone( ZoneId.systemDefault() )
                    .toLocalDateTime();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
            String format = ldt.format(dtf);
            return "已登记("+format+")";
        } else {
            invoice.setCreateTime(new Date());
            int temp = invoiceService.insertModel(invoice);
            if (temp > 0) {
                return "未登记";
            }
        }
        return "数据库异常";

    }

   /* @Pagination
    public BaseResult list(){

    }*/

}
