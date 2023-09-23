package yuyu.common.hozen.khcommon.dba4hasseijikzieditshrtyousyotbl;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QIT_KhTyousyo;

/**
 * 契約保全 契約保全共通 発生時課税支払調書TBL編集
 */
public class HasseijikziEditShrtyousyotblDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getShrtysyrennoBySyonoTyouhyouymd(String pSyono, BizDate pTyouhyouymd) {

        QIT_KhTyousyo qIT_KhTyousyo = new QIT_KhTyousyo("QIT_KhTyousyo");

        String strSql = $SELECT + $MAX(qIT_KhTyousyo.shrtysyrenno) + $AS + "shrtysyrenno" +
            $FROM (qIT_KhTyousyo) +
            $WHERE + qIT_KhTyousyo.syono.eq(pSyono) +
            $AND + qIT_KhTyousyo.tyouhyouymd.eq(pTyouhyouymd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTyousyo).getSingleResult();
    }
}
