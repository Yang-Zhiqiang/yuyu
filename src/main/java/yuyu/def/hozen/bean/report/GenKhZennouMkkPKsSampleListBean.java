package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）前納未経過Ｐ検証サンプルリスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhZennouMkkPKsSampleListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhZennouMkkPKsSampleListBean() {
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
