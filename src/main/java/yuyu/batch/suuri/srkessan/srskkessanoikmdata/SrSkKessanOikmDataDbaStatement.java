package yuyu.batch.suuri.srkessan.srskkessanoikmdata;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.suuri.manager.SuuriDomManager;

/**
 * バッチ機能のＤＢアクセスクラス
 */
public class SrSkKessanOikmDataDbaStatement {

    @Inject
    private SuuriDomManager suuriDomManager;

    public ExDBResults<ST_SkOikmTyouseiDenpyou> getSkOikmTyouseiDenpyous() {

        ExDBResults<ST_SkOikmTyouseiDenpyou> skOikmTyouseiDenpyouLst = suuriDomManager.getSkOikmTyouseiDenpyous();

        return skOikmTyouseiDenpyouLst;
    }
}
