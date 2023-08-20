package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;

/**
 * （数理）年金配当所要額追加情報反映ＦバッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrNkHitAddInfoBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrNkHitAddInfoBatchParam() {
    }

    private BizDate ibKsnbiymd;

    public BizDate getIbKsnbiymd() {
        return ibKsnbiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsnbiymd(BizDate pIbKsnbiymd) {
        ibKsnbiymd = pIbKsnbiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
