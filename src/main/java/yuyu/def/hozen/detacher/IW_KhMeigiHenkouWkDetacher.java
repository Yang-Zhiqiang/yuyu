package yuyu.def.hozen.detacher;

import yuyu.def.db.entity.IW_KhMeigiHenkouWk;

/**
 * 名義変更ワークテーブル(IW_KhMeigiHenkouWk) デタッチャークラスです。<br />
 */
public class IW_KhMeigiHenkouWkDetacher {

    public static IW_KhMeigiHenkouWk detachKhMeigiHenkouWktouched(IW_KhMeigiHenkouWk pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
