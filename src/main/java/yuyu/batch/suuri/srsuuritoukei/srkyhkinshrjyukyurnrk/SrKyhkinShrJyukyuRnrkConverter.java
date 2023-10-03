package yuyu.batch.suuri.srsuuritoukei.srkyhkinshrjyukyurnrk;

import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;

import com.google.common.base.Strings;

/**
 * 数理統計 数理統計 給付金支払状況連絡情報作成のコンバータークラス
 */
public class SrKyhkinShrJyukyuRnrkConverter {

    public SrKyhkinShrJyukyuRnrkConverter() {
        super();
    }

    public static void convertPadding(ZT_KyhknShrJyoukyouRnrkTy pKyhknShrJyoukyouRnrkTy) {

        pKyhknShrJyoukyouRnrkTy.setZtyqpackhyj(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtyqpackhyj(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtysykgycd(Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtysykgycd(), 3, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtykawaseratetekiyouymd(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtykawaseratetekiyouymd(), 8, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtyihukutyakudatukahikbn(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtyihukutyakudatukahikbn(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtyfktrsmtkahikbn(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtyfktrsmtkahikbn(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtysykmtssyukahikbn(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtysykmtssyukahikbn(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtyngerkahikbn(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtyngerkahikbn(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtyseiketuseiyoukahikbn(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtyseiketuseiyoukahikbn(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtynyykkahikbn(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtynyykkahikbn(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtyhhknnentysihyj(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtyhhknnentysihyj(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtybyoumeicd1(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtybyoumeicd1(), 4, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtybyoumeicd2(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtybyoumeicd2(), 4, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtyhokoukahikbn(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtyhokoukahikbn(), 1, '0'));
        pKyhknShrJyoukyouRnrkTy.setZtymannenreihyj(
            Strings.padStart(pKyhknShrJyoukyouRnrkTy.getZtymannenreihyj(), 1, '0'));

    }
}
