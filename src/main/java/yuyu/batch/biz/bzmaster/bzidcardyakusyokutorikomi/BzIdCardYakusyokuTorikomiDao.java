package yuyu.batch.biz.bzmaster.bzidcardyakusyokutorikomi;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QBW_IdCardYakusyokuWk;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（ＩＤカード役職マスタ）DAOクラスです。
 */
public class BzIdCardYakusyokuTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateIdCardYakusyoku() {

        String sql = "delete from AM_IdCardYakusyoku";
        exDBEntityManager.createNativeSQL(sql).executeUpdate();
    }

    public void truncateIdCardYakusyokuWk() {

        String strSql = "delete from BW_IdCardYakusyokuWk";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteIdCardYakusyokuWk() {
        QBW_IdCardYakusyokuWk qBW_IdCardYakusyokuWk = new QBW_IdCardYakusyokuWk();

        String strSql = $DELETE_FROM(qBW_IdCardYakusyokuWk);

        exDBEntityManager.createJPQL(strSql).bind(qBW_IdCardYakusyokuWk).executeUpdate();
    }
}
