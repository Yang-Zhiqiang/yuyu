package yuyu.common.siharai.edittbl;

/**
 * 保険金給付金支払 保険金給付金支払共通 ＭＮ名義番号Paramインターフェース実装クラス
 */
public class SiMnmeigibangouParamImpl implements SiMnmeigibangouParam {

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
