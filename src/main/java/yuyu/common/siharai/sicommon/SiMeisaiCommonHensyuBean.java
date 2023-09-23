package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細書共通編集Bean
 */
public class SiMeisaiCommonHensyuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_Tuukasyu kykTuukaSyu;

    private BizDate knsnKijyunYmd;

    private BizNumber kawaseRate;

    private BizNumber gaikaKnsnKwsRate;

    private BizDate sibouYmd;

    private BizCurrency hokenKngk;

    private BizCurrency yenHokenKngk;

    private BizCurrency haitouKin;

    private BizCurrency yenkaHaitouKin;

    private BizCurrency sonotaHaitouKin;

    private BizCurrency yenkaSonotaHaitouKin;

    private Integer misyuupJyuutouKaisuuY;

    private Integer misyuupJyuutouKaisuuM;

    private BizDateYM misyuupJyuutouYm;

    private BizCurrency misyuuP;

    private BizCurrency yenkaMisyuuP;

    private Integer mikeikapJyuutouKaisuuY;

    private Integer mikeikapJyuutouKaisuuM;

    private BizDateYM mikeikapJyuutouYm;

    private BizCurrency mikeikaP;

    private BizCurrency yenkaMikeikaP;

    private BizCurrency zennouSeisankGk;

    private BizCurrency yenkaZennouSeisankGk;

    private BizCurrency zitkazukaRikinGkSiteiTuuka;

    private BizCurrency zitkazukaRikinGkYen;

    private BizCurrency krkGk;

    private BizCurrency yenkaKrkGk;

    private BizCurrency tienRsk;

    private BizCurrency YenTienRsk;

    private C_SinsaGendoKknKbn sinsaGendokKnKbn;

    private Integer tienRskNissuu;

    private BizCurrency gaikaKnsntkGk;

    private BizCurrency gaikaKnsnKekkaGk;

    private BizCurrency yenkaKnsntkGk;

    private BizCurrency yenkaKnsnKekkaGk;

    public SiMeisaiCommonHensyuBean() {
        super();
    }

    public C_Tuukasyu getKykTuukaSyu() {
        return kykTuukaSyu;
    }

    public void setKykTuukaSyu(C_Tuukasyu pKykTuukaSyu) {
        kykTuukaSyu = pKykTuukaSyu;
    }

    public BizDate getKnsnKijyunYmd() {
        return knsnKijyunYmd;
    }

    public void setKnsnKijyunYmd(BizDate pKnsnKijyunYmd) {
        knsnKijyunYmd = pKnsnKijyunYmd;
    }

    public BizNumber getKawaseRate() {
        return kawaseRate;
    }

    public void setKawaseRate(BizNumber pKawaseRate) {
        kawaseRate = pKawaseRate;
    }

    public BizNumber getGaikaKnsnKwsRate() {
        return gaikaKnsnKwsRate;
    }

    public void setGaikaKnsnKwsRate(BizNumber pGaikaKnsnKwsRate) {
        gaikaKnsnKwsRate = pGaikaKnsnKwsRate;
    }

    public BizDate getSibouYmd() {
        return sibouYmd;
    }

    public void setSibouYmd(BizDate pSibouYmd) {
        sibouYmd = pSibouYmd;
    }

    public BizCurrency getHokenKngk() {
        return hokenKngk;
    }

    public void setHokenKngk(BizCurrency pHokenKngk) {
        hokenKngk = pHokenKngk;
    }

    public BizCurrency getYenHokenKngk() {
        return yenHokenKngk;
    }

    public void setYenHokenKngk(BizCurrency pYenHokenKngk) {
        yenHokenKngk = pYenHokenKngk;
    }

    public BizCurrency getHaitouKin() {
        return haitouKin;
    }

    public void setHaitouKin(BizCurrency pHaitouKin) {
        haitouKin = pHaitouKin;
    }

    public BizCurrency getYenkaHaitouKin() {
        return yenkaHaitouKin;
    }

    public void setYenkaHaitouKin(BizCurrency pYenkaHaitouKin) {
        yenkaHaitouKin = pYenkaHaitouKin;
    }

    public BizCurrency getSonotaHaitouKin() {
        return sonotaHaitouKin;
    }

    public void setSonotaHaitouKin(BizCurrency pSonotaHaitouKin) {
        sonotaHaitouKin = pSonotaHaitouKin;
    }

    public BizCurrency getYenkaSonotaHaitouKin() {
        return yenkaSonotaHaitouKin;
    }

    public void setYenkaSonotaHaitouKin(BizCurrency pYenkaSonotaHaitouKin) {
        yenkaSonotaHaitouKin = pYenkaSonotaHaitouKin;
    }

    public Integer getMisyuupJyuutouKaisuuY() {
        return misyuupJyuutouKaisuuY;
    }

    public void setMisyuupJyuutouKaisuuY(Integer pMisyuupJyuutouKaisuuY) {
        misyuupJyuutouKaisuuY = pMisyuupJyuutouKaisuuY;
    }

    public Integer getMisyuupJyuutouKaisuuM() {
        return misyuupJyuutouKaisuuM;
    }

    public void setMisyuupJyuutouKaisuuM(Integer pMisyuupJyuutouKaisuuM) {
        misyuupJyuutouKaisuuM = pMisyuupJyuutouKaisuuM;
    }

    public BizDateYM getMisyuupJyuutouYm() {
        return misyuupJyuutouYm;
    }

    public void setMisyuupJyuutouYm(BizDateYM pMisyuupJyuutouYm) {
        misyuupJyuutouYm = pMisyuupJyuutouYm;
    }

    public BizCurrency getMisyuuP() {
        return misyuuP;
    }

    public void setMisyuuP(BizCurrency pMisyuuP) {
        misyuuP = pMisyuuP;
    }

    public BizCurrency getYenkaMisyuuP() {
        return yenkaMisyuuP;
    }

    public void setYenkaMisyuuP(BizCurrency pYenkaMisyuuP) {
        yenkaMisyuuP = pYenkaMisyuuP;
    }

    public Integer getMikeikapJyuutouKaisuuY() {
        return mikeikapJyuutouKaisuuY;
    }

    public void setMikeikapJyuutouKaisuuY(Integer pMikeikapJyuutouKaisuuY) {
        mikeikapJyuutouKaisuuY = pMikeikapJyuutouKaisuuY;
    }

    public Integer getMikeikapJyuutouKaisuuM() {
        return mikeikapJyuutouKaisuuM;
    }

    public void setMikeikapJyuutouKaisuuM(Integer pMikeikapJyuutouKaisuuM) {
        mikeikapJyuutouKaisuuM = pMikeikapJyuutouKaisuuM;
    }

    public BizDateYM getMikeikapJyuutouYm() {
        return mikeikapJyuutouYm;
    }

    public void setMikeikapJyuutouYm(BizDateYM pMikeikapJyuutouYm) {
        mikeikapJyuutouYm = pMikeikapJyuutouYm;
    }

    public BizCurrency getMikeikaP() {
        return mikeikaP;
    }

    public void setMikeikaP(BizCurrency pMikeikaP) {
        mikeikaP = pMikeikaP;
    }

    public BizCurrency getYenkaMikeikaP() {
        return yenkaMikeikaP;
    }

    public void setYenkaMikeikaP(BizCurrency pYenkaMikeikaP) {
        yenkaMikeikaP = pYenkaMikeikaP;
    }

    public BizCurrency getZennouSeisankGk() {
        return zennouSeisankGk;
    }

    public void setZennouSeisankGk(BizCurrency pZennouSeisankGk) {
        zennouSeisankGk = pZennouSeisankGk;
    }

    public BizCurrency getYenkaZennouSeisankGk() {
        return yenkaZennouSeisankGk;
    }

    public void setYenkaZennouSeisankGk(BizCurrency pYenkaZennouSeisankGk) {
        yenkaZennouSeisankGk = pYenkaZennouSeisankGk;
    }

    public BizCurrency getZitkazukaRikinGkSiteiTuuka() {
        return zitkazukaRikinGkSiteiTuuka;
    }

    public void setZitkazukaRikinGkSiteiTuuka(BizCurrency pZitkazukaRikinGkSiteiTuuka) {
        zitkazukaRikinGkSiteiTuuka = pZitkazukaRikinGkSiteiTuuka;
    }

    public BizCurrency getZitkazukaRikinGkYen() {
        return zitkazukaRikinGkYen;
    }

    public void setZitkazukaRikinGkYen(BizCurrency pZitkazukaRikinGkYen) {
        zitkazukaRikinGkYen = pZitkazukaRikinGkYen;
    }

    public BizCurrency getKrkGk() {
        return krkGk;
    }

    public void setKrkGk(BizCurrency pKrkGk) {
        krkGk = pKrkGk;
    }

    public BizCurrency getYenkaKrkGk() {
        return yenkaKrkGk;
    }

    public void setYenkaKrkGk(BizCurrency pYenkaKrkGk) {
        yenkaKrkGk = pYenkaKrkGk;
    }

    public BizCurrency getTienRsk() {
        return tienRsk;
    }

    public void setTienRsk(BizCurrency pTienRsk) {
        tienRsk = pTienRsk;
    }

    public BizCurrency getYenTienRsk() {
        return YenTienRsk;
    }

    public void setYenTienRsk(BizCurrency pYenTienRsk) {
        YenTienRsk = pYenTienRsk;
    }

    public C_SinsaGendoKknKbn getSinsaGendokKnKbn() {
        return sinsaGendokKnKbn;
    }

    public void setSinsaGendokKnKbn(C_SinsaGendoKknKbn pSinsaGendokKnKbn) {
        sinsaGendokKnKbn = pSinsaGendokKnKbn;
    }

    public Integer getTienRskNissuu() {
        return tienRskNissuu;
    }

    public void setTienRskNissuu(Integer pTienRskNissuu) {
        tienRskNissuu = pTienRskNissuu;
    }

    public BizCurrency getGaikaKnsntkGk() {
        return gaikaKnsntkGk;
    }

    public void setGaikaKnsntkGk(BizCurrency pGaikaKnsntkGk) {
        gaikaKnsntkGk = pGaikaKnsntkGk;
    }

    public BizCurrency getGaikaKnsnKekkaGk() {
        return gaikaKnsnKekkaGk;
    }

    public void setGaikaKnsnKekkaGk(BizCurrency pGaikaKnsnKekkaGk) {
        gaikaKnsnKekkaGk = pGaikaKnsnKekkaGk;
    }

    public BizCurrency getYenkaKnsntkGk() {
        return yenkaKnsntkGk;
    }

    public void setYenkaKnsntkGk(BizCurrency pYenkaKnsntkGk) {
        yenkaKnsntkGk = pYenkaKnsntkGk;
    }

    public BizCurrency getYenkaKnsnKekkaGk() {
        return yenkaKnsnKekkaGk;
    }

    public void setYenkaKnsnKekkaGk(BizCurrency pYenkaKnsnKekkaGk) {
        yenkaKnsnKekkaGk = pYenkaKnsnKekkaGk;
    }

}
