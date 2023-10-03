package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisai;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;

/**
 * 数理統計 数理統計 仮割当配当金明細情報作成ＤＢアクセスクラス
 */
public class SrKariwariateDMeisaiBatchDbAccess {

    @Inject
    private SrKariwariateDMeisaiDao srKariwariateDMeisaiDao;

    public ExDBResults<ST_YuukoukykHtjynbknKarid> getKariwariateDMeisai(BizDate pKijyunym, String pKakutyoujobcd) {

        ExDBResults<ST_YuukoukykHtjynbknKarid> yuukoukykHtjynbknKaridList = srKariwariateDMeisaiDao
            .getKariwariateDMeisai(pKijyunym, pKakutyoujobcd);

        return yuukoukykHtjynbknKaridList;
    }
}