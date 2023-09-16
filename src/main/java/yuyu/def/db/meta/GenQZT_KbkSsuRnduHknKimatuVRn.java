package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknKimatuVRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 株価指数連動保険期末ＶＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KbkSsuRnduHknKimatuVRn extends AbstractExDBTable<ZT_KbkSsuRnduHknKimatuVRn> {

    public GenQZT_KbkSsuRnduHknKimatuVRn() {
        this("ZT_KbkSsuRnduHknKimatuVRn");
    }

    public GenQZT_KbkSsuRnduHknKimatuVRn(String pAlias) {
        super("ZT_KbkSsuRnduHknKimatuVRn", ZT_KbkSsuRnduHknKimatuVRn.class, pAlias);
    }

    public String ZT_KbkSsuRnduHknKimatuVRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnnenkinkaisigohyouji = new ExDBFieldString<>("zrnnenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnnksgokurikosidhyj = new ExDBFieldString<>("zrnnksgokurikosidhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnidojiyukbn = new ExDBFieldString<>("zrnidojiyukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnzougenkbn = new ExDBFieldString<>("zrnzougenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnidourecordkbn = new ExDBFieldString<>("zrnidourecordkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkeijyouctrlkbn = new ExDBFieldString<>("zrnkeijyouctrlkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhenkousyoriymd = new ExDBFieldString<>("zrnhenkousyoriymd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrnkykmfksnctr = new ExDBFieldNumber<>("zrnkykmfksnctr", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrnrecordctr = new ExDBFieldNumber<>("zrnrecordctr", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyoukouryokukaisiymd = new ExDBFieldString<>("zrnsuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnbluekeizokuhyouji = new ExDBFieldString<>("zrnbluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin1x2 = new ExDBFieldString<>("zrnsuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntoukeikeijyoukbn = new ExDBFieldString<>("zrntoukeikeijyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnzenkiidouteiseikbn = new ExDBFieldString<>("zrnzenkiidouteiseikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkangokeiyakubosyuuym = new ExDBFieldString<>("zrntenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnidoujiyuucd = new ExDBFieldString<>("zrnidoujiyuucd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsekininteiseihyouji = new ExDBFieldString<>("zrnsekininteiseihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsihankibikinkbn = new ExDBFieldString<>("zrnsihankibikinkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin1x3 = new ExDBFieldString<>("zrnsuuriyouyobin1x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhosyoukinoukbn = new ExDBFieldString<>("zrnhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndaikbn = new ExDBFieldString<>("zrndaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntyuukbn = new ExDBFieldString<>("zrntyuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsyoukbn = new ExDBFieldString<>("zrnsyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsedaikbn = new ExDBFieldString<>("zrnsedaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnao3tyou3sibousdatehyouji = new ExDBFieldString<>("zrnao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntkbthsyumnryuhyouji = new ExDBFieldString<>("zrntkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsyukeiyakupwaribikikbn = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanwaribikikbn = new ExDBFieldString<>("zrntenkanwaribikikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("zrnyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntokujyoup = new ExDBFieldNumber<>("zrntokujyoup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsiteizukisyukeiyakup = new ExDBFieldNumber<>("zrnsiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhenkougokihons = new ExDBFieldNumber<>("zrnhenkougokihons", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhenkougosibous = new ExDBFieldNumber<>("zrnhenkougosibous", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhenkouymd = new ExDBFieldString<>("zrnhenkouymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnentyoukikan = new ExDBFieldString<>("zrnentyoukikan", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnseizonkyuuhukinsiteimd = new ExDBFieldString<>("zrnseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsyukeiyakusiharaikingaku = new ExDBFieldNumber<>("zrnsyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnatukaisisyatodouhukencd = new ExDBFieldString<>("zrnatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrntokuyakuhukasuu = new ExDBFieldNumber<>("zrntokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndi2hknkknikoujihisyaage = new ExDBFieldString<>("zrndi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrimnentyoumaephrkkkn = new ExDBFieldString<>("zrnhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkousinmanryouage = new ExDBFieldString<>("zrnkousinmanryouage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrizmjhknsyukigousdkbn = new ExDBFieldString<>("zrnhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkrsgjhknsyukigousdkbn = new ExDBFieldString<>("zrnkrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsotodasisyouhinkaiteikbn = new ExDBFieldString<>("zrnsotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngoukeitenkans = new ExDBFieldNumber<>("zrngoukeitenkans", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngoukeipbubuntenkans = new ExDBFieldNumber<>("zrngoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanteikisyuruikigou = new ExDBFieldString<>("zrntenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanteikikigousedaikbn = new ExDBFieldString<>("zrntenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntnkntiksotodasikusnkbn = new ExDBFieldString<>("zrntnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntnkntikstdspmenkbn = new ExDBFieldString<>("zrntnkntikstdspmenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanteikikigouyobi = new ExDBFieldString<>("zrntenkanteikikigouyobi", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanteikikikan = new ExDBFieldString<>("zrntenkanteikikikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngoukeitenkanteikis = new ExDBFieldNumber<>("zrngoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntnknteikinkshrkkn = new ExDBFieldString<>("zrntnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntenkansiharaikingaku = new ExDBFieldNumber<>("zrntenkansiharaikingaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntnkntikshrkngk = new ExDBFieldNumber<>("zrntnkntikshrkngk", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngoukeitenkankakaku = new ExDBFieldNumber<>("zrngoukeitenkankakaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrntnknkhnbbnjyuturt = new ExDBFieldString<>("zrntnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnwnasigoukeitenkanteikis = new ExDBFieldNumber<>("zrnwnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntnknteikikousinmnryouage = new ExDBFieldString<>("zrntnknteikikousinmnryouage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkanyujidatakanrino = new ExDBFieldString<>("zrnkanyujidatakanrino", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkanyujikykymd = new ExDBFieldString<>("zrnkanyujikykymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkanyuujihihokensyaage = new ExDBFieldString<>("zrnkanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkanyuujitenkanhyouji = new ExDBFieldString<>("zrnkanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhsyuikktminaosikaisu = new ExDBFieldString<>("zrnhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsknnjynbknsisnrt = new ExDBFieldString<>("zrnsknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsakugenkikan = new ExDBFieldString<>("zrnsakugenkikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrnryoumasihyouten = new ExDBFieldNumber<>("zrnryoumasihyouten", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsykyktkjyuryumsratehyj = new ExDBFieldString<>("zrnsykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsykyktkjyuryumsrate = new ExDBFieldString<>("zrnsykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2tokujyoukbn = new ExDBFieldString<>("zrndai2tokujyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2sakugenkikan = new ExDBFieldString<>("zrndai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrndai2ryoumasihyouten = new ExDBFieldNumber<>("zrndai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntokuteibuijyoukenhyouji = new ExDBFieldString<>("zrntokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntokuteibuino1 = new ExDBFieldString<>("zrntokuteibuino1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhtnpkkn1 = new ExDBFieldString<>("zrnhtnpkkn1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntokuteibuino2 = new ExDBFieldString<>("zrntokuteibuino2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhtnpkkn2 = new ExDBFieldString<>("zrnhtnpkkn2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmhituiryuyutktbijyknhyj = new ExDBFieldString<>("zrnmhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmuhaitouiryouyoutktbino1 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmuhaitouiryouyoutktbino2 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsiteizukipwarimasihyouji = new ExDBFieldString<>("zrnsiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnpwarimasisiteim1 = new ExDBFieldString<>("zrnpwarimasisiteim1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnpwarimasisiteim2 = new ExDBFieldString<>("zrnpwarimasisiteim2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsiteimsykykpbairitu = new ExDBFieldString<>("zrnsiteimsykykpbairitu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsaisyuusiteiym = new ExDBFieldString<>("zrnsaisyuusiteiym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsykykkitmttvkeisanym = new ExDBFieldString<>("zrnsykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("zrnsykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrndftumitatekingaku = new ExDBFieldNumber<>("zrndftumitatekingaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrndftumimasikin = new ExDBFieldNumber<>("zrndftumimasikin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnvbubundftenkankakaku = new ExDBFieldNumber<>("zrnvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrndpbubundftenkankakaku = new ExDBFieldNumber<>("zrndpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrndftmttkngkitjbrbbn = new ExDBFieldNumber<>("zrndftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhendous = new ExDBFieldNumber<>("zrnhendous", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhengakujigyounendomatucv = new ExDBFieldNumber<>("zrnhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnitibuitijibaraip = new ExDBFieldNumber<>("zrnitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnitibitjbrshrkngk = new ExDBFieldNumber<>("zrnitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngoukeicv = new ExDBFieldNumber<>("zrngoukeicv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnminasicv = new ExDBFieldNumber<>("zrnminasicv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnloanfund = new ExDBFieldNumber<>("zrnloanfund", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsaiteihosyougaku = new ExDBFieldNumber<>("zrnsaiteihosyougaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhngksitihsyuyusykykp = new ExDBFieldNumber<>("zrnhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsiinkbn = new ExDBFieldString<>("zrnsiinkbn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnmudkaimasikihons = new ExDBFieldNumber<>("zrnmudkaimasikihons", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkaimasiymd = new ExDBFieldString<>("zrnkaimasiymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkaimasikikan = new ExDBFieldString<>("zrnkaimasikikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnhikitugikaimasis = new ExDBFieldNumber<>("zrnhikitugikaimasis", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnmudkaimasisiharaikingaku = new ExDBFieldNumber<>("zrnmudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoukouryokukaisiymdx1 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszouhokensyuruikigoux1 = new ExDBFieldString<>("zrnszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoukigousedaikbnx1 = new ExDBFieldString<>("zrnszoukigousedaikbnx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoukikanx1 = new ExDBFieldString<>("zrnszoukikanx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszouhihokensyaagex1 = new ExDBFieldString<>("zrnszouhihokensyaagex1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoudai2hihknsyaagex1 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnzoukasx1 = new ExDBFieldNumber<>("zrnzoukasx1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnzennendozoukasx1 = new ExDBFieldNumber<>("zrnzennendozoukasx1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnszousiharaikingakux1 = new ExDBFieldNumber<>("zrnszousiharaikingakux1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoukouryokukaisiymdx2 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszouhokensyuruikigoux2 = new ExDBFieldString<>("zrnszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoukigousedaikbnx2 = new ExDBFieldString<>("zrnszoukigousedaikbnx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoukikanx2 = new ExDBFieldString<>("zrnszoukikanx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszouhihokensyaagex2 = new ExDBFieldString<>("zrnszouhihokensyaagex2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoudai2hihknsyaagex2 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnzoukasx2 = new ExDBFieldNumber<>("zrnzoukasx2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnzennendozoukasx2 = new ExDBFieldNumber<>("zrnzennendozoukasx2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnszousiharaikingakux2 = new ExDBFieldNumber<>("zrnszousiharaikingakux2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin1x5 = new ExDBFieldString<>("zrnsuuriyouyobin1x5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin1x6 = new ExDBFieldString<>("zrnsuuriyouyobin1x6", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrimngkizktkykpmenhyj = new ExDBFieldString<>("zrnhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmisyuustartym = new ExDBFieldString<>("zrnmisyuustartym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmisyuukaisuu = new ExDBFieldString<>("zrnmisyuukaisuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("zrnitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngyousekihyoujis = new ExDBFieldNumber<>("zrngyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsykykgyusekihyjs = new ExDBFieldNumber<>("zrnsykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntenkangyousekihyoujis = new ExDBFieldNumber<>("zrntenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntnknteikigyousekihyjs = new ExDBFieldNumber<>("zrntnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntnkndpbbngyuskhyjs = new ExDBFieldNumber<>("zrntnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkykjyoutai = new ExDBFieldString<>("zrnkykjyoutai", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkousinkbn = new ExDBFieldString<>("zrnkousinkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmankiyoteikbn = new ExDBFieldString<>("zrnmankiyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsykyktikmnkyoteikbn = new ExDBFieldString<>("zrnsykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntnknsykykkhnmnkytikbn = new ExDBFieldString<>("zrntnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntnknsykyktikmnkytikbn = new ExDBFieldString<>("zrntnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanteikimankiyoteikbn = new ExDBFieldString<>("zrntenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoumankiyoteikbnx1 = new ExDBFieldString<>("zrnszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnszoumankiyoteikbnx2 = new ExDBFieldString<>("zrnszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnvestingmankiyoteikbn = new ExDBFieldString<>("zrnvestingmankiyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnvkeisanhyouji = new ExDBFieldString<>("zrnvkeisanhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntoukisinkeiyakuhyouji = new ExDBFieldString<>("zrntoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsykykhokenhoutekiyouhyj = new ExDBFieldString<>("zrnsykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnytirrthndsysnmnskaisuu = new ExDBFieldString<>("zrnytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin3 = new ExDBFieldString<>("zrnsuuriyouyobin3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin11 = new ExDBFieldString<>("zrnsuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnwnasigoukeitenkankakaku = new ExDBFieldNumber<>("zrnwnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntukibaraikansantokujyoup = new ExDBFieldNumber<>("zrntukibaraikansantokujyoup", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntnkngkykkssnkijyuym = new ExDBFieldString<>("zrntnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsaiteihosyouhyouji = new ExDBFieldString<>("zrnsaiteihosyouhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin8x2 = new ExDBFieldString<>("zrnsuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin14 = new ExDBFieldString<>("zrnsuuriyouyobin14", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("zrnhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrimngtkykphrkkirkbn = new ExDBFieldString<>("zrnhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhrimngtkykpryurtkbn = new ExDBFieldString<>("zrnhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv13 = new ExDBFieldString<>("zrnyobiv13", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnidoujisaiteihosyoukngk = new ExDBFieldNumber<>("zrnidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnidoujisaiteihosyoucost = new ExDBFieldNumber<>("zrnidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsinhokenfundtumitatekin = new ExDBFieldNumber<>("zrnsinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnmsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("zrnmsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthndugtnkgetumatuv = new ExDBFieldNumber<>("zrnrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("zrnrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthendougatanksibous = new ExDBFieldNumber<>("zrnrrthendougatanksibous", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnalmyousohutomeisyoukbn = new ExDBFieldString<>("zrnalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsnkyksoftmeisyoukbn = new ExDBFieldString<>("zrnsnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsoftmeisyoukbn = new ExDBFieldString<>("zrnsoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkykjitokujyouarihyj = new ExDBFieldString<>("zrnkykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanminaosikbn = new ExDBFieldString<>("zrntenkanminaosikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsoujikeitenkankbn = new ExDBFieldString<>("zrnsoujikeitenkankbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnnenkingatakbn = new ExDBFieldString<>("zrnnenkingatakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnheiyoubaraikeiyakukbn = new ExDBFieldString<>("zrnheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnnenkinmaruteihukakbn = new ExDBFieldString<>("zrnnenkinmaruteihukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsinseizonmrtiarihyj = new ExDBFieldString<>("zrnsinseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsnkykyouibokijyukbn = new ExDBFieldString<>("zrnsnkykyouibokijyukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntokusitujyuusitusetkbn = new ExDBFieldString<>("zrntokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("zrnsiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnpmensugugtganhsyunshyj = new ExDBFieldString<>("zrnpmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntkykgyousekihyjszerohyj = new ExDBFieldString<>("zrntkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin7 = new ExDBFieldString<>("zrnsuuriyouyobin7", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsyussaikeitaikbn = new ExDBFieldString<>("zrnsyussaikeitaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobiv8 = new ExDBFieldString<>("zrnsuuriyouyobiv8", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsinsakbn = new ExDBFieldString<>("zrnsinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2hihokensyasinsakbn = new ExDBFieldString<>("zrndai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2toukeiyousinsakbn = new ExDBFieldString<>("zrndai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnketteikijyunkanwakbn = new ExDBFieldString<>("zrnketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkihonsibouhyoukbn = new ExDBFieldString<>("zrnkihonsibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnteikisibouhyoukbn = new ExDBFieldString<>("zrnteikisibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsonotasibouhyoukbn = new ExDBFieldString<>("zrnsonotasibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmrarihyj = new ExDBFieldString<>("zrnmrarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsentakujyouhouarihyouji = new ExDBFieldString<>("zrnsentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndugktnknsntkhuhukbn = new ExDBFieldString<>("zrndugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnjidoukousinkykkanyuuymd = new ExDBFieldString<>("zrnjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsaikohtnknkykkykymd = new ExDBFieldString<>("zrnsaikohtnknkykkykymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkousinmaesykyksburtkbn = new ExDBFieldString<>("zrnkousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhjncd = new ExDBFieldString<>("zrnhjncd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhjnjigyosyocd = new ExDBFieldString<>("zrnhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsaihokenno = new ExDBFieldString<>("zrnsaihokenno", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndakuhikettikekkacd = new ExDBFieldString<>("zrndakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2dakuhiketteikekkacd = new ExDBFieldString<>("zrndai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnpmenkbnv2 = new ExDBFieldString<>("zrnpmenkbnv2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsiboukyuuhukin = new ExDBFieldNumber<>("zrnsiboukyuuhukin", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnjyudthumeharaitkykhkhyj = new ExDBFieldString<>("zrnjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkyksyaagetyouseihyj = new ExDBFieldString<>("zrnkyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmusentakukeiyakukbn = new ExDBFieldString<>("zrnmusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv6x2 = new ExDBFieldString<>("zrnyobiv6x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnlivingneedssiharaihyouji = new ExDBFieldString<>("zrnlivingneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnlnseikyuuymd = new ExDBFieldString<>("zrnlnseikyuuymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnlnshrgenincd = new ExDBFieldString<>("zrnlnshrgenincd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndai2dakuhiketteisyacd = new ExDBFieldString<>("zrndai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrngansapotokuyakuarihyouji = new ExDBFieldString<>("zrngansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrngnspshrhyj = new ExDBFieldString<>("zrngnspshrhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrngansaposeikyuuymd = new ExDBFieldString<>("zrngansaposeikyuuymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrngnspshrgenincd = new ExDBFieldString<>("zrngnspshrgenincd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv3x2 = new ExDBFieldString<>("zrnyobiv3x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntargetmokuhyouritu = new ExDBFieldString<>("zrntargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnautoswitchmokuhyouritu = new ExDBFieldString<>("zrnautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntumitatekinitenarihyj = new ExDBFieldString<>("zrntumitatekinitenarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntumitatekinitenkaisuu = new ExDBFieldString<>("zrntumitatekinitenkaisuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndatakanrino2 = new ExDBFieldString<>("zrndatakanrino2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrndatakanrino3 = new ExDBFieldString<>("zrndatakanrino3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnknkuzusnzyrttekinendo = new ExDBFieldString<>("zrnknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnknkuzusnzyrtx2 = new ExDBFieldString<>("zrnknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnknkuzusnzyrtx3 = new ExDBFieldString<>("zrnknkuzusnzyrtx3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("zrnsinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntenkanjiknkuzusnzyrt = new ExDBFieldString<>("zrntenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsinkeiyakujivithkhyouji = new ExDBFieldString<>("zrnsinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkykjivithukusuukykhyj = new ExDBFieldString<>("zrnkykjivithukusuukykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin9x2 = new ExDBFieldString<>("zrnsuuriyouyobin9x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin9 = new ExDBFieldString<>("zrnsuuriyouyobin9", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin10x7 = new ExDBFieldString<>("zrnsuuriyouyobin10x7", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin10x8 = new ExDBFieldString<>("zrnsuuriyouyobin10x8", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin10x9 = new ExDBFieldString<>("zrnsuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntumitatekinitenbubun = new ExDBFieldNumber<>("zrntumitatekinitenbubun", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsagakusknnjynbknzndk = new ExDBFieldNumber<>("zrnsagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x10 = new ExDBFieldNumber<>("zrnyobin11x10", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x11 = new ExDBFieldNumber<>("zrnyobin11x11", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x12 = new ExDBFieldNumber<>("zrnyobin11x12", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x13 = new ExDBFieldNumber<>("zrnyobin11x13", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x14 = new ExDBFieldNumber<>("zrnyobin11x14", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x15 = new ExDBFieldNumber<>("zrnyobin11x15", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x16 = new ExDBFieldNumber<>("zrnyobin11x16", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x17 = new ExDBFieldNumber<>("zrnyobin11x17", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnzyrthntiyustatuskbnx2 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnzyrthntiyustatuskbnx3 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnzyrthntiyustatuskbnx4 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnzyrthntiyustatuskbnx5 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv15x2 = new ExDBFieldString<>("zrnyobiv15x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv15x3 = new ExDBFieldString<>("zrnyobiv15x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv15x4 = new ExDBFieldString<>("zrnyobiv15x4", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnkawaserate1 = new ExDBFieldString<>("zrnkawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkawaseratetekiyouymd1 = new ExDBFieldString<>("zrnkawaseratetekiyouymd1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnkawaserate2 = new ExDBFieldString<>("zrnkawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkawaseratetekiyouymd2 = new ExDBFieldString<>("zrnkawaseratetekiyouymd2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnkykjikawaserate = new ExDBFieldString<>("zrnkykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkykjikawaseratetkyuymd = new ExDBFieldString<>("zrnkykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnkaiyakukoujyoritu = new ExDBFieldString<>("zrnkaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("zrnsrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnmvakeisankijyunymd = new ExDBFieldString<>("zrnmvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnenkdtsbujsitihsyucost = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("zrnenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkaigomaebaraitkykarihyj = new ExDBFieldString<>("zrnkaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsibouhyoukbn = new ExDBFieldString<>("zrnsibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnnyuukintuukakbn = new ExDBFieldString<>("zrnnyuukintuukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsiharaituukakbn = new ExDBFieldString<>("zrnsiharaituukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnwyendttargetmokuhyouritu = new ExDBFieldString<>("zrnwyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnteirituikouhyouji = new ExDBFieldString<>("zrnteirituikouhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin2x3 = new ExDBFieldString<>("zrnsuuriyouyobin2x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin10x11 = new ExDBFieldString<>("zrnsuuriyouyobin10x11", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrntmttknzoukaritujygn = new ExDBFieldString<>("zrntmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsetteibairitu = new ExDBFieldString<>("zrnsetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrntykzenoutouymdsisuu = new ExDBFieldString<>("zrntykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnkimatusisuu = new ExDBFieldString<>("zrnkimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyenkadatekihons = new ExDBFieldNumber<>("zrnyenkadatekihons", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsitihsyumegkdtsibous = new ExDBFieldNumber<>("zrnsitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnenkdtssrentumitatekin = new ExDBFieldNumber<>("zrnenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsisuurentumitatekin = new ExDBFieldNumber<>("zrnsisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnnksjitirttumitatekin = new ExDBFieldNumber<>("zrnnksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkimatutirttumitatekin = new ExDBFieldNumber<>("zrnkimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngaikadatejyuutoup = new ExDBFieldNumber<>("zrngaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyendttargetkijyunkingaku = new ExDBFieldNumber<>("zrnyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsitivkisnyukykjikwsrate = new ExDBFieldString<>("zrnsitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsisuurentyokugotmttkn = new ExDBFieldNumber<>("zrnsisuurentyokugotmttkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnyoteiririturironbase = new ExDBFieldString<>("zrnyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnyoteiriritujtnyknbase = new ExDBFieldString<>("zrnyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkihrkmpjtnyknbase = new ExDBFieldNumber<>("zrnkihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsyuptumitatekin = new ExDBFieldNumber<>("zrnsyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnsyuptumitatekingsc = new ExDBFieldNumber<>("zrnsyuptumitatekingsc", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngaikadatenkgns = new ExDBFieldNumber<>("zrngaikadatenkgns", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnjikaipjyuutouym2 = new ExDBFieldString<>("zrnjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Integer> zrnsuuriyobin9 = new ExDBFieldNumber<>("zrnsuuriyobin9", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngessitumitatekin = new ExDBFieldNumber<>("zrngessitumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngaikadatetougetujuutoup = new ExDBFieldNumber<>("zrngaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkihrkmpmsukisymbase = new ExDBFieldNumber<>("zrnkihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkeisanhanteiyoutmttkn = new ExDBFieldNumber<>("zrnkeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngtmtv = new ExDBFieldNumber<>("zrngtmtv", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnzettaisibouritu = new ExDBFieldString<>("zrnzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsoutaisibouritu = new ExDBFieldString<>("zrnsoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnsoutaikaiyakuritu = new ExDBFieldString<>("zrnsoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnvhireilritu2 = new ExDBFieldString<>("zrnvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnphireialpha = new ExDBFieldString<>("zrnphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnphireibeta = new ExDBFieldString<>("zrnphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnphireiganma = new ExDBFieldString<>("zrnphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnphireilwrbkritu = new ExDBFieldString<>("zrnphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnyoteiriritumsukisymbase = new ExDBFieldString<>("zrnyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnrrthnduhknvkiso = new ExDBFieldNumber<>("zrnrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrntumitatekin = new ExDBFieldNumber<>("zrntumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkykkjmmvatyouseigow = new ExDBFieldNumber<>("zrnkykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x39 = new ExDBFieldNumber<>("zrnyobin11x39", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x41 = new ExDBFieldNumber<>("zrnyobin11x41", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x42 = new ExDBFieldNumber<>("zrnyobin11x42", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x43 = new ExDBFieldNumber<>("zrnyobin11x43", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x44 = new ExDBFieldNumber<>("zrnyobin11x44", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x45 = new ExDBFieldNumber<>("zrnyobin11x45", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin15x3 = new ExDBFieldString<>("zrnsuuriyouyobin15x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin15x4 = new ExDBFieldString<>("zrnsuuriyouyobin15x4", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin15x5 = new ExDBFieldString<>("zrnsuuriyouyobin15x5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin15x6 = new ExDBFieldString<>("zrnsuuriyouyobin15x6", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnvkimatutirttumitatekin = new ExDBFieldNumber<>("zrnvkimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkimatusisuutumitatekin = new ExDBFieldNumber<>("zrnkimatusisuutumitatekin", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnvyoutykzenoutouymdsisuu = new ExDBFieldString<>("zrnvyoutykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrntykzensisuukijyunymd = new ExDBFieldString<>("zrntykzensisuukijyunymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnvyoukimatusisuu = new ExDBFieldString<>("zrnvyoukimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnkmtsisuukijyunymd = new ExDBFieldString<>("zrnkmtsisuukijyunymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnvyoutmttknzoukaritujygn = new ExDBFieldString<>("zrnvyoutmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnvyousetteibairitu = new ExDBFieldString<>("zrnvyousetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, BizNumber> zrnvyourendouritu = new ExDBFieldString<>("zrnvyourendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin3x2 = new ExDBFieldString<>("zrnsuuriyouyobin3x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnkimatusisuutyokugotmttkn = new ExDBFieldNumber<>("zrnkimatusisuutyokugotmttkn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x19 = new ExDBFieldNumber<>("zrnyobin11x19", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x20 = new ExDBFieldNumber<>("zrnyobin11x20", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmttirttumitatekinnplus0 = new ExDBFieldNumber<>("zrnjmttirttumitatekinnplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmttirttumitatekinnplus1 = new ExDBFieldNumber<>("zrnjmttirttumitatekinnplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmttirttumitatekinnplus2 = new ExDBFieldNumber<>("zrnjmttirttumitatekinnplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtssutumitatekinnplus0 = new ExDBFieldNumber<>("zrnjmtssutumitatekinnplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtssutumitatekinnplus1 = new ExDBFieldNumber<>("zrnjmtssutumitatekinnplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtssutumitatekinnplus2 = new ExDBFieldNumber<>("zrnjmtssutumitatekinnplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtmvatyouseigownplus0 = new ExDBFieldNumber<>("zrnjmtmvatyouseigownplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtmvakeisanjiwnplus0 = new ExDBFieldNumber<>("zrnjmtmvakeisanjiwnplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtmvatyouseigownplus1 = new ExDBFieldNumber<>("zrnjmtmvatyouseigownplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtmvakeisanjiwnplus1 = new ExDBFieldNumber<>("zrnjmtmvakeisanjiwnplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtmvatyouseigownplus2 = new ExDBFieldNumber<>("zrnjmtmvatyouseigownplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnjmtmvakeisanjiwnplus2 = new ExDBFieldNumber<>("zrnjmtmvakeisanjiwnplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x21 = new ExDBFieldNumber<>("zrnyobin11x21", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x22 = new ExDBFieldNumber<>("zrnyobin11x22", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x23 = new ExDBFieldNumber<>("zrnyobin11x23", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x25 = new ExDBFieldNumber<>("zrnyobin11x25", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknKimatuVRn, Long> zrnyobin11x26 = new ExDBFieldNumber<>("zrnyobin11x26", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin15 = new ExDBFieldString<>("zrnsuuriyouyobin15", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnsuuriyouyobin15x2 = new ExDBFieldString<>("zrnsuuriyouyobin15x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv15 = new ExDBFieldString<>("zrnyobiv15", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknKimatuVRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);
}
