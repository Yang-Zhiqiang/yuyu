package yuyu.def.direct.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;

/**
 * ＤＳ顧客全情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class DsKokyakuKanrisByItemsBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    public DsKokyakuKanrisByItemsBean() {
    }

    @Getter @Setter
    private MT_DsKokyakuKanri mT_DsKokyakuKanri;

    @Getter @Setter
    private MT_DsHonninKakuninCd mT_DsHonninKakuninCd;

    @Getter @Setter
    private MT_DsLoginKanri mT_DsLoginKanri;

    @Getter @Setter
    private MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}