package yuyu.batch.biz.bzmaster.bzsisuutorikomi;

import javax.inject.Inject;

import yuyu.def.db.meta.QZT_SisuuRendouRn;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（指数マスタ）DAOクラスです。
 */
public class BzSisuuTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public Long getSisuuRendouRnCount() {
        QZT_SisuuRendouRn qZT_SisuuRendouRn = new QZT_SisuuRendouRn("qZT_SisuuRendouRn");

        String strSql = $SELECT + $COUNT(qZT_SisuuRendouRn.zrntorikomiyousisuukbn) +
            $FROM (qZT_SisuuRendouRn);

        return exDBEntityManager.createJPQL(strSql).bind(qZT_SisuuRendouRn).getSingleResult();
    }
}
