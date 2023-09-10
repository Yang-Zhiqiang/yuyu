package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）不備未解消リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHubiMikaiListLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkHubiMikaiListLayoutFile() {
    }

    @Column(order = 1, label = "親代理店ｺｰﾄﾞ")
    private String ifcOyadrtencd;

    public String getIfcOyadrtencd() {
        return ifcOyadrtencd;
    }

    public void setIfcOyadrtencd(String pIfcOyadrtencd) {
        ifcOyadrtencd = pIfcOyadrtencd;
    }

    @Column(order = 2, label = "代理店")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 3, label = "打出機関名１")
    private String ifcUtidasikikannm1;

    public String getIfcUtidasikikannm1() {
        return ifcUtidasikikannm1;
    }

    public void setIfcUtidasikikannm1(String pIfcUtidasikikannm1) {
        ifcUtidasikikannm1 = pIfcUtidasikikannm1;
    }

    @Column(order = 4, label = "事務所ｺｰﾄﾞ(支店ｺｰﾄﾞ)")
    private String ifcJimusyocd;

    public String getIfcJimusyocd() {
        return ifcJimusyocd;
    }

    public void setIfcJimusyocd(String pIfcJimusyocd) {
        ifcJimusyocd = pIfcJimusyocd;
    }

    @Column(order = 5, label = "受付日")
    private String ifcMosnyuuryokuymd;

    public String getIfcMosnyuuryokuymd() {
        return ifcMosnyuuryokuymd;
    }

    public void setIfcMosnyuuryokuymd(String pIfcMosnyuuryokuymd) {
        ifcMosnyuuryokuymd = pIfcMosnyuuryokuymd;
    }

    @Column(order = 6, label = "申込番号")
    private String ifcMosno;

    public String getIfcMosno() {
        return ifcMosno;
    }

    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }

    @Column(order = 7, label = "保険種類名")
    private String ifcHknsyuruimei;

    public String getIfcHknsyuruimei() {
        return ifcHknsyuruimei;
    }

    public void setIfcHknsyuruimei(String pIfcHknsyuruimei) {
        ifcHknsyuruimei = pIfcHknsyuruimei;
    }

    @Column(order = 8, label = "漢字契約者名")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 9, label = "払込保険料")
    private String ifcSyokaiphrkgk;

    public String getIfcSyokaiphrkgk() {
        return ifcSyokaiphrkgk;
    }

    public void setIfcSyokaiphrkgk(String pIfcSyokaiphrkgk) {
        ifcSyokaiphrkgk = pIfcSyokaiphrkgk;
    }

    @Column(order = 10, label = "通貨種類")
    private String ifcHrktuukasyu;

    public String getIfcHrktuukasyu() {
        return ifcHrktuukasyu;
    }

    public void setIfcHrktuukasyu(String pIfcHrktuukasyu) {
        ifcHrktuukasyu = pIfcHrktuukasyu;
    }

    @Column(order = 11, label = "申込状態")
    private String ifcKetteikbn;

    public String getIfcKetteikbn() {
        return ifcKetteikbn;
    }

    public void setIfcKetteikbn(String pIfcKetteikbn) {
        ifcKetteikbn = pIfcKetteikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
