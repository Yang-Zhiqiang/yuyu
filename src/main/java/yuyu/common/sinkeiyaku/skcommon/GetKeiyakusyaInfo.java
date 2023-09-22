package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.db.entity.HT_MosKihon;

/**
 * 新契約 新契約共通 契約者情報編集
 */
public class GetKeiyakusyaInfo {

    public GetKeiyakusyaInfo() {
        super();
    }

    public String getKyknmkn(C_KykKbn pKykkbn, String pKyknmKn, String pHhknnmKn) {

        String kyknmKn = "";
        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {
            kyknmKn = pHhknnmKn;
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pKykkbn)) {
            kyknmKn = pKyknmKn;
        }

        return kyknmKn;
    }

    public String getKyknmkj(C_KykKbn pKykkbn, String pKyknmKj, String pHhknnmKj) {

        String kyknmKj = "";
        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {
            kyknmKj = pHhknnmKj;
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pKykkbn)) {
            kyknmKj = pKyknmKj;
        }

        return kyknmKj;
    }

    public C_KjkhukaKbn getKyknmkjkhukakbn(C_KykKbn pKykkbn, C_KjkhukaKbn pKykKjkhukaKbn, C_KjkhukaKbn pHhkKjkhukaKbn) {

        C_KjkhukaKbn kykKjkhukaKbn = C_KjkhukaKbn.BLNK;

        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {
            kykKjkhukaKbn = pHhkKjkhukaKbn;
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pKykkbn)) {
            kykKjkhukaKbn = pKykKjkhukaKbn;
        }

        return kykKjkhukaKbn;
    }

    public C_Kyksei getKyksei(C_KykKbn pKykkbn, C_Kyksei pKyksei, C_Hhknsei pHhknsei) {

        C_Kyksei kyksei = C_Kyksei.BLNK;
        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {
            kyksei = C_Kyksei.valueOf(pHhknsei.getValue());
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pKykkbn)) {
            kyksei = pKyksei;
        }

        return kyksei;
    }

    public BizDate getKykseiymd(C_KykKbn pKykkbn, BizDate pKykseiYmd, BizDate pHhknseiYmd) {

        BizDate kykseiYmd = null;
        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {
            kykseiYmd = pHhknseiYmd;
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pKykkbn)) {
            kykseiYmd = pKykseiYmd;
        }

        return kykseiYmd;
    }

    public Integer getKyknen(C_KykKbn pKykkbn, Integer pKyknen, Integer pHhknen) {

        Integer kyknen = 0;
        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {
            kyknen = pHhknen;
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pKykkbn)) {
            kyknen = pKyknen;
        }

        return kyknen;
    }

    public String getKykkinmusakinm(C_KykKbn pKykkbn, String pKykkinmusakinm, String pHhknkinmusakinm) {

        String kykkinmusakinm = "";
        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {
            kykkinmusakinm = pHhknkinmusakinm;
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pKykkbn)) {
            kykkinmusakinm = pKykkinmusakinm;
        }

        return kykkinmusakinm;
    }

    public KeiyakusyaInfoBean getKeiyakusyainfo(HT_MosKihon pMosKihon) {

        C_KykKbn kykKbn = pMosKihon.getKykkbn();
        KeiyakusyaInfoBean keiyakusyaInfoBean = SWAKInjector.getInstance(KeiyakusyaInfoBean.class);

        keiyakusyaInfoBean.setKyknmkn(getKyknmkn(kykKbn, pMosKihon.getKyknmkn(), pMosKihon.getHhknnmkn()));
        keiyakusyaInfoBean.setKyknmkj(getKyknmkj(kykKbn, pMosKihon.getKyknmkj(), pMosKihon.getHhknnmkj()));
        keiyakusyaInfoBean.setKyknmkjkhukakbn(getKyknmkjkhukakbn(kykKbn, pMosKihon.getKyknmkjkhukakbn(), pMosKihon.getHhknnmkjkhukakbn()));
        keiyakusyaInfoBean.setKyksei(getKyksei(kykKbn, pMosKihon.getKyksei(), pMosKihon.getHhknsei()));
        keiyakusyaInfoBean.setKykseiymd(getKykseiymd(kykKbn, pMosKihon.getKykseiymd(), pMosKihon.getHhknseiymd()));
        keiyakusyaInfoBean.setKyknen(getKyknen(kykKbn, pMosKihon.getKyknen(), pMosKihon.getHhknnen()));
        keiyakusyaInfoBean.setKykkinmusakinm(getKykkinmusakinm(kykKbn, pMosKihon.getKykkinmusakinm(), pMosKihon.getHhknkinmusakinm()));

        return keiyakusyaInfoBean;
    }
}