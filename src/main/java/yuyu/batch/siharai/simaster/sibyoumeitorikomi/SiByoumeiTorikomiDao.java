package yuyu.batch.siharai.simaster.sibyoumeitorikomi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QJM_Byoumei;

/**
 * 病名マスタ取込DAOクラスです。
 */
public class SiByoumeiTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateByoumei() {

        String sql = "delete from JM_Byoumei";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void deleteByoumei() {
        QJM_Byoumei qJM_Byoumei = new QJM_Byoumei();

        String strSql = $DELETE_FROM(qJM_Byoumei);

        exDBEntityManager.createJPQL(strSql).bind(qJM_Byoumei).executeUpdate();
    }
}
