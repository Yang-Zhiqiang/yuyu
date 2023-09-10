package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）死亡原因未反映リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkSibougeninmihaneilistLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkSibougeninmihaneilistLayoutFile() {
    }

    @Column(order = 1, label = "異動処理日")
    private String ifcIdousyoriymd;

    public String getIfcIdousyoriymd() {
        return ifcIdousyoriymd;
    }

    public void setIfcIdousyoriymd(String pIfcIdousyoriymd) {
        ifcIdousyoriymd = pIfcIdousyoriymd;
    }

    @Column(order = 2, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 3, label = "消滅日")
    private String ifcSyoumetuymd;

    public String getIfcSyoumetuymd() {
        return ifcSyoumetuymd;
    }

    public void setIfcSyoumetuymd(String pIfcSyoumetuymd) {
        ifcSyoumetuymd = pIfcSyoumetuymd;
    }

    @Column(order = 4, label = "消滅原因コード")
    private String ifcSymtgenincd;

    public String getIfcSymtgenincd() {
        return ifcSymtgenincd;
    }

    public void setIfcSymtgenincd(String pIfcSymtgenincd) {
        ifcSymtgenincd = pIfcSymtgenincd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
