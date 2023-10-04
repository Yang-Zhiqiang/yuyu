package yuyu.batch.hozen.khansyuu.khuriageseikyuusel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_CreditCardInfo;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Collections2;

/**
 * 契約保全 案内収納 売上請求データ抽出の機能DAOクラス
 */
public class KhUriageSeikyuuSelDao {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<AnnaiSyuunouDataBean> getAnnaiSyuunouDataBean(String pKakutyoujobcd, BizDateYM pSyoriym,
        String pKbnkey) {

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_CreditCardInfo qIT_CreditCardInfo = new QIT_CreditCardInfo("qIT_CreditCardInfo");

        String query = $SELECT + $NEW(AnnaiSyuunouDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_AnsyuKihon.jkipjytym,
            qIT_AnsyuKihon.syuharaimanymd,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykKihon.hrkkeiro,
            qIT_KykKihon.tikiktbrisyuruikbn,
            qIT_KykSyouhn.syouhncd,
            qIT_CreditCardInfo.creditkessaiyouno,
            qIT_CreditCardInfo.credityuukoukakym,
            qIT_CreditCardInfo.credityuukoukakkekka) +
            $FROM(qIT_AnsyuKihon,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_CreditCardInfo);
        if (!BizUtil.isBlank(pKbnkey)) {
            query += $WHERE + qIT_AnsyuKihon.kbnkey.eq(pKbnkey) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_CreditCardInfo.syono);
        }

        else {
            query += $WHERE + qIT_AnsyuKihon.syono.eq(qIT_CreditCardInfo.syono);
        }
        query += $AND + qIT_AnsyuKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_AnsyuKihon.jkipjytym.le(pSyoriym) +
            $AND + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.CREDIT) +
            $AND + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.TUKI) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
            $AND + qIT_CreditCardInfo.credityuukoukakym.le(pSyoriym) +
            $AND + qIT_CreditCardInfo.credityuukoukakkekka.eq(C_Yuukoukakkekka.YUUKOUKAK_OK) +
            $AND + qIT_AnsyuKihon.syuharaimanymd.substring(1, 6).gt(qIT_AnsyuKihon.jkipjytym.substring(1, 6));


        ExDBResults<AnnaiSyuunouDataBean> exDBResults = exDBEntityManager
            .createJPQL(query, AnnaiSyuunouDataBean.class)
            .bind(qIT_AnsyuKihon, qIT_KykKihon, qIT_KykSyouhn, qIT_CreditCardInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_YykIdouUktk getYykIdouUktk(String pSyono, BizDateYM pSyoriYm) {

        QIT_YykIdouUktk qIT_YykIdouUktk = new QIT_YykIdouUktk("qIT_YykIdouUktk");

        String query = $SELECT + qIT_YykIdouUktk +
            $FROM(qIT_YykIdouUktk) +
            $WHERE + qIT_YykIdouUktk.syono.eq(pSyono) +
            $AND + qIT_YykIdouUktk.yykidousyorikbn.eq(C_YykidousyoriKbn.UKE) +
            $AND + qIT_YykIdouUktk.syoriym.le(pSyoriYm) +
            $ORDER_BY(qIT_YykIdouUktk.syoriym.asc());

        return exDBEntityManager.createJPQL(query).setFirstResult(0).setMaxResults(1).bind(qIT_YykIdouUktk)
            .getSingleResult();
    }

    public Integer getAnsyuRirekiMaxAnnaino(String pSyono, BizDateYM pJyuutouYm) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        List<IT_AnsyuRireki> ansyuRirekiList = ansyuKihon.getAnsyuRirekis();

        if (ansyuRirekiList.size() == 0) {

            return null;
        }

        FilterAnsyuRirekiByJyuutouym filterAnsyuRirekiByJyuutouym = new FilterAnsyuRirekiByJyuutouym(pJyuutouYm);

        ansyuRirekiList = new ArrayList<IT_AnsyuRireki>(Collections2.filter(ansyuRirekiList,
            filterAnsyuRirekiByJyuutouym));

        if (ansyuRirekiList.size() == 0) {

            return null;
        }

        SortKhUriageSeikyuuSel sortKhUriageSeikyuuSel = SWAKInjector.getInstance(SortKhUriageSeikyuuSel.class);

        List<IT_AnsyuRireki> sortAnsyuRirekiList = sortKhUriageSeikyuuSel.OrderIT_AnsyuRirekiByAnnainoDesc(ansyuRirekiList);

        Integer annainoMax = sortAnsyuRirekiList.get(0).getAnnaino();

        return annainoMax;
    }
}
