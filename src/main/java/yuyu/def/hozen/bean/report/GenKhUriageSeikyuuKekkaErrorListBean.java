package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）売上請求結果エラーリスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhUriageSeikyuuKekkaErrorListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhUriageSeikyuuKekkaErrorListBean() {
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String pIrTantousitunm) {
        irTantousitunm = pIrTantousitunm;
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
