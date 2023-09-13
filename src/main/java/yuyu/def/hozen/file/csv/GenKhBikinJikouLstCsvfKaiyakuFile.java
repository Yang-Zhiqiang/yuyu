package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）解約備金時効リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhBikinJikouLstCsvfKaiyakuFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhBikinJikouLstCsvfKaiyakuFile() {
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

    @Column(order = 4, label = "ページ番号")
    private String ifcPageno;

    public String getIfcPageno() {
        return ifcPageno;
    }

    public void setIfcPageno(String pIfcPageno) {
        ifcPageno = pIfcPageno;
    }

    @Column(order = 5, label = "保険種類")
    private String ifcHknsyurui;

    public String getIfcHknsyurui() {
        return ifcHknsyurui;
    }

    public void setIfcHknsyurui(String pIfcHknsyurui) {
        ifcHknsyurui = pIfcHknsyurui;
    }

    @Column(order = 6, label = "決算年度")
    private String ifcKessannnd;

    public String getIfcKessannnd() {
        return ifcKessannnd;
    }

    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }

    @Column(order = 7, label = "備金コード")
    private String ifcBkncd;

    public String getIfcBkncd() {
        return ifcBkncd;
    }

    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }

    @Column(order = 8, label = "支払表示")
    private String ifcShrhyj;

    public String getIfcShrhyj() {
        return ifcShrhyj;
    }

    public void setIfcShrhyj(String pIfcShrhyj) {
        ifcShrhyj = pIfcShrhyj;
    }

    @Column(order = 9, label = "備金確定年月日")
    private String ifcBknkktiymdwareki;

    public String getIfcBknkktiymdwareki() {
        return ifcBknkktiymdwareki;
    }

    public void setIfcBknkktiymdwareki(String pIfcBknkktiymdwareki) {
        ifcBknkktiymdwareki = pIfcBknkktiymdwareki;
    }

    @Column(order = 10, label = "計算基準年月日")
    private String ifcCalckijyunymdwareki;

    public String getIfcCalckijyunymdwareki() {
        return ifcCalckijyunymdwareki;
    }

    public void setIfcCalckijyunymdwareki(String pIfcCalckijyunymdwareki) {
        ifcCalckijyunymdwareki = pIfcCalckijyunymdwareki;
    }

    @Column(order = 11, label = "支社コード")
    private String ifcSisyacd;

    public String getIfcSisyacd() {
        return ifcSisyacd;
    }

    public void setIfcSisyacd(String pIfcSisyacd) {
        ifcSisyacd = pIfcSisyacd;
    }

    @Column(order = 12, label = "記号")
    private String ifcHknsyuruikigou;

    public String getIfcHknsyuruikigou() {
        return ifcHknsyuruikigou;
    }

    public void setIfcHknsyuruikigou(String pIfcHknsyuruikigou) {
        ifcHknsyuruikigou = pIfcHknsyuruikigou;
    }

    @Column(order = 13, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 14, label = "備金額")
    private String ifcBkngk;

    public String getIfcBkngk() {
        return ifcBkngk;
    }

    public void setIfcBkngk(String pIfcBkngk) {
        ifcBkngk = pIfcBkngk;
    }

    @Column(order = 15, label = "基本（保障）Ｓ")
    private String ifcKihons;

    public String getIfcKihons() {
        return ifcKihons;
    }

    public void setIfcKihons(String pIfcKihons) {
        ifcKihons = pIfcKihons;
    }

    @Column(order = 16, label = "特約Ｓ")
    private String ifcTks;

    public String getIfcTks() {
        return ifcTks;
    }

    public void setIfcTks(String pIfcTks) {
        ifcTks = pIfcTks;
    }

    @Column(order = 17, label = "特約記号")
    private String ifcTkkigou;

    public String getIfcTkkigou() {
        return ifcTkkigou;
    }

    public void setIfcTkkigou(String pIfcTkkigou) {
        ifcTkkigou = pIfcTkkigou;
    }

    @Column(order = 18, label = "型")
    private String ifcTkkata;

    public String getIfcTkkata() {
        return ifcTkkata;
    }

    public void setIfcTkkata(String pIfcTkkata) {
        ifcTkkata = pIfcTkkata;
    }

    @Column(order = 19, label = "妻子区分")
    private String ifcSaisikbn;

    public String getIfcSaisikbn() {
        return ifcSaisikbn;
    }

    public void setIfcSaisikbn(String pIfcSaisikbn) {
        ifcSaisikbn = pIfcSaisikbn;
    }

    @Column(order = 20, label = "診査表示")
    private String ifcSinsahyj;

    public String getIfcSinsahyj() {
        return ifcSinsahyj;
    }

    public void setIfcSinsahyj(String pIfcSinsahyj) {
        ifcSinsahyj = pIfcSinsahyj;
    }

    @Column(order = 21, label = "早期表示")
    private String ifcSoukihyj;

    public String getIfcSoukihyj() {
        return ifcSoukihyj;
    }

    public void setIfcSoukihyj(String pIfcSoukihyj) {
        ifcSoukihyj = pIfcSoukihyj;
    }

    @Column(order = 22, label = "削減表示")
    private String ifcSkgnhyj;

    public String getIfcSkgnhyj() {
        return ifcSkgnhyj;
    }

    public void setIfcSkgnhyj(String pIfcSkgnhyj) {
        ifcSkgnhyj = pIfcSkgnhyj;
    }

    @Column(order = 23, label = "転換表示")
    private String ifcTnknhyj;

    public String getIfcTnknhyj() {
        return ifcTnknhyj;
    }

    public void setIfcTnknhyj(String pIfcTnknhyj) {
        ifcTnknhyj = pIfcTnknhyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
