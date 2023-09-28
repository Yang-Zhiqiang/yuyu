package yuyu.common.biz.bzunyo;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBM_TestSyonokanri;

/**
 * テストデータ変換DAO クラスです。
 */
public class ConvertTestDataDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public Integer getTestSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(String pSeirekinen2keta,String pBosyuusosikicd) {
        QBM_TestSyonokanri qBM_TestSyonokanri = new QBM_TestSyonokanri("qBM_TestSyonokanri");

        String strSql = $SELECT + $MAX(qBM_TestSyonokanri.syonorenno) +
            $FROM (qBM_TestSyonokanri) +
            $WHERE + qBM_TestSyonokanri.seirekinen2keta.eq(pSeirekinen2keta) +
            $AND + qBM_TestSyonokanri.bosyuusosikicd.eq(pBosyuusosikicd);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_TestSyonokanri).getSingleResult();
    }
}