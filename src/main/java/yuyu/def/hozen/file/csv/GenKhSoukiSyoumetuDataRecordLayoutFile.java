package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）早期消滅データ（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSoukiSyoumetuDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSoukiSyoumetuDataRecordLayoutFile() {
    }

    @Column(order = 1, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 2, label = "親代理店コード")
    private String ifcOyadrtencd;

    public String getIfcOyadrtencd() {
        return ifcOyadrtencd;
    }

    public void setIfcOyadrtencd(String pIfcOyadrtencd) {
        ifcOyadrtencd = pIfcOyadrtencd;
    }

    @Column(order = 3, label = "新契約募集時代理店コード")
    private String ifcSkeibsyknjdrtencd;

    public String getIfcSkeibsyknjdrtencd() {
        return ifcSkeibsyknjdrtencd;
    }

    public void setIfcSkeibsyknjdrtencd(String pIfcSkeibsyknjdrtencd) {
        ifcSkeibsyknjdrtencd = pIfcSkeibsyknjdrtencd;
    }

    @Column(order = 4, label = "代理店保有契約代理店コード")
    private String ifcDrtenhydrtencd;

    public String getIfcDrtenhydrtencd() {
        return ifcDrtenhydrtencd;
    }

    public void setIfcDrtenhydrtencd(String pIfcDrtenhydrtencd) {
        ifcDrtenhydrtencd = pIfcDrtenhydrtencd;
    }

    @Column(order = 5, label = "契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 6, label = "消滅日")
    private String ifcSyoumetuymd;

    public String getIfcSyoumetuymd() {
        return ifcSyoumetuymd;
    }

    public void setIfcSyoumetuymd(String pIfcSyoumetuymd) {
        ifcSyoumetuymd = pIfcSyoumetuymd;
    }

    @Column(order = 7, label = "募集代理店名")
    private String ifcBosyudrtennm;

    public String getIfcBosyudrtennm() {
        return ifcBosyudrtennm;
    }

    public void setIfcBosyudrtennm(String pIfcBosyudrtennm) {
        ifcBosyudrtennm = pIfcBosyudrtennm;
    }

    @Column(order = 8, label = "支店名")
    private String ifcSitennm;

    public String getIfcSitennm() {
        return ifcSitennm;
    }

    public void setIfcSitennm(String pIfcSitennm) {
        ifcSitennm = pIfcSitennm;
    }

    @Column(order = 9, label = "契約者名")
    private String ifcKyksyamei;

    public String getIfcKyksyamei() {
        return ifcKyksyamei;
    }

    public void setIfcKyksyamei(String pIfcKyksyamei) {
        ifcKyksyamei = pIfcKyksyamei;
    }

    @Column(order = 10, label = "商品名")
    private String ifcSyouhnnm;

    public String getIfcSyouhnnm() {
        return ifcSyouhnnm;
    }

    public void setIfcSyouhnnm(String pIfcSyouhnnm) {
        ifcSyouhnnm = pIfcSyouhnnm;
    }

    @Column(order = 11, label = "募集担当者氏名")
    private String ifcBosyuTntnm;

    public String getIfcBosyuTntnm() {
        return ifcBosyuTntnm;
    }

    public void setIfcBosyuTntnm(String pIfcBosyuTntnm) {
        ifcBosyuTntnm = pIfcBosyuTntnm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
