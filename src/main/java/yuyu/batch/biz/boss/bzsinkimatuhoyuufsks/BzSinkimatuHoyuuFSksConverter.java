package yuyu.batch.biz.boss.bzsinkimatuhoyuufsks;

import yuyu.def.db.entity.ZT_SinkimatuHoyuuFTy;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ新期末保有Ｆコンバーター
 */
public class BzSinkimatuHoyuuFSksConverter {

    public static void convertPadding(ZT_SinkimatuHoyuuFTy pSinkimatuHoyuuFTy) {

        pSinkimatuHoyuuFTy.setZtytantoukojincd(Strings.padStart(pSinkimatuHoyuuFTy.getZtytantoukojincd(), 6, '0'));
        pSinkimatuHoyuuFTy.setZtytantousyasetteiym(Strings.padStart(pSinkimatuHoyuuFTy.getZtytantousyasetteiym(), 6, '0'));
        pSinkimatuHoyuuFTy.setZtykeijyousakikbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtykeijyousakikbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykeijyousakisosiki(Strings.padStart(pSinkimatuHoyuuFTy.getZtykeijyousakisosiki(), 7, '0'));
        pSinkimatuHoyuuFTy.setZtykeijyouym(Strings.padStart(pSinkimatuHoyuuFTy.getZtykeijyouym(), 6, '0'));
        pSinkimatuHoyuuFTy.setZtydenymd(Strings.padStart(pSinkimatuHoyuuFTy.getZtydenymd(), 8, '0'));
        pSinkimatuHoyuuFTy.setZtytantoukeiyakukbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtytantoukeiyakukbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykydatkikbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtykydatkikbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysyono(Strings.padStart(pSinkimatuHoyuuFTy.getZtysyono(), 11, '0'));
        pSinkimatuHoyuuFTy.setZtybsyym(Strings.padStart(pSinkimatuHoyuuFTy.getZtybsyym(), 6, '0'));
        pSinkimatuHoyuuFTy.setZtykykymd(Strings.padStart(pSinkimatuHoyuuFTy.getZtykykymd(), 8, '0'));
        pSinkimatuHoyuuFTy.setZtysaisinbsyym(Strings.padStart(pSinkimatuHoyuuFTy.getZtysaisinbsyym(), 6, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv1(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv1(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv1x2(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv1x2(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykykniyutksytioukbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtykykniyutksytioukbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv1x3(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv1x3(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyteisyuuhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyteisyuuhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyitijibryourouhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyitijibryourouhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtymrtihukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtymrtihukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyseizonmrtihukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyseizonmrtihukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyteigenmrtihukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyteigenmrtihukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysynymrtihukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtysynymrtihukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtylivingneedstkykarihyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyreguardmrtihukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyreguardmrtihukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyreguardmrsyuhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyreguardmrsyuhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyvguardmrtihukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyvguardmrtihukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykaigonktkykhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtykaigonktkykhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyhrkkaisuukbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtyhrkkaisuukbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyannaifuyouriyuukbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtyannaifuyouriyuukbn(), 2, '0'));
        pSinkimatuHoyuuFTy.setZtyanniskcd(Strings.padStart(pSinkimatuHoyuuFTy.getZtyanniskcd(), 8, '0'));
        pSinkimatuHoyuuFTy.setZtytenkankaisuu(Strings.padStart(pSinkimatuHoyuuFTy.getZtytenkankaisuu(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysikkounyknkaisuu(Strings.padStart(pSinkimatuHoyuuFTy.getZtysikkounyknkaisuu(), 2, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv2(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv2(), 2, '0'));
        pSinkimatuHoyuuFTy.setZtyhhknnen2keta(Strings.padStart(pSinkimatuHoyuuFTy.getZtyhhknnen2keta(), 2, '0'));
        pSinkimatuHoyuuFTy.setZtyhhknseikbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtyhhknseikbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyhjnkykhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyhjnkykhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyhjncd(Strings.padStart(pSinkimatuHoyuuFTy.getZtyhjncd(), 9, '0'));
        pSinkimatuHoyuuFTy.setZtysyorisosikicd(Strings.padStart(pSinkimatuHoyuuFTy.getZtysyorisosikicd(), 7, '0'));
        pSinkimatuHoyuuFTy.setZtytikusyokansisyakijyhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtytikusyokansisyakijyhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykeizokutyuuihyouji(Strings.padStart(pSinkimatuHoyuuFTy.getZtykeizokutyuuihyouji(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtytyohkkeiyakutyuuikbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtytyohkkeiyakutyuuikbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv1x4(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv1x4(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysuperknkuseikatupackhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtysuperknkuseikatupackhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyjikokykhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyjikokykhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykikeiyakutyuuihyouji(Strings.padStart(pSinkimatuHoyuuFTy.getZtykikeiyakutyuuihyouji(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyclubsumiseikaiinkykkbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtyclubsumiseikaiinkykkbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtygatkihmkknrkmaekykhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtygatkihmkknrkmaekykhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtygatkisetteikouhokykhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtygatkisetteikouhokykhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtybosyuu25keikahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtybosyuu25keikahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtytokuteidaisyokudanhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtytokuteidaisyokudanhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyhoyuuikantsgkykhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyhoyuuikantsgkykhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtytokubeturuletikuhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtytokubeturuletikuhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyfieldtantousyaarihyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyfieldtantousyaarihyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv1x5(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv1x5(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtycatkihmkknrkmaekykhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtycatkihmkknrkmaekykhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtycatkisetteikouhokykhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtycatkisetteikouhokykhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyseppankeijyoukbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtyseppankeijyoukbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv6(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv6(), 6, '0'));
        pSinkimatuHoyuuFTy.setZtyfollowtantousyakbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtyfollowtantousyakbn(), 2, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv7(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv7(), 7, '0'));
        pSinkimatuHoyuuFTy.setZtyhosyouminaosikaisuuv2(Strings.padStart(pSinkimatuHoyuuFTy.getZtyhosyouminaosikaisuuv2(), 2, '0'));
        pSinkimatuHoyuuFTy.setZtybnkttnknkbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtybnkttnknkbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtytenkangosyono(Strings.padStart(pSinkimatuHoyuuFTy.getZtytenkangosyono(), 11, '0'));
        pSinkimatuHoyuuFTy.setZtyqpackhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyqpackhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtytenkangoqpackhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtytenkangoqpackhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysyuruihnkutkbttrtkhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtysyuruihnkutkbttrtkhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtytnkngsyuhnkutkbttrtkhyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtytnkngsyuhnkutkbttrtkhyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykibanhikitugikbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtykibanhikitugikbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv1x6(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv1x6(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysyoumetucd(Strings.padStart(pSinkimatuHoyuuFTy.getZtysyoumetucd(), 4, '0'));
        pSinkimatuHoyuuFTy.setZtyjikaipjyuutouym(Strings.padStart(pSinkimatuHoyuuFTy.getZtyjikaipjyuutouym(), 6, '0'));
        pSinkimatuHoyuuFTy.setZtykaigomarusyuuhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtykaigomarusyuuhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyyobiv1x7(Strings.padStart(pSinkimatuHoyuuFTy.getZtyyobiv1x7(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysyoritorikesihyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtysyoritorikesihyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtynyuuintkykhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtynyuuintkykhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtynyuuintkykhukahyj20ijyou(Strings.padStart(pSinkimatuHoyuuFTy.getZtynyuuintkykhukahyj20ijyou(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtynyuuintkykhukahyj5ijyou(Strings.padStart(pSinkimatuHoyuuFTy.getZtynyuuintkykhukahyj5ijyou(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtymarusyotkykhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtymarusyotkykhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtymarujyuutkykhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtymarujyuutkykhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykakudaimaruitkykhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtykakudaimaruitkykhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykakunyuutkykhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtykakunyuutkykhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtymaruitkykhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtymaruitkykhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtystdairiseikyuutkykarihyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtystdairiseikyuutkykarihyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykensuuyuuguukbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtykensuuyuuguukbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykaigosynyteikikbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtykaigosynyteikikbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykaigosynyteikishrkskbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtykaigosynyteikishrkskbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysiktsynymrtihukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtysiktsynymrtihukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtysiktsynyteikikbn(Strings.padStart(pSinkimatuHoyuuFTy.getZtysiktsynyteikikbn(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtylivguardhukahyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtylivguardhukahyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtyknkuzusnzyrttekitkarihyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtyknkuzusnzyrttekitkarihyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtybluekzjtkaisiymd(Strings.padStart(pSinkimatuHoyuuFTy.getZtybluekzjtkaisiymd(), 8, '0'));
        pSinkimatuHoyuuFTy.setZtykykdrtkykarihyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtykykdrtkykarihyj(), 1, '0'));
        pSinkimatuHoyuuFTy.setZtykzktourokuservicearihyj(Strings.padStart(pSinkimatuHoyuuFTy.getZtykzktourokuservicearihyj(), 1, '0'));

    }
}
