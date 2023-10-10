package yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import yuyu.def.db.meta.QBV_HjybruikeigakuData;

/**
 * 補助簿累計額入力（BzHojyoboRuikeigakuNyuuryoku）のDAOクラスです。<br />
 */
public class BzHojyoboRuikeigakuNyuuryokuDao {

    @Inject
    ExDBEntityManager em;

    public List<BV_HjybruikeigakuData> getHjybruikeigakuDataByHjybtantositucd(String pHjybtantositucd) {

        QBV_HjybruikeigakuData qBV_HjybruikeigakuData = new QBV_HjybruikeigakuData();

        String strSql = $SELECT + qBV_HjybruikeigakuData +
            $FROM + qBV_HjybruikeigakuData.BV_HjybruikeigakuData() +
            $WHERE + qBV_HjybruikeigakuData.hjybtantositucd.eq(pHjybtantositucd) +
            $ORDER_BY (qBV_HjybruikeigakuData.kanjyoukmkcd.asc());
        return em.createJPQL(strSql).bind(qBV_HjybruikeigakuData).getResultList();
    }
}
