package yuyu.common.hozen.haitou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 配当 配当金計算情報Beanクラス
 */
public class KeisanDInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency kihonS;

    private BizNumber drate;

    private BizNumber kawaserate;

    private BizDate kwsratekjymd;

    private int keikaTukisuu;

    private BizCurrency haitoukinYenKansanMae;

    private BizCurrency haitoukinYen;

    public KeisanDInfoBean() {

    }

    public KeisanDInfoBean(BizCurrency pKihonS, BizNumber pDRate,
        BizNumber pKawaseRate, int pKeikaMonth) {
        super();
        this.kihonS = pKihonS;
        this.drate = pDRate;
        this.kawaserate = pKawaseRate;
        this.keikaTukisuu = pKeikaMonth;
    }

    public BizCurrency getKihonS() {
        return kihonS;
    }

    public void setKihonS(BizCurrency pKihonS) {
        this.kihonS = pKihonS;
    }

    public BizNumber getdrate() {
        return drate;
    }

    public void setdrate(BizNumber pDrate) {
        this.drate = pDrate;
    }

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    public void setKawaserate(BizNumber pKawaserate) {
        this.kawaserate = pKawaserate;
    }

    public BizDate getKwsratekjymd() {
        return kwsratekjymd;
    }

    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        this.kwsratekjymd = pKwsratekjymd;
    }

    public int getKeikaTukisuu() {
        return keikaTukisuu;
    }

    public void setKeikaTukisuu(int pKeikaTukisuu) {
        this.keikaTukisuu = pKeikaTukisuu;
    }

    public BizCurrency getHaitoukinYenKansanMae() {
        return haitoukinYenKansanMae;
    }

    public void setHaitoukinYenKansanMae(BizCurrency pHaitoukinYenKansanMae) {
        this.haitoukinYenKansanMae = pHaitoukinYenKansanMae;
    }

    public BizCurrency getHaitoukinYen() {
        return haitoukinYen;
    }

    public void setHaitoukinYen(BizCurrency pHaitoukinYen) {
        this.haitoukinYen = pHaitoukinYen;
    }

}
