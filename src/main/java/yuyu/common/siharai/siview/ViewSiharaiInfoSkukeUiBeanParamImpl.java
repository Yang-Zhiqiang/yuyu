package yuyu.common.siharai.siview;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日設定（請求受付）UiBeanパラメータインタフェース実装クラス
 */
public class ViewSiharaiInfoSkukeUiBeanParamImpl implements ViewSiharaiInfoSkukeUiBeanParam {

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
