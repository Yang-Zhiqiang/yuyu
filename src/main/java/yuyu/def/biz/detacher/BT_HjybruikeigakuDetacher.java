package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BT_Hjybruikeigaku;

/**
 * 補助簿累計額テーブル(BT_Hjybruikeigaku) デタッチャークラスです。<br />
 */
public class BT_HjybruikeigakuDetacher {

    public static BT_Hjybruikeigaku detachHjybruikeigakutouched(BT_Hjybruikeigaku pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
    public static List<BT_Hjybruikeigaku> detachHjybruikeigakutouched(List<BT_Hjybruikeigaku> pEntityList) {


        for (BT_Hjybruikeigaku entity : pEntityList) {


            if (entity != null) {


                entity.detach();
            }
            else {
                continue;
            }
        }


        return pEntityList;
    }
}
