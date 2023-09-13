package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 保有契約保全手続履歴テーブルBeanクラスです。<br />
 */
@AllArgsConstructor
public class HoyuuKhTtdkRirekiByPkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate syoriymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
