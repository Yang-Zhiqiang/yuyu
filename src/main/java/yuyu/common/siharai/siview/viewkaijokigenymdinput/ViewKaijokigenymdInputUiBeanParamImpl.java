package yuyu.common.siharai.siview.viewkaijokigenymdinput;

import jp.co.slcs.swak.date.BizDate;

/**
 * 保険金給付金支払 支払画面部品 解除期限日入力クラス <br />
 */
public class ViewKaijokigenymdInputUiBeanParamImpl implements ViewKaijokigenymdInputUiBeanParam{

    private BizDate kaijokigenymd;

    private boolean viewKaijokigenymdInputFlg;

    private boolean viewKaijokigenymdSeigyo;

    private boolean viewKaijokigenymdDispFlg;

    @Override
    public BizDate getKaijokigenymd() {
        return kaijokigenymd;
    }

    @Override
    public void setKaijokigenymd(BizDate pKaijokigenymd) {
        kaijokigenymd = pKaijokigenymd;
    }

    @Override
    public boolean isViewKaijokigenymdInputFlg() {
        return viewKaijokigenymdInputFlg;
    }

    @Override
    public boolean isViewKaijokigenymdSeigyo() {
        return viewKaijokigenymdSeigyo;
    }

    @Override
    public boolean isViewKaijokigenymdDispFlg() {
        return viewKaijokigenymdDispFlg;
    }
}
