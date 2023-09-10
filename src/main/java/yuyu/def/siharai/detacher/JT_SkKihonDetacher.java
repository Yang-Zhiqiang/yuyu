package yuyu.def.siharai.detacher;

import java.util.List;

import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 請求基本テーブル(JT_SkKihon) デタッチャークラスです。<br />
 */
public class JT_SkKihonDetacher {

    public static JT_SkKihon detachSiRirekitouched(JT_SkKihon pEntity) {

        if (pEntity != null) {

            pEntity.getSiRirekis().size();

            pEntity.detach();

            return pEntity;
        }
        return null;
    }

    public static JT_SkKihon detachSkKihontouched(JT_SkKihon pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static JT_SkKihon detachSktouched(JT_SkKihon pEntity) {

        if (pEntity != null) {

            pEntity.getSks().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static JT_SkKihon detachSkJiyuutouched(JT_SkKihon pEntity) {

        if (pEntity != null) {

            List<JT_Sk> SkLst = pEntity.getSks();
            for(JT_Sk JT_Sk: SkLst){

                if(JT_Sk != null){

                    JT_Sk.getSkJiyuus().size();
                }
            }

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static JT_SkKihon detachSiDetailtouched(JT_SkKihon pEntity) {

        if (pEntity != null) {

            List<JT_Sk> SkLst = pEntity.getSks();
            for(JT_Sk JT_Sk: SkLst){

                if(JT_Sk != null){

                    List<JT_SkJiyuu> SkJiyuuLst = JT_Sk.getSkJiyuus();
                    for(JT_SkJiyuu JT_SkJiyuu: SkJiyuuLst){

                        if(JT_SkJiyuu != null){

                            JT_SkJiyuu.getSiDetails().size();
                        }
                    }
                }
            }

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static List<JT_SkKihon> detachSibouKariuketsuketouched(List<JT_SkKihon> pEntityList) {

        for (JT_SkKihon entity : pEntityList) {

            if (entity != null) {

                entity.getSibouKariuketsuke();

                entity.detach();
            }
            else {
                continue;
            }
        }

        return pEntityList;
    }

    public static JT_SkKihon detachTtdkRirekitouched(JT_SkKihon pEntity) {

        if (pEntity != null) {

            pEntity.getTtdkRirekis().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
