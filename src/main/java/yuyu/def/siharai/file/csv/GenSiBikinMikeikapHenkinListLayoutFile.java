package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）備金未経過Ｐ返金レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiBikinMikeikapHenkinListLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiBikinMikeikapHenkinListLayoutFile() {
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


    @Column(order = 5, label = "決算年度")
    private String ifcKessannnd;


    public String getIfcKessannnd() {
        return ifcKessannnd;
    }


    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }


    @Column(order = 6, label = "処理コード")
    private String ifcSyoricd;


    public String getIfcSyoricd() {
        return ifcSyoricd;
    }


    public void setIfcSyoricd(String pIfcSyoricd) {
        ifcSyoricd = pIfcSyoricd;
    }


    @Column(order = 7, label = "セグメントコード")
    private String ifcKbnkeirisegcd;


    public String getIfcKbnkeirisegcd() {
        return ifcKbnkeirisegcd;
    }


    public void setIfcKbnkeirisegcd(String pIfcKbnkeirisegcd) {
        ifcKbnkeirisegcd = pIfcKbnkeirisegcd;
    }


    @Column(order = 8, label = "区分経理用保険種類レベル")
    private String ifcHknsyruilevelcd;


    public String getIfcHknsyruilevelcd() {
        return ifcHknsyruilevelcd;
    }


    public void setIfcHknsyruilevelcd(String pIfcHknsyruilevelcd) {
        ifcHknsyruilevelcd = pIfcHknsyruilevelcd;
    }


    @Column(order = 9, label = "未経過Ｐ確定年月日")
    private String ifcMikeikapkktiymd;


    public String getIfcMikeikapkktiymd() {
        return ifcMikeikapkktiymd;
    }


    public void setIfcMikeikapkktiymd(String pIfcMikeikapkktiymd) {
        ifcMikeikapkktiymd = pIfcMikeikapkktiymd;
    }


    @Column(order = 10, label = "未経過Ｐ確定年度")
    private String ifcMikeikapkktinnd;


    public String getIfcMikeikapkktinnd() {
        return ifcMikeikapkktinnd;
    }


    public void setIfcMikeikapkktinnd(String pIfcMikeikapkktinnd) {
        ifcMikeikapkktinnd = pIfcMikeikapkktinnd;
    }


    @Column(order = 11, label = "未経過Ｐ確定年月")
    private String ifcMikeikapkktiym;


    public String getIfcMikeikapkktiym() {
        return ifcMikeikapkktiym;
    }


    public void setIfcMikeikapkktiym(String pIfcMikeikapkktiym) {
        ifcMikeikapkktiym = pIfcMikeikapkktiym;
    }


    @Column(order = 12, label = "証券番号")
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 13, label = "未経過保険料")
    private String ifcMikeikap;


    public String getIfcMikeikap() {
        return ifcMikeikap;
    }


    public void setIfcMikeikap(String pIfcMikeikap) {
        ifcMikeikap = pIfcMikeikap;
    }


    @Column(order = 14, label = "書類受付年月日")
    private String ifcSyoruiukeymdseireki;


    public String getIfcSyoruiukeymdseireki() {
        return ifcSyoruiukeymdseireki;
    }


    public void setIfcSyoruiukeymdseireki(String pIfcSyoruiukeymdseireki) {
        ifcSyoruiukeymdseireki = pIfcSyoruiukeymdseireki;
    }


    @Column(order = 15, label = "外貨受取表示")
    private String ifcGaikaukthyoji;


    public String getIfcGaikaukthyoji() {
        return ifcGaikaukthyoji;
    }


    public void setIfcGaikaukthyoji(String pIfcGaikaukthyoji) {
        ifcGaikaukthyoji = pIfcGaikaukthyoji;
    }


    @Column(order = 16, label = "外貨建未経過Ｐ")
    private String ifcGkdtmikeikap;


    public String getIfcGkdtmikeikap() {
        return ifcGkdtmikeikap;
    }


    public void setIfcGkdtmikeikap(String pIfcGkdtmikeikap) {
        ifcGkdtmikeikap = pIfcGkdtmikeikap;
    }


    @Column(order = 17, label = "円換算レート")
    private String ifcKawaserate;


    public String getIfcKawaserate() {
        return ifcKawaserate;
    }


    public void setIfcKawaserate(String pIfcKawaserate) {
        ifcKawaserate = pIfcKawaserate;
    }


    @Column(order = 18, label = "ミス表示")
    private String ifcMissuhyj;


    public String getIfcMissuhyj() {
        return ifcMissuhyj;
    }


    public void setIfcMissuhyj(String pIfcMissuhyj) {
        ifcMissuhyj = pIfcMissuhyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
