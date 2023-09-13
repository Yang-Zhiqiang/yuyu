package yuyu.def.hozen.detacher;

import yuyu.def.db.entity.IT_ItekiToukeiInfo;

/**
 * 医的統計用情報テーブル(IT_ItekiToukeiInfo) デタッチャークラスです。<br />
 */
public class IT_ItekiToukeiInfoDetacher {

    public static IT_ItekiToukeiInfo detachItekiToukeiInfotouched(IT_ItekiToukeiInfo pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
