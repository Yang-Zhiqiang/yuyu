package yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.db.meta.QIT_AsBikinkanri;

/**
 * 契約保全 決算 Ｐ未入消滅備金時効リスト作成機能DAOクラス
 */
public class KhPMinyuuSyoumetuBikinListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_AsBikinkanri> getAsBikinkanriInfosByKakutyoujobcdKsnbiymdBikincdkbn(String pKakutyoujobcd,
        BizDate pKessanKijyunYmd, C_BkncdKbn pBkncdKbn) {

        QIT_AsBikinkanri qIT_AsBikinkanri = new QIT_AsBikinkanri("qIT_AsBikinkanri");

        String strSql = $SELECT + qIT_AsBikinkanri +
            $FROM(qIT_AsBikinkanri) +
            $WHERE + qIT_AsBikinkanri.kessankijyunymd.eq(pKessanKijyunYmd) +
            $AND + qIT_AsBikinkanri.bkncdkbn.eq(pBkncdKbn) +
            $ORDER_BY(qIT_AsBikinkanri.kbnkeirisegcd.asc(),
                qIT_AsBikinkanri.bknkktymd.asc(),
                qIT_AsBikinkanri.syono.asc());

        ExDBResults<IT_AsBikinkanri> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_AsBikinkanri).
            getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
