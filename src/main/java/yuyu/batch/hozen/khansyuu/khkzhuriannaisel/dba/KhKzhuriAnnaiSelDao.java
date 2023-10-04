package yuyu.batch.hozen.khansyuu.khkzhuriannaisel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.mapping.AbstractExDBEntity;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_Kouza;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納 口座振替案内データ抽出機能DAOクラスです。
 */
public class KhKzhuriAnnaiSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<AnnaiSyuuouDataBean> getAnnaiSyuuouDataBean(String pKakutyouJobCd,BizDateYM pJkipjytYm,String pKbnkey) {

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_Kouza qIT_Kouza = new QIT_Kouza("qIT_Kouza");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String queryStr = $SELECT + $NEW(AnnaiSyuuouDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_AnsyuKihon.jkipjytym,
            qIT_AnsyuKihon.syuharaimanymd,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykKihon.hrkkeiro,
            qIT_KykKihon.tikiktbrisyuruikbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName(),
            qIT_Kouza.syuudaikocd,
            qIT_Kouza.bankcd,
            qIT_Kouza.sitencd,
            qIT_Kouza.yokinkbn,
            qIT_Kouza.kouzano,
            qIT_Kouza.kzmeiginmkn,
            qIT_Kouza.sinkeizkkbn,
            qIT_KykSya.kyknmkn) +
            $FROM(qIT_AnsyuKihon,
                qIT_Kouza,
                qIT_KykSya,
                qIT_KykSyouhn,
                qIT_KykKihon) +
                $WHERE + qIT_AnsyuKihon.syuharaimanymd.substring(1, 6).gt(qIT_AnsyuKihon.jkipjytym.substring(1, 6)) +
                $AND + qIT_AnsyuKihon.jkipjytym.le(pJkipjytYm) +
                $AND + qIT_AnsyuKihon.kbnkey.in(pKbnkey) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_Kouza.syono) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.KOUHURI) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU);

        ExDBResults<AnnaiSyuuouDataBean> exDBResults = exDBEntityManager.createJPQL(queryStr,
            AnnaiSyuuouDataBean.class).bind(qIT_AnsyuKihon, qIT_Kouza,
                qIT_KykSya, qIT_KykSyouhn, qIT_KykKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Integer getAnsyuRirekiMaxAnnaino(String pSyono, BizDateYM pJyuutouYm) {

        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String quertSql = $SELECT + $MAX(qIT_AnsyuRireki.annaino) +
            $FROM (qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND + qIT_AnsyuRireki.jyuutouym.eq(pJyuutouYm);

        return exDBEntityManager.createJPQL(quertSql).bind(qIT_AnsyuRireki).getSingleResult();
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public IT_Kouza getKouza(IT_KykKihon pKykKihon) {

        IT_Kouza kouza = pKykKihon.getKouza();

        return kouza;
    }

    public void addMultipleUpdateEntity(MultipleEntityUpdater pMultipleEntityUpdater, AbstractExDBEntity<?, ?> pEntity) {

        pMultipleEntityUpdater.add(pEntity);

    }

    public IT_AnsyuRireki createAnsyuRireki(IT_AnsyuKihon pAnsyuKihon) {

        return pAnsyuKihon.createAnsyuRireki();
    }

    public void addMultipleInsertEntity(MultipleEntityInserter pMultipleEntityInserter, AbstractExDBEntity<?, ?> pEntity) {

        pMultipleEntityInserter.add(pEntity);

    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyoNo) {

        return hozenDomManager.getAnsyuKihon(pSyoNo);
    }

    public IT_YykIdouUktk getYykIdouUktk(String pSyono, C_YykidousyoriKbn pYykidousyoriKbn, BizDateYM pSyoriYm) {

        QIT_YykIdouUktk qIT_YykIdouUktk = new QIT_YykIdouUktk("qIT_YykIdouUktk");

        String query = $SELECT + qIT_YykIdouUktk +
            $FROM(qIT_YykIdouUktk) +
            $WHERE + qIT_YykIdouUktk.syono.eq(pSyono) +
            $AND + qIT_YykIdouUktk.yykidousyorikbn.eq(pYykidousyoriKbn) +
            $AND + qIT_YykIdouUktk.syoriym.le(pSyoriYm);

        return  exDBEntityManager.createJPQL(query).bind(qIT_YykIdouUktk).getSingleResult();
    }
}
