package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BT_BuntanInfo;

/**
 * 分担情報テーブルリスト(BT_BuntanInfo) デタッチャークラスです。<br />
 */
public class BT_BuntanInfoDetacher {

    public static List<BT_BuntanInfo> detachBuntanInfotouched(List<BT_BuntanInfo> pEntityList) {


        for (BT_BuntanInfo entity : pEntityList) {


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
