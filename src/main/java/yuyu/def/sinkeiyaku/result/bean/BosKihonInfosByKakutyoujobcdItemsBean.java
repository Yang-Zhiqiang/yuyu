package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 募集基本情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class BosKihonInfosByKakutyoujobcdItemsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String mosno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
