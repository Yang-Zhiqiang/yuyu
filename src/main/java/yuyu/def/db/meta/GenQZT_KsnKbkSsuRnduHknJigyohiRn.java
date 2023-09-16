package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 決算計上用株価指数連動保険事業費Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KsnKbkSsuRnduHknJigyohiRn extends AbstractExDBTable<ZT_KsnKbkSsuRnduHknJigyohiRn> {

    public GenQZT_KsnKbkSsuRnduHknJigyohiRn() {
        this("ZT_KsnKbkSsuRnduHknJigyohiRn");
    }

    public GenQZT_KsnKbkSsuRnduHknJigyohiRn(String pAlias) {
        super("ZT_KsnKbkSsuRnduHknJigyohiRn", ZT_KsnKbkSsuRnduHknJigyohiRn.class, pAlias);
    }

    public String ZT_KsnKbkSsuRnduHknJigyohiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnnenkinkaisigohyouji = new ExDBFieldString<>("zrnnenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnnksgokurikosidhyj = new ExDBFieldString<>("zrnnksgokurikosidhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnidojiyukbn = new ExDBFieldString<>("zrnidojiyukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnzougenkbn = new ExDBFieldString<>("zrnzougenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnidourecordkbn = new ExDBFieldString<>("zrnidourecordkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkeijyouctrlkbn = new ExDBFieldString<>("zrnkeijyouctrlkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhenkousyoriymd = new ExDBFieldString<>("zrnhenkousyoriymd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrnkykmfksnctr = new ExDBFieldNumber<>("zrnkykmfksnctr", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrnrecordctr = new ExDBFieldNumber<>("zrnrecordctr", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyoukouryokukaisiymd = new ExDBFieldString<>("zrnsuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnbluekeizokuhyouji = new ExDBFieldString<>("zrnbluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin1x2 = new ExDBFieldString<>("zrnsuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntoukeikeijyoukbn = new ExDBFieldString<>("zrntoukeikeijyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnzenkiidouteiseikbn = new ExDBFieldString<>("zrnzenkiidouteiseikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkangokeiyakubosyuuym = new ExDBFieldString<>("zrntenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnidoujiyuucd = new ExDBFieldString<>("zrnidoujiyuucd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsekininteiseihyouji = new ExDBFieldString<>("zrnsekininteiseihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsihankibikinkbn = new ExDBFieldString<>("zrnsihankibikinkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin1x3 = new ExDBFieldString<>("zrnsuuriyouyobin1x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhosyoukinoukbn = new ExDBFieldString<>("zrnhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndaikbn = new ExDBFieldString<>("zrndaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntyuukbn = new ExDBFieldString<>("zrntyuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsyoukbn = new ExDBFieldString<>("zrnsyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsedaikbn = new ExDBFieldString<>("zrnsedaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnao3tyou3sibousdatehyouji = new ExDBFieldString<>("zrnao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntkbthsyumnryuhyouji = new ExDBFieldString<>("zrntkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsyukeiyakupwaribikikbn = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanwaribikikbn = new ExDBFieldString<>("zrntenkanwaribikikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("zrnyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntokujyoup = new ExDBFieldNumber<>("zrntokujyoup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsiteizukisyukeiyakup = new ExDBFieldNumber<>("zrnsiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhenkougokihons = new ExDBFieldNumber<>("zrnhenkougokihons", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhenkougosibous = new ExDBFieldNumber<>("zrnhenkougosibous", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhenkouymd = new ExDBFieldString<>("zrnhenkouymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnentyoukikan = new ExDBFieldString<>("zrnentyoukikan", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnseizonkyuuhukinsiteimd = new ExDBFieldString<>("zrnseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsyukeiyakusiharaikingaku = new ExDBFieldNumber<>("zrnsyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnatukaisisyatodouhukencd = new ExDBFieldString<>("zrnatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrntokuyakuhukasuu = new ExDBFieldNumber<>("zrntokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndi2hknkknikoujihisyaage = new ExDBFieldString<>("zrndi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrimnentyoumaephrkkkn = new ExDBFieldString<>("zrnhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkousinmanryouage = new ExDBFieldString<>("zrnkousinmanryouage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrizmjhknsyukigousdkbn = new ExDBFieldString<>("zrnhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkrsgjhknsyukigousdkbn = new ExDBFieldString<>("zrnkrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsotodasisyouhinkaiteikbn = new ExDBFieldString<>("zrnsotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngoukeitenkans = new ExDBFieldNumber<>("zrngoukeitenkans", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngoukeipbubuntenkans = new ExDBFieldNumber<>("zrngoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanteikisyuruikigou = new ExDBFieldString<>("zrntenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanteikikigousedaikbn = new ExDBFieldString<>("zrntenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntnkntiksotodasikusnkbn = new ExDBFieldString<>("zrntnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntnkntikstdspmenkbn = new ExDBFieldString<>("zrntnkntikstdspmenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanteikikigouyobi = new ExDBFieldString<>("zrntenkanteikikigouyobi", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanteikikikan = new ExDBFieldString<>("zrntenkanteikikikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngoukeitenkanteikis = new ExDBFieldNumber<>("zrngoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntnknteikinkshrkkn = new ExDBFieldString<>("zrntnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntenkansiharaikingaku = new ExDBFieldNumber<>("zrntenkansiharaikingaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntnkntikshrkngk = new ExDBFieldNumber<>("zrntnkntikshrkngk", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngoukeitenkankakaku = new ExDBFieldNumber<>("zrngoukeitenkankakaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrntnknkhnbbnjyuturt = new ExDBFieldString<>("zrntnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnwnasigoukeitenkanteikis = new ExDBFieldNumber<>("zrnwnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntnknteikikousinmnryouage = new ExDBFieldString<>("zrntnknteikikousinmnryouage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkanyujidatakanrino = new ExDBFieldString<>("zrnkanyujidatakanrino", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkanyujikykymd = new ExDBFieldString<>("zrnkanyujikykymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkanyuujihihokensyaage = new ExDBFieldString<>("zrnkanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkanyuujitenkanhyouji = new ExDBFieldString<>("zrnkanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhsyuikktminaosikaisu = new ExDBFieldString<>("zrnhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsknnjynbknsisnrt = new ExDBFieldString<>("zrnsknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsakugenkikan = new ExDBFieldString<>("zrnsakugenkikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrnryoumasihyouten = new ExDBFieldNumber<>("zrnryoumasihyouten", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsykyktkjyuryumsratehyj = new ExDBFieldString<>("zrnsykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsykyktkjyuryumsrate = new ExDBFieldString<>("zrnsykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2tokujyoukbn = new ExDBFieldString<>("zrndai2tokujyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2sakugenkikan = new ExDBFieldString<>("zrndai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrndai2ryoumasihyouten = new ExDBFieldNumber<>("zrndai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntokuteibuijyoukenhyouji = new ExDBFieldString<>("zrntokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntokuteibuino1 = new ExDBFieldString<>("zrntokuteibuino1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhtnpkkn1 = new ExDBFieldString<>("zrnhtnpkkn1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntokuteibuino2 = new ExDBFieldString<>("zrntokuteibuino2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhtnpkkn2 = new ExDBFieldString<>("zrnhtnpkkn2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmhituiryuyutktbijyknhyj = new ExDBFieldString<>("zrnmhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmuhaitouiryouyoutktbino1 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmuhaitouiryouyoutktbino2 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsiteizukipwarimasihyouji = new ExDBFieldString<>("zrnsiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnpwarimasisiteim1 = new ExDBFieldString<>("zrnpwarimasisiteim1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnpwarimasisiteim2 = new ExDBFieldString<>("zrnpwarimasisiteim2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsiteimsykykpbairitu = new ExDBFieldString<>("zrnsiteimsykykpbairitu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsaisyuusiteiym = new ExDBFieldString<>("zrnsaisyuusiteiym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsykykkitmttvkeisanym = new ExDBFieldString<>("zrnsykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("zrnsykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrndftumitatekingaku = new ExDBFieldNumber<>("zrndftumitatekingaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrndftumimasikin = new ExDBFieldNumber<>("zrndftumimasikin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnvbubundftenkankakaku = new ExDBFieldNumber<>("zrnvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrndpbubundftenkankakaku = new ExDBFieldNumber<>("zrndpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrndftmttkngkitjbrbbn = new ExDBFieldNumber<>("zrndftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhendous = new ExDBFieldNumber<>("zrnhendous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhengakujigyounendomatucv = new ExDBFieldNumber<>("zrnhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnitibuitijibaraip = new ExDBFieldNumber<>("zrnitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnitibitjbrshrkngk = new ExDBFieldNumber<>("zrnitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngoukeicv = new ExDBFieldNumber<>("zrngoukeicv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnminasicv = new ExDBFieldNumber<>("zrnminasicv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnloanfund = new ExDBFieldNumber<>("zrnloanfund", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsaiteihosyougaku = new ExDBFieldNumber<>("zrnsaiteihosyougaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhngksitihsyuyusykykp = new ExDBFieldNumber<>("zrnhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsiinkbn = new ExDBFieldString<>("zrnsiinkbn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnmudkaimasikihons = new ExDBFieldNumber<>("zrnmudkaimasikihons", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkaimasiymd = new ExDBFieldString<>("zrnkaimasiymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkaimasikikan = new ExDBFieldString<>("zrnkaimasikikan", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnhikitugikaimasis = new ExDBFieldNumber<>("zrnhikitugikaimasis", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnmudkaimasisiharaikingaku = new ExDBFieldNumber<>("zrnmudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoukouryokukaisiymdx1 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszouhokensyuruikigoux1 = new ExDBFieldString<>("zrnszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoukigousedaikbnx1 = new ExDBFieldString<>("zrnszoukigousedaikbnx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoukikanx1 = new ExDBFieldString<>("zrnszoukikanx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszouhihokensyaagex1 = new ExDBFieldString<>("zrnszouhihokensyaagex1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoudai2hihknsyaagex1 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnzoukasx1 = new ExDBFieldNumber<>("zrnzoukasx1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnzennendozoukasx1 = new ExDBFieldNumber<>("zrnzennendozoukasx1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnszousiharaikingakux1 = new ExDBFieldNumber<>("zrnszousiharaikingakux1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoukouryokukaisiymdx2 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszouhokensyuruikigoux2 = new ExDBFieldString<>("zrnszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoukigousedaikbnx2 = new ExDBFieldString<>("zrnszoukigousedaikbnx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoukikanx2 = new ExDBFieldString<>("zrnszoukikanx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszouhihokensyaagex2 = new ExDBFieldString<>("zrnszouhihokensyaagex2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoudai2hihknsyaagex2 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnzoukasx2 = new ExDBFieldNumber<>("zrnzoukasx2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnzennendozoukasx2 = new ExDBFieldNumber<>("zrnzennendozoukasx2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnszousiharaikingakux2 = new ExDBFieldNumber<>("zrnszousiharaikingakux2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin1x5 = new ExDBFieldString<>("zrnsuuriyouyobin1x5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin1x6 = new ExDBFieldString<>("zrnsuuriyouyobin1x6", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrimngkizktkykpmenhyj = new ExDBFieldString<>("zrnhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmisyuustartym = new ExDBFieldString<>("zrnmisyuustartym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmisyuukaisuu = new ExDBFieldString<>("zrnmisyuukaisuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("zrnitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngyousekihyoujis = new ExDBFieldNumber<>("zrngyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsykykgyusekihyjs = new ExDBFieldNumber<>("zrnsykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntenkangyousekihyoujis = new ExDBFieldNumber<>("zrntenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntnknteikigyousekihyjs = new ExDBFieldNumber<>("zrntnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntnkndpbbngyuskhyjs = new ExDBFieldNumber<>("zrntnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkykjyoutai = new ExDBFieldString<>("zrnkykjyoutai", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkousinkbn = new ExDBFieldString<>("zrnkousinkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmankiyoteikbn = new ExDBFieldString<>("zrnmankiyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsykyktikmnkyoteikbn = new ExDBFieldString<>("zrnsykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntnknsykykkhnmnkytikbn = new ExDBFieldString<>("zrntnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntnknsykyktikmnkytikbn = new ExDBFieldString<>("zrntnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanteikimankiyoteikbn = new ExDBFieldString<>("zrntenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoumankiyoteikbnx1 = new ExDBFieldString<>("zrnszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnszoumankiyoteikbnx2 = new ExDBFieldString<>("zrnszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnvestingmankiyoteikbn = new ExDBFieldString<>("zrnvestingmankiyoteikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnvkeisanhyouji = new ExDBFieldString<>("zrnvkeisanhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntoukisinkeiyakuhyouji = new ExDBFieldString<>("zrntoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsykykhokenhoutekiyouhyj = new ExDBFieldString<>("zrnsykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnytirrthndsysnmnskaisuu = new ExDBFieldString<>("zrnytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin3 = new ExDBFieldString<>("zrnsuuriyouyobin3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin11 = new ExDBFieldString<>("zrnsuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnwnasigoukeitenkankakaku = new ExDBFieldNumber<>("zrnwnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntukibaraikansantokujyoup = new ExDBFieldNumber<>("zrntukibaraikansantokujyoup", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntnkngkykkssnkijyuym = new ExDBFieldString<>("zrntnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsaiteihosyouhyouji = new ExDBFieldString<>("zrnsaiteihosyouhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin8x2 = new ExDBFieldString<>("zrnsuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin14 = new ExDBFieldString<>("zrnsuuriyouyobin14", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("zrnhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrimngtkykphrkkirkbn = new ExDBFieldString<>("zrnhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhrimngtkykpryurtkbn = new ExDBFieldString<>("zrnhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv13 = new ExDBFieldString<>("zrnyobiv13", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnidoujisaiteihosyoukngk = new ExDBFieldNumber<>("zrnidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnidoujisaiteihosyoucost = new ExDBFieldNumber<>("zrnidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsinhokenfundtumitatekin = new ExDBFieldNumber<>("zrnsinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnmsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("zrnmsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthndugtnkgetumatuv = new ExDBFieldNumber<>("zrnrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("zrnrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthendougatanksibous = new ExDBFieldNumber<>("zrnrrthendougatanksibous", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnalmyousohutomeisyoukbn = new ExDBFieldString<>("zrnalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsnkyksoftmeisyoukbn = new ExDBFieldString<>("zrnsnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsoftmeisyoukbn = new ExDBFieldString<>("zrnsoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkykjitokujyouarihyj = new ExDBFieldString<>("zrnkykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanminaosikbn = new ExDBFieldString<>("zrntenkanminaosikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsoujikeitenkankbn = new ExDBFieldString<>("zrnsoujikeitenkankbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnnenkingatakbn = new ExDBFieldString<>("zrnnenkingatakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnheiyoubaraikeiyakukbn = new ExDBFieldString<>("zrnheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnnenkinmaruteihukakbn = new ExDBFieldString<>("zrnnenkinmaruteihukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsinseizonmrtiarihyj = new ExDBFieldString<>("zrnsinseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsnkykyouibokijyukbn = new ExDBFieldString<>("zrnsnkykyouibokijyukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntokusitujyuusitusetkbn = new ExDBFieldString<>("zrntokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("zrnsiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnpmensugugtganhsyunshyj = new ExDBFieldString<>("zrnpmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntkykgyousekihyjszerohyj = new ExDBFieldString<>("zrntkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin7 = new ExDBFieldString<>("zrnsuuriyouyobin7", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsyussaikeitaikbn = new ExDBFieldString<>("zrnsyussaikeitaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobiv8 = new ExDBFieldString<>("zrnsuuriyouyobiv8", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsinsakbn = new ExDBFieldString<>("zrnsinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2hihokensyasinsakbn = new ExDBFieldString<>("zrndai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2toukeiyousinsakbn = new ExDBFieldString<>("zrndai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnketteikijyunkanwakbn = new ExDBFieldString<>("zrnketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkihonsibouhyoukbn = new ExDBFieldString<>("zrnkihonsibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnteikisibouhyoukbn = new ExDBFieldString<>("zrnteikisibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsonotasibouhyoukbn = new ExDBFieldString<>("zrnsonotasibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmrarihyj = new ExDBFieldString<>("zrnmrarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsentakujyouhouarihyouji = new ExDBFieldString<>("zrnsentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndugktnknsntkhuhukbn = new ExDBFieldString<>("zrndugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnjidoukousinkykkanyuuymd = new ExDBFieldString<>("zrnjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsaikohtnknkykkykymd = new ExDBFieldString<>("zrnsaikohtnknkykkykymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkousinmaesykyksburtkbn = new ExDBFieldString<>("zrnkousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhjncd = new ExDBFieldString<>("zrnhjncd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhjnjigyosyocd = new ExDBFieldString<>("zrnhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsaihokenno = new ExDBFieldString<>("zrnsaihokenno", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndakuhikettikekkacd = new ExDBFieldString<>("zrndakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2dakuhiketteikekkacd = new ExDBFieldString<>("zrndai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnpmenkbnv2 = new ExDBFieldString<>("zrnpmenkbnv2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsiboukyuuhukin = new ExDBFieldNumber<>("zrnsiboukyuuhukin", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnjyudthumeharaitkykhkhyj = new ExDBFieldString<>("zrnjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkyksyaagetyouseihyj = new ExDBFieldString<>("zrnkyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmusentakukeiyakukbn = new ExDBFieldString<>("zrnmusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv6x2 = new ExDBFieldString<>("zrnyobiv6x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnlivingneedssiharaihyouji = new ExDBFieldString<>("zrnlivingneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnlnseikyuuymd = new ExDBFieldString<>("zrnlnseikyuuymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnlnshrgenincd = new ExDBFieldString<>("zrnlnshrgenincd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndai2dakuhiketteisyacd = new ExDBFieldString<>("zrndai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrngansapotokuyakuarihyouji = new ExDBFieldString<>("zrngansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrngnspshrhyj = new ExDBFieldString<>("zrngnspshrhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrngansaposeikyuuymd = new ExDBFieldString<>("zrngansaposeikyuuymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrngnspshrgenincd = new ExDBFieldString<>("zrngnspshrgenincd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv3x2 = new ExDBFieldString<>("zrnyobiv3x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntargetmokuhyouritu = new ExDBFieldString<>("zrntargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnautoswitchmokuhyouritu = new ExDBFieldString<>("zrnautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntumitatekinitenarihyj = new ExDBFieldString<>("zrntumitatekinitenarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntumitatekinitenkaisuu = new ExDBFieldString<>("zrntumitatekinitenkaisuu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndatakanrino2 = new ExDBFieldString<>("zrndatakanrino2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrndatakanrino3 = new ExDBFieldString<>("zrndatakanrino3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnknkuzusnzyrttekinendo = new ExDBFieldString<>("zrnknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnknkuzusnzyrtx2 = new ExDBFieldString<>("zrnknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnknkuzusnzyrtx3 = new ExDBFieldString<>("zrnknkuzusnzyrtx3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("zrnsinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrntenkanjiknkuzusnzyrt = new ExDBFieldString<>("zrntenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsinkeiyakujivithkhyouji = new ExDBFieldString<>("zrnsinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkykjivithukusuukykhyj = new ExDBFieldString<>("zrnkykjivithukusuukykhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin9x2 = new ExDBFieldString<>("zrnsuuriyouyobin9x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin9 = new ExDBFieldString<>("zrnsuuriyouyobin9", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin10x7 = new ExDBFieldString<>("zrnsuuriyouyobin10x7", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin10x8 = new ExDBFieldString<>("zrnsuuriyouyobin10x8", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin10x9 = new ExDBFieldString<>("zrnsuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntumitatekinitenbubun = new ExDBFieldNumber<>("zrntumitatekinitenbubun", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsagakusknnjynbknzndk = new ExDBFieldNumber<>("zrnsagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x10 = new ExDBFieldNumber<>("zrnyobin11x10", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x11 = new ExDBFieldNumber<>("zrnyobin11x11", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x12 = new ExDBFieldNumber<>("zrnyobin11x12", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x13 = new ExDBFieldNumber<>("zrnyobin11x13", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x14 = new ExDBFieldNumber<>("zrnyobin11x14", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x15 = new ExDBFieldNumber<>("zrnyobin11x15", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x16 = new ExDBFieldNumber<>("zrnyobin11x16", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x17 = new ExDBFieldNumber<>("zrnyobin11x17", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnzyrthntiyustatuskbnx2 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnzyrthntiyustatuskbnx3 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnzyrthntiyustatuskbnx4 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnzyrthntiyustatuskbnx5 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv15x2 = new ExDBFieldString<>("zrnyobiv15x2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv15x3 = new ExDBFieldString<>("zrnyobiv15x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv15x4 = new ExDBFieldString<>("zrnyobiv15x4", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnkawaserate1 = new ExDBFieldString<>("zrnkawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkawaseratetekiyouymd1 = new ExDBFieldString<>("zrnkawaseratetekiyouymd1", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnkawaserate2 = new ExDBFieldString<>("zrnkawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkawaseratetekiyouymd2 = new ExDBFieldString<>("zrnkawaseratetekiyouymd2", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnkykjikawaserate = new ExDBFieldString<>("zrnkykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkykjikawaseratetkyuymd = new ExDBFieldString<>("zrnkykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnkaiyakukoujyoritu = new ExDBFieldString<>("zrnkaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("zrnsrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnmvakeisankijyunymd = new ExDBFieldString<>("zrnmvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnenkdtsbujsitihsyucost = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("zrnenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnkaigomaebaraitkykarihyj = new ExDBFieldString<>("zrnkaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsibouhyoukbn = new ExDBFieldString<>("zrnsibouhyoukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnnyuukintuukakbn = new ExDBFieldString<>("zrnnyuukintuukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsiharaituukakbn = new ExDBFieldString<>("zrnsiharaituukakbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnwyendttargetmokuhyouritu = new ExDBFieldString<>("zrnwyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnteirituikouhyouji = new ExDBFieldString<>("zrnteirituikouhyouji", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin2x3 = new ExDBFieldString<>("zrnsuuriyouyobin2x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin10x11 = new ExDBFieldString<>("zrnsuuriyouyobin10x11", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrntmttknzoukaritujygn = new ExDBFieldString<>("zrntmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsetteibairitu = new ExDBFieldString<>("zrnsetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrntykzenoutouymdsisuu = new ExDBFieldString<>("zrntykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnkimatusisuu = new ExDBFieldString<>("zrnkimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyenkadatekihons = new ExDBFieldNumber<>("zrnyenkadatekihons", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsitihsyumegkdtsibous = new ExDBFieldNumber<>("zrnsitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnenkdtssrentumitatekin = new ExDBFieldNumber<>("zrnenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsisuurentumitatekin = new ExDBFieldNumber<>("zrnsisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnnksjitirttumitatekin = new ExDBFieldNumber<>("zrnnksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkimatutirttumitatekin = new ExDBFieldNumber<>("zrnkimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngaikadatejyuutoup = new ExDBFieldNumber<>("zrngaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyendttargetkijyunkingaku = new ExDBFieldNumber<>("zrnyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsitivkisnyukykjikwsrate = new ExDBFieldString<>("zrnsitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsisuurentyokugotmttkn = new ExDBFieldNumber<>("zrnsisuurentyokugotmttkn", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnyoteiririturironbase = new ExDBFieldString<>("zrnyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnyoteiriritujtnyknbase = new ExDBFieldString<>("zrnyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkihrkmpjtnyknbase = new ExDBFieldNumber<>("zrnkihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsyuptumitatekin = new ExDBFieldNumber<>("zrnsyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnsyuptumitatekingsc = new ExDBFieldNumber<>("zrnsyuptumitatekingsc", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngaikadatenkgns = new ExDBFieldNumber<>("zrngaikadatenkgns", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnjikaipjyuutouym2 = new ExDBFieldString<>("zrnjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Integer> zrnsuuriyobin9 = new ExDBFieldNumber<>("zrnsuuriyobin9", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngessitumitatekin = new ExDBFieldNumber<>("zrngessitumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngaikadatetougetujuutoup = new ExDBFieldNumber<>("zrngaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkihrkmpmsukisymbase = new ExDBFieldNumber<>("zrnkihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkeisanhanteiyoutmttkn = new ExDBFieldNumber<>("zrnkeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngtmtv = new ExDBFieldNumber<>("zrngtmtv", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnzettaisibouritu = new ExDBFieldString<>("zrnzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsoutaisibouritu = new ExDBFieldString<>("zrnsoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnsoutaikaiyakuritu = new ExDBFieldString<>("zrnsoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnvhireilritu2 = new ExDBFieldString<>("zrnvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnphireialpha = new ExDBFieldString<>("zrnphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnphireibeta = new ExDBFieldString<>("zrnphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnphireiganma = new ExDBFieldString<>("zrnphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnphireilwrbkritu = new ExDBFieldString<>("zrnphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnyoteiriritumsukisymbase = new ExDBFieldString<>("zrnyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrrthnduhknvkiso = new ExDBFieldNumber<>("zrnrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntumitatekin = new ExDBFieldNumber<>("zrntumitatekin", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkykkjmmvatyouseigow = new ExDBFieldNumber<>("zrnkykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x39 = new ExDBFieldNumber<>("zrnyobin11x39", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x41 = new ExDBFieldNumber<>("zrnyobin11x41", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x42 = new ExDBFieldNumber<>("zrnyobin11x42", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x43 = new ExDBFieldNumber<>("zrnyobin11x43", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x44 = new ExDBFieldNumber<>("zrnyobin11x44", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x45 = new ExDBFieldNumber<>("zrnyobin11x45", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin15x3 = new ExDBFieldString<>("zrnsuuriyouyobin15x3", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin15x4 = new ExDBFieldString<>("zrnsuuriyouyobin15x4", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin15x5 = new ExDBFieldString<>("zrnsuuriyouyobin15x5", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin15x6 = new ExDBFieldString<>("zrnsuuriyouyobin15x6", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnloadingkeijyoym = new ExDBFieldString<>("zrnloadingkeijyoym", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsihankiksnydatahyj = new ExDBFieldString<>("zrnsihankiksnydatahyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrngmkijyhyj = new ExDBFieldString<>("zrngmkijyhyj", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin12 = new ExDBFieldString<>("zrnsuuriyouyobin12", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x18 = new ExDBFieldNumber<>("zrnyobin11x18", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnvhireilkisnyukngkx1 = new ExDBFieldNumber<>("zrnvhireilkisnyukngkx1", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x19 = new ExDBFieldNumber<>("zrnyobin11x19", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x20 = new ExDBFieldNumber<>("zrnyobin11x20", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x21 = new ExDBFieldNumber<>("zrnyobin11x21", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnvhireilkisnyukngkx2 = new ExDBFieldNumber<>("zrnvhireilkisnyukngkx2", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x22 = new ExDBFieldNumber<>("zrnyobin11x22", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x23 = new ExDBFieldNumber<>("zrnyobin11x23", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnrpkeisanyousibous = new ExDBFieldNumber<>("zrnrpkeisanyousibous", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkikens = new ExDBFieldNumber<>("zrnkikens", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnvhireialpha = new ExDBFieldNumber<>("zrnvhireialpha", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnvhireibeta = new ExDBFieldNumber<>("zrnvhireibeta", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnkikenp = new ExDBFieldNumber<>("zrnkikenp", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnvhireilritu = new ExDBFieldString<>("zrnvhireilritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, BizNumber> zrnkikenpritu = new ExDBFieldString<>("zrnkikenpritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrntumimasimaew = new ExDBFieldNumber<>("zrntumimasimaew", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x25 = new ExDBFieldNumber<>("zrnyobin11x25", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x26 = new ExDBFieldNumber<>("zrnyobin11x26", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x27 = new ExDBFieldNumber<>("zrnyobin11x27", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x28 = new ExDBFieldNumber<>("zrnyobin11x28", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x29 = new ExDBFieldNumber<>("zrnyobin11x29", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x30 = new ExDBFieldNumber<>("zrnyobin11x30", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x31 = new ExDBFieldNumber<>("zrnyobin11x31", this);

    public final ExDBFieldNumber<ZT_KsnKbkSsuRnduHknJigyohiRn, Long> zrnyobin11x32 = new ExDBFieldNumber<>("zrnyobin11x32", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnsuuriyouyobin15 = new ExDBFieldString<>("zrnsuuriyouyobin15", this);

    public final ExDBFieldString<ZT_KsnKbkSsuRnduHknJigyohiRn, String> zrnyobiv19 = new ExDBFieldString<>("zrnyobiv19", this);
}
