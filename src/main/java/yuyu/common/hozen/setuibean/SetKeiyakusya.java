package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;
import yuyu.def.db.entity.IT_KykSya;

/**
 * 契約保全 UiBean設定 契約者情報設定
 */
public class SetKeiyakusya {

    public static boolean exec(KhozenCommonParam pKhCParm, SetKeiyakusyaExecUiBeanParam pUiBean) {

        IT_KykSya kykSya = pKhCParm.getKeiyakusya(pUiBean.getSyono());

        pUiBean.setVkykskyknmkn(kykSya.getKyknmkn());
        pUiBean.setVkykskyknmkj(kykSya.getKyknmkj());
        pUiBean.setVkykskyknmkjkhukakbn(kykSya.getKyknmkjkhukakbn());
        pUiBean.setVkykskykseiymd(kykSya.getKykseiymd());
        pUiBean.setVkykskyksei(kykSya.getKyksei());
        pUiBean.setVkykskkkyktdk(kykSya.getKkkyktdk());
        pUiBean.setVkykshjndaiykkbn(kykSya.getHjndaiykkbn());
        pUiBean.setVkykshjndaiyknm(kykSya.getHjndaiyknm());
        pUiBean.setVkykshjndainmkn(kykSya.getHjndainmkn());
        pUiBean.setVkykshjndainmkj(kykSya.getHjndainmkj());

        return true;
    }

    public static void init(SetKeiyakusyaExecUiBeanParam pUiBean) {
        pUiBean.setVkykskyknmkn("");
        pUiBean.setVkykskyknmkj("");
        pUiBean.setVkykskyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pUiBean.setVkykskykseiymd(null);
        pUiBean.setVkykskyksei(C_Kyksei.BLNK);
        pUiBean.setVkykskkkyktdk(C_Tdk.BLNK);
        pUiBean.setVkykshjndaiykkbn(C_HjndaiykKbn.BLNK);
        pUiBean.setVkykshjndaiyknm("");
        pUiBean.setVkykshjndainmkn("");
        pUiBean.setVkykshjndainmkj("");
    }
}
