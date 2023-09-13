package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 社員名簿情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SyainMeiboInfosByKakutyoujobcdKykymdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

    @Getter @Setter
    private IT_KykSya iT_KykSya;

    @Getter @Setter
    private BM_SyouhnZokusei bM_SyouhnZokusei;

    @Getter @Setter
    private IT_KhTtdkTyuui iT_KhTtdkTyuui;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
