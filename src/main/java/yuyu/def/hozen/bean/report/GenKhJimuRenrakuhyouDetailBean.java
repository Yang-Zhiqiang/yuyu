package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）事務連絡票明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhJimuRenrakuhyouDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhJimuRenrakuhyouDetailBean() {
    }

    private String irJmrnrkhyoumsg;

    public String getIrJmrnrkhyoumsg() {
        return irJmrnrkhyoumsg;
    }

    public void setIrJmrnrkhyoumsg(String pIrJmrnrkhyoumsg) {
        irJmrnrkhyoumsg = pIrJmrnrkhyoumsg;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
