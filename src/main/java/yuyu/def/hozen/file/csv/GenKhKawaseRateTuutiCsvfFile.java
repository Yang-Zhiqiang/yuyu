package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）為替レート通知ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKawaseRateTuutiCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhKawaseRateTuutiCsvfFile() {
    }

    @Column(order = 1, label = "通知郵送有無")
    private String ifcTuutiyusouumu;

    public String getIfcTuutiyusouumu() {
        return ifcTuutiyusouumu;
    }

    public void setIfcTuutiyusouumu(String pIfcTuutiyusouumu) {
        ifcTuutiyusouumu = pIfcTuutiyusouumu;
    }

    @Column(order = 2, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 3, label = "送付先郵便番号")
    private String ifcShskyno;

    public String getIfcShskyno() {
        return ifcShskyno;
    }

    public void setIfcShskyno(String pIfcShskyno) {
        ifcShskyno = pIfcShskyno;
    }

    @Column(order = 4, label = "送付先住所１（漢字）")
    private String ifcShskadr1kj;

    public String getIfcShskadr1kj() {
        return ifcShskadr1kj;
    }

    public void setIfcShskadr1kj(String pIfcShskadr1kj) {
        ifcShskadr1kj = pIfcShskadr1kj;
    }

    @Column(order = 5, label = "送付先住所２（漢字）")
    private String ifcShskadr2kj;

    public String getIfcShskadr2kj() {
        return ifcShskadr2kj;
    }

    public void setIfcShskadr2kj(String pIfcShskadr2kj) {
        ifcShskadr2kj = pIfcShskadr2kj;
    }

    @Column(order = 6, label = "送付先住所３（漢字）")
    private String ifcShskadr3kj;

    public String getIfcShskadr3kj() {
        return ifcShskadr3kj;
    }

    public void setIfcShskadr3kj(String pIfcShskadr3kj) {
        ifcShskadr3kj = pIfcShskadr3kj;
    }

    @Column(order = 7, label = "送付先氏名（漢字）")
    private String ifcShsknmkj;

    public String getIfcShsknmkj() {
        return ifcShsknmkj;
    }

    public void setIfcShsknmkj(String pIfcShsknmkj) {
        ifcShsknmkj = pIfcShsknmkj;
    }

    @Column(order = 8, label = "被保険者名（漢字）")
    private String ifcHhknnmkj;

    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }

    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }

    @Column(order = 9, label = "銀行名")
    private String ifcBanknm;

    public String getIfcBanknm() {
        return ifcBanknm;
    }

    public void setIfcBanknm(String pIfcBanknm) {
        ifcBanknm = pIfcBanknm;
    }

    @Column(order = 10, label = "支店名／通帳記号")
    private String ifcSitennmtuutyoukigou;

    public String getIfcSitennmtuutyoukigou() {
        return ifcSitennmtuutyoukigou;
    }

    public void setIfcSitennmtuutyoukigou(String pIfcSitennmtuutyoukigou) {
        ifcSitennmtuutyoukigou = pIfcSitennmtuutyoukigou;
    }

    @Column(order = 11, label = "預金種別")
    private String ifcYokinkj;

    public String getIfcYokinkj() {
        return ifcYokinkj;
    }

    public void setIfcYokinkj(String pIfcYokinkj) {
        ifcYokinkj = pIfcYokinkj;
    }

    @Column(order = 12, label = "口座番号／通帳番号")
    private String ifcKouzanotuutyouno;

    public String getIfcKouzanotuutyouno() {
        return ifcKouzanotuutyouno;
    }

    public void setIfcKouzanotuutyouno(String pIfcKouzanotuutyouno) {
        ifcKouzanotuutyouno = pIfcKouzanotuutyouno;
    }

    @Column(order = 13, label = "口座名義人（カナ）")
    private String ifcKzmeiginmknkana;

    public String getIfcKzmeiginmknkana() {
        return ifcKzmeiginmknkana;
    }

    public void setIfcKzmeiginmknkana(String pIfcKzmeiginmknkana) {
        ifcKzmeiginmknkana = pIfcKzmeiginmknkana;
    }

    @Column(order = 14, label = "案内年月")
    private String ifcAnnaiym;

    public String getIfcAnnaiym() {
        return ifcAnnaiym;
    }

    public void setIfcAnnaiym(String pIfcAnnaiym) {
        ifcAnnaiym = pIfcAnnaiym;
    }

    @Column(order = 15, label = "換算基準日")
    private BizDate ifcKnsnkjymd;

    public BizDate getIfcKnsnkjymd() {
        return ifcKnsnkjymd;
    }

    public void setIfcKnsnkjymd(BizDate pIfcKnsnkjymd) {
        ifcKnsnkjymd = pIfcKnsnkjymd;
    }

    @Column(order = 16, label = "確定為替レート")
    private BizNumber ifcKktikawaserate;

    public BizNumber getIfcKktikawaserate() {
        return ifcKktikawaserate;
    }

    public void setIfcKktikawaserate(BizNumber pIfcKktikawaserate) {
        ifcKktikawaserate = pIfcKktikawaserate;
    }

    @Column(order = 17, label = "契約通貨種類")
    private String ifcKyktuukasyu;

    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }

    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }

    @Column(order = 18, label = "円換算保険料")
    private BizCurrency ifcEnknsnp;

    public BizCurrency getIfcEnknsnp() {
        return ifcEnknsnp;
    }

    public void setIfcEnknsnp(BizCurrency pIfcEnknsnp) {
        ifcEnknsnp = pIfcEnknsnp;
    }

    @Column(order = 19, label = "指定通貨保険料")
    private String ifcSiteituukap;

    public String getIfcSiteituukap() {
        return ifcSiteituukap;
    }

    public void setIfcSiteituukap(String pIfcSiteituukap) {
        ifcSiteituukap = pIfcSiteituukap;
    }

    @Column(order = 20, label = "作成日")
    private BizDate ifcSakuseiymd;

    public BizDate getIfcSakuseiymd() {
        return ifcSakuseiymd;
    }

    public void setIfcSakuseiymd(BizDate pIfcSakuseiymd) {
        ifcSakuseiymd = pIfcSakuseiymd;
    }

    @Column(order = 21, label = "募集時Ａ扱代理店名")
    private String ifcBosyuujiaatukaidrtenkj;

    public String getIfcBosyuujiaatukaidrtenkj() {
        return ifcBosyuujiaatukaidrtenkj;
    }

    public void setIfcBosyuujiaatukaidrtenkj(String pIfcBosyuujiaatukaidrtenkj) {
        ifcBosyuujiaatukaidrtenkj = pIfcBosyuujiaatukaidrtenkj;
    }

    @Column(order = 22, label = "愛称名")
    private String ifcAisyoumei;

    public String getIfcAisyoumei() {
        return ifcAisyoumei;
    }

    public void setIfcAisyoumei(String pIfcAisyoumei) {
        ifcAisyoumei = pIfcAisyoumei;
    }

    @Column(order = 23, label = "契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
