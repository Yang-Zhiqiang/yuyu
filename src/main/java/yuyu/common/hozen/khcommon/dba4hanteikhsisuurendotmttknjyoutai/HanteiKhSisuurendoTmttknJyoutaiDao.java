package yuyu.common.hozen.khcommon.dba4hanteikhsisuurendotmttknjyoutai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import javax.inject.Inject;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;

/**
 * 契約保全 契約保全共通 指数連動積増型年金積立金状態判定の機能DAOクラス
 */
public class HanteiKhSisuurendoTmttknJyoutaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public long getSisuurendoTmttknCountBySyonoTmttkntaisyouym(
        String pSyono, BizDateYM pTmttknTaisyouym) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM (qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttkntaisyouym.eq(pTmttknTaisyouym);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhSisuurendoTmttkn).getSingleResult();
    }

    public long getSisuurendoTmttknCountBySyonoTmttknkouryokukaisiymd(String pSyono, BizDate pTmttknKouryokuKaisiymd) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM (qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.gt(pTmttknKouryokuKaisiymd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhSisuurendoTmttkn).getSingleResult();
    }
}
