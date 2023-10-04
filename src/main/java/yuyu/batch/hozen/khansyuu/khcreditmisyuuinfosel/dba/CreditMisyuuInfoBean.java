package yuyu.batch.hozen.khansyuu.khcreditmisyuuinfosel.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;

/**
 * クレカ未収契約情報Beanクラス<br />
 */
@AllArgsConstructor
public class CreditMisyuuInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_DattairiyuuKbn dattairiyuukbn;

    @Getter @Setter
    private C_Dattaikeiro dattaikeiro;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}