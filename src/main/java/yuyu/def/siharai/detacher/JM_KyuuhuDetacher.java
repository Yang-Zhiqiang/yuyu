package yuyu.def.siharai.detacher;

import yuyu.def.db.entity.JM_Kyuuhu;

/**
 * 給付マスタ(JM_Kyuuhu) デタッチャークラスです。<br />
 */
public class JM_KyuuhuDetacher {

    public static JM_Kyuuhu detachKyuuhutouched(JM_Kyuuhu pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
