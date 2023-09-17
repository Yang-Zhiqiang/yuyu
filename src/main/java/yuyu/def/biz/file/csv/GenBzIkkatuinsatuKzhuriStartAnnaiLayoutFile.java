package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * （共通）専用帳票一括印刷送信ファイル（口座振替開始案内レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzIkkatuinsatuKzhuriStartAnnaiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzIkkatuinsatuKzhuriStartAnnaiLayoutFile() {
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

    @Column(order = 5, label = "（ＩＦｃ）充当年月")
    private BizDateYM ifcJyutouym;

    public BizDateYM getIfcJyutouym() {
        return ifcJyutouym;
    }

    public void setIfcJyutouym(BizDateYM pIfcJyutouym) {
        ifcJyutouym = pIfcJyutouym;
    }

    @Column(order = 6, label = "（ＩＦｃ）充当回数（年）")
    private Integer ifcJyutoukaisuuy;

    public Integer getIfcJyutoukaisuuy() {
        return ifcJyutoukaisuuy;
    }

    public void setIfcJyutoukaisuuy(Integer pIfcJyutoukaisuuy) {
        ifcJyutoukaisuuy = pIfcJyutoukaisuuy;
    }

    @Column(order = 7, label = "（ＩＦｃ）充当回数（月）")
    private Integer ifcJyutoukaisuum;

    public Integer getIfcJyutoukaisuum() {
        return ifcJyutoukaisuum;
    }

    public void setIfcJyutoukaisuum(Integer pIfcJyutoukaisuum) {
        ifcJyutoukaisuum = pIfcJyutoukaisuum;
    }

    @Column(order = 8, label = "（ＩＦｃ）領収金額（１３，３桁）")
    private String ifcRyosyugk;

    public String getIfcRyosyugk() {
        return ifcRyosyugk;
    }

    public void setIfcRyosyugk(String pIfcRyosyugk) {
        ifcRyosyugk = pIfcRyosyugk;
    }

    @Column(order = 9, label = "（ＩＦｃ）払込保険料")
    private String ifcHrkp;

    public String getIfcHrkp() {
        return ifcHrkp;
    }

    public void setIfcHrkp(String pIfcHrkp) {
        ifcHrkp = pIfcHrkp;
    }

    @Column(order = 10, label = "（ＩＦｃ）振替日")
    private BizDate ifcHurikaeymd;

    public BizDate getIfcHurikaeymd() {
        return ifcHurikaeymd;
    }

    public void setIfcHurikaeymd(BizDate pIfcHurikaeymd) {
        ifcHurikaeymd = pIfcHurikaeymd;
    }

    @Column(order = 11, label = "（ＩＦｃ）銀行コード")
    private String ifcBankcd;

    public String getIfcBankcd() {
        return ifcBankcd;
    }

    public void setIfcBankcd(String pIfcBankcd) {
        ifcBankcd = pIfcBankcd;
    }

    @Column(order = 12, label = "（ＩＦｃ）支店コード")
    private String ifcSitencd;

    public String getIfcSitencd() {
        return ifcSitencd;
    }

    public void setIfcSitencd(String pIfcSitencd) {
        ifcSitencd = pIfcSitencd;
    }

    @Column(order = 13, label = "（ＩＦｃ）口座番号")
    private String ifcKouzano;

    public String getIfcKouzano() {
        return ifcKouzano;
    }

    public void setIfcKouzano(String pIfcKouzano) {
        ifcKouzano = pIfcKouzano;
    }

    @Column(order = 14, label = "（ＩＦｃ）口座名義人氏名（カナ）")
    private String ifcKzmeiginmkn;

    public String getIfcKzmeiginmkn() {
        return ifcKzmeiginmkn;
    }

    public void setIfcKzmeiginmkn(String pIfcKzmeiginmkn) {
        ifcKzmeiginmkn = pIfcKzmeiginmkn;
    }

    @Column(order = 15, label = "（ＩＦｃ）契約者名（漢字）")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 16, label = "（ＩＦｃ）通信先郵便番号")
    private String ifcTsinyno;

    public String getIfcTsinyno() {
        return ifcTsinyno;
    }

    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }

    @Column(order = 17, label = "（ＩＦｃ）通信先住所１（漢字）")
    private String ifcTsinadr1kj;

    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }

    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }

    @Column(order = 18, label = "（ＩＦｃ）通信先住所２（漢字）")
    private String ifcTsinadr2kj;

    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }

    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }

    @Column(order = 19, label = "（ＩＦｃ）通信先住所３（漢字）")
    private String ifcTsinadr3kj;

    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }

    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }

    @Column(order = 20, label = "（ＩＦｃ）通信先住所４（漢字）")
    private String ifcTsinadr4kj;

    public String getIfcTsinadr4kj() {
        return ifcTsinadr4kj;
    }

    public void setIfcTsinadr4kj(String pIfcTsinadr4kj) {
        ifcTsinadr4kj = pIfcTsinadr4kj;
    }

    @Column(order = 21, label = "（ＩＦｃ）被保険者名（漢字）")
    private String ifcHhknnmkj;

    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }

    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }

    @Column(order = 22, label = "（ＩＦｃ）商品名")
    private String ifcSyouhnnm;

    public String getIfcSyouhnnm() {
        return ifcSyouhnnm;
    }

    public void setIfcSyouhnnm(String pIfcSyouhnnm) {
        ifcSyouhnnm = pIfcSyouhnnm;
    }

    @Column(order = 23, label = "（ＩＦｃ）銀行名（漢字）")
    private String ifcBanknmkj;

    public String getIfcBanknmkj() {
        return ifcBanknmkj;
    }

    public void setIfcBanknmkj(String pIfcBanknmkj) {
        ifcBanknmkj = pIfcBanknmkj;
    }

    @Column(order = 24, label = "（ＩＦｃ）支店名（漢字）")
    private String ifcSitennmkj;

    public String getIfcSitennmkj() {
        return ifcSitennmkj;
    }

    public void setIfcSitennmkj(String pIfcSitennmkj) {
        ifcSitennmkj = pIfcSitennmkj;
    }

    @Column(order = 25, label = "（ＩＦｃ）預金種目区分")
    private C_YokinKbn ifcYokinkbn;

    public C_YokinKbn getIfcYokinkbn() {
        return ifcYokinkbn;
    }

    public void setIfcYokinkbn(C_YokinKbn pIfcYokinkbn) {
        ifcYokinkbn = pIfcYokinkbn;
    }

    @Column(order = 26, label = "（ＩＦｃ）預金種目名（漢字）")
    private String ifcYokinknmkj;

    public String getIfcYokinknmkj() {
        return ifcYokinknmkj;
    }

    public void setIfcYokinknmkj(String pIfcYokinknmkj) {
        ifcYokinknmkj = pIfcYokinknmkj;
    }

    @Column(order = 27, label = "（ＩＦｃ）代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 28, label = "（ＩＦｃ）代理店名（漢字）")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 29, label = "（ＩＦｃ）契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 30, label = "（ＩＦｃ）猶予期間満了日")
    private BizDate ifcYykknmnryymd;

    public BizDate getIfcYykknmnryymd() {
        return ifcYykknmnryymd;
    }

    public void setIfcYykknmnryymd(BizDate pIfcYykknmnryymd) {
        ifcYykknmnryymd = pIfcYykknmnryymd;
    }

    @Column(order = 31, label = "（ＩＦｃ）印字パターン区分")
    private Integer ifcInjiptnkbn;

    public Integer getIfcInjiptnkbn() {
        return ifcInjiptnkbn;
    }

    public void setIfcInjiptnkbn(Integer pIfcInjiptnkbn) {
        ifcInjiptnkbn = pIfcInjiptnkbn;
    }

    @Column(order = 32, label = "（ＩＦｃ）帳票作成日")
    private BizDate ifcTyouhyousakuseiymd;

    public BizDate getIfcTyouhyousakuseiymd() {
        return ifcTyouhyousakuseiymd;
    }

    public void setIfcTyouhyousakuseiymd(BizDate pIfcTyouhyousakuseiymd) {
        ifcTyouhyousakuseiymd = pIfcTyouhyousakuseiymd;
    }

    @Column(order = 33, label = "（ＩＦｃ）取扱コード")
    private Integer ifcTratkicd;

    public Integer getIfcTratkicd() {
        return ifcTratkicd;
    }

    public void setIfcTratkicd(Integer pIfcTratkicd) {
        ifcTratkicd = pIfcTratkicd;
    }

    @Column(order = 34, label = "（ＩＦｃ）帳票コード")
    private String ifcTyouhyoucd;

    public String getIfcTyouhyoucd() {
        return ifcTyouhyoucd;
    }

    public void setIfcTyouhyoucd(String pIfcTyouhyoucd) {
        ifcTyouhyoucd = pIfcTyouhyoucd;
    }

    @Column(order = 35, label = "（ＩＦｃ）帳票連絡先識別区分")
    private C_TyhyrenrakusikibetuKbn ifcTyhyrenrakusikibetukbn;

    public C_TyhyrenrakusikibetuKbn getIfcTyhyrenrakusikibetukbn() {
        return ifcTyhyrenrakusikibetukbn;
    }

    public void setIfcTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pIfcTyhyrenrakusikibetukbn) {
        ifcTyhyrenrakusikibetukbn = pIfcTyhyrenrakusikibetukbn;
    }

    @Column(order = 36, label = "（ＩＦｃ）エンド")
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
