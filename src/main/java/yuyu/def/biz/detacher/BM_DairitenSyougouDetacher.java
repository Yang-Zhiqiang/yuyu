package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_DairitenSyougou;

/**
 * 代理店法人商号マスタ(BM_DairitenSyougou) デタッチャークラスです。<br />
 */
public class BM_DairitenSyougouDetacher {

    public static BM_DairitenSyougou detachDairitenSyougoutouched(BM_DairitenSyougou pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
