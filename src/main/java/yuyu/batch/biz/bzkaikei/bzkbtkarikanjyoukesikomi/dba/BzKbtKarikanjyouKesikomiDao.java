package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoukesikomi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.meta.QBT_KbtKarikanjyou;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 業務共通 経理･会計 個別仮勘定消込DAOクラスです。<br />
 */
public class BzKbtKarikanjyouKesikomiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KbtKarikanjyouKesikomiDataBean> getKbtKarikanjyouKesikomiByTaisyakuKbn(C_TaisyakuKbn pTaisyakukbn) {

        QBT_KbtKarikanjyou qBT_KbtKarikanjyou = new QBT_KbtKarikanjyou("qBT_KbtKarikanjyou");

        String sql = $SELECT + $NEW(KbtKarikanjyouKesikomiDataBean.class,
            qBT_KbtKarikanjyou.kbtkarikanjyouskbtkey,
            qBT_KbtKarikanjyou.kanjyoukmkcd,
            qBT_KbtKarikanjyou.keirisyono,
            qBT_KbtKarikanjyou.denyenkagk.getTypeFieldName(),
            qBT_KbtKarikanjyou.denyenkagk.getValueFieldName()) +
            $FROM(qBT_KbtKarikanjyou) +
            $WHERE + qBT_KbtKarikanjyou.taisyakukbn.eq(pTaisyakukbn) +
            $AND + qBT_KbtKarikanjyou.kskmkanryouymd.isNull()  +
            $ORDER_BY(qBT_KbtKarikanjyou.kanjyoukmkcd.asc(),
                qBT_KbtKarikanjyou.keirisyono.asc(),
                qBT_KbtKarikanjyou.denyenkagk.asc(),
                qBT_KbtKarikanjyou.denrenno.asc());

        return exDBEntityManager.createJPQL(sql, KbtKarikanjyouKesikomiDataBean.class)
            .bind(qBT_KbtKarikanjyou).getResults();
    }
}
