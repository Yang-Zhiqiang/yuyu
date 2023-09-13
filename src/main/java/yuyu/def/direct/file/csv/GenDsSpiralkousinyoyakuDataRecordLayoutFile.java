package yuyu.def.direct.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ダイレクト）ＳＰＩＲＡＬ更新予約ファイル（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsSpiralkousinyoyakuDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenDsSpiralkousinyoyakuDataRecordLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）ＤＳ顧客メールアドレス識別キー")
    private String ifcDskokmailaddressskbtkey;

    public String getIfcDskokmailaddressskbtkey() {
        return ifcDskokmailaddressskbtkey;
    }

    public void setIfcDskokmailaddressskbtkey(String pIfcDskokmailaddressskbtkey) {
        ifcDskokmailaddressskbtkey = pIfcDskokmailaddressskbtkey;
    }

    @Column(order = 2, label = "（ＩＦｃ）ＤＳメールアドレス")
    private String ifcDsmailaddress;

    public String getIfcDsmailaddress() {
        return ifcDsmailaddress;
    }

    public void setIfcDsmailaddress(String pIfcDsmailaddress) {
        ifcDsmailaddress = pIfcDsmailaddress;
    }

    @Column(order = 3, label = "（ＩＦｃ）ＤＳメールＤＢ処理区分")
    private String ifcDsmailaddressdbsyorikbn;

    public String getIfcDsmailaddressdbsyorikbn() {
        return ifcDsmailaddressdbsyorikbn;
    }

    public void setIfcDsmailaddressdbsyorikbn(String pIfcDsmailaddressdbsyorikbn) {
        ifcDsmailaddressdbsyorikbn = pIfcDsmailaddressdbsyorikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
