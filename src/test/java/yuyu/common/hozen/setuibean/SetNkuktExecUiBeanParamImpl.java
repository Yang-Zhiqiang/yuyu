package yuyu.common.hozen.setuibean;

import yuyu.def.classification.C_UktKbn;



/**
 * 契約保全 UiBean設定 年金受取人情報設定UiBean
 */
public class SetNkuktExecUiBeanParamImpl implements SetNkuktExecUiBeanParam{

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private C_UktKbn vnkuknenkinuktkbn;

    public C_UktKbn getVnkuknenkinuktkbn() {
        return vnkuknenkinuktkbn;
    }

    @Override
    public void setVnkuknenkinuktkbn(C_UktKbn pVnkuknenkinuktkbn) {
        this.vnkuknenkinuktkbn = pVnkuknenkinuktkbn;
    }
}
