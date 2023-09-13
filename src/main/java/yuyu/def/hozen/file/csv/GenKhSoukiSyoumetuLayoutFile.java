package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）早期消滅データレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSoukiSyoumetuLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSoukiSyoumetuLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）早期消滅データ")
    private String ifcSoukisyoumetudata;

    public String getIfcSoukisyoumetudata() {
        return ifcSoukisyoumetudata;
    }

    public void setIfcSoukisyoumetudata(String pIfcSoukisyoumetudata) {
        ifcSoukisyoumetudata = pIfcSoukisyoumetudata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
