package yuyu.def.base.detacher;

import java.util.List;

import yuyu.def.db.entity.AS_Kinou;

/**
 * 機能基幹テーブル(AS_Kinou) デタッチャークラスです。<br />
 */
public class AS_KinouDetacher {

    public static AS_Kinou detachKinouModetouched(AS_Kinou pEntity) {

        if (pEntity != null) {

            pEntity.getKinouModes().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static List<AS_Kinou> detachKinoutouched(List<AS_Kinou> pEntityList) {

        for (AS_Kinou entity : pEntityList) {

            if (entity == null) {

                continue;
            }

            entity.detach();
        }

        return pEntityList;
    }
}
