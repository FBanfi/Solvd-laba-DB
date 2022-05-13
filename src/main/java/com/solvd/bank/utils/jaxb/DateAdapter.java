package com.solvd.bank.utils.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter {

    @Override
    public Object unmarshal(Object date) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").format(date);
    }

    @Override
    public Object marshal(Object date) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").parse((String) date);
    }
}
