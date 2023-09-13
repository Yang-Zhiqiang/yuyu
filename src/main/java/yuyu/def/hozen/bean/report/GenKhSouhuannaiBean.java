package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MosKbn;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * （保全）送付案内帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSouhuannaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSouhuannaiBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private String irShsnmkj;

    public String getIrShsnmkj() {
        return irShsnmkj;
    }

    public void setIrShsnmkj(String pIrShsnmkj) {
        irShsnmkj = pIrShsnmkj;
    }

    private String irSouhuannaimsg1;

    public String getIrSouhuannaimsg1() {
        return irSouhuannaimsg1;
    }

    public void setIrSouhuannaimsg1(String pIrSouhuannaimsg1) {
        irSouhuannaimsg1 = pIrSouhuannaimsg1;
    }

    private String irSouhuannaimsg2;

    public String getIrSouhuannaimsg2() {
        return irSouhuannaimsg2;
    }

    public void setIrSouhuannaimsg2(String pIrSouhuannaimsg2) {
        irSouhuannaimsg2 = pIrSouhuannaimsg2;
    }

    private String irSouhuannaimsg3;

    public String getIrSouhuannaimsg3() {
        return irSouhuannaimsg3;
    }

    public void setIrSouhuannaimsg3(String pIrSouhuannaimsg3) {
        irSouhuannaimsg3 = pIrSouhuannaimsg3;
    }

    private String irSouhuannaimsg4;

    public String getIrSouhuannaimsg4() {
        return irSouhuannaimsg4;
    }

    public void setIrSouhuannaimsg4(String pIrSouhuannaimsg4) {
        irSouhuannaimsg4 = pIrSouhuannaimsg4;
    }

    private String irSouhuannaimsg5;

    public String getIrSouhuannaimsg5() {
        return irSouhuannaimsg5;
    }

    public void setIrSouhuannaimsg5(String pIrSouhuannaimsg5) {
        irSouhuannaimsg5 = pIrSouhuannaimsg5;
    }

    private String irSouhuannaimsg6;

    public String getIrSouhuannaimsg6() {
        return irSouhuannaimsg6;
    }

    public void setIrSouhuannaimsg6(String pIrSouhuannaimsg6) {
        irSouhuannaimsg6 = pIrSouhuannaimsg6;
    }

    private String irSouhuannaimsg7;

    public String getIrSouhuannaimsg7() {
        return irSouhuannaimsg7;
    }

    public void setIrSouhuannaimsg7(String pIrSouhuannaimsg7) {
        irSouhuannaimsg7 = pIrSouhuannaimsg7;
    }

    private String irSouhuannaimsg8;

    public String getIrSouhuannaimsg8() {
        return irSouhuannaimsg8;
    }

    public void setIrSouhuannaimsg8(String pIrSouhuannaimsg8) {
        irSouhuannaimsg8 = pIrSouhuannaimsg8;
    }

    private String irSouhuannaimsg9;

    public String getIrSouhuannaimsg9() {
        return irSouhuannaimsg9;
    }

    public void setIrSouhuannaimsg9(String pIrSouhuannaimsg9) {
        irSouhuannaimsg9 = pIrSouhuannaimsg9;
    }

    private String irSouhuannaimsg10;

    public String getIrSouhuannaimsg10() {
        return irSouhuannaimsg10;
    }

    public void setIrSouhuannaimsg10(String pIrSouhuannaimsg10) {
        irSouhuannaimsg10 = pIrSouhuannaimsg10;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irHhknnmkj;

    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }

    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }

    private C_TargetTkKbn irTargettkkbn;

    public C_TargetTkKbn getIrTargettkkbn() {
        return irTargettkkbn;
    }

    public void setIrTargettkkbn(C_TargetTkKbn pIrTargettkkbn) {
        irTargettkkbn = pIrTargettkkbn;
    }

    private String irSyosaihkymd;

    public String getIrSyosaihkymd() {
        return irSyosaihkymd;
    }

    public void setIrSyosaihkymd(String pIrSyosaihkymd) {
        irSyosaihkymd = pIrSyosaihkymd;
    }

    private String irNexttkshrkjt;

    public String getIrNexttkshrkjt() {
        return irNexttkshrkjt;
    }

    public void setIrNexttkshrkjt(String pIrNexttkshrkjt) {
        irNexttkshrkjt = pIrNexttkshrkjt;
    }

    private String irSeikyuukigenymd;

    public String getIrSeikyuukigenymd() {
        return irSeikyuukigenymd;
    }

    public void setIrSeikyuukigenymd(String pIrSeikyuukigenymd) {
        irSeikyuukigenymd = pIrSeikyuukigenymd;
    }

    private C_SyoruiCdKbn irSyoruicd;

    public C_SyoruiCdKbn getIrSyoruicd() {
        return irSyoruicd;
    }

    public void setIrSyoruicd(C_SyoruiCdKbn pIrSyoruicd) {
        irSyoruicd = pIrSyoruicd;
    }

    private C_UmuKbn irHengakuumukbn;

    public C_UmuKbn getIrHengakuumukbn() {
        return irHengakuumukbn;
    }

    public void setIrHengakuumukbn(C_UmuKbn pIrHengakuumukbn) {
        irHengakuumukbn = pIrHengakuumukbn;
    }

    private C_UmuKbn irSibousumukbn;

    public C_UmuKbn getIrSibousumukbn() {
        return irSibousumukbn;
    }

    public void setIrSibousumukbn(C_UmuKbn pIrSibousumukbn) {
        irSibousumukbn = pIrSibousumukbn;
    }

    private C_UmuKbn irSiboukyhkumukbn;

    public C_UmuKbn getIrSiboukyhkumukbn() {
        return irSiboukyhkumukbn;
    }

    public void setIrSiboukyhkumukbn(C_UmuKbn pIrSiboukyhkumukbn) {
        irSiboukyhkumukbn = pIrSiboukyhkumukbn;
    }

    private C_UmuKbn irStdrsktkyumukbn;

    public C_UmuKbn getIrStdrsktkyumukbn() {
        return irStdrsktkyumukbn;
    }

    public void setIrStdrsktkyumukbn(C_UmuKbn pIrStdrsktkyumukbn) {
        irStdrsktkyumukbn = pIrStdrsktkyumukbn;
    }

    private C_UmuKbn irTargettkhkumu;

    public C_UmuKbn getIrTargettkhkumu() {
        return irTargettkhkumu;
    }

    public void setIrTargettkhkumu(C_UmuKbn pIrTargettkhkumu) {
        irTargettkhkumu = pIrTargettkhkumu;
    }

    private C_TargetTkHenkouKbn irTargettkhnkkbn;

    public C_TargetTkHenkouKbn getIrTargettkhnkkbn() {
        return irTargettkhnkkbn;
    }

    public void setIrTargettkhnkkbn(C_TargetTkHenkouKbn pIrTargettkhnkkbn) {
        irTargettkhnkkbn = pIrTargettkhnkkbn;
    }

    private C_Tdk irKkkyktdk;

    public C_Tdk getIrKkkyktdk() {
        return irKkkyktdk;
    }

    public void setIrKkkyktdk(C_Tdk pIrKkkyktdk) {
        irKkkyktdk = pIrKkkyktdk;
    }

    private C_UmuKbn irHenkankinumukbn;

    public C_UmuKbn getIrHenkankinumukbn() {
        return irHenkankinumukbn;
    }

    public void setIrHenkankinumukbn(C_UmuKbn pIrHenkankinumukbn) {
        irHenkankinumukbn = pIrHenkankinumukbn;
    }

    private C_UmuKbn irShrumu;

    public C_UmuKbn getIrShrumu() {
        return irShrumu;
    }

    public void setIrShrumu(C_UmuKbn pIrShrumu) {
        irShrumu = pIrShrumu;
    }

    private C_NstkhKbn irNkshrtkykhnkkbn;

    public C_NstkhKbn getIrNkshrtkykhnkkbn() {
        return irNkshrtkykhnkkbn;
    }

    public void setIrNkshrtkykhnkkbn(C_NstkhKbn pIrNkshrtkykhnkkbn) {
        irNkshrtkykhnkkbn = pIrNkshrtkykhnkkbn;
    }

    private C_Meigihnkjiyuu irMeigihnkjiyuu;

    public C_Meigihnkjiyuu getIrMeigihnkjiyuu() {
        return irMeigihnkjiyuu;
    }

    public void setIrMeigihnkjiyuu(C_Meigihnkjiyuu pIrMeigihnkjiyuu) {
        irMeigihnkjiyuu = pIrMeigihnkjiyuu;
    }

    private C_Kaiyakujiyuu irKaiyakujiyuu;

    public C_Kaiyakujiyuu getIrKaiyakujiyuu() {
        return irKaiyakujiyuu;
    }

    public void setIrKaiyakujiyuu(C_Kaiyakujiyuu pIrKaiyakujiyuu) {
        irKaiyakujiyuu = pIrKaiyakujiyuu;
    }

    private String irHknkisynm;

    public String getIrHknkisynm() {
        return irHknkisynm;
    }

    public void setIrHknkisynm(String pIrHknkisynm) {
        irHknkisynm = pIrHknkisynm;
    }

    private C_KyksyaSibouUmuKbn irKyksbumu;

    public C_KyksyaSibouUmuKbn getIrKyksbumu() {
        return irKyksbumu;
    }

    public void setIrKyksbumu(C_KyksyaSibouUmuKbn pIrKyksbumu) {
        irKyksbumu = pIrKyksbumu;
    }

    private C_UmuKbn irTuityouumu;

    public C_UmuKbn getIrTuityouumu() {
        return irTuityouumu;
    }

    public void setIrTuityouumu(C_UmuKbn pIrTuityouumu) {
        irTuityouumu = pIrTuityouumu;
    }

    private C_YuukousyoumetuKbn irYuukousyoumetukbn;

    public C_YuukousyoumetuKbn getIrYuukousyoumetukbn() {
        return irYuukousyoumetukbn;
    }

    public void setIrYuukousyoumetukbn(C_YuukousyoumetuKbn pIrYuukousyoumetukbn) {
        irYuukousyoumetukbn = pIrYuukousyoumetukbn;
    }

    private C_UmuKbn irHrkkeirohnkumu;

    public C_UmuKbn getIrHrkkeirohnkumu() {
        return irHrkkeirohnkumu;
    }

    public void setIrHrkkeirohnkumu(C_UmuKbn pIrHrkkeirohnkumu) {
        irHrkkeirohnkumu = pIrHrkkeirohnkumu;
    }

    private C_UmuKbn irHrkkaisuuhnkumu;

    public C_UmuKbn getIrHrkkaisuuhnkumu() {
        return irHrkkaisuuhnkumu;
    }

    public void setIrHrkkaisuuhnkumu(C_UmuKbn pIrHrkkaisuuhnkumu) {
        irHrkkaisuuhnkumu = pIrHrkkaisuuhnkumu;
    }

    private BizCurrency irKaiykhmk;

    public BizCurrency getIrKaiykhmk() {
        return irKaiykhmk;
    }

    public void setIrKaiykhmk(BizCurrency pIrKaiykhmk) {
        irKaiykhmk = pIrKaiykhmk;
    }

    private String irTsinyno;

    public String getIrTsinyno() {
        return irTsinyno;
    }

    public void setIrTsinyno(String pIrTsinyno) {
        irTsinyno = pIrTsinyno;
    }

    private String irTsinadr1kj;

    public String getIrTsinadr1kj() {
        return irTsinadr1kj;
    }

    public void setIrTsinadr1kj(String pIrTsinadr1kj) {
        irTsinadr1kj = pIrTsinadr1kj;
    }

    private String irTsinadr2kj;

    public String getIrTsinadr2kj() {
        return irTsinadr2kj;
    }

    public void setIrTsinadr2kj(String pIrTsinadr2kj) {
        irTsinadr2kj = pIrTsinadr2kj;
    }

    private String irTsinadr3kj;

    public String getIrTsinadr3kj() {
        return irTsinadr3kj;
    }

    public void setIrTsinadr3kj(String pIrTsinadr3kj) {
        irTsinadr3kj = pIrTsinadr3kj;
    }

    private String irTsinadr4kj;

    public String getIrTsinadr4kj() {
        return irTsinadr4kj;
    }

    public void setIrTsinadr4kj(String pIrTsinadr4kj) {
        irTsinadr4kj = pIrTsinadr4kj;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private String irCctelno;

    public String getIrCctelno() {
        return irCctelno;
    }

    public void setIrCctelno(String pIrCctelno) {
        irCctelno = pIrCctelno;
    }

    private String irTyouhyoutitle;

    public String getIrTyouhyoutitle() {
        return irTyouhyoutitle;
    }

    public void setIrTyouhyoutitle(String pIrTyouhyoutitle) {
        irTyouhyoutitle = pIrTyouhyoutitle;
    }

    private String irCcimagepath;

    public String getIrCcimagepath() {
        return irCcimagepath;
    }

    public void setIrCcimagepath(String pIrCcimagepath) {
        irCcimagepath = pIrCcimagepath;
    }

    private C_Hrkkaisuu irHrkkaisuu;

    public C_Hrkkaisuu getIrHrkkaisuu() {
        return irHrkkaisuu;
    }

    public void setIrHrkkaisuu(C_Hrkkaisuu pIrHrkkaisuu) {
        irHrkkaisuu = pIrHrkkaisuu;
    }

    private C_MosKbn irMoskbn;

    public C_MosKbn getIrMoskbn() {
        return irMoskbn;
    }

    public void setIrMoskbn(C_MosKbn pIrMoskbn) {
        irMoskbn = pIrMoskbn;
    }

    private C_YouhiblnkKbn irFatcakakuninyhkbn;

    public C_YouhiblnkKbn getIrFatcakakuninyhkbn() {
        return irFatcakakuninyhkbn;
    }

    public void setIrFatcakakuninyhkbn(C_YouhiblnkKbn pIrFatcakakuninyhkbn) {
        irFatcakakuninyhkbn = pIrFatcakakuninyhkbn;
    }

    private C_UmuKbn irTrhkjikakumukbn;

    public C_UmuKbn getIrTrhkjikakumukbn() {
        return irTrhkjikakumukbn;
    }

    public void setIrTrhkjikakumukbn(C_UmuKbn pIrTrhkjikakumukbn) {
        irTrhkjikakumukbn = pIrTrhkjikakumukbn;
    }

    private String irSyouhnnm;

    public String getIrSyouhnnm() {
        return irSyouhnnm;
    }

    public void setIrSyouhnnm(String pIrSyouhnnm) {
        irSyouhnnm = pIrSyouhnnm;
    }

    private C_KykMsnKbn irKykmsnkbn;

    public C_KykMsnKbn getIrKykmsnkbn() {
        return irKykmsnkbn;
    }

    public void setIrKykmsnkbn(C_KykMsnKbn pIrKykmsnkbn) {
        irKykmsnkbn = pIrKykmsnkbn;
    }

    private C_JyudkaigomaebaraiTkykhnkKbn irJyudkaigomaebrtkykhnkkbn;

    public C_JyudkaigomaebaraiTkykhnkKbn getIrJyudkaigomaebrtkykhnkkbn() {
        return irJyudkaigomaebrtkykhnkkbn;
    }

    public void setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn pIrJyudkaigomaebrtkykhnkkbn) {
        irJyudkaigomaebrtkykhnkkbn = pIrJyudkaigomaebrtkykhnkkbn;
    }

    private C_UmuKbn irHhknseiymdhenkouumu;

    public C_UmuKbn getIrHhknseiymdhenkouumu() {
        return irHhknseiymdhenkouumu;
    }

    public void setIrHhknseiymdhenkouumu(C_UmuKbn pIrHhknseiymdhenkouumu) {
        irHhknseiymdhenkouumu = pIrHhknseiymdhenkouumu;
    }

    private C_UmuKbn irHhknseihenkouumu;

    public C_UmuKbn getIrHhknseihenkouumu() {
        return irHhknseihenkouumu;
    }

    public void setIrHhknseihenkouumu(C_UmuKbn pIrHhknseihenkouumu) {
        irHhknseihenkouumu = pIrHhknseihenkouumu;
    }

    private C_Tuukasyu irKyktuukasyu;

    public C_Tuukasyu getIrKyktuukasyu() {
        return irKyktuukasyu;
    }

    public void setIrKyktuukasyu(C_Tuukasyu pIrKyktuukasyu) {
        irKyktuukasyu = pIrKyktuukasyu;
    }

    private BizCurrency irYendthnkHrgk;

    public BizCurrency getIrYendthnkHrgk() {
        return irYendthnkHrgk;
    }

    public void setIrYendthnkHrgk(BizCurrency pIrYendthnkHrgk) {
        irYendthnkHrgk = pIrYendthnkHrgk;
    }

    private C_Khhrshrjiyuu irKhhrshrjiyuu;

    public C_Khhrshrjiyuu getIrKhhrshrjiyuu() {
        return irKhhrshrjiyuu;
    }

    public void setIrKhhrshrjiyuu(C_Khhrshrjiyuu pIrKhhrshrjiyuu) {
        irKhhrshrjiyuu = pIrKhhrshrjiyuu;
    }

    private C_Khskssakuseijiyuu irKhskssakuseijiyuu;

    public C_Khskssakuseijiyuu getIrKhskssakuseijiyuu() {
        return irKhskssakuseijiyuu;
    }

    public void setIrKhskssakuseijiyuu(C_Khskssakuseijiyuu pIrKhskssakuseijiyuu) {
        irKhskssakuseijiyuu = pIrKhskssakuseijiyuu;
    }

    private C_Tmttknitenkbn irTmttknitenkbn;

    public C_Tmttknitenkbn getIrTmttknitenkbn() {
        return irTmttknitenkbn;
    }

    public void setIrTmttknitenkbn(C_Tmttknitenkbn pIrTmttknitenkbn) {
        irTmttknitenkbn = pIrTmttknitenkbn;
    }

    private String irTmttknitenuktkstartymd;

    public String getIrTmttknitenuktkstartymd() {
        return irTmttknitenuktkstartymd;
    }

    public void setIrTmttknitenuktkstartymd(String pIrTmttknitenuktkstartymd) {
        irTmttknitenuktkstartymd = pIrTmttknitenuktkstartymd;
    }

    private String irSyoruiuktkkigenymd;

    public String getIrSyoruiuktkkigenymd() {
        return irSyoruiuktkkigenymd;
    }

    public void setIrSyoruiuktkkigenymd(String pIrSyoruiuktkkigenymd) {
        irSyoruiuktkkigenymd = pIrSyoruiuktkkigenymd;
    }

    private C_UmuKbn irGsbunritaisyouumukbn;

    public C_UmuKbn getIrGsbunritaisyouumukbn() {
        return irGsbunritaisyouumukbn;
    }

    public void setIrGsbunritaisyouumukbn(C_UmuKbn pIrGsbunritaisyouumukbn) {
        irGsbunritaisyouumukbn = pIrGsbunritaisyouumukbn;
    }

    private Integer irSyouhnhanteikekka;

    public Integer getIrSyouhnhanteikekka() {
        return irSyouhnhanteikekka;
    }

    public void setIrSyouhnhanteikekka(Integer pIrSyouhnhanteikekka) {
        irSyouhnhanteikekka = pIrSyouhnhanteikekka;
    }

    private C_KahiKbn irDskaiyakukahikbn;

    public C_KahiKbn getIrDskaiyakukahikbn() {
        return irDskaiyakukahikbn;
    }

    public void setIrDskaiyakukahikbn(C_KahiKbn pIrDskaiyakukahikbn) {
        irDskaiyakukahikbn = pIrDskaiyakukahikbn;
    }

    private C_TmttknhaibunjyoutaiKbn irTmttknhaibunjyoutai;

    public C_TmttknhaibunjyoutaiKbn getIrTmttknhaibunjyoutai() {
        return irTmttknhaibunjyoutai;
    }

    public void setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn pIrTmttknhaibunjyoutai) {
        irTmttknhaibunjyoutai = pIrTmttknhaibunjyoutai;
    }

    private String irCalckijyunymd;

    public String getIrCalckijyunymd() {
        return irCalckijyunymd;
    }

    public void setIrCalckijyunymd(String pIrCalckijyunymd) {
        irCalckijyunymd = pIrCalckijyunymd;
    }

    private BizCurrency irTmtthtkinzndk;

    public BizCurrency getIrTmtthtkinzndk() {
        return irTmtthtkinzndk;
    }

    public void setIrTmtthtkinzndk(BizCurrency pIrTmtthtkinzndk) {
        irTmtthtkinzndk = pIrTmtthtkinzndk;
    }

    private C_UmuKbn irZeiseitkkktkykhukaumu;

    public C_UmuKbn getIrZeiseitkkktkykhukaumu() {
        return irZeiseitkkktkykhukaumu;
    }

    public void setIrZeiseitkkktkykhukaumu(C_UmuKbn pIrZeiseitkkktkykhukaumu) {
        irZeiseitkkktkykhukaumu = pIrZeiseitkkktkykhukaumu;
    }

    private C_Kykjyoutai irKykjyoutai;

    public C_Kykjyoutai getIrKykjyoutai() {
        return irKykjyoutai;
    }

    public void setIrKykjyoutai(C_Kykjyoutai pIrKykjyoutai) {
        irKykjyoutai = pIrKykjyoutai;
    }

    private C_KahiKbn irTmttknitenuktkkahikbn;

    public C_KahiKbn getIrTmttknitenuktkkahikbn() {
        return irTmttknitenuktkkahikbn;
    }

    public void setIrTmttknitenuktkkahikbn(C_KahiKbn pIrTmttknitenuktkkahikbn) {
        irTmttknitenuktkkahikbn = pIrTmttknitenuktkkahikbn;
    }

    private String irSyoumetuymd;

    public String getIrSyoumetuymd() {
        return irSyoumetuymd;
    }

    public void setIrSyoumetuymd(String pIrSyoumetuymd) {
        irSyoumetuymd = pIrSyoumetuymd;
    }

    private BizCurrency irHaraimodosikngk;

    public BizCurrency getIrHaraimodosikngk() {
        return irHaraimodosikngk;
    }

    public void setIrHaraimodosikngk(BizCurrency pIrHaraimodosikngk) {
        irHaraimodosikngk = pIrHaraimodosikngk;
    }

    private String irKykymd;

    public String getIrKykymd() {
        return irKykymd;
    }

    public void setIrKykymd(String pIrKykymd) {
        irKykymd = pIrKykymd;
    }

    private C_UmuKbn irMynosinkokutaisyouumukbn;

    public C_UmuKbn getIrMynosinkokutaisyouumukbn() {
        return irMynosinkokutaisyouumukbn;
    }

    public void setIrMynosinkokutaisyouumukbn(C_UmuKbn pIrMynosinkokutaisyouumukbn) {
        irMynosinkokutaisyouumukbn = pIrMynosinkokutaisyouumukbn;
    }

    private C_KykdrknHtdjytKbn irKykdrknhatudoujyoutai;

    public C_KykdrknHtdjytKbn getIrKykdrknhatudoujyoutai() {
        return irKykdrknhatudoujyoutai;
    }

    public void setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pIrKykdrknhatudoujyoutai) {
        irKykdrknhatudoujyoutai = pIrKykdrknhatudoujyoutai;
    }

    private C_MousideninKbn irMousideninkbn;

    public C_MousideninKbn getIrMousideninkbn() {
        return irMousideninkbn;
    }

    public void setIrMousideninkbn(C_MousideninKbn pIrMousideninkbn) {
        irMousideninkbn = pIrMousideninkbn;
    }

    private String irSksnm;

    public String getIrSksnm() {
        return irSksnm;
    }

    public void setIrSksnm(String pIrSksnm) {
        irSksnm = pIrSksnm;
    }

    private C_UmuKbn irTeikishrtkykhukaumu;

    public C_UmuKbn getIrTeikishrtkykhukaumu() {
        return irTeikishrtkykhukaumu;
    }

    public void setIrTeikishrtkykhukaumu(C_UmuKbn pIrTeikishrtkykhukaumu) {
        irTeikishrtkykhukaumu = pIrTeikishrtkykhukaumu;
    }

    private C_MousideIkouKbn irMousideikoukbn;

    public C_MousideIkouKbn getIrMousideikoukbn() {
        return irMousideikoukbn;
    }

    public void setIrMousideikoukbn(C_MousideIkouKbn pIrMousideikoukbn) {
        irMousideikoukbn = pIrMousideikoukbn;
    }

    private C_UmuKbn irTuikahrkkinumu;

    public C_UmuKbn getIrTuikahrkkinumu() {
        return irTuikahrkkinumu;
    }

    public void setIrTuikahrkkinumu(C_UmuKbn pIrTuikahrkkinumu) {
        irTuikahrkkinumu = pIrTuikahrkkinumu;
    }

    private BizCurrency irTuikahrkkin;

    public BizCurrency getIrTuikahrkkin() {
        return irTuikahrkkin;
    }

    public void setIrTuikahrkkin(BizCurrency pIrTuikahrkkin) {
        irTuikahrkkin = pIrTuikahrkkin;
    }

    private String irYendthnkymd;

    public String getIrYendthnkymd() {
        return irYendthnkymd;
    }

    public void setIrYendthnkymd(String pIrYendthnkymd) {
        irYendthnkymd = pIrYendthnkymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
