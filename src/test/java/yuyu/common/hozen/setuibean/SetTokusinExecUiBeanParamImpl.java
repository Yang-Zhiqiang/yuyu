package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 UiBean設定 特伸情報設定UiBean
 */
public class SetTokusinExecUiBeanParamImpl implements SetTokusinExecUiBeanParam{

    private String syono;

    private C_UmuKbn vtsumukbn;

    private C_TokusinKbn vtstokusinkbn;

    private BizDate vtshsgymd;

    private BizDate vtstokusinendymd;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public C_UmuKbn getVtsumukbn() {
        return vtsumukbn;
    }

    @Override
    public void setVtsumukbn(C_UmuKbn pVtsumukbn) {
        vtsumukbn = pVtsumukbn;
    }

    public C_TokusinKbn getVtstokusinkbn() {
        return vtstokusinkbn;
    }

    @Override
    public void setVtstokusinkbn(C_TokusinKbn pVtstokusinkbn) {
        vtstokusinkbn = pVtstokusinkbn;
    }

    public BizDate getVtshsgymd() {
        return vtshsgymd;
    }

    @Override
    public void setVtshsgymd(BizDate pVtshsgymd) {
        vtshsgymd = pVtshsgymd;
    }

    public BizDate getVtstokusinendymd() {
        return vtstokusinendymd;
    }

    @Override
    public void setVtstokusinendymd(BizDate pVtstokusinendymd) {
        vtstokusinendymd = pVtstokusinendymd;
    }
}
