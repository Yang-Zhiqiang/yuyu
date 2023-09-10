package yuyu.def.siharai.detacher;

import yuyu.def.db.entity.JM_SiinHantei;

/**
 * 死因判定マスタ(JM_SiinHantei) デタッチャークラスです。<br />
 */
public class JM_SiinHanteiDetacher {

    public static JM_SiinHantei detachSiinHanteitouched(JM_SiinHantei pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
