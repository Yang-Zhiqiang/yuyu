package yuyu.batch.hozen.khozen.khbatchmkhgkhenkou.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QIT_KhHenkouUktk;

/**
 * 契約保全 契約保全 バッチ目標額変更の機能DAOクラスです
 */
public class KhBatchMkhgkhenkouDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhHenkouUktkBean> getKhHenkouUktkBeans(String pKakutyoujobCd, BizDate pUktkYmd) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $NEW(KhHenkouUktkBean.class,
            qIT_KhHenkouUktk.kbnkey,
            qIT_KhHenkouUktk.syono,
            qIT_KhHenkouUktk.hozenhenkouuktkrenno,
            qIT_KhHenkouUktk.uktkymd,
            qIT_KhHenkouUktk.tourokuroute,
            qIT_KhHenkouUktk.uktksyorikbn,
            qIT_KhHenkouUktk.kouryokuhasseiymd,
            qIT_KhHenkouUktk.syoriyoteiymd,
            qIT_KhHenkouUktk.uktkjyoutaikbn) +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.uktkymd.eq(pUktkYmd) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.MKHGKHNK) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI) +
            $ORDER_BY(qIT_KhHenkouUktk.syono.asc());

        ExDBResults<KhHenkouUktkBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhHenkouUktkBean.class)
            .bind(qIT_KhHenkouUktk).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobCd));

        return exDBResults;
    }
}
