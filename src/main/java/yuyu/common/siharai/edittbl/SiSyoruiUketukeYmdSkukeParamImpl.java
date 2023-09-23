package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日（請求受付）Paramインターフェース実装クラス
 */
public class SiSyoruiUketukeYmdSkukeParamImpl implements SiSyoruiUketukeYmdSkukeParam {

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
