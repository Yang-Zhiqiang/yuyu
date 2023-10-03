package yuyu.batch.suuri.srsuuritoukei.srsp2rnduyusouseiritu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;
import yuyu.def.db.meta.QSV_Sp2RnduyuSouseiritu;

/**
 * ＳＰ２連動用総成立情報作成Daoクラスです。
 */
public class SrSp2RnduyuSouseirituDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_Sp2RnduyuSouseiritu> getSp2RnduyuSouseiritusBySeisekiymSeiritukbn(BizDateYM pSeisekiym, C_SeirituKbn pSeiritukbn) {

        QSV_Sp2RnduyuSouseiritu qSV_Sp2RnduyuSouseiritu = new QSV_Sp2RnduyuSouseiritu();

        String strSql = $SELECT + qSV_Sp2RnduyuSouseiritu +
            $FROM + qSV_Sp2RnduyuSouseiritu.SV_Sp2RnduyuSouseiritu() +
            $WHERE + qSV_Sp2RnduyuSouseiritu.seisekiym.eq(pSeisekiym) +
            $AND + qSV_Sp2RnduyuSouseiritu.seiritukbn.eq(pSeiritukbn);

        return exDBEntityManager.createJPQL(strSql).bind(qSV_Sp2RnduyuSouseiritu).getResults();
    }
}
