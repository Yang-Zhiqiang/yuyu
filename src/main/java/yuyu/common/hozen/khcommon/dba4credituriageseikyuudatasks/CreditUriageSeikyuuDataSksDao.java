package yuyu.common.hozen.khcommon.dba4credituriageseikyuudatasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_UriageSeikyuuData;
import yuyu.def.hozen.comparator.OrderIT_UriageSeikyuuData;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全共通 クレカ売上請求データ作成DAOクラス
 */
public class CreditUriageSeikyuuDataSksDao {

    public Integer getUriageSeikyuuDataMaxRenno3keta(IT_AnsyuKihon pAnsyuKihon, String pCreditkessaiyouNo,
        BizDate pUriagenengappi) {

        List<IT_UriageSeikyuuData> uriageSeikyuuDataList = pAnsyuKihon.getUriageSeikyuuDatas();

        uriageSeikyuuDataList = new ArrayList<IT_UriageSeikyuuData>(Collections2.
            filter(uriageSeikyuuDataList, new FilterUriageSeikyuuData1(pAnsyuKihon.getSyono(),
                pCreditkessaiyouNo,pUriagenengappi)));

        List<SortCondition<IT_UriageSeikyuuData>> sortConditionUriageSeikyuuDataList = new ArrayList<>();

        sortConditionUriageSeikyuuDataList.add(new SortCondition<>(
            (new QIT_UriageSeikyuuData()).renno3keta, SortOrder.DESC));

        List<IT_UriageSeikyuuData> uriageSeikyuuDataTmpList =
            new ArrayList<IT_UriageSeikyuuData>(uriageSeikyuuDataList);

            Collections.sort(uriageSeikyuuDataTmpList, new OrderIT_UriageSeikyuuData(
                sortConditionUriageSeikyuuDataList));

            if (uriageSeikyuuDataTmpList.size() > 0) {

                return uriageSeikyuuDataTmpList.get(0).getRenno3keta();
            }
            return null;
    }

    public String getUriageSeikyuuDataMaxRecordno(IT_AnsyuKihon pAnsyuKihon,String pCreditkessaiyouNo,
        BizDate pUriagenengappi,C_CreditUriageSeikyuuKbn pCreditUriageSeikyuuKbn) {

        List<IT_UriageSeikyuuData> uriageSeikyuuDataList = pAnsyuKihon.getUriageSeikyuuDatas();

        List<IT_UriageSeikyuuData> uriageSeikyuuDataFilterList = new ArrayList<IT_UriageSeikyuuData>(Collections2.
            filter(uriageSeikyuuDataList, new FilterUriageSeikyuuData2(pAnsyuKihon.getSyono(),pCreditkessaiyouNo,
                pUriagenengappi,pCreditUriageSeikyuuKbn)));

        SortUriageSeikyuuData sortUriageSeikyuuData = SWAKInjector.getInstance(SortUriageSeikyuuData.class);

        uriageSeikyuuDataFilterList = sortUriageSeikyuuData.OrderIT_UriageSeikyuuData(uriageSeikyuuDataFilterList);

        if(uriageSeikyuuDataFilterList.size() > 0){

            return uriageSeikyuuDataFilterList.get(0).getRecordno();
        }
        return null;
    }
}
