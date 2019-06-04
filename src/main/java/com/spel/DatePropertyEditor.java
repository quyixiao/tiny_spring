package com.spel;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

    private String formate = "yyyy-MM-dd";

    public void setFormate(String formate){
        this.formate = formate;
    }


    @Override
    public void setAsText(String args0) throws IllegalStateException{
        System.out.println("args0=" + args0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);
        try {
            Date d  =  simpleDateFormat.parse(args0);
            this.setValue(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
