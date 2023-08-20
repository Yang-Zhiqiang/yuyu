package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.batch.BatchParam;

/**
 * （数理）新契約決算ベース月次成立情報作成バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrSinkeiyakuGetujiSeirituBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    public GenSrSinkeiyakuGetujiSeirituBatchParam() {
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

    private BizDateYM ibTysyttaisyouym;

    public BizDateYM getIbTysyttaisyouym() {
        return ibTysyttaisyouym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbTysyttaisyouym(BizDateYM pIbTysyttaisyouym) {
        ibTysyttaisyouym = pIbTysyttaisyouym;
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
