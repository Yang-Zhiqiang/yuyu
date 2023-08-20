package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;


/**
 * （数理）新契約決算用会計取引ファイルバッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrSkKessanKaikeiTorihikiBatchParam extends BatchParam {


    private static final long serialVersionUID = 1L;


    public GenSrSkKessanKaikeiTorihikiBatchParam() {
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


    private BizDate ibKsnsaisyueigyoubiymd;


    public BizDate getIbKsnsaisyueigyoubiymd() {
        return ibKsnsaisyueigyoubiymd;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsnsaisyueigyoubiymd(BizDate pIbKsnsaisyueigyoubiymd) {
        ibKsnsaisyueigyoubiymd = pIbKsnsaisyueigyoubiymd;
    }


    private BizDate ibKsnyokugetu1steigyoubiymd;


    public BizDate getIbKsnyokugetu1steigyoubiymd() {
        return ibKsnyokugetu1steigyoubiymd;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsnyokugetu1steigyoubiymd(BizDate pIbKsnyokugetu1steigyoubiymd) {
        ibKsnyokugetu1steigyoubiymd = pIbKsnyokugetu1steigyoubiymd;
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
