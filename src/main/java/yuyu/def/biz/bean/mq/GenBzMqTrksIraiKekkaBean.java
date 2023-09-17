package yuyu.def.biz.bean.mq;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＭＱ取消依頼結果BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqTrksIraiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqTrksIraiKekkaBean() {
    }

    @Column(order = 1, length = 4)
    private String iwsAcserrcd;

    public String getIwsAcserrcd() {
        return iwsAcserrcd;
    }

    public void setIwsAcserrcd(String pIwsAcserrcd) {
        iwsAcserrcd = pIwsAcserrcd;
    }

    @Column(order = 2, length = 1)
    private String iwsTrkskekkakbn;

    public String getIwsTrkskekkakbn() {
        return iwsTrkskekkakbn;
    }

    public void setIwsTrkskekkakbn(String pIwsTrkskekkakbn) {
        iwsTrkskekkakbn = pIwsTrkskekkakbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
