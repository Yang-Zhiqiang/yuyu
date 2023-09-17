package yuyu.def.biz.result.impl;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.core.exception.ExIllegalArgumentException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.CloseableExDBEntityManager;
import jp.co.slcs.swak.db.ExDBFactory;
import jp.co.slcs.swak.db.ExDBResultsFilter;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;

import org.apache.commons.beanutils.PropertyUtils;

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.meta.QBT_SkipKey;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * リカバリフィルタクラス<br />
 */
public class ExDBSkippedResultsFilter implements ExDBResultsFilter {

    private List<List<Method>> methodList = null;

    private  Map<List<String>, BT_SkipKey> filterDataMap = null;

    private BM_RecoveryFilter recoveryFilter = null;

    private String filterTableId;

    private List<String> filterDataKeyList = Lists.newArrayList();

    private boolean isFirstKeyFlg = true;

    public ExDBSkippedResultsFilter(String pKakutyoujobcd){
        List<BT_SkipKey> list ;
        try( CloseableExDBEntityManager em = SWAKInjector.getInstance(ExDBFactory.class).createExDBEntityManager()){
            QBT_SkipKey qSkipKey = new QBT_SkipKey("qSkipKey");
            String jpql = $SELECT +  qSkipKey + $FROM(qSkipKey) + $WHERE + qSkipKey.kakutyoujobcd.eq(pKakutyoujobcd);
            list = em.createJPQL(jpql).bind(qSkipKey).getResultList();
            if(list.size() == 0){
                return ;
            }
            recoveryFilter = list.get(0).getRecoveryFilter();
            if(recoveryFilter == null){
                throw new ExIllegalArgumentException("フィルタID[" + list.get(0).getRecoveryfilterid()+ "]スキップフィルタマスタの定義情報が存在しません！");
            }
        }

        filterDataMap =  Maps.newHashMap();
        for(BT_SkipKey skipKey : list){
            List<String> keyList = Lists.newArrayList();
            getFilterDataMap(keyList,recoveryFilter.getRecoveryfilterkeykmid1(),skipKey.getRecoveryfilterkey1());
            getFilterDataMap(keyList,recoveryFilter.getRecoveryfilterkeykmid2(),skipKey.getRecoveryfilterkey2());
            getFilterDataMap(keyList,recoveryFilter.getRecoveryfilterkeykmid3(),skipKey.getRecoveryfilterkey3());
            getFilterDataMap(keyList,recoveryFilter.getRecoveryfilterkeykmid4(),skipKey.getRecoveryfilterkey4());
            getFilterDataMap(keyList,recoveryFilter.getRecoveryfilterkeykmid5(),skipKey.getRecoveryfilterkey5());

            filterTableId = skipKey.getTableid();
            isFirstKeyFlg = false;
            filterDataMap.put(keyList, skipKey);
        }
    }

    private void getFilterDataMap(List<String> keyList,String pFilterkmId,String pFilterKey){
        if(!Strings.isNullOrEmpty(pFilterkmId)){
            keyList.add(pFilterKey);
            if(isFirstKeyFlg){
                filterDataKeyList.add(null);
            }
        }
    }

    @Override
    public <T> boolean match(T bean) {
        if(filterDataMap == null || filterDataKeyList.size() == 0){
            return false;
        }

        if(bean == null ){
            return filterDataMap.containsKey(filterDataKeyList);
        }

        if(methodList == null){
            if(getReadMethodMap(bean) == null){
                return filterDataMap.containsKey(filterDataKeyList);
            }
        }

        List<Object> dataKey = Lists.newArrayList();
        for(List<Method> tmpMethodList:methodList){
            try {
                Object obj = null;
                if(tmpMethodList.size() > 1){
                    Object tmpObj = tmpMethodList.get(0).invoke(bean);
                    if(tmpObj != null) {
                        obj = tmpMethodList.get(1).invoke(tmpObj);
                    }
                }else{
                    obj = tmpMethodList.get(0).invoke(bean);
                }
                if(obj != null){
                    dataKey.add(obj.toString());
                }else{
                    dataKey.add(obj);
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return filterDataMap.containsKey(dataKey);
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private <T> List<List<Method>> getReadMethodMap(T bean){
        Object tmpTarget = null;
        if(bean instanceof ExDBEntity){
            if(!filterTableId.equals(bean.getClass().getSimpleName())){
                throw new ExIllegalArgumentException("対象データが[" + filterTableId+ "]の型ではありません！");
            }
            tmpTarget = bean;
        }

        Method readEntityMethod = null ;
        Map tempMethodMap = Maps.newHashMap();
        try {
            for (PropertyDescriptor prop : PropertyUtils.getPropertyDescriptors(bean)){
                if(filterTableId.equals(prop.getPropertyType().getSimpleName())){
                    readEntityMethod = prop.getReadMethod();
                    tmpTarget = prop.getReadMethod().invoke(bean);
                    if(tmpTarget == null) {
                        return null;
                    }
                    break;
                }
            }

            if(tmpTarget == null) {
                tmpTarget = bean;
            }


            for (PropertyDescriptor prop : PropertyUtils.getPropertyDescriptors(tmpTarget)){
                List<Method> tmpMethodList = Lists.newArrayList();
                if(readEntityMethod != null){
                    tmpMethodList.add(readEntityMethod);
                }
                tmpMethodList.add(prop.getReadMethod());
                tempMethodMap.put(prop.getName(), tmpMethodList);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        methodList = Lists.newArrayList();
        getReadMethodList(recoveryFilter.getRecoveryfilterkeykmid1(),tempMethodMap);
        getReadMethodList(recoveryFilter.getRecoveryfilterkeykmid2(),tempMethodMap);
        getReadMethodList(recoveryFilter.getRecoveryfilterkeykmid3(),tempMethodMap);
        getReadMethodList(recoveryFilter.getRecoveryfilterkeykmid4(),tempMethodMap);
        getReadMethodList(recoveryFilter.getRecoveryfilterkeykmid5(),tempMethodMap);

        return methodList;

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void getReadMethodList(String pKeykmId,Map methodMap){
        if(!Strings.isNullOrEmpty(pKeykmId)){
            if(!methodMap.containsKey(pKeykmId)){
                throw new ExIllegalArgumentException("対象データに[" + pKeykmId+ "]が存在しません！");
            }
            methodList.add((List<Method>) methodMap.get(pKeykmId));
        }

    }
}
