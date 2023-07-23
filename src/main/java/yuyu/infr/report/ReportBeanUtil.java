package yuyu.infr.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;


/**
 * 帳票サービスBeanを操作するためのユーティリティクラスです。
 */
public class ReportBeanUtil {

    private static final String KEY_IMAGE_MAP      = "key_imagemap";
    private static final String KEY_PARAMOBJCT_MAP = "key_pomap";
    private static final String KEY_DATASORCE_MAP  = "key_dsmap";

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static HashMap convBean2Map(ReportServicesBean pBean) {

        try{
            ReportSerializableBean serializableBean = new ReportSerializableBean(pBean);
            HashMap beanMap = (HashMap) BeanUtils.describe(serializableBean);

            beanMap.put(KEY_IMAGE_MAP, pBean.getImageFileNameData());
            Map<String, Object[]> paramObjectsData = pBean.getParamObjectsData();

            if(paramObjectsData != null){
                HashMap poMap = new HashMap<String, List<Map>>();
                Set<String> poKeySet = paramObjectsData.keySet();

                Iterator<String> poItr = poKeySet.iterator();

                while(poItr.hasNext()){
                    String poKey = poItr.next();
                    Object[] objs = paramObjectsData.get(poKey);
                    List<Map> list = new ArrayList<Map>();

                    for(int i = 0; i < objs.length; i++){
                        if(objs[i] != null){
                            if(objs[i] instanceof Map){
                                Map map = (Map)objs[i];
                                map.put("class", Map.class.getName());
                                list.add(map);
                            }
                            else{

                                list.add(BeanUtils.describe(objs[i]));
                            }
                        }
                    }
                    poMap.put(poKey, list);
                }
                beanMap.put(KEY_PARAMOBJCT_MAP, poMap);
            }

            Map<String, List<IReportDataSouceBean>> dataSouceMap = pBean.getBeanDataSouceData();
            if(dataSouceMap != null){

                HashMap dsHashMap = new HashMap<String, List<Map>>();
                Set<String> dsKeySet = dataSouceMap.keySet();
                Iterator<String> dsItr = dsKeySet.iterator();

                while(dsItr.hasNext()){

                    String dsKey = dsItr.next();
                    List<IReportDataSouceBean> dsList = dataSouceMap.get(dsKey);
                    if(dsList != null){

                        List<Map> mapList = new ArrayList<Map>();

                        for(int i = 0; i < dsList.size(); i++){

                            if(dsList.get(i) != null){

                                mapList.add(BeanUtils.describe(dsList.get(i)));
                            }
                        }
                        dsHashMap.put(dsKey, mapList);
                    }
                }
                beanMap.put(KEY_DATASORCE_MAP, dsHashMap);
            }
            return beanMap;
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0012");
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static ReportServicesBean convMap2Bean(Map pMap) {

        try{
            ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
            ReportSerializableBean serializableBean = new ReportSerializableBean();
            BeanUtils.populate(serializableBean, pMap);

            ReportServicesBean serviceBean = serializableBean.generateOriginalBean();
            HashMap imageMap = (HashMap)pMap.get(KEY_IMAGE_MAP);

            if(imageMap != null && imageMap.size() > 0){

                Set<String> imageKeySet = imageMap.keySet();

                Iterator<String> imageItr = imageKeySet.iterator();

                while(imageItr.hasNext()){

                    String imageKey = imageItr.next();

                    List<String> imageList = (List<String>)imageMap.get(imageKey);

                    for(int i = 0; i < imageList.size(); i++){

                        String path = imageList.get(i);

                        serviceBean.addImageFileName(path, C_SyoruiCdKbn.valueOf(imageKey));
                    }
                }
            }

            HashMap poMap = (HashMap)pMap.get(KEY_PARAMOBJCT_MAP);
            HashMap dsMap = (HashMap)pMap.get(KEY_DATASORCE_MAP);

            if(poMap != null && poMap.size() > 0){
                Set<String> poKeySet = poMap.keySet();
                Iterator<String> poIt = poKeySet.iterator();

                while(poIt.hasNext()){
                    String sKey = poIt.next();
                    List<Map> oList = (List<Map>)poMap.get(sKey);
                    Object[] objs = new Object[oList.size()];
                    for(int i = 0; i<oList.size(); i++){
                        String sClsName = (String)oList.get(i).get("class");
                        if(Map.class.getName().equals(sClsName)){
                            objs[i] = oList.get(i);
                        }
                        else{
                            Class poCls = Class.forName(sClsName.substring(6));
                            objs[i] = poCls.newInstance();
                            BeanUtils.populate(objs[i], oList.get(i));
                        }
                    }
                    List<IReportDataSouceBean> otList = null;
                    if(dsMap != null && dsMap.size() > 0){
                        List<Map> inList = (List<Map>)dsMap.get(sKey);
                        if(inList != null && inList.size() > 0){
                            otList = new ArrayList<IReportDataSouceBean>();
                            Class dsCls = Class.forName(((String)inList.get(0).get("class")).substring(6));
                            for(int i = 0; i<inList.size(); i++){
                                IReportDataSouceBean dsBean = (IReportDataSouceBean)dsCls.newInstance();
                                BeanUtils.populate(dsBean, inList.get(i));
                                otList.add(dsBean);
                            }
                        }
                    }
                    serviceBean.addParamObjects(objs, otList, sKey);
                }
            }
            return serviceBean;
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0013");
        }
    }
}
