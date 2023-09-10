package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）支払備金集計表レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSiharaiBikinsyuukeiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiSiharaiBikinsyuukeiLayoutFile() {
    }


    @Column(order = 1, label = "処理年月日")
    private String ifcSyoriymdseireki;


    public String getIfcSyoriymdseireki() {
        return ifcSyoriymdseireki;
    }


    public void setIfcSyoriymdseireki(String pIfcSyoriymdseireki) {
        ifcSyoriymdseireki = pIfcSyoriymdseireki;
    }


    @Column(order = 2, label = "備金区分")
    private String ifcHknknsyruiname;


    public String getIfcHknknsyruiname() {
        return ifcHknknsyruiname;
    }


    public void setIfcHknknsyruiname(String pIfcHknknsyruiname) {
        ifcHknknsyruiname = pIfcHknknsyruiname;
    }


    @Column(order = 3, label = "備金コード")
    private String ifcBkncd;


    public String getIfcBkncd() {
        return ifcBkncd;
    }


    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }


    @Column(order = 4, label = "保険種類レベルコード")
    private String ifcHknsyruilevelcd;


    public String getIfcHknsyruilevelcd() {
        return ifcHknsyruilevelcd;
    }


    public void setIfcHknsyruilevelcd(String pIfcHknsyruilevelcd) {
        ifcHknsyruilevelcd = pIfcHknsyruilevelcd;
    }


    @Column(order = 5, label = "保険種類")
    private String ifcHknsyurui;


    public String getIfcHknsyurui() {
        return ifcHknsyurui;
    }


    public void setIfcHknsyurui(String pIfcHknsyurui) {
        ifcHknsyurui = pIfcHknsyurui;
    }


    @Column(order = 6, label = "新備件数")
    private String ifcSinbikensuu;


    public String getIfcSinbikensuu() {
        return ifcSinbikensuu;
    }


    public void setIfcSinbikensuu(String pIfcSinbikensuu) {
        ifcSinbikensuu = pIfcSinbikensuu;
    }


    @Column(order = 7, label = "新備金額")
    private String ifcSinbikingk;


    public String getIfcSinbikingk() {
        return ifcSinbikingk;
    }


    public void setIfcSinbikingk(String pIfcSinbikingk) {
        ifcSinbikingk = pIfcSinbikingk;
    }


    @Column(order = 8, label = "再備件数")
    private String ifcSaibikensuu;


    public String getIfcSaibikensuu() {
        return ifcSaibikensuu;
    }


    public void setIfcSaibikensuu(String pIfcSaibikensuu) {
        ifcSaibikensuu = pIfcSaibikensuu;
    }


    @Column(order = 9, label = "再備金額")
    private String ifcSaibikingk;


    public String getIfcSaibikingk() {
        return ifcSaibikingk;
    }


    public void setIfcSaibikingk(String pIfcSaibikingk) {
        ifcSaibikingk = pIfcSaibikingk;
    }


    @Column(order = 10, label = "再々備件数")
    private String ifcSaisaibikensuu;


    public String getIfcSaisaibikensuu() {
        return ifcSaisaibikensuu;
    }


    public void setIfcSaisaibikensuu(String pIfcSaisaibikensuu) {
        ifcSaisaibikensuu = pIfcSaisaibikensuu;
    }


    @Column(order = 11, label = "再々備金額")
    private String ifcSaisaibikingk;


    public String getIfcSaisaibikingk() {
        return ifcSaisaibikingk;
    }


    public void setIfcSaisaibikingk(String pIfcSaisaibikingk) {
        ifcSaisaibikingk = pIfcSaisaibikingk;
    }


    @Column(order = 12, label = "再々々備件数")
    private String ifcSaisaisaibikensuu;


    public String getIfcSaisaisaibikensuu() {
        return ifcSaisaisaibikensuu;
    }


    public void setIfcSaisaisaibikensuu(String pIfcSaisaisaibikensuu) {
        ifcSaisaisaibikensuu = pIfcSaisaisaibikensuu;
    }


    @Column(order = 13, label = "再々々備金額")
    private String ifcSaisaisaibikingk;


    public String getIfcSaisaisaibikingk() {
        return ifcSaisaisaibikingk;
    }


    public void setIfcSaisaisaibikingk(String pIfcSaisaisaibikingk) {
        ifcSaisaisaibikingk = pIfcSaisaisaibikingk;
    }


    @Column(order = 14, label = "合計件数")
    private String ifcGoukeikensuu;


    public String getIfcGoukeikensuu() {
        return ifcGoukeikensuu;
    }


    public void setIfcGoukeikensuu(String pIfcGoukeikensuu) {
        ifcGoukeikensuu = pIfcGoukeikensuu;
    }


    @Column(order = 15, label = "合計金額")
    private String ifcGoukeikingk;


    public String getIfcGoukeikingk() {
        return ifcGoukeikingk;
    }


    public void setIfcGoukeikingk(String pIfcGoukeikingk) {
        ifcGoukeikingk = pIfcGoukeikingk;
    }


    @Column(order = 16, label = "時効件数")
    private String ifcJikoukensuu;


    public String getIfcJikoukensuu() {
        return ifcJikoukensuu;
    }


    public void setIfcJikoukensuu(String pIfcJikoukensuu) {
        ifcJikoukensuu = pIfcJikoukensuu;
    }


    @Column(order = 17, label = "時効金額")
    private String ifcJikoukingk;


    public String getIfcJikoukingk() {
        return ifcJikoukingk;
    }


    public void setIfcJikoukingk(String pIfcJikoukingk) {
        ifcJikoukingk = pIfcJikoukingk;
    }


    @Column(order = 18, label = "予備０１")
    private String ifcYobisiharai;


    public String getIfcYobisiharai() {
        return ifcYobisiharai;
    }


    public void setIfcYobisiharai(String pIfcYobisiharai) {
        ifcYobisiharai = pIfcYobisiharai;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
