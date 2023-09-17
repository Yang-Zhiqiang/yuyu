package yuyu.def.biz.detacher;

import java.util.List;

import yuyu.def.db.entity.BM_Dairiten;

/**
 * 代理店マスタ(BM_Dairiten) デタッチャークラスです。<br />
 */
public class BM_DairitenDetacher {

    public static BM_Dairiten detachDairitentouched(BM_Dairiten pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }

    public static List<BM_Dairiten> detachDairitentouched(List<BM_Dairiten> pEntityList) {


        for (BM_Dairiten entity : pEntityList) {


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
