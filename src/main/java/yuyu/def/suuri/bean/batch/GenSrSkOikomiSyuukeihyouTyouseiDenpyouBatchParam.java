package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * （数理）新契約追込集計表（調整伝票）バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrSkOikomiSyuukeihyouTyouseiDenpyouBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrSkOikomiSyuukeihyouTyouseiDenpyouBatchParam() {
    }

    private String ibWarekinendo;

    public String getIbWarekinendo() {
        return ibWarekinendo;
    }

    public void setIbWarekinendo(String pIbWarekinendo) {
        ibWarekinendo = pIbWarekinendo;
    }

    private String ibKessankikanji;

    public String getIbKessankikanji() {
        return ibKessankikanji;
    }

    public void setIbKessankikanji(String pIbKessankikanji) {
        ibKessankikanji = pIbKessankikanji;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
