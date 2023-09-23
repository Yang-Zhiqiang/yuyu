package yuyu.common.siharai.siview.viewkaijokigenymdinput;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 解除期限日入力 <br />
 */
public interface ViewKaijokigenymdInputUiBeanParam extends CommonViewUiBeanParam {

    public BizDate getKaijokigenymd();

    public void setKaijokigenymd(BizDate pKaijokigenymd);

    public boolean isViewKaijokigenymdInputFlg();

    public boolean isViewKaijokigenymdSeigyo();

    public boolean isViewKaijokigenymdDispFlg();
}
