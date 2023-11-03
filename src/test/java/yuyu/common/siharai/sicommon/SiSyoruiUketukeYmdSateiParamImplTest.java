package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSyoruiUketukeYmdSateiParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 書類受付日（査定）Paramインターフェース実装クラス（テスト用）
 */
public class SiSyoruiUketukeYmdSateiParamImplTest implements SiSyoruiUketukeYmdSateiParam ,EditSkTblParam {

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
