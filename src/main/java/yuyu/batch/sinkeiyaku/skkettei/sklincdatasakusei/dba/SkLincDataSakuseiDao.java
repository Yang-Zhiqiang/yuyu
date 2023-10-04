package yuyu.batch.sinkeiyaku.skkettei.sklincdatasakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_LincdatasousinKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_SkLincSousinData;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 決定 新契約ＬＩＮＣデータ作成機能DAOクラス。<br />
 */
public class SkLincDataSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcd(String pKakutyouJobCd) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");

        String sql = $SELECT + qHT_SyoriCTL +
            $FROM(qHT_SyoriCTL) +
            $WHERE + qHT_SyoriCTL.lincdatasousinkbn.ne(C_LincdatasousinKbn.MISETTEI);

        ExDBUpdatableResults<HT_SyoriCTL> exDBUpdResults = exDBEntityManager.createJPQL(sql).bind(qHT_SyoriCTL).getUpdatableResults();

        exDBUpdResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBUpdResults;
    }

    public Integer getSkLincSousinDataMaxRennoByMosno(String pMosno) {

        QHT_SkLincSousinData qHT_SkLincSousinData = new QHT_SkLincSousinData("qHT_SkLincSousinData");

        String strSql = $SELECT + $MAX(qHT_SkLincSousinData.renno) +
            $FROM(qHT_SkLincSousinData) +
            $WHERE + qHT_SkLincSousinData.mosno.eq(pMosno);

        return exDBEntityManager.createJPQL(strSql).bind(qHT_SkLincSousinData).getSingleResult();
    }
}
