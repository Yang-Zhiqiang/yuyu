package yuyu.app.hozen.khozen.khtoujituonlinetorikesi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktk;

/**
 * 契約保全 契約保全 契約保全当日オンライン取消機能DAOクラス
 */
public class KhToujituOnlineTorikesiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KhHenkouUktk> getKhHenkouUktksBySyonoGyoumuKousinTime(String pSyono, String pGyoumuKousinTime) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + qIT_KhHenkouUktk +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.gyoumuKousinTime.gt(pGyoumuKousinTime);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk).getResultList();

    }
}
