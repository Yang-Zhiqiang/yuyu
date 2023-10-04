package yuyu.batch.sinkeiyaku.skkessan.skmiseirijiyuutyouhyousakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.QHT_MiseirijiyuuMeisai;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 新契約 決算 未整理事由別明細帳票作成の機能DAOクラスです
 */
public class SkMiseiriJiyuuTyouhyouSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_MiseirijiyuuMeisai> getMosnoMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulst(C_Tuukasyu pRstuukasyu,
        C_Tuukasyu... pKyktuukasyuList) {

        QHT_MiseirijiyuuMeisai qHT_MiseirijiyuuMeisai = new QHT_MiseirijiyuuMeisai("qHT_MiseirijiyuuMeisai");

        String subSql = $SELECT + qHT_MiseirijiyuuMeisai +
            $FROM(qHT_MiseirijiyuuMeisai) +
            $WHERE + qHT_MiseirijiyuuMeisai.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_MiseirijiyuuMeisai.kyktuukasyu.in(pKyktuukasyuList) +
            $ORDER_BY(qHT_MiseirijiyuuMeisai.mosno.asc());

        return exDBEntityManager.createJPQL(subSql).bind(qHT_MiseirijiyuuMeisai).getResults();
    }

    public ExDBResults<HT_MiseirijiyuuMeisai> getMiseirijiyuukbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulst(C_Tuukasyu pRstuukasyu,
        C_Tuukasyu... pKyktuukasyuList) {

        QHT_MiseirijiyuuMeisai qHT_MiseirijiyuuMeisai = new QHT_MiseirijiyuuMeisai("qHT_MiseirijiyuuMeisai");

        String subSql = $SELECT + qHT_MiseirijiyuuMeisai +
            $FROM(qHT_MiseirijiyuuMeisai) +
            $WHERE + qHT_MiseirijiyuuMeisai.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_MiseirijiyuuMeisai.kyktuukasyu.in(pKyktuukasyuList) +
            $ORDER_BY(qHT_MiseirijiyuuMeisai.miseirijiyuukbn.asc(),
                qHT_MiseirijiyuuMeisai.miseirijiyuudetailkbn.asc(),
                qHT_MiseirijiyuuMeisai.mosno.asc());

        return exDBEntityManager.createJPQL(subSql).bind(qHT_MiseirijiyuuMeisai).getResults();
    }

    public ExDBResults<HT_MiseirijiyuuMeisai> getNyuukinjoutaikbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulst(C_Tuukasyu pRstuukasyu,
        C_Tuukasyu... pKyktuukasyuList) {

        QHT_MiseirijiyuuMeisai qHT_MiseirijiyuuMeisai = new QHT_MiseirijiyuuMeisai("qHT_MiseirijiyuuMeisai");

        String subSql = $SELECT + qHT_MiseirijiyuuMeisai +
            $FROM(qHT_MiseirijiyuuMeisai) +
            $WHERE + qHT_MiseirijiyuuMeisai.miseirijiyuukbn.eq("03") +
            $AND + qHT_MiseirijiyuuMeisai.miseirijiyuudetailkbn.eq("01") +
            $AND + qHT_MiseirijiyuuMeisai.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_MiseirijiyuuMeisai.kyktuukasyu.in(pKyktuukasyuList) +
            $ORDER_BY(qHT_MiseirijiyuuMeisai.nyuukinjoutaikbn.asc(),
                qHT_MiseirijiyuuMeisai.mosno.asc());

        return exDBEntityManager.createJPQL(subSql).bind(qHT_MiseirijiyuuMeisai).getResults();
    }

    public ExDBResults<HT_MiseirijiyuuMeisai> getSyoruisyuruikbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulstSyoruihubikensuuEq(
        C_Tuukasyu pRstuukasyu, C_Tuukasyu... pKyktuukasyuList) {

        QHT_MiseirijiyuuMeisai qHT_MiseirijiyuuMeisai = new QHT_MiseirijiyuuMeisai("qHT_MiseirijiyuuMeisai");

        String strSql = $SELECT + qHT_MiseirijiyuuMeisai +
            $FROM + qHT_MiseirijiyuuMeisai.HT_MiseirijiyuuMeisai() +
            $WHERE + qHT_MiseirijiyuuMeisai.miseirijiyuukbn.eq("03") +
            $AND + qHT_MiseirijiyuuMeisai.miseirijiyuudetailkbn.eq("02") +
            $AND + qHT_MiseirijiyuuMeisai.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_MiseirijiyuuMeisai.syoruihubikensuu.eq(1) +
            $AND + qHT_MiseirijiyuuMeisai.kyktuukasyu.in(pKyktuukasyuList) +
            $ORDER_BY (qHT_MiseirijiyuuMeisai.syoruikbn1.asc(),
                qHT_MiseirijiyuuMeisai.mosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_MiseirijiyuuMeisai).getResults();
    }

    public ExDBResults<HT_MiseirijiyuuMeisai> getSyoruisyuruikbnMiseirijiyuuMeisaisByRstuukasyuKyktuukasyulstSyoruihubikensuuNe(
        C_Tuukasyu pRstuukasyu, C_Tuukasyu... pKyktuukasyuList) {

        QHT_MiseirijiyuuMeisai qHT_MiseirijiyuuMeisai = new QHT_MiseirijiyuuMeisai("qHT_MiseirijiyuuMeisai");

        String strSql = $SELECT + qHT_MiseirijiyuuMeisai +
            $FROM + qHT_MiseirijiyuuMeisai.HT_MiseirijiyuuMeisai() +
            $WHERE + qHT_MiseirijiyuuMeisai.miseirijiyuukbn.eq("03") +
            $AND + qHT_MiseirijiyuuMeisai.miseirijiyuudetailkbn.eq("02") +
            $AND + qHT_MiseirijiyuuMeisai.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_MiseirijiyuuMeisai.syoruihubikensuu.ne(1) +
            $AND + qHT_MiseirijiyuuMeisai.kyktuukasyu.in(pKyktuukasyuList) +
            $ORDER_BY (qHT_MiseirijiyuuMeisai.syoruihubikensuu.desc(),
                qHT_MiseirijiyuuMeisai.syoruikbn1.asc(),
                qHT_MiseirijiyuuMeisai.mosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_MiseirijiyuuMeisai).getResults();
    }
}
