package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;

/**
 * 金融機関普保預振情報マスタ(BM_KinyuuKikanHuhoyofuriInfo) デタッチャークラスです。<br />
 */
public class BM_KinyuuKikanHuhoyofuriInfoDetacher {

    public static BM_KinyuuKikanHuhoyofuriInfo detachKinyuuKikanHuhoyofuriInfotouched(
        BM_KinyuuKikanHuhoyofuriInfo pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
