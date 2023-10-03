package yuyu.batch.suuri.srsuuritoukei.srjigyounendosikitkhoyuu;

import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;

import com.google.common.base.Strings;

/**
 * 数理 数理統計 事業年度式特約保有情報作成のコンバータークラス
 */
public class SrJigyounendosikiTkHoyuuConverter {

    public SrJigyounendosikiTkHoyuuConverter() {
        super();
    }

    public static void convertPadding(ZT_JigyounndsikiTkHoyuuTy pJigyounndsikiTkHoyuuTy) {

        pJigyounndsikiTkHoyuuTy.setZtyhhknhnsktodouhukencd(
            Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtyhhknhnsktodouhukencd(), 2, '0'));
        pJigyounndsikiTkHoyuuTy.setZtysykgycd(Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtysykgycd(), 3, '0'));
        pJigyounndsikiTkHoyuuTy.setZtyqpackhyj(
            Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtyqpackhyj(), 1, '0'));
        pJigyounndsikiTkHoyuuTy.setZtykawaseratetekiyouymd(
            Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtykawaseratetekiyouymd(), 8, '0'));
        pJigyounndsikiTkHoyuuTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pJigyounndsikiTkHoyuuTy.setZtytenkankaisuu(
            Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtytenkankaisuu(), 1, '0'));
        pJigyounndsikiTkHoyuuTy.setZtyhhknnentysihyj(
            Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtyhhknnentysihyj(), 1, '0'));
        pJigyounndsikiTkHoyuuTy.setZtymannenreihyj(
            Strings.padStart(pJigyounndsikiTkHoyuuTy.getZtymannenreihyj(), 1, '0'));

    }
}