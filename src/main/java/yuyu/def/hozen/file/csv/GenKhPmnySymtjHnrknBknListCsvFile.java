package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * （保全）Ｐ未入消滅時返戻金備金リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhPmnySymtjHnrknBknListCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhPmnySymtjHnrknBknListCsvFile() {
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

    @Column(order = 4, label = "頁番号")
    private String ifcPageno;

    public String getIfcPageno() {
        return ifcPageno;
    }

    public void setIfcPageno(String pIfcPageno) {
        ifcPageno = pIfcPageno;
    }

    @Column(order = 5, label = "決算年度")
    private String ifcKessannnd;

    public String getIfcKessannnd() {
        return ifcKessannnd;
    }

    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }

    @Column(order = 6, label = "保険種類名称")
    private String ifcHknsyuruinm;

    public String getIfcHknsyuruinm() {
        return ifcHknsyuruinm;
    }

    public void setIfcHknsyuruinm(String pIfcHknsyuruinm) {
        ifcHknsyuruinm = pIfcHknsyuruinm;
    }

    @Column(order = 7, label = "備金コード")
    private String ifcBkncd;

    public String getIfcBkncd() {
        return ifcBkncd;
    }

    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }

    @Column(order = 8, label = "備金確定年月日")
    private String ifcBknkktiymdseireki;

    public String getIfcBknkktiymdseireki() {
        return ifcBknkktiymdseireki;
    }

    public void setIfcBknkktiymdseireki(String pIfcBknkktiymdseireki) {
        ifcBknkktiymdseireki = pIfcBknkktiymdseireki;
    }

    @Column(order = 9, label = "受付支社")
    private String ifcUktksisya;

    public String getIfcUktksisya() {
        return ifcUktksisya;
    }

    public void setIfcUktksisya(String pIfcUktksisya) {
        ifcUktksisya = pIfcUktksisya;
    }

    @Column(order = 10, label = "記号")
    private String ifcHknsyuruikigou;

    public String getIfcHknsyuruikigou() {
        return ifcHknsyuruikigou;
    }

    public void setIfcHknsyuruikigou(String pIfcHknsyuruikigou) {
        ifcHknsyuruikigou = pIfcHknsyuruikigou;
    }

    @Column(order = 11, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 12, label = "備金額")
    private String ifcBkngk;

    public String getIfcBkngk() {
        return ifcBkngk;
    }

    public void setIfcBkngk(String pIfcBkngk) {
        ifcBkngk = pIfcBkngk;
    }

    @Column(order = 13, label = "区分経理用セグメントコード")
    private String ifcKbnkeirisegcd;

    public String getIfcKbnkeirisegcd() {
        return ifcKbnkeirisegcd;
    }

    public void setIfcKbnkeirisegcd(String pIfcKbnkeirisegcd) {
        ifcKbnkeirisegcd = pIfcKbnkeirisegcd;
    }

    @Column(order = 14, label = "処理有無区分")
    private String ifcSyoriumukbn;

    public String getIfcSyoriumukbn() {
        return ifcSyoriumukbn;
    }

    public void setIfcSyoriumukbn(String pIfcSyoriumukbn) {
        ifcSyoriumukbn = pIfcSyoriumukbn;
    }

    @Column(order = 15, label = "備金時効区分")
    private C_BknJkuKbn ifcBknjkukbn;

    public C_BknJkuKbn getIfcBknjkukbn() {
        return ifcBknjkukbn;
    }

    public void setIfcBknjkukbn(C_BknJkuKbn pIfcBknjkukbn) {
        ifcBknjkukbn = pIfcBknjkukbn;
    }

    @Column(order = 16, label = "解約返戻金（外貨）")
    private String ifcKaiyakuhrkngaika;

    public String getIfcKaiyakuhrkngaika() {
        return ifcKaiyakuhrkngaika;
    }

    public void setIfcKaiyakuhrkngaika(String pIfcKaiyakuhrkngaika) {
        ifcKaiyakuhrkngaika = pIfcKaiyakuhrkngaika;
    }

    @Column(order = 17, label = "契約通貨種類")
    private String ifcKyktuukasyu;

    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }

    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }

    @Column(order = 18, label = "支払通貨種類")
    private C_Tuukasyu ifcShrtuukasyu;

    public C_Tuukasyu getIfcShrtuukasyu() {
        return ifcShrtuukasyu;
    }

    public void setIfcShrtuukasyu(C_Tuukasyu pIfcShrtuukasyu) {
        ifcShrtuukasyu = pIfcShrtuukasyu;
    }

    @Column(order = 19, label = "為替レート基準日")
    private String ifcKwsratekjymd;

    public String getIfcKwsratekjymd() {
        return ifcKwsratekjymd;
    }

    public void setIfcKwsratekjymd(String pIfcKwsratekjymd) {
        ifcKwsratekjymd = pIfcKwsratekjymd;
    }

    @Column(order = 20, label = "為替レート")
    private String ifcKawaserate;

    public String getIfcKawaserate() {
        return ifcKawaserate;
    }

    public void setIfcKawaserate(String pIfcKawaserate) {
        ifcKawaserate = pIfcKawaserate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
