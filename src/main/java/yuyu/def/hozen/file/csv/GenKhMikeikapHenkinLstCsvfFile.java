package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）未経過Ｐ返金リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMikeikapHenkinLstCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhMikeikapHenkinLstCsvfFile() {
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
    private String ifcSegcd;

    public String getIfcSegcd() {
        return ifcSegcd;
    }

    public void setIfcSegcd(String pIfcSegcd) {
        ifcSegcd = pIfcSegcd;
    }

    @Column(order = 8, label = "区分経理用保険種類レベル")
    private String ifcHknsyuruilevel;

    public String getIfcHknsyuruilevel() {
        return ifcHknsyuruilevel;
    }

    public void setIfcHknsyuruilevel(String pIfcHknsyuruilevel) {
        ifcHknsyuruilevel = pIfcHknsyuruilevel;
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

    @Column(order = 14, label = "ミス表示")
    private String ifcMissuhyj;

    public String getIfcMissuhyj() {
        return ifcMissuhyj;
    }

    public void setIfcMissuhyj(String pIfcMissuhyj) {
        ifcMissuhyj = pIfcMissuhyj;
    }

    @Column(order = 15, label = "円貨未経過保険料")
    private BizCurrency ifcYenkamikeikapbizc;

    public BizCurrency getIfcYenkamikeikapbizc() {
        return ifcYenkamikeikapbizc;
    }

    public void setIfcYenkamikeikapbizc(BizCurrency pIfcYenkamikeikapbizc) {
        ifcYenkamikeikapbizc = pIfcYenkamikeikapbizc;
    }

    @Column(order = 16, label = "外貨支払時為替レート基準日")
    private String ifcGaikashrkwsratekjnymd;

    public String getIfcGaikashrkwsratekjnymd() {
        return ifcGaikashrkwsratekjnymd;
    }

    public void setIfcGaikashrkwsratekjnymd(String pIfcGaikashrkwsratekjnymd) {
        ifcGaikashrkwsratekjnymd = pIfcGaikashrkwsratekjnymd;
    }

    @Column(order = 17, label = "外貨支払時為替レート")
    private BizNumber ifcGaikashrkwsrate;

    public BizNumber getIfcGaikashrkwsrate() {
        return ifcGaikashrkwsrate;
    }

    public void setIfcGaikashrkwsrate(BizNumber pIfcGaikashrkwsrate) {
        ifcGaikashrkwsrate = pIfcGaikashrkwsrate;
    }

    @Column(order = 18, label = "外貨未経過保険料")
    private String ifcGaikamikeikap;

    public String getIfcGaikamikeikap() {
        return ifcGaikamikeikap;
    }

    public void setIfcGaikamikeikap(String pIfcGaikamikeikap) {
        ifcGaikamikeikap = pIfcGaikamikeikap;
    }

    @Column(order = 19, label = "支払時為替レート基準日")
    private String ifcShrkwsratekjnymdseireki;

    public String getIfcShrkwsratekjnymdseireki() {
        return ifcShrkwsratekjnymdseireki;
    }

    public void setIfcShrkwsratekjnymdseireki(String pIfcShrkwsratekjnymdseireki) {
        ifcShrkwsratekjnymdseireki = pIfcShrkwsratekjnymdseireki;
    }

    @Column(order = 20, label = "支払時為替レート")
    private BizNumber ifcShrkwsrate;

    public BizNumber getIfcShrkwsrate() {
        return ifcShrkwsrate;
    }

    public void setIfcShrkwsrate(BizNumber pIfcShrkwsrate) {
        ifcShrkwsrate = pIfcShrkwsrate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
