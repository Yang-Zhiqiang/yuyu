package yuyu.batch.biz.boss.bzskipjissekifsks;

import yuyu.def.db.entity.ZT_SkIpJissekiTy;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ新契約インプット実績Ｆコンバーター
 */
public class BzSkIpJissekiFSksConverter {

    public static void convertPadding(ZT_SkIpJissekiTy pSkIpJissekiTy) {

        pSkIpJissekiTy.setZtymosym(Strings.padStart(pSkIpJissekiTy.getZtymosym(), 6, '0'));
        pSkIpJissekiTy.setZtyatukaikojincd(Strings.padStart(pSkIpJissekiTy.getZtyatukaikojincd(), 6, '0'));
        pSkIpJissekiTy.setZtydairitenatkikeitaikbn(Strings.padStart(pSkIpJissekiTy.getZtydairitenatkikeitaikbn(), 1, '0'));
        pSkIpJissekiTy.setZtykjsakininisetteihyj(Strings.padStart(pSkIpJissekiTy.getZtykjsakininisetteihyj(), 1, '0'));
        pSkIpJissekiTy.setZtymosno(Strings.padStart(pSkIpJissekiTy.getZtymosno(), 9, '0'));
        pSkIpJissekiTy.setZtykydatkikbn(Strings.padStart(pSkIpJissekiTy.getZtykydatkikbn(), 1, '0'));
        pSkIpJissekiTy.setZtymossyoumetukbn(Strings.padStart(pSkIpJissekiTy.getZtymossyoumetukbn(), 1, '0'));
        pSkIpJissekiTy.setZtyhknkkn(Strings.padStart(pSkIpJissekiTy.getZtyhknkkn(), 2, '0'));
        pSkIpJissekiTy.setZtyphrkkikn(Strings.padStart(pSkIpJissekiTy.getZtyphrkkikn(), 2, '0'));
        pSkIpJissekiTy.setZtyhhknseikbn(Strings.padStart(pSkIpJissekiTy.getZtyhhknseikbn(), 1, '0'));
        pSkIpJissekiTy.setZtyhhknnen2keta(Strings.padStart(pSkIpJissekiTy.getZtyhhknnen2keta(), 2, '0'));
        pSkIpJissekiTy.setZtykyksyanen(Strings.padStart(pSkIpJissekiTy.getZtykyksyanen(), 2, '0'));
        pSkIpJissekiTy.setZtyhrkkaisuukbn(Strings.padStart(pSkIpJissekiTy.getZtyhrkkaisuukbn(), 1, '0'));
        pSkIpJissekiTy.setZtykykktaikbn(Strings.padStart(pSkIpJissekiTy.getZtykykktaikbn(), 2, '0'));
        pSkIpJissekiTy.setZtyannaifuyouriyuukbn(Strings.padStart(pSkIpJissekiTy.getZtyannaifuyouriyuukbn(), 2, '0'));
        pSkIpJissekiTy.setZtyatukaisosikicd(Strings.padStart(pSkIpJissekiTy.getZtyatukaisosikicd(), 7, '0'));
        pSkIpJissekiTy.setZtytoukeiyousinsakbn(Strings.padStart(pSkIpJissekiTy.getZtytoukeiyousinsakbn(), 2, '0'));
        pSkIpJissekiTy.setZtysaimnkkykhyj(Strings.padStart(pSkIpJissekiTy.getZtysaimnkkykhyj(), 1, '0'));
        pSkIpJissekiTy.setZtysdpdkbn(Strings.padStart(pSkIpJissekiTy.getZtysdpdkbn(), 1, '0'));
        pSkIpJissekiTy.setZtykykymd(Strings.padStart(pSkIpJissekiTy.getZtykykymd(), 8, '0'));
        pSkIpJissekiTy.setZtymusymd(Strings.padStart(pSkIpJissekiTy.getZtymusymd(), 8, '0'));
        pSkIpJissekiTy.setZtymosnyuuryokuymd(Strings.padStart(pSkIpJissekiTy.getZtymosnyuuryokuymd(), 8, '0'));
        pSkIpJissekiTy.setZtysyokaipryosyuymd(Strings.padStart(pSkIpJissekiTy.getZtysyokaipryosyuymd(), 8, '0'));
        pSkIpJissekiTy.setZtyfstpnyknsyoriymd(Strings.padStart(pSkIpJissekiTy.getZtyfstpnyknsyoriymd(), 8, '0'));
        pSkIpJissekiTy.setZtykokutiymd(Strings.padStart(pSkIpJissekiTy.getZtykokutiymd(), 8, '0'));
        pSkIpJissekiTy.setZtymossyumtkktymd(Strings.padStart(pSkIpJissekiTy.getZtymossyumtkktymd(), 8, '0'));
        pSkIpJissekiTy.setZtysisyaketsyoriymd(Strings.padStart(pSkIpJissekiTy.getZtysisyaketsyoriymd(), 8, '0'));
        pSkIpJissekiTy.setZtymossyosakuseiymd(Strings.padStart(pSkIpJissekiTy.getZtymossyosakuseiymd(), 8, '0'));
        pSkIpJissekiTy.setZtyhhknsakuinmeino(Strings.padStart(pSkIpJissekiTy.getZtyhhknsakuinmeino(), 10, '0'));
        pSkIpJissekiTy.setZtyhaitousiharaikbn(Strings.padStart(pSkIpJissekiTy.getZtyhaitousiharaikbn(), 1, '0'));
        pSkIpJissekiTy.setZtyhubikbn(Strings.padStart(pSkIpJissekiTy.getZtyhubikbn(), 1, '0'));
        pSkIpJissekiTy.setZtysyono(Strings.padStart(pSkIpJissekiTy.getZtysyono(), 11, '0'));
        pSkIpJissekiTy.setZtyseisekiym(Strings.padStart(pSkIpJissekiTy.getZtyseisekiym(), 6, '0'));
        pSkIpJissekiTy.setZtytokusyujimutoriatukaikbn(Strings.padStart(pSkIpJissekiTy.getZtytokusyujimutoriatukaikbn(), 1, '0'));
        pSkIpJissekiTy.setZtykyksyaskinmeino(Strings.padStart(pSkIpJissekiTy.getZtykyksyaskinmeino(), 10, '0'));
        pSkIpJissekiTy.setZtymossakuseino(Strings.padStart(pSkIpJissekiTy.getZtymossakuseino(), 9, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x1(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x1(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x2(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x2(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x3(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x3(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x4(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x4(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x5(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x5(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x6(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x6(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x7(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x7(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x8(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x8(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x9(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x9(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x10(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x10(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x11(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x11(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x12(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x12(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x13(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x13(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x14(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x14(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi1x15(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi1x15(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x1(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x1(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x2(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x2(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x3(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x3(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x4(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x4(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x5(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x5(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x6(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x6(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x7(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x7(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x8(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x8(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x9(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x9(), 1, '0'));
        pSkIpJissekiTy.setZtyhokensyuruikigouyobi3x10(Strings.padStart(pSkIpJissekiTy.getZtyhokensyuruikigouyobi3x10(), 1, '0'));
        pSkIpJissekiTy.setZtynstkarihyj(Strings.padStart(pSkIpJissekiTy.getZtynstkarihyj(), 1, '0'));
        pSkIpJissekiTy.setZtystdairiseikyuutkykarihyj(Strings.padStart(pSkIpJissekiTy.getZtystdairiseikyuutkykarihyj(), 1, '0'));
        pSkIpJissekiTy.setZtydai1kyktdkkbn(Strings.padStart(pSkIpJissekiTy.getZtydai1kyktdkkbn(), 1, '0'));
        pSkIpJissekiTy.setZtymossyouninymd(Strings.padStart(pSkIpJissekiTy.getZtymossyouninymd(), 8, '0'));
        pSkIpJissekiTy.setZtyhhknseiymd(Strings.padStart(pSkIpJissekiTy.getZtyhhknseiymd(), 8, '0'));
        pSkIpJissekiTy.setZtyhensyuuyoukyksyaseiymd(Strings.padStart(pSkIpJissekiTy.getZtyhensyuuyoukyksyaseiymd(), 8, '0'));
        pSkIpJissekiTy.setZtysyksbsitihsyutkykarihyj(Strings.padStart(pSkIpJissekiTy.getZtysyksbsitihsyutkykarihyj(), 1, '0'));
        pSkIpJissekiTy.setZtyskkaigomaehrtkykarihyj(Strings.padStart(pSkIpJissekiTy.getZtyskkaigomaehrtkykarihyj(), 1, '0'));
        pSkIpJissekiTy.setZtyzenkizennouhyouji(Strings.padStart(pSkIpJissekiTy.getZtyzenkizennouhyouji(), 1, '0'));
        pSkIpJissekiTy.setZtynknsnpssyhrkkskbn(Strings.padStart(pSkIpJissekiTy.getZtynknsnpssyhrkkskbn(), 1, '0'));
        pSkIpJissekiTy.setZtykykdrtkykarihyj(Strings.padStart(pSkIpJissekiTy.getZtykykdrtkykarihyj(), 1, '0'));
        pSkIpJissekiTy.setZtykzktrkservicearihyj(Strings.padStart(pSkIpJissekiTy.getZtykzktrkservicearihyj(), 1, '0'));

    }
}
