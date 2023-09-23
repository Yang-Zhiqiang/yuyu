package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.db.entity.IT_KykSya;

/**
 * 契約保全 UiBean設定 通信先情報設定
 */
public class SetTuusinsaki {

    public static boolean exec(KhozenCommonParam pKhCParm, SetTuusinsakiExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();
        IT_KykSya kykSya = pKhCParm.getKeiyakusya(syoNo);

        pUiBean.setVtssktsinyno(kykSya.getTsinyno());
        pUiBean.setVtssktsinadr1kj(kykSya.getTsinadr1kj());
        pUiBean.setVtssktsinadr2kj(kykSya.getTsinadr2kj());
        pUiBean.setVtssktsinadr3kj(kykSya.getTsinadr3kj());
        pUiBean.setVtssktsintelno(kykSya.getTsintelno());
        pUiBean.setVtsskdai2tsintelno(kykSya.getDai2tsintelno());

        return true;
    }

    public static void init(SetTuusinsakiExecUiBeanParam pUiBean) {
        pUiBean.setVtssktsinyno("");
        pUiBean.setVtssktsinadr1kj("");
        pUiBean.setVtssktsinadr2kj("");
        pUiBean.setVtssktsinadr3kj("");
        pUiBean.setVtssktsintelno("");
        pUiBean.setVtsskdai2tsintelno("");
    }
}
