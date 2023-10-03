package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

import com.google.common.base.Strings;

import yuyu.def.db.entity.ZT_KaiykHrSoutougakuTy;

/**
 * 数理統計 数理統計 解約返戻金相当額Fテーブル（中）コンバーター
 */
public class SrKaiyakuHenreikinConverter {

    public static void convertPadding(ZT_KaiykHrSoutougakuTy pZtKaiykHrSoutougakuTy) {

        pZtKaiykHrSoutougakuTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pZtKaiykHrSoutougakuTy.setZtykyksyanen(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtykyksyanen(), 2, '0'));
        pZtKaiykHrSoutougakuTy.setZtykeikatukisuu(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtykeikatukisuu(), 2, '0'));
        pZtKaiykHrSoutougakuTy.setZtysaimnkkykhyj(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtysaimnkkykhyj(), 1, '0'));
        pZtKaiykHrSoutougakuTy.setZtyjikaipjyuutouym(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtyjikaipjyuutouym(), 6, '0'));
        pZtKaiykHrSoutougakuTy.setZtytkjykbn(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtytkjykbn(), 1, '0'));
        pZtKaiykHrSoutougakuTy.setZtytokuyakuno(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtytokuyakuno(), 2, '0'));
        pZtKaiykHrSoutougakuTy.setZtykawaseratetekiyouymd(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtykawaseratetekiyouymd(), 8, '0'));
        pZtKaiykHrSoutougakuTy.setZtyphrkkikn(
            Strings.padStart(pZtKaiykHrSoutougakuTy.getZtyphrkkikn(), 2, '0'));
    }
}
