package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_Ginkou;

/**
 * 銀行マスタ(BM_Ginkou) デタッチャークラスです。<br />
 */
public class BM_GinkouDetacher {

    public static BM_Ginkou detachGinkoutouched(BM_Ginkou pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
