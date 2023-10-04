package yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinsel.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;

/**
 * Ｐ未入消滅情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon kykKihon;

    @Getter @Setter
    private IT_KykSyouhn kykSyouhn;

    @Getter @Setter
    private IT_PMinyuuSyoumetuInfo pMinyuuSyoumetuInfo;

    @Getter @Setter
    private Integer syoriUmuKbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
