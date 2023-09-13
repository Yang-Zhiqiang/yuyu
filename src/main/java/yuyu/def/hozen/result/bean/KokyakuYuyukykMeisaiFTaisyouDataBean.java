package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 顧客用ゆうゆう契約明細Ｆ対象データBeanクラスです。<br />
 */
@AllArgsConstructor
public class KokyakuYuyukykMeisaiFTaisyouDataBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

    @Getter @Setter
    private IT_KykSonotaTkyk iT_KykSonotaTkyk;

    @Getter @Setter
    private IT_HhknSya iT_HhknSya;

    @Getter @Setter
    private IT_KykSya iT_KykSya;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
