package lml;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source==null) {
            throw new RuntimeException("请输入要转换的日期");
        }

        DateFormat ormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            return ormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("转换失败");
        }
    }
}