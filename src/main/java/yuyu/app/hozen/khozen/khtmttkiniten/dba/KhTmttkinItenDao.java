package yuyu.app.hozen.khozen.khtmttkiniten.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktk;

/**
 * 契約保全 契約保全 積立金移転機能DAOクラス
 */
public class KhTmttkinItenDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public IT_KhHenkouUktk getHenkouUktkBySyonoUktksyorikbnUktkjyoutaikbn(String pSyono, C_UktkSyoriKbn pUktkSyoriKbn,
        C_UktkJyoutaiKbn pUktkJyoutaiKbn) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + qIT_KhHenkouUktk +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(pUktkSyoriKbn) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(pUktkJyoutaiKbn);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk).getSingleResult();

    }
}
