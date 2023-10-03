package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakusyuunyuuptoukei;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.meta.QSV_SnkiykSyunyup;

/**
 * 新契約収入Ｐ統計情報DAOクラスです。
 */
public class SrSinkeiyakuSyuunyuupToukeiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_SnkiykSyunyup> getSnkiykSyunyupsBySeiritukbn(C_SeirituKbn pSeiritukbn) {

        QSV_SnkiykSyunyup qSV_SnkiykSyunyup = new QSV_SnkiykSyunyup();

        String strSql = $SELECT + qSV_SnkiykSyunyup +
            $FROM + qSV_SnkiykSyunyup.SV_SnkiykSyunyup() +
            $WHERE + qSV_SnkiykSyunyup.seiritukbn.eq(pSeiritukbn);

        return exDBEntityManager.createJPQL(strSql).bind(qSV_SnkiykSyunyup).getResults();
    }
}
