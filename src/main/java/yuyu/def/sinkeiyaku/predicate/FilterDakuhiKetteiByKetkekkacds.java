package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.db.entity.HT_DakuhiKettei;

import com.google.common.base.Predicate;

/**
 * 諾否決定テーブル用 Predicate<br />
 * 決定結果コードは（無条件、限界体承諾、延期（指示なし）、延期（数年後再診）、見合わせ、クーリングオフ、申込取消、有効期間経過）に満足する<br />
 */
public class FilterDakuhiKetteiByKetkekkacds implements Predicate<HT_DakuhiKettei> {

    public FilterDakuhiKetteiByKetkekkacds() {

        super();
    }

    @Override
    public boolean apply(HT_DakuhiKettei pKetkekkacd) {

        if (C_Ketkekkacd.MUJYOUKEN.equals(pKetkekkacd.getKetkekkacd())
                || C_Ketkekkacd.GENKAITAI_SYOUDAKU.equals(pKetkekkacd.getKetkekkacd())
                || C_Ketkekkacd.ENKI_SIJINASI.equals(pKetkekkacd.getKetkekkacd())
                || C_Ketkekkacd.ENKI_SUUNENGOSAISIN.equals(pKetkekkacd.getKetkekkacd())
                || C_Ketkekkacd.MIAWASE.equals(pKetkekkacd.getKetkekkacd())
                || C_Ketkekkacd.COOLINGOFF.equals(pKetkekkacd.getKetkekkacd())
                || C_Ketkekkacd.MOS_TORIKESI.equals(pKetkekkacd.getKetkekkacd())
                || C_Ketkekkacd.YUUKOUKKNKKA.equals(pKetkekkacd.getKetkekkacd())) {

            return true;
        }

        return false;
    }
}
