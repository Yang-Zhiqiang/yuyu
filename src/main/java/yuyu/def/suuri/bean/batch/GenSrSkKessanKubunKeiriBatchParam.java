package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;

/**
 * （数理）新契約決算用区分経理連動ファイルバッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrSkKessanKubunKeiriBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrSkKessanKubunKeiriBatchParam() {
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

    private BizDate ibKsndensimeymd;

    public BizDate getIbKsndensimeymd() {
        return ibKsndensimeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsndensimeymd(BizDate pIbKsndensimeymd) {
        ibKsndensimeymd = pIbKsndensimeymd;
    }

    private Integer ibSyorikensuu;

    public Integer getIbSyorikensuu() {
        return ibSyorikensuu;
    }

    public void setIbSyorikensuu(Integer pIbSyorikensuu) {
        ibSyorikensuu = pIbSyorikensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
