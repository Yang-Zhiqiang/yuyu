package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * （保険募集）生保Ｗｅｂ申込状況照会入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebMosSyoukaiInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebMosSyoukaiInputBean() {
    }

    @Column(order = 1, length = 9)
    @MousikomiNo
    private String iwsMosno;

    public String getIwsMosno() {
        return iwsMosno;
    }

    public void setIwsMosno(String pIwsMosno) {
        iwsMosno = pIwsMosno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
