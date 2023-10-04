package yuyu.batch.hozen.khkessan.khyendthnkbikinlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhBikinkanri;

/**
 * 契約保全 決算 円建変更時返戻金備金リスト作成機能DAOクラス
 */
public class KhYendtHnkBikinListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbn(String pKakutyoujobcd,
        BizDate pKessanKijyunYmd, C_BkncdKbn pBkncdKbn) {

        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri("QIT_KhBikinkanri");

        String strSql = $SELECT + qIT_KhBikinkanri +

            $FROM(qIT_KhBikinkanri) +

            $WHERE + qIT_KhBikinkanri.kessankijyunymd.eq(pKessanKijyunYmd) +
            $AND + qIT_KhBikinkanri.bkncdkbn.eq(pBkncdKbn) +
            $AND + qIT_KhBikinkanri.bknrigikbn.eq(C_BknrigiKbn.BLNK) +

            $ORDER_BY(qIT_KhBikinkanri.kbnkeirisegcd.asc(),
                qIT_KhBikinkanri.bknkktymd.asc(),
                qIT_KhBikinkanri.syono.asc());

        ExDBResults<IT_KhBikinkanri> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_KhBikinkanri).
            getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
