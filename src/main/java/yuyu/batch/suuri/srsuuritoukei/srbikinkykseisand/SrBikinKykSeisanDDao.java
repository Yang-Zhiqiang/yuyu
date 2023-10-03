package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisand;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.meta.QST_BknkykHtjynbkn;

/**
 * 備金契約精算Ｄ情報作成のDAOクラス
 */
public class SrBikinKykSeisanDDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<ST_BknkykHtjynbkn> getBikinKykHaitouJyunbikin(BizDate pKijyunymd, String pKakutyoujobcd) {

        QST_BknkykHtjynbkn qST_BknkykHtjynbkn = new QST_BknkykHtjynbkn("qST_BknkykHtjynbkn");

        String queryStr = $SELECT + qST_BknkykHtjynbkn +
            $FROM (qST_BknkykHtjynbkn) +
            $WHERE + qST_BknkykHtjynbkn.srkijyunym.eq(pKijyunymd.getBizDateYM().toString()) +
            $AND + qST_BknkykHtjynbkn.kakutyoujobcd.eq(pKakutyoujobcd);

        return exDBEntityManager.createJPQL(queryStr).bind(qST_BknkykHtjynbkn).getResults();
    }
}
