package yuyu.batch.hozen.khinterf.khseisandhaneituutisks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_UktkSyoriKbn;

/**
 * 変更受付予約Beanクラス<br />
 */
@AllArgsConstructor
public class KhHenkouUktkYykBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_UktkSyoriKbn uktksyorikbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
