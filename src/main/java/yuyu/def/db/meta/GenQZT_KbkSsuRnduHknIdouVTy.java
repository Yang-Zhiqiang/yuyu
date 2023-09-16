package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 株価指数連動保険異動ＶＦテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KbkSsuRnduHknIdouVTy extends AbstractExDBTable<ZT_KbkSsuRnduHknIdouVTy> {

    public GenQZT_KbkSsuRnduHknIdouVTy() {
        this("ZT_KbkSsuRnduHknIdouVTy");
    }

    public GenQZT_KbkSsuRnduHknIdouVTy(String pAlias) {
        super("ZT_KbkSsuRnduHknIdouVTy", ZT_KbkSsuRnduHknIdouVTy.class, pAlias);
    }

    public String ZT_KbkSsuRnduHknIdouVTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztynenkinkaisigohyouji = new ExDBFieldString<>("ztynenkinkaisigohyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztynksgokurikosidhyj = new ExDBFieldString<>("ztynksgokurikosidhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyidojiyukbn = new ExDBFieldString<>("ztyidojiyukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyzougenkbn = new ExDBFieldString<>("ztyzougenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyidourecordkbn = new ExDBFieldString<>("ztyidourecordkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykeijyouctrlkbn = new ExDBFieldString<>("ztykeijyouctrlkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztykykmfksnctr = new ExDBFieldNumber<>("ztykykmfksnctr", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztyrecordctr = new ExDBFieldNumber<>("ztyrecordctr", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyoukouryokukaisiymd = new ExDBFieldString<>("ztysuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztybluekeizokuhyouji = new ExDBFieldString<>("ztybluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytoukeikeijyoukbn = new ExDBFieldString<>("ztytoukeikeijyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyzenkiidouteiseikbn = new ExDBFieldString<>("ztyzenkiidouteiseikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkangokeiyakubosyuuym = new ExDBFieldString<>("ztytenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyidoujiyuucd = new ExDBFieldString<>("ztyidoujiyuucd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysekininteiseihyouji = new ExDBFieldString<>("ztysekininteiseihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysihankibikinkbn = new ExDBFieldString<>("ztysihankibikinkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin1x3 = new ExDBFieldString<>("ztysuuriyouyobin1x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhosyoukinoukbn = new ExDBFieldString<>("ztyhosyoukinoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydaikbn = new ExDBFieldString<>("ztydaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytyuukbn = new ExDBFieldString<>("ztytyuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysyoukbn = new ExDBFieldString<>("ztysyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysedaikbn = new ExDBFieldString<>("ztysedaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyao3tyou3sibousdatehyouji = new ExDBFieldString<>("ztyao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytkbthsyumnryuhyouji = new ExDBFieldString<>("ztytkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysyukeiyakupwaribikikbn = new ExDBFieldString<>("ztysyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanwaribikikbn = new ExDBFieldString<>("ztytenkanwaribikikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("ztyyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysiteizukisyukeiyakup = new ExDBFieldNumber<>("ztysiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhenkougokihons = new ExDBFieldNumber<>("ztyhenkougokihons", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhenkougosibous = new ExDBFieldNumber<>("ztyhenkougosibous", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhenkouymd = new ExDBFieldString<>("ztyhenkouymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyentyoukikan = new ExDBFieldString<>("ztyentyoukikan", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyseizonkyuuhukinsiteimd = new ExDBFieldString<>("ztyseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysyukeiyakusiharaikingaku = new ExDBFieldNumber<>("ztysyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyatukaisisyatodouhukencd = new ExDBFieldString<>("ztyatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztytokuyakuhukasuu = new ExDBFieldNumber<>("ztytokuyakuhukasuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydi2hknkknikoujihisyaage = new ExDBFieldString<>("ztydi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrimnentyoumaephrkkkn = new ExDBFieldString<>("ztyhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrizmjhknsyukigousdkbn = new ExDBFieldString<>("ztyhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykrsgjhknsyukigousdkbn = new ExDBFieldString<>("ztykrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysotodasisyouhinkaiteikbn = new ExDBFieldString<>("ztysotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygoukeipbubuntenkans = new ExDBFieldNumber<>("ztygoukeipbubuntenkans", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanteikisyuruikigou = new ExDBFieldString<>("ztytenkanteikisyuruikigou", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanteikikigousedaikbn = new ExDBFieldString<>("ztytenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytnkntiksotodasikusnkbn = new ExDBFieldString<>("ztytnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytnkntikstdspmenkbn = new ExDBFieldString<>("ztytnkntikstdspmenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanteikikigouyobi = new ExDBFieldString<>("ztytenkanteikikigouyobi", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanteikikikan = new ExDBFieldString<>("ztytenkanteikikikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytnknteikinkshrkkn = new ExDBFieldString<>("ztytnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytenkansiharaikingaku = new ExDBFieldNumber<>("ztytenkansiharaikingaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytnkntikshrkngk = new ExDBFieldNumber<>("ztytnkntikshrkngk", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygoukeitenkankakaku = new ExDBFieldNumber<>("ztygoukeitenkankakaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztytnknkhnbbnjyuturt = new ExDBFieldString<>("ztytnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztywnasigoukeitenkanteikis = new ExDBFieldNumber<>("ztywnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytnknteikikousinmnryouage = new ExDBFieldString<>("ztytnknteikikousinmnryouage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykanyujidatakanrino = new ExDBFieldString<>("ztykanyujidatakanrino", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykanyujikykymd = new ExDBFieldString<>("ztykanyujikykymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykanyuujihihokensyaage = new ExDBFieldString<>("ztykanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykanyuujitenkanhyouji = new ExDBFieldString<>("ztykanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhsyuikktminaosikaisu = new ExDBFieldString<>("ztyhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysknnjynbknsisnrt = new ExDBFieldString<>("ztysknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysakugenkikan = new ExDBFieldString<>("ztysakugenkikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysykyktkjyuryumsratehyj = new ExDBFieldString<>("ztysykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysykyktkjyuryumsrate = new ExDBFieldString<>("ztysykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2sakugenkikan = new ExDBFieldString<>("ztydai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytokuteibuijyoukenhyouji = new ExDBFieldString<>("ztytokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytokuteibuino1 = new ExDBFieldString<>("ztytokuteibuino1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhtnpkkn1 = new ExDBFieldString<>("ztyhtnpkkn1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytokuteibuino2 = new ExDBFieldString<>("ztytokuteibuino2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhtnpkkn2 = new ExDBFieldString<>("ztyhtnpkkn2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymhituiryuyutktbijyknhyj = new ExDBFieldString<>("ztymhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymuhaitouiryouyoutktbino1 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymuhaitouiryouyoutktbino2 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysiteizukipwarimasihyouji = new ExDBFieldString<>("ztysiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysiteimsykykpbairitu = new ExDBFieldString<>("ztysiteimsykykpbairitu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysykykkitmttvkeisanym = new ExDBFieldString<>("ztysykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("ztysykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztydftumitatekingaku = new ExDBFieldNumber<>("ztydftumitatekingaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztydftumimasikin = new ExDBFieldNumber<>("ztydftumimasikin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyvbubundftenkankakaku = new ExDBFieldNumber<>("ztyvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztydpbubundftenkankakaku = new ExDBFieldNumber<>("ztydpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztydftmttkngkitjbrbbn = new ExDBFieldNumber<>("ztydftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhendous = new ExDBFieldNumber<>("ztyhendous", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhengakujigyounendomatucv = new ExDBFieldNumber<>("ztyhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyitibitjbrshrkngk = new ExDBFieldNumber<>("ztyitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygoukeicv = new ExDBFieldNumber<>("ztygoukeicv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyminasicv = new ExDBFieldNumber<>("ztyminasicv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyloanfund = new ExDBFieldNumber<>("ztyloanfund", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysaiteihosyougaku = new ExDBFieldNumber<>("ztysaiteihosyougaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhngksitihsyuyusykykp = new ExDBFieldNumber<>("ztyhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysiinkbn = new ExDBFieldString<>("ztysiinkbn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztymudkaimasikihons = new ExDBFieldNumber<>("ztymudkaimasikihons", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykaimasiymd = new ExDBFieldString<>("ztykaimasiymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykaimasikikan = new ExDBFieldString<>("ztykaimasikikan", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyhikitugikaimasis = new ExDBFieldNumber<>("ztyhikitugikaimasis", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztymudkaimasisiharaikingaku = new ExDBFieldNumber<>("ztymudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoukouryokukaisiymdx1 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszouhokensyuruikigoux1 = new ExDBFieldString<>("ztyszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoukigousedaikbnx1 = new ExDBFieldString<>("ztyszoukigousedaikbnx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoukikanx1 = new ExDBFieldString<>("ztyszoukikanx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszouhihokensyaagex1 = new ExDBFieldString<>("ztyszouhihokensyaagex1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoudai2hihknsyaagex1 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyzoukasx1 = new ExDBFieldNumber<>("ztyzoukasx1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyzennendozoukasx1 = new ExDBFieldNumber<>("ztyzennendozoukasx1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyszousiharaikingakux1 = new ExDBFieldNumber<>("ztyszousiharaikingakux1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoukouryokukaisiymdx2 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszouhokensyuruikigoux2 = new ExDBFieldString<>("ztyszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoukigousedaikbnx2 = new ExDBFieldString<>("ztyszoukigousedaikbnx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoukikanx2 = new ExDBFieldString<>("ztyszoukikanx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszouhihokensyaagex2 = new ExDBFieldString<>("ztyszouhihokensyaagex2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoudai2hihknsyaagex2 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyzoukasx2 = new ExDBFieldNumber<>("ztyzoukasx2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyzennendozoukasx2 = new ExDBFieldNumber<>("ztyzennendozoukasx2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyszousiharaikingakux2 = new ExDBFieldNumber<>("ztyszousiharaikingakux2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin1x5 = new ExDBFieldString<>("ztysuuriyouyobin1x5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin1x6 = new ExDBFieldString<>("ztysuuriyouyobin1x6", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrimngkizktkykpmenhyj = new ExDBFieldString<>("ztyhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymisyuustartym = new ExDBFieldString<>("ztymisyuustartym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymisyuukaisuu = new ExDBFieldString<>("ztymisyuukaisuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("ztyitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygyousekihyoujis = new ExDBFieldNumber<>("ztygyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysykykgyusekihyjs = new ExDBFieldNumber<>("ztysykykgyusekihyjs", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytenkangyousekihyoujis = new ExDBFieldNumber<>("ztytenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytnknteikigyousekihyjs = new ExDBFieldNumber<>("ztytnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytnkndpbbngyuskhyjs = new ExDBFieldNumber<>("ztytnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykykjyoutai = new ExDBFieldString<>("ztykykjyoutai", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymankiyoteikbn = new ExDBFieldString<>("ztymankiyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysykyktikmnkyoteikbn = new ExDBFieldString<>("ztysykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytnknsykykkhnmnkytikbn = new ExDBFieldString<>("ztytnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytnknsykyktikmnkytikbn = new ExDBFieldString<>("ztytnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanteikimankiyoteikbn = new ExDBFieldString<>("ztytenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoumankiyoteikbnx1 = new ExDBFieldString<>("ztyszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyszoumankiyoteikbnx2 = new ExDBFieldString<>("ztyszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyvestingmankiyoteikbn = new ExDBFieldString<>("ztyvestingmankiyoteikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyvkeisanhyouji = new ExDBFieldString<>("ztyvkeisanhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytoukisinkeiyakuhyouji = new ExDBFieldString<>("ztytoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysykykhokenhoutekiyouhyj = new ExDBFieldString<>("ztysykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyytirrthndsysnmnskaisuu = new ExDBFieldString<>("ztyytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin3 = new ExDBFieldString<>("ztysuuriyouyobin3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin11 = new ExDBFieldString<>("ztysuuriyouyobin11", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztywnasigoukeitenkankakaku = new ExDBFieldNumber<>("ztywnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytukibaraikansantokujyoup = new ExDBFieldNumber<>("ztytukibaraikansantokujyoup", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytnkngkykkssnkijyuym = new ExDBFieldString<>("ztytnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysaiteihosyouhyouji = new ExDBFieldString<>("ztysaiteihosyouhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin8x2 = new ExDBFieldString<>("ztysuuriyouyobin8x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin14 = new ExDBFieldString<>("ztysuuriyouyobin14", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("ztyhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrimngtkykphrkkirkbn = new ExDBFieldString<>("ztyhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhrimngtkykpryurtkbn = new ExDBFieldString<>("ztyhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv13 = new ExDBFieldString<>("ztyyobiv13", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyidoujisaiteihosyoukngk = new ExDBFieldNumber<>("ztyidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyidoujisaiteihosyoucost = new ExDBFieldNumber<>("ztyidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysinhokenfundtumitatekin = new ExDBFieldNumber<>("ztysinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztymsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("ztymsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthndugtnkgetumatuv = new ExDBFieldNumber<>("ztyrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("ztyrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthendougatanksibous = new ExDBFieldNumber<>("ztyrrthendougatanksibous", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyalmyousohutomeisyoukbn = new ExDBFieldString<>("ztyalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysnkyksoftmeisyoukbn = new ExDBFieldString<>("ztysnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysoftmeisyoukbn = new ExDBFieldString<>("ztysoftmeisyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykykjitokujyouarihyj = new ExDBFieldString<>("ztykykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysoujikeitenkankbn = new ExDBFieldString<>("ztysoujikeitenkankbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztynenkingatakbn = new ExDBFieldString<>("ztynenkingatakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyheiyoubaraikeiyakukbn = new ExDBFieldString<>("ztyheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztynenkinmaruteihukakbn = new ExDBFieldString<>("ztynenkinmaruteihukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysinseizonmrtiarihyj = new ExDBFieldString<>("ztysinseizonmrtiarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysnkykyouibokijyukbn = new ExDBFieldString<>("ztysnkykyouibokijyukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytokusitujyuusitusetkbn = new ExDBFieldString<>("ztytokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("ztysiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztypmensugugtganhsyunshyj = new ExDBFieldString<>("ztypmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytkykgyousekihyjszerohyj = new ExDBFieldString<>("ztytkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin7 = new ExDBFieldString<>("ztysuuriyouyobin7", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysyussaikeitaikbn = new ExDBFieldString<>("ztysyussaikeitaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobiv8 = new ExDBFieldString<>("ztysuuriyouyobiv8", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysinsakbn = new ExDBFieldString<>("ztysinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2hihokensyasinsakbn = new ExDBFieldString<>("ztydai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2toukeiyousinsakbn = new ExDBFieldString<>("ztydai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyketteikijyunkanwakbn = new ExDBFieldString<>("ztyketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykihonsibouhyoukbn = new ExDBFieldString<>("ztykihonsibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyteikisibouhyoukbn = new ExDBFieldString<>("ztyteikisibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysonotasibouhyoukbn = new ExDBFieldString<>("ztysonotasibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymrarihyj = new ExDBFieldString<>("ztymrarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysentakujyouhouarihyouji = new ExDBFieldString<>("ztysentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydugktnknsntkhuhukbn = new ExDBFieldString<>("ztydugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyjidoukousinkykkanyuuymd = new ExDBFieldString<>("ztyjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysaikohtnknkykkykymd = new ExDBFieldString<>("ztysaikohtnknkykkykymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykousinmaesykyksburtkbn = new ExDBFieldString<>("ztykousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysaihokenno = new ExDBFieldString<>("ztysaihokenno", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2dakuhiketteikekkacd = new ExDBFieldString<>("ztydai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysiboukyuuhukin = new ExDBFieldNumber<>("ztysiboukyuuhukin", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyjyudthumeharaitkykhkhyj = new ExDBFieldString<>("ztyjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykituenhonsuu = new ExDBFieldString<>("ztykituenhonsuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymusentakukeiyakukbn = new ExDBFieldString<>("ztymusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv6x2 = new ExDBFieldString<>("ztyyobiv6x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztylivingneedssiharaihyouji = new ExDBFieldString<>("ztylivingneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztylnseikyuuymd = new ExDBFieldString<>("ztylnseikyuuymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztylnshrgenincd = new ExDBFieldString<>("ztylnshrgenincd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydai2dakuhiketteisyacd = new ExDBFieldString<>("ztydai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztygansapotokuyakuarihyouji = new ExDBFieldString<>("ztygansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztygnspshrhyj = new ExDBFieldString<>("ztygnspshrhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztygansaposeikyuuymd = new ExDBFieldString<>("ztygansaposeikyuuymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztygnspshrgenincd = new ExDBFieldString<>("ztygnspshrgenincd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytargetmokuhyouritu = new ExDBFieldString<>("ztytargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyautoswitchmokuhyouritu = new ExDBFieldString<>("ztyautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytumitatekinitenarihyj = new ExDBFieldString<>("ztytumitatekinitenarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytumitatekinitenkaisuu = new ExDBFieldString<>("ztytumitatekinitenkaisuu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyknkuzusnzyrttekinendo = new ExDBFieldString<>("ztyknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyknkuzusnzyrtx2 = new ExDBFieldString<>("ztyknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyknkuzusnzyrtx3 = new ExDBFieldString<>("ztyknkuzusnzyrtx3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("ztysinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytenkanjiknkuzusnzyrt = new ExDBFieldString<>("ztytenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykykjivithukusuukykhyj = new ExDBFieldString<>("ztykykjivithukusuukykhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin9x2 = new ExDBFieldString<>("ztysuuriyouyobin9x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin10x7 = new ExDBFieldString<>("ztysuuriyouyobin10x7", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin10x8 = new ExDBFieldString<>("ztysuuriyouyobin10x8", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin10x9 = new ExDBFieldString<>("ztysuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytumitatekinitenbubun = new ExDBFieldNumber<>("ztytumitatekinitenbubun", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysagakusknnjynbknzndk = new ExDBFieldNumber<>("ztysagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x11 = new ExDBFieldNumber<>("ztyyobin11x11", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x12 = new ExDBFieldNumber<>("ztyyobin11x12", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x13 = new ExDBFieldNumber<>("ztyyobin11x13", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x14 = new ExDBFieldNumber<>("ztyyobin11x14", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x15 = new ExDBFieldNumber<>("ztyyobin11x15", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x16 = new ExDBFieldNumber<>("ztyyobin11x16", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x17 = new ExDBFieldNumber<>("ztyyobin11x17", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyzyrthntiyustatuskbnx2 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyzyrthntiyustatuskbnx3 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyzyrthntiyustatuskbnx4 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyzyrthntiyustatuskbnx5 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv15x2 = new ExDBFieldString<>("ztyyobiv15x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv15x3 = new ExDBFieldString<>("ztyyobiv15x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv15x4 = new ExDBFieldString<>("ztyyobiv15x4", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztykawaserate1 = new ExDBFieldString<>("ztykawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykawaseratetekiyouymd1 = new ExDBFieldString<>("ztykawaseratetekiyouymd1", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztykawaserate2 = new ExDBFieldString<>("ztykawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykawaseratetekiyouymd2 = new ExDBFieldString<>("ztykawaseratetekiyouymd2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztykaiyakukoujyoritu = new ExDBFieldString<>("ztykaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztymvakeisankijyunymd = new ExDBFieldString<>("ztymvakeisankijyunymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyenkdtsbujsitihsyucost = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("ztyenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykaigomaebaraitkykarihyj = new ExDBFieldString<>("ztykaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysiharaituukakbn = new ExDBFieldString<>("ztysiharaituukakbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztywyendttargetmokuhyouritu = new ExDBFieldString<>("ztywyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyteirituikouhyouji = new ExDBFieldString<>("ztyteirituikouhyouji", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin2x3 = new ExDBFieldString<>("ztysuuriyouyobin2x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin10x11 = new ExDBFieldString<>("ztysuuriyouyobin10x11", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztytykzenoutouymdsisuu = new ExDBFieldString<>("ztytykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztykimatusisuu = new ExDBFieldString<>("ztykimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyenkadatekihons = new ExDBFieldNumber<>("ztyyenkadatekihons", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysitihsyumegkdtsibous = new ExDBFieldNumber<>("ztysitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyenkdtssrentumitatekin = new ExDBFieldNumber<>("ztyenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztynksjitirttumitatekin = new ExDBFieldNumber<>("ztynksjitirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykimatutirttumitatekin = new ExDBFieldNumber<>("ztykimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygaikadatejyuutoup = new ExDBFieldNumber<>("ztygaikadatejyuutoup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyendttargetkijyunkingaku = new ExDBFieldNumber<>("ztyyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysitivkisnyukykjikwsrate = new ExDBFieldString<>("ztysitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysisuurentyokugotmttkn = new ExDBFieldNumber<>("ztysisuurentyokugotmttkn", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyyoteiririturironbase = new ExDBFieldString<>("ztyyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyyoteiriritujtnyknbase = new ExDBFieldString<>("ztyyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykihrkmpjtnyknbase = new ExDBFieldNumber<>("ztykihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztysyuptumitatekingsc = new ExDBFieldNumber<>("ztysyuptumitatekingsc", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyjikaipjyuutouym2 = new ExDBFieldString<>("ztyjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Integer> ztysuuriyobin9 = new ExDBFieldNumber<>("ztysuuriyobin9", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygessitumitatekin = new ExDBFieldNumber<>("ztygessitumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygaikadatetougetujuutoup = new ExDBFieldNumber<>("ztygaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykihrkmpmsukisymbase = new ExDBFieldNumber<>("ztykihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykeisanhanteiyoutmttkn = new ExDBFieldNumber<>("ztykeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygtmtv = new ExDBFieldNumber<>("ztygtmtv", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyzettaisibouritu = new ExDBFieldString<>("ztyzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysoutaisibouritu = new ExDBFieldString<>("ztysoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztysoutaikaiyakuritu = new ExDBFieldString<>("ztysoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyvhireilritu2 = new ExDBFieldString<>("ztyvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyphireialpha = new ExDBFieldString<>("ztyphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyphireibeta = new ExDBFieldString<>("ztyphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyphireiganma = new ExDBFieldString<>("ztyphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyphireilwrbkritu = new ExDBFieldString<>("ztyphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyyoteiriritumsukisymbase = new ExDBFieldString<>("ztyyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyrrthnduhknvkiso = new ExDBFieldNumber<>("ztyrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykykkjmmvatyouseigow = new ExDBFieldNumber<>("ztykykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x39 = new ExDBFieldNumber<>("ztyyobin11x39", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x41 = new ExDBFieldNumber<>("ztyyobin11x41", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x42 = new ExDBFieldNumber<>("ztyyobin11x42", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x43 = new ExDBFieldNumber<>("ztyyobin11x43", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x44 = new ExDBFieldNumber<>("ztyyobin11x44", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x45 = new ExDBFieldNumber<>("ztyyobin11x45", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin15x3 = new ExDBFieldString<>("ztysuuriyouyobin15x3", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin15x4 = new ExDBFieldString<>("ztysuuriyouyobin15x4", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin15x5 = new ExDBFieldString<>("ztysuuriyouyobin15x5", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin15x6 = new ExDBFieldString<>("ztysuuriyouyobin15x6", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv14 = new ExDBFieldString<>("ztyyobiv14", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyvkimatutirttumitatekin = new ExDBFieldNumber<>("ztyvkimatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykimatusisuutumitatekin = new ExDBFieldNumber<>("ztykimatusisuutumitatekin", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyvyoutykzenoutouymdsisuu = new ExDBFieldString<>("ztyvyoutykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztytykzensisuukijyunymd = new ExDBFieldString<>("ztytykzensisuukijyunymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyvyoukimatusisuu = new ExDBFieldString<>("ztyvyoukimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztykmtsisuukijyunymd = new ExDBFieldString<>("ztykmtsisuukijyunymd", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyvyoutmttknzoukaritujygn = new ExDBFieldString<>("ztyvyoutmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyvyousetteibairitu = new ExDBFieldString<>("ztyvyousetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, BizNumber> ztyvyourendouritu = new ExDBFieldString<>("ztyvyourendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin3x2 = new ExDBFieldString<>("ztysuuriyouyobin3x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztykimatusisuutyokugotmttkn = new ExDBFieldNumber<>("ztykimatusisuutyokugotmttkn", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x19 = new ExDBFieldNumber<>("ztyyobin11x19", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x20 = new ExDBFieldNumber<>("ztyyobin11x20", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmttirttumitatekinnplus0 = new ExDBFieldNumber<>("ztyjmttirttumitatekinnplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmttirttumitatekinnplus1 = new ExDBFieldNumber<>("ztyjmttirttumitatekinnplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmttirttumitatekinnplus2 = new ExDBFieldNumber<>("ztyjmttirttumitatekinnplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtssutumitatekinnplus0 = new ExDBFieldNumber<>("ztyjmtssutumitatekinnplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtssutumitatekinnplus1 = new ExDBFieldNumber<>("ztyjmtssutumitatekinnplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtssutumitatekinnplus2 = new ExDBFieldNumber<>("ztyjmtssutumitatekinnplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtmvatyouseigownplus0 = new ExDBFieldNumber<>("ztyjmtmvatyouseigownplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtmvakeisanjiwnplus0 = new ExDBFieldNumber<>("ztyjmtmvakeisanjiwnplus0", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtmvatyouseigownplus1 = new ExDBFieldNumber<>("ztyjmtmvatyouseigownplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtmvakeisanjiwnplus1 = new ExDBFieldNumber<>("ztyjmtmvakeisanjiwnplus1", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtmvatyouseigownplus2 = new ExDBFieldNumber<>("ztyjmtmvatyouseigownplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyjmtmvakeisanjiwnplus2 = new ExDBFieldNumber<>("ztyjmtmvakeisanjiwnplus2", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x21 = new ExDBFieldNumber<>("ztyyobin11x21", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x22 = new ExDBFieldNumber<>("ztyyobin11x22", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x23 = new ExDBFieldNumber<>("ztyyobin11x23", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x25 = new ExDBFieldNumber<>("ztyyobin11x25", this);

    public final ExDBFieldNumber<ZT_KbkSsuRnduHknIdouVTy, Long> ztyyobin11x26 = new ExDBFieldNumber<>("ztyyobin11x26", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin15 = new ExDBFieldString<>("ztysuuriyouyobin15", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztysuuriyouyobin15x2 = new ExDBFieldString<>("ztysuuriyouyobin15x2", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv15 = new ExDBFieldString<>("ztyyobiv15", this);

    public final ExDBFieldString<ZT_KbkSsuRnduHknIdouVTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);
}
