package yuyu.common.hozen.khcommon.dba4hanteilinc;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.meta.QBM_Address;

/**
 * 契約保全 契約保全共通 ＬＩＮＣ該当判定Daoクラス
 */
public class HanteiLincDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_Address getAddressByPostalCd(String pPostalCd) {

        QBM_Address qBM_Address = new QBM_Address("qBM_Address");

        String strSpl = $SELECT + qBM_Address +
            $FROM(qBM_Address) +
            $WHERE + qBM_Address.postalCd.eq(pPostalCd) +
            $AND + qBM_Address.kihontikucdsyoumetukbn.eq(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        return exDBEntityManager.createJPQL(strSpl).bind(qBM_Address).getSingleResult();
    }
}
