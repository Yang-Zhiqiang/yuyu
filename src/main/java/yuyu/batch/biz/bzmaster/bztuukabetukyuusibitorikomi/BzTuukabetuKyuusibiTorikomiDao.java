package yuyu.batch.biz.bzmaster.bztuukabetukyuusibitorikomi;

import javax.inject.Inject;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（通貨別取扱休止日マスタ）DAOクラスです。
 */
public class BzTuukabetuKyuusibiTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateTuukabetuKyuusibi() {

        String strSql = "truncate table BM_TuukabetuKyuusibi";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }
}
