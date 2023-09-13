package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）円建変更時返戻金備金リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhBikinSgyLstCsvfYendthnkHrFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhBikinSgyLstCsvfYendthnkHrFile() {
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
    private String ifcSakuseiymdwareki;

    public String getIfcSakuseiymdwareki() {
        return ifcSakuseiymdwareki;
    }

    public void setIfcSakuseiymdwareki(String pIfcSakuseiymdwareki) {
        ifcSakuseiymdwareki = pIfcSakuseiymdwareki;
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
    private String ifcBknkktiymdwareki;

    public String getIfcBknkktiymdwareki() {
        return ifcBknkktiymdwareki;
    }

    public void setIfcBknkktiymdwareki(String pIfcBknkktiymdwareki) {
        ifcBknkktiymdwareki = pIfcBknkktiymdwareki;
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
