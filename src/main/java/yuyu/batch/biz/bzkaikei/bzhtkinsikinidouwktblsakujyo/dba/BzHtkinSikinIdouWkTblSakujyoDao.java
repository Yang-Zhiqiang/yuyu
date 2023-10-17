package yuyu.batch.biz.bzkaikei.bzhtkinsikinidouwktblsakujyo.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBW_HtkinSikinIdouWk;

/**
 * 業務共通 経理･会計 配当金資金移動ワークテーブル削除機能DAOクラスです。<br />
 */
public class BzHtkinSikinIdouWkTblSakujyoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public int delAllHtkinSikinIdouWk() {

        QBW_HtkinSikinIdouWk qBW_HtkinSikinIdouWk = new QBW_HtkinSikinIdouWk("qBW_HtkinSikinIdouWk");

        String sql = $DELETE_FROM(qBW_HtkinSikinIdouWk) +
            $WHERE + qBW_HtkinSikinIdouWk.syono.isNotNull();

        return exDBEntityManager.createJPQL(sql).bind(qBW_HtkinSikinIdouWk).executeUpdate();
    }

}
