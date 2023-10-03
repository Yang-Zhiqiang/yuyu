package yuyu.batch.suuri.srkessan.srskoikmkaikeityusyutu;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_DenpyoData;

/**
 * バッチ機能のＤＢアクセスクラス
 */
public class SrSkOikmKaikeiTyusyutuDbaStatement {

    @Inject
    private BizDomManager bizDomManager;

    public ExDBResults<BT_DenpyoData> getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate pDenymd,
        BizDate pSyoriYmd, BizDate pFstpryosyuymd) {

        ExDBResults<BT_DenpyoData> denpyoDataLst =
            bizDomManager.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(
                pDenymd, pSyoriYmd, pFstpryosyuymd);

        return denpyoDataLst;
    }
}
