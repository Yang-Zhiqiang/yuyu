package yuyu.def.base.detacher;

import yuyu.def.db.entity.AM_User;

/**
 * ユーザーマスタ(AM_User) デタッチャークラスです。<br />
 */
public class AM_UserDetacher {

    public static AM_User detachUsertouched(AM_User pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
