package yuyu.common.workflowcore.core.iwfinfr.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.slcs.swak.date.BizDate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import yuyu.def.workflowcore.configration.IwfCoreConfig;


/**
 * 日付ユーティリティ<br/>
 */
public class IwfDateUtils  {

    private static final String SYSDATE_TIME_MILLI_FORMAT = "yyyyMMddHHmmssSSS";
    public static final SimpleDateFormat sdfSYSDATE_TIME_MILLI = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static final SimpleDateFormat sdfYYYYMMDD           = new SimpleDateFormat("yyyyMMdd");

    public static String getSysDate() {
        return BizDate.getSysDateTimeMilli();
    }

    public static String getYYYYMMDD() {
        return BizDate.getSysDateTimeMilli().substring(0,8);
    }

    public static synchronized Date getDateObject(String psDate) throws Exception {
        return sdfSYSDATE_TIME_MILLI.parse(psDate);
    }

    public static synchronized Date getDateYYYYMMDD(String psDate) throws Exception {
        return sdfYYYYMMDD.parse(psDate);
    }

    public static synchronized boolean checkDateYYYYMMDD(String psDate) throws Exception {


        DateFormat df = IwfDateUtils.sdfYYYYMMDD;
        String converted = null;
        try
        {

            Date convertedDate = df.parse(psDate);

            converted = df.format(convertedDate);

        } catch (ParseException ex) {
            return false;
        }


        return converted.equals(psDate);
    }

    public static synchronized boolean checkDate(String psDate) throws Exception {


        DateFormat df = IwfDateUtils.sdfSYSDATE_TIME_MILLI;
        String converted = null;
        try
        {

            Date convertedDate = df.parse(psDate);

            converted = df.format(convertedDate);

        } catch (ParseException ex) {
            return false;
        }


        return converted.equals(psDate);
    }

    public static synchronized boolean checkDateFromTo(String psTarget, String psFrom, String psTo) throws Exception {


        if (StringUtils.isNotEmpty(psFrom)) {
            if(getDateYYYYMMDD(psTarget).before(getDateYYYYMMDD(psFrom))) {
                return false;
            }
        }


        if (StringUtils.isNotEmpty(psTo)) {
            if(getDateYYYYMMDD(psTarget).after(getDateYYYYMMDD(psTo))) {
                return false;
            }
        }

        return true;
    }

    public static String getLockYuukouTime() {
        try {

            Date oSysDate = null;
            oSysDate = IwfDateUtils.getDateObject(IwfDateUtils.getSysDate());

            int lckValidTime =  IwfCoreConfig.getInstance().getLockValidTime() * -1;


            Date oLockDate = DateUtils.addMinutes(oSysDate, lckValidTime);


            SimpleDateFormat sdf = new SimpleDateFormat(SYSDATE_TIME_MILLI_FORMAT);
            return sdf.format(oLockDate);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
