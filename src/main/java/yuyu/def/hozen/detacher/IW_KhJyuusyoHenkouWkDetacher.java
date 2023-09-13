package yuyu.def.hozen.detacher;

import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;

/**
 * 住所変更ワークテーブル(IW_KhJyuusyoHenkouWk) デタッチャークラスです。<br />
 */
public class IW_KhJyuusyoHenkouWkDetacher {

    public static IW_KhJyuusyoHenkouWk detachKhJyuusyoHenkouWktouched(IW_KhJyuusyoHenkouWk pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
