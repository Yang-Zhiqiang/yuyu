package yuyu.def.siharai.detacher;

import java.util.List;

import yuyu.def.db.entity.JT_SiBikinkanri;

/**
 * 保険金給付金備金管理テーブルリスト(List<JT_SiBikinkanri>) デタッチャークラスです。<br />
 */
public class JT_SiBikinkanriDetacher {

    public static List<JT_SiBikinkanri> detachSiBikinkanritouched(List<JT_SiBikinkanri> pEntityList) {

        for (JT_SiBikinkanri entity : pEntityList) {

            if (entity == null) {
                continue;
            }

            entity.detach();
        }

        return pEntityList;
    }
}
