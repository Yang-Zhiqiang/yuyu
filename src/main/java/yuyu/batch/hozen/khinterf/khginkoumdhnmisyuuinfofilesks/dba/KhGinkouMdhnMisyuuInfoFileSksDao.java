package yuyu.batch.hozen.khinterf.khginkoumdhnmisyuuinfofilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_KhGinkouMdhnMisyuuInfo;

/**
 * 契約保全 インターフェイス 銀行窓販未収情報Ｆ作成機能DAOクラス
 */
public class KhGinkouMdhnMisyuuInfoFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhGinkouMdhnMisyuuInfoBean> getGinkouMdhnMisyuuInfoBeans(String pKakutyoujobcd, BizDate pDataRenymd) {

        QIT_KhGinkouMdhnMisyuuInfo qIT_KhGinkouMdhnMisyuuInfo = new QIT_KhGinkouMdhnMisyuuInfo("qIT_KhGinkouMdhnMisyuuInfo");

        String strSql = $SELECT + $NEW(KhGinkouMdhnMisyuuInfoBean.class,
            qIT_KhGinkouMdhnMisyuuInfo.datarenymd,
            qIT_KhGinkouMdhnMisyuuInfo.henkousikibetukey,
            qIT_KhGinkouMdhnMisyuuInfo.gwbsydrtencd,
            qIT_KhGinkouMdhnMisyuuInfo.gwdatakbn,
            qIT_KhGinkouMdhnMisyuuInfo.gwdatasakuseiymd,
            qIT_KhGinkouMdhnMisyuuInfo.gwhknkaisyacd,
            qIT_KhGinkouMdhnMisyuuInfo.gwhknsyuruicd,
            qIT_KhGinkouMdhnMisyuuInfo.gwsyonosyuban,
            qIT_KhGinkouMdhnMisyuuInfo.gwmisyuutatekaekbn,
            qIT_KhGinkouMdhnMisyuuInfo.gwmisyuutatekaeym,
            qIT_KhGinkouMdhnMisyuuInfo.gwmisyuukg,
            qIT_KhGinkouMdhnMisyuuInfo.gwbnkaisuu,
            qIT_KhGinkouMdhnMisyuuInfo.gwmisyuujiyuu,
            qIT_KhGinkouMdhnMisyuuInfo.gwjikaidatakousinymd,
            qIT_KhGinkouMdhnMisyuuInfo.kbnkey,
            qIT_KhGinkouMdhnMisyuuInfo.syono,
            qIT_KhGinkouMdhnMisyuuInfo.ikkatubaraikbn,
            qIT_KhGinkouMdhnMisyuuInfo.ikkatubaraikaisuu) +
            $FROM(qIT_KhGinkouMdhnMisyuuInfo) +
            $WHERE + qIT_KhGinkouMdhnMisyuuInfo.datarenymd.eq(pDataRenymd) +
            $ORDER_BY(qIT_KhGinkouMdhnMisyuuInfo.gwsyonosyuban.asc(),
                qIT_KhGinkouMdhnMisyuuInfo.henkousikibetukey.asc());
        ExDBResults<KhGinkouMdhnMisyuuInfoBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhGinkouMdhnMisyuuInfoBean.class).bind(qIT_KhGinkouMdhnMisyuuInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
