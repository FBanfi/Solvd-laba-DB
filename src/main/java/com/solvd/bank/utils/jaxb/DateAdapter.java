package com.solvd.bank.utils.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String string) throws Exception {
        return new SimpleDateFormat("dd/MM/yyyy").parse(string);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
