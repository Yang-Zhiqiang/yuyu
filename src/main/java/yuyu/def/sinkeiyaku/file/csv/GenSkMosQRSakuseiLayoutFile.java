package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）外部用ＱＲデータレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMosQRSakuseiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkMosQRSakuseiLayoutFile() {
    }

    @Column(order = 1, label = "新契約事務区分")
    private String ifcSkeijimukbn;

    public String getIfcSkeijimukbn() {
        return ifcSkeijimukbn;
    }

    public void setIfcSkeijimukbn(String pIfcSkeijimukbn) {
        ifcSkeijimukbn = pIfcSkeijimukbn;
    }

    @Column(order = 2, label = "保険種類番号")
    private String ifcHknsyuruino;

    public String getIfcHknsyuruino() {
        return ifcHknsyuruino;
    }

    public void setIfcHknsyuruino(String pIfcHknsyuruino) {
        ifcHknsyuruino = pIfcHknsyuruino;
    }

    @Column(order = 3, label = "申込番号")
    private String ifcMosno;

    public String getIfcMosno() {
        return ifcMosno;
    }

    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }

    @Column(order = 4, label = "ＱＲ元データ１")
    private String ifcQrmotodata1;

    public String getIfcQrmotodata1() {
        return ifcQrmotodata1;
    }

    public void setIfcQrmotodata1(String pIfcQrmotodata1) {
        ifcQrmotodata1 = pIfcQrmotodata1;
    }

    @Column(order = 5, label = "ＱＲ元データ２")
    private String ifcQrmotodata2;

    public String getIfcQrmotodata2() {
        return ifcQrmotodata2;
    }

    public void setIfcQrmotodata2(String pIfcQrmotodata2) {
        ifcQrmotodata2 = pIfcQrmotodata2;
    }

    @Column(order = 6, label = "ＱＲ元データ３")
    private String ifcQrmotodata3;

    public String getIfcQrmotodata3() {
        return ifcQrmotodata3;
    }

    public void setIfcQrmotodata3(String pIfcQrmotodata3) {
        ifcQrmotodata3 = pIfcQrmotodata3;
    }

    @Column(order = 7, label = "ＱＲ元データ４")
    private String ifcQrmotodata4;

    public String getIfcQrmotodata4() {
        return ifcQrmotodata4;
    }

    public void setIfcQrmotodata4(String pIfcQrmotodata4) {
        ifcQrmotodata4 = pIfcQrmotodata4;
    }

    @Column(order = 8, label = "ＱＲ元データ５")
    private String ifcQrmotodata5;

    public String getIfcQrmotodata5() {
        return ifcQrmotodata5;
    }

    public void setIfcQrmotodata5(String pIfcQrmotodata5) {
        ifcQrmotodata5 = pIfcQrmotodata5;
    }

    @Column(order = 9, label = "ＱＲ元データ６")
    private String ifcQrmotodata6;

    public String getIfcQrmotodata6() {
        return ifcQrmotodata6;
    }

    public void setIfcQrmotodata6(String pIfcQrmotodata6) {
        ifcQrmotodata6 = pIfcQrmotodata6;
    }

    @Column(order = 10, label = "セット申込番号１")
    private String ifcSetmosno1;

    public String getIfcSetmosno1() {
        return ifcSetmosno1;
    }

    public void setIfcSetmosno1(String pIfcSetmosno1) {
        ifcSetmosno1 = pIfcSetmosno1;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
