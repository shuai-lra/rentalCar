package com.shuai.stat.controller;

import com.shuai.bus.domain.Customer;
import com.shuai.bus.domain.Rent;
import com.shuai.bus.service.CustomerService;
import com.shuai.bus.service.RentService;
import com.shuai.stat.domain.BaseEntity;
import com.shuai.stat.service.StatService;
import com.shuai.stat.utils.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("stat")
public class StatController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentService rentService;

    @Autowired
    private StatService statService;

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

    @RequestMapping("toCustomerAreaStat")
    public String toCustomerAreaStat(){
        return "stat/customerAreaStat";
    }

    @RequestMapping("loadCustomerAreaStatJson")
    @ResponseBody
    public List<BaseEntity> loadCustomerAreaStatJson(){
        return statService.loadCustomerAreaStatList();
    }

    @RequestMapping("toCompanyYearGradeStat")
    public String toCompanyYearGradeStat(){
        return "stat/companyYearGradeStat";
    }

    @RequestMapping("loadCompanyYearGradeStatJson")
    @ResponseBody
    public List<Double> loadCompanyYearGradeStatJson(String year){
        List<Double> entities = this.statService.loadCompanyYearGradeStatList(year);
        for (int i = 0; i < entities.size(); i++) {
            if (null==entities.get(i)){
                entities.set(i,0.0);
            }
        }
        return entities;
    }

    @RequestMapping("toOpernameYearGradeStat")
    public String toOpernameYearGradeStat(){
        return "stat/opernameYearGradeStat";
    }

    @RequestMapping("loadOpernameYearGradeStatJson")
    @ResponseBody
    public Map<String,Object> loadOpernameYearGradeStatJson(String year){
        List<BaseEntity> entities = this.statService.loadOpernameYearGradeStatList(year);
        Map<String,Object> map = new HashMap<String, Object>();
        List<String> names = new ArrayList<String>();
        List<Double> values = new ArrayList<Double>();
        for (BaseEntity baseEntity : entities) {
            names.add(baseEntity.getName());
            values.add(baseEntity.getValue());
        }
        map.put("name",names);
        map.put("value",values);
        return map;
    }

}
