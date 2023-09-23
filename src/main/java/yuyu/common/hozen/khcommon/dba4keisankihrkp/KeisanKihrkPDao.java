package yuyu.common.hozen.khcommon.dba4keisankihrkp;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_Zennou;

/**
 * 契約保全 契約保全共通 既払込Ｐ計算 Daoクラス
 */
public class KeisanKihrkPDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_Zennou> getZennous(String pSyono) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("qIT_Zennou");

        String strSql = $SELECT + qIT_Zennou +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.syono.eq(pSyono)+
            $ORDER_BY(
                qIT_Zennou.zennoukaisiymd.asc(),
                qIT_Zennou.renno.asc()
                );

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Zennou).getResultList();
    }
}
