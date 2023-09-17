package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）資金移動リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSikinIdouListCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSikinIdouListCsvfFile() {
    }

    @Column(order = 1, label = "資金移動日")
    private String ifcSikinidouymd;

    public String getIfcSikinidouymd() {
        return ifcSikinidouymd;
    }

    public void setIfcSikinidouymd(String pIfcSikinidouymd) {
        ifcSikinidouymd = pIfcSikinidouymd;
    }

    @Column(order = 2, label = "資金移動リスト")
    private String ifcSikinidoulist;

    public String getIfcSikinidoulist() {
        return ifcSikinidoulist;
    }

    public void setIfcSikinidoulist(String pIfcSikinidoulist) {
        ifcSikinidoulist = pIfcSikinidoulist;
    }

    @Column(order = 3, label = "出金口座")
    private String ifcSyukkinkouza;

    public String getIfcSyukkinkouza() {
        return ifcSyukkinkouza;
    }

    public void setIfcSyukkinkouza(String pIfcSyukkinkouza) {
        ifcSyukkinkouza = pIfcSyukkinkouza;
    }

    @Column(order = 4, label = "入金口座")
    private String ifcNyuukinkouza;

    public String getIfcNyuukinkouza() {
        return ifcNyuukinkouza;
    }

    public void setIfcNyuukinkouza(String pIfcNyuukinkouza) {
        ifcNyuukinkouza = pIfcNyuukinkouza;
    }

    @Column(order = 5, label = "資金移動金額")
    private String ifcSikinidoumeisaigk;

    public String getIfcSikinidoumeisaigk() {
        return ifcSikinidoumeisaigk;
    }

    public void setIfcSikinidoumeisaigk(String pIfcSikinidoumeisaigk) {
        ifcSikinidoumeisaigk = pIfcSikinidoumeisaigk;
    }

    @Column(order = 6, label = "通貨")
    private String ifcTuukasyu;

    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }

    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
