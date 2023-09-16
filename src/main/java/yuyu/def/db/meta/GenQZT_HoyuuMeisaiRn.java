package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_HoyuuMeisaiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 保有明細Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HoyuuMeisaiRn extends AbstractExDBTable<ZT_HoyuuMeisaiRn> {

    public GenQZT_HoyuuMeisaiRn() {
        this("ZT_HoyuuMeisaiRn");
    }

    public GenQZT_HoyuuMeisaiRn(String pAlias) {
        super("ZT_HoyuuMeisaiRn", ZT_HoyuuMeisaiRn.class, pAlias);
    }

    public String ZT_HoyuuMeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnnenkinkaisigohyouji = new ExDBFieldString<>("zrnnenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnnksgokurikosidhyj = new ExDBFieldString<>("zrnnksgokurikosidhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnidojiyukbn = new ExDBFieldString<>("zrnidojiyukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzougenkbn = new ExDBFieldString<>("zrnzougenkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnidourecordkbn = new ExDBFieldString<>("zrnidourecordkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkeijyouctrlkbn = new ExDBFieldString<>("zrnkeijyouctrlkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhenkousyoriymd = new ExDBFieldString<>("zrnhenkousyoriymd", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrnkykmfksnctr = new ExDBFieldNumber<>("zrnkykmfksnctr", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrnrecordctr = new ExDBFieldNumber<>("zrnrecordctr", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyoukouryokukaisiymd = new ExDBFieldString<>("zrnsuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnbluekeizokuhyouji = new ExDBFieldString<>("zrnbluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin1x2 = new ExDBFieldString<>("zrnsuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntoukeikeijyoukbn = new ExDBFieldString<>("zrntoukeikeijyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzenkiidouteiseikbn = new ExDBFieldString<>("zrnzenkiidouteiseikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkangokeiyakubosyuuym = new ExDBFieldString<>("zrntenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnidoujiyuucd = new ExDBFieldString<>("zrnidoujiyuucd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsekininteiseihyouji = new ExDBFieldString<>("zrnsekininteiseihyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsihankibikinkbn = new ExDBFieldString<>("zrnsihankibikinkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin1x3 = new ExDBFieldString<>("zrnsuuriyouyobin1x3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhosyoukinoukbn = new ExDBFieldString<>("zrnhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndaikbn = new ExDBFieldString<>("zrndaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntyuukbn = new ExDBFieldString<>("zrntyuukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyoukbn = new ExDBFieldString<>("zrnsyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsedaikbn = new ExDBFieldString<>("zrnsedaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnao3tyou3sibousdatehyouji = new ExDBFieldString<>("zrnao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntkbthsyumnryuhyouji = new ExDBFieldString<>("zrntkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyukeiyakupwaribikikbn = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanwaribikikbn = new ExDBFieldString<>("zrntenkanwaribikikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("zrnyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntokujyoup = new ExDBFieldNumber<>("zrntokujyoup", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsiteizukisyukeiyakup = new ExDBFieldNumber<>("zrnsiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhenkougokihons = new ExDBFieldNumber<>("zrnhenkougokihons", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhenkougosibous = new ExDBFieldNumber<>("zrnhenkougosibous", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhenkouymd = new ExDBFieldString<>("zrnhenkouymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnentyoukikan = new ExDBFieldString<>("zrnentyoukikan", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnseizonkyuuhukinsiteimd = new ExDBFieldString<>("zrnseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsyukeiyakusiharaikingaku = new ExDBFieldNumber<>("zrnsyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnatukaisisyatodouhukencd = new ExDBFieldString<>("zrnatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrntokuyakuhukasuu = new ExDBFieldNumber<>("zrntokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndi2hknkknikoujihisyaage = new ExDBFieldString<>("zrndi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrimnentyoumaephrkkkn = new ExDBFieldString<>("zrnhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkousinmanryouage = new ExDBFieldString<>("zrnkousinmanryouage", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrizmjhknsyukigousdkbn = new ExDBFieldString<>("zrnhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkrsgjhknsyukigousdkbn = new ExDBFieldString<>("zrnkrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsotodasisyouhinkaiteikbn = new ExDBFieldString<>("zrnsotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeitenkans = new ExDBFieldNumber<>("zrngoukeitenkans", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeipbubuntenkans = new ExDBFieldNumber<>("zrngoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikisyuruikigou = new ExDBFieldString<>("zrntenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikikigousedaikbn = new ExDBFieldString<>("zrntenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnkntiksotodasikusnkbn = new ExDBFieldString<>("zrntnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnkntikstdspmenkbn = new ExDBFieldString<>("zrntnkntikstdspmenkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikikigouyobi = new ExDBFieldString<>("zrntenkanteikikigouyobi", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikikikan = new ExDBFieldString<>("zrntenkanteikikikan", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeitenkanteikis = new ExDBFieldNumber<>("zrngoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknteikinkshrkkn = new ExDBFieldString<>("zrntnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntenkansiharaikingaku = new ExDBFieldNumber<>("zrntenkansiharaikingaku", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnkntikshrkngk = new ExDBFieldNumber<>("zrntnkntikshrkngk", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeitenkankakaku = new ExDBFieldNumber<>("zrngoukeitenkankakaku", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrntnknkhnbbnjyuturt = new ExDBFieldString<>("zrntnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnwnasigoukeitenkanteikis = new ExDBFieldNumber<>("zrnwnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknteikikousinmnryouage = new ExDBFieldString<>("zrntnknteikikousinmnryouage", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkanyujidatakanrino = new ExDBFieldString<>("zrnkanyujidatakanrino", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkanyujikykymd = new ExDBFieldString<>("zrnkanyujikykymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkanyuujihihokensyaage = new ExDBFieldString<>("zrnkanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkanyuujitenkanhyouji = new ExDBFieldString<>("zrnkanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhsyuikktminaosikaisu = new ExDBFieldString<>("zrnhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsknnjynbknsisnrt = new ExDBFieldString<>("zrnsknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsakugenkikan = new ExDBFieldString<>("zrnsakugenkikan", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrnryoumasihyouten = new ExDBFieldNumber<>("zrnryoumasihyouten", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsykyktkjyuryumsratehyj = new ExDBFieldString<>("zrnsykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsykyktkjyuryumsrate = new ExDBFieldString<>("zrnsykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2tokujyoukbn = new ExDBFieldString<>("zrndai2tokujyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2sakugenkikan = new ExDBFieldString<>("zrndai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrndai2ryoumasihyouten = new ExDBFieldNumber<>("zrndai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuteibuijyoukenhyouji = new ExDBFieldString<>("zrntokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuteibuino1 = new ExDBFieldString<>("zrntokuteibuino1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhtnpkkn1 = new ExDBFieldString<>("zrnhtnpkkn1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuteibuino2 = new ExDBFieldString<>("zrntokuteibuino2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhtnpkkn2 = new ExDBFieldString<>("zrnhtnpkkn2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmhituiryuyutktbijyknhyj = new ExDBFieldString<>("zrnmhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmuhaitouiryouyoutktbino1 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmuhaitouiryouyoutktbino2 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsiteizukipwarimasihyouji = new ExDBFieldString<>("zrnsiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnpwarimasisiteim1 = new ExDBFieldString<>("zrnpwarimasisiteim1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnpwarimasisiteim2 = new ExDBFieldString<>("zrnpwarimasisiteim2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsiteimsykykpbairitu = new ExDBFieldString<>("zrnsiteimsykykpbairitu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsaisyuusiteiym = new ExDBFieldString<>("zrnsaisyuusiteiym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsykykkitmttvkeisanym = new ExDBFieldString<>("zrnsykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("zrnsykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrndftumitatekingaku = new ExDBFieldNumber<>("zrndftumitatekingaku", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrndftumimasikin = new ExDBFieldNumber<>("zrndftumimasikin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnvbubundftenkankakaku = new ExDBFieldNumber<>("zrnvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrndpbubundftenkankakaku = new ExDBFieldNumber<>("zrndpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrndftmttkngkitjbrbbn = new ExDBFieldNumber<>("zrndftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhendous = new ExDBFieldNumber<>("zrnhendous", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhengakujigyounendomatucv = new ExDBFieldNumber<>("zrnhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnitibuitijibaraip = new ExDBFieldNumber<>("zrnitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnitibitjbrshrkngk = new ExDBFieldNumber<>("zrnitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeicv = new ExDBFieldNumber<>("zrngoukeicv", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnminasicv = new ExDBFieldNumber<>("zrnminasicv", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnloanfund = new ExDBFieldNumber<>("zrnloanfund", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsaiteihosyougaku = new ExDBFieldNumber<>("zrnsaiteihosyougaku", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhngksitihsyuyusykykp = new ExDBFieldNumber<>("zrnhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsiinkbn = new ExDBFieldString<>("zrnsiinkbn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnmudkaimasikihons = new ExDBFieldNumber<>("zrnmudkaimasikihons", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkaimasiymd = new ExDBFieldString<>("zrnkaimasiymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkaimasikikan = new ExDBFieldString<>("zrnkaimasikikan", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhikitugikaimasis = new ExDBFieldNumber<>("zrnhikitugikaimasis", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnmudkaimasisiharaikingaku = new ExDBFieldNumber<>("zrnmudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoukouryokukaisiymdx1 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszouhokensyuruikigoux1 = new ExDBFieldString<>("zrnszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoukigousedaikbnx1 = new ExDBFieldString<>("zrnszoukigousedaikbnx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoukikanx1 = new ExDBFieldString<>("zrnszoukikanx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszouhihokensyaagex1 = new ExDBFieldString<>("zrnszouhihokensyaagex1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoudai2hihknsyaagex1 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnzoukasx1 = new ExDBFieldNumber<>("zrnzoukasx1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnzennendozoukasx1 = new ExDBFieldNumber<>("zrnzennendozoukasx1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnszousiharaikingakux1 = new ExDBFieldNumber<>("zrnszousiharaikingakux1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoukouryokukaisiymdx2 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszouhokensyuruikigoux2 = new ExDBFieldString<>("zrnszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoukigousedaikbnx2 = new ExDBFieldString<>("zrnszoukigousedaikbnx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoukikanx2 = new ExDBFieldString<>("zrnszoukikanx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszouhihokensyaagex2 = new ExDBFieldString<>("zrnszouhihokensyaagex2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoudai2hihknsyaagex2 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnzoukasx2 = new ExDBFieldNumber<>("zrnzoukasx2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnzennendozoukasx2 = new ExDBFieldNumber<>("zrnzennendozoukasx2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnszousiharaikingakux2 = new ExDBFieldNumber<>("zrnszousiharaikingakux2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin1x5 = new ExDBFieldString<>("zrnsuuriyouyobin1x5", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin1x6 = new ExDBFieldString<>("zrnsuuriyouyobin1x6", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrimngkizktkykpmenhyj = new ExDBFieldString<>("zrnhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmisyuustartym = new ExDBFieldString<>("zrnmisyuustartym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmisyuukaisuu = new ExDBFieldString<>("zrnmisyuukaisuu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("zrnitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngyousekihyoujis = new ExDBFieldNumber<>("zrngyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsykykgyusekihyjs = new ExDBFieldNumber<>("zrnsykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntenkangyousekihyoujis = new ExDBFieldNumber<>("zrntenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnknteikigyousekihyjs = new ExDBFieldNumber<>("zrntnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnkndpbbngyuskhyjs = new ExDBFieldNumber<>("zrntnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkykjyoutai = new ExDBFieldString<>("zrnkykjyoutai", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkousinkbn = new ExDBFieldString<>("zrnkousinkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmankiyoteikbn = new ExDBFieldString<>("zrnmankiyoteikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsykyktikmnkyoteikbn = new ExDBFieldString<>("zrnsykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknsykykkhnmnkytikbn = new ExDBFieldString<>("zrntnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknsykyktikmnkytikbn = new ExDBFieldString<>("zrntnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikimankiyoteikbn = new ExDBFieldString<>("zrntenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoumankiyoteikbnx1 = new ExDBFieldString<>("zrnszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszoumankiyoteikbnx2 = new ExDBFieldString<>("zrnszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnvestingmankiyoteikbn = new ExDBFieldString<>("zrnvestingmankiyoteikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnvkeisanhyouji = new ExDBFieldString<>("zrnvkeisanhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntoukisinkeiyakuhyouji = new ExDBFieldString<>("zrntoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsykykhokenhoutekiyouhyj = new ExDBFieldString<>("zrnsykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnytirrthndsysnmnskaisuu = new ExDBFieldString<>("zrnytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin3 = new ExDBFieldString<>("zrnsuuriyouyobin3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin11 = new ExDBFieldString<>("zrnsuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnwnasigoukeitenkankakaku = new ExDBFieldNumber<>("zrnwnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntukibaraikansantokujyoup = new ExDBFieldNumber<>("zrntukibaraikansantokujyoup", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnkngkykkssnkijyuym = new ExDBFieldString<>("zrntnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsaiteihosyouhyouji = new ExDBFieldString<>("zrnsaiteihosyouhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin8x2 = new ExDBFieldString<>("zrnsuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin14 = new ExDBFieldString<>("zrnsuuriyouyobin14", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("zrnhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrimngtkykphrkkirkbn = new ExDBFieldString<>("zrnhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhrimngtkykpryurtkbn = new ExDBFieldString<>("zrnhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv13 = new ExDBFieldString<>("zrnyobiv13", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnidoujisaiteihosyoukngk = new ExDBFieldNumber<>("zrnidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnidoujisaiteihosyoucost = new ExDBFieldNumber<>("zrnidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsinhokenfundtumitatekin = new ExDBFieldNumber<>("zrnsinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnmsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("zrnmsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthndugtnkgetumatuv = new ExDBFieldNumber<>("zrnrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("zrnrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthendougatanksibous = new ExDBFieldNumber<>("zrnrrthendougatanksibous", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnalmyousohutomeisyoukbn = new ExDBFieldString<>("zrnalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsnkyksoftmeisyoukbn = new ExDBFieldString<>("zrnsnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsoftmeisyoukbn = new ExDBFieldString<>("zrnsoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkykjitokujyouarihyj = new ExDBFieldString<>("zrnkykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanminaosikbn = new ExDBFieldString<>("zrntenkanminaosikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsoujikeitenkankbn = new ExDBFieldString<>("zrnsoujikeitenkankbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnnenkingatakbn = new ExDBFieldString<>("zrnnenkingatakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnheiyoubaraikeiyakukbn = new ExDBFieldString<>("zrnheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnnenkinmaruteihukakbn = new ExDBFieldString<>("zrnnenkinmaruteihukakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsinseizonmrtiarihyj = new ExDBFieldString<>("zrnsinseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsnkykyouibokijyukbn = new ExDBFieldString<>("zrnsnkykyouibokijyukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokusitujyuusitusetkbn = new ExDBFieldString<>("zrntokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("zrnsiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnpmensugugtganhsyunshyj = new ExDBFieldString<>("zrnpmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntkykgyousekihyjszerohyj = new ExDBFieldString<>("zrntkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin7 = new ExDBFieldString<>("zrnsuuriyouyobin7", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyussaikeitaikbn = new ExDBFieldString<>("zrnsyussaikeitaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobiv8 = new ExDBFieldString<>("zrnsuuriyouyobiv8", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsinsakbn = new ExDBFieldString<>("zrnsinsakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2hihokensyasinsakbn = new ExDBFieldString<>("zrndai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2toukeiyousinsakbn = new ExDBFieldString<>("zrndai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnketteikijyunkanwakbn = new ExDBFieldString<>("zrnketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkihonsibouhyoukbn = new ExDBFieldString<>("zrnkihonsibouhyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnteikisibouhyoukbn = new ExDBFieldString<>("zrnteikisibouhyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsonotasibouhyoukbn = new ExDBFieldString<>("zrnsonotasibouhyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmrarihyj = new ExDBFieldString<>("zrnmrarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsentakujyouhouarihyouji = new ExDBFieldString<>("zrnsentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndugktnknsntkhuhukbn = new ExDBFieldString<>("zrndugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnjidoukousinkykkanyuuymd = new ExDBFieldString<>("zrnjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsaikohtnknkykkykymd = new ExDBFieldString<>("zrnsaikohtnknkykkykymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkousinmaesykyksburtkbn = new ExDBFieldString<>("zrnkousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhjncd = new ExDBFieldString<>("zrnhjncd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhjnjigyosyocd = new ExDBFieldString<>("zrnhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsaihokenno = new ExDBFieldString<>("zrnsaihokenno", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndakuhikettikekkacd = new ExDBFieldString<>("zrndakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2dakuhiketteikekkacd = new ExDBFieldString<>("zrndai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnpmenkbnv2 = new ExDBFieldString<>("zrnpmenkbnv2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsiboukyuuhukin = new ExDBFieldNumber<>("zrnsiboukyuuhukin", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnjyudthumeharaitkykhkhyj = new ExDBFieldString<>("zrnjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkyksyaagetyouseihyj = new ExDBFieldString<>("zrnkyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmusentakukeiyakukbn = new ExDBFieldString<>("zrnmusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv6x2 = new ExDBFieldString<>("zrnyobiv6x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnlivingneedssiharaihyouji = new ExDBFieldString<>("zrnlivingneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnlnseikyuuymd = new ExDBFieldString<>("zrnlnseikyuuymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnlnshrgenincd = new ExDBFieldString<>("zrnlnshrgenincd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndai2dakuhiketteisyacd = new ExDBFieldString<>("zrndai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrngansapotokuyakuarihyouji = new ExDBFieldString<>("zrngansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrngnspshrhyj = new ExDBFieldString<>("zrngnspshrhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrngansaposeikyuuymd = new ExDBFieldString<>("zrngansaposeikyuuymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrngnspshrgenincd = new ExDBFieldString<>("zrngnspshrgenincd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv3x2 = new ExDBFieldString<>("zrnyobiv3x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntargetmokuhyouritu = new ExDBFieldString<>("zrntargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnautoswitchmokuhyouritu = new ExDBFieldString<>("zrnautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntumitatekinitenarihyj = new ExDBFieldString<>("zrntumitatekinitenarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntumitatekinitenkaisuu = new ExDBFieldString<>("zrntumitatekinitenkaisuu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndatakanrino2 = new ExDBFieldString<>("zrndatakanrino2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndatakanrino3 = new ExDBFieldString<>("zrndatakanrino3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnknkuzusnzyrttekinendo = new ExDBFieldString<>("zrnknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnknkuzusnzyrtx2 = new ExDBFieldString<>("zrnknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnknkuzusnzyrtx3 = new ExDBFieldString<>("zrnknkuzusnzyrtx3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("zrnsinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanjiknkuzusnzyrt = new ExDBFieldString<>("zrntenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsinkeiyakujivithkhyouji = new ExDBFieldString<>("zrnsinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkykjivithukusuukykhyj = new ExDBFieldString<>("zrnkykjivithukusuukykhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin9x2 = new ExDBFieldString<>("zrnsuuriyouyobin9x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin9 = new ExDBFieldString<>("zrnsuuriyouyobin9", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin10x7 = new ExDBFieldString<>("zrnsuuriyouyobin10x7", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin10x8 = new ExDBFieldString<>("zrnsuuriyouyobin10x8", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin10x9 = new ExDBFieldString<>("zrnsuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntumitatekinitenbubun = new ExDBFieldNumber<>("zrntumitatekinitenbubun", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsagakusknnjynbknzndk = new ExDBFieldNumber<>("zrnsagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x10 = new ExDBFieldNumber<>("zrnyobin11x10", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x11 = new ExDBFieldNumber<>("zrnyobin11x11", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x12 = new ExDBFieldNumber<>("zrnyobin11x12", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x13 = new ExDBFieldNumber<>("zrnyobin11x13", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x14 = new ExDBFieldNumber<>("zrnyobin11x14", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x15 = new ExDBFieldNumber<>("zrnyobin11x15", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x16 = new ExDBFieldNumber<>("zrnyobin11x16", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x17 = new ExDBFieldNumber<>("zrnyobin11x17", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzyrthntiyustatuskbnx2 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzyrthntiyustatuskbnx3 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzyrthntiyustatuskbnx4 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzyrthntiyustatuskbnx5 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv15x2 = new ExDBFieldString<>("zrnyobiv15x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv15x3 = new ExDBFieldString<>("zrnyobiv15x3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv15x4 = new ExDBFieldString<>("zrnyobiv15x4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnkawaserate1 = new ExDBFieldString<>("zrnkawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkawaseratetekiyouymd1 = new ExDBFieldString<>("zrnkawaseratetekiyouymd1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnkawaserate2 = new ExDBFieldString<>("zrnkawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkawaseratetekiyouymd2 = new ExDBFieldString<>("zrnkawaseratetekiyouymd2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnkykjikawaserate = new ExDBFieldString<>("zrnkykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkykjikawaseratetkyuymd = new ExDBFieldString<>("zrnkykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnkaiyakukoujyoritu = new ExDBFieldString<>("zrnkaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("zrnsrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnmvakeisankijyunymd = new ExDBFieldString<>("zrnmvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnenkdtsbujsitihsyucost = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("zrnenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkaigomaebaraitkykarihyj = new ExDBFieldString<>("zrnkaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsibouhyoukbn = new ExDBFieldString<>("zrnsibouhyoukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnnyuukintuukakbn = new ExDBFieldString<>("zrnnyuukintuukakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsiharaituukakbn = new ExDBFieldString<>("zrnsiharaituukakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnwyendttargetmokuhyouritu = new ExDBFieldString<>("zrnwyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnteirituikouhyouji = new ExDBFieldString<>("zrnteirituikouhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin10x11 = new ExDBFieldString<>("zrnsuuriyouyobin10x11", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrntmttknzoukaritujygn = new ExDBFieldString<>("zrntmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsetteibairitu = new ExDBFieldString<>("zrnsetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrntykzenoutouymdsisuu = new ExDBFieldString<>("zrntykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnkimatusisuu = new ExDBFieldString<>("zrnkimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyenkadatekihons = new ExDBFieldNumber<>("zrnyenkadatekihons", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsitihsyumegkdtsibous = new ExDBFieldNumber<>("zrnsitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnenkdtssrentumitatekin = new ExDBFieldNumber<>("zrnenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsisuurentumitatekin = new ExDBFieldNumber<>("zrnsisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnnksjitirttumitatekin = new ExDBFieldNumber<>("zrnnksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkimatutirttumitatekin = new ExDBFieldNumber<>("zrnkimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngaikadatejyuutoup = new ExDBFieldNumber<>("zrngaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyendttargetkijyunkingaku = new ExDBFieldNumber<>("zrnyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsitivkisnyukykjikwsrate = new ExDBFieldString<>("zrnsitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsisuurentyokugotmttkn = new ExDBFieldNumber<>("zrnsisuurentyokugotmttkn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnyoteiririturironbase = new ExDBFieldString<>("zrnyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnyoteiriritujtnyknbase = new ExDBFieldString<>("zrnyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkihrkmpjtnyknbase = new ExDBFieldNumber<>("zrnkihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsyuptumitatekin = new ExDBFieldNumber<>("zrnsyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsyuptumitatekingsc = new ExDBFieldNumber<>("zrnsyuptumitatekingsc", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngaikadatenkgns = new ExDBFieldNumber<>("zrngaikadatenkgns", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnjikaipjyuutouym2 = new ExDBFieldString<>("zrnjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Integer> zrnsuuriyobin9 = new ExDBFieldNumber<>("zrnsuuriyobin9", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngessitumitatekin = new ExDBFieldNumber<>("zrngessitumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngaikadatetougetujuutoup = new ExDBFieldNumber<>("zrngaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkihrkmpmsukisymbase = new ExDBFieldNumber<>("zrnkihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkeisanhanteiyoutmttkn = new ExDBFieldNumber<>("zrnkeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngtmtv = new ExDBFieldNumber<>("zrngtmtv", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnzettaisibouritu = new ExDBFieldString<>("zrnzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsoutaisibouritu = new ExDBFieldString<>("zrnsoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnsoutaikaiyakuritu = new ExDBFieldString<>("zrnsoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnvhireilritu2 = new ExDBFieldString<>("zrnvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnphireialpha = new ExDBFieldString<>("zrnphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnphireibeta = new ExDBFieldString<>("zrnphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnphireiganma = new ExDBFieldString<>("zrnphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnphireilwrbkritu = new ExDBFieldString<>("zrnphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnyoteiriritumsukisymbase = new ExDBFieldString<>("zrnyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnrrthnduhknvkiso = new ExDBFieldNumber<>("zrnrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntumitatekin = new ExDBFieldNumber<>("zrntumitatekin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkykkjmmvatyouseigow = new ExDBFieldNumber<>("zrnkykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x39 = new ExDBFieldNumber<>("zrnyobin11x39", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x41 = new ExDBFieldNumber<>("zrnyobin11x41", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x42 = new ExDBFieldNumber<>("zrnyobin11x42", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x43 = new ExDBFieldNumber<>("zrnyobin11x43", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x44 = new ExDBFieldNumber<>("zrnyobin11x44", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x45 = new ExDBFieldNumber<>("zrnyobin11x45", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin15x3 = new ExDBFieldString<>("zrnsuuriyouyobin15x3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin15x4 = new ExDBFieldString<>("zrnsuuriyouyobin15x4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin15x5 = new ExDBFieldString<>("zrnsuuriyouyobin15x5", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin15x6 = new ExDBFieldString<>("zrnsuuriyouyobin15x6", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkyksyhhknsydouituhyouji = new ExDBFieldString<>("zrnkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkyksyaskinmeino = new ExDBFieldString<>("zrnkyksyaskinmeino", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeikihons = new ExDBFieldNumber<>("zrngoukeikihons", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeigyousekihyjsibous = new ExDBFieldNumber<>("zrngoukeigyousekihyjsibous", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnalmyousibous = new ExDBFieldNumber<>("zrnalmyousibous", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsiteizukiharaikomip = new ExDBFieldNumber<>("zrnsiteizukiharaikomip", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsaisyuusiteimhrkp = new ExDBFieldNumber<>("zrnsaisyuusiteimhrkp", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeinenbaraikansanp = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrngyousekihyoujisrank = new ExDBFieldString<>("zrngyousekihyoujisrank", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, BizNumber> zrnteikibairitu = new ExDBFieldString<>("zrnteikibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkangodatakanrino = new ExDBFieldString<>("zrntenkangodatakanrino", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaitekykdatakanrino1 = new ExDBFieldString<>("zrnaitekykdatakanrino1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaitekykdatakanrino2 = new ExDBFieldString<>("zrnaitekykdatakanrino2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknsyokaipcashlesshyj = new ExDBFieldString<>("zrntnknsyokaipcashlesshyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyokaipannaikbn = new ExDBFieldString<>("zrnsyokaipannaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzennoukaisiymd = new ExDBFieldString<>("zrnzennoukaisiymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnzennoukikan = new ExDBFieldString<>("zrnzennoukikan", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnseizonkyuuhukinsiteiy = new ExDBFieldString<>("zrnseizonkyuuhukinsiteiy", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnalmyouseizonkyhknsiteimd = new ExDBFieldString<>("zrnalmyouseizonkyhknsiteimd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkkn3x1 = new ExDBFieldString<>("zrnhktgtikkikkkn3x1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkkn3x2 = new ExDBFieldString<>("zrnhktgtikkikkkn3x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkkn3x3 = new ExDBFieldString<>("zrnhktgtikkikkkn3x3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkkn3x4 = new ExDBFieldString<>("zrnhktgtikkikkkn3x4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkappadkeisankbnx1 = new ExDBFieldString<>("zrnkappadkeisankbnx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkappadkeisankbnx2 = new ExDBFieldString<>("zrnkappadkeisankbnx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkappadkeisankbnx3 = new ExDBFieldString<>("zrnkappadkeisankbnx3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkappadkeisankbnx4 = new ExDBFieldString<>("zrnkappadkeisankbnx4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv6x3 = new ExDBFieldString<>("zrnyobiv6x3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkimatuvyoutumimasikin = new ExDBFieldNumber<>("zrnkimatuvyoutumimasikin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkmtvyusnhknfundtmttkin = new ExDBFieldNumber<>("zrnkmtvyusnhknfundtmttkin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeinenkansanp3x1 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeinenkansanp3x2 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeinenkansanp3x3 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeinenkansanp3x4 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x4", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkmtvyuhijynbritmttkin = new ExDBFieldNumber<>("zrnkmtvyuhijynbritmttkin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkimatuvyouitjbrtmttkin = new ExDBFieldNumber<>("zrnkimatuvyouitjbrtmttkin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x26 = new ExDBFieldNumber<>("zrnyobin11x26", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x27 = new ExDBFieldNumber<>("zrnyobin11x27", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x28 = new ExDBFieldNumber<>("zrnyobin11x28", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x29 = new ExDBFieldNumber<>("zrnyobin11x29", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x30 = new ExDBFieldNumber<>("zrnyobin11x30", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x31 = new ExDBFieldNumber<>("zrnyobin11x31", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x32 = new ExDBFieldNumber<>("zrnyobin11x32", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x33 = new ExDBFieldNumber<>("zrnyobin11x33", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhaitouyouloadingkijyuns = new ExDBFieldNumber<>("zrnhaitouyouloadingkijyuns", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntouduketorihouhoukbn = new ExDBFieldString<>("zrntouduketorihouhoukbn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntumitated = new ExDBFieldNumber<>("zrntumitated", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkariwariated = new ExDBFieldNumber<>("zrnkariwariated", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntyokuzensiharaikijitu = new ExDBFieldString<>("zrntyokuzensiharaikijitu", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntyokuzentuusanhanteis = new ExDBFieldNumber<>("zrntyokuzentuusanhanteis", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntyokugosiharaikijitu = new ExDBFieldString<>("zrntyokugosiharaikijitu", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntyokugotuusanhanteis = new ExDBFieldNumber<>("zrntyokugotuusanhanteis", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntyokugokyuuhutaisyous = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyous", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntyokugocbkingaku = new ExDBFieldNumber<>("zrntyokugocbkingaku", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyokaisiharaikijitu = new ExDBFieldString<>("zrnsyokaisiharaikijitu", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsyokaituusanhanteis = new ExDBFieldNumber<>("zrnsyokaituusanhanteis", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrncbnayosetuusanhanteis = new ExDBFieldNumber<>("zrncbnayosetuusanhanteis", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhitenkankeiyakusuu = new ExDBFieldString<>("zrnhitenkankeiyakusuu", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrngoukeipbubuntenkanteikis = new ExDBFieldNumber<>("zrngoukeipbubuntenkanteikis", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsaidaihktgtikkikkkn = new ExDBFieldString<>("zrnsaidaihktgtikkikkkn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsisyutnknhktgkujygk = new ExDBFieldNumber<>("zrnsisyutnknhktgkujygk", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x34 = new ExDBFieldNumber<>("zrnyobin11x34", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhtnknkykkykymdx1 = new ExDBFieldString<>("zrnhtnknkykkykymdx1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnkntkbtdkisnyusx1 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknkaiykkujytksux1 = new ExDBFieldString<>("zrntnknkaiykkujytksux1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnknkaiykkujygkx1 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikihyoujix1 = new ExDBFieldString<>("zrntenkanteikihyoujix1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhtnknkyknenknsnpx1 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkknx1 = new ExDBFieldString<>("zrnhktgtikkikkknx1", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhtnknkykkykymdx2 = new ExDBFieldString<>("zrnhtnknkykkykymdx2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnkntkbtdkisnyusx2 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknkaiykkujytksux2 = new ExDBFieldString<>("zrntnknkaiykkujytksux2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnknkaiykkujygkx2 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikihyoujix2 = new ExDBFieldString<>("zrntenkanteikihyoujix2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhtnknkyknenknsnpx2 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkknx2 = new ExDBFieldString<>("zrnhktgtikkikkknx2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhtnknkykkykymdx3 = new ExDBFieldString<>("zrnhtnknkykkykymdx3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnkntkbtdkisnyusx3 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknkaiykkujytksux3 = new ExDBFieldString<>("zrntnknkaiykkujytksux3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnknkaiykkujygkx3 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikihyoujix3 = new ExDBFieldString<>("zrntenkanteikihyoujix3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhtnknkyknenknsnpx3 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkknx3 = new ExDBFieldString<>("zrnhktgtikkikkknx3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhtnknkykkykymdx4 = new ExDBFieldString<>("zrnhtnknkykkykymdx4", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnkntkbtdkisnyusx4 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntnknkaiykkujytksux4 = new ExDBFieldString<>("zrntnknkaiykkujytksux4", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntnknkaiykkujygkx4 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikihyoujix4 = new ExDBFieldString<>("zrntenkanteikihyoujix4", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnhtnknkyknenknsnpx4 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhktgtikkikkknx4 = new ExDBFieldString<>("zrnhktgtikkikkknx4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsknjyututkykkykkbn = new ExDBFieldString<>("zrnsknjyututkykkykkbn", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnswingminyuuphrkekngk = new ExDBFieldNumber<>("zrnswingminyuuphrkekngk", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnswingminyuuphrkejyutuym = new ExDBFieldString<>("zrnswingminyuuphrkejyutuym", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrndftounendoitijitounyuup = new ExDBFieldNumber<>("zrndftounendoitijitounyuup", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrndfkaiyakukujyhktggk = new ExDBFieldNumber<>("zrndfkaiyakukujyhktggk", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkaiyakukoujyotukisuu = new ExDBFieldString<>("zrnkaiyakukoujyotukisuu", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrndfkaiyakuhenreikin = new ExDBFieldNumber<>("zrndfkaiyakuhenreikin", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnsyuuseis = new ExDBFieldNumber<>("zrnsyuuseis", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaatukaisyakeisyousisyacd = new ExDBFieldString<>("zrnaatukaisyakeisyousisyacd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaatukaisyazaisekihyouji = new ExDBFieldString<>("zrnaatukaisyazaisekihyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaatukaisyabosyuujiage = new ExDBFieldString<>("zrnaatukaisyabosyuujiage", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaatukaisyabsyjisikakucd = new ExDBFieldString<>("zrnaatukaisyabsyjisikakucd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnaatukaisyasikakucd = new ExDBFieldString<>("zrnaatukaisyasikakucd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnokyksmkuztrhkkitikbn = new ExDBFieldString<>("zrnokyksmkuztrhkkitikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhoyuusisyacd = new ExDBFieldString<>("zrnhoyuusisyacd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyokansisyacd = new ExDBFieldString<>("zrnsyokansisyacd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntantousyakbn = new ExDBFieldString<>("zrntantousyakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntantousyakbnnew = new ExDBFieldString<>("zrntantousyakbnnew", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnclubsumiseikbn = new ExDBFieldString<>("zrnclubsumiseikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnfollowtantousyakbn = new ExDBFieldString<>("zrnfollowtantousyakbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntantousyajyoutaikbn = new ExDBFieldString<>("zrntantousyajyoutaikbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkihonyoteii = new ExDBFieldString<>("zrnkihonyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnteikiyoteii = new ExDBFieldString<>("zrnteikiyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsonotayoteii = new ExDBFieldString<>("zrnsonotayoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnitijibaraikihonyoteii = new ExDBFieldString<>("zrnitijibaraikihonyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnitijibaraiteikiyoteii = new ExDBFieldString<>("zrnitijibaraiteikiyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnitijibaraisonotayoteii = new ExDBFieldString<>("zrnitijibaraisonotayoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkankihonyoteii = new ExDBFieldString<>("zrntenkankihonyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntenkanteikiyoteii = new ExDBFieldString<>("zrntenkanteikiyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnszouyoteii = new ExDBFieldString<>("zrnszouyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnvestingyoteii = new ExDBFieldString<>("zrnvestingyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsippeitokuyakuyoteii = new ExDBFieldString<>("zrnsippeitokuyakuyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnseijinbyoutokuyakuyoteii = new ExDBFieldString<>("zrnseijinbyoutokuyakuyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnjyoseitokuyakuyoteii = new ExDBFieldString<>("zrnjyoseitokuyakuyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntuuintokuyakuyoteii = new ExDBFieldString<>("zrntuuintokuyakuyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsaiteihosyoui = new ExDBFieldString<>("zrnsaiteihosyoui", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnvkisoitjbrkhnyoteii = new ExDBFieldString<>("zrnvkisoitjbrkhnyoteii", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnvkisorrtzeroikahyouji = new ExDBFieldString<>("zrnvkisorrtzeroikahyouji", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin3x2 = new ExDBFieldString<>("zrnsuuriyouyobin3x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhoyuusisyacd2 = new ExDBFieldString<>("zrnhoyuusisyacd2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrndftujyukujykisnkisiym = new ExDBFieldString<>("zrndftujyukujykisnkisiym", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntikikktbrijyututksu = new ExDBFieldString<>("zrntikikktbrijyututksu", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsyunyumrtikykjtigngtkbn = new ExDBFieldString<>("zrnsyunyumrtikykjtigngtkbn", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnhhkdrtkykarihyj = new ExDBFieldString<>("zrnhhkdrtkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnyobiv10x14 = new ExDBFieldString<>("zrnyobiv10x14", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkappadhktgkujygkx1 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx1", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkappadhktgkujygkx2 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx2", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkappadhktgkujygkx3 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx3", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnkappadhktgkujygkx4 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx4", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrntrkzsgkaiykkjynstmtkzndk = new ExDBFieldNumber<>("zrntrkzsgkaiykkjynstmtkzndk", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnpmenkouryokuhasseiymd = new ExDBFieldString<>("zrnpmenkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin5 = new ExDBFieldString<>("zrnsuuriyouyobin5", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrnsuuriyouyobin13 = new ExDBFieldString<>("zrnsuuriyouyobin13", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x35 = new ExDBFieldNumber<>("zrnyobin11x35", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x36 = new ExDBFieldNumber<>("zrnyobin11x36", this);

    public final ExDBFieldNumber<ZT_HoyuuMeisaiRn, Long> zrnyobin11x37 = new ExDBFieldNumber<>("zrnyobin11x37", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200 = new ExDBFieldString<>("zrntokuyakukoumokuv200", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x2 = new ExDBFieldString<>("zrntokuyakukoumokuv200x2", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x3 = new ExDBFieldString<>("zrntokuyakukoumokuv200x3", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x4 = new ExDBFieldString<>("zrntokuyakukoumokuv200x4", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x5 = new ExDBFieldString<>("zrntokuyakukoumokuv200x5", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x6 = new ExDBFieldString<>("zrntokuyakukoumokuv200x6", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x7 = new ExDBFieldString<>("zrntokuyakukoumokuv200x7", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x8 = new ExDBFieldString<>("zrntokuyakukoumokuv200x8", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x9 = new ExDBFieldString<>("zrntokuyakukoumokuv200x9", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x10 = new ExDBFieldString<>("zrntokuyakukoumokuv200x10", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x11 = new ExDBFieldString<>("zrntokuyakukoumokuv200x11", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x12 = new ExDBFieldString<>("zrntokuyakukoumokuv200x12", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x13 = new ExDBFieldString<>("zrntokuyakukoumokuv200x13", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x14 = new ExDBFieldString<>("zrntokuyakukoumokuv200x14", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x15 = new ExDBFieldString<>("zrntokuyakukoumokuv200x15", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x16 = new ExDBFieldString<>("zrntokuyakukoumokuv200x16", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x17 = new ExDBFieldString<>("zrntokuyakukoumokuv200x17", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x18 = new ExDBFieldString<>("zrntokuyakukoumokuv200x18", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x19 = new ExDBFieldString<>("zrntokuyakukoumokuv200x19", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x20 = new ExDBFieldString<>("zrntokuyakukoumokuv200x20", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x21 = new ExDBFieldString<>("zrntokuyakukoumokuv200x21", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x22 = new ExDBFieldString<>("zrntokuyakukoumokuv200x22", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x23 = new ExDBFieldString<>("zrntokuyakukoumokuv200x23", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x24 = new ExDBFieldString<>("zrntokuyakukoumokuv200x24", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x25 = new ExDBFieldString<>("zrntokuyakukoumokuv200x25", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x26 = new ExDBFieldString<>("zrntokuyakukoumokuv200x26", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x27 = new ExDBFieldString<>("zrntokuyakukoumokuv200x27", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x28 = new ExDBFieldString<>("zrntokuyakukoumokuv200x28", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x29 = new ExDBFieldString<>("zrntokuyakukoumokuv200x29", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x30 = new ExDBFieldString<>("zrntokuyakukoumokuv200x30", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x31 = new ExDBFieldString<>("zrntokuyakukoumokuv200x31", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x32 = new ExDBFieldString<>("zrntokuyakukoumokuv200x32", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x33 = new ExDBFieldString<>("zrntokuyakukoumokuv200x33", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x34 = new ExDBFieldString<>("zrntokuyakukoumokuv200x34", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x35 = new ExDBFieldString<>("zrntokuyakukoumokuv200x35", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x36 = new ExDBFieldString<>("zrntokuyakukoumokuv200x36", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x37 = new ExDBFieldString<>("zrntokuyakukoumokuv200x37", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x38 = new ExDBFieldString<>("zrntokuyakukoumokuv200x38", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x39 = new ExDBFieldString<>("zrntokuyakukoumokuv200x39", this);

    public final ExDBFieldString<ZT_HoyuuMeisaiRn, String> zrntokuyakukoumokuv200x40 = new ExDBFieldString<>("zrntokuyakukoumokuv200x40", this);
}
