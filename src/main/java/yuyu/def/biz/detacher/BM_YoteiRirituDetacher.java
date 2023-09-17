package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BM_YoteiRiritu;

/**
 * 予定利率マスタリスト(BM_YoteiRiritu) デタッチャークラスです。<br />
 */
public class BM_YoteiRirituDetacher {

    public static List<BM_YoteiRiritu> detachYoteiRiritutouched(List<BM_YoteiRiritu> pEntityList) {


        for (BM_YoteiRiritu entity : pEntityList) {


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
