package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_Kouin;

/**
 * 行員マスタ(BM_Kouin) デタッチャークラスです。<br />
 */
public class BM_KouinDetacher {

    public static BM_Kouin detachKouintouched(BM_Kouin pEntity) {



        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}