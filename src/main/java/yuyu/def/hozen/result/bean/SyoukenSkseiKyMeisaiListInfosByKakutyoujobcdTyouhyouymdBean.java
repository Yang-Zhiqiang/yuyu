package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;

/**
 * 証券作成契約明細リスト情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_HokenSyouken iT_HokenSyouken;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSya iT_KykSya;

    @Getter @Setter
    private IT_HhknSya iT_HhknSya;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
