package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSyoruiUketukeYmdSkukeParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日（請求受付）Paramインターフェース実装クラス（テスト用）
 */
public class SiSyoruiUketukeYmdSkukeParamImplTest implements SiSyoruiUketukeYmdSkukeParam ,EditSkTblParam {

    private BizDate syoruiukeymd;

    @Override
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Override
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }
}
