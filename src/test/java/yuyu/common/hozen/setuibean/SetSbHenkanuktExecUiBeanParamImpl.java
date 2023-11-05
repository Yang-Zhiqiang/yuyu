package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 UiBean設定 継続年金受取人情報設定UiBeanパラメータ
 */
public class SetSbHenkanuktExecUiBeanParamImpl implements SetSbHenkanuktExecUiBeanParam{

    private String syono = null;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private String sbhenkanuktnmkn;

    public String getSbhenkanuktnmkn() {
        return sbhenkanuktnmkn;
    }

    @Override
    public void setSbhenkanuktnmkn(String pSbhenkanuktnmkn){
        this.sbhenkanuktnmkn = pSbhenkanuktnmkn;
    }

    private String sbhenkanuktnmkj;

    public String getSbhenkanuktnmkj() {
        return sbhenkanuktnmkj;
    }

    @Override
    public void setSbhenkanuktnmkj(String pSbhenkanuktnmkj){
        this.sbhenkanuktnmkj = pSbhenkanuktnmkj;
    }

    private BizDate sibouhenkankinuktseiymd;

    public BizDate getSibouhenkankinuktseiymd() {
        return sibouhenkankinuktseiymd;
    }

    @Override
    public void setSibouhenkankinuktseiymd(BizDate pSibouhenkankinuktseiymd){
        this.sibouhenkankinuktseiymd = pSibouhenkankinuktseiymd;
    }

    private C_Tdk sibouhenkankinukttdk;

    public C_Tdk getSibouhenkankinukttdk() {
        return sibouhenkankinukttdk;
    }

    @Override
    public void setSibouhenkankinukttdk(C_Tdk pSibouhenkankinukttdk){
        this.sibouhenkankinukttdk = pSibouhenkankinukttdk;
    }
}
