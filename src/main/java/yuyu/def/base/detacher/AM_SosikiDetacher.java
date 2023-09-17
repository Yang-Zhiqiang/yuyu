package yuyu.def.base.detacher;

import java.util.List;

import yuyu.def.db.entity.AM_Sosiki;

/**
 * 組織マスタ(AM_Sosiki) デタッチャークラスです。<br />
 */
public class AM_SosikiDetacher {

    public static AM_Sosiki detachSosikitouched(AM_Sosiki pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.detach();
        return pEntity;
    }

    public static List<AM_Sosiki> detachSosikitouched(List<AM_Sosiki> pEntityList) {

        for (AM_Sosiki entity : pEntityList) {

            if (entity == null) {

                continue;
            }

            entity.detach();
        }

        return pEntityList;
    }
}
