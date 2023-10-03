package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisand;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;

/**
 * 備金契約精算Ｄ情報作成のＤＢアクセスクラス
 */
public class SrBikinKykSeisanDBatchDbAccess {

    @Inject
    private SrBikinKykSeisanDDao srBikinKykSeisanDDao;

    public ExDBResults<ST_BknkykHtjynbkn> getBikinKykHaitouJyunbikin(BizDate pKijyunymd, String pKakutyoujobcd) {

        ExDBResults<ST_BknkykHtjynbkn> bknkykHtjynbknlist = srBikinKykSeisanDDao
            .getBikinKykHaitouJyunbikin(pKijyunymd, pKakutyoujobcd);

        return bknkykHtjynbknlist;
    }
}
