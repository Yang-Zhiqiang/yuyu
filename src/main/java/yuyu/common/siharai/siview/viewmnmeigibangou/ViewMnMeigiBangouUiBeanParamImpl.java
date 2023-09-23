package yuyu.common.siharai.siview.viewmnmeigibangou;

/**
 * 保険金給付金支払 支払画面部品 ＭＮ名義番号表示 <br />
 */
public class ViewMnMeigiBangouUiBeanParamImpl implements ViewMnMeigiBangouUiBeanParam{

    private String kykmnmeigibangou;

    private String uktmnmeigibangou;

    private boolean viewMnMeigiBangouSeigyo;

    private boolean viewMnMeigiBangouDispFlg;

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

    @Override
    public boolean isViewMnMeigiBangouSeigyo() {
        return viewMnMeigiBangouSeigyo;
    }

    @Override
    public boolean isViewMnMeigiBangouDispFlg() {
        return viewMnMeigiBangouDispFlg;
    }

}
