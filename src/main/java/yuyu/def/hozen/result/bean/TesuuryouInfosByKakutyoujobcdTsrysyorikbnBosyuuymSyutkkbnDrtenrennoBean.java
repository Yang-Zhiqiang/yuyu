package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;

/**
 * 手数料情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    IT_Tesuuryou iT_Tesuuryou;

    @Getter @Setter
    IT_TesuuryouSyouhn iT_TesuuryouSyouhn;

    @Getter @Setter
    IT_TesuuryouSyouhnRireki iT_TesuuryouSyouhnRireki;

    @Getter @Setter
    IT_KykKihon iT_KykKihon;

    @Getter @Setter
    IT_KykSya iT_KykSya;

    @Getter @Setter
    IT_HhknSya iT_HhknSya;

    @Getter @Setter
    IT_KykDairiten iT_KykDairiten;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}