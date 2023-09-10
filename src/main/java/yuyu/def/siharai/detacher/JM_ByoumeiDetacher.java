package yuyu.def.siharai.detacher;

import yuyu.def.db.entity.JM_Byoumei;

/**
 * 病名マスタ(JM_Byoumei) デタッチャークラスです。<br />
 */
public class JM_ByoumeiDetacher {

    public static JM_Byoumei detachByoumeitouched(JM_Byoumei pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
