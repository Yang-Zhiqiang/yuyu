package yuyu.batch.suuri.srkessan.srskkessandataretentionperiod;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QST_SkKessanSyukei;
import yuyu.def.db.meta.QST_SkOikmSyukeiPDenpyou;
import yuyu.def.db.meta.QST_SkOikmTyouseiDenpyou;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 新契約決算用データ保存期間管理DAOクラスです。
 */
public class SrSkKessanDataRetentionPeriodDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateSkOikmTyouseiDenpyou() {
        String sql = "truncate table ST_SkOikmTyouseiDenpyou";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void deleteSkOikmTyouseiDenpyou() {

        QST_SkOikmTyouseiDenpyou qST_SkOikmTyouseiDenpyou = new QST_SkOikmTyouseiDenpyou();

        String strSql = $DELETE_FROM(qST_SkOikmTyouseiDenpyou);

        exDBEntityManager.createJPQL(strSql).bind(qST_SkOikmTyouseiDenpyou).executeUpdate();
    }

    public void truncateSkOikmSyukeiPDenpyou() {

        String sql = "truncate table ST_SkOikmSyukeiPDenpyou";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void deleteSkOikmSyukeiPDenpyou() {

        QST_SkOikmSyukeiPDenpyou qST_SkOikmSyukeiPDenpyou = new QST_SkOikmSyukeiPDenpyou();

        String strSql = $DELETE_FROM(qST_SkOikmSyukeiPDenpyou);

        exDBEntityManager.createJPQL(strSql).bind(qST_SkOikmSyukeiPDenpyou).executeUpdate();
    }

    public int deleteSkKessanSyukeisBySyoriYmd(BizDate pSyoriYmd) {

        QST_SkKessanSyukei qST_SkKessanSyukei = new QST_SkKessanSyukei();

        String sql = $DELETE_FROM(qST_SkKessanSyukei) +
            $WHERE + qST_SkKessanSyukei.syoriYmd.lt(pSyoriYmd);

        return exDBEntityManager.createJPQL(sql).bind(qST_SkKessanSyukei).executeUpdate();
    }
}
