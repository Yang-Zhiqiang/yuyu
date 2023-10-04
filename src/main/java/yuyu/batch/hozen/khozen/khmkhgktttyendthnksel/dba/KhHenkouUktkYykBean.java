package yuyu.batch.hozen.khozen.khmkhgktttyendthnksel.dba;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_UktkSyoriKbn;

/**
 * 契約保全 契約保全 変更受付予約Beanクラス
 */
public class KhHenkouUktkYykBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_UktkSyoriKbn uktksyorikbn;

    public KhHenkouUktkYykBean(String pSyono, C_UktkSyoriKbn pUktksyorikbn) {

        syono = pSyono;
        uktksyorikbn = pUktksyorikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
