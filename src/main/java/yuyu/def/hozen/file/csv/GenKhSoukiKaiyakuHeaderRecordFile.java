package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）早期解約データファイル（ヘッダーレコード） データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSoukiKaiyakuHeaderRecordFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSoukiKaiyakuHeaderRecordFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）タイトル")
    private String ifcTitle;

    public String getIfcTitle() {
        return ifcTitle;
    }

    public void setIfcTitle(String pIfcTitle) {
        ifcTitle = pIfcTitle;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
