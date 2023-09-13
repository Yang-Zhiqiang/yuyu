package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * ＦＡＴＣＡ定期調査要契約情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_FatcaInfo iT_FatcaInfo;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

    @Getter @Setter
    private IT_KykSya iT_KykSya;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
