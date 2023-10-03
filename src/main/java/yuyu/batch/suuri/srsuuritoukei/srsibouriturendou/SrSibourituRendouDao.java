package yuyu.batch.suuri.srsuuritoukei.srsibouriturendou;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.db.meta.QSV_SibourituRendou;

/**
 * 死亡率用連動情報作成Daoクラスです。
 */
public class SrSibourituRendouDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_SibourituRendou> getSibourituRendousByBosyuuymSeiritukbn(BizDateYM pBosyuuym, C_SeirituKbn pSeiritukbn) {

        QSV_SibourituRendou qSV_SibourituRendou = new QSV_SibourituRendou();

        String strSql = $SELECT + qSV_SibourituRendou +
            $FROM + qSV_SibourituRendou.SV_SibourituRendou() +
            $WHERE + qSV_SibourituRendou.bosyuuym.eq(pBosyuuym) +
            $AND + qSV_SibourituRendou.seiritukbn.eq(pSeiritukbn);

        return exDBEntityManager.createJPQL(strSql).bind(qSV_SibourituRendou).getResults();
    }
}
