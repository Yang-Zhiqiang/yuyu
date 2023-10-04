package yuyu.batch.sinkeiyaku.sknyuukin.skkouhuritourokukekkahaneipre.dba;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.zdb.manager.ZdbDomManager;

/**
 * 新契約 入金 口振受付登録結果反映前処理の機能DAOクラス
 */
public class SkKouhuriTourokuKekkaHaneiPreDao {

    @Inject
    ZdbDomManager zdbDomManager;

    public ExDBResults<ZT_SkKouhuriUkTrkkekkaTr> getSkKouhuriUkTrkkekkaTrs(String pKakutyouJobCd) {

        ExDBResults<ZT_SkKouhuriUkTrkkekkaTr> skKouhuriUkTrkkekkaTrs = zdbDomManager.getAllSkKouhuriUkTrkkekkaTr();

        skKouhuriUkTrkkekkaTrs.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return skKouhuriUkTrkkekkaTrs;
    }
}
