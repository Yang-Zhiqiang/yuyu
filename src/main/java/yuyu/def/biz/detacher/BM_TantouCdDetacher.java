package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_TantouCd;

/**
 * 担当コードマスタ(BM_TantouCd) デタッチャークラスです。<br />
 */
public class BM_TantouCdDetacher {

    public static BM_TantouCd detachTantouCdtouched(BM_TantouCd pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }
        return null;
    }
}
