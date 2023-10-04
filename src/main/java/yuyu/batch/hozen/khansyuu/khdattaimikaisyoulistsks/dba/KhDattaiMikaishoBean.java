package yuyu.batch.hozen.khansyuu.khdattaimikaisyoulistsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;

/**
 * 脱退未解消Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhDattaiMikaishoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private String syorisosikicd;

    @Getter @Setter
    private C_Dattaikeiro dattaikeiro;

    @Getter @Setter
    private C_DattairiyuuKbn dattairiyuukbn;

    @Getter @Setter
    private String comment124keta;

    @Getter @Setter
    private String gyoumuKousinsyaId;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
