package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保有入金実績履歴テーブルBeanクラスです。<br />
 */
@AllArgsConstructor
public class NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_Tuukasyu rstuukasyu;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
