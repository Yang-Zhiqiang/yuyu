package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）前月一時払増額特約付契約Ｐ集計リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkItjbrzoutokkykpmonthlyLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkItjbrzoutokkykpmonthlyLayoutFile() {
    }

    @Column(order = 1, label = "インプット年月日")
    private String ifcInputymd;

    public String getIfcInputymd() {
        return ifcInputymd;
    }

    public void setIfcInputymd(String pIfcInputymd) {
        ifcInputymd = pIfcInputymd;
    }

    @Column(order = 2, label = "区分経理コード")
    private String ifcKeiricd;

    public String getIfcKeiricd() {
        return ifcKeiricd;
    }

    public void setIfcKeiricd(String pIfcKeiricd) {
        ifcKeiricd = pIfcKeiricd;
    }

    @Column(order = 3, label = "主契約小区分")
    private String ifcSyusyoukbn;

    public String getIfcSyusyoukbn() {
        return ifcSyusyoukbn;
    }

    public void setIfcSyusyoukbn(String pIfcSyusyoukbn) {
        ifcSyusyoukbn = pIfcSyusyoukbn;
    }

    @Column(order = 4, label = "通貨種類")
    private String ifcTuukasyu;

    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }

    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }

    @Column(order = 5, label = "為替レート")
    private String ifcKawaserate;

    public String getIfcKawaserate() {
        return ifcKawaserate;
    }

    public void setIfcKawaserate(String pIfcKawaserate) {
        ifcKawaserate = pIfcKawaserate;
    }

    @Column(order = 6, label = "初回Ｐ領収額")
    private String ifcPryosyugk;

    public String getIfcPryosyugk() {
        return ifcPryosyugk;
    }

    public void setIfcPryosyugk(String pIfcPryosyugk) {
        ifcPryosyugk = pIfcPryosyugk;
    }

    @Column(order = 7, label = "伝票金額（円）")
    private String ifcDengk;

    public String getIfcDengk() {
        return ifcDengk;
    }

    public void setIfcDengk(String pIfcDengk) {
        ifcDengk = pIfcDengk;
    }

    @Column(order = 8, label = "件数")
    private String ifcKensuu;

    public String getIfcKensuu() {
        return ifcKensuu;
    }

    public void setIfcKensuu(String pIfcKensuu) {
        ifcKensuu = pIfcKensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
