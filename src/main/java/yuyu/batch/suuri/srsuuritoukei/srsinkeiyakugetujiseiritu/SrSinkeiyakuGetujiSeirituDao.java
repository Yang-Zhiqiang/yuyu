package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakugetujiseiritu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.meta.QSV_SnkiykGtjSirt;

/**
 * 新契約決算ベース月次成立情報作成DAOクラスです。
 */
public class SrSinkeiyakuGetujiSeirituDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_SnkiykGtjSirt> getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn(BizDateYM pSkeikeijyouym, C_SeirituKbn pSeiritukbn) {

        QSV_SnkiykGtjSirt qSV_SnkiykGtjSirt = new QSV_SnkiykGtjSirt();

        String strSql = $SELECT + qSV_SnkiykGtjSirt +
            $FROM + qSV_SnkiykGtjSirt.SV_SnkiykGtjSirt() +
            $WHERE + qSV_SnkiykGtjSirt.skeikeijyouym.eq(pSkeikeijyouym) +
            $AND + qSV_SnkiykGtjSirt.seiritukbn.eq(pSeiritukbn);

        return exDBEntityManager.createJPQL(strSql).bind(qSV_SnkiykGtjSirt).getResults();
    }
}
