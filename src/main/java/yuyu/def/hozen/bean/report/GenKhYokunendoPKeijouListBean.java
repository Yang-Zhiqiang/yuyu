package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）翌年度保険料計上リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhYokunendoPKeijouListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhYokunendoPKeijouListBean() {
    }

    private BizDate irSyoribi;

    public BizDate getIrSyoribi() {
        return irSyoribi;
    }

    public void setIrSyoribi(BizDate pIrSyoribi) {
        irSyoribi = pIrSyoribi;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
