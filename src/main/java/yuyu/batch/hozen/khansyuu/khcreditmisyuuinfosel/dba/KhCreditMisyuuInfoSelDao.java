package yuyu.batch.hozen.khansyuu.khcreditmisyuuinfosel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_DattaiUktk;
import yuyu.def.db.meta.QIT_Kariukekin;
import yuyu.def.db.meta.QIT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 案内収納 クレカ未収契約情報抽出の機能DAOクラス
 */
public class KhCreditMisyuuInfoSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<CreditMisyuuInfoBean> getCreditMisyuuInfoBean(String pKakutyoujobcd, BizDateYM pSyoriYm) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_DattaiUktk qIT_DattaiUktk = new QIT_DattaiUktk("qIT_DattaiUktk");

        String strSql = $SELECT + $NEW(CreditMisyuuInfoBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_DattaiUktk.dattairiyuukbn,
            qIT_DattaiUktk.dattaikeiro) +
            $FROM(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon, qIT_DattaiUktk) +
            $WHERE + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
            $AND + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.CREDIT) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + $(qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                $OR  + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.IKKATUNK)) +
            $AND + qIT_AnsyuKihon.jkipjytym.substring(1, 6).lt(qIT_AnsyuKihon.syuharaimanymd.substring(1, 6)) +
            $AND + qIT_AnsyuKihon.jkipjytym.lt(pSyoriYm) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_DattaiUktk.syono.eq(qIT_KykKihon.syono) ;

        ExDBResults<CreditMisyuuInfoBean> exDBResults = exDBEntityManager.createJPQL(strSql, CreditMisyuuInfoBean.class)
            .bind(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon, qIT_DattaiUktk).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public List<IT_KouzahuriMinyuTuuti> getKouzahuriMinyuTuutis(String pSyono, BizDateYM pJkipjytym,
        BizDate pKzhuriTyouhyousakuseiKijyunymd, BizDate pCreditTyouhyousakuseiKijyunymd) {

        QIT_KouzahuriMinyuTuuti qIT_KouzahuriMinyuTuuti = new QIT_KouzahuriMinyuTuuti("qIT_KouzahuriMinyuTuuti");

        String strSql = $SELECT +
            qIT_KouzahuriMinyuTuuti +
            $FROM(qIT_KouzahuriMinyuTuuti) +
            $WHERE + qIT_KouzahuriMinyuTuuti.syono.eq(pSyono) +
            $AND + qIT_KouzahuriMinyuTuuti.jkipjytym.eq(pJkipjytym) +
            $AND + $((qIT_KouzahuriMinyuTuuti.hrkkeiro.eq(C_Hrkkeiro.KOUHURI) +
                $AND + qIT_KouzahuriMinyuTuuti.tyouhyouymd.gt(pKzhuriTyouhyousakuseiKijyunymd)) +
                $OR + $(qIT_KouzahuriMinyuTuuti.hrkkeiro.eq(C_Hrkkeiro.CREDIT) +
                    $AND + qIT_KouzahuriMinyuTuuti.tyouhyouymd.gt(pCreditTyouhyousakuseiKijyunymd)));

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KouzahuriMinyuTuuti).getResultList();
    }

    public List<IT_Kariukekin> getKariukekins(String pSyono) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT +
            qIT_Kariukekin +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) +
            $AND + qIT_Kariukekin.nyknaiyoukbn.in(C_NyknaiyouKbn.KEIZOKUP, C_NyknaiyouKbn.HARAIHENYOUP,
                C_NyknaiyouKbn.OTHER, C_NyknaiyouKbn.HOZENHENKOUYOUP) +
                $AND + qIT_Kariukekin.krkseisanzumiflg.eq(C_Krkseisanzumiflg.BLNK);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Kariukekin).getResultList();
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis(String pSyono) {

        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");
        QIT_AnsyuRireki subqIT_AnsyuRireki = new QIT_AnsyuRireki("subqIT_AnsyuRireki");

        String strSubSql = $SELECT  + $MAX(subqIT_AnsyuRireki.uriageymdkon) +
            $FROM(subqIT_AnsyuRireki) +
            $WHERE + subqIT_AnsyuRireki.syono.eq(qIT_AnsyuRireki.syono) ;

        String strSql = $SELECT + qIT_AnsyuRireki +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono)  +
            $AND + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.MINYUU) +
            $AND + qIT_AnsyuRireki.uriageymdkon + $EQ + $(strSubSql) +
            $ORDER_BY  (qIT_AnsyuRireki.jyuutouym.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AnsyuRireki, subqIT_AnsyuRireki).getResultList();
    }
}
