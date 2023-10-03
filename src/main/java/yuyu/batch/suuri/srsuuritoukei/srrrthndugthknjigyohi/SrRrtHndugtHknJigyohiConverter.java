package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknjigyohi;

import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiTy;

import com.google.common.base.Strings;

/**
 * 数理統計 数理統計 利率変動型保険事業費情報コンバーター
 */
public class SrRrtHndugtHknJigyohiConverter {

    public static void convertPadding(ZT_RrtHndugtHknJigyohiTy pZtRrtHndugtHknJigyohiTy) {

        pZtRrtHndugtHknJigyohiTy.setZtynknshry(
            Strings.padStart(pZtRrtHndugtHknJigyohiTy.getZtynknshry(), 2, '0'));
        pZtRrtHndugtHknJigyohiTy.setZtyphrkkikn(
            Strings.padStart(pZtRrtHndugtHknJigyohiTy.getZtyphrkkikn(), 2, '0'));

    }

    public static void convertPadding(ZT_RrtHndugtHknKsnJigyohiTy pZtRrtHndugtHknKsnJigyohiTy) {

        pZtRrtHndugtHknKsnJigyohiTy.setZtynknshry(
            Strings.padStart(pZtRrtHndugtHknKsnJigyohiTy.getZtynknshry(), 2, '0'));
        pZtRrtHndugtHknKsnJigyohiTy.setZtyphrkkikn(
            Strings.padStart(pZtRrtHndugtHknKsnJigyohiTy.getZtyphrkkikn(), 2, '0'));

    }
}
