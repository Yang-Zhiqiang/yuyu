package yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakukenti.dba;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakukenti.dba.BzKijituTouraiKeiyakuKentiDao;
import yuyu.def.db.meta.QBT_KijituTouraiHonbanKensyou;

/**
 * 業務共通 システム本番検証用 期日到来契約検知
 */

public class BzKijituTouraiKeiyakuKentiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KijituTouraiHonbanKensyouDataBean> getKijituTouraiHonbanKensyouDataBean(BizDate pSyoriYmd) {

        QBT_KijituTouraiHonbanKensyou qBT_KijituTouraiHonbanKensyou = new QBT_KijituTouraiHonbanKensyou("qBT_KijituTouraiHonbanKensyou");

        String sql = $SELECT_DISTINCT + $NEW(KijituTouraiHonbanKensyouDataBean.class,
            qBT_KijituTouraiHonbanKensyou.subSystemId,
            qBT_KijituTouraiHonbanKensyou.tysytno) +
            $FROM(qBT_KijituTouraiHonbanKensyou) +
            $WHERE + qBT_KijituTouraiHonbanKensyou.syoriYmd.eq(pSyoriYmd);

        return exDBEntityManager.createJPQL(sql, KijituTouraiHonbanKensyouDataBean.class
            ).bind(qBT_KijituTouraiHonbanKensyou).getResults();

    }
}
