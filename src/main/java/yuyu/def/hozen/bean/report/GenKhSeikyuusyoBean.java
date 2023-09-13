package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KeihiKbn;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MosKbn;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagetyuusiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）請求書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSeikyuusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSeikyuusyoBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irHknkisynm;

    public String getIrHknkisynm() {
        return irHknkisynm;
    }

    public void setIrHknkisynm(String pIrHknkisynm) {
        irHknkisynm = pIrHknkisynm;
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

    private String irTsintelno;

    public String getIrTsintelno() {
        return irTsintelno;
    }

    public void setIrTsintelno(String pIrTsintelno) {
        irTsintelno = pIrTsintelno;
    }

    private C_KyksyaSibouUmuKbn irKyksbumu;

    public C_KyksyaSibouUmuKbn getIrKyksbumu() {
        return irKyksbumu;
    }

    public void setIrKyksbumu(C_KyksyaSibouUmuKbn pIrKyksbumu) {
        irKyksbumu = pIrKyksbumu;
    }

    private C_UmuKbn irShrumu;

    public C_UmuKbn getIrShrumu() {
        return irShrumu;
    }

    public void setIrShrumu(C_UmuKbn pIrShrumu) {
        irShrumu = pIrShrumu;
    }

    private BizCurrency irKaiyakuhr;

    public BizCurrency getIrKaiyakuhr() {
        return irKaiyakuhr;
    }

    public void setIrKaiyakuhr(BizCurrency pIrKaiyakuhr) {
        irKaiyakuhr = pIrKaiyakuhr;
    }

    private BizCurrency irHrkp;

    public BizCurrency getIrHrkp() {
        return irHrkp;
    }

    public void setIrHrkp(BizCurrency pIrHrkp) {
        irHrkp = pIrHrkp;
    }

    private C_Hrkkeiro irHrkkeiro;

    public C_Hrkkeiro getIrHrkkeiro() {
        return irHrkkeiro;
    }

    public void setIrHrkkeiro(C_Hrkkeiro pIrHrkkeiro) {
        irHrkkeiro = pIrHrkkeiro;
    }

    private C_Hrkkaisuu irHrkkaisuu;

    public C_Hrkkaisuu getIrHrkkaisuu() {
        return irHrkkaisuu;
    }

    public void setIrHrkkaisuu(C_Hrkkaisuu pIrHrkkaisuu) {
        irHrkkaisuu = pIrHrkkaisuu;
    }

    private C_Hrkkaisuu irHenhrkkaisuu;

    public C_Hrkkaisuu getIrHenhrkkaisuu() {
        return irHenhrkkaisuu;
    }

    public void setIrHenhrkkaisuu(C_Hrkkaisuu pIrHenhrkkaisuu) {
        irHenhrkkaisuu = pIrHenhrkkaisuu;
    }

    private String irBanknmkj;

    public String getIrBanknmkj() {
        return irBanknmkj;
    }

    public void setIrBanknmkj(String pIrBanknmkj) {
        irBanknmkj = pIrBanknmkj;
    }

    private String irSitennmkj;

    public String getIrSitennmkj() {
        return irSitennmkj;
    }

    public void setIrSitennmkj(String pIrSitennmkj) {
        irSitennmkj = pIrSitennmkj;
    }

    private String irBankcd;

    public String getIrBankcd() {
        return irBankcd;
    }

    public void setIrBankcd(String pIrBankcd) {
        irBankcd = pIrBankcd;
    }

    private String irSitencd;

    public String getIrSitencd() {
        return irSitencd;
    }

    public void setIrSitencd(String pIrSitencd) {
        irSitencd = pIrSitencd;
    }

    private String irKzmeiginmkn;

    public String getIrKzmeiginmkn() {
        return irKzmeiginmkn;
    }

    public void setIrKzmeiginmkn(String pIrKzmeiginmkn) {
        irKzmeiginmkn = pIrKzmeiginmkn;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private C_Tdk irKkkyktdk;

    public C_Tdk getIrKkkyktdk() {
        return irKkkyktdk;
    }

    public void setIrKkkyktdk(C_Tdk pIrKkkyktdk) {
        irKkkyktdk = pIrKkkyktdk;
    }

    private String irHhknnmkj;

    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }

    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }

    private String irHhknseiymd;

    public String getIrHhknseiymd() {
        return irHhknseiymd;
    }

    public void setIrHhknseiymd(String pIrHhknseiymd) {
        irHhknseiymd = pIrHhknseiymd;
    }

    private C_UmuKbn irHhknseiymdhenkouumu;

    public C_UmuKbn getIrHhknseiymdhenkouumu() {
        return irHhknseiymdhenkouumu;
    }

    public void setIrHhknseiymdhenkouumu(C_UmuKbn pIrHhknseiymdhenkouumu) {
        irHhknseiymdhenkouumu = pIrHhknseiymdhenkouumu;
    }

    private C_Hhknsei irHhknsei;

    public C_Hhknsei getIrHhknsei() {
        return irHhknsei;
    }

    public void setIrHhknsei(C_Hhknsei pIrHhknsei) {
        irHhknsei = pIrHhknsei;
    }

    private C_UmuKbn irHhknseihenkouumu;

    public C_UmuKbn getIrHhknseihenkouumu() {
        return irHhknseihenkouumu;
    }

    public void setIrHhknseihenkouumu(C_UmuKbn pIrHhknseihenkouumu) {
        irHhknseihenkouumu = pIrHhknseihenkouumu;
    }

    private String irHhknyno;

    public String getIrHhknyno() {
        return irHhknyno;
    }

    public void setIrHhknyno(String pIrHhknyno) {
        irHhknyno = pIrHhknyno;
    }

    private String irHhknadr1kj;

    public String getIrHhknadr1kj() {
        return irHhknadr1kj;
    }

    public void setIrHhknadr1kj(String pIrHhknadr1kj) {
        irHhknadr1kj = pIrHhknadr1kj;
    }

    private String irHhknadr2kj;

    public String getIrHhknadr2kj() {
        return irHhknadr2kj;
    }

    public void setIrHhknadr2kj(String pIrHhknadr2kj) {
        irHhknadr2kj = pIrHhknadr2kj;
    }

    private String irHhknadr3kj;

    public String getIrHhknadr3kj() {
        return irHhknadr3kj;
    }

    public void setIrHhknadr3kj(String pIrHhknadr3kj) {
        irHhknadr3kj = pIrHhknadr3kj;
    }

    private String irHhknadr4kj;

    public String getIrHhknadr4kj() {
        return irHhknadr4kj;
    }

    public void setIrHhknadr4kj(String pIrHhknadr4kj) {
        irHhknadr4kj = pIrHhknadr4kj;
    }

    private String irHhkntelno;

    public String getIrHhkntelno() {
        return irHhkntelno;
    }

    public void setIrHhkntelno(String pIrHhkntelno) {
        irHhkntelno = pIrHhkntelno;
    }

    private String irSbhenkanuktnmkj;

    public String getIrSbhenkanuktnmkj() {
        return irSbhenkanuktnmkj;
    }

    public void setIrSbhenkanuktnmkj(String pIrSbhenkanuktnmkj) {
        irSbhenkanuktnmkj = pIrSbhenkanuktnmkj;
    }

    private String irStdrsknmkj;

    public String getIrStdrsknmkj() {
        return irStdrsknmkj;
    }

    public void setIrStdrsknmkj(String pIrStdrsknmkj) {
        irStdrsknmkj = pIrStdrsknmkj;
    }

    private String irDrtencd;

    public String getIrDrtencd() {
        return irDrtencd;
    }

    public void setIrDrtencd(String pIrDrtencd) {
        irDrtencd = pIrDrtencd;
    }

    private String irDrtennmkj;

    public String getIrDrtennmkj() {
        return irDrtennmkj;
    }

    public void setIrDrtennmkj(String pIrDrtennmkj) {
        irDrtennmkj = pIrDrtennmkj;
    }

    private C_UmuKbn irSyukykgengakuumu;

    public C_UmuKbn getIrSyukykgengakuumu() {
        return irSyukykgengakuumu;
    }

    public void setIrSyukykgengakuumu(C_UmuKbn pIrSyukykgengakuumu) {
        irSyukykgengakuumu = pIrSyukykgengakuumu;
    }

    private BizCurrency irGannyukyhntgk;

    public BizCurrency getIrGannyukyhntgk() {
        return irGannyukyhntgk;
    }

    public void setIrGannyukyhntgk(BizCurrency pIrGannyukyhntgk) {
        irGannyukyhntgk = pIrGannyukyhntgk;
    }

    private C_UmuKbn irGannyukyhumu;

    public C_UmuKbn getIrGannyukyhumu() {
        return irGannyukyhumu;
    }

    public void setIrGannyukyhumu(C_UmuKbn pIrGannyukyhumu) {
        irGannyukyhumu = pIrGannyukyhumu;
    }

    private C_UmuKbn irSbhnknuktumu;

    public C_UmuKbn getIrSbhnknuktumu() {
        return irSbhnknuktumu;
    }

    public void setIrSbhnknuktumu(C_UmuKbn pIrSbhnknuktumu) {
        irSbhnknuktumu = pIrSbhnknuktumu;
    }

    private C_KyktrksKbn irKyktrkskbn;

    public C_KyktrksKbn getIrKyktrkskbn() {
        return irKyktrkskbn;
    }

    public void setIrKyktrkskbn(C_KyktrksKbn pIrKyktrkskbn) {
        irKyktrkskbn = pIrKyktrkskbn;
    }

    private String irGanmukoutstksyouhnnm1kj;

    public String getIrGanmukoutstksyouhnnm1kj() {
        return irGanmukoutstksyouhnnm1kj;
    }

    public void setIrGanmukoutstksyouhnnm1kj(String pIrGanmukoutstksyouhnnm1kj) {
        irGanmukoutstksyouhnnm1kj = pIrGanmukoutstksyouhnnm1kj;
    }

    private String irGanmukoutstksyouhnnm2kj;

    public String getIrGanmukoutstksyouhnnm2kj() {
        return irGanmukoutstksyouhnnm2kj;
    }

    public void setIrGanmukoutstksyouhnnm2kj(String pIrGanmukoutstksyouhnnm2kj) {
        irGanmukoutstksyouhnnm2kj = pIrGanmukoutstksyouhnnm2kj;
    }

    private C_UriagetyuusiKbn irUriagetyuusikbn;

    public C_UriagetyuusiKbn getIrUriagetyuusikbn() {
        return irUriagetyuusikbn;
    }

    public void setIrUriagetyuusikbn(C_UriagetyuusiKbn pIrUriagetyuusikbn) {
        irUriagetyuusikbn = pIrUriagetyuusikbn;
    }

    private C_Hrkkeiro irHenhrkkeiro;

    public C_Hrkkeiro getIrHenhrkkeiro() {
        return irHenhrkkeiro;
    }

    public void setIrHenhrkkeiro(C_Hrkkeiro pIrHenhrkkeiro) {
        irHenhrkkeiro = pIrHenhrkkeiro;
    }

    private C_UmuKbn irSandaisiphsytkumu;

    public C_UmuKbn getIrSandaisiphsytkumu() {
        return irSandaisiphsytkumu;
    }

    public void setIrSandaisiphsytkumu(C_UmuKbn pIrSandaisiphsytkumu) {
        irSandaisiphsytkumu = pIrSandaisiphsytkumu;
    }

    private C_UmuKbn irSandaisippmnjtkumu;

    public C_UmuKbn getIrSandaisippmnjtkumu() {
        return irSandaisippmnjtkumu;
    }

    public void setIrSandaisippmnjtkumu(C_UmuKbn pIrSandaisippmnjtkumu) {
        irSandaisippmnjtkumu = pIrSandaisippmnjtkumu;
    }

    private String irKinouid;

    public String getIrKinouid() {
        return irKinouid;
    }

    public void setIrKinouid(String pIrKinouid) {
        irKinouid = pIrKinouid;
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

    private C_YouhiblnkKbn irAeoikakuninyhkbn;

    public C_YouhiblnkKbn getIrAeoikakuninyhkbn() {
        return irAeoikakuninyhkbn;
    }

    public void setIrAeoikakuninyhkbn(C_YouhiblnkKbn pIrAeoikakuninyhkbn) {
        irAeoikakuninyhkbn = pIrAeoikakuninyhkbn;
    }

    private C_TargetTkKbn irTargettkkbn;

    public C_TargetTkKbn getIrTargettkkbn() {
        return irTargettkkbn;
    }

    public void setIrTargettkkbn(C_TargetTkKbn pIrTargettkkbn) {
        irTargettkkbn = pIrTargettkkbn;
    }

    private Integer irAftertargettkmokuhyouti;

    public Integer getIrAftertargettkmokuhyouti() {
        return irAftertargettkmokuhyouti;
    }

    public void setIrAftertargettkmokuhyouti(Integer pIrAftertargettkmokuhyouti) {
        irAftertargettkmokuhyouti = pIrAftertargettkmokuhyouti;
    }

    private Integer irBeforetargettkmokuhyouti;

    public Integer getIrBeforetargettkmokuhyouti() {
        return irBeforetargettkmokuhyouti;
    }

    public void setIrBeforetargettkmokuhyouti(Integer pIrBeforetargettkmokuhyouti) {
        irBeforetargettkmokuhyouti = pIrBeforetargettkmokuhyouti;
    }

    private String irDocumentid;

    public String getIrDocumentid() {
        return irDocumentid;
    }

    public void setIrDocumentid(String pIrDocumentid) {
        irDocumentid = pIrDocumentid;
    }

    private BizCurrency irBeforekihons;

    public BizCurrency getIrBeforekihons() {
        return irBeforekihons;
    }

    public void setIrBeforekihons(BizCurrency pIrBeforekihons) {
        irBeforekihons = pIrBeforekihons;
    }

    private BizCurrency irAfterkihons;

    public BizCurrency getIrAfterkihons() {
        return irAfterkihons;
    }

    public void setIrAfterkihons(BizCurrency pIrAfterkihons) {
        irAfterkihons = pIrAfterkihons;
    }

    private BizCurrency irBeforep;

    public BizCurrency getIrBeforep() {
        return irBeforep;
    }

    public void setIrBeforep(BizCurrency pIrBeforep) {
        irBeforep = pIrBeforep;
    }

    private BizCurrency irAfterp;

    public BizCurrency getIrAfterp() {
        return irAfterp;
    }

    public void setIrAfterp(BizCurrency pIrAfterp) {
        irAfterp = pIrAfterp;
    }

    private C_Tuukasyu irKyktuukasyu;

    public C_Tuukasyu getIrKyktuukasyu() {
        return irKyktuukasyu;
    }

    public void setIrKyktuukasyu(C_Tuukasyu pIrKyktuukasyu) {
        irKyktuukasyu = pIrKyktuukasyu;
    }

    private String irSbuktnmkj1;

    public String getIrSbuktnmkj1() {
        return irSbuktnmkj1;
    }

    public void setIrSbuktnmkj1(String pIrSbuktnmkj1) {
        irSbuktnmkj1 = pIrSbuktnmkj1;
    }

    private String irSbuktnmkj2;

    public String getIrSbuktnmkj2() {
        return irSbuktnmkj2;
    }

    public void setIrSbuktnmkj2(String pIrSbuktnmkj2) {
        irSbuktnmkj2 = pIrSbuktnmkj2;
    }

    private String irSbuktnmkj3;

    public String getIrSbuktnmkj3() {
        return irSbuktnmkj3;
    }

    public void setIrSbuktnmkj3(String pIrSbuktnmkj3) {
        irSbuktnmkj3 = pIrSbuktnmkj3;
    }

    private String irSbuktnmkj4;

    public String getIrSbuktnmkj4() {
        return irSbuktnmkj4;
    }

    public void setIrSbuktnmkj4(String pIrSbuktnmkj4) {
        irSbuktnmkj4 = pIrSbuktnmkj4;
    }

    private String irSbuktnmkn;

    public String getIrSbuktnmkn() {
        return irSbuktnmkn;
    }

    public void setIrSbuktnmkn(String pIrSbuktnmkn) {
        irSbuktnmkn = pIrSbuktnmkn;
    }

    private C_YokinKbn irYokinkbn;

    public C_YokinKbn getIrYokinkbn() {
        return irYokinkbn;
    }

    public void setIrYokinkbn(C_YokinKbn pIrYokinkbn) {
        irYokinkbn = pIrYokinkbn;
    }

    private String irKouzano;

    public String getIrKouzano() {
        return irKouzano;
    }

    public void setIrKouzano(String pIrKouzano) {
        irKouzano = pIrKouzano;
    }

    private C_Nstknsyu irAfternkshrtkyknksyukbn;

    public C_Nstknsyu getIrAfternkshrtkyknksyukbn() {
        return irAfternkshrtkyknksyukbn;
    }

    public void setIrAfternkshrtkyknksyukbn(C_Nstknsyu pIrAfternkshrtkyknksyukbn) {
        irAfternkshrtkyknksyukbn = pIrAfternkshrtkyknksyukbn;
    }

    private C_Nstknsyu irBiforenkshrtkyknksyukbn;

    public C_Nstknsyu getIrBiforenkshrtkyknksyukbn() {
        return irBiforenkshrtkyknksyukbn;
    }

    public void setIrBiforenkshrtkyknksyukbn(C_Nstknsyu pIrBiforenkshrtkyknksyukbn) {
        irBiforenkshrtkyknksyukbn = pIrBiforenkshrtkyknksyukbn;
    }

    private Integer irAfternkshrtkyknkkkn;

    public Integer getIrAfternkshrtkyknkkkn() {
        return irAfternkshrtkyknkkkn;
    }

    public void setIrAfternkshrtkyknkkkn(Integer pIrAfternkshrtkyknkkkn) {
        irAfternkshrtkyknkkkn = pIrAfternkshrtkyknkkkn;
    }

    private Integer irBeforenkshrtkyknkkkn;

    public Integer getIrBeforenkshrtkyknkkkn() {
        return irBeforenkshrtkyknkkkn;
    }

    public void setIrBeforenkshrtkyknkkkn(Integer pIrBeforenkshrtkyknkkkn) {
        irBeforenkshrtkyknkkkn = pIrBeforenkshrtkyknkkkn;
    }

    private String irNkuktnm;

    public String getIrNkuktnm() {
        return irNkuktnm;
    }

    public void setIrNkuktnm(String pIrNkuktnm) {
        irNkuktnm = pIrNkuktnm;
    }

    private BizNumber irSbubnwari1;

    public BizNumber getIrSbubnwari1() {
        return irSbubnwari1;
    }

    public void setIrSbubnwari1(BizNumber pIrSbubnwari1) {
        irSbubnwari1 = pIrSbubnwari1;
    }

    private BizNumber irSbubnwari2;

    public BizNumber getIrSbubnwari2() {
        return irSbubnwari2;
    }

    public void setIrSbubnwari2(BizNumber pIrSbubnwari2) {
        irSbubnwari2 = pIrSbubnwari2;
    }

    private BizNumber irSbubnwari3;

    public BizNumber getIrSbubnwari3() {
        return irSbubnwari3;
    }

    public void setIrSbubnwari3(BizNumber pIrSbubnwari3) {
        irSbubnwari3 = pIrSbubnwari3;
    }

    private BizNumber irSbubnwari4;

    public BizNumber getIrSbubnwari4() {
        return irSbubnwari4;
    }

    public void setIrSbubnwari4(BizNumber pIrSbubnwari4) {
        irSbubnwari4 = pIrSbubnwari4;
    }

    private C_TargetTkHenkouKbn irTargettkhnkkbn;

    public C_TargetTkHenkouKbn getIrTargettkhnkkbn() {
        return irTargettkhnkkbn;
    }

    public void setIrTargettkhnkkbn(C_TargetTkHenkouKbn pIrTargettkhnkkbn) {
        irTargettkhnkkbn = pIrTargettkhnkkbn;
    }

    private C_Kaiyakujiyuu irKaiyakujiyuu;

    public C_Kaiyakujiyuu getIrKaiyakujiyuu() {
        return irKaiyakujiyuu;
    }

    public void setIrKaiyakujiyuu(C_Kaiyakujiyuu pIrKaiyakujiyuu) {
        irKaiyakujiyuu = pIrKaiyakujiyuu;
    }

    private C_GengkhouKbn irGengkhoukbn;

    public C_GengkhouKbn getIrGengkhoukbn() {
        return irGengkhoukbn;
    }

    public void setIrGengkhoukbn(C_GengkhouKbn pIrGengkhoukbn) {
        irGengkhoukbn = pIrGengkhoukbn;
    }

    private C_Tdk irUkttdk;

    public C_Tdk getIrUkttdk() {
        return irUkttdk;
    }

    public void setIrUkttdk(C_Tdk pIrUkttdk) {
        irUkttdk = pIrUkttdk;
    }

    private Integer irSbuktnin;

    public Integer getIrSbuktnin() {
        return irSbuktnin;
    }

    public void setIrSbuktnin(Integer pIrSbuktnin) {
        irSbuktnin = pIrSbuktnin;
    }

    private C_UktKbn irSbuuktkbn;

    public C_UktKbn getIrSbuuktkbn() {
        return irSbuuktkbn;
    }

    public void setIrSbuuktkbn(C_UktKbn pIrSbuuktkbn) {
        irSbuuktkbn = pIrSbuuktkbn;
    }

    private C_UmuKbn irYenshrtkumu;

    public C_UmuKbn getIrYenshrtkumu() {
        return irYenshrtkumu;
    }

    public void setIrYenshrtkumu(C_UmuKbn pIrYenshrtkumu) {
        irYenshrtkumu = pIrYenshrtkumu;
    }

    private C_UmuKbn irHenkankinumukbn;

    public C_UmuKbn getIrHenkankinumukbn() {
        return irHenkankinumukbn;
    }

    public void setIrHenkankinumukbn(C_UmuKbn pIrHenkankinumukbn) {
        irHenkankinumukbn = pIrHenkankinumukbn;
    }

    private C_Tuukasyu irRstuukasyu;

    public C_Tuukasyu getIrRstuukasyu() {
        return irRstuukasyu;
    }

    public void setIrRstuukasyu(C_Tuukasyu pIrRstuukasyu) {
        irRstuukasyu = pIrRstuukasyu;
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

    private C_UmuKbn irNkhknumu;

    public C_UmuKbn getIrNkhknumu() {
        return irNkhknumu;
    }

    public void setIrNkhknumu(C_UmuKbn pIrNkhknumu) {
        irNkhknumu = pIrNkhknumu;
    }

    private C_UmuKbn irSiboukyhkuktumukbn;

    public C_UmuKbn getIrSiboukyhkuktumukbn() {
        return irSiboukyhkuktumukbn;
    }

    public void setIrSiboukyhkuktumukbn(C_UmuKbn pIrSiboukyhkuktumukbn) {
        irSiboukyhkuktumukbn = pIrSiboukyhkuktumukbn;
    }

    private C_UmuKbn irSibousuktumukbn1;

    public C_UmuKbn getIrSibousuktumukbn1() {
        return irSibousuktumukbn1;
    }

    public void setIrSibousuktumukbn1(C_UmuKbn pIrSibousuktumukbn1) {
        irSibousuktumukbn1 = pIrSibousuktumukbn1;
    }

    private C_UmuKbn irSibousuktumukbn2;

    public C_UmuKbn getIrSibousuktumukbn2() {
        return irSibousuktumukbn2;
    }

    public void setIrSibousuktumukbn2(C_UmuKbn pIrSibousuktumukbn2) {
        irSibousuktumukbn2 = pIrSibousuktumukbn2;
    }

    private C_UmuKbn irSibousuktumukbn3;

    public C_UmuKbn getIrSibousuktumukbn3() {
        return irSibousuktumukbn3;
    }

    public void setIrSibousuktumukbn3(C_UmuKbn pIrSibousuktumukbn3) {
        irSibousuktumukbn3 = pIrSibousuktumukbn3;
    }

    private C_UmuKbn irSibousuktumukbn4;

    public C_UmuKbn getIrSibousuktumukbn4() {
        return irSibousuktumukbn4;
    }

    public void setIrSibousuktumukbn4(C_UmuKbn pIrSibousuktumukbn4) {
        irSibousuktumukbn4 = pIrSibousuktumukbn4;
    }

    private C_UmuKbn irSbubnwariumu1;

    public C_UmuKbn getIrSbubnwariumu1() {
        return irSbubnwariumu1;
    }

    public void setIrSbubnwariumu1(C_UmuKbn pIrSbubnwariumu1) {
        irSbubnwariumu1 = pIrSbubnwariumu1;
    }

    private C_UmuKbn irSbubnwariumu2;

    public C_UmuKbn getIrSbubnwariumu2() {
        return irSbubnwariumu2;
    }

    public void setIrSbubnwariumu2(C_UmuKbn pIrSbubnwariumu2) {
        irSbubnwariumu2 = pIrSbubnwariumu2;
    }

    private C_UmuKbn irSbubnwariumu3;

    public C_UmuKbn getIrSbubnwariumu3() {
        return irSbubnwariumu3;
    }

    public void setIrSbubnwariumu3(C_UmuKbn pIrSbubnwariumu3) {
        irSbubnwariumu3 = pIrSbubnwariumu3;
    }

    private C_UmuKbn irSbubnwariumu4;

    public C_UmuKbn getIrSbubnwariumu4() {
        return irSbubnwariumu4;
    }

    public void setIrSbubnwariumu4(C_UmuKbn pIrSbubnwariumu4) {
        irSbubnwariumu4 = pIrSbubnwariumu4;
    }

    private C_UktKbn irStdruktkbn;

    public C_UktKbn getIrStdruktkbn() {
        return irStdruktkbn;
    }

    public void setIrStdruktkbn(C_UktKbn pIrStdruktkbn) {
        irStdruktkbn = pIrStdruktkbn;
    }

    private C_UmuKbn irStdrsktkyhukaumu;

    public C_UmuKbn getIrStdrsktkyhukaumu() {
        return irStdrsktkyhukaumu;
    }

    public void setIrStdrsktkyhukaumu(C_UmuKbn pIrStdrsktkyhukaumu) {
        irStdrsktkyhukaumu = pIrStdrsktkyhukaumu;
    }

    private C_UmuKbn irStdrsktkyuuktmukbn;

    public C_UmuKbn getIrStdrsktkyuuktmukbn() {
        return irStdrsktkyuuktmukbn;
    }

    public void setIrStdrsktkyuuktmukbn(C_UmuKbn pIrStdrsktkyuuktmukbn) {
        irStdrsktkyuuktmukbn = pIrStdrsktkyuuktmukbn;
    }

    private C_JyudkaigomaebaraiTkykhnkKbn irJyudkaigomaebrtkykhnkkbn;

    public C_JyudkaigomaebaraiTkykhnkKbn getIrJyudkaigomaebrtkykhnkkbn() {
        return irJyudkaigomaebrtkykhnkkbn;
    }

    public void setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn pIrJyudkaigomaebrtkykhnkkbn) {
        irJyudkaigomaebrtkykhnkkbn = pIrJyudkaigomaebrtkykhnkkbn;
    }

    private C_KeihiKbn irKeihikbn;

    public C_KeihiKbn getIrKeihikbn() {
        return irKeihikbn;
    }

    public void setIrKeihikbn(C_KeihiKbn pIrKeihikbn) {
        irKeihikbn = pIrKeihikbn;
    }

    private C_UmuKbn irKihonshenkouumu;

    public C_UmuKbn getIrKihonshenkouumu() {
        return irKihonshenkouumu;
    }

    public void setIrKihonshenkouumu(C_UmuKbn pIrKihonshenkouumu) {
        irKihonshenkouumu = pIrKihonshenkouumu;
    }

    private String irKihonssyurui;

    public String getIrKihonssyurui() {
        return irKihonssyurui;
    }

    public void setIrKihonssyurui(String pIrKihonssyurui) {
        irKihonssyurui = pIrKihonssyurui;
    }

    private C_Tmttknitenkbn irTmttknitenkbn;

    public C_Tmttknitenkbn getIrTmttknitenkbn() {
        return irTmttknitenkbn;
    }

    public void setIrTmttknitenkbn(C_Tmttknitenkbn pIrTmttknitenkbn) {
        irTmttknitenkbn = pIrTmttknitenkbn;
    }

    private String irTmttknitenymd;

    public String getIrTmttknitenymd() {
        return irTmttknitenymd;
    }

    public void setIrTmttknitenymd(String pIrTmttknitenymd) {
        irTmttknitenymd = pIrTmttknitenymd;
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

    private Integer irSyouhnhanteikekka;

    public Integer getIrSyouhnhanteikekka() {
        return irSyouhnhanteikekka;
    }

    public void setIrSyouhnhanteikekka(Integer pIrSyouhnhanteikekka) {
        irSyouhnhanteikekka = pIrSyouhnhanteikekka;
    }

    private BizCurrency irAfterkijyunkingaku;

    public BizCurrency getIrAfterkijyunkingaku() {
        return irAfterkijyunkingaku;
    }

    public void setIrAfterkijyunkingaku(BizCurrency pIrAfterkijyunkingaku) {
        irAfterkijyunkingaku = pIrAfterkijyunkingaku;
    }

    private C_Kykjyoutai irKykjyoutai;

    public C_Kykjyoutai getIrKykjyoutai() {
        return irKykjyoutai;
    }

    public void setIrKykjyoutai(C_Kykjyoutai pIrKykjyoutai) {
        irKykjyoutai = pIrKykjyoutai;
    }

    private C_UmuKbn irZeiseitkkktkykhukaumu;

    public C_UmuKbn getIrZeiseitkkktkykhukaumu() {
        return irZeiseitkkktkykhukaumu;
    }

    public void setIrZeiseitkkktkykhukaumu(C_UmuKbn pIrZeiseitkkktkykhukaumu) {
        irZeiseitkkktkykhukaumu = pIrZeiseitkkktkykhukaumu;
    }

    private C_UmuKbn irYuuyokkntyoukaumu;

    public C_UmuKbn getIrYuuyokkntyoukaumu() {
        return irYuuyokkntyoukaumu;
    }

    public void setIrYuuyokkntyoukaumu(C_UmuKbn pIrYuuyokkntyoukaumu) {
        irYuuyokkntyoukaumu = pIrYuuyokkntyoukaumu;
    }

    private C_MousideIkouKbn irMousideikoukbn;

    public C_MousideIkouKbn getIrMousideikoukbn() {
        return irMousideikoukbn;
    }

    public void setIrMousideikoukbn(C_MousideIkouKbn pIrMousideikoukbn) {
        irMousideikoukbn = pIrMousideikoukbn;
    }

    private C_UmuKbn irSaikensetumu;

    public C_UmuKbn getIrSaikensetumu() {
        return irSaikensetumu;
    }

    public void setIrSaikensetumu(C_UmuKbn pIrSaikensetumu) {
        irSaikensetumu = pIrSaikensetumu;
    }

    private String irTrkkzknmkn1;

    public String getIrTrkkzknmkn1() {
        return irTrkkzknmkn1;
    }

    public void setIrTrkkzknmkn1(String pIrTrkkzknmkn1) {
        irTrkkzknmkn1 = pIrTrkkzknmkn1;
    }

    private String irTrkkzknmkj1;

    public String getIrTrkkzknmkj1() {
        return irTrkkzknmkj1;
    }

    public void setIrTrkkzknmkj1(String pIrTrkkzknmkj1) {
        irTrkkzknmkj1 = pIrTrkkzknmkj1;
    }

    private String irTrkkzkadr1kj1;

    public String getIrTrkkzkadr1kj1() {
        return irTrkkzkadr1kj1;
    }

    public void setIrTrkkzkadr1kj1(String pIrTrkkzkadr1kj1) {
        irTrkkzkadr1kj1 = pIrTrkkzkadr1kj1;
    }

    private String irTrkkzkadr2kj1;

    public String getIrTrkkzkadr2kj1() {
        return irTrkkzkadr2kj1;
    }

    public void setIrTrkkzkadr2kj1(String pIrTrkkzkadr2kj1) {
        irTrkkzkadr2kj1 = pIrTrkkzkadr2kj1;
    }

    private String irTrkkzkadr3kj1;

    public String getIrTrkkzkadr3kj1() {
        return irTrkkzkadr3kj1;
    }

    public void setIrTrkkzkadr3kj1(String pIrTrkkzkadr3kj1) {
        irTrkkzkadr3kj1 = pIrTrkkzkadr3kj1;
    }

    private String irTrkkzktelno1;

    public String getIrTrkkzktelno1() {
        return irTrkkzktelno1;
    }

    public void setIrTrkkzktelno1(String pIrTrkkzktelno1) {
        irTrkkzktelno1 = pIrTrkkzktelno1;
    }

    private C_KahiKbn irTrkkzksakujyokahi1;

    public C_KahiKbn getIrTrkkzksakujyokahi1() {
        return irTrkkzksakujyokahi1;
    }

    public void setIrTrkkzksakujyokahi1(C_KahiKbn pIrTrkkzksakujyokahi1) {
        irTrkkzksakujyokahi1 = pIrTrkkzksakujyokahi1;
    }

    private String irTrkkzknmkn2;

    public String getIrTrkkzknmkn2() {
        return irTrkkzknmkn2;
    }

    public void setIrTrkkzknmkn2(String pIrTrkkzknmkn2) {
        irTrkkzknmkn2 = pIrTrkkzknmkn2;
    }

    private String irTrkkzknmkj2;

    public String getIrTrkkzknmkj2() {
        return irTrkkzknmkj2;
    }

    public void setIrTrkkzknmkj2(String pIrTrkkzknmkj2) {
        irTrkkzknmkj2 = pIrTrkkzknmkj2;
    }

    private String irTrkkzkadr1kj2;

    public String getIrTrkkzkadr1kj2() {
        return irTrkkzkadr1kj2;
    }

    public void setIrTrkkzkadr1kj2(String pIrTrkkzkadr1kj2) {
        irTrkkzkadr1kj2 = pIrTrkkzkadr1kj2;
    }

    private String irTrkkzkadr2kj2;

    public String getIrTrkkzkadr2kj2() {
        return irTrkkzkadr2kj2;
    }

    public void setIrTrkkzkadr2kj2(String pIrTrkkzkadr2kj2) {
        irTrkkzkadr2kj2 = pIrTrkkzkadr2kj2;
    }

    private String irTrkkzkadr3kj2;

    public String getIrTrkkzkadr3kj2() {
        return irTrkkzkadr3kj2;
    }

    public void setIrTrkkzkadr3kj2(String pIrTrkkzkadr3kj2) {
        irTrkkzkadr3kj2 = pIrTrkkzkadr3kj2;
    }

    private String irTrkkzktelno2;

    public String getIrTrkkzktelno2() {
        return irTrkkzktelno2;
    }

    public void setIrTrkkzktelno2(String pIrTrkkzktelno2) {
        irTrkkzktelno2 = pIrTrkkzktelno2;
    }

    private C_KahiKbn irTrkkzksakujyokahi2;

    public C_KahiKbn getIrTrkkzksakujyokahi2() {
        return irTrkkzksakujyokahi2;
    }

    public void setIrTrkkzksakujyokahi2(C_KahiKbn pIrTrkkzksakujyokahi2) {
        irTrkkzksakujyokahi2 = pIrTrkkzksakujyokahi2;
    }

    private String irKyknmkn;

    public String getIrKyknmkn() {
        return irKyknmkn;
    }

    public void setIrKyknmkn(String pIrKyknmkn) {
        irKyknmkn = pIrKyknmkn;
    }

    private String irKykdairinmkj;

    public String getIrKykdairinmkj() {
        return irKykdairinmkj;
    }

    public void setIrKykdairinmkj(String pIrKykdairinmkj) {
        irKykdairinmkj = pIrKykdairinmkj;
    }

    private C_UmuKbn irKykdrtkykhukaumu;

    public C_UmuKbn getIrKykdrtkykhukaumu() {
        return irKykdrtkykhukaumu;
    }

    public void setIrKykdrtkykhukaumu(C_UmuKbn pIrKykdrtkykhukaumu) {
        irKykdrtkykhukaumu = pIrKykdrtkykhukaumu;
    }

    private C_MousideninKbn irMousideninkbn;

    public C_MousideninKbn getIrMousideninkbn() {
        return irMousideninkbn;
    }

    public void setIrMousideninkbn(C_MousideninKbn pIrMousideninkbn) {
        irMousideninkbn = pIrMousideninkbn;
    }

    private C_KykdrknHtdjytKbn irKykdrknhatudoujyoutai;

    public C_KykdrknHtdjytKbn getIrKykdrknhatudoujyoutai() {
        return irKykdrknhatudoujyoutai;
    }

    public void setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pIrKykdrknhatudoujyoutai) {
        irKykdrknhatudoujyoutai = pIrKykdrknhatudoujyoutai;
    }

    private String irDrstiskkyknmkj;

    public String getIrDrstiskkyknmkj() {
        return irDrstiskkyknmkj;
    }

    public void setIrDrstiskkyknmkj(String pIrDrstiskkyknmkj) {
        irDrstiskkyknmkj = pIrDrstiskkyknmkj;
    }

    private String irTyouhyoutitle;

    public String getIrTyouhyoutitle() {
        return irTyouhyoutitle;
    }

    public void setIrTyouhyoutitle(String pIrTyouhyoutitle) {
        irTyouhyoutitle = pIrTyouhyoutitle;
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

    private C_UktKbn irKykdrkbn;

    public C_UktKbn getIrKykdrkbn() {
        return irKykdrkbn;
    }

    public void setIrKykdrkbn(C_UktKbn pIrKykdrkbn) {
        irKykdrkbn = pIrKykdrkbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
