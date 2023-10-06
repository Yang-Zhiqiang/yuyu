package yuyu.batch.biz.boss.bzegsyokuinsysrendousks;

import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ営業職員システム連動Ｆコンバーター
 */
public class BzEgsyokuinSysRendouSksConverter {

    public static void convertPadding(ZT_EgsyokuinSysRendouTy pEgsyokuinSysRendouTy) {

        pEgsyokuinSysRendouTy.setZtyatukaikojincd(Strings.padStart(pEgsyokuinSysRendouTy.getZtyatukaikojincd(), 6, '0'));
        pEgsyokuinSysRendouTy.setZtysyono(Strings.padStart(pEgsyokuinSysRendouTy.getZtysyono(), 11, '0'));
        pEgsyokuinSysRendouTy.setZtyhknkkn(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhknkkn(), 2, '0'));
        pEgsyokuinSysRendouTy.setZtyphrkkikn(Strings.padStart(pEgsyokuinSysRendouTy.getZtyphrkkikn(), 2, '0'));
        pEgsyokuinSysRendouTy.setZtysaimnkkykhyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtysaimnkkykhyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtykykymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtykykymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtyannaifuyouriyuukbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtyannaifuyouriyuukbn(), 2, '0'));
        pEgsyokuinSysRendouTy.setZtyhrkkaisuukbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhrkkaisuukbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtysdpdkbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtysdpdkbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtykydatkikbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtykydatkikbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtybsyym(Strings.padStart(pEgsyokuinSysRendouTy.getZtybsyym(), 6, '0'));
        pEgsyokuinSysRendouTy.setZtyatukaisosikicd(Strings.padStart(pEgsyokuinSysRendouTy.getZtyatukaisosikicd(), 7, '0'));
        pEgsyokuinSysRendouTy.setZtyhhknseikbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhhknseikbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhhknnen2keta(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhhknnen2keta(), 2, '0'));
        pEgsyokuinSysRendouTy.setZtykyksyanen(Strings.padStart(pEgsyokuinSysRendouTy.getZtykyksyanen(), 2, '0'));
        pEgsyokuinSysRendouTy.setZtykurikosihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtykurikosihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtylivingneedstkykarihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtykyksyhhknsydouituhyouji(Strings.padStart(pEgsyokuinSysRendouTy.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhaitousiharaikbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhaitousiharaikbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtydairitenatkikeitaikbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtydairitenatkikeitaikbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtykjsakisosikisetteihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtykjsakisosikisetteihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtysimetyokuzenbosyuuhyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtysimetyokuzenbosyuuhyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtymosnyuuryokuymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtymosnyuuryokuymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtyhhknsakuinmeino(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhhknsakuinmeino(), 10, '0'));
        pEgsyokuinSysRendouTy.setZtytokusyujimutoriatukaikbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtytokusyujimutoriatukaikbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x1(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x1(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x2(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x2(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x3(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x3(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x4(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x4(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x5(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x5(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x6(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x6(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x7(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x7(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x8(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x8(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x9(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x9(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x10(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x10(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x11(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x11(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x12(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x12(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x13(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x13(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x14(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x14(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi1x15(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi1x15(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x1(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x1(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x2(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x2(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x3(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x3(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x4(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x4(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x5(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x5(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x6(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x6(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x7(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x7(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x8(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x8(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x9(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x9(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhokensyuruikigouyobi3x10(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhokensyuruikigouyobi3x10(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtynstkarihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtynstkarihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtymosno(Strings.padStart(pEgsyokuinSysRendouTy.getZtymosno(), 9, '0'));
        pEgsyokuinSysRendouTy.setZtystdairiseikyuutkykarihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtystdairiseikyuutkykarihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtykyksyaskinmeino(Strings.padStart(pEgsyokuinSysRendouTy.getZtykyksyaskinmeino(), 10, '0'));
        pEgsyokuinSysRendouTy.setZtysekininkaisiymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtysekininkaisiymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtykokutiymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtykokutiymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtysyokaipryosyuymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtysyokaipryosyuymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtyseirituymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtyseirituymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtybosyuunincd(Strings.padStart(pEgsyokuinSysRendouTy.getZtybosyuunincd(), 6, '0'));
        pEgsyokuinSysRendouTy.setZtydrtentsryhushrkykhyouji(Strings.padStart(pEgsyokuinSysRendouTy.getZtydrtentsryhushrkykhyouji(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtymdhnaisyoumeikbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtymdhnaisyoumeikbn(), 3, '0'));
        pEgsyokuinSysRendouTy.setZtyhensyuuyoukyksyaseikbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhensyuuyoukyksyaseikbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyhensyuuyoukyksyaseiymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhensyuuyoukyksyaseiymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtyhhknseiymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtyhhknseiymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtymusymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtymusymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtymossyosakuseiymd(Strings.padStart(pEgsyokuinSysRendouTy.getZtymossyosakuseiymd(), 8, '0'));
        pEgsyokuinSysRendouTy.setZtysyksbsitihsyutkykarihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtysyksbsitihsyutkykarihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyskkaigomaehrtkykarihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtyskkaigomaehrtkykarihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtyzenkizennouhyouji(Strings.padStart(pEgsyokuinSysRendouTy.getZtyzenkizennouhyouji(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtynknsnpssyhrkkskbn(Strings.padStart(pEgsyokuinSysRendouTy.getZtynknsnpssyhrkkskbn(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtykykdrtkykarihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtykykdrtkykarihyj(), 1, '0'));
        pEgsyokuinSysRendouTy.setZtykzktrkservicearihyj(Strings.padStart(pEgsyokuinSysRendouTy.getZtykzktrkservicearihyj(), 1, '0'));
    }
}
