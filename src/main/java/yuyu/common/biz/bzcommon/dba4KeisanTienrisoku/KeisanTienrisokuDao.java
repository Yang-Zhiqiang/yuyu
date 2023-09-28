package yuyu.common.biz.bzcommon.dba4KeisanTienrisoku;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QBM_TienrisokuRiritu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 業務共通 業務共通 遅延利息利率取得の機能DAOクラス
 */
public class KeisanTienrisokuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BizNumber getTienrisokuRiritu(BizDate pRisokukeisanymd) {

        QBM_TienrisokuRiritu qBM_TienrisokuRiritu = new QBM_TienrisokuRiritu("qBM_TienrisokuRiritu");

        String strSql = $SELECT + qBM_TienrisokuRiritu.tienrisokuriritu +
            $FROM (qBM_TienrisokuRiritu) +
            $WHERE + qBM_TienrisokuRiritu.tekiyoukknfrom.le(pRisokukeisanymd.toString()) +
            $AND + qBM_TienrisokuRiritu.tekiyoukknkto.ge(pRisokukeisanymd.toString());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_TienrisokuRiritu).getSingleResult();
    }
}
