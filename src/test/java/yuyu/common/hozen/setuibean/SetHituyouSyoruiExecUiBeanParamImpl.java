package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khcommon.KhozenCommonParamKhMeigiHenkouUiBeanParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 UiBean設定 必要書類設定UiBean
 */
public class SetHituyouSyoruiExecUiBeanParamImpl implements SetHituyouSyoruiExecUiBeanParam, KhozenCommonParamGetHituyouSyoruiUiBeanParam, KhozenCommonParamKhMeigiHenkouUiBeanParam{

    private String vhtysdisphtysyorui;

    public String getVhtysdisphtysyorui() {
        return vhtysdisphtysyorui;
    }

    @Override
    public void setVhtysdisphtysyorui(String pVhtysdisphtysyorui) {
        this.vhtysdisphtysyorui = pVhtysdisphtysyorui;
    }

    private C_Meigihnkjiyuu meigihnkjiyuu;

    @Override
    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkjiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu meigihnkjiyuu) {
        this.meigihnkjiyuu = meigihnkjiyuu;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Override
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu hrkkaisuu) {
        this.hrkkaisuu = hrkkaisuu;
    }

    private C_UmuKbn daisennintdkumukbn;

    @Override
    public C_UmuKbn getDaisennintdkumukbn() {
        return daisennintdkumukbn;
    }

    public void setDaisennintdkumukbn(C_UmuKbn daisennintdkumukbn) {
        this.daisennintdkumukbn = daisennintdkumukbn;
    }

}
