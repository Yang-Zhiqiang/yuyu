package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）交換契約リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKoukankeiyakuLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkKoukankeiyakuLayoutFile() {
    }

    @Column(order = 1, label = "代理店名")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 2, label = "代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 3, label = "募集担当者名")
    private String ifcBosyuutantounm;

    public String getIfcBosyuutantounm() {
        return ifcBosyuutantounm;
    }

    public void setIfcBosyuutantounm(String pIfcBosyuutantounm) {
        ifcBosyuutantounm = pIfcBosyuutantounm;
    }

    @Column(order = 4, label = "申込番号")
    private String ifcMosno;

    public String getIfcMosno() {
        return ifcMosno;
    }

    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }

    @Column(order = 5, label = "申込日")
    private String ifcMosymd;

    public String getIfcMosymd() {
        return ifcMosymd;
    }

    public void setIfcMosymd(String pIfcMosymd) {
        ifcMosymd = pIfcMosymd;
    }

    @Column(order = 6, label = "契約者名")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 7, label = "保険料")
    private String ifcHokenryou;

    public String getIfcHokenryou() {
        return ifcHokenryou;
    }

    public void setIfcHokenryou(String pIfcHokenryou) {
        ifcHokenryou = pIfcHokenryou;
    }

    @Column(order = 8, label = "勤務先名")
    private String ifcKinmusakinm;

    public String getIfcKinmusakinm() {
        return ifcKinmusakinm;
    }

    public void setIfcKinmusakinm(String pIfcKinmusakinm) {
        ifcKinmusakinm = pIfcKinmusakinm;
    }

    @Column(order = 9, label = "職務内容")
    private String ifcSyokumunaiyou;

    public String getIfcSyokumunaiyou() {
        return ifcSyokumunaiyou;
    }

    public void setIfcSyokumunaiyou(String pIfcSyokumunaiyou) {
        ifcSyokumunaiyou = pIfcSyokumunaiyou;
    }

    @Column(order = 10, label = "特記事項欄")
    private String ifcTokkijikou;

    public String getIfcTokkijikou() {
        return ifcTokkijikou;
    }

    public void setIfcTokkijikou(String pIfcTokkijikou) {
        ifcTokkijikou = pIfcTokkijikou;
    }

    @Column(order = 11, label = "払込回数")
    private String ifcHrkkaisuunaiyou;

    public String getIfcHrkkaisuunaiyou() {
        return ifcHrkkaisuunaiyou;
    }

    public void setIfcHrkkaisuunaiyou(String pIfcHrkkaisuunaiyou) {
        ifcHrkkaisuunaiyou = pIfcHrkkaisuunaiyou;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
