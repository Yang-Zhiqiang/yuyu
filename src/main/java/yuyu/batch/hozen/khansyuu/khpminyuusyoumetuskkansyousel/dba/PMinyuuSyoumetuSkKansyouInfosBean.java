package yuyu.batch.hozen.khansyuu.khpminyuusyoumetuskkansyousel.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;

/**
 * 契約保全 案内収納 Ｐ未入消滅請求勧奨情報Beanクラス
 */
@AllArgsConstructor
public class PMinyuuSyoumetuSkKansyouInfosBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

    @Getter @Setter
    private BM_SyouhnZokusei bM_SyouhnZokusei;

    @Getter @Setter
    private IT_KykSya iT_KykSya;

    @Getter @Setter
    private IT_HhknSya iT_HhknSya;

    @Getter @Setter
    private IT_PMinyuuSyoumetuInfo iT_PMinyuuSyoumetuInfo;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
