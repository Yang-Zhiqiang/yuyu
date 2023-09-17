package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BT_TjtIdouNyNk;

/**
 * 当日異動内容年金支払テーブルリスト(BT_TjtIdouNyNk) デタッチャークラスです。<br />
 */
public class BT_TjtIdouNyNkDetacher {

    public static List<BT_TjtIdouNyNk> detachTjtIdouNyNktouched(List<BT_TjtIdouNyNk> pEntityList) {


        for (BT_TjtIdouNyNk entity : pEntityList) {


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
