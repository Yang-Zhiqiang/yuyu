package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）振替用紙作成契約未入金リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhHrkeyousiSksKykMinyknListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhHrkeyousiSksKykMinyknListBean() {
    }

    private BizDate irSyoribi;

    public BizDate getIrSyoribi() {
        return irSyoribi;
    }

    public void setIrSyoribi(BizDate pIrSyoribi) {
        irSyoribi = pIrSyoribi;
    }

    private Integer irKensuu;

    public Integer getIrKensuu() {
        return irKensuu;
    }

    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
