package yuyu.batch.biz.boss.bzhoyuujyunzouzougenfsks;

import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFTy;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ保有純増増減Ｆコンバーター
 */
public class BzHoyuuJyunzouZougenFSksConverter {

    public static void convertPadding(ZT_HoyuuJyunzouZougenFTy pHoyuuJyunzouZougenFTy) {

        pHoyuuJyunzouZougenFTy.setZtytantoukojincd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytantoukojincd(), 6, '0'));
        pHoyuuJyunzouZougenFTy.setZtytantousyasetteiym(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytantousyasetteiym(), 6, '0'));
        pHoyuuJyunzouZougenFTy.setZtykeijyousakikbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykeijyousakikbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykeijyousakisosiki(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykeijyousakisosiki(), 7, '0'));
        pHoyuuJyunzouZougenFTy.setZtykeijyouym(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykeijyouym(), 6, '0'));
        pHoyuuJyunzouZougenFTy.setZtydenymd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtydenymd(), 8, '0'));
        pHoyuuJyunzouZougenFTy.setZtytantoukeiyakukbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytantoukeiyakukbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykydatkikbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykydatkikbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysyono(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysyono(), 11, '0'));
        pHoyuuJyunzouZougenFTy.setZtybsyym(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtybsyym(), 6, '0'));
        pHoyuuJyunzouZougenFTy.setZtykykymd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykykymd(), 8, '0'));
        pHoyuuJyunzouZougenFTy.setZtysaisinbsyym(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysaisinbsyym(), 6, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv1(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv1(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv1x2(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv1x2(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykykniyutksytioukbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykykniyutksytioukbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv1x3(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv1x3(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyteisyuuhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyteisyuuhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyitijibryourouhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyitijibryourouhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtymrtihukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtymrtihukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyseizonmrtihukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyseizonmrtihukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyteigenmrtihukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyteigenmrtihukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysynymrtihukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysynymrtihukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtylivingneedstkykarihyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyreguardmrtihukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyreguardmrtihukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyreguardmrsyuhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyreguardmrsyuhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyvguardmrtihukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyvguardmrtihukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykaigonktkykhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykaigonktkykhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyhrkkaisuukbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyhrkkaisuukbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyannaifuyouriyuukbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyannaifuyouriyuukbn(), 2, '0'));
        pHoyuuJyunzouZougenFTy.setZtyanniskcd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyanniskcd(), 8, '0'));
        pHoyuuJyunzouZougenFTy.setZtytenkankaisuu(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytenkankaisuu(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysikkounyknkaisuu(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysikkounyknkaisuu(), 2, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv2(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv2(), 2, '0'));
        pHoyuuJyunzouZougenFTy.setZtyhhknnen2keta(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyhhknnen2keta(), 2, '0'));
        pHoyuuJyunzouZougenFTy.setZtyhhknseikbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyhhknseikbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyhjnkykhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyhjnkykhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyhjncd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyhjncd(), 9, '0'));
        pHoyuuJyunzouZougenFTy.setZtysyorisosikicd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysyorisosikicd(), 7, '0'));
        pHoyuuJyunzouZougenFTy.setZtytikusyokansisyakijyhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytikusyokansisyakijyhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykeizokutyuuihyouji(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykeizokutyuuihyouji(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtytyohkkeiyakutyuuikbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytyohkkeiyakutyuuikbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv1x4(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv1x4(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysuperknkuseikatupackhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysuperknkuseikatupackhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyjikokykhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyjikokykhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykikeiyakutyuuihyouji(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykikeiyakutyuuihyouji(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyclubsumiseikaiinkykkbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyclubsumiseikaiinkykkbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtygatkihmkknrkmaekykhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtygatkihmkknrkmaekykhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtygatkisetteikouhokykhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtygatkisetteikouhokykhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtybosyuu25keikahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtybosyuu25keikahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtytokuteidaisyokudanhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytokuteidaisyokudanhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyhoyuuikantsgkykhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyhoyuuikantsgkykhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtytokubeturuletikuhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytokubeturuletikuhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyfieldtantousyaarihyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyfieldtantousyaarihyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv1x5(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv1x5(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtycatkihmkknrkmaekykhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtycatkihmkknrkmaekykhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtycatkisetteikouhokykhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtycatkisetteikouhokykhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyseppankeijyoukbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyseppankeijyoukbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv6(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv6(), 6, '0'));
        pHoyuuJyunzouZougenFTy.setZtyfollowtantousyakbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyfollowtantousyakbn(), 2, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv7(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv7(), 7, '0'));
        pHoyuuJyunzouZougenFTy.setZtyhosyouminaosikaisuuv2(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyhosyouminaosikaisuuv2(), 2, '0'));
        pHoyuuJyunzouZougenFTy.setZtybnkttnknkbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtybnkttnknkbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtytenkangosyono(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytenkangosyono(), 11, '0'));
        pHoyuuJyunzouZougenFTy.setZtyqpackhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyqpackhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtytenkangoqpackhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytenkangoqpackhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysyuruihnkutkbttrtkhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysyuruihnkutkbttrtkhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtytnkngsyuhnkutkbttrtkhyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtytnkngsyuhnkutkbttrtkhyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykibanhikitugikbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykibanhikitugikbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv1x6(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv1x6(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysyoumetucd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysyoumetucd(), 4, '0'));
        pHoyuuJyunzouZougenFTy.setZtyjikaipjyuutouym(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyjikaipjyuutouym(), 6, '0'));
        pHoyuuJyunzouZougenFTy.setZtykaigomarusyuuhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykaigomarusyuuhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyyobiv1x7(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyyobiv1x7(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysyoritorikesihyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysyoritorikesihyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtynyuuintkykhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtynyuuintkykhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtynyuuintkykhukahyj20ijyou(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtynyuuintkykhukahyj20ijyou(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtynyuuintkykhukahyj5ijyou(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtynyuuintkykhukahyj5ijyou(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtymarusyotkykhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtymarusyotkykhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtymarujyuutkykhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtymarujyuutkykhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykakudaimaruitkykhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykakudaimaruitkykhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykakunyuutkykhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykakunyuutkykhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtymaruitkykhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtymaruitkykhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtystdairiseikyuutkykarihyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtystdairiseikyuutkykarihyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykensuuyuuguukbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykensuuyuuguukbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykaigosynyteikikbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykaigosynyteikikbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykaigosynyteikishrkskbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykaigosynyteikishrkskbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysiktsynymrtihukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysiktsynymrtihukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtysiktsynyteikikbn(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtysiktsynyteikikbn(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtylivguardhukahyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtylivguardhukahyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtyknkuzusnzyrttekitkarihyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtyknkuzusnzyrttekitkarihyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtybluekzjtkaisiymd(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtybluekzjtkaisiymd(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykykdrtkykarihyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykykdrtkykarihyj(), 1, '0'));
        pHoyuuJyunzouZougenFTy.setZtykzktourokuservicearihyj(Strings.padStart(pHoyuuJyunzouZougenFTy.getZtykzktourokuservicearihyj(), 1, '0'));


    }
}
