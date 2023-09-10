package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）事務連絡票明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkJimurenrakuhyouDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkJimurenrakuhyouDetailBean() {
    }

    private String irMessage;

    public String getIrMessage() {
        return irMessage;
    }

    public void setIrMessage(String pIrMessage) {
        irMessage = pIrMessage;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
