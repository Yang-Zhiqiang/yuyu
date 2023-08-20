package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;

/**
 * （数理）保有明細情報作成バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrHoyuuMeisaiBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrHoyuuMeisaiBatchParam() {
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
