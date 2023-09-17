package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保険募集）クレジットカード決済用番号取得出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebCreditkessaiyounoOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebCreditkessaiyounoOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsErrkbn;

    public String getIwsErrkbn() {
        return iwsErrkbn;
    }

    public void setIwsErrkbn(String pIwsErrkbn) {
        iwsErrkbn = pIwsErrkbn;
    }

    @Column(order = 2, length = 26)
    private String iwsCreditkessaiyouno;

    public String getIwsCreditkessaiyouno() {
        return iwsCreditkessaiyouno;
    }

    public void setIwsCreditkessaiyouno(String pIwsCreditkessaiyouno) {
        iwsCreditkessaiyouno = pIwsCreditkessaiyouno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
