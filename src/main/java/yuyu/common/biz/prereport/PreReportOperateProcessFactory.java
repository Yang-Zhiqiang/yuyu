package yuyu.common.biz.prereport;

import java.util.Map;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.MessageId;

import com.google.common.collect.Maps;

public class PreReportOperateProcessFactory {

    private static Map<String, String> preReportMap = getPreReportMap();

    private static Map<String,String> getPreReportMap(){

        Map<String,String> map = Maps.newConcurrentMap();
        map.put("sinkeiyaku", "yuyu.common.sinkeiyaku.prereport.SinkeiyakuPreReportOperateProcess");
        map.put("hozen"     , "yuyu.common.hozen.prereport.HozenPreReportOperateProcess");
        map.put("siharai"   , "yuyu.common.siharai.prereport.SiharaiPreReportOperateProcess");
        map.put("nenkin"    , "yuyu.common.nenkin.prereport.NenkinPreReportOperateProcess");

        return map;
    }

    public PreReportOperateProcess getOperator(String pSubsystemId){

        if (preReportMap.containsKey(pSubsystemId) == false) {

            throw new BizAppException(MessageId.EBA0023, "サブシステムID:" + pSubsystemId );
        }

        return getInstance(preReportMap.get(pSubsystemId));
    }

    private PreReportOperateProcess getInstance(String pPackage) {

        try {
            return (PreReportOperateProcess)SWAKInjector.getInstance(Class.forName(pPackage));

        } catch (ClassNotFoundException e) {
            throw new BizAppException(e, MessageId.EBF0011);
        }
    }
}
