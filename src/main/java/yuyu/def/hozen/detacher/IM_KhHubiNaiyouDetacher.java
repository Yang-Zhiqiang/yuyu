package yuyu.def.hozen.detacher;

import java.util.List;

import yuyu.def.db.entity.IM_KhHubiNaiyou;

/**
 * 契約保全不備内容マスタリスト(IM_KhHubiNaiyou) デタッチャークラスです。<br />
 */
public class IM_KhHubiNaiyouDetacher {

    public static List<IM_KhHubiNaiyou> detachKhHubiNaiyoutouched(List<IM_KhHubiNaiyou> pEntityList) {

        for (IM_KhHubiNaiyou entity : pEntityList) {

            if (entity != null) {

                entity.detach();
            }
            else {
                continue;
            }
        }

        return pEntityList;
    }
}
