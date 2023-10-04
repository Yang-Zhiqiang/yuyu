package yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KouzahuriStartAnnai;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納 口座振替開始案内作成Daoクラス
 */
public class KhKzhuriKaisiAnnaiSksDao {

    public KhKzhuriKaisiAnnaiSksDao() {
        super();
    }

    @Inject
    private ExDBEntityManager em;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public ExDBResults<KzhuriAnnaiDataBean> getKzhuriAnnaiDataBean(BizDateYM pJkipjytym, String pKakutyouJobcd){

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("q1");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("q2");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("q3");

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki1 = new QIT_NyknJissekiRireki("q4");

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki2 = new QIT_NyknJissekiRireki("q7");

        QIT_KouzahuriStartAnnai qIT_KouzahuriStartAnnai = new QIT_KouzahuriStartAnnai("q8");

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("q9");

        String subQuery1 = $SELECT + qIT_NyknJissekiRireki1.syono +
            $FROM(qIT_NyknJissekiRireki1) +
            $WHERE  + qIT_NyknJissekiRireki1.syono.eq(qIT_KykKihon.syono) +
            $AND  + qIT_NyknJissekiRireki1.nykkeiro.ne(C_Nykkeiro.SKEI);

        String subQuery2 = $SELECT + qIT_NyknJissekiRireki2.syono +
            $FROM(qIT_NyknJissekiRireki2) +
            $WHERE  + qIT_NyknJissekiRireki2.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_NyknJissekiRireki2.nykkeiro.eq(C_Nykkeiro.SKEI);

        String subQuery3 = $SELECT + qIT_KouzahuriStartAnnai.syono +
            $FROM(qIT_KouzahuriStartAnnai) +
            $WHERE  + qIT_KouzahuriStartAnnai.syono.eq(qIT_KykKihon.syono);

        String subQuery4 = $SELECT + qIT_KhTtdkRireki.syono +
            $FROM(qIT_KhTtdkRireki) +
            $WHERE  + qIT_KhTtdkRireki.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU) +
            $AND + $(qIT_KhTtdkRireki.syorikbn.ne(C_SyoriKbn.YYKIDOUUKE) +
                $AND + qIT_KhTtdkRireki.syorikbn.ne(C_SyoriKbn.YYKIDOUTORIKESI));

        String mainQuery = $SELECT + $NEW(KzhuriAnnaiDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykKihon.tikiktbrisyuruikbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName()) +
            $FROM (qIT_AnsyuKihon,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE  + qIT_AnsyuKihon.jkipjytym.eq(pJkipjytym) +
                $AND  + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
                $AND  + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND  + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.KOUHURI) +
                $AND  + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.TUKI) +
                $AND + "(" + qIT_KykKihon.tikiktbrisyuruikbn.ne(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS) +
                $AND  + qIT_KykKihon.tikiktbrisyuruikbn.ne(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS)+ ")" +
                $AND  + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND  + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND  + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                $AND  + qIT_KykSyouhn.kykymd.substring(1, 6) +
                $GE + pJkipjytym.addMonths(-5) +
                $AND  + $NOT_EXISTS(subQuery1) +
                $AND  + $EXISTS(subQuery2) +
                $AND  + $NOT_EXISTS(subQuery3) +
                $AND  + $NOT_EXISTS(subQuery4);

        ExDBResults<KzhuriAnnaiDataBean> exDBResults = em.createJPQL(mainQuery, KzhuriAnnaiDataBean.class).
            bind(qIT_AnsyuKihon, qIT_KykKihon, qIT_KykSyouhn, qIT_NyknJissekiRireki1,
                qIT_NyknJissekiRireki2, qIT_KouzahuriStartAnnai, qIT_KhTtdkRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobcd));

        return exDBResults;

    }

    public IT_KykKihon getKykKihon(String pSyono){
        return hozenDomManager.getKykKihon(pSyono);
    }

    public IT_KykSya getKykSya(IT_KykKihon pKykKihon){
        IT_KykSya kykSya = null;
        try {
            kykSya = pKykKihon.getKykSya();
        }
        catch (EntityNotFoundException e) {
            kykSya = null;
        }
        return kykSya;
    }

    public IT_HhknSya getHhknSya(IT_KykKihon pKykKihon){
        IT_HhknSya hhknSya = null;
        try {
            hhknSya = pKykKihon.getHhknSya();
        }
        catch (EntityNotFoundException e) {
            hhknSya = null;
        }
        return hhknSya;
    }

    public IT_Kouza getKouza(IT_KykKihon pKykKihon){
        return pKykKihon.getKouza();
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno){
        return bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);
    }

    public IT_KykDairiten getKykDairiten(IT_KykKihon pKykKihon){
        List<IT_KykDairiten> kykDairitenList = pKykKihon.getKykDairitens();

        IT_KykDairiten kykDairiten = null;
        if (kykDairitenList.size() != 0){
            kykDairiten = kykDairitenList.get(0);
        }
        return kykDairiten;
    }
}
