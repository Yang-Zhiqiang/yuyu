package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BM_NenkinYoteiRiritu;

/**
 * 年金開始後予定利率マスタリスト(BM_NenkinYoteiRiritu) デタッチャークラスです。<br />
 */
public class BM_NenkinYoteiRirituDetacher {

    public static List<BM_NenkinYoteiRiritu> detachNenkinYoteiRiritutouched(List<BM_NenkinYoteiRiritu> pEntityList) {


        for (BM_NenkinYoteiRiritu entity : pEntityList) {


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
