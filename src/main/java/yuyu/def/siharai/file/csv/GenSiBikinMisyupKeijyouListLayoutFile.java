package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）備金未収Ｐ計上レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiBikinMisyupKeijyouListLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiBikinMisyupKeijyouListLayoutFile() {
    }


    @Column(order = 1, label = "リスト名")
    private String ifcListnm;


    public String getIfcListnm() {
        return ifcListnm;
    }


    public void setIfcListnm(String pIfcListnm) {
        ifcListnm = pIfcListnm;
    }


    @Column(order = 2, label = "宛先")
    private String ifcAtesaki;


    public String getIfcAtesaki() {
        return ifcAtesaki;
    }


    public void setIfcAtesaki(String pIfcAtesaki) {
        ifcAtesaki = pIfcAtesaki;
    }


    @Column(order = 3, label = "作成年月日")
    private String ifcSakuseiymdseireki;


    public String getIfcSakuseiymdseireki() {
        return ifcSakuseiymdseireki;
    }


    public void setIfcSakuseiymdseireki(String pIfcSakuseiymdseireki) {
        ifcSakuseiymdseireki = pIfcSakuseiymdseireki;
    }


    @Column(order = 4, label = "ページ番号")
    private String ifcPageno;


    public String getIfcPageno() {
        return ifcPageno;
    }


    public void setIfcPageno(String pIfcPageno) {
        ifcPageno = pIfcPageno;
    }


    @Column(order = 5, label = "区分経理コード")
    private String ifcKbnkeirisegcd;


    public String getIfcKbnkeirisegcd() {
        return ifcKbnkeirisegcd;
    }


    public void setIfcKbnkeirisegcd(String pIfcKbnkeirisegcd) {
        ifcKbnkeirisegcd = pIfcKbnkeirisegcd;
    }


    @Column(order = 6, label = "区分経理用保険種類レベル")
    private String ifcHknsyruilevelcd;


    public String getIfcHknsyruilevelcd() {
        return ifcHknsyruilevelcd;
    }


    public void setIfcHknsyruilevelcd(String pIfcHknsyruilevelcd) {
        ifcHknsyruilevelcd = pIfcHknsyruilevelcd;
    }


    @Column(order = 7, label = "備金年度")
    private String ifcBknkktinnd;


    public String getIfcBknkktinnd() {
        return ifcBknkktinnd;
    }


    public void setIfcBknkktinnd(String pIfcBknkktinnd) {
        ifcBknkktinnd = pIfcBknkktinnd;
    }


    @Column(order = 8, label = "備金確定年月")
    private String ifcBknkktiym;


    public String getIfcBknkktiym() {
        return ifcBknkktiym;
    }


    public void setIfcBknkktiym(String pIfcBknkktiym) {
        ifcBknkktiym = pIfcBknkktiym;
    }


    @Column(order = 9, label = "決算年度")
    private String ifcKessannnd;


    public String getIfcKessannnd() {
        return ifcKessannnd;
    }


    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }


    @Column(order = 10, label = "備金コード")
    private String ifcBkncd;


    public String getIfcBkncd() {
        return ifcBkncd;
    }


    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }


    @Column(order = 11, label = "備金確定年月日")
    private String ifcBknkktiymdseireki;


    public String getIfcBknkktiymdseireki() {
        return ifcBknkktiymdseireki;
    }


    public void setIfcBknkktiymdseireki(String pIfcBknkktiymdseireki) {
        ifcBknkktiymdseireki = pIfcBknkktiymdseireki;
    }


    @Column(order = 12, label = "計算基準年月日")
    private String ifcCalckijyunymdseireki;


    public String getIfcCalckijyunymdseireki() {
        return ifcCalckijyunymdseireki;
    }


    public void setIfcCalckijyunymdseireki(String pIfcCalckijyunymdseireki) {
        ifcCalckijyunymdseireki = pIfcCalckijyunymdseireki;
    }


    @Column(order = 13, label = "証券番号")
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 14, label = "契約年月日")
    private String ifcKeiyakuymd;


    public String getIfcKeiyakuymd() {
        return ifcKeiyakuymd;
    }


    public void setIfcKeiyakuymd(String pIfcKeiyakuymd) {
        ifcKeiyakuymd = pIfcKeiyakuymd;
    }


    @Column(order = 15, label = "次回Ｐ充当年月")
    private String ifcMisyuupjyuutouym;


    public String getIfcMisyuupjyuutouym() {
        return ifcMisyuupjyuutouym;
    }


    public void setIfcMisyuupjyuutouym(String pIfcMisyuupjyuutouym) {
        ifcMisyuupjyuutouym = pIfcMisyuupjyuutouym;
    }


    @Column(order = 16, label = "表定Ｐ")
    private String ifcHrkp;


    public String getIfcHrkp() {
        return ifcHrkp;
    }


    public void setIfcHrkp(String pIfcHrkp) {
        ifcHrkp = pIfcHrkp;
    }


    @Column(order = 17, label = "未収Ｐ")
    private String ifcMisyuup;


    public String getIfcMisyuup() {
        return ifcMisyuup;
    }


    public void setIfcMisyuup(String pIfcMisyuup) {
        ifcMisyuup = pIfcMisyuup;
    }


    @Column(order = 18, label = "書類受付年月日")
    private String ifcSyoruiukeymdseireki;


    public String getIfcSyoruiukeymdseireki() {
        return ifcSyoruiukeymdseireki;
    }


    public void setIfcSyoruiukeymdseireki(String pIfcSyoruiukeymdseireki) {
        ifcSyoruiukeymdseireki = pIfcSyoruiukeymdseireki;
    }


    @Column(order = 19, label = "外貨受取表示")
    private String ifcGaikaukthyoji;


    public String getIfcGaikaukthyoji() {
        return ifcGaikaukthyoji;
    }


    public void setIfcGaikaukthyoji(String pIfcGaikaukthyoji) {
        ifcGaikaukthyoji = pIfcGaikaukthyoji;
    }


    @Column(order = 20, label = "換算基準年月日")
    private String ifcKnsnkijyunymd;


    public String getIfcKnsnkijyunymd() {
        return ifcKnsnkijyunymd;
    }


    public void setIfcKnsnkijyunymd(String pIfcKnsnkijyunymd) {
        ifcKnsnkijyunymd = pIfcKnsnkijyunymd;
    }


    @Column(order = 21, label = "円換算レート")
    private String ifcKawaserate;


    public String getIfcKawaserate() {
        return ifcKawaserate;
    }


    public void setIfcKawaserate(String pIfcKawaserate) {
        ifcKawaserate = pIfcKawaserate;
    }


    @Column(order = 22, label = "契約通貨建未収Ｐ")
    private String ifcKyktuukamisyuup;


    public String getIfcKyktuukamisyuup() {
        return ifcKyktuukamisyuup;
    }


    public void setIfcKyktuukamisyuup(String pIfcKyktuukamisyuup) {
        ifcKyktuukamisyuup = pIfcKyktuukamisyuup;
    }


    @Column(order = 23, label = "契約通貨種類")
    private String ifcKyktuuka;


    public String getIfcKyktuuka() {
        return ifcKyktuuka;
    }


    public void setIfcKyktuuka(String pIfcKyktuuka) {
        ifcKyktuuka = pIfcKyktuuka;
    }


    @Column(order = 24, label = "払込方法")
    private String ifcHrkkaisuunaiyou;


    public String getIfcHrkkaisuunaiyou() {
        return ifcHrkkaisuunaiyou;
    }


    public void setIfcHrkkaisuunaiyou(String pIfcHrkkaisuunaiyou) {
        ifcHrkkaisuunaiyou = pIfcHrkkaisuunaiyou;
    }


    @Column(order = 25, label = "初年度次回以降Ｐ")
    private String ifcSyonendojikaiikoup;


    public String getIfcSyonendojikaiikoup() {
        return ifcSyonendojikaiikoup;
    }


    public void setIfcSyonendojikaiikoup(String pIfcSyonendojikaiikoup) {
        ifcSyonendojikaiikoup = pIfcSyonendojikaiikoup;
    }


    @Column(order = 26, label = "次年度以降Ｐ")
    private String ifcJinendoikoup;


    public String getIfcJinendoikoup() {
        return ifcJinendoikoup;
    }


    public void setIfcJinendoikoup(String pIfcJinendoikoup) {
        ifcJinendoikoup = pIfcJinendoikoup;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
