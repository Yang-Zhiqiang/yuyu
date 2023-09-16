package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 決算計上用株価指数連動保険事業費Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KsnKbkSsuRnduHknJigyohiTy extends AbstractExDBTable<ZT_KsnKbkSsuRnduHknJigyohiTy> {

    public GenQZT_KsnKbkSsuRnduHknJigyohiTy() {
        this("ZT_KsnKbkSsuRnduHknJigyohiTy");
    }

    public GenQZT_KsnKbkSsuRnduHknJigyohiTy(String pAlias) {
        super("ZT_KsnKbkSsuRnduHknJigyohiTy", ZT_KsnKbkSsuRnduHknJigyohiTy.class, pAlias);
    }

    public String ZT_KsnKbkSsuRnduHknJigyohiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztynenkinkaisigohyouji = new ExDBFieldString<>("ztynenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztynksgokurikosidhyj = new ExDBFieldString<>("ztynksgokurikosidhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyidojiyukbn = new ExDBFieldString<>("ztyidojiyukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyzougenkbn = new ExDBFieldString<>("ztyzougenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyidourecordkbn = new ExDBFieldString<>("ztyidourecordkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykeijyouctrlkbn = new ExDBFieldString<>("ztykeijyouctrlkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztykykmfksnctr = new ExDBFieldNumber<>("ztykykmfksnctr", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztyrecordctr = new ExDBFieldNumber<>("ztyrecordctr", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyoukouryokukaisiymd = new ExDBFieldString<>("ztysuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztybluekeizokuhyouji = new ExDBFieldString<>("ztybluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytoukeikeijyoukbn = new ExDBFieldString<>("ztytoukeikeijyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyzenkiidouteiseikbn = new ExDBFieldString<>("ztyzenkiidouteiseikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkangokeiyakubosyuuym = new ExDBFieldString<>("ztytenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyidoujiyuucd = new ExDBFieldString<>("ztyidoujiyuucd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysekininteiseihyouji = new ExDBFieldString<>("ztysekininteiseihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysihankibikinkbn = new ExDBFieldString<>("ztysihankibikinkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin1x3 = new ExDBFieldString<>("ztysuuriyouyobin1x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhosyoukinoukbn = new ExDBFieldString<>("ztyhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydaikbn = new ExDBFieldString<>("ztydaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytyuukbn = new ExDBFieldString<>("ztytyuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysyoukbn = new ExDBFieldString<>("ztysyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysedaikbn = new ExDBFieldString<>("ztysedaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyao3tyou3sibousdatehyouji = new ExDBFieldString<>("ztyao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytkbthsyumnryuhyouji = new ExDBFieldString<>("ztytkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysyukeiyakupwaribikikbn = new ExDBFieldString<>("ztysyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanwaribikikbn = new ExDBFieldString<>("ztytenkanwaribikikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("ztyyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysiteizukisyukeiyakup = new ExDBFieldNumber<>("ztysiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhenkougokihons = new ExDBFieldNumber<>("ztyhenkougokihons", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhenkougosibous = new ExDBFieldNumber<>("ztyhenkougosibous", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhenkouymd = new ExDBFieldString<>("ztyhenkouymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyentyoukikan = new ExDBFieldString<>("ztyentyoukikan", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyseizonkyuuhukinsiteimd = new ExDBFieldString<>("ztyseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysyukeiyakusiharaikingaku = new ExDBFieldNumber<>("ztysyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyatukaisisyatodouhukencd = new ExDBFieldString<>("ztyatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztytokuyakuhukasuu = new ExDBFieldNumber<>("ztytokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydi2hknkknikoujihisyaage = new ExDBFieldString<>("ztydi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrimnentyoumaephrkkkn = new ExDBFieldString<>("ztyhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrizmjhknsyukigousdkbn = new ExDBFieldString<>("ztyhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykrsgjhknsyukigousdkbn = new ExDBFieldString<>("ztykrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysotodasisyouhinkaiteikbn = new ExDBFieldString<>("ztysotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygoukeipbubuntenkans = new ExDBFieldNumber<>("ztygoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanteikisyuruikigou = new ExDBFieldString<>("ztytenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanteikikigousedaikbn = new ExDBFieldString<>("ztytenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytnkntiksotodasikusnkbn = new ExDBFieldString<>("ztytnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytnkntikstdspmenkbn = new ExDBFieldString<>("ztytnkntikstdspmenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanteikikigouyobi = new ExDBFieldString<>("ztytenkanteikikigouyobi", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanteikikikan = new ExDBFieldString<>("ztytenkanteikikikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytnknteikinkshrkkn = new ExDBFieldString<>("ztytnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytenkansiharaikingaku = new ExDBFieldNumber<>("ztytenkansiharaikingaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytnkntikshrkngk = new ExDBFieldNumber<>("ztytnkntikshrkngk", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygoukeitenkankakaku = new ExDBFieldNumber<>("ztygoukeitenkankakaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztytnknkhnbbnjyuturt = new ExDBFieldString<>("ztytnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztywnasigoukeitenkanteikis = new ExDBFieldNumber<>("ztywnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytnknteikikousinmnryouage = new ExDBFieldString<>("ztytnknteikikousinmnryouage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykanyujidatakanrino = new ExDBFieldString<>("ztykanyujidatakanrino", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykanyujikykymd = new ExDBFieldString<>("ztykanyujikykymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykanyuujihihokensyaage = new ExDBFieldString<>("ztykanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykanyuujitenkanhyouji = new ExDBFieldString<>("ztykanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhsyuikktminaosikaisu = new ExDBFieldString<>("ztyhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysknnjynbknsisnrt = new ExDBFieldString<>("ztysknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysakugenkikan = new ExDBFieldString<>("ztysakugenkikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysykyktkjyuryumsratehyj = new ExDBFieldString<>("ztysykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysykyktkjyuryumsrate = new ExDBFieldString<>("ztysykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2sakugenkikan = new ExDBFieldString<>("ztydai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytokuteibuijyoukenhyouji = new ExDBFieldString<>("ztytokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytokuteibuino1 = new ExDBFieldString<>("ztytokuteibuino1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhtnpkkn1 = new ExDBFieldString<>("ztyhtnpkkn1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytokuteibuino2 = new ExDBFieldString<>("ztytokuteibuino2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhtnpkkn2 = new ExDBFieldString<>("ztyhtnpkkn2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymhituiryuyutktbijyknhyj = new ExDBFieldString<>("ztymhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymuhaitouiryouyoutktbino1 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymuhaitouiryouyoutktbino2 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysiteizukipwarimasihyouji = new ExDBFieldString<>("ztysiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysiteimsykykpbairitu = new ExDBFieldString<>("ztysiteimsykykpbairitu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysykykkitmttvkeisanym = new ExDBFieldString<>("ztysykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("ztysykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztydftumitatekingaku = new ExDBFieldNumber<>("ztydftumitatekingaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztydftumimasikin = new ExDBFieldNumber<>("ztydftumimasikin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyvbubundftenkankakaku = new ExDBFieldNumber<>("ztyvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztydpbubundftenkankakaku = new ExDBFieldNumber<>("ztydpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztydftmttkngkitjbrbbn = new ExDBFieldNumber<>("ztydftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhendous = new ExDBFieldNumber<>("ztyhendous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhengakujigyounendomatucv = new ExDBFieldNumber<>("ztyhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyitibitjbrshrkngk = new ExDBFieldNumber<>("ztyitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygoukeicv = new ExDBFieldNumber<>("ztygoukeicv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyminasicv = new ExDBFieldNumber<>("ztyminasicv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyloanfund = new ExDBFieldNumber<>("ztyloanfund", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysaiteihosyougaku = new ExDBFieldNumber<>("ztysaiteihosyougaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhngksitihsyuyusykykp = new ExDBFieldNumber<>("ztyhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysiinkbn = new ExDBFieldString<>("ztysiinkbn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztymudkaimasikihons = new ExDBFieldNumber<>("ztymudkaimasikihons", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykaimasiymd = new ExDBFieldString<>("ztykaimasiymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykaimasikikan = new ExDBFieldString<>("ztykaimasikikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyhikitugikaimasis = new ExDBFieldNumber<>("ztyhikitugikaimasis", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztymudkaimasisiharaikingaku = new ExDBFieldNumber<>("ztymudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoukouryokukaisiymdx1 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszouhokensyuruikigoux1 = new ExDBFieldString<>("ztyszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoukigousedaikbnx1 = new ExDBFieldString<>("ztyszoukigousedaikbnx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoukikanx1 = new ExDBFieldString<>("ztyszoukikanx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszouhihokensyaagex1 = new ExDBFieldString<>("ztyszouhihokensyaagex1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoudai2hihknsyaagex1 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyzoukasx1 = new ExDBFieldNumber<>("ztyzoukasx1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyzennendozoukasx1 = new ExDBFieldNumber<>("ztyzennendozoukasx1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyszousiharaikingakux1 = new ExDBFieldNumber<>("ztyszousiharaikingakux1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoukouryokukaisiymdx2 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszouhokensyuruikigoux2 = new ExDBFieldString<>("ztyszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoukigousedaikbnx2 = new ExDBFieldString<>("ztyszoukigousedaikbnx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoukikanx2 = new ExDBFieldString<>("ztyszoukikanx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszouhihokensyaagex2 = new ExDBFieldString<>("ztyszouhihokensyaagex2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoudai2hihknsyaagex2 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyzoukasx2 = new ExDBFieldNumber<>("ztyzoukasx2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyzennendozoukasx2 = new ExDBFieldNumber<>("ztyzennendozoukasx2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyszousiharaikingakux2 = new ExDBFieldNumber<>("ztyszousiharaikingakux2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin1x5 = new ExDBFieldString<>("ztysuuriyouyobin1x5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin1x6 = new ExDBFieldString<>("ztysuuriyouyobin1x6", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrimngkizktkykpmenhyj = new ExDBFieldString<>("ztyhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymisyuustartym = new ExDBFieldString<>("ztymisyuustartym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymisyuukaisuu = new ExDBFieldString<>("ztymisyuukaisuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("ztyitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygyousekihyoujis = new ExDBFieldNumber<>("ztygyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysykykgyusekihyjs = new ExDBFieldNumber<>("ztysykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytenkangyousekihyoujis = new ExDBFieldNumber<>("ztytenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytnknteikigyousekihyjs = new ExDBFieldNumber<>("ztytnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytnkndpbbngyuskhyjs = new ExDBFieldNumber<>("ztytnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykykjyoutai = new ExDBFieldString<>("ztykykjyoutai", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymankiyoteikbn = new ExDBFieldString<>("ztymankiyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysykyktikmnkyoteikbn = new ExDBFieldString<>("ztysykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytnknsykykkhnmnkytikbn = new ExDBFieldString<>("ztytnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytnknsykyktikmnkytikbn = new ExDBFieldString<>("ztytnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanteikimankiyoteikbn = new ExDBFieldString<>("ztytenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoumankiyoteikbnx1 = new ExDBFieldString<>("ztyszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyszoumankiyoteikbnx2 = new ExDBFieldString<>("ztyszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyvestingmankiyoteikbn = new ExDBFieldString<>("ztyvestingmankiyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyvkeisanhyouji = new ExDBFieldString<>("ztyvkeisanhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytoukisinkeiyakuhyouji = new ExDBFieldString<>("ztytoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysykykhokenhoutekiyouhyj = new ExDBFieldString<>("ztysykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyytirrthndsysnmnskaisuu = new ExDBFieldString<>("ztyytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin3 = new ExDBFieldString<>("ztysuuriyouyobin3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin11 = new ExDBFieldString<>("ztysuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztywnasigoukeitenkankakaku = new ExDBFieldNumber<>("ztywnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytukibaraikansantokujyoup = new ExDBFieldNumber<>("ztytukibaraikansantokujyoup", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytnkngkykkssnkijyuym = new ExDBFieldString<>("ztytnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysaiteihosyouhyouji = new ExDBFieldString<>("ztysaiteihosyouhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin8x2 = new ExDBFieldString<>("ztysuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin14 = new ExDBFieldString<>("ztysuuriyouyobin14", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("ztyhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrimngtkykphrkkirkbn = new ExDBFieldString<>("ztyhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhrimngtkykpryurtkbn = new ExDBFieldString<>("ztyhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv13 = new ExDBFieldString<>("ztyyobiv13", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyidoujisaiteihosyoukngk = new ExDBFieldNumber<>("ztyidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyidoujisaiteihosyoucost = new ExDBFieldNumber<>("ztyidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysinhokenfundtumitatekin = new ExDBFieldNumber<>("ztysinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztymsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("ztymsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthndugtnkgetumatuv = new ExDBFieldNumber<>("ztyrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("ztyrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthendougatanksibous = new ExDBFieldNumber<>("ztyrrthendougatanksibous", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyalmyousohutomeisyoukbn = new ExDBFieldString<>("ztyalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysnkyksoftmeisyoukbn = new ExDBFieldString<>("ztysnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysoftmeisyoukbn = new ExDBFieldString<>("ztysoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykykjitokujyouarihyj = new ExDBFieldString<>("ztykykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysoujikeitenkankbn = new ExDBFieldString<>("ztysoujikeitenkankbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztynenkingatakbn = new ExDBFieldString<>("ztynenkingatakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyheiyoubaraikeiyakukbn = new ExDBFieldString<>("ztyheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztynenkinmaruteihukakbn = new ExDBFieldString<>("ztynenkinmaruteihukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysinseizonmrtiarihyj = new ExDBFieldString<>("ztysinseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysnkykyouibokijyukbn = new ExDBFieldString<>("ztysnkykyouibokijyukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytokusitujyuusitusetkbn = new ExDBFieldString<>("ztytokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("ztysiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztypmensugugtganhsyunshyj = new ExDBFieldString<>("ztypmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytkykgyousekihyjszerohyj = new ExDBFieldString<>("ztytkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin7 = new ExDBFieldString<>("ztysuuriyouyobin7", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysyussaikeitaikbn = new ExDBFieldString<>("ztysyussaikeitaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobiv8 = new ExDBFieldString<>("ztysuuriyouyobiv8", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysinsakbn = new ExDBFieldString<>("ztysinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2hihokensyasinsakbn = new ExDBFieldString<>("ztydai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2toukeiyousinsakbn = new ExDBFieldString<>("ztydai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyketteikijyunkanwakbn = new ExDBFieldString<>("ztyketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykihonsibouhyoukbn = new ExDBFieldString<>("ztykihonsibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyteikisibouhyoukbn = new ExDBFieldString<>("ztyteikisibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysonotasibouhyoukbn = new ExDBFieldString<>("ztysonotasibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymrarihyj = new ExDBFieldString<>("ztymrarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysentakujyouhouarihyouji = new ExDBFieldString<>("ztysentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydugktnknsntkhuhukbn = new ExDBFieldString<>("ztydugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyjidoukousinkykkanyuuymd = new ExDBFieldString<>("ztyjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysaikohtnknkykkykymd = new ExDBFieldString<>("ztysaikohtnknkykkykymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykousinmaesykyksburtkbn = new ExDBFieldString<>("ztykousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysaihokenno = new ExDBFieldString<>("ztysaihokenno", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2dakuhiketteikekkacd = new ExDBFieldString<>("ztydai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysiboukyuuhukin = new ExDBFieldNumber<>("ztysiboukyuuhukin", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyjyudthumeharaitkykhkhyj = new ExDBFieldString<>("ztyjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykituenhonsuu = new ExDBFieldString<>("ztykituenhonsuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymusentakukeiyakukbn = new ExDBFieldString<>("ztymusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv6x2 = new ExDBFieldString<>("ztyyobiv6x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztylivingneedssiharaihyouji = new ExDBFieldString<>("ztylivingneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztylnseikyuuymd = new ExDBFieldString<>("ztylnseikyuuymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztylnshrgenincd = new ExDBFieldString<>("ztylnshrgenincd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydai2dakuhiketteisyacd = new ExDBFieldString<>("ztydai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztygansapotokuyakuarihyouji = new ExDBFieldString<>("ztygansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztygnspshrhyj = new ExDBFieldString<>("ztygnspshrhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztygansaposeikyuuymd = new ExDBFieldString<>("ztygansaposeikyuuymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztygnspshrgenincd = new ExDBFieldString<>("ztygnspshrgenincd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytargetmokuhyouritu = new ExDBFieldString<>("ztytargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyautoswitchmokuhyouritu = new ExDBFieldString<>("ztyautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytumitatekinitenarihyj = new ExDBFieldString<>("ztytumitatekinitenarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytumitatekinitenkaisuu = new ExDBFieldString<>("ztytumitatekinitenkaisuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyknkuzusnzyrttekinendo = new ExDBFieldString<>("ztyknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyknkuzusnzyrtx2 = new ExDBFieldString<>("ztyknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyknkuzusnzyrtx3 = new ExDBFieldString<>("ztyknkuzusnzyrtx3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("ztysinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztytenkanjiknkuzusnzyrt = new ExDBFieldString<>("ztytenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykykjivithukusuukykhyj = new ExDBFieldString<>("ztykykjivithukusuukykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin9x2 = new ExDBFieldString<>("ztysuuriyouyobin9x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin10x7 = new ExDBFieldString<>("ztysuuriyouyobin10x7", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin10x8 = new ExDBFieldString<>("ztysuuriyouyobin10x8", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin10x9 = new ExDBFieldString<>("ztysuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytumitatekinitenbubun = new ExDBFieldNumber<>("ztytumitatekinitenbubun", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysagakusknnjynbknzndk = new ExDBFieldNumber<>("ztysagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x11 = new ExDBFieldNumber<>("ztyyobin11x11", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x12 = new ExDBFieldNumber<>("ztyyobin11x12", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x13 = new ExDBFieldNumber<>("ztyyobin11x13", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x14 = new ExDBFieldNumber<>("ztyyobin11x14", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x15 = new ExDBFieldNumber<>("ztyyobin11x15", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x16 = new ExDBFieldNumber<>("ztyyobin11x16", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x17 = new ExDBFieldNumber<>("ztyyobin11x17", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyzyrthntiyustatuskbnx2 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyzyrthntiyustatuskbnx3 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyzyrthntiyustatuskbnx4 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyzyrthntiyustatuskbnx5 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv15x2 = new ExDBFieldString<>("ztyyobiv15x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv15x3 = new ExDBFieldString<>("ztyyobiv15x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv15x4 = new ExDBFieldString<>("ztyyobiv15x4", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztykawaserate1 = new ExDBFieldString<>("ztykawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykawaseratetekiyouymd1 = new ExDBFieldString<>("ztykawaseratetekiyouymd1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztykawaserate2 = new ExDBFieldString<>("ztykawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykawaseratetekiyouymd2 = new ExDBFieldString<>("ztykawaseratetekiyouymd2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztykaiyakukoujyoritu = new ExDBFieldString<>("ztykaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztymvakeisankijyunymd = new ExDBFieldString<>("ztymvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyenkdtsbujsitihsyucost = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("ztyenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztykaigomaebaraitkykarihyj = new ExDBFieldString<>("ztykaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysiharaituukakbn = new ExDBFieldString<>("ztysiharaituukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztywyendttargetmokuhyouritu = new ExDBFieldString<>("ztywyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyteirituikouhyouji = new ExDBFieldString<>("ztyteirituikouhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin2x3 = new ExDBFieldString<>("ztysuuriyouyobin2x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin10x11 = new ExDBFieldString<>("ztysuuriyouyobin10x11", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztytykzenoutouymdsisuu = new ExDBFieldString<>("ztytykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztykimatusisuu = new ExDBFieldString<>("ztykimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyenkadatekihons = new ExDBFieldNumber<>("ztyyenkadatekihons", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysitihsyumegkdtsibous = new ExDBFieldNumber<>("ztysitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyenkdtssrentumitatekin = new ExDBFieldNumber<>("ztyenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztynksjitirttumitatekin = new ExDBFieldNumber<>("ztynksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykimatutirttumitatekin = new ExDBFieldNumber<>("ztykimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygaikadatejyuutoup = new ExDBFieldNumber<>("ztygaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyendttargetkijyunkingaku = new ExDBFieldNumber<>("ztyyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysitivkisnyukykjikwsrate = new ExDBFieldString<>("ztysitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysisuurentyokugotmttkn = new ExDBFieldNumber<>("ztysisuurentyokugotmttkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyyoteiririturironbase = new ExDBFieldString<>("ztyyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyyoteiriritujtnyknbase = new ExDBFieldString<>("ztyyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykihrkmpjtnyknbase = new ExDBFieldNumber<>("ztykihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztysyuptumitatekingsc = new ExDBFieldNumber<>("ztysyuptumitatekingsc", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyjikaipjyuutouym2 = new ExDBFieldString<>("ztyjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Integer> ztysuuriyobin9 = new ExDBFieldNumber<>("ztysuuriyobin9", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygessitumitatekin = new ExDBFieldNumber<>("ztygessitumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygaikadatetougetujuutoup = new ExDBFieldNumber<>("ztygaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykihrkmpmsukisymbase = new ExDBFieldNumber<>("ztykihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykeisanhanteiyoutmttkn = new ExDBFieldNumber<>("ztykeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygtmtv = new ExDBFieldNumber<>("ztygtmtv", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyzettaisibouritu = new ExDBFieldString<>("ztyzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysoutaisibouritu = new ExDBFieldString<>("ztysoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztysoutaikaiyakuritu = new ExDBFieldString<>("ztysoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyvhireilritu2 = new ExDBFieldString<>("ztyvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyphireialpha = new ExDBFieldString<>("ztyphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyphireibeta = new ExDBFieldString<>("ztyphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyphireiganma = new ExDBFieldString<>("ztyphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyphireilwrbkritu = new ExDBFieldString<>("ztyphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyyoteiriritumsukisymbase = new ExDBFieldString<>("ztyyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrrthnduhknvkiso = new ExDBFieldNumber<>("ztyrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykykkjmmvatyouseigow = new ExDBFieldNumber<>("ztykykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x39 = new ExDBFieldNumber<>("ztyyobin11x39", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x41 = new ExDBFieldNumber<>("ztyyobin11x41", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x42 = new ExDBFieldNumber<>("ztyyobin11x42", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x43 = new ExDBFieldNumber<>("ztyyobin11x43", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x44 = new ExDBFieldNumber<>("ztyyobin11x44", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x45 = new ExDBFieldNumber<>("ztyyobin11x45", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin15x3 = new ExDBFieldString<>("ztysuuriyouyobin15x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin15x4 = new ExDBFieldString<>("ztysuuriyouyobin15x4", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin15x5 = new ExDBFieldString<>("ztysuuriyouyobin15x5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin15x6 = new ExDBFieldString<>("ztysuuriyouyobin15x6", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv14 = new ExDBFieldString<>("ztyyobiv14", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyloadingkeijyoym = new ExDBFieldString<>("ztyloadingkeijyoym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysihankiksnydatahyj = new ExDBFieldString<>("ztysihankiksnydatahyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztygmkijyhyj = new ExDBFieldString<>("ztygmkijyhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin12 = new ExDBFieldString<>("ztysuuriyouyobin12", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x18 = new ExDBFieldNumber<>("ztyyobin11x18", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyvhireilkisnyukngkx1 = new ExDBFieldNumber<>("ztyvhireilkisnyukngkx1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x19 = new ExDBFieldNumber<>("ztyyobin11x19", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x20 = new ExDBFieldNumber<>("ztyyobin11x20", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x21 = new ExDBFieldNumber<>("ztyyobin11x21", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyvhireilkisnyukngkx2 = new ExDBFieldNumber<>("ztyvhireilkisnyukngkx2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x22 = new ExDBFieldNumber<>("ztyyobin11x22", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x23 = new ExDBFieldNumber<>("ztyyobin11x23", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyrpkeisanyousibous = new ExDBFieldNumber<>("ztyrpkeisanyousibous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykikens = new ExDBFieldNumber<>("ztykikens", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyvhireialpha = new ExDBFieldNumber<>("ztyvhireialpha", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyvhireibeta = new ExDBFieldNumber<>("ztyvhireibeta", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztykikenp = new ExDBFieldNumber<>("ztykikenp", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztyvhireilritu = new ExDBFieldString<>("ztyvhireilritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, BizNumber> ztykikenpritu = new ExDBFieldString<>("ztykikenpritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztytumimasimaew = new ExDBFieldNumber<>("ztytumimasimaew", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x25 = new ExDBFieldNumber<>("ztyyobin11x25", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x26 = new ExDBFieldNumber<>("ztyyobin11x26", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x27 = new ExDBFieldNumber<>("ztyyobin11x27", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x28 = new ExDBFieldNumber<>("ztyyobin11x28", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x29 = new ExDBFieldNumber<>("ztyyobin11x29", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x30 = new ExDBFieldNumber<>("ztyyobin11x30", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x31 = new ExDBFieldNumber<>("ztyyobin11x31", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiTy, Long> ztyyobin11x32 = new ExDBFieldNumber<>("ztyyobin11x32", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztysuuriyouyobin15 = new ExDBFieldString<>("ztysuuriyouyobin15", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiTy, String> ztyyobiv19 = new ExDBFieldString<>("ztyyobiv19", this);
}
