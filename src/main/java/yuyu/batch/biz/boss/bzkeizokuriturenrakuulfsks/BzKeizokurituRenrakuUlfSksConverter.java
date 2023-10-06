package yuyu.batch.biz.boss.bzkeizokuriturenrakuulfsks;

import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ通知履歴連動Ｆ作成コンバーター
 */
public class BzKeizokurituRenrakuUlfSksConverter {

    public static void convertPadding(ZT_KeizokurituRenrakuULFTy pKeizokurituRenrakuULFTy) {

        pKeizokurituRenrakuULFTy.setZtysyono(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysyono(), 11, '0'));
        pKeizokurituRenrakuULFTy.setZtyatukaikojincd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyatukaikojincd(), 6, '0'));
        pKeizokurituRenrakuULFTy.setZtybsyym(Strings.padStart(pKeizokurituRenrakuULFTy.getZtybsyym(), 6, '0'));
        pKeizokurituRenrakuULFTy.setZtyhknkkn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhknkkn(), 2, '0'));
        pKeizokurituRenrakuULFTy.setZtyphrkkikn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyphrkkikn(), 2, '0'));
        pKeizokurituRenrakuULFTy.setZtysaimnkkykhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysaimnkkykhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhrkkaisuukbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhrkkaisuukbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtytksyuannaikykkbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtytksyuannaikykkbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtysyukinkbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysyukinkbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyannaifuyouriyuukbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyannaifuyouriyuukbn(), 2, '0'));
        pKeizokurituRenrakuULFTy.setZtyanniskcd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyanniskcd(), 8, '0'));
        pKeizokurituRenrakuULFTy.setZtysyuukintantousosikicd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysyuukintantousosikicd(), 7, '0'));
        pKeizokurituRenrakuULFTy.setZtydnthrkkeirokbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtydnthrkkeirokbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykhyuukousyoumetukbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykhyuukousyoumetukbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykeikatukisuu(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykeikatukisuu(), 2, '0'));
        pKeizokurituRenrakuULFTy.setZtyatukaisosikicd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyatukaisosikicd(), 7, '0'));
        pKeizokurituRenrakuULFTy.setZtyhhknseikbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhhknseikbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhhknnen2keta(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhhknnen2keta(), 2, '0'));
        pKeizokurituRenrakuULFTy.setZtymarutokuhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtymarutokuhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtytyohktyouseihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtytyohktyouseihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtygyoumujyouhyouji(Strings.padStart(pKeizokurituRenrakuULFTy.getZtygyoumujyouhyouji(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykydatkihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykydatkihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtytenkankaisuu(Strings.padStart(pKeizokurituRenrakuULFTy.getZtytenkankaisuu(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykzktatkibanhktgksnkbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykzktatkibanhktgksnkbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyjidoukousinhyouji(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyjidoukousinhyouji(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyskeijimrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyskeijimrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyskeijikzkmrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyskeijikzkmrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhukkatukeiiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhukkatukeiiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtytyouhukutyouseiskeihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtytyouhukutyouseiskeihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyphkbnmnoshyouji(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyphkbnmnoshyouji(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykaigomarusyuuarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykaigomarusyuuarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyheiyoubaraikeiyakukbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhngkjidouentyoukbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhngkjidouentyoukbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhngkjidouentyoukikan(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhngkjidouentyoukikan(), 3, '0'));
        pKeizokurituRenrakuULFTy.setZtyyobiv1(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyyobiv1(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyseizonmrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyseizonmrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyteigenmrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyteigenmrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyaltourokukeiyakuhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyaltourokukeiyakuhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyjikokykhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyjikokykhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtysynymrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysynymrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyreguardmrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyreguardmrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyreguardmrsyuarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyreguardmrsyuarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyvguardmrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyvguardmrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykousintkykhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykousintkykhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykousinkakuninnasihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykousinkakuninnasihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyfollowhunouhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyfollowhunouhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykaigosynymrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykaigosynymrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykaigoteigenmrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykaigoteigenmrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtysuperknkuseikatupackhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysuperknkuseikatupackhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykaigonktkykarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykaigonktkykarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykaigomrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykaigomrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykeiyakukbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykeiyakukbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykeizokutyuuihyouji(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykeizokutyuuihyouji(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykikeiyakutyuuihyouji(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykikeiyakutyuuihyouji(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtybosyuunincd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtybosyuunincd(), 6, '0'));
        pKeizokurituRenrakuULFTy.setZtyhsyuikktminaosikaisu(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pKeizokurituRenrakuULFTy.setZtykykjiqpackhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykykjiqpackhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtybnkttnknkbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtybnkttnknkbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyyouikunktkykarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyyouikunktkykarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtysyoumetucd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysyoumetucd(), 4, '0'));
        pKeizokurituRenrakuULFTy.setZtyhitenkansyono1(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhitenkansyono1(), 11, '0'));
        pKeizokurituRenrakuULFTy.setZtyhitenkansyono2(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhitenkansyono2(), 11, '0'));
        pKeizokurituRenrakuULFTy.setZtyhitenkansyono3(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhitenkansyono3(), 11, '0'));
        pKeizokurituRenrakuULFTy.setZtyhitenkansyono4(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhitenkansyono4(), 11, '0'));
        pKeizokurituRenrakuULFTy.setZtyhitenkansyono5(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhitenkansyono5(), 11, '0'));
        pKeizokurituRenrakuULFTy.setZtyhitenkansyono6(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhitenkansyono6(), 11, '0'));
        pKeizokurituRenrakuULFTy.setZtykykym(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykykym(), 6, '0'));
        pKeizokurituRenrakuULFTy.setZtysytikbn(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysytikbn(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyjikaipjyuutouym(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyjikaipjyuutouym(), 6, '0'));
        pKeizokurituRenrakuULFTy.setZtysiktsynymrtiarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtysiktsynymrtiarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtylivguardarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtylivguardarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyknkuzusnzyrttekitkarihyj(Strings.padStart(pKeizokurituRenrakuULFTy. getZtyknkuzusnzyrttekitkarihyj(), 1,'0'));
        pKeizokurituRenrakuULFTy.setZtybluekzjtkaisiymd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtybluekzjtkaisiymd(), 8, '0'));
        pKeizokurituRenrakuULFTy.setZtytokuyakuno(Strings.padStart(pKeizokurituRenrakuULFTy.getZtytokuyakuno(), 2, '0'));
        pKeizokurituRenrakuULFTy.setZtyvityugusttkyuhyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyvityugusttkyuhyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykykdrtkykarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykykdrtkykarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtystdairiseikyuutkykarihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtystdairiseikyuutkykarihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtykzktourokuservicearihyj(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykzktourokuservicearihyj(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyyendthnkymd8keta(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyyendthnkymd8keta(), 8, '0'));
        pKeizokurituRenrakuULFTy.setZtykykymd(Strings.padStart(pKeizokurituRenrakuULFTy.getZtykykymd(), 8, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x1(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x1(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x2(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x2(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x3(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x3(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x4(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x4(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x5(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x5(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x6(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x6(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x7(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x7(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x8(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x8(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x9(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x9(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x10(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x10(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x11(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x11(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x12(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x12(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x13(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x13(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x14(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x14(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi1x15(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi1x15(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x1(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x1(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x2(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x2(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x3(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x3(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x4(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x4(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x5(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x5(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x6(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x6(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x7(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x7(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x8(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x8(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x9(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x9(), 1, '0'));
        pKeizokurituRenrakuULFTy.setZtyhokensyuruikigouyobi3x10(Strings.padStart(pKeizokurituRenrakuULFTy.getZtyhokensyuruikigouyobi3x10(), 1, '0'));

    }
}
