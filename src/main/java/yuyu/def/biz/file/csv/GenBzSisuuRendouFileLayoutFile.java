package yuyu.def.biz.file.csv;

import java.io.Serializable;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）指数連動ファイルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSisuuRendouFileLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSisuuRendouFileLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）指数連動ファイルデータ")
    private String ifcSisuurendoudata;

    public String getIfcSisuurendoudata() {
        return ifcSisuurendoudata;
    }

    public void setIfcSisuurendoudata(String pIfcSisuurendoudata) {
        ifcSisuurendoudata = pIfcSisuurendoudata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
