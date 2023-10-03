package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknKarid;

/**
 * 数理統計 数理統計 仮割当配当金明細情報作成DAOクラス
 */
public class SrKariwariateDMeisaiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<ST_YuukoukykHtjynbknKarid> getKariwariateDMeisai(BizDate pKijyunym, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknKarid qST_YuukoukykHtjynbknKarid = new QST_YuukoukykHtjynbknKarid(
            "qST_YuukoukykHtjynbknKarid");

        String queryStr = $SELECT + qST_YuukoukykHtjynbknKarid +
            $FROM(qST_YuukoukykHtjynbknKarid) +
            $WHERE + qST_YuukoukykHtjynbknKarid.srkijyunym.eq(pKijyunym.getBizDateYM().toString()) +
            $AND + qST_YuukoukykHtjynbknKarid.kakutyoujobcd.eq(pKakutyoujobcd);

        return exDBEntityManager.createJPQL(queryStr).bind(qST_YuukoukykHtjynbknKarid).getResults();
    }
}
