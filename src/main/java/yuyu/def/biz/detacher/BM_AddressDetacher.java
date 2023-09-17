package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_Address;

/**
 * 住所マスタ(BM_Address) デタッチャークラスです。<br />
 */
public class BM_AddressDetacher {

    public static BM_Address detachAddresstouched(BM_Address pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
