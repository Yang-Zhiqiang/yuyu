package yuyu.common.siharai.siview;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日設定（請求受付）UiBeanパラメータインタフェース
 */
public interface ViewSiharaiInfoSkukeUiBeanParam extends CommonViewUiBeanParam {

    public BizDate getSyoruiukeymd();

    public void setSyoruiukeymd(BizDate pSyoruiukeymd);

}
