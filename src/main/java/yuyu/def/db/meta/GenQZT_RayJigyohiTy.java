package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RayJigyohiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＲＡＹ事業費Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RayJigyohiTy extends AbstractExDBTable<ZT_RayJigyohiTy> {

    public GenQZT_RayJigyohiTy() {
        this("ZT_RayJigyohiTy");
    }

    public GenQZT_RayJigyohiTy(String pAlias) {
        super("ZT_RayJigyohiTy", ZT_RayJigyohiTy.class, pAlias);
    }

    public String ZT_RayJigyohiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztynenkinkaisigohyouji = new ExDBFieldString<>("ztynenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztynksgokurikosidhyj = new ExDBFieldString<>("ztynksgokurikosidhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyidojiyukbn = new ExDBFieldString<>("ztyidojiyukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyzougenkbn = new ExDBFieldString<>("ztyzougenkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyidourecordkbn = new ExDBFieldString<>("ztyidourecordkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykeijyouctrlkbn = new ExDBFieldString<>("ztykeijyouctrlkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztykykmfksnctr = new ExDBFieldNumber<>("ztykykmfksnctr", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztyrecordctr = new ExDBFieldNumber<>("ztyrecordctr", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyoukouryokukaisiymd = new ExDBFieldString<>("ztysuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztybluekeizokuhyouji = new ExDBFieldString<>("ztybluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytoukeikeijyoukbn = new ExDBFieldString<>("ztytoukeikeijyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyzenkiidouteiseikbn = new ExDBFieldString<>("ztyzenkiidouteiseikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkangokeiyakubosyuuym = new ExDBFieldString<>("ztytenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyidoujiyuucd = new ExDBFieldString<>("ztyidoujiyuucd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysekininteiseihyouji = new ExDBFieldString<>("ztysekininteiseihyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysihankibikinkbn = new ExDBFieldString<>("ztysihankibikinkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin1x3 = new ExDBFieldString<>("ztysuuriyouyobin1x3", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhosyoukinoukbn = new ExDBFieldString<>("ztyhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydaikbn = new ExDBFieldString<>("ztydaikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytyuukbn = new ExDBFieldString<>("ztytyuukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysyoukbn = new ExDBFieldString<>("ztysyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysedaikbn = new ExDBFieldString<>("ztysedaikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyao3tyou3sibousdatehyouji = new ExDBFieldString<>("ztyao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytkbthsyumnryuhyouji = new ExDBFieldString<>("ztytkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysyukeiyakupwaribikikbn = new ExDBFieldString<>("ztysyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanwaribikikbn = new ExDBFieldString<>("ztytenkanwaribikikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("ztyyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysiteizukisyukeiyakup = new ExDBFieldNumber<>("ztysiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhenkougokihons = new ExDBFieldNumber<>("ztyhenkougokihons", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhenkougosibous = new ExDBFieldNumber<>("ztyhenkougosibous", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhenkouymd = new ExDBFieldString<>("ztyhenkouymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyentyoukikan = new ExDBFieldString<>("ztyentyoukikan", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyseizonkyuuhukinsiteimd = new ExDBFieldString<>("ztyseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysyukeiyakusiharaikingaku = new ExDBFieldNumber<>("ztysyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyatukaisisyatodouhukencd = new ExDBFieldString<>("ztyatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztytokuyakuhukasuu = new ExDBFieldNumber<>("ztytokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydi2hknkknikoujihisyaage = new ExDBFieldString<>("ztydi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrimnentyoumaephrkkkn = new ExDBFieldString<>("ztyhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrizmjhknsyukigousdkbn = new ExDBFieldString<>("ztyhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykrsgjhknsyukigousdkbn = new ExDBFieldString<>("ztykrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysotodasisyouhinkaiteikbn = new ExDBFieldString<>("ztysotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygoukeipbubuntenkans = new ExDBFieldNumber<>("ztygoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanteikisyuruikigou = new ExDBFieldString<>("ztytenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanteikikigousedaikbn = new ExDBFieldString<>("ztytenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytnkntiksotodasikusnkbn = new ExDBFieldString<>("ztytnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytnkntikstdspmenkbn = new ExDBFieldString<>("ztytnkntikstdspmenkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanteikikigouyobi = new ExDBFieldString<>("ztytenkanteikikigouyobi", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanteikikikan = new ExDBFieldString<>("ztytenkanteikikikan", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytnknteikinkshrkkn = new ExDBFieldString<>("ztytnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytenkansiharaikingaku = new ExDBFieldNumber<>("ztytenkansiharaikingaku", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytnkntikshrkngk = new ExDBFieldNumber<>("ztytnkntikshrkngk", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygoukeitenkankakaku = new ExDBFieldNumber<>("ztygoukeitenkankakaku", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztytnknkhnbbnjyuturt = new ExDBFieldString<>("ztytnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztywnasigoukeitenkanteikis = new ExDBFieldNumber<>("ztywnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytnknteikikousinmnryouage = new ExDBFieldString<>("ztytnknteikikousinmnryouage", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykanyujidatakanrino = new ExDBFieldString<>("ztykanyujidatakanrino", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykanyujikykymd = new ExDBFieldString<>("ztykanyujikykymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykanyuujihihokensyaage = new ExDBFieldString<>("ztykanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykanyuujitenkanhyouji = new ExDBFieldString<>("ztykanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhsyuikktminaosikaisu = new ExDBFieldString<>("ztyhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysknnjynbknsisnrt = new ExDBFieldString<>("ztysknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysakugenkikan = new ExDBFieldString<>("ztysakugenkikan", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysykyktkjyuryumsratehyj = new ExDBFieldString<>("ztysykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysykyktkjyuryumsrate = new ExDBFieldString<>("ztysykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2sakugenkikan = new ExDBFieldString<>("ztydai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytokuteibuijyoukenhyouji = new ExDBFieldString<>("ztytokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytokuteibuino1 = new ExDBFieldString<>("ztytokuteibuino1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhtnpkkn1 = new ExDBFieldString<>("ztyhtnpkkn1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytokuteibuino2 = new ExDBFieldString<>("ztytokuteibuino2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhtnpkkn2 = new ExDBFieldString<>("ztyhtnpkkn2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymhituiryuyutktbijyknhyj = new ExDBFieldString<>("ztymhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymuhaitouiryouyoutktbino1 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymuhaitouiryouyoutktbino2 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysiteizukipwarimasihyouji = new ExDBFieldString<>("ztysiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysiteimsykykpbairitu = new ExDBFieldString<>("ztysiteimsykykpbairitu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysykykkitmttvkeisanym = new ExDBFieldString<>("ztysykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("ztysykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztydftumitatekingaku = new ExDBFieldNumber<>("ztydftumitatekingaku", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztydftumimasikin = new ExDBFieldNumber<>("ztydftumimasikin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyvbubundftenkankakaku = new ExDBFieldNumber<>("ztyvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztydpbubundftenkankakaku = new ExDBFieldNumber<>("ztydpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztydftmttkngkitjbrbbn = new ExDBFieldNumber<>("ztydftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhendous = new ExDBFieldNumber<>("ztyhendous", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhengakujigyounendomatucv = new ExDBFieldNumber<>("ztyhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyitibitjbrshrkngk = new ExDBFieldNumber<>("ztyitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygoukeicv = new ExDBFieldNumber<>("ztygoukeicv", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyminasicv = new ExDBFieldNumber<>("ztyminasicv", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyloanfund = new ExDBFieldNumber<>("ztyloanfund", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysaiteihosyougaku = new ExDBFieldNumber<>("ztysaiteihosyougaku", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhngksitihsyuyusykykp = new ExDBFieldNumber<>("ztyhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysiinkbn = new ExDBFieldString<>("ztysiinkbn", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztymudkaimasikihons = new ExDBFieldNumber<>("ztymudkaimasikihons", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykaimasiymd = new ExDBFieldString<>("ztykaimasiymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykaimasikikan = new ExDBFieldString<>("ztykaimasikikan", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyhikitugikaimasis = new ExDBFieldNumber<>("ztyhikitugikaimasis", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztymudkaimasisiharaikingaku = new ExDBFieldNumber<>("ztymudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoukouryokukaisiymdx1 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszouhokensyuruikigoux1 = new ExDBFieldString<>("ztyszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoukigousedaikbnx1 = new ExDBFieldString<>("ztyszoukigousedaikbnx1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoukikanx1 = new ExDBFieldString<>("ztyszoukikanx1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszouhihokensyaagex1 = new ExDBFieldString<>("ztyszouhihokensyaagex1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoudai2hihknsyaagex1 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyzoukasx1 = new ExDBFieldNumber<>("ztyzoukasx1", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyzennendozoukasx1 = new ExDBFieldNumber<>("ztyzennendozoukasx1", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyszousiharaikingakux1 = new ExDBFieldNumber<>("ztyszousiharaikingakux1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoukouryokukaisiymdx2 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszouhokensyuruikigoux2 = new ExDBFieldString<>("ztyszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoukigousedaikbnx2 = new ExDBFieldString<>("ztyszoukigousedaikbnx2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoukikanx2 = new ExDBFieldString<>("ztyszoukikanx2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszouhihokensyaagex2 = new ExDBFieldString<>("ztyszouhihokensyaagex2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoudai2hihknsyaagex2 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyzoukasx2 = new ExDBFieldNumber<>("ztyzoukasx2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyzennendozoukasx2 = new ExDBFieldNumber<>("ztyzennendozoukasx2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyszousiharaikingakux2 = new ExDBFieldNumber<>("ztyszousiharaikingakux2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin1x5 = new ExDBFieldString<>("ztysuuriyouyobin1x5", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin1x6 = new ExDBFieldString<>("ztysuuriyouyobin1x6", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrimngkizktkykpmenhyj = new ExDBFieldString<>("ztyhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymisyuustartym = new ExDBFieldString<>("ztymisyuustartym", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymisyuukaisuu = new ExDBFieldString<>("ztymisyuukaisuu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("ztyitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygyousekihyoujis = new ExDBFieldNumber<>("ztygyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysykykgyusekihyjs = new ExDBFieldNumber<>("ztysykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytenkangyousekihyoujis = new ExDBFieldNumber<>("ztytenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytnknteikigyousekihyjs = new ExDBFieldNumber<>("ztytnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytnkndpbbngyuskhyjs = new ExDBFieldNumber<>("ztytnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykykjyoutai = new ExDBFieldString<>("ztykykjyoutai", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymankiyoteikbn = new ExDBFieldString<>("ztymankiyoteikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysykyktikmnkyoteikbn = new ExDBFieldString<>("ztysykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytnknsykykkhnmnkytikbn = new ExDBFieldString<>("ztytnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytnknsykyktikmnkytikbn = new ExDBFieldString<>("ztytnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanteikimankiyoteikbn = new ExDBFieldString<>("ztytenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoumankiyoteikbnx1 = new ExDBFieldString<>("ztyszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyszoumankiyoteikbnx2 = new ExDBFieldString<>("ztyszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyvestingmankiyoteikbn = new ExDBFieldString<>("ztyvestingmankiyoteikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyvkeisanhyouji = new ExDBFieldString<>("ztyvkeisanhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytoukisinkeiyakuhyouji = new ExDBFieldString<>("ztytoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysykykhokenhoutekiyouhyj = new ExDBFieldString<>("ztysykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyytirrthndsysnmnskaisuu = new ExDBFieldString<>("ztyytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin3 = new ExDBFieldString<>("ztysuuriyouyobin3", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin11 = new ExDBFieldString<>("ztysuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztywnasigoukeitenkankakaku = new ExDBFieldNumber<>("ztywnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytukibaraikansantokujyoup = new ExDBFieldNumber<>("ztytukibaraikansantokujyoup", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytnkngkykkssnkijyuym = new ExDBFieldString<>("ztytnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysaiteihosyouhyouji = new ExDBFieldString<>("ztysaiteihosyouhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin8x2 = new ExDBFieldString<>("ztysuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin14 = new ExDBFieldString<>("ztysuuriyouyobin14", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("ztyhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrimngtkykphrkkirkbn = new ExDBFieldString<>("ztyhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhrimngtkykpryurtkbn = new ExDBFieldString<>("ztyhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv13 = new ExDBFieldString<>("ztyyobiv13", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyidoujisaiteihosyoukngk = new ExDBFieldNumber<>("ztyidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyidoujisaiteihosyoucost = new ExDBFieldNumber<>("ztyidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysinhokenfundtumitatekin = new ExDBFieldNumber<>("ztysinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztymsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("ztymsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthndugtnkgetumatuv = new ExDBFieldNumber<>("ztyrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("ztyrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthendougatanksibous = new ExDBFieldNumber<>("ztyrrthendougatanksibous", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyalmyousohutomeisyoukbn = new ExDBFieldString<>("ztyalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysnkyksoftmeisyoukbn = new ExDBFieldString<>("ztysnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysoftmeisyoukbn = new ExDBFieldString<>("ztysoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykykjitokujyouarihyj = new ExDBFieldString<>("ztykykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysoujikeitenkankbn = new ExDBFieldString<>("ztysoujikeitenkankbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztynenkingatakbn = new ExDBFieldString<>("ztynenkingatakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyheiyoubaraikeiyakukbn = new ExDBFieldString<>("ztyheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztynenkinmaruteihukakbn = new ExDBFieldString<>("ztynenkinmaruteihukakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysinseizonmrtiarihyj = new ExDBFieldString<>("ztysinseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysnkykyouibokijyukbn = new ExDBFieldString<>("ztysnkykyouibokijyukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytokusitujyuusitusetkbn = new ExDBFieldString<>("ztytokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("ztysiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztypmensugugtganhsyunshyj = new ExDBFieldString<>("ztypmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytkykgyousekihyjszerohyj = new ExDBFieldString<>("ztytkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin7 = new ExDBFieldString<>("ztysuuriyouyobin7", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysyussaikeitaikbn = new ExDBFieldString<>("ztysyussaikeitaikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobiv8 = new ExDBFieldString<>("ztysuuriyouyobiv8", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysinsakbn = new ExDBFieldString<>("ztysinsakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2hihokensyasinsakbn = new ExDBFieldString<>("ztydai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2toukeiyousinsakbn = new ExDBFieldString<>("ztydai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyketteikijyunkanwakbn = new ExDBFieldString<>("ztyketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykihonsibouhyoukbn = new ExDBFieldString<>("ztykihonsibouhyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyteikisibouhyoukbn = new ExDBFieldString<>("ztyteikisibouhyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysonotasibouhyoukbn = new ExDBFieldString<>("ztysonotasibouhyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymrarihyj = new ExDBFieldString<>("ztymrarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysentakujyouhouarihyouji = new ExDBFieldString<>("ztysentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydugktnknsntkhuhukbn = new ExDBFieldString<>("ztydugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyjidoukousinkykkanyuuymd = new ExDBFieldString<>("ztyjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysaikohtnknkykkykymd = new ExDBFieldString<>("ztysaikohtnknkykkykymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykousinmaesykyksburtkbn = new ExDBFieldString<>("ztykousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysaihokenno = new ExDBFieldString<>("ztysaihokenno", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2dakuhiketteikekkacd = new ExDBFieldString<>("ztydai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysiboukyuuhukin = new ExDBFieldNumber<>("ztysiboukyuuhukin", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyjyudthumeharaitkykhkhyj = new ExDBFieldString<>("ztyjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykituenhonsuu = new ExDBFieldString<>("ztykituenhonsuu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymusentakukeiyakukbn = new ExDBFieldString<>("ztymusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv6x2 = new ExDBFieldString<>("ztyyobiv6x2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztylivingneedssiharaihyouji = new ExDBFieldString<>("ztylivingneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztylnseikyuuymd = new ExDBFieldString<>("ztylnseikyuuymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztylnshrgenincd = new ExDBFieldString<>("ztylnshrgenincd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydai2dakuhiketteisyacd = new ExDBFieldString<>("ztydai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztygansapotokuyakuarihyouji = new ExDBFieldString<>("ztygansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztygnspshrhyj = new ExDBFieldString<>("ztygnspshrhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztygansaposeikyuuymd = new ExDBFieldString<>("ztygansaposeikyuuymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztygnspshrgenincd = new ExDBFieldString<>("ztygnspshrgenincd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytargetmokuhyouritu = new ExDBFieldString<>("ztytargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyautoswitchmokuhyouritu = new ExDBFieldString<>("ztyautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytumitatekinitenarihyj = new ExDBFieldString<>("ztytumitatekinitenarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytumitatekinitenkaisuu = new ExDBFieldString<>("ztytumitatekinitenkaisuu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyknkuzusnzyrttekinendo = new ExDBFieldString<>("ztyknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyknkuzusnzyrtx2 = new ExDBFieldString<>("ztyknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyknkuzusnzyrtx3 = new ExDBFieldString<>("ztyknkuzusnzyrtx3", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("ztysinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytenkanjiknkuzusnzyrt = new ExDBFieldString<>("ztytenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykykjivithukusuukykhyj = new ExDBFieldString<>("ztykykjivithukusuukykhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin9x2 = new ExDBFieldString<>("ztysuuriyouyobin9x2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin10x7 = new ExDBFieldString<>("ztysuuriyouyobin10x7", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin10x8 = new ExDBFieldString<>("ztysuuriyouyobin10x8", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin10x9 = new ExDBFieldString<>("ztysuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytumitatekinitenbubun = new ExDBFieldNumber<>("ztytumitatekinitenbubun", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysagakusknnjynbknzndk = new ExDBFieldNumber<>("ztysagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x11 = new ExDBFieldNumber<>("ztyyobin11x11", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x12 = new ExDBFieldNumber<>("ztyyobin11x12", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x13 = new ExDBFieldNumber<>("ztyyobin11x13", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x14 = new ExDBFieldNumber<>("ztyyobin11x14", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x15 = new ExDBFieldNumber<>("ztyyobin11x15", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x16 = new ExDBFieldNumber<>("ztyyobin11x16", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x17 = new ExDBFieldNumber<>("ztyyobin11x17", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyzyrthntiyustatuskbnx2 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyzyrthntiyustatuskbnx3 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyzyrthntiyustatuskbnx4 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyzyrthntiyustatuskbnx5 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv15x2 = new ExDBFieldString<>("ztyyobiv15x2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv15x3 = new ExDBFieldString<>("ztyyobiv15x3", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv15x4 = new ExDBFieldString<>("ztyyobiv15x4", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztykawaserate1 = new ExDBFieldString<>("ztykawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykawaseratetekiyouymd1 = new ExDBFieldString<>("ztykawaseratetekiyouymd1", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztykawaserate2 = new ExDBFieldString<>("ztykawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykawaseratetekiyouymd2 = new ExDBFieldString<>("ztykawaseratetekiyouymd2", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztykaiyakukoujyoritu = new ExDBFieldString<>("ztykaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztymvakeisankijyunymd = new ExDBFieldString<>("ztymvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyenkdtsbujsitihsyucost = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("ztyenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztykaigomaebaraitkykarihyj = new ExDBFieldString<>("ztykaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysiharaituukakbn = new ExDBFieldString<>("ztysiharaituukakbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztywyendttargetmokuhyouritu = new ExDBFieldString<>("ztywyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyteirituikouhyouji = new ExDBFieldString<>("ztyteirituikouhyouji", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin10x11 = new ExDBFieldString<>("ztysuuriyouyobin10x11", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztytykzenoutouymdsisuu = new ExDBFieldString<>("ztytykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztykimatusisuu = new ExDBFieldString<>("ztykimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyenkadatekihons = new ExDBFieldNumber<>("ztyyenkadatekihons", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysitihsyumegkdtsibous = new ExDBFieldNumber<>("ztysitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyenkdtssrentumitatekin = new ExDBFieldNumber<>("ztyenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztynksjitirttumitatekin = new ExDBFieldNumber<>("ztynksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykimatutirttumitatekin = new ExDBFieldNumber<>("ztykimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygaikadatejyuutoup = new ExDBFieldNumber<>("ztygaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyendttargetkijyunkingaku = new ExDBFieldNumber<>("ztyyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysitivkisnyukykjikwsrate = new ExDBFieldString<>("ztysitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysisuurentyokugotmttkn = new ExDBFieldNumber<>("ztysisuurentyokugotmttkn", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyyoteiririturironbase = new ExDBFieldString<>("ztyyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyyoteiriritujtnyknbase = new ExDBFieldString<>("ztyyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykihrkmpjtnyknbase = new ExDBFieldNumber<>("ztykihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztysyuptumitatekingsc = new ExDBFieldNumber<>("ztysyuptumitatekingsc", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyjikaipjyuutouym2 = new ExDBFieldString<>("ztyjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Integer> ztysuuriyobin9 = new ExDBFieldNumber<>("ztysuuriyobin9", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygessitumitatekin = new ExDBFieldNumber<>("ztygessitumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygaikadatetougetujuutoup = new ExDBFieldNumber<>("ztygaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykihrkmpmsukisymbase = new ExDBFieldNumber<>("ztykihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykeisanhanteiyoutmttkn = new ExDBFieldNumber<>("ztykeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygtmtv = new ExDBFieldNumber<>("ztygtmtv", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyzettaisibouritu = new ExDBFieldString<>("ztyzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysoutaisibouritu = new ExDBFieldString<>("ztysoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztysoutaikaiyakuritu = new ExDBFieldString<>("ztysoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyvhireilritu2 = new ExDBFieldString<>("ztyvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyphireialpha = new ExDBFieldString<>("ztyphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyphireibeta = new ExDBFieldString<>("ztyphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyphireiganma = new ExDBFieldString<>("ztyphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyphireilwrbkritu = new ExDBFieldString<>("ztyphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyyoteiriritumsukisymbase = new ExDBFieldString<>("ztyyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrrthnduhknvkiso = new ExDBFieldNumber<>("ztyrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykykkjmmvatyouseigow = new ExDBFieldNumber<>("ztykykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x39 = new ExDBFieldNumber<>("ztyyobin11x39", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x41 = new ExDBFieldNumber<>("ztyyobin11x41", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x42 = new ExDBFieldNumber<>("ztyyobin11x42", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x43 = new ExDBFieldNumber<>("ztyyobin11x43", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x44 = new ExDBFieldNumber<>("ztyyobin11x44", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x45 = new ExDBFieldNumber<>("ztyyobin11x45", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin15x3 = new ExDBFieldString<>("ztysuuriyouyobin15x3", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin15x4 = new ExDBFieldString<>("ztysuuriyouyobin15x4", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin15x5 = new ExDBFieldString<>("ztysuuriyouyobin15x5", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin15x6 = new ExDBFieldString<>("ztysuuriyouyobin15x6", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv14 = new ExDBFieldString<>("ztyyobiv14", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyloadingkeijyoym = new ExDBFieldString<>("ztyloadingkeijyoym", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysihankiksnydatahyj = new ExDBFieldString<>("ztysihankiksnydatahyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztygmkijyhyj = new ExDBFieldString<>("ztygmkijyhyj", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin12 = new ExDBFieldString<>("ztysuuriyouyobin12", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x18 = new ExDBFieldNumber<>("ztyyobin11x18", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyvhireilkisnyukngkx1 = new ExDBFieldNumber<>("ztyvhireilkisnyukngkx1", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x19 = new ExDBFieldNumber<>("ztyyobin11x19", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x20 = new ExDBFieldNumber<>("ztyyobin11x20", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x21 = new ExDBFieldNumber<>("ztyyobin11x21", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyvhireilkisnyukngkx2 = new ExDBFieldNumber<>("ztyvhireilkisnyukngkx2", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x22 = new ExDBFieldNumber<>("ztyyobin11x22", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x23 = new ExDBFieldNumber<>("ztyyobin11x23", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyrpkeisanyousibous = new ExDBFieldNumber<>("ztyrpkeisanyousibous", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykikens = new ExDBFieldNumber<>("ztykikens", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyvhireialpha = new ExDBFieldNumber<>("ztyvhireialpha", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyvhireibeta = new ExDBFieldNumber<>("ztyvhireibeta", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztykikenp = new ExDBFieldNumber<>("ztykikenp", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztyvhireilritu = new ExDBFieldString<>("ztyvhireilritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayJigyohiTy, BizNumber> ztykikenpritu = new ExDBFieldString<>("ztykikenpritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztytumimasimaew = new ExDBFieldNumber<>("ztytumimasimaew", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x25 = new ExDBFieldNumber<>("ztyyobin11x25", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x26 = new ExDBFieldNumber<>("ztyyobin11x26", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x27 = new ExDBFieldNumber<>("ztyyobin11x27", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x28 = new ExDBFieldNumber<>("ztyyobin11x28", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x29 = new ExDBFieldNumber<>("ztyyobin11x29", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x30 = new ExDBFieldNumber<>("ztyyobin11x30", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x31 = new ExDBFieldNumber<>("ztyyobin11x31", this);

    public final ExDBFieldNumber<ZT_RayJigyohiTy, Long> ztyyobin11x32 = new ExDBFieldNumber<>("ztyyobin11x32", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztysuuriyouyobin15 = new ExDBFieldString<>("ztysuuriyouyobin15", this);

    public final ExDBFieldString<ZT_RayJigyohiTy, String> ztyyobiv19 = new ExDBFieldString<>("ztyyobiv19", this);
}
