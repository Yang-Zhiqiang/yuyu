package yuyu.batch.direct.dskokyakukanri.dskaripasswordtuutisakusei;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiTy;

/**
 * 仮パスワード通知作成DAOクラスです。
 */
public class DsKariPasswordTuutiSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void truncateDsKariPasswordTuutiTy() {

        QZT_DsKariPasswordTuutiTy qZT_DsKariPasswordTuutiTy = new QZT_DsKariPasswordTuutiTy();

        String querySql = $DELETE_FROM(qZT_DsKariPasswordTuutiTy);

        exDBEntityManager.createJPQL(querySql).bind(qZT_DsKariPasswordTuutiTy).executeUpdate();
    }

    public void deleteDsKariPasswordTuutiTy() {

        QZT_DsKariPasswordTuutiTy qZT_DsKariPasswordTuutiTy = new QZT_DsKariPasswordTuutiTy();

        String querySql = $DELETE_FROM(qZT_DsKariPasswordTuutiTy);

        exDBEntityManager.createJPQL(querySql).bind(qZT_DsKariPasswordTuutiTy).executeUpdate();
    }
}
