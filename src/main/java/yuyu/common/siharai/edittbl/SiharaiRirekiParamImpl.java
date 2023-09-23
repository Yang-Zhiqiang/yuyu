package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;


/**
 * 保険金給付金支払 保険金給付金支払共通 支払履歴Paramインターフェースクラス
 */
public class SiharaiRirekiParamImpl implements SiharaiRirekiParam {

    private BizDate tyakkinymd;

    private BizCurrency shrgkkei;

    @Override
    public BizDate getTyakkinymd() {

        if (shrgkkei == null || shrgkkei.isOptional() ||
            !(shrgkkei.compareTo(BizCurrency.valueOf(0, shrgkkei.getType())) == 1)) {
            tyakkinymd = null;
        }

        return tyakkinymd;
    }

    @Override
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    @Override
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    @Override
    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }
}
