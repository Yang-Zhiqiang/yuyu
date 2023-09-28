package yuyu.common.biz.bzwebserviceaccesslogoutput;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.infr.accesslog.YuyuAccessLogExtensionWSProp;
import yuyu.infr.accesslog.YuyuAccessLogWSProp;

/**
 * 業務共通 WEBサービスアクセスログ出力 クラス
 */
public class WebServiceAccesslogOutput {

    @Inject
    private static Logger logger;

    @SuppressWarnings("unchecked")
    public <T> void exec (C_AccessLogSyubetuKbn pLogKindCd,
        WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        T pGyoumuBean) {

        if(pLogKindCd != C_AccessLogSyubetuKbn.ACTION_BEGIN) {
            logger.warn(MessageUtil.getMessage(MessageId.EBA0013, C_AccessLogSyubetuKbn.ACTION_BEGIN.getContent()));
        }

        Map<String, String> gyoumuMap = analyze(pGyoumuBean);

        String[] iwsMethodArray = pWsBzWebserviceReqParamBean.getMethodName().replace("yuyu.app.", "").split("\\.");

        YuyuAccessLogWSProp.SyoriUserId.set(pWsBzWebserviceReqParamBean.getOperatorId());
        YuyuAccessLogWSProp.SubsystemId.set(iwsMethodArray[0]);
        YuyuAccessLogWSProp.CategoryId.set(iwsMethodArray[1]);
        YuyuAccessLogWSProp.KinouId.set(iwsMethodArray[2]);

        YuyuAccessLogExtensionWSProp.TanmatuType.set(pWsBzWebserviceReqParamBean.getCoopClass().substring(
            pWsBzWebserviceReqParamBean.getCoopClass().length() - 1));
        YuyuAccessLogExtensionWSProp.ButsuriSosikiCd.set("");
        YuyuAccessLogExtensionWSProp.RonriSosikiCd.set(pWsBzWebserviceReqParamBean.getOrgCode());
        YuyuAccessLogExtensionWSProp.TanmatuJyoutaiHyouji.set("");

        List<String> syousaiDataList = new ArrayList<String>();
        syousaiDataList.add(iwsMethodArray[3]);

        for (Map.Entry<String, String > entry : gyoumuMap.entrySet()) {

            syousaiDataList.add(entry.getKey().concat("=").concat(entry.getValue()));
        }

        AccessLog.ActionBegin.log(syousaiDataList);
    }

    private <T> HashMap<String,String> analyze(T pBean) {

        HashMap<String,String> map = null ;
        PropertyDescriptor     pd  = null ;

        if(pBean == null) {
            map = new HashMap<String, String>();
            return map;
        }

        try {

            Class<?> clazz = pBean.getClass();
            List<String> sList = getDDList(clazz);


            map = new HashMap<String, String>();

            for (String key : sList) {
                pd = new PropertyDescriptor(key,clazz);
                Method method = pd.getReadMethod();
                Object tValue = method.invoke(pBean);

                String value = null;

                if (tValue == null) {
                    value = "";
                } else {

                    if (tValue instanceof String ||
                        tValue instanceof Integer ||
                        tValue instanceof Long ||
                        tValue instanceof Double) {
                        value = String.valueOf(tValue);
                    } else {
                        value = tValue.toString();
                    }
                }
                map.put(key, value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    private List<String> getDDList(Class<?> pConvertedLayout) {

        List<String> convObjectDDList = new ArrayList<>();
        Class<?> superClass = null;
        Field[] fields = null;

        superClass = pConvertedLayout.getSuperclass();

        fields = superClass.getDeclaredFields();

        for (Field field : fields) {

            if(field.getName() != "serialVersionUID") {
                convObjectDDList.add(field.getName());
            }
        }

        return convObjectDDList;
    }

}
