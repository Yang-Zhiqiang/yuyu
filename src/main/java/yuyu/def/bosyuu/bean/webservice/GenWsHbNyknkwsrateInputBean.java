package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.ValidDate;

/**
 * （保険募集）入金用為替レート照会入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbNyknkwsrateInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbNyknkwsrateInputBean() {
    }

    @Column(order = 1, length = 8)
    @ValidDate
    private BizDate iwsKijyunymd;

    public BizDate getIwsKijyunymd() {
        return iwsKijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKijyunymd(BizDate pIwsKijyunymd) {
        iwsKijyunymd = pIwsKijyunymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
