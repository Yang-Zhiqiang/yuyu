package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkSyoriKbn;

/**
 * 契約保全変更受付Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhHenkouUktkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_UktkSyoriKbn uktkSyoriKbn;

    @Getter @Setter
    private C_TourokuRouteKbn tourokuroute;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
