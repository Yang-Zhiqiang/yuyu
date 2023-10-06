package yuyu.batch.biz.bzkaikei.bzskhurikaedentbljouhouhuka;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.meta.QBT_SinkeiyakuHurikaeDen;

/**
 * 新契約振替伝票テーブル情報付加処理（BzSkHurikaeDenTblJouhouHuka）のDAOクラスです。<br />
 */
public class BzSkHurikaeDenTblJouhouHukaDao {

    @Inject
    ExDBEntityManager em;

    public ExDBUpdatableResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd, String pKakutyoujobcd) {

        QBT_SinkeiyakuHurikaeDen qBT_SinkeiyakuHurikaeDen = new QBT_SinkeiyakuHurikaeDen();

        String strSql =$SELECT + qBT_SinkeiyakuHurikaeDen +
            $FROM + qBT_SinkeiyakuHurikaeDen.BT_SinkeiyakuHurikaeDen() +
            $WHERE + qBT_SinkeiyakuHurikaeDen.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qBT_SinkeiyakuHurikaeDen.denymd.asc(),
                qBT_SinkeiyakuHurikaeDen.huridenatesakicd.asc(),
                qBT_SinkeiyakuHurikaeDen.huridenpyoukyktuukakbn.asc(),
                qBT_SinkeiyakuHurikaeDen.tuukasyu.asc(),
                qBT_SinkeiyakuHurikaeDen.dengyoumucd.asc());

        ExDBUpdatableResults<BT_SinkeiyakuHurikaeDen> exDBResults = em.createJPQL(strSql).bind(qBT_SinkeiyakuHurikaeDen).getUpdatableResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
        return exDBResults;
    }
}
