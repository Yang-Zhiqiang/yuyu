package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全備金管理情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

    @Getter @Setter
    private IT_KhShrRireki iT_KhShrRireki;

    @Getter @Setter
    private IT_KhTtdkRireki iT_KhTtdkRireki;

    @Getter @Setter
    private BM_SyouhnZokusei bM_SyouhnZokusei;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
