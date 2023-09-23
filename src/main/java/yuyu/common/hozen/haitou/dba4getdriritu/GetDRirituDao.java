package yuyu.common.hozen.haitou.dba4getdriritu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BM_HaitouRiritu;
import yuyu.def.db.meta.QBM_HaitouRiritu;

/**
 * 業務共通 業務共通 配当利率取得の機能DAOクラス
 */
public class GetDRirituDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_HaitouRiritu> getHaitouRirituByPK(BizDate pCalcKijyunfromymd, BizDate pCalcKijyuntoymd) {

        QBM_HaitouRiritu qBM_HaitouRiritu = new QBM_HaitouRiritu
            ("qBM_HaitouRiritu");

        String strSql = $SELECT + qBM_HaitouRiritu +
            $FROM(qBM_HaitouRiritu) +
            $WHERE + qBM_HaitouRiritu.kijyunfromymd.le(pCalcKijyuntoymd) +
            $AND + qBM_HaitouRiritu.kijyuntoymd.ge(pCalcKijyunfromymd) +
            $ORDER_BY(qBM_HaitouRiritu.kijyunfromymd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_HaitouRiritu).getResultList();
    }

}
