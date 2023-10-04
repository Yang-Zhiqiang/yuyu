package yuyu.batch.hozen.khinterf.khtmttkingkysksel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 インターフェイス 積立金額予測ファイル抽出機能DAOクラス
 */
public class KhTmttkingkYskSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhTmttkingkYskSelBean> getTmttkingkYsk(String pKakutyouJobCd) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn1 = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn1");

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn2 = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn2");

        String subQueryA = $SELECT +
            qIT_KhSisuurendoTmttkn1.syono + "," +
            $MAX(qIT_KhSisuurendoTmttkn1.tmttkntaisyouym) +
            $FROM(qIT_KhSisuurendoTmttkn1) +
            $WHERE + qIT_KhSisuurendoTmttkn1.syono.eq(qIT_KhSisuurendoTmttkn2.syono) +
            $GROUP_BY + qIT_KhSisuurendoTmttkn1.syono +
            $HAVING + $MAX(qIT_KhSisuurendoTmttkn1.tmttkntaisyouym) + $EQ + qIT_KhSisuurendoTmttkn2.tmttkntaisyouym;

        String subQueryB = $SELECT +
            qIT_KhSisuurendoTmttkn2.syono + "," +
            qIT_KhSisuurendoTmttkn2.tmttkntaisyouym + "," +
            $MAX(qIT_KhSisuurendoTmttkn2.renno) +
            $FROM(qIT_KhSisuurendoTmttkn2) +
            $WHERE + $EXISTS(subQueryA) +
            $AND + qIT_KhSisuurendoTmttkn2.syono.eq(qIT_KhSisuurendoTmttkn.syono) +
            $AND + qIT_KhSisuurendoTmttkn2.tmttkntaisyouym.eq(qIT_KhSisuurendoTmttkn.tmttkntaisyouym) +
            $GROUP_BY + qIT_KhSisuurendoTmttkn2.syono + "," +
            qIT_KhSisuurendoTmttkn2.tmttkntaisyouym +
            $HAVING + $MAX(qIT_KhSisuurendoTmttkn2.renno) + $EQ + qIT_KhSisuurendoTmttkn.renno;

        String subQuery = $SELECT + $NEW(KhTmttkingkYskSelBean.class,
            qIT_KykSyouhn.kbnkey,
            qIT_KykSyouhn.syono,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.hknkkn,
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName(),
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.setteibairitu,
            qIT_KykSyouhn.kykjisisuurendourate,
            qIT_KykSyouhn.tmttknzoukaritujygn,
            qIT_KykSyouhn.tumitateriritu,
            qIT_KykSyouhn.tmttknhaibunjyoutai,
            qIT_KykSyouhn.sisuukbn,
            qIT_KykSyouhn.rendouritu,
            qBM_SyouhnZokusei.teikisiharaikinumu,
            qIT_KhSisuurendoTmttkn.tmttkntaisyouym,
            qIT_KhSisuurendoTmttkn.renno,
            qIT_KhSisuurendoTmttkn.tmttknhaneisisuu,
            qIT_KhSisuurendoTmttkn.sisuurendoutmttkngk.getTypeFieldName(),
            qIT_KhSisuurendoTmttkn.sisuurendoutmttkngk.getValueFieldName(),
            qIT_KhSisuurendoTmttkn.teiritutmttkngk.getTypeFieldName(),
            qIT_KhSisuurendoTmttkn.teiritutmttkngk.getValueFieldName()) +
            $FROM(qIT_KykSyouhn,
                qBM_SyouhnZokusei,
                qIT_KhSisuurendoTmttkn) +
                $WHERE + $EXISTS(subQueryB) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KhSisuurendoTmttkn.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                $ORDER_BY(qIT_KykSyouhn.syouhncd.asc(),
                    qIT_KykSyouhn.kykymd.asc(),
                    qIT_KykSyouhn.hknkkn.asc(),
                    qIT_KykSyouhn.sisuukbn.asc(),
                    qIT_KykSyouhn.syono.asc());

        ExDBResults<KhTmttkingkYskSelBean> exDBResults = exDBEntityManager.createJPQL(
            subQuery, KhTmttkingkYskSelBean.class).bind(
                qIT_KykSyouhn,
                qIT_KhSisuurendoTmttkn,
                qIT_KhSisuurendoTmttkn1,
                qIT_KhSisuurendoTmttkn2).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Long getHenkouUktkTmttkinItenCountBySyono(String pSyono) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $COUNT(qIT_KhHenkouUktk.syono) +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.TMTTKNITEN) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk).getSingleResult();
    }

}
