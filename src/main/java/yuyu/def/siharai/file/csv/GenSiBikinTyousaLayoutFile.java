package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）支払保険金備金調査Ｆレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiBikinTyousaLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiBikinTyousaLayoutFile() {
    }


    @Column(order = 1, label = "処理区分")
    private String ifcSyorikbn;


    public String getIfcSyorikbn() {
        return ifcSyorikbn;
    }


    public void setIfcSyorikbn(String pIfcSyorikbn) {
        ifcSyorikbn = pIfcSyorikbn;
    }


    @Column(order = 2, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 3, label = "保険金支払年月日")
    private BizDate ifcSishrymd;


    public BizDate getIfcSishrymd() {
        return ifcSishrymd;
    }


    public void setIfcSishrymd(BizDate pIfcSishrymd) {
        ifcSishrymd = pIfcSishrymd;
    }


    @Column(order = 4, label = "事故発生年月日")
    private BizDate ifcJikohasseiymd;


    public BizDate getIfcJikohasseiymd() {
        return ifcJikohasseiymd;
    }


    public void setIfcJikohasseiymd(BizDate pIfcJikohasseiymd) {
        ifcJikohasseiymd = pIfcJikohasseiymd;
    }


    @Column(order = 5, label = "会社了知年月日")
    private BizDate ifcKaisyaryoutiymd;


    public BizDate getIfcKaisyaryoutiymd() {
        return ifcKaisyaryoutiymd;
    }


    public void setIfcKaisyaryoutiymd(BizDate pIfcKaisyaryoutiymd) {
        ifcKaisyaryoutiymd = pIfcKaisyaryoutiymd;
    }


    @Column(order = 6, label = "保険金額")
    private String ifcHkgk;


    public String getIfcHkgk() {
        return ifcHkgk;
    }


    public void setIfcHkgk(String pIfcHkgk) {
        ifcHkgk = pIfcHkgk;
    }


    @Column(order = 7, label = "備金計上額")
    private String ifcBikinkeigaku;


    public String getIfcBikinkeigaku() {
        return ifcBikinkeigaku;
    }


    public void setIfcBikinkeigaku(String pIfcBikinkeigaku) {
        ifcBikinkeigaku = pIfcBikinkeigaku;
    }


    @Column(order = 8, label = "保険金額－備金計上額")
    private String ifcHkgkbkngk;


    public String getIfcHkgkbkngk() {
        return ifcHkgkbkngk;
    }


    public void setIfcHkgkbkngk(String pIfcHkgkbkngk) {
        ifcHkgkbkngk = pIfcHkgkbkngk;
    }


    @Column(order = 9, label = "年金請求区分")
    private String ifcNkseikyuukbn;


    public String getIfcNkseikyuukbn() {
        return ifcNkseikyuukbn;
    }


    public void setIfcNkseikyuukbn(String pIfcNkseikyuukbn) {
        ifcNkseikyuukbn = pIfcNkseikyuukbn;
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


    @Column(order = 12, label = "為替レート相違有無区分")
    private String ifcKawaseratesouikbn;


    public String getIfcKawaseratesouikbn() {
        return ifcKawaseratesouikbn;
    }


    public void setIfcKawaseratesouikbn(String pIfcKawaseratesouikbn) {
        ifcKawaseratesouikbn = pIfcKawaseratesouikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
