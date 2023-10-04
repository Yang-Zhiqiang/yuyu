package yuyu.batch.sinkeiyaku.skkettei.sklinckekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.meta.QHT_SkLincJyusinData;

/**
 * 新契約 決定 新契約ＬＩＮＣ結果反映DAOクラス
 */
public class SkLincKekkaHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SkLincJyusinData> getSkLincJyusinDatasByKakutyoujobcdSyoriymd(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QHT_SkLincJyusinData qHT_SkLincJyusinData1 = new QHT_SkLincJyusinData("qHT_SkLincJyusinData1");

        QHT_SkLincJyusinData qHT_SkLincJyusinData2 = new QHT_SkLincJyusinData("qHT_SkLincJyusinData2");

        String strSql1 = $SELECT + qHT_SkLincJyusinData1.rendoumosnochknasi +
            $FROM(qHT_SkLincJyusinData1) +
            $WHERE + qHT_SkLincJyusinData1.lincsoujyusinsyskbn.eq(C_LincsoujyusinsysKbn.SKEI) +
            $AND + qHT_SkLincJyusinData1.syoriYmd.eq(pSyoriYmd) +
            $AND + "(" + qHT_SkLincJyusinData1.lincrecordsyubetu.eq(6) +
            $OR + qHT_SkLincJyusinData1.lincrecordsyubetu.eq(16) +
            $OR + qHT_SkLincJyusinData1.lincrecordsyubetu.eq(26) +
            $OR + qHT_SkLincJyusinData1.lincrecordsyubetu.eq(50) + ")" +
            $AND + qHT_SkLincJyusinData1.syoriYmd.eq(qHT_SkLincJyusinData2.syoriYmd) +
            $GROUP_BY + qHT_SkLincJyusinData1.rendoumosnochknasi +
            $HAVING + $MIN(qHT_SkLincJyusinData1.linckyknaiykekdatarenno) + $EQ + qHT_SkLincJyusinData2.linckyknaiykekdatarenno;

        String strSql2 =$SELECT + qHT_SkLincJyusinData2 +
            $FROM(qHT_SkLincJyusinData2) +
            $WHERE + $EXISTS(strSql1) +
            $ORDER_BY(qHT_SkLincJyusinData2.linckyknaiykekdatarenno.asc());

        ExDBResults<HT_SkLincJyusinData> exDBResults = exDBEntityManager.createJPQL(strSql2)
            .bind(qHT_SkLincJyusinData1, qHT_SkLincJyusinData2).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

}