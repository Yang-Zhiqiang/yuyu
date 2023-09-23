package yuyu.common.hozen.setuibean;

import yuyu.def.classification.C_Kzdou;

/**
 * 契約保全 UiBean設定 口座情報設定
 */
public class SetKouzaInfo {

    public static boolean init(SetKouzaInfoExecUiBeanParam pUiBean) {

        C_Kzdou iKouzaDoukbn = pUiBean.getKzdoukbn();
        if (C_Kzdou.DOUITU.eq(iKouzaDoukbn)) {
            pUiBean.setKzmeiginmkn(pUiBean.getVkykskyknmkn());
        }

        return true;
    }
}
