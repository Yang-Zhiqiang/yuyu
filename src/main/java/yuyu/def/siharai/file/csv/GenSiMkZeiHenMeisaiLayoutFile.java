package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）税務及び返戻金備金明細表レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiMkZeiHenMeisaiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiMkZeiHenMeisaiLayoutFile() {
    }


    @Column(order = 1, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 2, label = "セグメントレベル区分")
    private String ifcSeglevelkbn;


    public String getIfcSeglevelkbn() {
        return ifcSeglevelkbn;
    }


    public void setIfcSeglevelkbn(String pIfcSeglevelkbn) {
        ifcSeglevelkbn = pIfcSeglevelkbn;
    }


    @Column(order = 3, label = "保険種類レベル区分")
    private String ifcHknsyruilevelkbn;


    public String getIfcHknsyruilevelkbn() {
        return ifcHknsyruilevelkbn;
    }


    public void setIfcHknsyruilevelkbn(String pIfcHknsyruilevelkbn) {
        ifcHknsyruilevelkbn = pIfcHknsyruilevelkbn;
    }


    @Column(order = 4, label = "備金確定年月日")
    private BizDate ifcBknkktiymd;


    public BizDate getIfcBknkktiymd() {
        return ifcBknkktiymd;
    }


    public void setIfcBknkktiymd(BizDate pIfcBknkktiymd) {
        ifcBknkktiymd = pIfcBknkktiymd;
    }


    @Column(order = 5, label = "備金コード")
    private String ifcBkncd;


    public String getIfcBkncd() {
        return ifcBkncd;
    }


    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }


    @Column(order = 6, label = "備金計上額")
    private String ifcBikinkeigaku;


    public String getIfcBikinkeigaku() {
        return ifcBikinkeigaku;
    }


    public void setIfcBikinkeigaku(String pIfcBikinkeigaku) {
        ifcBikinkeigaku = pIfcBikinkeigaku;
    }


    @Column(order = 7, label = "買増Ｓ")
    private String ifcKaimasis;


    public String getIfcKaimasis() {
        return ifcKaimasis;
    }


    public void setIfcKaimasis(String pIfcKaimasis) {
        ifcKaimasis = pIfcKaimasis;
    }


    @Column(order = 8, label = "年金備金表示")
    private String ifcNkbikinhyj;


    public String getIfcNkbikinhyj() {
        return ifcNkbikinhyj;
    }


    public void setIfcNkbikinhyj(String pIfcNkbikinhyj) {
        ifcNkbikinhyj = pIfcNkbikinhyj;
    }


    @Column(order = 9, label = "税務否認対象確認要表示")
    private String ifcZeimuhininkakyouhyj;


    public String getIfcZeimuhininkakyouhyj() {
        return ifcZeimuhininkakyouhyj;
    }


    public void setIfcZeimuhininkakyouhyj(String pIfcZeimuhininkakyouhyj) {
        ifcZeimuhininkakyouhyj = pIfcZeimuhininkakyouhyj;
    }


    @Column(order = 10, label = "予備０１")
    private String ifcYobisiharai;


    public String getIfcYobisiharai() {
        return ifcYobisiharai;
    }


    public void setIfcYobisiharai(String pIfcYobisiharai) {
        ifcYobisiharai = pIfcYobisiharai;
    }


    @Column(order = 11, label = "契約通貨種類")
    private String ifcKyktuukasyu;


    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }


    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
