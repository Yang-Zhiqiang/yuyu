package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_KykUkt;

/**
 * 契約保全 UiBean設定 年金受取人情報設定
 */
public class SetNkukt {

    public static boolean exec(KhozenCommonParam pKhCParm, SetNkuktExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();
        IT_KykUkt kykUkt = pKhCParm.getNenkinUketorinin(syoNo);

        if (kykUkt == null) {
            pUiBean.setVnkuknenkinuktkbn(C_UktKbn.BLNK);
        }
        else {
            pUiBean.setVnkuknenkinuktkbn(kykUkt.getUktkbn());
        }

        return true;
    }

    public static void init(SetNkuktExecUiBeanParam UiBean) {
        UiBean.setVnkuknenkinuktkbn(C_UktKbn.BLNK);
    }
}
