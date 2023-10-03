package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisai;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;

/**
 * 数理統計 数理統計 積立配当金明細情報作成ＤＢアクセスクラス
 */
public class SrTmttDMeisaiBatchDbAccess {

    @Inject
    private SrTmttDMeisaiDao srTmttDMeisaiDao;

    public ExDBResults<ST_YuukoukykHtjynbknTmttd> getTmttDMeisai(BizDate pKijyunymd, String pKakutyoujobcd) {

        ExDBResults<ST_YuukoukykHtjynbknTmttd> yuukoukykHtjynbknTmttdList = srTmttDMeisaiDao.getTmttDMeisai(pKijyunymd,
            pKakutyoujobcd);

        return yuukoukykHtjynbknTmttdList;
    }
}