package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;

/**
 * （数理）年金配当所要額Ｆ決算報告用バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrNkHitKsnBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrNkHitKsnBatchParam() {
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

    private BizDateY ibToujigyounendo;

    public BizDateY getIbToujigyounendo() {
        return ibToujigyounendo;
    }

    public void setIbToujigyounendo(BizDateY pIbToujigyounendo) {
        ibToujigyounendo = pIbToujigyounendo;
    }

    private BizDateY ibYokujigyounendo;

    public BizDateY getIbYokujigyounendo() {
        return ibYokujigyounendo;
    }

    public void setIbYokujigyounendo(BizDateY pIbYokujigyounendo) {
        ibYokujigyounendo = pIbYokujigyounendo;
    }

    private BizDateY ibYoku2jigyounendo;

    public BizDateY getIbYoku2jigyounendo() {
        return ibYoku2jigyounendo;
    }

    public void setIbYoku2jigyounendo(BizDateY pIbYoku2jigyounendo) {
        ibYoku2jigyounendo = pIbYoku2jigyounendo;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
