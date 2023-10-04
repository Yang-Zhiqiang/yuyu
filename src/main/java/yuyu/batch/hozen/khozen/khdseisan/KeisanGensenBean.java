package yuyu.batch.hozen.khozen.khdseisan;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全 源泉徴収税額計算Beanクラス
 */
public class KeisanGensenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency gensen;

    @Getter @Setter
    private BizCurrency yenGensen;

    @Getter @Setter
    private BizCurrency yenGsTszeiGkKokuz;

    @Getter @Setter
    private BizCurrency yenGsTszeiGkTihouz;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
