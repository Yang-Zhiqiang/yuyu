package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_KykUkt;

/**
 * 契約保全 UiBean設定 契約者代理人情報設定
 */
public class SetKyksyadairi {

    private static final String BLANK = "";

    public static boolean exec(KhozenCommonParam pKhCParm, SetKyksyadairiExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        IT_KykUkt kykUkt = pKhCParm.getKyksyaDairinin(syoNo);

        if (kykUkt != null) {
            pUiBean.setVkykdrkykdrkbn(kykUkt.getUktkbn());
            pUiBean.setVkykdrkykdrnmkn(kykUkt.getUktnmkn());
            pUiBean.setVkykdrkykdrnmkj(kykUkt.getUktnmkj());
            pUiBean.setVkykdrkykdrnmkjkhukakbn(kykUkt.getUktnmkjkhukakbn());
            pUiBean.setVkykdrkykdrseiymd(kykUkt.getUktseiymd());
            pUiBean.setVkykdrkykdryno(kykUkt.getUktyno());
            pUiBean.setVkykdrkykdradr1kj(kykUkt.getUktadr1kj());
            pUiBean.setVkykdrkykdradr2kj(kykUkt.getUktadr2kj());
            pUiBean.setVkykdrkykdradr3kj(kykUkt.getUktadr3kj());
        }
        else {
            pUiBean.setVkykdrkykdrkbn(C_UktKbn.BLNK);
            pUiBean.setVkykdrkykdrnmkn(BLANK);
            pUiBean.setVkykdrkykdrnmkj(BLANK);
            pUiBean.setVkykdrkykdrnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            pUiBean.setVkykdrkykdrseiymd(null);
            pUiBean.setVkykdrkykdryno(BLANK);
            pUiBean.setVkykdrkykdradr1kj(BLANK);
            pUiBean.setVkykdrkykdradr2kj(BLANK);
            pUiBean.setVkykdrkykdradr3kj(BLANK);
        }

        return true;
    }

    public static void init(SetKyksyadairiExecUiBeanParam pUiBean) {
        pUiBean.setVkykdrkykdrkbn(C_UktKbn.BLNK);
        pUiBean.setVkykdrkykdrnmkn(BLANK);
        pUiBean.setVkykdrkykdrnmkj(BLANK);
        pUiBean.setVkykdrkykdrnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pUiBean.setVkykdrkykdrseiymd(null);
        pUiBean.setVkykdrkykdryno(BLANK);
        pUiBean.setVkykdrkykdradr1kj(BLANK);
        pUiBean.setVkykdrkykdradr2kj(BLANK);
        pUiBean.setVkykdrkykdradr3kj(BLANK);
    }
}
