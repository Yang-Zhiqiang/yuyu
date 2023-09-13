package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）早期解約データファイル（レイアウト） データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSoukiKaiyakuDataLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSoukiKaiyakuDataLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）早期解約データ")
    private String ifcSoukikaiyakudata;

    public String getIfcSoukikaiyakudata() {
        return ifcSoukikaiyakudata;
    }

    public void setIfcSoukikaiyakudata(String pIfcSoukikaiyakudata) {
        ifcSoukikaiyakudata = pIfcSoukikaiyakudata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
