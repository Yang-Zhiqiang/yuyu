package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.number.BizCurrency;

/**
 *  特定時点その他特約情報Beanクラス
 */
public class SrGetTokutejitenTokuyakuInfoBean {

    private BizCurrency initSbjiyenkaSaiteihsygkMae;

    private BizCurrency initSbjiyenkaSaiteihsygkAto;

    private Integer targetTkmokuhyoutiMae;

    private Integer targetTkmokuhyoutiAto;

    private BizCurrency targetTkykkijyungkMae;

    private BizCurrency targetTkykkijyungkAto;

    SrGetTokutejitenTokuyakuInfoBean() {
        super();

        initSbjiyenkaSaiteihsygkMae = BizCurrency.valueOf(0);
        initSbjiyenkaSaiteihsygkAto = BizCurrency.valueOf(0);
        targetTkmokuhyoutiMae = 0;
        targetTkmokuhyoutiAto = 0;
        targetTkykkijyungkMae = BizCurrency.valueOf(0);
        targetTkykkijyungkAto = BizCurrency.valueOf(0);
    }

    public BizCurrency getInitsbjiyenkasaiteihsygkMae() {
        return initSbjiyenkaSaiteihsygkMae;
    }

    public void setInitsbjiyenkasaiteihsygkMae(BizCurrency pInitSbjiyenkaSaiteihsygkMae) {
        this.initSbjiyenkaSaiteihsygkMae = pInitSbjiyenkaSaiteihsygkMae;
    }

    public BizCurrency getInitsbjiyenkasaiteihsygkAto() {
        return initSbjiyenkaSaiteihsygkAto;
    }

    public void setInitsbjiyenkasaiteihsygkAto(BizCurrency pInitSbjiyenkaSaiteihsygkAto) {
        this.initSbjiyenkaSaiteihsygkAto = pInitSbjiyenkaSaiteihsygkAto;
    }

    public Integer getTargettkmokuhyoutiMae() {
        return targetTkmokuhyoutiMae;
    }

    public void setTargettkmokuhyoutiMae(Integer pTargetTkmokuhyoutiMae) {
        this.targetTkmokuhyoutiMae = pTargetTkmokuhyoutiMae;
    }

    public Integer getTargettkmokuhyoutiAto() {
        return targetTkmokuhyoutiAto;
    }

    public void setTargettkmokuhyoutiAto(Integer pTargetTkmokuhyoutiAto) {
        this.targetTkmokuhyoutiAto = pTargetTkmokuhyoutiAto;
    }

    public BizCurrency getTargettkykkijyungkMae() {
        return targetTkykkijyungkMae;
    }

    public void setTargettkykkijyungkMae(BizCurrency pTargetTkykkijyungkMae) {
        this.targetTkykkijyungkMae = pTargetTkykkijyungkMae;
    }

    public BizCurrency getTargettkykkijyungkAto() {
        return targetTkykkijyungkAto;
    }

    public void setTargettkykkijyungkAto(BizCurrency pTargetTkykkijyungkAto) {
        this.targetTkykkijyungkAto = pTargetTkykkijyungkAto;
    }

}
