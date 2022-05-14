package com.shuai.stat.controller;

import com.shuai.bus.domain.Customer;
import com.shuai.bus.domain.Rent;
import com.shuai.bus.service.CustomerService;
import com.shuai.bus.service.RentService;
import com.shuai.stat.utils.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("stat")
public class StatController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentService rentService;

    @RequestMapping("exportRent")
    public ResponseEntity<Object> exportRent(String rentid){
        Rent rent = rentService.queryRentByRentId(rentid);
        Customer customer = customerService.queryCustomerByIdentity(rent.getIdentity());
        String fileName = customer.getCustname()+"-的出租单.xls";
        String sheetName = customer.getCustname()+"出租单";
        ByteArrayOutputStream bos = ExportRentUtils.exportRent(rent, customer, sheetName);
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment",fileName);
            return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
