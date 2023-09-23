package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 保険金給付金支払共通 解除期限日入力Paramインターフェース実装クラス
 */
public class SiKaijoKigenParamImpl implements SiKaijoKigenParam {

    private BizDate kaijokigenymd;

    @Override
    public BizDate getKaijokigenymd() {
        return kaijokigenymd;
    }

    @Override
    public void setKaijokigenymd(BizDate pKaijokigenymd) {
        kaijokigenymd = pKaijokigenymd;
    }

    public boolean isAllBlnk() {

        if (kaijokigenymd == null) {
            return true;
        }
        return false;
    }

}
