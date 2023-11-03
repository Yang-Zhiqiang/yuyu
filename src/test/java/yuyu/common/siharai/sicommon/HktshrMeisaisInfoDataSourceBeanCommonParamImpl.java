package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.siharai.siview.HktshrMeisaisInfoDataSourceBeanCommonParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払詳細情報表示（保険金）実現クラス
 */
public class HktshrMeisaisInfoDataSourceBeanCommonParamImpl implements HktshrMeisaisInfoDataSourceBeanCommonParam {

    private BizCurrency pDispkyhkg;

    private String bikoumsg1;

    private String bikoumsg2;

    private String bikoumsg3;

    private String bikoumsg4;

    private String syouhnnmgm;

    @Override
    public BizCurrency getKyhkg() {
        return pDispkyhkg;
    }

    @Override
    public void setKyhkg(BizCurrency pDispkyhkg) {
        this.pDispkyhkg = pDispkyhkg;
    }

    @Override
    public String getBikoumsg1() {
        return bikoumsg1;
    }

    @Override
    public void setBikoumsg1(String pBikoumsg1) {
        this.bikoumsg1 = pBikoumsg1;
    }

    @Override
    public String getBikoumsg2() {
        return bikoumsg2;
    }

    @Override
    public void setBikoumsg2(String pBikoumsg2) {
        this.bikoumsg2 = pBikoumsg2;
    }

    @Override
    public String getBikoumsg3() {
        return bikoumsg3;
    }

    @Override
    public void setBikoumsg3(String pBikoumsg3) {
        this.bikoumsg3 = pBikoumsg3;
    }

    @Override
    public String getBikoumsg4() {
        return bikoumsg4;
    }

    @Override
    public void setBikoumsg4(String pBikoumsg4) {
        this.bikoumsg4 = pBikoumsg4;
    }

    @Override
    public String getSyouhnnmgm() {
        return syouhnnmgm;
    }

    @Override
    public void setSyouhnnmgm(String pSyouhnnmgm) {
        syouhnnmgm = pSyouhnnmgm;
    }

}
