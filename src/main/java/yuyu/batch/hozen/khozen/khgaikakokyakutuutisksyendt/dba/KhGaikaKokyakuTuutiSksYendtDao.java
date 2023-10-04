package yuyu.batch.hozen.khozen.khgaikakokyakutuutisksyendt.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.hozen.result.bean.GaikaKokyakuTuutiInfosByKakutyoujobcdBean;

/**
 * 契約保全 契約保全 外貨建顧客通知作成（円建変更後）DAOクラス
 */
public class KhGaikaKokyakuTuutiSksYendtDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;

    public ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> getGaikaKokyakuTuutiInfosByKakutyoujobcd(String pKakutyouJobCd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String mainStr = $SELECT + $NEW(GaikaKokyakuTuutiInfosByKakutyoujobcdBean.class,
            qIT_KykKihon,
            qIT_KykSyouhn) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.kyktuukasyu.eq(C_Tuukasyu.JPY);

        ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> exDBResults = exDBEntityManager.createJPQL(
            mainStr, GaikaKokyakuTuutiInfosByKakutyoujobcdBean.class).bind(qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<KhHenkouUktkBean> getKhHenkouUktkBySyono(String pSyono){

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $NEW(KhHenkouUktkBean.class,
            qIT_KhHenkouUktk.uktksyorikbn,
            qIT_KhHenkouUktk.uktkjyoutaikbn) +
            $FROM (qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + $(qIT_KhHenkouUktk.uktkjyoutaikbn.ne(C_UktkJyoutaiKbn.SYORIZUMI) +
                $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.ne(C_UktkJyoutaiKbn.TORIKESI));

        return exDBEntityManager.createJPQL(strSql, KhHenkouUktkBean.class).bind(qIT_KhHenkouUktk).getResultList();
    }
}