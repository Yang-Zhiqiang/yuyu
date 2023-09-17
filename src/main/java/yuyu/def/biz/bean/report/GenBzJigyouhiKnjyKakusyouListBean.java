package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）事業費勘定確証リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzJigyouhiKnjyKakusyouListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzJigyouhiKnjyKakusyouListBean() {
    }

    private BizDate irJigyouhilistsakuseiymd;

    public BizDate getIrJigyouhilistsakuseiymd() {
        return irJigyouhilistsakuseiymd;
    }

    public void setIrJigyouhilistsakuseiymd(BizDate pIrJigyouhilistsakuseiymd) {
        irJigyouhilistsakuseiymd = pIrJigyouhilistsakuseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
