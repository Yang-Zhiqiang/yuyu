package yuyu.common.siharai.siview;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日設定（査定）UiBeanパラメータインタフェース実装クラス
 */
public class ViewSiharaiInfoSateiUiBeanParamImpl implements ViewSiharaiInfoSateiUiBeanParam {

    private BizDate syoruiukeymd;

    private BizDate hubikanryouymd;

    @Override
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Override
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    @Override
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Override
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

}
