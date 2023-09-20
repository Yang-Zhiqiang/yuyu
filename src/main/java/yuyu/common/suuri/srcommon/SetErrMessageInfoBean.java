package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 数理 数理共通 エラーメッセージ設定情報Bean
 */
public class SetErrMessageInfoBean {

    private BizDate kwsrateKjYmd;

    private C_KawaserateSyuruiKbn kawaserateSyuruiKbn;

    private C_Tuukasyu motoTuukasyu;

    private C_Tuukasyu kansanTuukasyu;

    private C_KawasetekiyoKbn kawasetekiyoKbn;

    private C_KawasetsryKbn kawasetsryKbn;

    private C_EigyoubiHoseiKbn eigyoubiHoseiKbn;

    private C_YouhiKbn youhiKbn;

    public BizDate getKwsrateKjYmd() {
        return kwsrateKjYmd;
    }

    public void setKwsrateKjYmd(BizDate pKwsrateKjYmd) {
        kwsrateKjYmd = pKwsrateKjYmd;
    }

    public C_KawaserateSyuruiKbn getKawaserateSyuruiKbn() {
        return kawaserateSyuruiKbn;
    }

    public void setKawaserateSyuruiKbn(C_KawaserateSyuruiKbn pKawaserateSyuruiKbn) {
        kawaserateSyuruiKbn = pKawaserateSyuruiKbn;
    }

    public C_Tuukasyu getMotoTuukasyu() {
        return motoTuukasyu;
    }

    public void setMotoTuukasyu(C_Tuukasyu pMotoTuukasyu) {
        motoTuukasyu = pMotoTuukasyu;
    }

    public C_Tuukasyu getKansanTuukasyu() {
        return kansanTuukasyu;
    }

    public void setKansanTuukasyu(C_Tuukasyu pKansanTuukasyu) {
        kansanTuukasyu = pKansanTuukasyu;
    }

    public C_KawasetekiyoKbn getKawasetekiyoKbn() {
        return kawasetekiyoKbn;
    }

    public void setKawasetekiyoKbn(C_KawasetekiyoKbn pKawasetekiyoKbn) {
        kawasetekiyoKbn = pKawasetekiyoKbn;
    }

    public C_KawasetsryKbn getKawasetsryKbn() {
        return kawasetsryKbn;
    }

    public void setKawasetsryKbn(C_KawasetsryKbn pKawasetsryKbn) {
        kawasetsryKbn = pKawasetsryKbn;
    }

    public C_EigyoubiHoseiKbn getEigyoubiHoseiKbn() {
        return eigyoubiHoseiKbn;
    }

    public void setEigyoubiHoseiKbn(C_EigyoubiHoseiKbn pEigyoubiHoseiKbn) {
        eigyoubiHoseiKbn = pEigyoubiHoseiKbn;
    }

    public C_YouhiKbn getYouhiKbn() {
        return youhiKbn;
    }

    public void setYouhiKbn(C_YouhiKbn pYouhiKbn) {
        youhiKbn = pYouhiKbn;
    }

}
