package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZeitratkiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細書共通計算Bean
 */
public class SiMeisaiCommonCalcBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_Tuukasyu kykTuukasyu;

    private C_Tuukasyu shrTuukasyu;

    private BizNumber kawaseRate;

    private BizNumber gaikaknsnkwsrate;

    private BizNumber zeimukwsrate;

    private BizCurrency hokenkngkgoukei;

    private BizCurrency zennouseisankgk;

    private BizCurrency yenkazennouseisankgk;

    private BizCurrency misyuup;

    private BizCurrency mikeikap;

    private BizCurrency yenkamikeikap;

    private BizCurrency haitoukin;

    private BizCurrency yenkahaitoukin;

    private BizCurrency sonotahaitoukin;

    private BizCurrency yenkasonotahaitoukin;

    private BizCurrency zitkazukarikingksiteituuka;

    private BizCurrency zitkazukarikingkyen;

    private BizCurrency yenkakrkgk;

    private C_ZeitratkiKbn zeitratkikbn;

    private String syouhinCd;

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu kykTuukasyu) {
        this.kykTuukasyu = kykTuukasyu;
    }

    public C_Tuukasyu getShrTuukasyu() {
        return shrTuukasyu;
    }

    public void setShrTuukasyu(C_Tuukasyu shrTuukasyu) {
        this.shrTuukasyu = shrTuukasyu;
    }

    public BizNumber getKawaseRate() {
        return kawaseRate;
    }

    public void setKawaseRate(BizNumber kawaseRate) {
        this.kawaseRate = kawaseRate;
    }

    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber gaikaknsnkwsrate) {
        this.gaikaknsnkwsrate = gaikaknsnkwsrate;
    }

    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber zeimukwsrate) {
        this.zeimukwsrate = zeimukwsrate;
    }

    public BizCurrency getHokenkngkgoukei() {
        return hokenkngkgoukei;
    }

    public void setHokenkngkgoukei(BizCurrency hokenkngkgoukei) {
        this.hokenkngkgoukei = hokenkngkgoukei;
    }

    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency zennouseisankgk) {
        this.zennouseisankgk = zennouseisankgk;
    }

    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    public void setYenkazennouseisankgk(BizCurrency yenkazennouseisankgk) {
        this.yenkazennouseisankgk = yenkazennouseisankgk;
    }

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency misyuup) {
        this.misyuup = misyuup;
    }

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency mikeikap) {
        this.mikeikap = mikeikap;
    }

    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency yenkamikeikap) {
        this.yenkamikeikap = yenkamikeikap;
    }

    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    public void setHaitoukin(BizCurrency haitoukin) {
        this.haitoukin = haitoukin;
    }

    public BizCurrency getYenkahaitoukin() {
        return yenkahaitoukin;
    }

    public void setYenkahaitoukin(BizCurrency yenkahaitoukin) {
        this.yenkahaitoukin = yenkahaitoukin;
    }

    public BizCurrency getSonotahaitoukin() {
        return sonotahaitoukin;
    }

    public void setSonotahaitoukin(BizCurrency sonotahaitoukin) {
        this.sonotahaitoukin = sonotahaitoukin;
    }

    public BizCurrency getYenkasonotahaitoukin() {
        return yenkasonotahaitoukin;
    }

    public void setYenkasonotahaitoukin(BizCurrency yenkasonotahaitoukin) {
        this.yenkasonotahaitoukin = yenkasonotahaitoukin;
    }

    public BizCurrency getZitkazukarikingksiteituuka() {
        return zitkazukarikingksiteituuka;
    }

    public void setZitkazukarikingksiteituuka(BizCurrency zitkazukarikingksiteituuka) {
        this.zitkazukarikingksiteituuka = zitkazukarikingksiteituuka;
    }

    public BizCurrency getZitkazukarikingkyen() {
        return zitkazukarikingkyen;
    }

    public void setZitkazukarikingkyen(BizCurrency zitkazukarikingkyen) {
        this.zitkazukarikingkyen = zitkazukarikingkyen;
    }

    public BizCurrency getYenkakrkgk() {
        return yenkakrkgk;
    }

    public void setYenkakrkgk(BizCurrency yenkakrkgk) {
        this.yenkakrkgk = yenkakrkgk;
    }

    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn zeitratkikbn) {
        this.zeitratkikbn = zeitratkikbn;
    }

    public String getSyouhinCd() {
        return syouhinCd;
    }

    public void setSyouhinCd(String pSyouhinCd) {
        this.syouhinCd = pSyouhinCd;
    }
}
