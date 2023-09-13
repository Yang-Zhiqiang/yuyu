package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）前納統計リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhZennouToukeiListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhZennouToukeiListBean() {
    }

    private String irSakuseiymd;

    public String getIrSakuseiymd() {
        return irSakuseiymd;
    }

    public void setIrSakuseiymd(String pIrSakuseiymd) {
        irSakuseiymd = pIrSakuseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
