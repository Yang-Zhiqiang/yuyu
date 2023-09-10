package yuyu.def.sinkeiyaku.detacher;

import java.util.List;

import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 処理コントロールテーブル(HT_SyoriCTL) デタッチャークラスです。<br />
 */
public class HT_SyoriCTLDetacher {

    public static HT_SyoriCTL detachMosSyouhntouched(HT_SyoriCTL pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.getMosSyouhns().size();

        pEntity.detach();

        return pEntity;
    }

    public static HT_SyoriCTL detachMosDairitentouched(HT_SyoriCTL pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.getMosDairitens().size();

        pEntity.detach();

        return pEntity;
    }

    public static HT_SyoriCTL detachSyoriCTLtouched(HT_SyoriCTL pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static HT_SyoriCTL detachMosKihontouched(HT_SyoriCTL pEntity) {

        if (pEntity != null) {

            pEntity.getMosKihon();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static HT_SyoriCTL detachNyuukintouched(HT_SyoriCTL pEntity) {

        if (pEntity != null) {

            pEntity.getNyuukins().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static HT_SyoriCTL detachMosKihonMosDairitenNyuukinHenkintouched(HT_SyoriCTL pEntity) {

        if (pEntity != null) {

            pEntity.getMosKihon();

            pEntity.getMosDairitens().size();

            pEntity.getNyuukins().size();

            pEntity.getHenkins().size();

            pEntity.detach();

            return pEntity;
        }

        return null;
    }

    public static List<HT_SyoriCTL> detachMosKihontouched(List<HT_SyoriCTL> pEntityList) {

        for (HT_SyoriCTL entity : pEntityList) {

            if (entity != null) {

                entity.getMosKihon();

                entity.detach();
            }
            else {
                continue;
            }
        }

        return pEntityList;
    }
}
