package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）予定利率連動ファイルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzYoteirirituRendouFileLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzYoteirirituRendouFileLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）予定利率連動ファイルデータ")
    private String ifcYoteiririturendoudata;

    public String getIfcYoteiririturendoudata() {
        return ifcYoteiririturendoudata;
    }

    public void setIfcYoteiririturendoudata(String pIfcYoteiririturendoudata) {
        ifcYoteiririturendoudata = pIfcYoteiririturendoudata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
