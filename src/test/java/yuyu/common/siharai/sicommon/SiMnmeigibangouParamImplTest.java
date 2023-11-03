package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiMnmeigibangouParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 ＭＮ名義番号Paramインターフェース実装クラス（テスト用）
 */
public class SiMnmeigibangouParamImplTest implements SiMnmeigibangouParam, EditSkTblParam {

    private String uktmnmeigibangou;
    private String kykmnmeigibangou;

    @Override
    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    @Override
    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        uktmnmeigibangou = pUktmnmeigibangou;
    }

    @Override
    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    @Override
    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        kykmnmeigibangou = pKykmnmeigibangou;
    }

}
