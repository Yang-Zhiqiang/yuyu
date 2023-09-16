package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_IdouMeisaiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動明細Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IdouMeisaiRn extends AbstractExDBTable<ZT_IdouMeisaiRn> {

    public GenQZT_IdouMeisaiRn() {
        this("ZT_IdouMeisaiRn");
    }

    public GenQZT_IdouMeisaiRn(String pAlias) {
        super("ZT_IdouMeisaiRn", ZT_IdouMeisaiRn.class, pAlias);
    }

    public String ZT_IdouMeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnnenkinkaisigohyouji = new ExDBFieldString<>("zrnnenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnnksgokurikosidhyj = new ExDBFieldString<>("zrnnksgokurikosidhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnidojiyukbn = new ExDBFieldString<>("zrnidojiyukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzougenkbn = new ExDBFieldString<>("zrnzougenkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnidourecordkbn = new ExDBFieldString<>("zrnidourecordkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkeijyouctrlkbn = new ExDBFieldString<>("zrnkeijyouctrlkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhenkousyoriymd = new ExDBFieldString<>("zrnhenkousyoriymd", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrnkykmfksnctr = new ExDBFieldNumber<>("zrnkykmfksnctr", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrnrecordctr = new ExDBFieldNumber<>("zrnrecordctr", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyoukouryokukaisiymd = new ExDBFieldString<>("zrnsuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnbluekeizokuhyouji = new ExDBFieldString<>("zrnbluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin1x2 = new ExDBFieldString<>("zrnsuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntoukeikeijyoukbn = new ExDBFieldString<>("zrntoukeikeijyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzenkiidouteiseikbn = new ExDBFieldString<>("zrnzenkiidouteiseikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkangokeiyakubosyuuym = new ExDBFieldString<>("zrntenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnidoujiyuucd = new ExDBFieldString<>("zrnidoujiyuucd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsekininteiseihyouji = new ExDBFieldString<>("zrnsekininteiseihyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsihankibikinkbn = new ExDBFieldString<>("zrnsihankibikinkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin1x3 = new ExDBFieldString<>("zrnsuuriyouyobin1x3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhosyoukinoukbn = new ExDBFieldString<>("zrnhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndaikbn = new ExDBFieldString<>("zrndaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntyuukbn = new ExDBFieldString<>("zrntyuukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyoukbn = new ExDBFieldString<>("zrnsyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsedaikbn = new ExDBFieldString<>("zrnsedaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnao3tyou3sibousdatehyouji = new ExDBFieldString<>("zrnao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntkbthsyumnryuhyouji = new ExDBFieldString<>("zrntkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyukeiyakupwaribikikbn = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanwaribikikbn = new ExDBFieldString<>("zrntenkanwaribikikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("zrnyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntokujyoup = new ExDBFieldNumber<>("zrntokujyoup", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsiteizukisyukeiyakup = new ExDBFieldNumber<>("zrnsiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhenkougokihons = new ExDBFieldNumber<>("zrnhenkougokihons", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhenkougosibous = new ExDBFieldNumber<>("zrnhenkougosibous", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhenkouymd = new ExDBFieldString<>("zrnhenkouymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnentyoukikan = new ExDBFieldString<>("zrnentyoukikan", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnseizonkyuuhukinsiteimd = new ExDBFieldString<>("zrnseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsyukeiyakusiharaikingaku = new ExDBFieldNumber<>("zrnsyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnatukaisisyatodouhukencd = new ExDBFieldString<>("zrnatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrntokuyakuhukasuu = new ExDBFieldNumber<>("zrntokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndi2hknkknikoujihisyaage = new ExDBFieldString<>("zrndi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrimnentyoumaephrkkkn = new ExDBFieldString<>("zrnhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkousinmanryouage = new ExDBFieldString<>("zrnkousinmanryouage", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrizmjhknsyukigousdkbn = new ExDBFieldString<>("zrnhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkrsgjhknsyukigousdkbn = new ExDBFieldString<>("zrnkrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsotodasisyouhinkaiteikbn = new ExDBFieldString<>("zrnsotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeitenkans = new ExDBFieldNumber<>("zrngoukeitenkans", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeipbubuntenkans = new ExDBFieldNumber<>("zrngoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikisyuruikigou = new ExDBFieldString<>("zrntenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikikigousedaikbn = new ExDBFieldString<>("zrntenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnkntiksotodasikusnkbn = new ExDBFieldString<>("zrntnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnkntikstdspmenkbn = new ExDBFieldString<>("zrntnkntikstdspmenkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikikigouyobi = new ExDBFieldString<>("zrntenkanteikikigouyobi", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikikikan = new ExDBFieldString<>("zrntenkanteikikikan", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeitenkanteikis = new ExDBFieldNumber<>("zrngoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknteikinkshrkkn = new ExDBFieldString<>("zrntnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntenkansiharaikingaku = new ExDBFieldNumber<>("zrntenkansiharaikingaku", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnkntikshrkngk = new ExDBFieldNumber<>("zrntnkntikshrkngk", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeitenkankakaku = new ExDBFieldNumber<>("zrngoukeitenkankakaku", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrntnknkhnbbnjyuturt = new ExDBFieldString<>("zrntnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnwnasigoukeitenkanteikis = new ExDBFieldNumber<>("zrnwnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknteikikousinmnryouage = new ExDBFieldString<>("zrntnknteikikousinmnryouage", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkanyujidatakanrino = new ExDBFieldString<>("zrnkanyujidatakanrino", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkanyujikykymd = new ExDBFieldString<>("zrnkanyujikykymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkanyuujihihokensyaage = new ExDBFieldString<>("zrnkanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkanyuujitenkanhyouji = new ExDBFieldString<>("zrnkanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhsyuikktminaosikaisu = new ExDBFieldString<>("zrnhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsknnjynbknsisnrt = new ExDBFieldString<>("zrnsknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsakugenkikan = new ExDBFieldString<>("zrnsakugenkikan", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrnryoumasihyouten = new ExDBFieldNumber<>("zrnryoumasihyouten", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsykyktkjyuryumsratehyj = new ExDBFieldString<>("zrnsykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsykyktkjyuryumsrate = new ExDBFieldString<>("zrnsykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2tokujyoukbn = new ExDBFieldString<>("zrndai2tokujyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2sakugenkikan = new ExDBFieldString<>("zrndai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrndai2ryoumasihyouten = new ExDBFieldNumber<>("zrndai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuteibuijyoukenhyouji = new ExDBFieldString<>("zrntokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuteibuino1 = new ExDBFieldString<>("zrntokuteibuino1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhtnpkkn1 = new ExDBFieldString<>("zrnhtnpkkn1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuteibuino2 = new ExDBFieldString<>("zrntokuteibuino2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhtnpkkn2 = new ExDBFieldString<>("zrnhtnpkkn2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmhituiryuyutktbijyknhyj = new ExDBFieldString<>("zrnmhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmuhaitouiryouyoutktbino1 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmuhaitouiryouyoutktbino2 = new ExDBFieldString<>("zrnmuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("zrnmuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsiteizukipwarimasihyouji = new ExDBFieldString<>("zrnsiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnpwarimasisiteim1 = new ExDBFieldString<>("zrnpwarimasisiteim1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnpwarimasisiteim2 = new ExDBFieldString<>("zrnpwarimasisiteim2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsiteimsykykpbairitu = new ExDBFieldString<>("zrnsiteimsykykpbairitu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsaisyuusiteiym = new ExDBFieldString<>("zrnsaisyuusiteiym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsykykkitmttvkeisanym = new ExDBFieldString<>("zrnsykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("zrnsykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrndftumitatekingaku = new ExDBFieldNumber<>("zrndftumitatekingaku", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrndftumimasikin = new ExDBFieldNumber<>("zrndftumimasikin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnvbubundftenkankakaku = new ExDBFieldNumber<>("zrnvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrndpbubundftenkankakaku = new ExDBFieldNumber<>("zrndpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrndftmttkngkitjbrbbn = new ExDBFieldNumber<>("zrndftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhendous = new ExDBFieldNumber<>("zrnhendous", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhengakujigyounendomatucv = new ExDBFieldNumber<>("zrnhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnitibuitijibaraip = new ExDBFieldNumber<>("zrnitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnitibitjbrshrkngk = new ExDBFieldNumber<>("zrnitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeicv = new ExDBFieldNumber<>("zrngoukeicv", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnminasicv = new ExDBFieldNumber<>("zrnminasicv", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnloanfund = new ExDBFieldNumber<>("zrnloanfund", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsaiteihosyougaku = new ExDBFieldNumber<>("zrnsaiteihosyougaku", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhngksitihsyuyusykykp = new ExDBFieldNumber<>("zrnhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("zrnhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsiinkbn = new ExDBFieldString<>("zrnsiinkbn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnmudkaimasikihons = new ExDBFieldNumber<>("zrnmudkaimasikihons", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkaimasiymd = new ExDBFieldString<>("zrnkaimasiymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkaimasikikan = new ExDBFieldString<>("zrnkaimasikikan", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhikitugikaimasis = new ExDBFieldNumber<>("zrnhikitugikaimasis", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnmudkaimasisiharaikingaku = new ExDBFieldNumber<>("zrnmudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoukouryokukaisiymdx1 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszouhokensyuruikigoux1 = new ExDBFieldString<>("zrnszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoukigousedaikbnx1 = new ExDBFieldString<>("zrnszoukigousedaikbnx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoukikanx1 = new ExDBFieldString<>("zrnszoukikanx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszouhihokensyaagex1 = new ExDBFieldString<>("zrnszouhihokensyaagex1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoudai2hihknsyaagex1 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnzoukasx1 = new ExDBFieldNumber<>("zrnzoukasx1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnzennendozoukasx1 = new ExDBFieldNumber<>("zrnzennendozoukasx1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnszousiharaikingakux1 = new ExDBFieldNumber<>("zrnszousiharaikingakux1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoukouryokukaisiymdx2 = new ExDBFieldString<>("zrnszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszouhokensyuruikigoux2 = new ExDBFieldString<>("zrnszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoukigousedaikbnx2 = new ExDBFieldString<>("zrnszoukigousedaikbnx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoukikanx2 = new ExDBFieldString<>("zrnszoukikanx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszouhihokensyaagex2 = new ExDBFieldString<>("zrnszouhihokensyaagex2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoudai2hihknsyaagex2 = new ExDBFieldString<>("zrnszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnzoukasx2 = new ExDBFieldNumber<>("zrnzoukasx2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnzennendozoukasx2 = new ExDBFieldNumber<>("zrnzennendozoukasx2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnszousiharaikingakux2 = new ExDBFieldNumber<>("zrnszousiharaikingakux2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin1x5 = new ExDBFieldString<>("zrnsuuriyouyobin1x5", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin1x6 = new ExDBFieldString<>("zrnsuuriyouyobin1x6", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrimngkizktkykpmenhyj = new ExDBFieldString<>("zrnhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmisyuustartym = new ExDBFieldString<>("zrnmisyuustartym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmisyuukaisuu = new ExDBFieldString<>("zrnmisyuukaisuu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("zrnitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngyousekihyoujis = new ExDBFieldNumber<>("zrngyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsykykgyusekihyjs = new ExDBFieldNumber<>("zrnsykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntenkangyousekihyoujis = new ExDBFieldNumber<>("zrntenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnknteikigyousekihyjs = new ExDBFieldNumber<>("zrntnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnkndpbbngyuskhyjs = new ExDBFieldNumber<>("zrntnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkykjyoutai = new ExDBFieldString<>("zrnkykjyoutai", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkousinkbn = new ExDBFieldString<>("zrnkousinkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmankiyoteikbn = new ExDBFieldString<>("zrnmankiyoteikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsykyktikmnkyoteikbn = new ExDBFieldString<>("zrnsykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknsykykkhnmnkytikbn = new ExDBFieldString<>("zrntnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknsykyktikmnkytikbn = new ExDBFieldString<>("zrntnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikimankiyoteikbn = new ExDBFieldString<>("zrntenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoumankiyoteikbnx1 = new ExDBFieldString<>("zrnszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszoumankiyoteikbnx2 = new ExDBFieldString<>("zrnszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnvestingmankiyoteikbn = new ExDBFieldString<>("zrnvestingmankiyoteikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnvkeisanhyouji = new ExDBFieldString<>("zrnvkeisanhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntoukisinkeiyakuhyouji = new ExDBFieldString<>("zrntoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsykykhokenhoutekiyouhyj = new ExDBFieldString<>("zrnsykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnytirrthndsysnmnskaisuu = new ExDBFieldString<>("zrnytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin3 = new ExDBFieldString<>("zrnsuuriyouyobin3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin11 = new ExDBFieldString<>("zrnsuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnwnasigoukeitenkankakaku = new ExDBFieldNumber<>("zrnwnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntukibaraikansantokujyoup = new ExDBFieldNumber<>("zrntukibaraikansantokujyoup", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnkngkykkssnkijyuym = new ExDBFieldString<>("zrntnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsaiteihosyouhyouji = new ExDBFieldString<>("zrnsaiteihosyouhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin8x2 = new ExDBFieldString<>("zrnsuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin14 = new ExDBFieldString<>("zrnsuuriyouyobin14", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("zrnhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrimngtkykphrkkirkbn = new ExDBFieldString<>("zrnhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhrimngtkykpryurtkbn = new ExDBFieldString<>("zrnhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv13 = new ExDBFieldString<>("zrnyobiv13", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnidoujisaiteihosyoukngk = new ExDBFieldNumber<>("zrnidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnidoujisaiteihosyoucost = new ExDBFieldNumber<>("zrnidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsinhokenfundtumitatekin = new ExDBFieldNumber<>("zrnsinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnmsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("zrnmsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthndugtnkgetumatuv = new ExDBFieldNumber<>("zrnrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("zrnrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthendougatanksibous = new ExDBFieldNumber<>("zrnrrthendougatanksibous", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnalmyousohutomeisyoukbn = new ExDBFieldString<>("zrnalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsnkyksoftmeisyoukbn = new ExDBFieldString<>("zrnsnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsoftmeisyoukbn = new ExDBFieldString<>("zrnsoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkykjitokujyouarihyj = new ExDBFieldString<>("zrnkykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanminaosikbn = new ExDBFieldString<>("zrntenkanminaosikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsoujikeitenkankbn = new ExDBFieldString<>("zrnsoujikeitenkankbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnnenkinkaisinendo = new ExDBFieldString<>("zrnnenkinkaisinendo", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnnenkingatakbn = new ExDBFieldString<>("zrnnenkingatakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnheiyoubaraikeiyakukbn = new ExDBFieldString<>("zrnheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnnenkinmaruteihukakbn = new ExDBFieldString<>("zrnnenkinmaruteihukakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsinseizonmrtiarihyj = new ExDBFieldString<>("zrnsinseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsnkykyouibokijyukbn = new ExDBFieldString<>("zrnsnkykyouibokijyukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokusitujyuusitusetkbn = new ExDBFieldString<>("zrntokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("zrnsiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnpmensugugtganhsyunshyj = new ExDBFieldString<>("zrnpmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntkykgyousekihyjszerohyj = new ExDBFieldString<>("zrntkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin7 = new ExDBFieldString<>("zrnsuuriyouyobin7", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyussaikeitaikbn = new ExDBFieldString<>("zrnsyussaikeitaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobiv8 = new ExDBFieldString<>("zrnsuuriyouyobiv8", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsinsakbn = new ExDBFieldString<>("zrnsinsakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2hihokensyasinsakbn = new ExDBFieldString<>("zrndai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2toukeiyousinsakbn = new ExDBFieldString<>("zrndai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnketteikijyunkanwakbn = new ExDBFieldString<>("zrnketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkihonsibouhyoukbn = new ExDBFieldString<>("zrnkihonsibouhyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnteikisibouhyoukbn = new ExDBFieldString<>("zrnteikisibouhyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsonotasibouhyoukbn = new ExDBFieldString<>("zrnsonotasibouhyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmrarihyj = new ExDBFieldString<>("zrnmrarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsentakujyouhouarihyouji = new ExDBFieldString<>("zrnsentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndugktnknsntkhuhukbn = new ExDBFieldString<>("zrndugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnjidoukousinkykkanyuuymd = new ExDBFieldString<>("zrnjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsaikohtnknkykkykymd = new ExDBFieldString<>("zrnsaikohtnknkykkykymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkousinmaesykyksburtkbn = new ExDBFieldString<>("zrnkousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhjncd = new ExDBFieldString<>("zrnhjncd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhjnjigyosyocd = new ExDBFieldString<>("zrnhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsaihokenno = new ExDBFieldString<>("zrnsaihokenno", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndakuhikettikekkacd = new ExDBFieldString<>("zrndakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2dakuhiketteikekkacd = new ExDBFieldString<>("zrndai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnpmenkbnv2 = new ExDBFieldString<>("zrnpmenkbnv2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsiboukyuuhukin = new ExDBFieldNumber<>("zrnsiboukyuuhukin", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnjyudthumeharaitkykhkhyj = new ExDBFieldString<>("zrnjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkyksyaagetyouseihyj = new ExDBFieldString<>("zrnkyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmusentakukeiyakukbn = new ExDBFieldString<>("zrnmusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv6x2 = new ExDBFieldString<>("zrnyobiv6x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnlivingneedssiharaihyouji = new ExDBFieldString<>("zrnlivingneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnlnseikyuuymd = new ExDBFieldString<>("zrnlnseikyuuymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnlnshrgenincd = new ExDBFieldString<>("zrnlnshrgenincd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndai2dakuhiketteisyacd = new ExDBFieldString<>("zrndai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrngansapotokuyakuarihyouji = new ExDBFieldString<>("zrngansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrngnspshrhyj = new ExDBFieldString<>("zrngnspshrhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrngansaposeikyuuymd = new ExDBFieldString<>("zrngansaposeikyuuymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrngnspshrgenincd = new ExDBFieldString<>("zrngnspshrgenincd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv3x2 = new ExDBFieldString<>("zrnyobiv3x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntargetmokuhyouritu = new ExDBFieldString<>("zrntargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnautoswitchmokuhyouritu = new ExDBFieldString<>("zrnautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntumitatekinitenarihyj = new ExDBFieldString<>("zrntumitatekinitenarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntumitatekinitenkaisuu = new ExDBFieldString<>("zrntumitatekinitenkaisuu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndatakanrino2 = new ExDBFieldString<>("zrndatakanrino2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndatakanrino3 = new ExDBFieldString<>("zrndatakanrino3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnknkuzusnzyrttekinendo = new ExDBFieldString<>("zrnknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnknkuzusnzyrtx2 = new ExDBFieldString<>("zrnknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnknkuzusnzyrtx3 = new ExDBFieldString<>("zrnknkuzusnzyrtx3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("zrnsinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanjiknkuzusnzyrt = new ExDBFieldString<>("zrntenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsinkeiyakujivithkhyouji = new ExDBFieldString<>("zrnsinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkykjivithukusuukykhyj = new ExDBFieldString<>("zrnkykjivithukusuukykhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin9x2 = new ExDBFieldString<>("zrnsuuriyouyobin9x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin9 = new ExDBFieldString<>("zrnsuuriyouyobin9", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin10x7 = new ExDBFieldString<>("zrnsuuriyouyobin10x7", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin10x8 = new ExDBFieldString<>("zrnsuuriyouyobin10x8", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin10x9 = new ExDBFieldString<>("zrnsuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntumitatekinitenbubun = new ExDBFieldNumber<>("zrntumitatekinitenbubun", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsagakusknnjynbknzndk = new ExDBFieldNumber<>("zrnsagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x10 = new ExDBFieldNumber<>("zrnyobin11x10", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x11 = new ExDBFieldNumber<>("zrnyobin11x11", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x12 = new ExDBFieldNumber<>("zrnyobin11x12", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x13 = new ExDBFieldNumber<>("zrnyobin11x13", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x14 = new ExDBFieldNumber<>("zrnyobin11x14", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x15 = new ExDBFieldNumber<>("zrnyobin11x15", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x16 = new ExDBFieldNumber<>("zrnyobin11x16", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x17 = new ExDBFieldNumber<>("zrnyobin11x17", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzyrthntiyustatuskbnx2 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzyrthntiyustatuskbnx3 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzyrthntiyustatuskbnx4 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzyrthntiyustatuskbnx5 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv15x2 = new ExDBFieldString<>("zrnyobiv15x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv15x3 = new ExDBFieldString<>("zrnyobiv15x3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv15x4 = new ExDBFieldString<>("zrnyobiv15x4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnkawaserate1 = new ExDBFieldString<>("zrnkawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkawaseratetekiyouymd1 = new ExDBFieldString<>("zrnkawaseratetekiyouymd1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnkawaserate2 = new ExDBFieldString<>("zrnkawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkawaseratetekiyouymd2 = new ExDBFieldString<>("zrnkawaseratetekiyouymd2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnkykjikawaserate = new ExDBFieldString<>("zrnkykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkykjikawaseratetkyuymd = new ExDBFieldString<>("zrnkykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnkaiyakukoujyoritu = new ExDBFieldString<>("zrnkaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("zrnsrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnmvakeisankijyunymd = new ExDBFieldString<>("zrnmvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnenkdtsbujsitihsyucost = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("zrnenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkaigomaebaraitkykarihyj = new ExDBFieldString<>("zrnkaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsibouhyoukbn = new ExDBFieldString<>("zrnsibouhyoukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnnyuukintuukakbn = new ExDBFieldString<>("zrnnyuukintuukakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsiharaituukakbn = new ExDBFieldString<>("zrnsiharaituukakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnwyendttargetmokuhyouritu = new ExDBFieldString<>("zrnwyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnteirituikouhyouji = new ExDBFieldString<>("zrnteirituikouhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin10x11 = new ExDBFieldString<>("zrnsuuriyouyobin10x11", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrntmttknzoukaritujygn = new ExDBFieldString<>("zrntmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsetteibairitu = new ExDBFieldString<>("zrnsetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrntykzenoutouymdsisuu = new ExDBFieldString<>("zrntykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnkimatusisuu = new ExDBFieldString<>("zrnkimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyenkadatekihons = new ExDBFieldNumber<>("zrnyenkadatekihons", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsitihsyumegkdtsibous = new ExDBFieldNumber<>("zrnsitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnenkdtssrentumitatekin = new ExDBFieldNumber<>("zrnenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsisuurentumitatekin = new ExDBFieldNumber<>("zrnsisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnnksjitirttumitatekin = new ExDBFieldNumber<>("zrnnksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkimatutirttumitatekin = new ExDBFieldNumber<>("zrnkimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngaikadatejyuutoup = new ExDBFieldNumber<>("zrngaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyendttargetkijyunkingaku = new ExDBFieldNumber<>("zrnyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsitivkisnyukykjikwsrate = new ExDBFieldString<>("zrnsitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsisuurentyokugotmttkn = new ExDBFieldNumber<>("zrnsisuurentyokugotmttkn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnyoteiririturironbase = new ExDBFieldString<>("zrnyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnyoteiriritujtnyknbase = new ExDBFieldString<>("zrnyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkihrkmpjtnyknbase = new ExDBFieldNumber<>("zrnkihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsyuptumitatekin = new ExDBFieldNumber<>("zrnsyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsyuptumitatekingsc = new ExDBFieldNumber<>("zrnsyuptumitatekingsc", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngaikadatenkgns = new ExDBFieldNumber<>("zrngaikadatenkgns", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnjikaipjyuutouym2 = new ExDBFieldString<>("zrnjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Integer> zrnsuuriyobin9 = new ExDBFieldNumber<>("zrnsuuriyobin9", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngessitumitatekin = new ExDBFieldNumber<>("zrngessitumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngaikadatetougetujuutoup = new ExDBFieldNumber<>("zrngaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkihrkmpmsukisymbase = new ExDBFieldNumber<>("zrnkihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkeisanhanteiyoutmttkn = new ExDBFieldNumber<>("zrnkeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngtmtv = new ExDBFieldNumber<>("zrngtmtv", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnzettaisibouritu = new ExDBFieldString<>("zrnzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsoutaisibouritu = new ExDBFieldString<>("zrnsoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnsoutaikaiyakuritu = new ExDBFieldString<>("zrnsoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnvhireilritu2 = new ExDBFieldString<>("zrnvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnphireialpha = new ExDBFieldString<>("zrnphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnphireibeta = new ExDBFieldString<>("zrnphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnphireiganma = new ExDBFieldString<>("zrnphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnphireilwrbkritu = new ExDBFieldString<>("zrnphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnyoteiriritumsukisymbase = new ExDBFieldString<>("zrnyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("zrnrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnrrthnduhknvkiso = new ExDBFieldNumber<>("zrnrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntumitatekin = new ExDBFieldNumber<>("zrntumitatekin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkykkjmmvatyouseigow = new ExDBFieldNumber<>("zrnkykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x39 = new ExDBFieldNumber<>("zrnyobin11x39", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x41 = new ExDBFieldNumber<>("zrnyobin11x41", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x42 = new ExDBFieldNumber<>("zrnyobin11x42", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x43 = new ExDBFieldNumber<>("zrnyobin11x43", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x44 = new ExDBFieldNumber<>("zrnyobin11x44", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x45 = new ExDBFieldNumber<>("zrnyobin11x45", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin15x3 = new ExDBFieldString<>("zrnsuuriyouyobin15x3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin15x4 = new ExDBFieldString<>("zrnsuuriyouyobin15x4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin15x5 = new ExDBFieldString<>("zrnsuuriyouyobin15x5", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin15x6 = new ExDBFieldString<>("zrnsuuriyouyobin15x6", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkyksyhhknsydouituhyouji = new ExDBFieldString<>("zrnkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkyksyaskinmeino = new ExDBFieldString<>("zrnkyksyaskinmeino", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeikihons = new ExDBFieldNumber<>("zrngoukeikihons", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeigyousekihyjsibous = new ExDBFieldNumber<>("zrngoukeigyousekihyjsibous", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnalmyousibous = new ExDBFieldNumber<>("zrnalmyousibous", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsiteizukiharaikomip = new ExDBFieldNumber<>("zrnsiteizukiharaikomip", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsaisyuusiteimhrkp = new ExDBFieldNumber<>("zrnsaisyuusiteimhrkp", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeinenbaraikansanp = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrngyousekihyoujisrank = new ExDBFieldString<>("zrngyousekihyoujisrank", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, BizNumber> zrnteikibairitu = new ExDBFieldString<>("zrnteikibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkangodatakanrino = new ExDBFieldString<>("zrntenkangodatakanrino", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaitekykdatakanrino1 = new ExDBFieldString<>("zrnaitekykdatakanrino1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaitekykdatakanrino2 = new ExDBFieldString<>("zrnaitekykdatakanrino2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknsyokaipcashlesshyj = new ExDBFieldString<>("zrntnknsyokaipcashlesshyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyokaipannaikbn = new ExDBFieldString<>("zrnsyokaipannaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzennoukaisiymd = new ExDBFieldString<>("zrnzennoukaisiymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnzennoukikan = new ExDBFieldString<>("zrnzennoukikan", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnseizonkyuuhukinsiteiy = new ExDBFieldString<>("zrnseizonkyuuhukinsiteiy", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnalmyouseizonkyhknsiteimd = new ExDBFieldString<>("zrnalmyouseizonkyhknsiteimd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkkn3x1 = new ExDBFieldString<>("zrnhktgtikkikkkn3x1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkkn3x2 = new ExDBFieldString<>("zrnhktgtikkikkkn3x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkkn3x3 = new ExDBFieldString<>("zrnhktgtikkikkkn3x3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkkn3x4 = new ExDBFieldString<>("zrnhktgtikkikkkn3x4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkappadkeisankbnx1 = new ExDBFieldString<>("zrnkappadkeisankbnx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkappadkeisankbnx2 = new ExDBFieldString<>("zrnkappadkeisankbnx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkappadkeisankbnx3 = new ExDBFieldString<>("zrnkappadkeisankbnx3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkappadkeisankbnx4 = new ExDBFieldString<>("zrnkappadkeisankbnx4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv6x3 = new ExDBFieldString<>("zrnyobiv6x3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkimatuvyoutumimasikin = new ExDBFieldNumber<>("zrnkimatuvyoutumimasikin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkmtvyusnhknfundtmttkin = new ExDBFieldNumber<>("zrnkmtvyusnhknfundtmttkin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeinenkansanp3x1 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeinenkansanp3x2 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeinenkansanp3x3 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeinenkansanp3x4 = new ExDBFieldNumber<>("zrngoukeinenkansanp3x4", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkmtvyuhijynbritmttkin = new ExDBFieldNumber<>("zrnkmtvyuhijynbritmttkin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkimatuvyouitjbrtmttkin = new ExDBFieldNumber<>("zrnkimatuvyouitjbrtmttkin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x26 = new ExDBFieldNumber<>("zrnyobin11x26", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x27 = new ExDBFieldNumber<>("zrnyobin11x27", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x28 = new ExDBFieldNumber<>("zrnyobin11x28", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x29 = new ExDBFieldNumber<>("zrnyobin11x29", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x30 = new ExDBFieldNumber<>("zrnyobin11x30", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x31 = new ExDBFieldNumber<>("zrnyobin11x31", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x32 = new ExDBFieldNumber<>("zrnyobin11x32", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x33 = new ExDBFieldNumber<>("zrnyobin11x33", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhaitouyouloadingkijyuns = new ExDBFieldNumber<>("zrnhaitouyouloadingkijyuns", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntouduketorihouhoukbn = new ExDBFieldString<>("zrntouduketorihouhoukbn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntumitated = new ExDBFieldNumber<>("zrntumitated", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkariwariated = new ExDBFieldNumber<>("zrnkariwariated", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntyokuzensiharaikijitu = new ExDBFieldString<>("zrntyokuzensiharaikijitu", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntyokuzentuusanhanteis = new ExDBFieldNumber<>("zrntyokuzentuusanhanteis", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntyokugosiharaikijitu = new ExDBFieldString<>("zrntyokugosiharaikijitu", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntyokugotuusanhanteis = new ExDBFieldNumber<>("zrntyokugotuusanhanteis", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntyokugokyuuhutaisyous = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyous", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntyokugocbkingaku = new ExDBFieldNumber<>("zrntyokugocbkingaku", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyokaisiharaikijitu = new ExDBFieldString<>("zrnsyokaisiharaikijitu", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsyokaituusanhanteis = new ExDBFieldNumber<>("zrnsyokaituusanhanteis", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrncbnayosetuusanhanteis = new ExDBFieldNumber<>("zrncbnayosetuusanhanteis", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhitenkankeiyakusuu = new ExDBFieldString<>("zrnhitenkankeiyakusuu", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrngoukeipbubuntenkanteikis = new ExDBFieldNumber<>("zrngoukeipbubuntenkanteikis", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsaidaihktgtikkikkkn = new ExDBFieldString<>("zrnsaidaihktgtikkikkkn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsisyutnknhktgkujygk = new ExDBFieldNumber<>("zrnsisyutnknhktgkujygk", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x34 = new ExDBFieldNumber<>("zrnyobin11x34", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhtnknkykkykymdx1 = new ExDBFieldString<>("zrnhtnknkykkykymdx1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnkntkbtdkisnyusx1 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknkaiykkujytksux1 = new ExDBFieldString<>("zrntnknkaiykkujytksux1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnknkaiykkujygkx1 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikihyoujix1 = new ExDBFieldString<>("zrntenkanteikihyoujix1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhtnknkyknenknsnpx1 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkknx1 = new ExDBFieldString<>("zrnhktgtikkikkknx1", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhtnknkykkykymdx2 = new ExDBFieldString<>("zrnhtnknkykkykymdx2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnkntkbtdkisnyusx2 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknkaiykkujytksux2 = new ExDBFieldString<>("zrntnknkaiykkujytksux2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnknkaiykkujygkx2 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikihyoujix2 = new ExDBFieldString<>("zrntenkanteikihyoujix2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhtnknkyknenknsnpx2 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkknx2 = new ExDBFieldString<>("zrnhktgtikkikkknx2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhtnknkykkykymdx3 = new ExDBFieldString<>("zrnhtnknkykkykymdx3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnkntkbtdkisnyusx3 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknkaiykkujytksux3 = new ExDBFieldString<>("zrntnknkaiykkujytksux3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnknkaiykkujygkx3 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikihyoujix3 = new ExDBFieldString<>("zrntenkanteikihyoujix3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhtnknkyknenknsnpx3 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkknx3 = new ExDBFieldString<>("zrnhktgtikkikkknx3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhtnknkykkykymdx4 = new ExDBFieldString<>("zrnhtnknkykkykymdx4", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnkntkbtdkisnyusx4 = new ExDBFieldNumber<>("zrntnkntkbtdkisnyusx4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntnknkaiykkujytksux4 = new ExDBFieldString<>("zrntnknkaiykkujytksux4", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntnknkaiykkujygkx4 = new ExDBFieldNumber<>("zrntnknkaiykkujygkx4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikihyoujix4 = new ExDBFieldString<>("zrntenkanteikihyoujix4", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnhtnknkyknenknsnpx4 = new ExDBFieldNumber<>("zrnhtnknkyknenknsnpx4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhktgtikkikkknx4 = new ExDBFieldString<>("zrnhktgtikkikkknx4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsknjyututkykkykkbn = new ExDBFieldString<>("zrnsknjyututkykkykkbn", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnswingminyuuphrkekngk = new ExDBFieldNumber<>("zrnswingminyuuphrkekngk", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnswingminyuuphrkejyutuym = new ExDBFieldString<>("zrnswingminyuuphrkejyutuym", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrndftounendoitijitounyuup = new ExDBFieldNumber<>("zrndftounendoitijitounyuup", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrndfkaiyakukujyhktggk = new ExDBFieldNumber<>("zrndfkaiyakukujyhktggk", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkaiyakukoujyotukisuu = new ExDBFieldString<>("zrnkaiyakukoujyotukisuu", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrndfkaiyakuhenreikin = new ExDBFieldNumber<>("zrndfkaiyakuhenreikin", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnsyuuseis = new ExDBFieldNumber<>("zrnsyuuseis", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaatukaisyakeisyousisyacd = new ExDBFieldString<>("zrnaatukaisyakeisyousisyacd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaatukaisyazaisekihyouji = new ExDBFieldString<>("zrnaatukaisyazaisekihyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaatukaisyabosyuujiage = new ExDBFieldString<>("zrnaatukaisyabosyuujiage", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaatukaisyabsyjisikakucd = new ExDBFieldString<>("zrnaatukaisyabsyjisikakucd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnaatukaisyasikakucd = new ExDBFieldString<>("zrnaatukaisyasikakucd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnokyksmkuztrhkkitikbn = new ExDBFieldString<>("zrnokyksmkuztrhkkitikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhoyuusisyacd = new ExDBFieldString<>("zrnhoyuusisyacd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyokansisyacd = new ExDBFieldString<>("zrnsyokansisyacd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntantousyakbn = new ExDBFieldString<>("zrntantousyakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntantousyakbnnew = new ExDBFieldString<>("zrntantousyakbnnew", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnclubsumiseikbn = new ExDBFieldString<>("zrnclubsumiseikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnfollowtantousyakbn = new ExDBFieldString<>("zrnfollowtantousyakbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntantousyajyoutaikbn = new ExDBFieldString<>("zrntantousyajyoutaikbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkihonyoteii = new ExDBFieldString<>("zrnkihonyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnteikiyoteii = new ExDBFieldString<>("zrnteikiyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsonotayoteii = new ExDBFieldString<>("zrnsonotayoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnitijibaraikihonyoteii = new ExDBFieldString<>("zrnitijibaraikihonyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnitijibaraiteikiyoteii = new ExDBFieldString<>("zrnitijibaraiteikiyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnitijibaraisonotayoteii = new ExDBFieldString<>("zrnitijibaraisonotayoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkankihonyoteii = new ExDBFieldString<>("zrntenkankihonyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntenkanteikiyoteii = new ExDBFieldString<>("zrntenkanteikiyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnszouyoteii = new ExDBFieldString<>("zrnszouyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnvestingyoteii = new ExDBFieldString<>("zrnvestingyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsippeitokuyakuyoteii = new ExDBFieldString<>("zrnsippeitokuyakuyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnseijinbyoutokuyakuyoteii = new ExDBFieldString<>("zrnseijinbyoutokuyakuyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnjyoseitokuyakuyoteii = new ExDBFieldString<>("zrnjyoseitokuyakuyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntuuintokuyakuyoteii = new ExDBFieldString<>("zrntuuintokuyakuyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsaiteihosyoui = new ExDBFieldString<>("zrnsaiteihosyoui", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnvkisoitjbrkhnyoteii = new ExDBFieldString<>("zrnvkisoitjbrkhnyoteii", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnvkisorrtzeroikahyouji = new ExDBFieldString<>("zrnvkisorrtzeroikahyouji", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin3x2 = new ExDBFieldString<>("zrnsuuriyouyobin3x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhoyuusisyacd2 = new ExDBFieldString<>("zrnhoyuusisyacd2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrndftujyukujykisnkisiym = new ExDBFieldString<>("zrndftujyukujykisnkisiym", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntikikktbrijyututksu = new ExDBFieldString<>("zrntikikktbrijyututksu", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsyunyumrtikykjtigngtkbn = new ExDBFieldString<>("zrnsyunyumrtikykjtigngtkbn", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnhhkdrtkykarihyj = new ExDBFieldString<>("zrnhhkdrtkykarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnyobiv10x14 = new ExDBFieldString<>("zrnyobiv10x14", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkappadhktgkujygkx1 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx1", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkappadhktgkujygkx2 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx2", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkappadhktgkujygkx3 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx3", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnkappadhktgkujygkx4 = new ExDBFieldNumber<>("zrnkappadhktgkujygkx4", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrntrkzsgkaiykkjynstmtkzndk = new ExDBFieldNumber<>("zrntrkzsgkaiykkjynstmtkzndk", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnpmenkouryokuhasseiymd = new ExDBFieldString<>("zrnpmenkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin5 = new ExDBFieldString<>("zrnsuuriyouyobin5", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrnsuuriyouyobin13 = new ExDBFieldString<>("zrnsuuriyouyobin13", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x35 = new ExDBFieldNumber<>("zrnyobin11x35", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x36 = new ExDBFieldNumber<>("zrnyobin11x36", this);

    public final ExDBFieldNumber<ZT_IdouMeisaiRn, Long> zrnyobin11x37 = new ExDBFieldNumber<>("zrnyobin11x37", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200 = new ExDBFieldString<>("zrntokuyakukoumokuv200", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x2 = new ExDBFieldString<>("zrntokuyakukoumokuv200x2", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x3 = new ExDBFieldString<>("zrntokuyakukoumokuv200x3", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x4 = new ExDBFieldString<>("zrntokuyakukoumokuv200x4", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x5 = new ExDBFieldString<>("zrntokuyakukoumokuv200x5", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x6 = new ExDBFieldString<>("zrntokuyakukoumokuv200x6", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x7 = new ExDBFieldString<>("zrntokuyakukoumokuv200x7", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x8 = new ExDBFieldString<>("zrntokuyakukoumokuv200x8", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x9 = new ExDBFieldString<>("zrntokuyakukoumokuv200x9", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x10 = new ExDBFieldString<>("zrntokuyakukoumokuv200x10", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x11 = new ExDBFieldString<>("zrntokuyakukoumokuv200x11", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x12 = new ExDBFieldString<>("zrntokuyakukoumokuv200x12", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x13 = new ExDBFieldString<>("zrntokuyakukoumokuv200x13", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x14 = new ExDBFieldString<>("zrntokuyakukoumokuv200x14", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x15 = new ExDBFieldString<>("zrntokuyakukoumokuv200x15", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x16 = new ExDBFieldString<>("zrntokuyakukoumokuv200x16", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x17 = new ExDBFieldString<>("zrntokuyakukoumokuv200x17", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x18 = new ExDBFieldString<>("zrntokuyakukoumokuv200x18", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x19 = new ExDBFieldString<>("zrntokuyakukoumokuv200x19", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x20 = new ExDBFieldString<>("zrntokuyakukoumokuv200x20", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x21 = new ExDBFieldString<>("zrntokuyakukoumokuv200x21", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x22 = new ExDBFieldString<>("zrntokuyakukoumokuv200x22", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x23 = new ExDBFieldString<>("zrntokuyakukoumokuv200x23", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x24 = new ExDBFieldString<>("zrntokuyakukoumokuv200x24", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x25 = new ExDBFieldString<>("zrntokuyakukoumokuv200x25", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x26 = new ExDBFieldString<>("zrntokuyakukoumokuv200x26", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x27 = new ExDBFieldString<>("zrntokuyakukoumokuv200x27", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x28 = new ExDBFieldString<>("zrntokuyakukoumokuv200x28", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x29 = new ExDBFieldString<>("zrntokuyakukoumokuv200x29", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x30 = new ExDBFieldString<>("zrntokuyakukoumokuv200x30", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x31 = new ExDBFieldString<>("zrntokuyakukoumokuv200x31", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x32 = new ExDBFieldString<>("zrntokuyakukoumokuv200x32", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x33 = new ExDBFieldString<>("zrntokuyakukoumokuv200x33", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x34 = new ExDBFieldString<>("zrntokuyakukoumokuv200x34", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x35 = new ExDBFieldString<>("zrntokuyakukoumokuv200x35", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x36 = new ExDBFieldString<>("zrntokuyakukoumokuv200x36", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x37 = new ExDBFieldString<>("zrntokuyakukoumokuv200x37", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x38 = new ExDBFieldString<>("zrntokuyakukoumokuv200x38", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x39 = new ExDBFieldString<>("zrntokuyakukoumokuv200x39", this);

    public final ExDBFieldString<ZT_IdouMeisaiRn, String> zrntokuyakukoumokuv200x40 = new ExDBFieldString<>("zrntokuyakukoumokuv200x40", this);
}
