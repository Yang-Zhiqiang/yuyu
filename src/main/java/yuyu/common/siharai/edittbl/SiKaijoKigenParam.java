package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 保険金給付金支払共通 解除期限日入力Paramインターフェース
 */
public interface SiKaijoKigenParam {

    public BizDate getKaijokigenymd();

    public void setKaijokigenymd(BizDate pKaijokigenymd);

}
