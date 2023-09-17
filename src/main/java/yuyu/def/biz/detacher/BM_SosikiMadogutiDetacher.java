package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_SosikiMadoguti;

/**
 * 組織窓口情報マスタ(BM_SosikiMadoguti) デタッチャークラスです。<br />
 */
public class BM_SosikiMadogutiDetacher {

    public static BM_SosikiMadoguti detachSosikiMadogutitouched(BM_SosikiMadoguti pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}