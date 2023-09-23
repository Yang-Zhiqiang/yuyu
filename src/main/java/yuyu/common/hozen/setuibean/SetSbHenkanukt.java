package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_Tdk;
import yuyu.def.db.entity.IT_KykUkt;

/**
 * 契約保全 UiBean設定 死亡返還金受取人情報設定
 */
public class SetSbHenkanukt {

    public static boolean exec(KhozenCommonParam pKhCParm, SetSbHenkanuktExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();
        IT_KykUkt kykUkt = pKhCParm.getSibouHenkankinUketorinin(syoNo);

        if (kykUkt == null) {
            pUiBean.setSbhenkanuktnmkn("");
            pUiBean.setSbhenkanuktnmkj("");
            pUiBean.setSibouhenkankinuktseiymd(null);
            pUiBean.setSibouhenkankinukttdk(C_Tdk.BLNK);
        }
        else {
            pUiBean.setSbhenkanuktnmkn(kykUkt.getUktnmkn());
            pUiBean.setSbhenkanuktnmkj(kykUkt.getUktnmkj());
            pUiBean.setSibouhenkankinuktseiymd(kykUkt.getUktseiymd());
            pUiBean.setSibouhenkankinukttdk(kykUkt.getUkttdk());
        }

        return true;
    }

    public static void init(SetSbHenkanuktExecUiBeanParam pUiBean) {
        pUiBean.setSbhenkanuktnmkn("");
        pUiBean.setSbhenkanuktnmkj("");
        pUiBean.setSibouhenkankinuktseiymd(null);
        pUiBean.setSibouhenkankinukttdk(C_Tdk.BLNK);
    }
}
