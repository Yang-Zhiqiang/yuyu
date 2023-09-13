package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）手続完了帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhTtdkkanryouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhTtdkkanryouBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private String irToiawasetelnokykate;

    public String getIrToiawasetelnokykate() {
        return irToiawasetelnokykate;
    }

    public void setIrToiawasetelnokykate(String pIrToiawasetelnokykate) {
        irToiawasetelnokykate = pIrToiawasetelnokykate;
    }

    private C_SyoruiCdKbn irSyoruicd;

    public C_SyoruiCdKbn getIrSyoruicd() {
        return irSyoruicd;
    }

    public void setIrSyoruicd(C_SyoruiCdKbn pIrSyoruicd) {
        irSyoruicd = pIrSyoruicd;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private C_TetudukisyuKbn irTetudukisyukbn;

    public C_TetudukisyuKbn getIrTetudukisyukbn() {
        return irTetudukisyukbn;
    }

    public void setIrTetudukisyukbn(C_TetudukisyuKbn pIrTetudukisyukbn) {
        irTetudukisyukbn = pIrTetudukisyukbn;
    }

    private C_SyoriKbn irSyorikbn;

    public C_SyoriKbn getIrSyorikbn() {
        return irSyorikbn;
    }

    public void setIrSyorikbn(C_SyoriKbn pIrSyorikbn) {
        irSyorikbn = pIrSyorikbn;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private String irHhknnmkj;

    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }

    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }

    private String irShrymd;

    public String getIrShrymd() {
        return irShrymd;
    }

    public void setIrShrymd(String pIrShrymd) {
        irShrymd = pIrShrymd;
    }

    private String irCalckijyunymd;

    public String getIrCalckijyunymd() {
        return irCalckijyunymd;
    }

    public void setIrCalckijyunymd(String pIrCalckijyunymd) {
        irCalckijyunymd = pIrCalckijyunymd;
    }

    private String irKaiykymd;

    public String getIrKaiykymd() {
        return irKaiykymd;
    }

    public void setIrKaiykymd(String pIrKaiykymd) {
        irKaiykymd = pIrKaiykymd;
    }

    private String irTekiyou1;

    public String getIrTekiyou1() {
        return irTekiyou1;
    }

    public void setIrTekiyou1(String pIrTekiyou1) {
        irTekiyou1 = pIrTekiyou1;
    }

    private BizCurrency irKngkmeisai1;

    public BizCurrency getIrKngkmeisai1() {
        return irKngkmeisai1;
    }

    public void setIrKngkmeisai1(BizCurrency pIrKngkmeisai1) {
        irKngkmeisai1 = pIrKngkmeisai1;
    }

    private String irKngkmisituukasyunm1;

    public String getIrKngkmisituukasyunm1() {
        return irKngkmisituukasyunm1;
    }

    public void setIrKngkmisituukasyunm1(String pIrKngkmisituukasyunm1) {
        irKngkmisituukasyunm1 = pIrKngkmisituukasyunm1;
    }

    private String irBikou1;

    public String getIrBikou1() {
        return irBikou1;
    }

    public void setIrBikou1(String pIrBikou1) {
        irBikou1 = pIrBikou1;
    }

    private String irTekiyou2;

    public String getIrTekiyou2() {
        return irTekiyou2;
    }

    public void setIrTekiyou2(String pIrTekiyou2) {
        irTekiyou2 = pIrTekiyou2;
    }

    private BizCurrency irKngkmeisai2;

    public BizCurrency getIrKngkmeisai2() {
        return irKngkmeisai2;
    }

    public void setIrKngkmeisai2(BizCurrency pIrKngkmeisai2) {
        irKngkmeisai2 = pIrKngkmeisai2;
    }

    private String irKngkmisituukasyunm2;

    public String getIrKngkmisituukasyunm2() {
        return irKngkmisituukasyunm2;
    }

    public void setIrKngkmisituukasyunm2(String pIrKngkmisituukasyunm2) {
        irKngkmisituukasyunm2 = pIrKngkmisituukasyunm2;
    }

    private String irBikou2;

    public String getIrBikou2() {
        return irBikou2;
    }

    public void setIrBikou2(String pIrBikou2) {
        irBikou2 = pIrBikou2;
    }

    private String irTekiyou3;

    public String getIrTekiyou3() {
        return irTekiyou3;
    }

    public void setIrTekiyou3(String pIrTekiyou3) {
        irTekiyou3 = pIrTekiyou3;
    }

    private BizCurrency irKngkmeisai3;

    public BizCurrency getIrKngkmeisai3() {
        return irKngkmeisai3;
    }

    public void setIrKngkmeisai3(BizCurrency pIrKngkmeisai3) {
        irKngkmeisai3 = pIrKngkmeisai3;
    }

    private String irKngkmisituukasyunm3;

    public String getIrKngkmisituukasyunm3() {
        return irKngkmisituukasyunm3;
    }

    public void setIrKngkmisituukasyunm3(String pIrKngkmisituukasyunm3) {
        irKngkmisituukasyunm3 = pIrKngkmisituukasyunm3;
    }

    private String irBikou3;

    public String getIrBikou3() {
        return irBikou3;
    }

    public void setIrBikou3(String pIrBikou3) {
        irBikou3 = pIrBikou3;
    }

    private String irTekiyou4;

    public String getIrTekiyou4() {
        return irTekiyou4;
    }

    public void setIrTekiyou4(String pIrTekiyou4) {
        irTekiyou4 = pIrTekiyou4;
    }

    private BizCurrency irKngkmeisai4;

    public BizCurrency getIrKngkmeisai4() {
        return irKngkmeisai4;
    }

    public void setIrKngkmeisai4(BizCurrency pIrKngkmeisai4) {
        irKngkmeisai4 = pIrKngkmeisai4;
    }

    private String irKngkmisituukasyunm4;

    public String getIrKngkmisituukasyunm4() {
        return irKngkmisituukasyunm4;
    }

    public void setIrKngkmisituukasyunm4(String pIrKngkmisituukasyunm4) {
        irKngkmisituukasyunm4 = pIrKngkmisituukasyunm4;
    }

    private String irBikou4;

    public String getIrBikou4() {
        return irBikou4;
    }

    public void setIrBikou4(String pIrBikou4) {
        irBikou4 = pIrBikou4;
    }

    private String irTekiyou5;

    public String getIrTekiyou5() {
        return irTekiyou5;
    }

    public void setIrTekiyou5(String pIrTekiyou5) {
        irTekiyou5 = pIrTekiyou5;
    }

    private BizCurrency irKngkmeisai5;

    public BizCurrency getIrKngkmeisai5() {
        return irKngkmeisai5;
    }

    public void setIrKngkmeisai5(BizCurrency pIrKngkmeisai5) {
        irKngkmeisai5 = pIrKngkmeisai5;
    }

    private String irKngkmisituukasyunm5;

    public String getIrKngkmisituukasyunm5() {
        return irKngkmisituukasyunm5;
    }

    public void setIrKngkmisituukasyunm5(String pIrKngkmisituukasyunm5) {
        irKngkmisituukasyunm5 = pIrKngkmisituukasyunm5;
    }

    private String irBikou5;

    public String getIrBikou5() {
        return irBikou5;
    }

    public void setIrBikou5(String pIrBikou5) {
        irBikou5 = pIrBikou5;
    }

    private String irTekiyou6;

    public String getIrTekiyou6() {
        return irTekiyou6;
    }

    public void setIrTekiyou6(String pIrTekiyou6) {
        irTekiyou6 = pIrTekiyou6;
    }

    private BizCurrency irKngkmeisai6;

    public BizCurrency getIrKngkmeisai6() {
        return irKngkmeisai6;
    }

    public void setIrKngkmeisai6(BizCurrency pIrKngkmeisai6) {
        irKngkmeisai6 = pIrKngkmeisai6;
    }

    private String irKngkmisituukasyunm6;

    public String getIrKngkmisituukasyunm6() {
        return irKngkmisituukasyunm6;
    }

    public void setIrKngkmisituukasyunm6(String pIrKngkmisituukasyunm6) {
        irKngkmisituukasyunm6 = pIrKngkmisituukasyunm6;
    }

    private String irBikou6;

    public String getIrBikou6() {
        return irBikou6;
    }

    public void setIrBikou6(String pIrBikou6) {
        irBikou6 = pIrBikou6;
    }

    private String irTekiyou7;

    public String getIrTekiyou7() {
        return irTekiyou7;
    }

    public void setIrTekiyou7(String pIrTekiyou7) {
        irTekiyou7 = pIrTekiyou7;
    }

    private BizCurrency irKngkmeisai7;

    public BizCurrency getIrKngkmeisai7() {
        return irKngkmeisai7;
    }

    public void setIrKngkmeisai7(BizCurrency pIrKngkmeisai7) {
        irKngkmeisai7 = pIrKngkmeisai7;
    }

    private String irKngkmisituukasyunm7;

    public String getIrKngkmisituukasyunm7() {
        return irKngkmisituukasyunm7;
    }

    public void setIrKngkmisituukasyunm7(String pIrKngkmisituukasyunm7) {
        irKngkmisituukasyunm7 = pIrKngkmisituukasyunm7;
    }

    private String irBikou7;

    public String getIrBikou7() {
        return irBikou7;
    }

    public void setIrBikou7(String pIrBikou7) {
        irBikou7 = pIrBikou7;
    }

    private String irTekiyou8;

    public String getIrTekiyou8() {
        return irTekiyou8;
    }

    public void setIrTekiyou8(String pIrTekiyou8) {
        irTekiyou8 = pIrTekiyou8;
    }

    private BizCurrency irKngkmeisai8;

    public BizCurrency getIrKngkmeisai8() {
        return irKngkmeisai8;
    }

    public void setIrKngkmeisai8(BizCurrency pIrKngkmeisai8) {
        irKngkmeisai8 = pIrKngkmeisai8;
    }

    private String irKngkmisituukasyunm8;

    public String getIrKngkmisituukasyunm8() {
        return irKngkmisituukasyunm8;
    }

    public void setIrKngkmisituukasyunm8(String pIrKngkmisituukasyunm8) {
        irKngkmisituukasyunm8 = pIrKngkmisituukasyunm8;
    }

    private String irBikou8;

    public String getIrBikou8() {
        return irBikou8;
    }

    public void setIrBikou8(String pIrBikou8) {
        irBikou8 = pIrBikou8;
    }

    private String irTekiyou9;

    public String getIrTekiyou9() {
        return irTekiyou9;
    }

    public void setIrTekiyou9(String pIrTekiyou9) {
        irTekiyou9 = pIrTekiyou9;
    }

    private BizCurrency irKngkmeisai9;

    public BizCurrency getIrKngkmeisai9() {
        return irKngkmeisai9;
    }

    public void setIrKngkmeisai9(BizCurrency pIrKngkmeisai9) {
        irKngkmeisai9 = pIrKngkmeisai9;
    }

    private String irKngkmisituukasyunm9;

    public String getIrKngkmisituukasyunm9() {
        return irKngkmisituukasyunm9;
    }

    public void setIrKngkmisituukasyunm9(String pIrKngkmisituukasyunm9) {
        irKngkmisituukasyunm9 = pIrKngkmisituukasyunm9;
    }

    private String irBikou9;

    public String getIrBikou9() {
        return irBikou9;
    }

    public void setIrBikou9(String pIrBikou9) {
        irBikou9 = pIrBikou9;
    }

    private String irTekiyou10;

    public String getIrTekiyou10() {
        return irTekiyou10;
    }

    public void setIrTekiyou10(String pIrTekiyou10) {
        irTekiyou10 = pIrTekiyou10;
    }

    private BizCurrency irKngkmeisai10;

    public BizCurrency getIrKngkmeisai10() {
        return irKngkmeisai10;
    }

    public void setIrKngkmeisai10(BizCurrency pIrKngkmeisai10) {
        irKngkmeisai10 = pIrKngkmeisai10;
    }

    private String irKngkmisituukasyunm10;

    public String getIrKngkmisituukasyunm10() {
        return irKngkmisituukasyunm10;
    }

    public void setIrKngkmisituukasyunm10(String pIrKngkmisituukasyunm10) {
        irKngkmisituukasyunm10 = pIrKngkmisituukasyunm10;
    }

    private String irBikou10;

    public String getIrBikou10() {
        return irBikou10;
    }

    public void setIrBikou10(String pIrBikou10) {
        irBikou10 = pIrBikou10;
    }

    private BizCurrency irShrgk;

    public BizCurrency getIrShrgk() {
        return irShrgk;
    }

    public void setIrShrgk(BizCurrency pIrShrgk) {
        irShrgk = pIrShrgk;
    }

    private C_Tuukasyu irTuukasyu;

    public C_Tuukasyu getIrTuukasyu() {
        return irTuukasyu;
    }

    public void setIrTuukasyu(C_Tuukasyu pIrTuukasyu) {
        irTuukasyu = pIrTuukasyu;
    }

    private String irShrtuukasyuryk;

    public String getIrShrtuukasyuryk() {
        return irShrtuukasyuryk;
    }

    public void setIrShrtuukasyuryk(String pIrShrtuukasyuryk) {
        irShrtuukasyuryk = pIrShrtuukasyuryk;
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

    private String irKzmeiginmkn;

    public String getIrKzmeiginmkn() {
        return irKzmeiginmkn;
    }

    public void setIrKzmeiginmkn(String pIrKzmeiginmkn) {
        irKzmeiginmkn = pIrKzmeiginmkn;
    }

    private C_HtsiryosyuKbn irHtsiryosyukbn;

    public C_HtsiryosyuKbn getIrHtsiryosyukbn() {
        return irHtsiryosyukbn;
    }

    public void setIrHtsiryosyukbn(C_HtsiryosyuKbn pIrHtsiryosyukbn) {
        irHtsiryosyukbn = pIrHtsiryosyukbn;
    }

    private BizCurrency irSynykngk;

    public BizCurrency getIrSynykngk() {
        return irSynykngk;
    }

    public void setIrSynykngk(BizCurrency pIrSynykngk) {
        irSynykngk = pIrSynykngk;
    }

    private BizCurrency irHtykeihi;

    public BizCurrency getIrHtykeihi() {
        return irHtykeihi;
    }

    public void setIrHtykeihi(BizCurrency pIrHtykeihi) {
        irHtykeihi = pIrHtykeihi;
    }

    private BizCurrency irShrkyksyahtykeihi;

    public BizCurrency getIrShrkyksyahtykeihi() {
        return irShrkyksyahtykeihi;
    }

    public void setIrShrkyksyahtykeihi(BizCurrency pIrShrkyksyahtykeihi) {
        irShrkyksyahtykeihi = pIrShrkyksyahtykeihi;
    }

    private BizCurrency irGsbnrkztsaeki;

    public BizCurrency getIrGsbnrkztsaeki() {
        return irGsbnrkztsaeki;
    }

    public void setIrGsbnrkztsaeki(BizCurrency pIrGsbnrkztsaeki) {
        irGsbnrkztsaeki = pIrGsbnrkztsaeki;
    }

    private C_ZeimuNaiyouHnsyuCtrlKbn irZeimunaiyouhensyuctrlkbn;

    public C_ZeimuNaiyouHnsyuCtrlKbn getIrZeimunaiyouhensyuctrlkbn() {
        return irZeimunaiyouhensyuctrlkbn;
    }

    public void setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn pIrZeimunaiyouhensyuctrlkbn) {
        irZeimunaiyouhensyuctrlkbn = pIrZeimunaiyouhensyuctrlkbn;
    }

    private C_SoukinsakisiteiKbn irSoukinsakisiteikbn;

    public C_SoukinsakisiteiKbn getIrSoukinsakisiteikbn() {
        return irSoukinsakisiteikbn;
    }

    public void setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn pIrSoukinsakisiteikbn) {
        irSoukinsakisiteikbn = pIrSoukinsakisiteikbn;
    }

    private C_Kaiyakujiyuu irKaiyakujiyuu;

    public C_Kaiyakujiyuu getIrKaiyakujiyuu() {
        return irKaiyakujiyuu;
    }

    public void setIrKaiyakujiyuu(C_Kaiyakujiyuu pIrKaiyakujiyuu) {
        irKaiyakujiyuu = pIrKaiyakujiyuu;
    }

    private C_UmuKbn irShrumu;

    public C_UmuKbn getIrShrumu() {
        return irShrumu;
    }

    public void setIrShrumu(C_UmuKbn pIrShrumu) {
        irShrumu = pIrShrumu;
    }

    private String irKazeinendo;

    public String getIrKazeinendo() {
        return irKazeinendo;
    }

    public void setIrKazeinendo(String pIrKazeinendo) {
        irKazeinendo = pIrKazeinendo;
    }

    private C_UmuKbn irYenshrtktekiumu;

    public C_UmuKbn getIrYenshrtktekiumu() {
        return irYenshrtktekiumu;
    }

    public void setIrYenshrtktekiumu(C_UmuKbn pIrYenshrtktekiumu) {
        irYenshrtktekiumu = pIrYenshrtktekiumu;
    }

    private BizCurrency irShrtienrsk;

    public BizCurrency getIrShrtienrsk() {
        return irShrtienrsk;
    }

    public void setIrShrtienrsk(BizCurrency pIrShrtienrsk) {
        irShrtienrsk = pIrShrtienrsk;
    }

    private String irBankcd;

    public String getIrBankcd() {
        return irBankcd;
    }

    public void setIrBankcd(String pIrBankcd) {
        irBankcd = pIrBankcd;
    }

    private BizCurrency irHnkngkkngk;

    public BizCurrency getIrHnkngkkngk() {
        return irHnkngkkngk;
    }

    public void setIrHnkngkkngk(BizCurrency pIrHnkngkkngk) {
        irHnkngkkngk = pIrHnkngkkngk;
    }

    private String irHnkntuukasyunm;

    public String getIrHnkntuukasyunm() {
        return irHnkntuukasyunm;
    }

    public void setIrHnkntuukasyunm(String pIrHnkntuukasyunm) {
        irHnkntuukasyunm = pIrHnkntuukasyunm;
    }

    private String irHnknymd;

    public String getIrHnknymd() {
        return irHnknymd;
    }

    public void setIrHnknymd(String pIrHnknymd) {
        irHnknymd = pIrHnknymd;
    }

    private String irZeimumongon1;

    public String getIrZeimumongon1() {
        return irZeimumongon1;
    }

    public void setIrZeimumongon1(String pIrZeimumongon1) {
        irZeimumongon1 = pIrZeimumongon1;
    }

    private String irZeimumongon2;

    public String getIrZeimumongon2() {
        return irZeimumongon2;
    }

    public void setIrZeimumongon2(String pIrZeimumongon2) {
        irZeimumongon2 = pIrZeimumongon2;
    }

    private String irZeimumongon3;

    public String getIrZeimumongon3() {
        return irZeimumongon3;
    }

    public void setIrZeimumongon3(String pIrZeimumongon3) {
        irZeimumongon3 = pIrZeimumongon3;
    }

    private String irZeimumongon4;

    public String getIrZeimumongon4() {
        return irZeimumongon4;
    }

    public void setIrZeimumongon4(String pIrZeimumongon4) {
        irZeimumongon4 = pIrZeimumongon4;
    }

    private String irZeimumongon5;

    public String getIrZeimumongon5() {
        return irZeimumongon5;
    }

    public void setIrZeimumongon5(String pIrZeimumongon5) {
        irZeimumongon5 = pIrZeimumongon5;
    }

    private String irOsirasemongon1;

    public String getIrOsirasemongon1() {
        return irOsirasemongon1;
    }

    public void setIrOsirasemongon1(String pIrOsirasemongon1) {
        irOsirasemongon1 = pIrOsirasemongon1;
    }

    private String irOsirasemongon2;

    public String getIrOsirasemongon2() {
        return irOsirasemongon2;
    }

    public void setIrOsirasemongon2(String pIrOsirasemongon2) {
        irOsirasemongon2 = pIrOsirasemongon2;
    }

    private String irOsirasemongon3;

    public String getIrOsirasemongon3() {
        return irOsirasemongon3;
    }

    public void setIrOsirasemongon3(String pIrOsirasemongon3) {
        irOsirasemongon3 = pIrOsirasemongon3;
    }

    private String irOsirasemongon4;

    public String getIrOsirasemongon4() {
        return irOsirasemongon4;
    }

    public void setIrOsirasemongon4(String pIrOsirasemongon4) {
        irOsirasemongon4 = pIrOsirasemongon4;
    }

    private String irOsirasemongon5;

    public String getIrOsirasemongon5() {
        return irOsirasemongon5;
    }

    public void setIrOsirasemongon5(String pIrOsirasemongon5) {
        irOsirasemongon5 = pIrOsirasemongon5;
    }

    private String irOsirasemongon6;

    public String getIrOsirasemongon6() {
        return irOsirasemongon6;
    }

    public void setIrOsirasemongon6(String pIrOsirasemongon6) {
        irOsirasemongon6 = pIrOsirasemongon6;
    }

    private String irOsirasemongon7;

    public String getIrOsirasemongon7() {
        return irOsirasemongon7;
    }

    public void setIrOsirasemongon7(String pIrOsirasemongon7) {
        irOsirasemongon7 = pIrOsirasemongon7;
    }

    private String irOsirasemongon8;

    public String getIrOsirasemongon8() {
        return irOsirasemongon8;
    }

    public void setIrOsirasemongon8(String pIrOsirasemongon8) {
        irOsirasemongon8 = pIrOsirasemongon8;
    }

    private String irOsirasemongon9;

    public String getIrOsirasemongon9() {
        return irOsirasemongon9;
    }

    public void setIrOsirasemongon9(String pIrOsirasemongon9) {
        irOsirasemongon9 = pIrOsirasemongon9;
    }

    private String irOsirasemongon10;

    public String getIrOsirasemongon10() {
        return irOsirasemongon10;
    }

    public void setIrOsirasemongon10(String pIrOsirasemongon10) {
        irOsirasemongon10 = pIrOsirasemongon10;
    }

    private String irOsirasemongon11;

    public String getIrOsirasemongon11() {
        return irOsirasemongon11;
    }

    public void setIrOsirasemongon11(String pIrOsirasemongon11) {
        irOsirasemongon11 = pIrOsirasemongon11;
    }

    private String irOsirasemongon12;

    public String getIrOsirasemongon12() {
        return irOsirasemongon12;
    }

    public void setIrOsirasemongon12(String pIrOsirasemongon12) {
        irOsirasemongon12 = pIrOsirasemongon12;
    }

    private String irOsirasemongon13;

    public String getIrOsirasemongon13() {
        return irOsirasemongon13;
    }

    public void setIrOsirasemongon13(String pIrOsirasemongon13) {
        irOsirasemongon13 = pIrOsirasemongon13;
    }

    private String irOsirasemongon14;

    public String getIrOsirasemongon14() {
        return irOsirasemongon14;
    }

    public void setIrOsirasemongon14(String pIrOsirasemongon14) {
        irOsirasemongon14 = pIrOsirasemongon14;
    }

    private String irOsirasemongon15;

    public String getIrOsirasemongon15() {
        return irOsirasemongon15;
    }

    public void setIrOsirasemongon15(String pIrOsirasemongon15) {
        irOsirasemongon15 = pIrOsirasemongon15;
    }

    private String irOsirasemongon16;

    public String getIrOsirasemongon16() {
        return irOsirasemongon16;
    }

    public void setIrOsirasemongon16(String pIrOsirasemongon16) {
        irOsirasemongon16 = pIrOsirasemongon16;
    }

    private String irOsirasemongon17;

    public String getIrOsirasemongon17() {
        return irOsirasemongon17;
    }

    public void setIrOsirasemongon17(String pIrOsirasemongon17) {
        irOsirasemongon17 = pIrOsirasemongon17;
    }

    private String irOsirasemongon18;

    public String getIrOsirasemongon18() {
        return irOsirasemongon18;
    }

    public void setIrOsirasemongon18(String pIrOsirasemongon18) {
        irOsirasemongon18 = pIrOsirasemongon18;
    }

    private String irOsirasemongon19;

    public String getIrOsirasemongon19() {
        return irOsirasemongon19;
    }

    public void setIrOsirasemongon19(String pIrOsirasemongon19) {
        irOsirasemongon19 = pIrOsirasemongon19;
    }

    private String irOsirasemongon20;

    public String getIrOsirasemongon20() {
        return irOsirasemongon20;
    }

    public void setIrOsirasemongon20(String pIrOsirasemongon20) {
        irOsirasemongon20 = pIrOsirasemongon20;
    }

    private String irOsirasemongon21;

    public String getIrOsirasemongon21() {
        return irOsirasemongon21;
    }

    public void setIrOsirasemongon21(String pIrOsirasemongon21) {
        irOsirasemongon21 = pIrOsirasemongon21;
    }

    private String irOsirasemongon22;

    public String getIrOsirasemongon22() {
        return irOsirasemongon22;
    }

    public void setIrOsirasemongon22(String pIrOsirasemongon22) {
        irOsirasemongon22 = pIrOsirasemongon22;
    }

    private String irOsirasemongon23;

    public String getIrOsirasemongon23() {
        return irOsirasemongon23;
    }

    public void setIrOsirasemongon23(String pIrOsirasemongon23) {
        irOsirasemongon23 = pIrOsirasemongon23;
    }

    private String irOsirasemongon24;

    public String getIrOsirasemongon24() {
        return irOsirasemongon24;
    }

    public void setIrOsirasemongon24(String pIrOsirasemongon24) {
        irOsirasemongon24 = pIrOsirasemongon24;
    }

    private String irOsirasemongon25;

    public String getIrOsirasemongon25() {
        return irOsirasemongon25;
    }

    public void setIrOsirasemongon25(String pIrOsirasemongon25) {
        irOsirasemongon25 = pIrOsirasemongon25;
    }

    private String irOsirasemongon26;

    public String getIrOsirasemongon26() {
        return irOsirasemongon26;
    }

    public void setIrOsirasemongon26(String pIrOsirasemongon26) {
        irOsirasemongon26 = pIrOsirasemongon26;
    }

    private String irOsirasemongon27;

    public String getIrOsirasemongon27() {
        return irOsirasemongon27;
    }

    public void setIrOsirasemongon27(String pIrOsirasemongon27) {
        irOsirasemongon27 = pIrOsirasemongon27;
    }

    private String irOsirasemongon28;

    public String getIrOsirasemongon28() {
        return irOsirasemongon28;
    }

    public void setIrOsirasemongon28(String pIrOsirasemongon28) {
        irOsirasemongon28 = pIrOsirasemongon28;
    }

    private String irOsirasemongon29;

    public String getIrOsirasemongon29() {
        return irOsirasemongon29;
    }

    public void setIrOsirasemongon29(String pIrOsirasemongon29) {
        irOsirasemongon29 = pIrOsirasemongon29;
    }

    private String irOsirasemongon30;

    public String getIrOsirasemongon30() {
        return irOsirasemongon30;
    }

    public void setIrOsirasemongon30(String pIrOsirasemongon30) {
        irOsirasemongon30 = pIrOsirasemongon30;
    }

    private String irOsirasemongon31;

    public String getIrOsirasemongon31() {
        return irOsirasemongon31;
    }

    public void setIrOsirasemongon31(String pIrOsirasemongon31) {
        irOsirasemongon31 = pIrOsirasemongon31;
    }

    private String irOsirasemongon32;

    public String getIrOsirasemongon32() {
        return irOsirasemongon32;
    }

    public void setIrOsirasemongon32(String pIrOsirasemongon32) {
        irOsirasemongon32 = pIrOsirasemongon32;
    }

    private String irOsirasemongon33;

    public String getIrOsirasemongon33() {
        return irOsirasemongon33;
    }

    public void setIrOsirasemongon33(String pIrOsirasemongon33) {
        irOsirasemongon33 = pIrOsirasemongon33;
    }

    private String irOsirasemongon34;

    public String getIrOsirasemongon34() {
        return irOsirasemongon34;
    }

    public void setIrOsirasemongon34(String pIrOsirasemongon34) {
        irOsirasemongon34 = pIrOsirasemongon34;
    }

    private String irOsirasemongon35;

    public String getIrOsirasemongon35() {
        return irOsirasemongon35;
    }

    public void setIrOsirasemongon35(String pIrOsirasemongon35) {
        irOsirasemongon35 = pIrOsirasemongon35;
    }

    private String irOsirasemongon36;

    public String getIrOsirasemongon36() {
        return irOsirasemongon36;
    }

    public void setIrOsirasemongon36(String pIrOsirasemongon36) {
        irOsirasemongon36 = pIrOsirasemongon36;
    }

    private String irOsirasemongon37;

    public String getIrOsirasemongon37() {
        return irOsirasemongon37;
    }

    public void setIrOsirasemongon37(String pIrOsirasemongon37) {
        irOsirasemongon37 = pIrOsirasemongon37;
    }

    private String irOsirasemongon38;

    public String getIrOsirasemongon38() {
        return irOsirasemongon38;
    }

    public void setIrOsirasemongon38(String pIrOsirasemongon38) {
        irOsirasemongon38 = pIrOsirasemongon38;
    }

    private String irOsirasemongon39;

    public String getIrOsirasemongon39() {
        return irOsirasemongon39;
    }

    public void setIrOsirasemongon39(String pIrOsirasemongon39) {
        irOsirasemongon39 = pIrOsirasemongon39;
    }

    private String irOsirasemongon40;

    public String getIrOsirasemongon40() {
        return irOsirasemongon40;
    }

    public void setIrOsirasemongon40(String pIrOsirasemongon40) {
        irOsirasemongon40 = pIrOsirasemongon40;
    }

    private String irOsirasemongon41;

    public String getIrOsirasemongon41() {
        return irOsirasemongon41;
    }

    public void setIrOsirasemongon41(String pIrOsirasemongon41) {
        irOsirasemongon41 = pIrOsirasemongon41;
    }

    private String irOsirasemongon42;

    public String getIrOsirasemongon42() {
        return irOsirasemongon42;
    }

    public void setIrOsirasemongon42(String pIrOsirasemongon42) {
        irOsirasemongon42 = pIrOsirasemongon42;
    }

    private String irOsirasemongon43;

    public String getIrOsirasemongon43() {
        return irOsirasemongon43;
    }

    public void setIrOsirasemongon43(String pIrOsirasemongon43) {
        irOsirasemongon43 = pIrOsirasemongon43;
    }

    private String irOsirasemongon44;

    public String getIrOsirasemongon44() {
        return irOsirasemongon44;
    }

    public void setIrOsirasemongon44(String pIrOsirasemongon44) {
        irOsirasemongon44 = pIrOsirasemongon44;
    }

    private String irOsirasemongon45;

    public String getIrOsirasemongon45() {
        return irOsirasemongon45;
    }

    public void setIrOsirasemongon45(String pIrOsirasemongon45) {
        irOsirasemongon45 = pIrOsirasemongon45;
    }

    private String irOsirasemongon46;

    public String getIrOsirasemongon46() {
        return irOsirasemongon46;
    }

    public void setIrOsirasemongon46(String pIrOsirasemongon46) {
        irOsirasemongon46 = pIrOsirasemongon46;
    }

    private String irOsirasemongon47;

    public String getIrOsirasemongon47() {
        return irOsirasemongon47;
    }

    public void setIrOsirasemongon47(String pIrOsirasemongon47) {
        irOsirasemongon47 = pIrOsirasemongon47;
    }

    private String irOsirasemongon48;

    public String getIrOsirasemongon48() {
        return irOsirasemongon48;
    }

    public void setIrOsirasemongon48(String pIrOsirasemongon48) {
        irOsirasemongon48 = pIrOsirasemongon48;
    }

    private String irOsirasemongon49;

    public String getIrOsirasemongon49() {
        return irOsirasemongon49;
    }

    public void setIrOsirasemongon49(String pIrOsirasemongon49) {
        irOsirasemongon49 = pIrOsirasemongon49;
    }

    private String irOsirasemongon50;

    public String getIrOsirasemongon50() {
        return irOsirasemongon50;
    }

    public void setIrOsirasemongon50(String pIrOsirasemongon50) {
        irOsirasemongon50 = pIrOsirasemongon50;
    }

    private String irShrnaiyouhskmongon1;

    public String getIrShrnaiyouhskmongon1() {
        return irShrnaiyouhskmongon1;
    }

    public void setIrShrnaiyouhskmongon1(String pIrShrnaiyouhskmongon1) {
        irShrnaiyouhskmongon1 = pIrShrnaiyouhskmongon1;
    }

    private String irShrnaiyouhskmongon2;

    public String getIrShrnaiyouhskmongon2() {
        return irShrnaiyouhskmongon2;
    }

    public void setIrShrnaiyouhskmongon2(String pIrShrnaiyouhskmongon2) {
        irShrnaiyouhskmongon2 = pIrShrnaiyouhskmongon2;
    }

    private C_UmuKbn irYuuyokkntyoukaumu;

    public C_UmuKbn getIrYuuyokkntyoukaumu() {
        return irYuuyokkntyoukaumu;
    }

    public void setIrYuuyokkntyoukaumu(C_UmuKbn pIrYuuyokkntyoukaumu) {
        irYuuyokkntyoukaumu = pIrYuuyokkntyoukaumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
