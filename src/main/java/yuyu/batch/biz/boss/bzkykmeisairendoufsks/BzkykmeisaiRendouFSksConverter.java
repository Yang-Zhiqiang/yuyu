package yuyu.batch.biz.boss.bzkykmeisairendoufsks;

import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ契約明細連動Ｆコンバーター
 */
public class BzkykmeisaiRendouFSksConverter {

    public static void convertPadding(ZT_KokyakuYuyuKykmeisaiFTy pKokyakuYuyuKykmeisaiFTy) {

        pKokyakuYuyuKykmeisaiFTy.setZtysyono(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysyono(), 11, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhknkkn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhknkkn(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyphrkkikn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyphrkkikn(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysaimnkkykhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysaimnkkykhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysymtymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysymtymd(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyjyudkaigomehrtkarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyjyudkaigomehrtkarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtypmentokuyakukbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtypmentokuyakukbn(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykykdrtkykarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykykdrtkykarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykykymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykykymd(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtybsyym(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtybsyym(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykyksyaseiymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykyksyaseiymd(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykyksyanen3(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykyksyanen3(), 3, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykykjikyksyanen(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykykjikyksyanen(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytuusinsakihumeihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytuusinsakihumeihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytodouhukencd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytodouhukencd(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysikutyousoncd5(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysikutyousoncd5(), 5, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhhknseiymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhhknseiymd(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhhknnen(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhhknnen(), 3, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhhknseikbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhhknseikbn(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykykjihhknnen(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykykjihhknnen(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtymannenreikykhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtymannenreikykhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykyksyhhknsydouituhyouji(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykykjyutikbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykykjyutikbn(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyannaifuyouriyuukbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyannaifuyouriyuukbn(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysyoumetucd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysyoumetucd(), 4, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytorihikikaisiymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytorihikikaisiymd(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtypowerfulhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtypowerfulhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtylargehyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtylargehyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysyouhnnmkbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysyouhnnmkbn(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytkbthsyukiknmanryouym(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytkbthsyukiknmanryouym(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyldownym(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyldownym(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhrkmanryouym(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhrkmanryouym(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtymankiym(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtymankiym(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyrserieshyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyrserieshyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyduketorihouhoukbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyduketorihouhoukbn(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyinfoteikyoutsghyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyinfoteikyoutsghyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtynaimitukykhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtynaimitukykhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtymrarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtymrarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtykasitukenaimituhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtykasitukenaimituhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuuiarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuuiarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkacd1(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuuisetkacd1(), 3, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetymd1(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuuisetymd1(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkbn1(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuuisetkbn1(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkacd2(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuuisetkacd2(), 3, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetymd2(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuuisetymd2(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkbn2(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuuisetkbn2(), 2, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyttdktyuui3kenijyouhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyttdktyuui3kenijyouhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysentakujyouhouarihyouji(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysentakujyouhouarihyouji(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtystknsetkykhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtystknsetkykhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtycalckijyunymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtycalckijyunymd(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytumitatedzndkhunouhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytumitatedzndkhunouhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtydairitenatkihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtydairitenatkihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou1sisyacd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou1sisyacd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou1sibucd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou1sibucd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou1kojincd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou1kojincd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou1tantoukaisiymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou1tantoukaisiymd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou2sisyacd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou2sisyacd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou2sibucd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou2sibucd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou2kojincd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou2kojincd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytantou2tantoukaisiymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytantou2tantoukaisiymd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysikijikbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysikijikbn(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyteikyou1sosikicd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyteikyou1sosikicd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyteikyou1kojincd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyteikyou1kojincd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyteikyou2sosikicd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyteikyou2sosikicd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyteikyou2kojincd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyteikyou2kojincd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyadrsyokansisyacd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyadrsyokansisyacd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki1sosikicd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhyukjsaki1sosikicd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki1kojincd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhyukjsaki1kojincd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki2sosikicd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhyukjsaki2sosikicd(), 7, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki2kojincd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhyukjsaki2kojincd(), 6, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyinfotysytymd(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyinfotysytymd(), 8, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtystdairiseikyuutkykarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtystdairiseikyuutkykarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyhouteityotikuhknhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyhouteityotikuhknhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtydrctservicekbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtydrctservicekbn(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtysiteituukakbn(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtysiteituukakbn(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtymkhyouyenhknhentkarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtymkhyouyenhknhentkarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyyenkhrikmtkarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyyenkhrikmtkarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtystigihrikmtkarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtystigihrikmtkarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyyenshrgksitihsyutkhyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyyenshrgksitihsyutkhyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtyteikisiharaiarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtyteikisiharaiarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytrkkzk1trkarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytrkkzk1trkarihyj(), 1, '0'));
        pKokyakuYuyuKykmeisaiFTy.setZtytrkkzk2trkarihyj(Strings.padStart(pKokyakuYuyuKykmeisaiFTy.getZtytrkkzk2trkarihyj(), 1, '0'));

    }
}
