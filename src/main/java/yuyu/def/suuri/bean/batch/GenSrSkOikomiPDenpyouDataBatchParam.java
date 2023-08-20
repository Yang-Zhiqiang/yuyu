package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * （数理）新契約追込保険料伝票データバッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrSkOikomiPDenpyouDataBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrSkOikomiPDenpyouDataBatchParam() {
    }

    private BizDate ibKsnyokugetufirstdayymd;

    public BizDate getIbKsnyokugetufirstdayymd() {
        return ibKsnyokugetufirstdayymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsnyokugetufirstdayymd(BizDate pIbKsnyokugetufirstdayymd) {
        ibKsnyokugetufirstdayymd = pIbKsnyokugetufirstdayymd;
    }

    private BizDate ibKsndensimeymd;

    public BizDate getIbKsndensimeymd() {
        return ibKsndensimeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsndensimeymd(BizDate pIbKsndensimeymd) {
        ibKsndensimeymd = pIbKsndensimeymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
