package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.db.entity.IT_HhknSya;

/**
 * 契約保全 UiBean設定 被保険者情報設定
 */
public class SetHihokensya {

    public static boolean exec(KhozenCommonParam pKhCParm, SetHihokensyaExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        IT_HhknSya hhknSya = pKhCParm.getHihokensya(syoNo);

        pUiBean.setVhhkshhknnmkn(hhknSya.getHhknnmkn());
        pUiBean.setVhhkshhknnmkj(hhknSya.getHhknnmkj());
        pUiBean.setVhhkshhknnmkjkhukakbn(hhknSya.getHhknnmkjkhukakbn());
        pUiBean.setVhhkshhknseiymd(hhknSya.getHhknseiymd());
        pUiBean.setVhhkshhknsei(hhknSya.getHhknsei());

        return true;
    }

    public static void init(SetHihokensyaExecUiBeanParam pUiBean) {
        pUiBean.setVhhkshhknnmkn("");
        pUiBean.setVhhkshhknnmkj("");
        pUiBean.setVhhkshhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pUiBean.setVhhkshhknseiymd(null);
        pUiBean.setVhhkshhknsei(C_Hhknsei.BLNK);
    }
}
