package yuyu.batch.biz.bzmaster.bzkinyuukikanhuhoyohuriinfotorikomi;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBM_KinyuuKikanHuhoyofuriInfo;

/**
 * マスタ取込（金融機関普保預振マスタ）DAOクラスです。
 */
public class BzKinyuuKikanHuhoyohuriInfoTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void deleteKinyuuKikanHuhoyohuriInfo() {
        QBM_KinyuuKikanHuhoyofuriInfo qBM_KinyuuKikanHuhoyohuriInfo = new QBM_KinyuuKikanHuhoyofuriInfo();

        String strSql = $DELETE_FROM(qBM_KinyuuKikanHuhoyohuriInfo);

        exDBEntityManager.createJPQL(strSql).bind(qBM_KinyuuKikanHuhoyohuriInfo).executeUpdate();
    }

}
