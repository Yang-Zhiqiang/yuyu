package yuyu.batch.biz.sysbatch.bzdeleteprocessandjbpmrecord;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 工程履歴・ＪＢＰＭデータ削除バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzDeleteProcessAndJBPMRecordBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public GenBzDeleteProcessAndJBPMRecordBatchParam() {
    }

    private String ibSkjtsgkkntksu;

    public String getIbSkjtsgkkntksu() {
        return ibSkjtsgkkntksu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbSkjtsgkkntksu(String pIbSkjtsgkkntksu) {
        ibSkjtsgkkntksu = pIbSkjtsgkkntksu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
