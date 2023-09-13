package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）継続Ｐ翌月充当予定ＣＳＶＦ データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKzkPYokuJyuutouYoteiFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhKzkPYokuJyuutouYoteiFile() {
    }

    @Column(order = 1, label = "契約通貨種類")
    private String ifcKyktuukasyu;

    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }

    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }

    @Column(order = 2, label = "契約年月")
    private BizDateYM ifcKykym;

    public BizDateYM getIfcKykym() {
        return ifcKykym;
    }

    public void setIfcKykym(BizDateYM pIfcKykym) {
        ifcKykym = pIfcKykym;
    }

    @Column(order = 3, label = "充当年月")
    private BizDateYM ifcJyutouym;

    public BizDateYM getIfcJyutouym() {
        return ifcJyutouym;
    }

    public void setIfcJyutouym(BizDateYM pIfcJyutouym) {
        ifcJyutouym = pIfcJyutouym;
    }

    @Column(order = 4, label = "保険期間")
    private BizNumber ifcHknkkssyu;

    public BizNumber getIfcHknkkssyu() {
        return ifcHknkkssyu;
    }

    public void setIfcHknkkssyu(BizNumber pIfcHknkkssyu) {
        ifcHknkkssyu = pIfcHknkkssyu;
    }

    @Column(order = 5, label = "保険料合計")
    private String ifcHokenryougoukei;

    public String getIfcHokenryougoukei() {
        return ifcHokenryougoukei;
    }

    public void setIfcHokenryougoukei(String pIfcHokenryougoukei) {
        ifcHokenryougoukei = pIfcHokenryougoukei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
