package com.lk.app.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jaxb工具日期格式化
 *
 * @author LK
 */
public class JaxbDateFormatter {

    public static class MillisecondDateFormatter extends XmlAdapter<String, Date> {

        @Override
        public Date unmarshal(String v) throws Exception {
            if (v == null || "".equals(v)) {
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm.SSS 'CST' ");
            return sdf.parse(v);
        }

        @Override
        public String marshal(Date v) throws Exception {
            if (v == null) {
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm.SSS 'CST' ");
            return sdf.format(v);
        }
    }

    public static class YearDateFormatter extends XmlAdapter<String, Date> {

        @Override
        public Date unmarshal(String v) throws Exception {
            if (v == null || "".equals(v)) {
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(v);
        }

        @Override
        public String marshal(Date v) throws Exception {
            if (v == null) {
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(v);
        }
    }
}
