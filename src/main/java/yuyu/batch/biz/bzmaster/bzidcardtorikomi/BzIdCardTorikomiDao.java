package yuyu.batch.biz.bzmaster.bzidcardtorikomi;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QBW_IdCardWk;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（ＩＤカードマスタ）DAOクラスです。
 */
public class BzIdCardTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateIdCard() {

        String sql = "delete from AM_IdCard";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void truncateIdCardWk() {
        String sql = "delete from BW_IdCardWk";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void deleteIdCardWk() {

        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();

        String strSql = $DELETE_FROM(qBW_IdCardWk);

        exDBEntityManager.createJPQL(strSql).bind(qBW_IdCardWk).executeUpdate();
    }


}
