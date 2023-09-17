package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BT_DenpyoData;

/**
 * 経理伝票データテーブル(BT_DenpyoData) デタッチャークラスです。<br />
 */
public class BT_DenpyoDataDetacher {

    public static BT_DenpyoData detachDenpyoDatatouched(BT_DenpyoData pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }

    public static List<BT_DenpyoData> detachDenpyoDatatouched(List<BT_DenpyoData> pEntityList) {


        for (BT_DenpyoData entity : pEntityList) {


            if (entity != null) {


                entity.detach();
            }
            else {
                continue;
            }
        }


        return pEntityList;
    }
}
