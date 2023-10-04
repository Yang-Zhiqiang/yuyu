package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomisakujyolistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.db.meta.QHT_HrkmNyknSakujyo;

/**
 * 新契約 入金 振込入金削除リスト作成DAOクラス
 */
public class SkHurikomiSakujyoListSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosBySyoriYmdSyorizumiflgRstuukasyuNyktyhyoutlst(BizDate pSyoriYmd,
        C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn... pNyktyhyoutKbnLst) {

        QHT_HrkmNyknSakujyo qHT_HrkmNyknSakujyo = new QHT_HrkmNyknSakujyo("qHT_HrkmNyknSakujyo");

        String queryStr = $SELECT + qHT_HrkmNyknSakujyo +
            $FROM(qHT_HrkmNyknSakujyo) +
            $WHERE + qHT_HrkmNyknSakujyo.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_HrkmNyknSakujyo.syorizumiflg.eq(C_Syorizumiflg.SYORIZUMI) +
            $AND + qHT_HrkmNyknSakujyo.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_HrkmNyknSakujyo.nyktyhyoutkbn.in(pNyktyhyoutKbnLst) +
            $ORDER_BY(qHT_HrkmNyknSakujyo.oyadrtencd.asc(),
                qHT_HrkmNyknSakujyo.nykmosno.asc());

        return exDBEntityManager.createJPQL(queryStr).bind(qHT_HrkmNyknSakujyo).getResults();
    }

}
