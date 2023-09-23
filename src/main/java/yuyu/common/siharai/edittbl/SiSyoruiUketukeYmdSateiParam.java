package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日（査定）Paramインターフェース
 */
public interface SiSyoruiUketukeYmdSateiParam {

    public BizDate getSyoruiukeymd();

    public void setSyoruiukeymd(BizDate pSyoruiukeymd);

    public BizDate getHubikanryouymd();

    public void setHubikanryouymd(BizDate pHubikanryouymd);

}
