package yuyu.batch.biz.bzkaikei.bzsinkeiyakuhurikaedentblsks;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBT_SinkeiyakuHurikaeDen;

/**
 * 新契約振替伝票テーブル作成処理DAOクラスです。
 */
public class BzSinkeiyakuHurikaeDenTblSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public int deleteSinkeiyakuHurikaeDensBySyoriYmd(BizDate pSyoriYmd) {

        QBT_SinkeiyakuHurikaeDen qBT_SinkeiyakuHurikaeDen = new QBT_SinkeiyakuHurikaeDen();

        String strSql = $DELETE_FROM(qBT_SinkeiyakuHurikaeDen) +
                $WHERE + qBT_SinkeiyakuHurikaeDen.syoriYmd.lt(pSyoriYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qBT_SinkeiyakuHurikaeDen).executeUpdate();
    }
}
