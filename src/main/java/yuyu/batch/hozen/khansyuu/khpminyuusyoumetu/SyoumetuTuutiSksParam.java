package yuyu.batch.hozen.khansyuu.khpminyuusyoumetu;

import java.io.Serializable;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 案内収納 消滅通知情報作成パラメータ
 */
public class SyoumetuTuutiSksParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String henkouSikibetukey;

    private C_HassouKbn hassouKbn;

    private BizDate syoumetuYmd;

    private BizDate shrYmd;

    private BizDate kykYmd;

    private BizNumber yenShrrate;

    private BizCurrency shrtuukaKaiyakuhrkngkkei;

    private BizCurrency kaiyakuHrkngkkeiSiteituuka;

    private BizCurrency sonotaSeisan;

    private BizCurrency yenkansanhaitoukin;

    private BizCurrency yenSonotaHaitoukin;

    private BizCurrency shrtuukaGstszeigk;

    private BizCurrency zitkazukarikingkSiteituuka;

    private BizCurrency shrgkkei;

    private BizCurrency synykngk;

    private BizCurrency htykeihi;

    private BizCurrency yenShrkykhtykeihi;

    private Integer kykhnkKaisuu;

    private C_HtsiryosyuKbn  shrtysysyuruiKbn;

    public SyoumetuTuutiSksParam() {
        super();
    }

    public String getHenkouSikibetukey() {
        return henkouSikibetukey;
    }

    public void setHenkouSikibetukey(String pHenkouSikibetukey) {
        henkouSikibetukey = pHenkouSikibetukey;
    }

    public C_HassouKbn getHassouKbn() {
        return hassouKbn;
    }

    public void setHassouKbn(C_HassouKbn pHassouKbn) {
        hassouKbn = pHassouKbn;
    }

    public BizDate getSyoumetuYmd() {
        return syoumetuYmd;
    }

    public void setSyoumetuYmd(BizDate pSyoumetuYmd) {
        syoumetuYmd = pSyoumetuYmd;
    }

    public BizDate getShrYmd() {
        return shrYmd;
    }

    public void setShrYmd(BizDate pShrYmd) {
        shrYmd = pShrYmd;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public BizNumber getYenShrrate() {
        return yenShrrate;
    }

    public void setYenShrrate(BizNumber pYenShrrate) {
        yenShrrate = pYenShrrate;
    }

    public BizCurrency getShrtuukaKaiyakuhrkngkkei() {
        return shrtuukaKaiyakuhrkngkkei;
    }

    public void setShrtuukaKaiyakuhrkngkkei(BizCurrency pShrtuukaKaiyakuhrkngkkei) {
        shrtuukaKaiyakuhrkngkkei = pShrtuukaKaiyakuhrkngkkei;
    }

    public BizCurrency getKaiyakuHrkngkkeiSiteituuka() {
        return kaiyakuHrkngkkeiSiteituuka;
    }

    public void setKaiyakuHrkngkkeiSiteituuka(BizCurrency pKaiyakuHrkngkkeiSiteituuka) {
        kaiyakuHrkngkkeiSiteituuka = pKaiyakuHrkngkkeiSiteituuka;
    }

    public BizCurrency getSonotaSeisan() {
        return sonotaSeisan;
    }

    public void setSonotaSeisan(BizCurrency pSonotaSeisan) {
        sonotaSeisan = pSonotaSeisan;
    }

    public BizCurrency getYenkansanhaitoukin() {
        return yenkansanhaitoukin;
    }

    public void setYenkansanhaitoukin(BizCurrency pYenkansanhaitoukin) {
        yenkansanhaitoukin = pYenkansanhaitoukin;
    }

    public BizCurrency getYenSonotaHaitoukin() {
        return yenSonotaHaitoukin;
    }

    public void setYenSonotaHaitoukin(BizCurrency pYenSonotaHaitoukin) {
        yenSonotaHaitoukin = pYenSonotaHaitoukin;
    }

    public BizCurrency getShrtuukaGstszeigk() {
        return shrtuukaGstszeigk;
    }

    public void setShrtuukaGstszeigk(BizCurrency pShrtuukaGstszeigk) {
        shrtuukaGstszeigk = pShrtuukaGstszeigk;
    }

    public BizCurrency getZitkazukarikingkSiteituuka() {
        return zitkazukarikingkSiteituuka;
    }

    public void setZitkazukarikingkSiteituuka(BizCurrency pZitkazukarikingkSiteituuka) {
        zitkazukarikingkSiteituuka = pZitkazukarikingkSiteituuka;
    }

    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }

    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        synykngk = pSynykngk;
    }

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
    }

    public BizCurrency getYenShrkykhtykeihi() {
        return yenShrkykhtykeihi;
    }

    public void setYenShrkykhtykeihi(BizCurrency pYenShrkykhtykeihi) {
        yenShrkykhtykeihi = pYenShrkykhtykeihi;
    }

    public Integer getKykhnkKaisuu() {
        return kykhnkKaisuu;
    }

    public void setKykhnkKaisuu(Integer pKykhnkKaisuu) {
        kykhnkKaisuu = pKykhnkKaisuu;
    }

    public C_HtsiryosyuKbn  getShrtysysyuruiKbn() {
        return shrtysysyuruiKbn;
    }

    public void setShrtysysyuruiKbn(C_HtsiryosyuKbn  pShrtysysyuruiKbn) {
        shrtysysyuruiKbn = pShrtysysyuruiKbn;
    }

}
