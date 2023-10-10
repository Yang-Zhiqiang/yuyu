package yuyu.app.hozen.khozen.khkawaserateyoteirrtsyoukai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.meta.QBM_YoteiRiritu3;

/**
 * 契約保全 契約保全 為替レート予定利率推移照会（平準払）DAOクラス
 */
public class KhKawaseRateYoteiRrtSyoukaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_YoteiRiritu3> getYoteiRiritu3List(
        String pSyouhnCd,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd) {

        QBM_YoteiRiritu3 qBM_YoteiRiritu3 = new QBM_YoteiRiritu3
            ("qBM_YoteiRiritu3");

        String strSql = $SELECT + qBM_YoteiRiritu3 +
            $FROM (qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr1.eq(pYoteiriritutkybr1) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr2.eq(pYoteiriritutkybr2) +
            $AND + qBM_YoteiRiritu3.kijyunfromymd.ge(pKijyunfromymd) +
            $AND + qBM_YoteiRiritu3.kijyuntoymd.le(pKijyuntoymd) +
            $ORDER_BY(qBM_YoteiRiritu3.kijyunfromymd.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_YoteiRiritu3).getResultList();
    }
}
