package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 UiBean設定 継続年金受取人情報設定UiBeanパラメータ
 */
public class SetKeizokuNkuktExecUiBeanParamImpl implements SetKeizokuNkuktExecUiBeanParam{

    private String syono = null;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private String keizknkuktnmkn;

    public String getKeizknkuktnmkn() {
        return keizknkuktnmkn;
    }

    @Override
    public void setKeizknkuktnmkn(String pKeizknkuktnmkn){
        this.keizknkuktnmkn = pKeizknkuktnmkn;
    }

    private String keizknkuktnmkj;

    public String getKeizknkuktnmkj() {
        return keizknkuktnmkj;
    }

    @Override
    public void setKeizknkuktnmkj(String pKeizknkuktnmkj){
        this.keizknkuktnmkj = pKeizknkuktnmkj;
    }

    private BizDate keizknenkiuktseiymd;

    public BizDate getKeizknenkiuktseiymd() {
        return keizknenkiuktseiymd;
    }

    @Override
    public void setKeizknenkiuktseiymd(BizDate pKeizknenkiuktseiymd){
        this.keizknenkiuktseiymd = pKeizknenkiuktseiymd;
    }

    private C_Tdk keizknenkinukttdk;

    public C_Tdk getKeizknenkinukttdk() {
        return keizknenkinukttdk;
    }

    @Override
    public void setKeizknenkinukttdk(C_Tdk pKeizknenkinukttdk){
        this.keizknenkinukttdk = pKeizknenkinukttdk;
    }
}
