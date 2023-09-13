package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）災害特伸契約保有リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSaigaitokusinKykhoyuuListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSaigaitokusinKykhoyuuListBean() {
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
