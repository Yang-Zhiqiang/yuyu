package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;


/**
 * 保険金給付金支払 保険金給付金支払共通 支払履歴Paramインターフェースクラス
 */
public interface SiharaiRirekiParam {

    BizDate getTyakkinymd();

    void setTyakkinymd(BizDate pTyakkinymd);

    BizCurrency getShrgkkei();

    void setShrgkkei(BizCurrency pShrgkkei);

}
