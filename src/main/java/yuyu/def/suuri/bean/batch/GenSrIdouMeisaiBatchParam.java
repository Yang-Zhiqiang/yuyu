package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;

/**
 * （数理）異動明細情報作成バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrIdouMeisaiBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrIdouMeisaiBatchParam() {
    }

    private BizDate ibKijyunymd;

    public BizDate getIbKijyunymd() {
        return ibKijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKijyunymd(BizDate pIbKijyunymd) {
        ibKijyunymd = pIbKijyunymd;
    }

    private BizDate ibZenkaidensimeymd;

    public BizDate getIbZenkaidensimeymd() {
        return ibZenkaidensimeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbZenkaidensimeymd(BizDate pIbZenkaidensimeymd) {
        ibZenkaidensimeymd = pIbZenkaidensimeymd;
    }

    private BizDate ibJigyounendoKsnbiymd;

    public BizDate getIbJigyounendoKsnbiymd() {
        return ibJigyounendoKsnbiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbJigyounendoKsnbiymd(BizDate pIbJigyounendoKsnbiymd) {
        ibJigyounendoKsnbiymd = pIbJigyounendoKsnbiymd;
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
