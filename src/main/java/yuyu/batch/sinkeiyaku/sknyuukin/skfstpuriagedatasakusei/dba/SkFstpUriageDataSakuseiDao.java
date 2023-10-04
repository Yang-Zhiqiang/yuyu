package yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagedatasakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 入金 初回保険料売上請求データ作成の機能DAOクラスです。
 */
public class SkFstpUriageDataSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<HT_SyoriCTL> getFstpUriageMisousinData(String pKakutyouJobCd){

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM  + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_SyoriCTL.uriagesousinkbn.eq(C_UriagesousinKbn.SOUSINMATI) +
            $ORDER_BY(qHT_SyoriCTL.mosno);

        ExDBUpdatableResults<HT_SyoriCTL> exDBResults = exDBEntityManager.
            createJPQL(strSql).bind(qHT_SyoriCTL).getUpdatableResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return  exDBResults;
    }
}
