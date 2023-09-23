package yuyu.common.hozen.khcommon.dba4keisanhtykeihi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;

/**
 * 契約保全 契約保全共通 必要経費計算 Daoクラス
 */
public class KeisanHtyKeihiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public KihrkmpSeisanRirekiBean getKihrkmpSeisanRirekiBean(String pSyono, String pGyoumuKousinTime) {

        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        String strSql = $SELECT + $NEW(KihrkmpSeisanRirekiBean.class,
            qIT_KihrkmpSeisanRireki.hituyoukeihiitijisytktysgk.getTypeFieldName(),
            $SUM + $(qIT_KihrkmpSeisanRireki.hituyoukeihiitijisytktysgk.getValueFieldName()))+
            $FROM(qIT_KihrkmpSeisanRireki) +
            $WHERE + qIT_KihrkmpSeisanRireki.syono.eq(pSyono) +
            $AND + qIT_KihrkmpSeisanRireki.gyoumuKousinTime.ge(pGyoumuKousinTime) +
            $GROUP_BY + qIT_KihrkmpSeisanRireki.syono + "," +
            qIT_KihrkmpSeisanRireki.hituyoukeihiitijisytktysgk.getTypeFieldName();

        return exDBEntityManager.createJPQL(strSql, KihrkmpSeisanRirekiBean.class).setFirstResult(0).setMaxResults(1)
            .bind(qIT_KihrkmpSeisanRireki).getSingleResult();
    }
}
