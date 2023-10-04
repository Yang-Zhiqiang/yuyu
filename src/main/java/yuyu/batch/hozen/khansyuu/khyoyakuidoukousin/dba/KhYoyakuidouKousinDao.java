package yuyu.batch.hozen.khansyuu.khyoyakuidoukousin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Iterables;

/**
 * 契約保全 案内収納 予約異動更新処理Daoクラス
 */
public class KhYoyakuidouKousinDao {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<YykIdouUktkBean> getYykIdouUktkBean(BizDateYM pSyoriYM, String pKakutyouJobCd) {
        QIT_YykIdouUktk qIT_YykIdouUktk = new QIT_YykIdouUktk("q");

        String strSql = $SELECT + $NEW(YykIdouUktkBean.class,
            qIT_YykIdouUktk.syono,
            qIT_YykIdouUktk.kbnkey,
            qIT_YykIdouUktk.henkousikibetukey,
            qIT_YykIdouUktk.kinouId,
            qIT_YykIdouUktk.syoriym,
            qIT_YykIdouUktk.uktkymd ) +
            $FROM + qIT_YykIdouUktk.IT_YykIdouUktk() +
            $WHERE + qIT_YykIdouUktk.yykidousyorikbn.eq(C_YykidousyoriKbn.UKE) +
            $AND + qIT_YykIdouUktk.syoriym.le(pSyoriYM);

        ExDBResults<YykIdouUktkBean> exDBResults = exDBEntityManager.createJPQL(strSql, YykIdouUktkBean.class).bind(qIT_YykIdouUktk).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;


    }

    public IT_KykKihon getKykKihon(String pSyoNo) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        return kykKihon;
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyoNo) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);

        return ansyuKihon;
    }

    public IT_YykIdouNaiyoHrhnk getYykIdouNaiyoHrhnk(IT_KykKihon pKykKihon, String pSikibetukey) {

        IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = pKykKihon.getYykIdouNaiyoHrhnkByHenkousikibetukey(pSikibetukey);

        return yykIdouNaiyoHrhnk;
    }

    public List<IT_KykSyouhn> getKykSyouhn(IT_KykKihon pKykKihon, C_SyutkKbn pSyutkKbn) {

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(pSyutkKbn);

        return kykSyouhnLst;
    }

    public void addMultipleEntityUpdater(MultipleEntityUpdater pEntityUpdater, AbstractExDBEntity<?, ?> pExDBEntity) {

        pEntityUpdater.add(pExDBEntity);
    }

    public void setKouza(IT_KykKihon pKykKihon, IT_Kouza pKouza) {

        pKykKihon.setKouza(pKouza);
    }

    public IT_Kouza createKouza(IT_KykKihon pKykKihon) {

        IT_Kouza kouza = pKykKihon.createKouza();

        return kouza;
    }

    public IT_YykIdouUktk getYykIdouUktks(IT_KykKihon pKykKihon, String pSikibetukey, String pKinouId) {

        List<IT_YykIdouUktk> yykIdouUktkLst = pKykKihon.getYykIdouUktks();

        return Iterables.getFirst(Iterables.filter(yykIdouUktkLst,
            new FilterYykIdouUktk1(pSikibetukey, pKinouId)), null);
    }

    public IT_KhTtdkRireki createKhTtdkRireki(IT_KykKihon pKykKihon) {

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.createKhTtdkRireki();

        return khTtdkRireki;
    }

    public IT_Kouza getKouza(IT_KykKihon pKykKihon) {

        return pKykKihon.getKouza();
    }

    public Long getAnsyuRirekiCount(String pSyono, BizDateYM pJyuutouym) {

        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strSql =  $SELECT + $COUNT + "(*)" +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND + qIT_AnsyuRireki.jyuutouym.le(pJyuutouym) +
            $AND + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.ANNAI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AnsyuRireki).getSingleResult();
    }
}
