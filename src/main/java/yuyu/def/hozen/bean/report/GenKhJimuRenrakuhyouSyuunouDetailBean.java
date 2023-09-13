package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）事務連絡票（収納）明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhJimuRenrakuhyouSyuunouDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhJimuRenrakuhyouSyuunouDetailBean() {
    }

    private String irJmrnrkhyousyuunoumsg;

    public String getIrJmrnrkhyousyuunoumsg() {
        return irJmrnrkhyousyuunoumsg;
    }

    public void setIrJmrnrkhyousyuunoumsg(String pIrJmrnrkhyousyuunoumsg) {
        irJmrnrkhyousyuunoumsg = pIrJmrnrkhyousyuunoumsg;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
