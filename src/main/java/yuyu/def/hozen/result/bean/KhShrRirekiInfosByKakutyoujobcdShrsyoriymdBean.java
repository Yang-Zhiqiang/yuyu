package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全支払履歴情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KhShrRireki iT_KhShrRireki;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

    @Getter @Setter
    private IT_KykSya iT_KykSya;

    @Getter @Setter
    private IT_HhknSya iT_HhknSya;

    @Getter @Setter
    private IT_KhTtdkRireki iT_KhTtdkRireki;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
