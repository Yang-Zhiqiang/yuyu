package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

/**
 * 業務用工程情報テーブルリスト(BT_GyoumuKouteiInfo) デタッチャークラスです。<br />
 */
public class BT_GyoumuKouteiInfoDetacher {

    public static List<BT_GyoumuKouteiInfo> detachGyoumuKouteiInfotouched(List<BT_GyoumuKouteiInfo> pEntityList) {


        for (BT_GyoumuKouteiInfo entity : pEntityList) {


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
