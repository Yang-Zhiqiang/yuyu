package yuyu.common.siharai.siview.viewhihokensya;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Hhknsei;

/**
 * 保険金給付金支払 支払画面部品 被保険者情報表示クラス <br />
 */
public class ViewHihokensyaUiBeanParamImpl implements ViewHihokensyaUiBeanParam{

    private String hhknnmkn;

    private String hhknnmkj;

    private BizDate hhknseiymd;

    private String mskmjskjhknnen;

    private C_Hhknsei hhknsei;

    @Override
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Override
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    @Override
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Override
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    @Override
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Override
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    @Override
    public String getMskmjskjhknnen() {
        return mskmjskjhknnen;
    }

    @Override
    public void setMskmjskjhknnen(String pMskmjskjhknnen) {
        mskmjskjhknnen = pMskmjskjhknnen;
    }

    @Override
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    @Override
    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

}
