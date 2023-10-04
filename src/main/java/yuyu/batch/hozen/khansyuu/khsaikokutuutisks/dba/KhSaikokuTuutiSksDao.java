package yuyu.batch.hozen.khansyuu.khsaikokutuutisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_YykIdouUktk;

import com.google.common.collect.Collections2;

/**
 * 契約保全 案内収納 催告通知作成の機能DAOクラス
 */
public class KhSaikokuTuutiSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SaikokuTuutiSksTaisyouDataBean> getSaikokuTuutiSksTaisyouDataBean(String pKakutyoujobcd,
        BizDateYM pSyoriYm,C_Hrkkeiro pHrkkeiro) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String strSql = $SELECT + $NEW(SaikokuTuutiSksTaisyouDataBean.class ,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_AnsyuKihon.jkipjytym) +
            $FROM(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon) +
            $WHERE + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
            $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
            $AND + qIT_KykKihon.hrkkeiro.eq(pHrkkeiro)+
            $AND + qIT_AnsyuKihon.jkipjytym.le(pSyoriYm.addMonths(-3)) +
            $AND + qIT_AnsyuKihon.jkipjytym.substring(1, 6).lt(qIT_AnsyuKihon.syuharaimanymd.substring(1, 6)) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU)  +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + $(qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU)+
                $OR + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.IKKATUNK));

        ExDBResults<SaikokuTuutiSksTaisyouDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, SaikokuTuutiSksTaisyouDataBean.class).
            bind(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public List<IT_KouzahuriMinyuTuuti> getKouzahuriMinyuTuutis(String pSyono,
        BizDateYM pJkipjytym) {

        QIT_KouzahuriMinyuTuuti qIT_KouzahuriMinyuTuuti = new QIT_KouzahuriMinyuTuuti("qIT_KouzahuriMinyuTuuti");

        String strSql = $SELECT +  qIT_KouzahuriMinyuTuuti +

            $FROM(qIT_KouzahuriMinyuTuuti) +
            $WHERE + qIT_KouzahuriMinyuTuuti.syono.eq(pSyono) +
            $AND + qIT_KouzahuriMinyuTuuti.jkipjytym.eq(pJkipjytym) +
            $AND + qIT_KouzahuriMinyuTuuti.saikokutuutizumiflg.eq(C_Skszumiflg.SAKUSEIZUMI);

        List<IT_KouzahuriMinyuTuuti> exDBResults = exDBEntityManager.createJPQL(strSql).
            bind(qIT_KouzahuriMinyuTuuti).getResultList();

        return exDBResults;
    }

    public List<IT_Kariukekin> getKariukekins(IT_KykKihon pKykKihon) {

        List<IT_Kariukekin> KariukekinLst = pKykKihon.getKariukekins();

        return new ArrayList<IT_Kariukekin>(Collections2.filter(KariukekinLst, new FilterKariukekin1()));
    }

    public List<IT_YykIdouUktk> getYykIdouUktks(String pSyono,
        BizDateYM pSyoriYm) {

        QIT_YykIdouUktk qIT_YykIdouUktk = new QIT_YykIdouUktk("qIT_YykIdouUktk");

        String strSql = $SELECT +  qIT_YykIdouUktk +
            $FROM(qIT_YykIdouUktk) +
            $WHERE + qIT_YykIdouUktk.syono.eq(pSyono) +
            $AND + qIT_YykIdouUktk.yykidousyorikbn.eq(C_YykidousyoriKbn.UKE) +
            $AND + qIT_YykIdouUktk.syoriym.le(pSyoriYm) ;

        List<IT_YykIdouUktk> exDBResults = exDBEntityManager.createJPQL(strSql).
            bind(qIT_YykIdouUktk).getResultList();

        return exDBResults;
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis (String pSyono){
        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        QIT_AnsyuRireki qIT_AnsyuRireki1 = new QIT_AnsyuRireki("qIT_AnsyuRireki1");

        String strSubSql = $SELECT + $MAX(qIT_AnsyuRireki1.uriageymdkon) +
            $AS + ("uriageymdkon") +
            $FROM(qIT_AnsyuRireki1) +
            $WHERE + qIT_AnsyuRireki1.syono.eq(qIT_AnsyuRireki.syono) ;

        String strSql = $SELECT + qIT_AnsyuRireki +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.MINYUU) +
            $AND + qIT_AnsyuRireki.uriageymdkon +
            $EQ + $(strSubSql) +
            $ORDER_BY(qIT_AnsyuRireki.jyuutouym);

        List<IT_AnsyuRireki> exDBResults = exDBEntityManager.createJPQL(strSql).
            bind(qIT_AnsyuRireki, qIT_AnsyuRireki1).getResultList();

        return exDBResults;
    }
}
