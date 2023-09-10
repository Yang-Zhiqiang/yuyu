package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）時効対象リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiJikouTaisyouListLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiJikouTaisyouListLayoutFile() {
    }


    @Column(order = 1, label = "証券番号")
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 2, label = "備金確定年月日")
    private String ifcBknkktiymdseireki;


    public String getIfcBknkktiymdseireki() {
        return ifcBknkktiymdseireki;
    }


    public void setIfcBknkktiymdseireki(String pIfcBknkktiymdseireki) {
        ifcBknkktiymdseireki = pIfcBknkktiymdseireki;
    }


    @Column(order = 3, label = "保険種類")
    private String ifcHknsyurui;


    public String getIfcHknsyurui() {
        return ifcHknsyurui;
    }


    public void setIfcHknsyurui(String pIfcHknsyurui) {
        ifcHknsyurui = pIfcHknsyurui;
    }


    @Column(order = 4, label = "備金コード")
    private String ifcBkncd;


    public String getIfcBkncd() {
        return ifcBkncd;
    }


    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }


    @Column(order = 5, label = "給付種類")
    private String ifcKyhsyurui;


    public String getIfcKyhsyurui() {
        return ifcKyhsyurui;
    }


    public void setIfcKyhsyurui(String pIfcKyhsyurui) {
        ifcKyhsyurui = pIfcKyhsyurui;
    }


    @Column(order = 6, label = "備金区分")
    private String ifcHknknsyruiname;


    public String getIfcHknknsyruiname() {
        return ifcHknknsyruiname;
    }


    public void setIfcHknknsyruiname(String pIfcHknknsyruiname) {
        ifcHknknsyruiname = pIfcHknknsyruiname;
    }


    @Column(order = 7, label = "被保険者名カナ")
    private String ifcHhknsyanmkn;


    public String getIfcHhknsyanmkn() {
        return ifcHhknsyanmkn;
    }


    public void setIfcHhknsyanmkn(String pIfcHhknsyanmkn) {
        ifcHhknsyanmkn = pIfcHhknsyanmkn;
    }


    @Column(order = 8, label = "被保険者名漢字")
    private String ifcHhknnmkj;


    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }


    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }


    @Column(order = 9, label = "契約者名カナ")
    private String ifcKyknmkn;


    public String getIfcKyknmkn() {
        return ifcKyknmkn;
    }


    public void setIfcKyknmkn(String pIfcKyknmkn) {
        ifcKyknmkn = pIfcKyknmkn;
    }


    @Column(order = 10, label = "契約者名漢字")
    private String ifcKyknmkj;


    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }


    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
