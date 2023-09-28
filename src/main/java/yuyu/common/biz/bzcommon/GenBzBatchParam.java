package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;

/**
 * （共通）バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    public GenBzBatchParam() {
    }

    private String ibKakutyoujobcd;

    public String getIbKakutyoujobcd() {
        return ibKakutyoujobcd;
    }

    public void setIbKakutyoujobcd(String pIbKakutyoujobcd) {
        ibKakutyoujobcd = pIbKakutyoujobcd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
