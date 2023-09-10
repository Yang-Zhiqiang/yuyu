package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）ＩＢＮＲ備金明細表レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiIBNRMeisaiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiIBNRMeisaiLayoutFile() {
    }


    @Column(order = 1, label = "種類名")
    private String ifcSyuruimei;


    public String getIfcSyuruimei() {
        return ifcSyuruimei;
    }


    public void setIfcSyuruimei(String pIfcSyuruimei) {
        ifcSyuruimei = pIfcSyuruimei;
    }


    @Column(order = 2, label = "支払種類名")
    private String ifcShrsyuruimei;


    public String getIfcShrsyuruimei() {
        return ifcShrsyuruimei;
    }


    public void setIfcShrsyuruimei(String pIfcShrsyuruimei) {
        ifcShrsyuruimei = pIfcShrsyuruimei;
    }


    @Column(order = 3, label = "契約通貨")
    private String ifcKyktuuka;


    public String getIfcKyktuuka() {
        return ifcKyktuuka;
    }


    public void setIfcKyktuuka(String pIfcKyktuuka) {
        ifcKyktuuka = pIfcKyktuuka;
    }


    @Column(order = 4, label = "発生年度")
    private String ifcHasseinendo;


    public String getIfcHasseinendo() {
        return ifcHasseinendo;
    }


    public void setIfcHasseinendo(String pIfcHasseinendo) {
        ifcHasseinendo = pIfcHasseinendo;
    }


    @Column(order = 5, label = "受付年度")
    private String ifcUketukenendo;


    public String getIfcUketukenendo() {
        return ifcUketukenendo;
    }


    public void setIfcUketukenendo(String pIfcUketukenendo) {
        ifcUketukenendo = pIfcUketukenendo;
    }


    @Column(order = 6, label = "金額（円貨）")
    private String ifcShrgk;


    public String getIfcShrgk() {
        return ifcShrgk;
    }


    public void setIfcShrgk(String pIfcShrgk) {
        ifcShrgk = pIfcShrgk;
    }


    @Column(order = 7, label = "金額（外貨）")
    private String ifcGaikashrgk;


    public String getIfcGaikashrgk() {
        return ifcGaikashrgk;
    }


    public void setIfcGaikashrgk(String pIfcGaikashrgk) {
        ifcGaikashrgk = pIfcGaikashrgk;
    }


    @Column(order = 8, label = "更新前支払表示")
    private String ifcKousinmaeshrhyouji;


    public String getIfcKousinmaeshrhyouji() {
        return ifcKousinmaeshrhyouji;
    }


    public void setIfcKousinmaeshrhyouji(String pIfcKousinmaeshrhyouji) {
        ifcKousinmaeshrhyouji = pIfcKousinmaeshrhyouji;
    }


    @Column(order = 9, label = "予備０１")
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
