package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_Tdk;
import yuyu.def.db.entity.IT_KykUkt;

/**
 * 契約保全 UiBean設定 継続年金受取人情報設定
 */
public class SetKeizokuNkukt {

    private static final String BLANK = "";

    public static boolean exec(KhozenCommonParam pKhCParm, SetKeizokuNkuktExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        IT_KykUkt kykUkt = pKhCParm.getKeizokuNenkinUketorinin(syoNo);

        if (kykUkt == null) {
            pUiBean.setKeizknkuktnmkn(BLANK);
            pUiBean.setKeizknkuktnmkj(BLANK);
            pUiBean.setKeizknenkiuktseiymd(null);
            pUiBean.setKeizknenkinukttdk(C_Tdk.BLNK);
        }
        else {
            pUiBean.setKeizknkuktnmkn(kykUkt.getUktnmkn());
            pUiBean.setKeizknkuktnmkj(kykUkt.getUktnmkj());
            pUiBean.setKeizknenkiuktseiymd(kykUkt.getUktseiymd());
            pUiBean.setKeizknenkinukttdk(kykUkt.getUkttdk());
        }

        return true;
    }

    public static void init(SetKeizokuNkuktExecUiBeanParam pUiBean) {
        pUiBean.setKeizknkuktnmkn(BLANK);
        pUiBean.setKeizknkuktnmkj(BLANK);
        pUiBean.setKeizknenkiuktseiymd(null);
        pUiBean.setKeizknenkinukttdk(C_Tdk.BLNK);
    }
}
