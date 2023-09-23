package yuyu.common.siharai.siview;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払詳細情報表示（保険金）
 */
public interface HktshrMeisaisInfoDataSourceBeanCommonParam {

    BizCurrency getKyhkg();

    void setKyhkg(BizCurrency pKyhkg);

    String getBikoumsg1();

    void setBikoumsg1(String pBikoumsg1);

    String getBikoumsg2();

    void setBikoumsg2(String pBikoumsg2);

    String getBikoumsg3();

    void setBikoumsg3(String pBikoumsg3);

    String getBikoumsg4();

    void setBikoumsg4(String pBikoumsg4);

    String getSyouhnnmgm();

    void setSyouhnnmgm(String pSyouhnnmgm);

}