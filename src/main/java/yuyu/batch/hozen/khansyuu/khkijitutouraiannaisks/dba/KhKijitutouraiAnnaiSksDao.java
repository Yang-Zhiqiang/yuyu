package yuyu.batch.hozen.khansyuu.khkijitutouraiannaisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納 期日到来案内作成Daoクラス
 */
public class KhKijitutouraiAnnaiSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<KijitutouraiAnnaiSksTaisyouDataBean> getKijitutouraiAnnaiSksTaisyouDataBean(BizDateYM pSyoriYm,
        String pKakutyoujobcd) {

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(KijitutouraiAnnaiSksTaisyouDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.tikiktbrisyuruikbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName()) +
            $FROM(qIT_AnsyuKihon,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.KOUHURI) +
                $AND + "(" + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.HALFY) +
                $OR + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.NEN) +
                $OR  + "(" + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.TUKI) +
                $AND + "(" + qIT_KykKihon.tikiktbrisyuruikbn.eq
                (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS) +
                $OR + qIT_KykKihon.tikiktbrisyuruikbn.eq
                (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS) + ")))" +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_AnsyuKihon.syuharaimanymd.substring(1, 6)
                .gt(qIT_AnsyuKihon.jkipjytym.substring(1, 6)) +
                $AND + qIT_AnsyuKihon.jkipjytym.eq(pSyoriYm);

        ExDBResults<KijitutouraiAnnaiSksTaisyouDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, KijitutouraiAnnaiSksTaisyouDataBean.class)
            .bind(qIT_AnsyuKihon, qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_KykKihon getKykKihon(String pSyono){
        return hozenDomManager.getKykKihon(pSyono);
    }

    public IT_KykSya getKykSya(IT_KykKihon pKykKihon){
        return pKykKihon.getKykSya();
    }

    public IT_HhknSya getHhknSya(IT_KykKihon pKykKihon){
        return pKykKihon.getHhknSya();
    }

    public IT_Kouza getKouza(IT_KykKihon pKykKihon){
        return pKykKihon.getKouza();
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);
        return syouhnZokusei;
    }

    public void addInsertEntity(EntityInserter<IT_KijituTouraiAnnai> pInserter, IT_KijituTouraiAnnai pKijituTouraiAnnai) {
        pInserter.add(pKijituTouraiAnnai);
    }

}
