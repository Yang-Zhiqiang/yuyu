package yuyu.batch.biz.kaikei.bzhurikaedentblsks;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBT_HuriDenpyou;

/**
 * 振替伝票テーブル作成処理DAOクラスです。<br />
 */
public class BzHurikaeDenTblSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public int deleteHuriDenpyousBySyoriYmd(BizDate pSyoriYmd) {

        QBT_HuriDenpyou qBT_HuriDenpyou = new QBT_HuriDenpyou();

        String strSql = $DELETE_FROM(qBT_HuriDenpyou) +
            $WHERE + qBT_HuriDenpyou.syoriYmd.lt(pSyoriYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qBT_HuriDenpyou).executeUpdate();
    }
}
