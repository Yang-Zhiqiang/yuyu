package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SosysaiyouhiKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * （共通）専用帳票一括印刷送信ファイル（手続完了レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzIkkatuinsatuTtdkKanLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzIkkatuinsatuTtdkKanLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）レコード区分")
    private String ifcRecordkbn;

    public String getIfcRecordkbn() {
        return ifcRecordkbn;
    }

    public void setIfcRecordkbn(String pIfcRecordkbn) {
        ifcRecordkbn = pIfcRecordkbn;
    }

    @Column(order = 2, label = "（ＩＦｃ）書類コード")
    private String ifcSyoruicd;

    public String getIfcSyoruicd() {
        return ifcSyoruicd;
    }

    public void setIfcSyoruicd(String pIfcSyoruicd) {
        ifcSyoruicd = pIfcSyoruicd;
    }

    @Column(order = 3, label = "（ＩＦｃ）一連番号")
    private String ifcItirenno;

    public String getIfcItirenno() {
        return ifcItirenno;
    }

    public void setIfcItirenno(String pIfcItirenno) {
        ifcItirenno = pIfcItirenno;
    }

    @Column(order = 4, label = "（ＩＦｃ）証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 5, label = "（ＩＦｃ）帳票作成日")
    private BizDate ifcTyouhyousakuseiymd;

    public BizDate getIfcTyouhyousakuseiymd() {
        return ifcTyouhyousakuseiymd;
    }

    public void setIfcTyouhyousakuseiymd(BizDate pIfcTyouhyousakuseiymd) {
        ifcTyouhyousakuseiymd = pIfcTyouhyousakuseiymd;
    }

    @Column(order = 6, label = "（ＩＦｃ）手続種類区分")
    private C_TetudukisyuKbn ifcTetudukisyukbn;

    public C_TetudukisyuKbn getIfcTetudukisyukbn() {
        return ifcTetudukisyukbn;
    }

    public void setIfcTetudukisyukbn(C_TetudukisyuKbn pIfcTetudukisyukbn) {
        ifcTetudukisyukbn = pIfcTetudukisyukbn;
    }

    @Column(order = 7, label = "（ＩＦｃ）支払有無区分")
    private C_UmuKbn ifcShrumu;

    public C_UmuKbn getIfcShrumu() {
        return ifcShrumu;
    }

    public void setIfcShrumu(C_UmuKbn pIfcShrumu) {
        ifcShrumu = pIfcShrumu;
    }

    @Column(order = 8, label = "（ＩＦｃ）通信先郵便番号")
    private String ifcTsinyno;

    public String getIfcTsinyno() {
        return ifcTsinyno;
    }

    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }

    @Column(order = 9, label = "（ＩＦｃ）通信先住所１（漢字）")
    private String ifcTsinadr1kj;

    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }

    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }

    @Column(order = 10, label = "（ＩＦｃ）通信先住所２（漢字）")
    private String ifcTsinadr2kj;

    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }

    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }

    @Column(order = 11, label = "（ＩＦｃ）通信先住所３（漢字）")
    private String ifcTsinadr3kj;

    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }

    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }

    @Column(order = 12, label = "（ＩＦｃ）通信先住所４（漢字）")
    private String ifcTsinadr4kj;

    public String getIfcTsinadr4kj() {
        return ifcTsinadr4kj;
    }

    public void setIfcTsinadr4kj(String pIfcTsinadr4kj) {
        ifcTsinadr4kj = pIfcTsinadr4kj;
    }

    @Column(order = 13, label = "（ＩＦｃ）契約者名（漢字）")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 14, label = "（ＩＦｃ）契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 15, label = "（ＩＦｃ）商品名")
    private String ifcSyouhnnm;

    public String getIfcSyouhnnm() {
        return ifcSyouhnnm;
    }

    public void setIfcSyouhnnm(String pIfcSyouhnnm) {
        ifcSyouhnnm = pIfcSyouhnnm;
    }

    @Column(order = 16, label = "（ＩＦｃ）被保険者名（漢字）")
    private String ifcHhknnmkj;

    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }

    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }

    @Column(order = 17, label = "（ＩＦｃ）通信先電話番号")
    private String ifcTsintelno;

    public String getIfcTsintelno() {
        return ifcTsintelno;
    }

    public void setIfcTsintelno(String pIfcTsintelno) {
        ifcTsintelno = pIfcTsintelno;
    }

    @Column(order = 18, label = "（ＩＦｃ）日中連絡先電話番号")
    private String ifcNittyuutelno;

    public String getIfcNittyuutelno() {
        return ifcNittyuutelno;
    }

    public void setIfcNittyuutelno(String pIfcNittyuutelno) {
        ifcNittyuutelno = pIfcNittyuutelno;
    }

    @Column(order = 19, label = "（ＩＦｃ）被保険者郵便番号")
    private String ifcHhknyno;

    public String getIfcHhknyno() {
        return ifcHhknyno;
    }

    public void setIfcHhknyno(String pIfcHhknyno) {
        ifcHhknyno = pIfcHhknyno;
    }

    @Column(order = 20, label = "（ＩＦｃ）被保険者住所１（漢字）")
    private String ifcHhknadr1kj;

    public String getIfcHhknadr1kj() {
        return ifcHhknadr1kj;
    }

    public void setIfcHhknadr1kj(String pIfcHhknadr1kj) {
        ifcHhknadr1kj = pIfcHhknadr1kj;
    }

    @Column(order = 21, label = "（ＩＦｃ）被保険者住所２（漢字）")
    private String ifcHhknadr2kj;

    public String getIfcHhknadr2kj() {
        return ifcHhknadr2kj;
    }

    public void setIfcHhknadr2kj(String pIfcHhknadr2kj) {
        ifcHhknadr2kj = pIfcHhknadr2kj;
    }

    @Column(order = 22, label = "（ＩＦｃ）被保険者住所３（漢字）")
    private String ifcHhknadr3kj;

    public String getIfcHhknadr3kj() {
        return ifcHhknadr3kj;
    }

    public void setIfcHhknadr3kj(String pIfcHhknadr3kj) {
        ifcHhknadr3kj = pIfcHhknadr3kj;
    }

    @Column(order = 23, label = "（ＩＦｃ）被保険者住所４（漢字）")
    private String ifcHhknadr4kj;

    public String getIfcHhknadr4kj() {
        return ifcHhknadr4kj;
    }

    public void setIfcHhknadr4kj(String pIfcHhknadr4kj) {
        ifcHhknadr4kj = pIfcHhknadr4kj;
    }

    @Column(order = 24, label = "（ＩＦｃ）被保険者電話番号")
    private String ifcHhkntelno;

    public String getIfcHhkntelno() {
        return ifcHhkntelno;
    }

    public void setIfcHhkntelno(String pIfcHhkntelno) {
        ifcHhkntelno = pIfcHhkntelno;
    }

    @Column(order = 25, label = "（ＩＦｃ）クレジットカード番号１")
    private String ifcCreditcardno1;

    public String getIfcCreditcardno1() {
        return ifcCreditcardno1;
    }

    public void setIfcCreditcardno1(String pIfcCreditcardno1) {
        ifcCreditcardno1 = pIfcCreditcardno1;
    }

    @Column(order = 26, label = "（ＩＦｃ）クレジットカード番号２")
    private String ifcCreditcardno2;

    public String getIfcCreditcardno2() {
        return ifcCreditcardno2;
    }

    public void setIfcCreditcardno2(String pIfcCreditcardno2) {
        ifcCreditcardno2 = pIfcCreditcardno2;
    }

    @Column(order = 27, label = "（ＩＦｃ）クレジットカード番号３")
    private String ifcCreditcardno3;

    public String getIfcCreditcardno3() {
        return ifcCreditcardno3;
    }

    public void setIfcCreditcardno3(String pIfcCreditcardno3) {
        ifcCreditcardno3 = pIfcCreditcardno3;
    }

    @Column(order = 28, label = "（ＩＦｃ）クレジットカード番号４")
    private String ifcCreditcardno4;

    public String getIfcCreditcardno4() {
        return ifcCreditcardno4;
    }

    public void setIfcCreditcardno4(String pIfcCreditcardno4) {
        ifcCreditcardno4 = pIfcCreditcardno4;
    }

    @Column(order = 29, label = "（ＩＦｃ）効力発生日")
    private BizDate ifcKouryokuhasseiymd;

    public BizDate getIfcKouryokuhasseiymd() {
        return ifcKouryokuhasseiymd;
    }

    public void setIfcKouryokuhasseiymd(BizDate pIfcKouryokuhasseiymd) {
        ifcKouryokuhasseiymd = pIfcKouryokuhasseiymd;
    }

    @Column(order = 30, label = "（ＩＦｃ）払込経路")
    private C_Hrkkeiro ifcHrkkeiro;

    public C_Hrkkeiro getIfcHrkkeiro() {
        return ifcHrkkeiro;
    }

    public void setIfcHrkkeiro(C_Hrkkeiro pIfcHrkkeiro) {
        ifcHrkkeiro = pIfcHrkkeiro;
    }

    @Column(order = 31, label = "（ＩＦｃ）払込回数")
    private C_Hrkkaisuu ifcHrkkaisuu;

    public C_Hrkkaisuu getIfcHrkkaisuu() {
        return ifcHrkkaisuu;
    }

    public void setIfcHrkkaisuu(C_Hrkkaisuu pIfcHrkkaisuu) {
        ifcHrkkaisuu = pIfcHrkkaisuu;
    }

    @Column(order = 32, label = "（ＩＦｃ）払込経路変更有無区分")
    private C_UmuKbn ifcHrkkeirohnkumu;

    public C_UmuKbn getIfcHrkkeirohnkumu() {
        return ifcHrkkeirohnkumu;
    }

    public void setIfcHrkkeirohnkumu(C_UmuKbn pIfcHrkkeirohnkumu) {
        ifcHrkkeirohnkumu = pIfcHrkkeirohnkumu;
    }

    @Column(order = 33, label = "（ＩＦｃ）払込回数変更有無区分")
    private C_UmuKbn ifcHrkkaisuuhnkumu;

    public C_UmuKbn getIfcHrkkaisuuhnkumu() {
        return ifcHrkkaisuuhnkumu;
    }

    public void setIfcHrkkaisuuhnkumu(C_UmuKbn pIfcHrkkaisuuhnkumu) {
        ifcHrkkaisuuhnkumu = pIfcHrkkaisuuhnkumu;
    }

    @Column(order = 34, label = "（ＩＦｃ）支払日")
    private BizDate ifcShrymd;

    public BizDate getIfcShrymd() {
        return ifcShrymd;
    }

    public void setIfcShrymd(BizDate pIfcShrymd) {
        ifcShrymd = pIfcShrymd;
    }

    @Column(order = 35, label = "（ＩＦｃ）支払額合計")
    private String ifcShrgkgoukei;

    public String getIfcShrgkgoukei() {
        return ifcShrgkgoukei;
    }

    public void setIfcShrgkgoukei(String pIfcShrgkgoukei) {
        ifcShrgkgoukei = pIfcShrgkgoukei;
    }

    @Column(order = 36, label = "（ＩＦｃ）解約返戻金")
    private String ifcKaiyakuhr;

    public String getIfcKaiyakuhr() {
        return ifcKaiyakuhr;
    }

    public void setIfcKaiyakuhr(String pIfcKaiyakuhr) {
        ifcKaiyakuhr = pIfcKaiyakuhr;
    }

    @Column(order = 37, label = "（ＩＦｃ）未経過保険料")
    private String ifcMikeikap;

    public String getIfcMikeikap() {
        return ifcMikeikap;
    }

    public void setIfcMikeikap(String pIfcMikeikap) {
        ifcMikeikap = pIfcMikeikap;
    }

    @Column(order = 38, label = "（ＩＦｃ）その他精算額")
    private String ifcSonotaseisangk;

    public String getIfcSonotaseisangk() {
        return ifcSonotaseisangk;
    }

    public void setIfcSonotaseisangk(String pIfcSonotaseisangk) {
        ifcSonotaseisangk = pIfcSonotaseisangk;
    }

    @Column(order = 39, label = "（ＩＦｃ）源泉徴収税額")
    private String ifcGstszeigk;

    public String getIfcGstszeigk() {
        return ifcGstszeigk;
    }

    public void setIfcGstszeigk(String pIfcGstszeigk) {
        ifcGstszeigk = pIfcGstszeigk;
    }

    @Column(order = 40, label = "（ＩＦｃ）支払遅延利息")
    private String ifcShrtienrsk;

    public String getIfcShrtienrsk() {
        return ifcShrtienrsk;
    }

    public void setIfcShrtienrsk(String pIfcShrtienrsk) {
        ifcShrtienrsk = pIfcShrtienrsk;
    }

    @Column(order = 41, label = "（ＩＦｃ）銀行コード")
    private String ifcBankcd;

    public String getIfcBankcd() {
        return ifcBankcd;
    }

    public void setIfcBankcd(String pIfcBankcd) {
        ifcBankcd = pIfcBankcd;
    }

    @Column(order = 42, label = "（ＩＦｃ）支店コード")
    private String ifcSitencd;

    public String getIfcSitencd() {
        return ifcSitencd;
    }

    public void setIfcSitencd(String pIfcSitencd) {
        ifcSitencd = pIfcSitencd;
    }

    @Column(order = 43, label = "（ＩＦｃ）銀行名（漢字）")
    private String ifcBanknmkj;

    public String getIfcBanknmkj() {
        return ifcBanknmkj;
    }

    public void setIfcBanknmkj(String pIfcBanknmkj) {
        ifcBanknmkj = pIfcBanknmkj;
    }

    @Column(order = 44, label = "（ＩＦｃ）支店名（漢字）")
    private String ifcSitennmkj;

    public String getIfcSitennmkj() {
        return ifcSitennmkj;
    }

    public void setIfcSitennmkj(String pIfcSitennmkj) {
        ifcSitennmkj = pIfcSitennmkj;
    }

    @Column(order = 45, label = "（ＩＦｃ）預金種目区分")
    private C_YokinKbn ifcYokinkbn;

    public C_YokinKbn getIfcYokinkbn() {
        return ifcYokinkbn;
    }

    public void setIfcYokinkbn(C_YokinKbn pIfcYokinkbn) {
        ifcYokinkbn = pIfcYokinkbn;
    }

    @Column(order = 46, label = "（ＩＦｃ）口座番号")
    private String ifcKouzano;

    public String getIfcKouzano() {
        return ifcKouzano;
    }

    public void setIfcKouzano(String pIfcKouzano) {
        ifcKouzano = pIfcKouzano;
    }

    @Column(order = 47, label = "（ＩＦｃ）口座名義人氏名（カナ）")
    private String ifcKzmeiginmkn;

    public String getIfcKzmeiginmkn() {
        return ifcKzmeiginmkn;
    }

    public void setIfcKzmeiginmkn(String pIfcKzmeiginmkn) {
        ifcKzmeiginmkn = pIfcKzmeiginmkn;
    }

    @Column(order = 48, label = "（ＩＦｃ）取扱コード")
    private Integer ifcTratkicd;

    public Integer getIfcTratkicd() {
        return ifcTratkicd;
    }

    public void setIfcTratkicd(Integer pIfcTratkicd) {
        ifcTratkicd = pIfcTratkicd;
    }

    @Column(order = 49, label = "（ＩＦｃ）帳票コード")
    private String ifcTyouhyoucd;

    public String getIfcTyouhyoucd() {
        return ifcTyouhyoucd;
    }

    public void setIfcTyouhyoucd(String pIfcTyouhyoucd) {
        ifcTyouhyoucd = pIfcTyouhyoucd;
    }

    @Column(order = 50, label = "（ＩＦｃ）一時所得課税有無区分")
    private C_UmuKbn ifcItjsytkkziumu;

    public C_UmuKbn getIfcItjsytkkziumu() {
        return ifcItjsytkkziumu;
    }

    public void setIfcItjsytkkziumu(C_UmuKbn pIfcItjsytkkziumu) {
        ifcItjsytkkziumu = pIfcItjsytkkziumu;
    }

    @Column(order = 51, label = "（ＩＦｃ）必要経費")
    private String ifcHtykeihi;

    public String getIfcHtykeihi() {
        return ifcHtykeihi;
    }

    public void setIfcHtykeihi(String pIfcHtykeihi) {
        ifcHtykeihi = pIfcHtykeihi;
    }

    @Column(order = 52, label = "（ＩＦｃ）帳票連絡先識別区分")
    private C_TyhyrenrakusikibetuKbn ifcTyhyrenrakusikibetukbn;

    public C_TyhyrenrakusikibetuKbn getIfcTyhyrenrakusikibetukbn() {
        return ifcTyhyrenrakusikibetukbn;
    }

    public void setIfcTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pIfcTyhyrenrakusikibetukbn) {
        ifcTyhyrenrakusikibetukbn = pIfcTyhyrenrakusikibetukbn;
    }

    @Column(order = 53, label = "（ＩＦｃ）責任開始日")
    private BizDate ifcSknnkaisiymd;

    public BizDate getIfcSknnkaisiymd() {
        return ifcSknnkaisiymd;
    }

    public void setIfcSknnkaisiymd(BizDate pIfcSknnkaisiymd) {
        ifcSknnkaisiymd = pIfcSknnkaisiymd;
    }

    @Column(order = 54, label = "（ＩＦｃ）がん責任開始日")
    private BizDate ifcGansknnkaisiymd;

    public BizDate getIfcGansknnkaisiymd() {
        return ifcGansknnkaisiymd;
    }

    public void setIfcGansknnkaisiymd(BizDate pIfcGansknnkaisiymd) {
        ifcGansknnkaisiymd = pIfcGansknnkaisiymd;
    }

    @Column(order = 55, label = "（ＩＦｃ）証券再発行要否区分")
    private C_SosysaiyouhiKbn ifcSyosaihkyouhikbn;

    public C_SosysaiyouhiKbn getIfcSyosaihkyouhikbn() {
        return ifcSyosaihkyouhikbn;
    }

    public void setIfcSyosaihkyouhikbn(C_SosysaiyouhiKbn pIfcSyosaihkyouhikbn) {
        ifcSyosaihkyouhikbn = pIfcSyosaihkyouhikbn;
    }

    @Column(order = 56, label = "（ＩＦｃ）エンド")
    private String ifcEnd;

    public String getIfcEnd() {
        return ifcEnd;
    }

    public void setIfcEnd(String pIfcEnd) {
        ifcEnd = pIfcEnd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
