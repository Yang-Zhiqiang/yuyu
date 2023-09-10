package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）訂正項目リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkTskmlistLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkTskmlistLayoutFile() {
    }

    @Column(order = 1, label = "処理日時")
    private String ifcSyoritime;

    public String getIfcSyoritime() {
        return ifcSyoritime;
    }

    public void setIfcSyoritime(String pIfcSyoritime) {
        ifcSyoritime = pIfcSyoritime;
    }

    @Column(order = 2, label = "申込番号")
    private String ifcMosno;

    public String getIfcMosno() {
        return ifcMosno;
    }

    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }

    @Column(order = 3, label = "処理名")
    private String ifcSyorinm;

    public String getIfcSyorinm() {
        return ifcSyorinm;
    }

    public void setIfcSyorinm(String pIfcSyorinm) {
        ifcSyorinm = pIfcSyorinm;
    }

    @Column(order = 4, label = "訂正項目名")
    private String ifcTskmnm;

    public String getIfcTskmnm() {
        return ifcTskmnm;
    }

    public void setIfcTskmnm(String pIfcTskmnm) {
        ifcTskmnm = pIfcTskmnm;
    }

    @Column(order = 5, label = "訂正前内容")
    private String ifcTsmaenaiyou;

    public String getIfcTsmaenaiyou() {
        return ifcTsmaenaiyou;
    }

    public void setIfcTsmaenaiyou(String pIfcTsmaenaiyou) {
        ifcTsmaenaiyou = pIfcTsmaenaiyou;
    }

    @Column(order = 6, label = "訂正後内容")
    private String ifcTsgonaiyou;

    public String getIfcTsgonaiyou() {
        return ifcTsgonaiyou;
    }

    public void setIfcTsgonaiyou(String pIfcTsgonaiyou) {
        ifcTsgonaiyou = pIfcTsgonaiyou;
    }

    @Column(order = 7, label = "担当者名")
    private String ifcTntnm;

    public String getIfcTntnm() {
        return ifcTntnm;
    }

    public void setIfcTntnm(String pIfcTntnm) {
        ifcTntnm = pIfcTntnm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
