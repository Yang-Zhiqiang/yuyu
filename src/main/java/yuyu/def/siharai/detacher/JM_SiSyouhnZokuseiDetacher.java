package yuyu.def.siharai.detacher;

import yuyu.def.db.entity.JM_SiSyouhnZokusei;

/**
 * 支払商品属性マスタ(JM_SiSyouhnZokusei) デタッチャークラスです。<br />
 */
public class JM_SiSyouhnZokuseiDetacher {

    public static JM_SiSyouhnZokusei detachSiSyouhnZokuseitouched(JM_SiSyouhnZokusei pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
