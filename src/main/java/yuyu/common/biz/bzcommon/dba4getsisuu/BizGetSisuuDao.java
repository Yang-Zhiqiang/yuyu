package yuyu.common.biz.bzcommon.dba4getsisuu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;


import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.def.db.meta.QBM_Sisuu;

/**
 * 業務共通 業務共通 指数取得の機能DAOクラス
 */
public class BizGetSisuuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_Sisuu getSisuuPreviousByPK(C_Sisuukbn pSisuukbn, BizDate pGetsisuuymd) {

        QBM_Sisuu qBM_Sisuu = new QBM_Sisuu("qBM_Sisuu");

        String strSql = $SELECT + qBM_Sisuu +
            $FROM (qBM_Sisuu) +
            $WHERE + qBM_Sisuu.sisuukbn .eq(pSisuukbn) +
            $AND + qBM_Sisuu.sisuukouhyouymd.le(pGetsisuuymd) +
            $ORDER_BY(qBM_Sisuu.sisuukouhyouymd.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).
            bind(qBM_Sisuu).getSingleResult();
    }
}
