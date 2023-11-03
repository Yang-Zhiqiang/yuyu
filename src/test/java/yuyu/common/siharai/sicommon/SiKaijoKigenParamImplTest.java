package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiKaijoKigenParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 解除期限日入力Paramインターフェース実装クラス（テスト用）
 */
public class SiKaijoKigenParamImplTest implements SiKaijoKigenParam ,EditSkTblParam {

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
