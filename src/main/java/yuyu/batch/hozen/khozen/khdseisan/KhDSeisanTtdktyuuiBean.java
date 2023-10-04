package yuyu.batch.hozen.khozen.khdseisan;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;

/**
 * 契約保全 契約保全 Ｄ精算手続注意情報Beanクラス
 */
public class KhDSeisanTtdktyuuiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String ttdktyuuiNaiyou;

    @Getter @Setter
    private C_DseisansouhusakihnsyuKbn dseisansouhusakihnsyuKbn;

    @Getter @Setter
    private int ttdktyuuiKensuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
