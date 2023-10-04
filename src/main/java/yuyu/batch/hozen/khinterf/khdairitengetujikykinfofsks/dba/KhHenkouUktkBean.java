package yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;

/**
 * 契約保全 契約保全 契約保全変更受付Beanクラス
 */
@AllArgsConstructor
public class KhHenkouUktkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_UktkSyoriKbn uktkSyoriKbn;

    @Getter @Setter
    private C_UktkJyoutaiKbn uktkJyoutaiKbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
