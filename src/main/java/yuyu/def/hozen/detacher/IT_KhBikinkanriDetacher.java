package yuyu.def.hozen.detacher;

import java.util.List;

import yuyu.def.db.entity.IT_KhBikinkanri;

/**
 * 契約保全備金管理テーブルリスト(List<IT_KhBikinkanri>) デタッチャークラスです。<br />
 */
public class IT_KhBikinkanriDetacher {

    public static List<IT_KhBikinkanri> detachKhBikinkanritouched(List<IT_KhBikinkanri> pEntityList) {

        for (IT_KhBikinkanri entity : pEntityList) {

            if (entity == null) {

                continue;
            }

            entity.detach();
        }

        return pEntityList;
    }
}
