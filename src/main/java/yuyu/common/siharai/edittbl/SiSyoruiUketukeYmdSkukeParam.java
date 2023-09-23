package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日（請求受付）Paramインターフェース
 */
public interface SiSyoruiUketukeYmdSkukeParam {

    public BizDate getSyoruiukeymd();

    public void setSyoruiukeymd(BizDate pSyoruiukeymd);

}
