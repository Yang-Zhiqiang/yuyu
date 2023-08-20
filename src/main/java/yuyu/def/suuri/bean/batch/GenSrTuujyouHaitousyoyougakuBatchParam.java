package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * （数理）通常配当所要額情報作成バッチパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrTuujyouHaitousyoyougakuBatchParam extends BzBatchParam {


    private static final long serialVersionUID = 1L;


    public GenSrTuujyouHaitousyoyougakuBatchParam() {
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


    private BizDateYM ibKeijyouym;


    public BizDateYM getIbKeijyouym() {
        return ibKeijyouym;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKeijyouym(BizDateYM pIbKeijyouym) {
        ibKeijyouym = pIbKeijyouym;
    }


    private String ibHaitousyoyougakukeisancd;


    public String getIbHaitousyoyougakukeisancd() {
        return ibHaitousyoyougakukeisancd;
    }


    public void setIbHaitousyoyougakukeisancd(String pIbHaitousyoyougakukeisancd) {
        ibHaitousyoyougakukeisancd = pIbHaitousyoyougakukeisancd;
    }


    private BizDateY ibDratenendo;


    public BizDateY getIbDratenendo() {
        return ibDratenendo;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbDratenendo(BizDateY pIbDratenendo) {
        ibDratenendo = pIbDratenendo;
    }


    private BizDateY ibKeisanDnendo;


    public BizDateY getIbKeisanDnendo() {
        return ibKeisanDnendo;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKeisanDnendo(BizDateY pIbKeisanDnendo) {
        ibKeisanDnendo = pIbKeisanDnendo;
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
