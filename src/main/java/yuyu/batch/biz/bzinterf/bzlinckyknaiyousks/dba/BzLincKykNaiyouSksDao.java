package yuyu.batch.biz.bzinterf.bzlinckyknaiyousks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.db.meta.QHT_SkLincSousinData;
import yuyu.def.db.meta.QIT_KhLincSousinData;

/**
 * 業務共通 インターフェース 契約内容ＬＩＮＣ送信Ｆ作成DAOクラスです。<br />
 */
public class BzLincKykNaiyouSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SkLincSousinDataBean> getSkLincSousinDataBeansByRecordsyubetuSyoriymdKakutyoujobcd(
        Integer pLincRecordSyurui, BizDate pSyoriYmd, String pKakutyoujobcd) {

        QHT_SkLincSousinData qHT_SkLincSousinData = new QHT_SkLincSousinData("qHT_SkLincSousinData");

        String strSql = $SELECT + $NEW(SkLincSousinDataBean.class,
            qHT_SkLincSousinData.mosno,
            qHT_SkLincSousinData.syoriYmd,
            qHT_SkLincSousinData.renno) +
            $FROM(qHT_SkLincSousinData) +
            $WHERE + qHT_SkLincSousinData.lincrecordsyubetu.eq(pLincRecordSyurui) +
            $AND + qHT_SkLincSousinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_SkLincSousinData.lincsousinkbn.eq(C_SousinKbn.SOUSINMATI) +
            $ORDER_BY(qHT_SkLincSousinData.renno.asc());

        ExDBResults<SkLincSousinDataBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            SkLincSousinDataBean.class).bind(qHT_SkLincSousinData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<KhLincSousinDataBean> getKhLincSousinDataBeansBySyoriymdKakutyoujobcd(
        BizDate pSyoriYmd, String pKakutyoujobcd) {

        QIT_KhLincSousinData qIT_KhLincSousinData1 = new QIT_KhLincSousinData("qIT_KhLincSousinData1");

        QIT_KhLincSousinData qIT_KhLincSousinData2 = new QIT_KhLincSousinData("qIT_KhLincSousinData2");

        String strSubSql = $SELECT + $MAX(qIT_KhLincSousinData1.renno) + $AS + "maxRenno" +
            $FROM(qIT_KhLincSousinData1) +
            $WHERE + qIT_KhLincSousinData1.syono.eq(qIT_KhLincSousinData2.syono) +
            $AND + qIT_KhLincSousinData1.syoriYmd.eq(qIT_KhLincSousinData2.syoriYmd) +
            $AND + qIT_KhLincSousinData1.lincrecordsyubetu.eq(qIT_KhLincSousinData2.lincrecordsyubetu);

        String strSql = $SELECT + $NEW(KhLincSousinDataBean.class,
            qIT_KhLincSousinData2.syono,
            qIT_KhLincSousinData2.syoriYmd,
            qIT_KhLincSousinData2.renno) +
            $FROM(qIT_KhLincSousinData2) +
            $WHERE + qIT_KhLincSousinData2.syoriYmd.eq(pSyoriYmd) +
            $AND + qIT_KhLincSousinData2.lincsousinkbn.eq(C_SousinKbn.SOUSINMATI) +
            $AND + qIT_KhLincSousinData2.renno + $EQ + $(strSubSql) +
            $ORDER_BY(qIT_KhLincSousinData2.syono.asc(),
                qIT_KhLincSousinData2.lincrecordsyubetu.asc());

        ExDBResults<KhLincSousinDataBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            KhLincSousinDataBean.class).bind(qIT_KhLincSousinData1, qIT_KhLincSousinData2).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
