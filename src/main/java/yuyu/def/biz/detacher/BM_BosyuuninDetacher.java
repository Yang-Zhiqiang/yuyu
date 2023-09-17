package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BM_Bosyuunin;

/**
 * 募集人マスタ(BM_Bosyuunin) デタッチャークラスです。<br />
 */
public class BM_BosyuuninDetacher {

    public static BM_Bosyuunin detachBosyuunintouched(BM_Bosyuunin pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }

    public static List<BM_Bosyuunin> detachBosyuunintouched(List<BM_Bosyuunin> pEntityList) {


        for (BM_Bosyuunin entity : pEntityList) {


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