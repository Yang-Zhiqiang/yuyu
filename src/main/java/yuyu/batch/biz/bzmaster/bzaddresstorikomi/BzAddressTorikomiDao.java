package yuyu.batch.biz.bzmaster.bzaddresstorikomi;

import javax.inject.Inject;

import yuyu.def.db.meta.QBM_Address;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * マスタ取込（住所マスタ）DAOクラスです。
 */
public class BzAddressTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateAddress() {

        String strSql = "delete from BM_Address";

        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteAddress() {
        QBM_Address qBM_Address = new QBM_Address();

        String strSql = $DELETE_FROM(qBM_Address);

        exDBEntityManager.createJPQL(strSql).bind(qBM_Address).executeUpdate();
    }
}
