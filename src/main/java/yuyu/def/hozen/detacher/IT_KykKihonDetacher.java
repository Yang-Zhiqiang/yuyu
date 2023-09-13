package yuyu.def.hozen.detacher;

import java.util.List;

import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tesuuryou;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
public class IT_KykKihonDetacher {

    public static IT_KykKihon detachKykSyouhnKykDairitenKykSyatouched(IT_KykKihon pEntity) {

        if(pEntity != null){

            pEntity.getKykSyouhns().size();

            pEntity.getKykDairitens().size();

            pEntity.getKykSya();

            pEntity.detach();
            return pEntity;
        }

        return null;
    }

    public static IT_KykKihon detachKykSyouhntouched(IT_KykKihon pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.getKykSyouhns().size();

        pEntity.detach();

        return pEntity;
    }

    public static IT_KykKihon detachKykSyaHhknSyaKykSyouhntouched(IT_KykKihon pEntity) {

        if (pEntity == null) {

            return pEntity;
        }
        pEntity.getKykSya();
        pEntity.getHhknSya();
        pEntity.getKykSyouhns().size();

        pEntity.detach();
        return pEntity;
    }

    public static IT_KykKihon detachKykDairitentouched(IT_KykKihon pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.getKykDairitens().size();

        pEntity.detach();

        return pEntity;
    }

    public static IT_KykKihon detachKhTtdkRirekitouched(IT_KykKihon pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.getKhTtdkRirekis().size();

        pEntity.detach();

        return pEntity;
    }

    public static IT_KykKihon detachKykUkttouched(IT_KykKihon pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.getKykUkts().size();

        pEntity.detach();

        return pEntity;
    }
    public static IT_KykKihon detachKykSyatouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.getKykSya();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static IT_KykKihon detachKykKihontouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static List<IT_KykKihon> detachKykSyatouched(List<IT_KykKihon> pEntityList) {

        for (IT_KykKihon entity : pEntityList) {

            if (entity != null) {

                entity.getKykSya();

                entity.detach();
            }
            else {

                continue;
            }
        }

        return pEntityList;
    }

    public static IT_KykKihon detachKhShrRirekitouched(IT_KykKihon pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        List<IT_KhTtdkRireki> khTtdkRirekiLst = pEntity.getKhTtdkRirekis();

        for(IT_KhTtdkRireki IT_KhTtdkRireki: khTtdkRirekiLst){

            IT_KhTtdkRireki.getKhShrRirekis().size();
        }

        pEntity.detach();
        return pEntity;
    }

    public static IT_KykKihon detachKoujyoSymtouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.getKoujyoSyms().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
    public static IT_KykKihon detachNyknJissekiRirekitouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.getNyknJissekiRirekis().size();
            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static IT_KykKihon detachKykSonotaTkyktouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.getKykSonotaTkyk();
            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static IT_KykKihon detachKhTtdkTyuuitouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.getKhTtdkTyuui();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
    public static IT_KykKihon detachTesuuryouSyouhnRirekitouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            List<IT_Tesuuryou> tesuuryouLst = pEntity.getTesuuryous();

            for (IT_Tesuuryou tesuuryou : tesuuryouLst) {

                if (tesuuryou != null) {

                    tesuuryou.getTesuuryouSyouhnRirekis().size();
                }
            }

            pEntity.detach();
            return pEntity;

        }
        return null;
    }
    public static IT_KykKihon detachKykSyaHoka5tablestouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.getKykSya();
            pEntity.getHhknSya();
            pEntity.getKykUkts().size();
            pEntity.getKykSonotaTkyk();
            pEntity.getNyknJissekiRirekis().size();
            pEntity.getKykSyouhns().size();


            pEntity.detach();
            return pEntity;
        }
        return null;
    }

    public static IT_KykKihon detachKykSyouhnKykDairitenKykSyaKouzatouched(IT_KykKihon pEntity){

        if(pEntity != null){

            pEntity.getKykSyouhns().size();

            pEntity.getKykDairitens().size();

            pEntity.getKykSya();

            pEntity.getKouza();

            pEntity.detach();

            return pEntity;

        }
        return null;

    }

    public static IT_KykKihon detachKouzatouched(IT_KykKihon pEntity){

        if(pEntity != null){

            pEntity.getKouza();

            pEntity.detach();

            return pEntity;
        }
        return null;

    }

    public static IT_KykKihon detachKhGwKykInfotouched(IT_KykKihon pEntity) {

        if (pEntity == null) {

            return pEntity;
        }

        pEntity.getKykDairitens().size();

        pEntity.getKykUkts().size();

        pEntity.getNyknJissekiRirekis().size();

        pEntity.getTrkKzks().size();

        pEntity.getKouza();

        List<IT_KhTtdkRireki> khTtdkRirekiLst = pEntity.getKhTtdkRirekis();

        for(IT_KhTtdkRireki IT_KhTtdkRireki: khTtdkRirekiLst){

            IT_KhTtdkRireki.getKhShrRirekis().size();
        }

        pEntity.detach();

        return pEntity;
    }

    public static IT_KykKihon detachHokenSyoukentouched(IT_KykKihon pEntity){

        if(pEntity != null){

            pEntity.getHokenSyoukens().size();

            pEntity.detach();

            return pEntity;
        }
        return null;

    }
}
