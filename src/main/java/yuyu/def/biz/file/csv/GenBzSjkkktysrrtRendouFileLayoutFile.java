package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）市場価格調整用利率連動ファイルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSjkkktysrrtRendouFileLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSjkkktysrrtRendouFileLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）市場価格調整用利率連動ファイルデータ")
    private String ifcSjkkktysrrtrendoudata;

    public String getIfcSjkkktysrrtrendoudata() {
        return ifcSjkkktysrrtrendoudata;
    }

    public void setIfcSjkkktysrrtrendoudata(String pIfcSjkkktysrrtrendoudata) {
        ifcSjkkktysrrtrendoudata = pIfcSjkkktysrrtrendoudata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
