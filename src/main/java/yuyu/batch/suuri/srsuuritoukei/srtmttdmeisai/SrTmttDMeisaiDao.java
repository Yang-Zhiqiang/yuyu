package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknTmttd;

/**
 * 数理統計 数理統計 積立配当金明細情報作成DAOクラス
 */
public class SrTmttDMeisaiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<ST_YuukoukykHtjynbknTmttd> getTmttDMeisai(BizDate pKijyunymd, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknTmttd qST_YuukoukykHtjynbknTmttd = new QST_YuukoukykHtjynbknTmttd(
            "qST_YuukoukykHtjynbknTmttd");

        String queryStr = $SELECT + qST_YuukoukykHtjynbknTmttd +
            $FROM(qST_YuukoukykHtjynbknTmttd) +
            $WHERE + qST_YuukoukykHtjynbknTmttd.srkijyunym.eq(pKijyunymd.getBizDateYM().toString()) +
            $AND + qST_YuukoukykHtjynbknTmttd.kakutyoujobcd.eq(pKakutyoujobcd);

        return exDBEntityManager.createJPQL(queryStr).bind(qST_YuukoukykHtjynbknTmttd).getResults();
    }
}
