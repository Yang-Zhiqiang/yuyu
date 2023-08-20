package yuyu.def.suuri.detacher;

import java.util.List;

import yuyu.def.db.entity.SV_KiykSyuhnData;

/**
 * 契約商品情報ビューリスト(List<SV_KiykSyuhnData>) デタッチャークラスです。<br />
 */
public class SV_KiykSyuhnDataDetacher {

    public static List<SV_KiykSyuhnData> detachKiykSyuhnDatatouched(List<SV_KiykSyuhnData> pEntityList) {

        for (SV_KiykSyuhnData entity : pEntityList) {

            if (entity == null) {

                continue;
            }

            entity.detach();
        }

        return pEntityList;
    }
}
