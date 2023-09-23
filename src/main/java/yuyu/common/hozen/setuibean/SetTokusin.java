package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_Tokusin;

/**
 * 契約保全 UiBean設定 特伸情報設定
 */
public class SetTokusin {

    public static boolean exec(KhozenCommonParam pKhCParm, SetTokusinExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();
        IT_Tokusin tokusin = pKhCParm.getTokusin(syoNo);

        if (tokusin != null) {
            pUiBean.setVtsumukbn(C_UmuKbn.ARI);
            pUiBean.setVtstokusinkbn(tokusin.getTokusinkbn());
            pUiBean.setVtshsgymd(tokusin.getHsgymd());
            pUiBean.setVtstokusinendymd(tokusin.getTokusinendymd());
        }

        return true;
    }

    public static void init (SetTokusinExecUiBeanParam pUiBean) {
        pUiBean.setVtsumukbn(C_UmuKbn.NONE);
        pUiBean.setVtstokusinkbn(C_TokusinKbn.BLNK);
        pUiBean.setVtshsgymd(null);
        pUiBean.setVtstokusinendymd(null);
    }
}

