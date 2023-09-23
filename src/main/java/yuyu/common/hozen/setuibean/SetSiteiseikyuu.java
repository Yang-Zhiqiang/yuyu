package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_KykUkt;

/**
 * 契約保全 UiBean設定 被保険者代理人情報設定
 */
public class SetSiteiseikyuu {

    private static final String BLANK = "";

    public static boolean exec(KhozenCommonParam pKhCParm, SetSiteiseikyuuExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();
        IT_KykUkt kykUktSitei = pKhCParm.getSiteiDairiSeikyuunin(syoNo);

        if (kykUktSitei == null) {
            pUiBean.setVstsksiteidruktkbn(C_UktKbn.BLNK);
            pUiBean.setVstskstdrsknmkn(BLANK);
            pUiBean.setVstskstdrsknmkj(BLANK);
            pUiBean.setVstskstdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
            pUiBean.setVstskstdrskseiymd(null);
        }
        else {
            pUiBean.setVstsksiteidruktkbn(kykUktSitei.getUktkbn());
            pUiBean.setVstskstdrsknmkn(kykUktSitei.getUktnmkn());
            pUiBean.setVstskstdrsknmkj(kykUktSitei.getUktnmkj());
            pUiBean.setVstskstdrsknmkjhukakbn(kykUktSitei.getUktnmkjkhukakbn());
            pUiBean.setVstskstdrskseiymd(kykUktSitei.getUktseiymd());
        }

        return true;
    }

    public static void init(SetSiteiseikyuuExecUiBeanParam pUiBean) {
        pUiBean.setVstsksiteidruktkbn(C_UktKbn.BLNK);
        pUiBean.setVstskstdrsknmkn("");
        pUiBean.setVstskstdrsknmkj("");
        pUiBean.setVstskstdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        pUiBean.setVstskstdrskseiymd(null);
    }
}
