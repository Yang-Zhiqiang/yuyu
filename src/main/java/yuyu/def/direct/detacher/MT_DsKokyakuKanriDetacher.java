package yuyu.def.direct.detacher;

import java.util.List;

import yuyu.def.db.entity.MT_DsKokyakuKanri;

/**
 * ＤＳ顧客管理テーブル(MT_DsKokyakuKanri) デタッチャークラスです。<br />
 */
public class MT_DsKokyakuKanriDetacher {

    public static MT_DsKokyakuKanri detachDsLoginKanritouched(MT_DsKokyakuKanri pEntity) {

        if (pEntity != null) {

            pEntity.getDsLoginKanri();

            pEntity.detach();

            return pEntity;
        }
        return null;
    }

    public static MT_DsKokyakuKanri detachDsKokyakuKanritouched(MT_DsKokyakuKanri pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static MT_DsKokyakuKanri detachDsKokyakuKeiyakutouched(MT_DsKokyakuKanri pEntity) {

        if (pEntity != null) {

            pEntity.getDsKokyakuKeiyakus().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static List<MT_DsKokyakuKanri> detachDsKokyakuKeiyakuDsHonninKakuninCdDsLoginKanritouched(List<MT_DsKokyakuKanri> pEntityList) {

        for (MT_DsKokyakuKanri entity : pEntityList) {

            if (entity != null) {

                entity.getDsKokyakuKeiyakus().size();

                entity.getDsHonninKakuninCd();

                entity.getDsLoginKanri();

                entity.detach();
            }
            else {
                continue;
            }
        }

        return pEntityList;
    }

    public static List<MT_DsKokyakuKanri> detachDsKokyakuKanritouched(List<MT_DsKokyakuKanri> pEntityList) {

        for (MT_DsKokyakuKanri entity : pEntityList) {

            if (entity != null) {

                entity.detach();
            }
            else {
                continue;
            }
        }

        return pEntityList;
    }

    public static MT_DsKokyakuKanri detachDsHaisinErrorListtouched(MT_DsKokyakuKanri pEntity) {

        if (pEntity != null) {

            pEntity.getDsHaisinErrorLists().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static List<MT_DsKokyakuKanri> detachDsMailAddresstouched(List<MT_DsKokyakuKanri> pEntityList) {

        for (MT_DsKokyakuKanri entity : pEntityList) {

            if (entity != null) {

                entity.getDsMailAddresss().size();

                entity.detach();
            }
            else {
                continue;
            }
        }

        return pEntityList;
    }
}
