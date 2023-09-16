package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動明細中継用一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_IdouMeisaiTyukeiyouItzHzn extends AbstractExDBTable<ST_IdouMeisaiTyukeiyouItzHzn> {

    public GenQST_IdouMeisaiTyukeiyouItzHzn() {
        this("ST_IdouMeisaiTyukeiyouItzHzn");
    }

    public GenQST_IdouMeisaiTyukeiyouItzHzn(String pAlias) {
        super("ST_IdouMeisaiTyukeiyouItzHzn", ST_IdouMeisaiTyukeiyouItzHzn.class, pAlias);
    }

    public String ST_IdouMeisaiTyukeiyouItzHzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrkijyunym = new ExDBFieldString<>("ztysrkijyunym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrkakutyoujobcd = new ExDBFieldString<>("ztysrkakutyoujobcd", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztynenkinkaisigohyouji = new ExDBFieldString<>("ztynenkinkaisigohyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztynksgokurikosidhyj = new ExDBFieldString<>("ztynksgokurikosidhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyidojiyukbn = new ExDBFieldString<>("ztyidojiyukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzougenkbn = new ExDBFieldString<>("ztyzougenkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyidourecordkbn = new ExDBFieldString<>("ztyidourecordkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykeijyouctrlkbn = new ExDBFieldString<>("ztykeijyouctrlkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztykykmfksnctr = new ExDBFieldNumber<>("ztykykmfksnctr", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztyrecordctr = new ExDBFieldNumber<>("ztyrecordctr", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyoukouryokukaisiymd = new ExDBFieldString<>("ztysuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztybluekeizokuhyouji = new ExDBFieldString<>("ztybluekeizokuhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytoukeikeijyoukbn = new ExDBFieldString<>("ztytoukeikeijyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzenkiidouteiseikbn = new ExDBFieldString<>("ztyzenkiidouteiseikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkangokeiyakubosyuuym = new ExDBFieldString<>("ztytenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyidoujiyuucd = new ExDBFieldString<>("ztyidoujiyuucd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysekininteiseihyouji = new ExDBFieldString<>("ztysekininteiseihyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysihankibikinkbn = new ExDBFieldString<>("ztysihankibikinkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x3 = new ExDBFieldString<>("ztysuuriyouyobin1x3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhosyoukinoukbn = new ExDBFieldString<>("ztyhosyoukinoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydaikbn = new ExDBFieldString<>("ztydaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytyuukbn = new ExDBFieldString<>("ztytyuukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyoukbn = new ExDBFieldString<>("ztysyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysedaikbn = new ExDBFieldString<>("ztysedaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyao3tyou3sibousdatehyouji = new ExDBFieldString<>("ztyao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytkbthsyumnryuhyouji = new ExDBFieldString<>("ztytkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyukeiyakupwaribikikbn = new ExDBFieldString<>("ztysyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanwaribikikbn = new ExDBFieldString<>("ztytenkanwaribikikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("ztyyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysiteizukisyukeiyakup = new ExDBFieldNumber<>("ztysiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhenkougokihons = new ExDBFieldNumber<>("ztyhenkougokihons", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhenkougosibous = new ExDBFieldNumber<>("ztyhenkougosibous", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhenkouymd = new ExDBFieldString<>("ztyhenkouymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyentyoukikan = new ExDBFieldString<>("ztyentyoukikan", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyseizonkyuuhukinsiteimd = new ExDBFieldString<>("ztyseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysyukeiyakusiharaikingaku = new ExDBFieldNumber<>("ztysyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyatukaisisyatodouhukencd = new ExDBFieldString<>("ztyatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztytokuyakuhukasuu = new ExDBFieldNumber<>("ztytokuyakuhukasuu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydi2hknkknikoujihisyaage = new ExDBFieldString<>("ztydi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrimnentyoumaephrkkkn = new ExDBFieldString<>("ztyhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrizmjhknsyukigousdkbn = new ExDBFieldString<>("ztyhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykrsgjhknsyukigousdkbn = new ExDBFieldString<>("ztykrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysotodasisyouhinkaiteikbn = new ExDBFieldString<>("ztysotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeipbubuntenkans = new ExDBFieldNumber<>("ztygoukeipbubuntenkans", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikisyuruikigou = new ExDBFieldString<>("ztytenkanteikisyuruikigou", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikikigousedaikbn = new ExDBFieldString<>("ztytenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnkntiksotodasikusnkbn = new ExDBFieldString<>("ztytnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnkntikstdspmenkbn = new ExDBFieldString<>("ztytnkntikstdspmenkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikikigouyobi = new ExDBFieldString<>("ztytenkanteikikigouyobi", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikikikan = new ExDBFieldString<>("ztytenkanteikikikan", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknteikinkshrkkn = new ExDBFieldString<>("ztytnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytenkansiharaikingaku = new ExDBFieldNumber<>("ztytenkansiharaikingaku", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnkntikshrkngk = new ExDBFieldNumber<>("ztytnkntikshrkngk", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeitenkankakaku = new ExDBFieldNumber<>("ztygoukeitenkankakaku", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztytnknkhnbbnjyuturt = new ExDBFieldString<>("ztytnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztywnasigoukeitenkanteikis = new ExDBFieldNumber<>("ztywnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknteikikousinmnryouage = new ExDBFieldString<>("ztytnknteikikousinmnryouage", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykanyujidatakanrino = new ExDBFieldString<>("ztykanyujidatakanrino", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykanyujikykymd = new ExDBFieldString<>("ztykanyujikykymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykanyuujihihokensyaage = new ExDBFieldString<>("ztykanyuujihihokensyaage", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykanyuujitenkanhyouji = new ExDBFieldString<>("ztykanyuujitenkanhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhsyuikktminaosikaisu = new ExDBFieldString<>("ztyhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysknnjynbknsisnrt = new ExDBFieldString<>("ztysknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysakugenkikan = new ExDBFieldString<>("ztysakugenkikan", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysykyktkjyuryumsratehyj = new ExDBFieldString<>("ztysykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysykyktkjyuryumsrate = new ExDBFieldString<>("ztysykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2sakugenkikan = new ExDBFieldString<>("ztydai2sakugenkikan", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuteibuijyoukenhyouji = new ExDBFieldString<>("ztytokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuteibuino1 = new ExDBFieldString<>("ztytokuteibuino1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhtnpkkn1 = new ExDBFieldString<>("ztyhtnpkkn1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuteibuino2 = new ExDBFieldString<>("ztytokuteibuino2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhtnpkkn2 = new ExDBFieldString<>("ztyhtnpkkn2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymhituiryuyutktbijyknhyj = new ExDBFieldString<>("ztymhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyoutktbino1 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyoutktbino2 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysiteizukipwarimasihyouji = new ExDBFieldString<>("ztysiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysiteimsykykpbairitu = new ExDBFieldString<>("ztysiteimsykykpbairitu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysykykkitmttvkeisanym = new ExDBFieldString<>("ztysykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("ztysykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztydftumitatekingaku = new ExDBFieldNumber<>("ztydftumitatekingaku", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztydftumimasikin = new ExDBFieldNumber<>("ztydftumimasikin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyvbubundftenkankakaku = new ExDBFieldNumber<>("ztyvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztydpbubundftenkankakaku = new ExDBFieldNumber<>("ztydpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztydftmttkngkitjbrbbn = new ExDBFieldNumber<>("ztydftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhendous = new ExDBFieldNumber<>("ztyhendous", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhengakujigyounendomatucv = new ExDBFieldNumber<>("ztyhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyitibitjbrshrkngk = new ExDBFieldNumber<>("ztyitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeicv = new ExDBFieldNumber<>("ztygoukeicv", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyminasicv = new ExDBFieldNumber<>("ztyminasicv", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyloanfund = new ExDBFieldNumber<>("ztyloanfund", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysaiteihosyougaku = new ExDBFieldNumber<>("ztysaiteihosyougaku", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhngksitihsyuyusykykp = new ExDBFieldNumber<>("ztyhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysiinkbn = new ExDBFieldString<>("ztysiinkbn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztymudkaimasikihons = new ExDBFieldNumber<>("ztymudkaimasikihons", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykaimasiymd = new ExDBFieldString<>("ztykaimasiymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykaimasikikan = new ExDBFieldString<>("ztykaimasikikan", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhikitugikaimasis = new ExDBFieldNumber<>("ztyhikitugikaimasis", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztymudkaimasisiharaikingaku = new ExDBFieldNumber<>("ztymudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoukouryokukaisiymdx1 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszouhokensyuruikigoux1 = new ExDBFieldString<>("ztyszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoukigousedaikbnx1 = new ExDBFieldString<>("ztyszoukigousedaikbnx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoukikanx1 = new ExDBFieldString<>("ztyszoukikanx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszouhihokensyaagex1 = new ExDBFieldString<>("ztyszouhihokensyaagex1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoudai2hihknsyaagex1 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyzoukasx1 = new ExDBFieldNumber<>("ztyzoukasx1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyzennendozoukasx1 = new ExDBFieldNumber<>("ztyzennendozoukasx1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyszousiharaikingakux1 = new ExDBFieldNumber<>("ztyszousiharaikingakux1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoukouryokukaisiymdx2 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszouhokensyuruikigoux2 = new ExDBFieldString<>("ztyszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoukigousedaikbnx2 = new ExDBFieldString<>("ztyszoukigousedaikbnx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoukikanx2 = new ExDBFieldString<>("ztyszoukikanx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszouhihokensyaagex2 = new ExDBFieldString<>("ztyszouhihokensyaagex2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoudai2hihknsyaagex2 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyzoukasx2 = new ExDBFieldNumber<>("ztyzoukasx2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyzennendozoukasx2 = new ExDBFieldNumber<>("ztyzennendozoukasx2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyszousiharaikingakux2 = new ExDBFieldNumber<>("ztyszousiharaikingakux2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x5 = new ExDBFieldString<>("ztysuuriyouyobin1x5", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x6 = new ExDBFieldString<>("ztysuuriyouyobin1x6", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrimngkizktkykpmenhyj = new ExDBFieldString<>("ztyhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymisyuustartym = new ExDBFieldString<>("ztymisyuustartym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymisyuukaisuu = new ExDBFieldString<>("ztymisyuukaisuu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("ztyitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygyousekihyoujis = new ExDBFieldNumber<>("ztygyousekihyoujis", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysykykgyusekihyjs = new ExDBFieldNumber<>("ztysykykgyusekihyjs", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytenkangyousekihyoujis = new ExDBFieldNumber<>("ztytenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnknteikigyousekihyjs = new ExDBFieldNumber<>("ztytnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnkndpbbngyuskhyjs = new ExDBFieldNumber<>("ztytnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykykjyoutai = new ExDBFieldString<>("ztykykjyoutai", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymankiyoteikbn = new ExDBFieldString<>("ztymankiyoteikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysykyktikmnkyoteikbn = new ExDBFieldString<>("ztysykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknsykykkhnmnkytikbn = new ExDBFieldString<>("ztytnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknsykyktikmnkytikbn = new ExDBFieldString<>("ztytnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikimankiyoteikbn = new ExDBFieldString<>("ztytenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoumankiyoteikbnx1 = new ExDBFieldString<>("ztyszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszoumankiyoteikbnx2 = new ExDBFieldString<>("ztyszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyvestingmankiyoteikbn = new ExDBFieldString<>("ztyvestingmankiyoteikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyvkeisanhyouji = new ExDBFieldString<>("ztyvkeisanhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytoukisinkeiyakuhyouji = new ExDBFieldString<>("ztytoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysykykhokenhoutekiyouhyj = new ExDBFieldString<>("ztysykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyytirrthndsysnmnskaisuu = new ExDBFieldString<>("ztyytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin3 = new ExDBFieldString<>("ztysuuriyouyobin3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin11 = new ExDBFieldString<>("ztysuuriyouyobin11", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztywnasigoukeitenkankakaku = new ExDBFieldNumber<>("ztywnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytukibaraikansantokujyoup = new ExDBFieldNumber<>("ztytukibaraikansantokujyoup", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnkngkykkssnkijyuym = new ExDBFieldString<>("ztytnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysaiteihosyouhyouji = new ExDBFieldString<>("ztysaiteihosyouhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin8x2 = new ExDBFieldString<>("ztysuuriyouyobin8x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin14 = new ExDBFieldString<>("ztysuuriyouyobin14", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("ztyhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrimngtkykphrkkirkbn = new ExDBFieldString<>("ztyhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhrimngtkykpryurtkbn = new ExDBFieldString<>("ztyhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv13 = new ExDBFieldString<>("ztyyobiv13", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyidoujisaiteihosyoukngk = new ExDBFieldNumber<>("ztyidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyidoujisaiteihosyoucost = new ExDBFieldNumber<>("ztyidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysinhokenfundtumitatekin = new ExDBFieldNumber<>("ztysinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztymsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("ztymsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthndugtnkgetumatuv = new ExDBFieldNumber<>("ztyrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("ztyrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthendougatanksibous = new ExDBFieldNumber<>("ztyrrthendougatanksibous", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyalmyousohutomeisyoukbn = new ExDBFieldString<>("ztyalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysnkyksoftmeisyoukbn = new ExDBFieldString<>("ztysnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysoftmeisyoukbn = new ExDBFieldString<>("ztysoftmeisyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykykjitokujyouarihyj = new ExDBFieldString<>("ztykykjitokujyouarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysoujikeitenkankbn = new ExDBFieldString<>("ztysoujikeitenkankbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztynenkingatakbn = new ExDBFieldString<>("ztynenkingatakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyheiyoubaraikeiyakukbn = new ExDBFieldString<>("ztyheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztynenkinmaruteihukakbn = new ExDBFieldString<>("ztynenkinmaruteihukakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysinseizonmrtiarihyj = new ExDBFieldString<>("ztysinseizonmrtiarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysnkykyouibokijyukbn = new ExDBFieldString<>("ztysnkykyouibokijyukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokusitujyuusitusetkbn = new ExDBFieldString<>("ztytokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("ztysiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztypmensugugtganhsyunshyj = new ExDBFieldString<>("ztypmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytkykgyousekihyjszerohyj = new ExDBFieldString<>("ztytkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin7 = new ExDBFieldString<>("ztysuuriyouyobin7", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyussaikeitaikbn = new ExDBFieldString<>("ztysyussaikeitaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobiv8 = new ExDBFieldString<>("ztysuuriyouyobiv8", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysinsakbn = new ExDBFieldString<>("ztysinsakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2hihokensyasinsakbn = new ExDBFieldString<>("ztydai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2toukeiyousinsakbn = new ExDBFieldString<>("ztydai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyketteikijyunkanwakbn = new ExDBFieldString<>("ztyketteikijyunkanwakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykihonsibouhyoukbn = new ExDBFieldString<>("ztykihonsibouhyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyteikisibouhyoukbn = new ExDBFieldString<>("ztyteikisibouhyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysonotasibouhyoukbn = new ExDBFieldString<>("ztysonotasibouhyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymrarihyj = new ExDBFieldString<>("ztymrarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysentakujyouhouarihyouji = new ExDBFieldString<>("ztysentakujyouhouarihyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydugktnknsntkhuhukbn = new ExDBFieldString<>("ztydugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyjidoukousinkykkanyuuymd = new ExDBFieldString<>("ztyjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysaikohtnknkykkykymd = new ExDBFieldString<>("ztysaikohtnknkykkykymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykousinmaesykyksburtkbn = new ExDBFieldString<>("ztykousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysaihokenno = new ExDBFieldString<>("ztysaihokenno", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2dakuhiketteikekkacd = new ExDBFieldString<>("ztydai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysiboukyuuhukin = new ExDBFieldNumber<>("ztysiboukyuuhukin", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyjyudthumeharaitkykhkhyj = new ExDBFieldString<>("ztyjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykituenhonsuu = new ExDBFieldString<>("ztykituenhonsuu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymusentakukeiyakukbn = new ExDBFieldString<>("ztymusentakukeiyakukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv6x2 = new ExDBFieldString<>("ztyyobiv6x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztylivingneedssiharaihyouji = new ExDBFieldString<>("ztylivingneedssiharaihyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztylnseikyuuymd = new ExDBFieldString<>("ztylnseikyuuymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztylnshrgenincd = new ExDBFieldString<>("ztylnshrgenincd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydai2dakuhiketteisyacd = new ExDBFieldString<>("ztydai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztygansapotokuyakuarihyouji = new ExDBFieldString<>("ztygansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztygnspshrhyj = new ExDBFieldString<>("ztygnspshrhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztygansaposeikyuuymd = new ExDBFieldString<>("ztygansaposeikyuuymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztygnspshrgenincd = new ExDBFieldString<>("ztygnspshrgenincd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytargetmokuhyouritu = new ExDBFieldString<>("ztytargetmokuhyouritu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyautoswitchmokuhyouritu = new ExDBFieldString<>("ztyautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytumitatekinitenarihyj = new ExDBFieldString<>("ztytumitatekinitenarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytumitatekinitenkaisuu = new ExDBFieldString<>("ztytumitatekinitenkaisuu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrttekinendo = new ExDBFieldString<>("ztyknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrtx2 = new ExDBFieldString<>("ztyknkuzusnzyrtx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrtx3 = new ExDBFieldString<>("ztyknkuzusnzyrtx3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("ztysinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanjiknkuzusnzyrt = new ExDBFieldString<>("ztytenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykykjivithukusuukykhyj = new ExDBFieldString<>("ztykykjivithukusuukykhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin9x2 = new ExDBFieldString<>("ztysuuriyouyobin9x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x7 = new ExDBFieldString<>("ztysuuriyouyobin10x7", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x8 = new ExDBFieldString<>("ztysuuriyouyobin10x8", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x9 = new ExDBFieldString<>("ztysuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytumitatekinitenbubun = new ExDBFieldNumber<>("ztytumitatekinitenbubun", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysagakusknnjynbknzndk = new ExDBFieldNumber<>("ztysagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x11 = new ExDBFieldNumber<>("ztyyobin11x11", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x12 = new ExDBFieldNumber<>("ztyyobin11x12", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x13 = new ExDBFieldNumber<>("ztyyobin11x13", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x14 = new ExDBFieldNumber<>("ztyyobin11x14", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x15 = new ExDBFieldNumber<>("ztyyobin11x15", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x16 = new ExDBFieldNumber<>("ztyyobin11x16", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x17 = new ExDBFieldNumber<>("ztyyobin11x17", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx2 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx3 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx4 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx5 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv15x2 = new ExDBFieldString<>("ztyyobiv15x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv15x3 = new ExDBFieldString<>("ztyyobiv15x3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv15x4 = new ExDBFieldString<>("ztyyobiv15x4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztykawaserate1 = new ExDBFieldString<>("ztykawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykawaseratetekiyouymd1 = new ExDBFieldString<>("ztykawaseratetekiyouymd1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztykawaserate2 = new ExDBFieldString<>("ztykawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykawaseratetekiyouymd2 = new ExDBFieldString<>("ztykawaseratetekiyouymd2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztykaiyakukoujyoritu = new ExDBFieldString<>("ztykaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztymvakeisankijyunymd = new ExDBFieldString<>("ztymvakeisankijyunymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyenkdtsbujsitihsyucost = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("ztyenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykaigomaebaraitkykarihyj = new ExDBFieldString<>("ztykaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysiharaituukakbn = new ExDBFieldString<>("ztysiharaituukakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztywyendttargetmokuhyouritu = new ExDBFieldString<>("ztywyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyteirituikouhyouji = new ExDBFieldString<>("ztyteirituikouhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x11 = new ExDBFieldString<>("ztysuuriyouyobin10x11", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztytykzenoutouymdsisuu = new ExDBFieldString<>("ztytykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztykimatusisuu = new ExDBFieldString<>("ztykimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyenkadatekihons = new ExDBFieldNumber<>("ztyyenkadatekihons", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysitihsyumegkdtsibous = new ExDBFieldNumber<>("ztysitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyenkdtssrentumitatekin = new ExDBFieldNumber<>("ztyenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztynksjitirttumitatekin = new ExDBFieldNumber<>("ztynksjitirttumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykimatutirttumitatekin = new ExDBFieldNumber<>("ztykimatutirttumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygaikadatejyuutoup = new ExDBFieldNumber<>("ztygaikadatejyuutoup", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyendttargetkijyunkingaku = new ExDBFieldNumber<>("ztyyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysitivkisnyukykjikwsrate = new ExDBFieldString<>("ztysitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysisuurentyokugotmttkn = new ExDBFieldNumber<>("ztysisuurentyokugotmttkn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyyoteiririturironbase = new ExDBFieldString<>("ztyyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyyoteiriritujtnyknbase = new ExDBFieldString<>("ztyyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykihrkmpjtnyknbase = new ExDBFieldNumber<>("ztykihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysyuptumitatekingsc = new ExDBFieldNumber<>("ztysyuptumitatekingsc", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyjikaipjyuutouym2 = new ExDBFieldString<>("ztyjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Integer> ztysuuriyobin9 = new ExDBFieldNumber<>("ztysuuriyobin9", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygessitumitatekin = new ExDBFieldNumber<>("ztygessitumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygaikadatetougetujuutoup = new ExDBFieldNumber<>("ztygaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykihrkmpmsukisymbase = new ExDBFieldNumber<>("ztykihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykeisanhanteiyoutmttkn = new ExDBFieldNumber<>("ztykeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygtmtv = new ExDBFieldNumber<>("ztygtmtv", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyzettaisibouritu = new ExDBFieldString<>("ztyzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysoutaisibouritu = new ExDBFieldString<>("ztysoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztysoutaikaiyakuritu = new ExDBFieldString<>("ztysoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyvhireilritu2 = new ExDBFieldString<>("ztyvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyphireialpha = new ExDBFieldString<>("ztyphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyphireibeta = new ExDBFieldString<>("ztyphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyphireiganma = new ExDBFieldString<>("ztyphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyphireilwrbkritu = new ExDBFieldString<>("ztyphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyyoteiriritumsukisymbase = new ExDBFieldString<>("ztyyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkiso = new ExDBFieldNumber<>("ztyrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykykkjmmvatyouseigow = new ExDBFieldNumber<>("ztykykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x39 = new ExDBFieldNumber<>("ztyyobin11x39", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x41 = new ExDBFieldNumber<>("ztyyobin11x41", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x42 = new ExDBFieldNumber<>("ztyyobin11x42", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x43 = new ExDBFieldNumber<>("ztyyobin11x43", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x44 = new ExDBFieldNumber<>("ztyyobin11x44", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x45 = new ExDBFieldNumber<>("ztyyobin11x45", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x3 = new ExDBFieldString<>("ztysuuriyouyobin15x3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x4 = new ExDBFieldString<>("ztysuuriyouyobin15x4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x5 = new ExDBFieldString<>("ztysuuriyouyobin15x5", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x6 = new ExDBFieldString<>("ztysuuriyouyobin15x6", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv14 = new ExDBFieldString<>("ztyyobiv14", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykyksyhhknsydouituhyouji = new ExDBFieldString<>("ztykyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykyksyaskinmeino = new ExDBFieldString<>("ztykyksyaskinmeino", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeikihons = new ExDBFieldNumber<>("ztygoukeikihons", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeigyousekihyjsibous = new ExDBFieldNumber<>("ztygoukeigyousekihyjsibous", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyalmyousibous = new ExDBFieldNumber<>("ztyalmyousibous", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysiteizukiharaikomip = new ExDBFieldNumber<>("ztysiteizukiharaikomip", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysaisyuusiteimhrkp = new ExDBFieldNumber<>("ztysaisyuusiteimhrkp", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeinenbaraikansanp = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztygyousekihyoujisrank = new ExDBFieldString<>("ztygyousekihyoujisrank", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, BizNumber> ztyteikibairitu = new ExDBFieldString<>("ztyteikibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkangodatakanrino = new ExDBFieldString<>("ztytenkangodatakanrino", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaitekykdatakanrino1 = new ExDBFieldString<>("ztyaitekykdatakanrino1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaitekykdatakanrino2 = new ExDBFieldString<>("ztyaitekykdatakanrino2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknsyokaipcashlesshyj = new ExDBFieldString<>("ztytnknsyokaipcashlesshyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyokaipannaikbn = new ExDBFieldString<>("ztysyokaipannaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzennoukaisiymd = new ExDBFieldString<>("ztyzennoukaisiymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyzennoukikan = new ExDBFieldString<>("ztyzennoukikan", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyseizonkyuuhukinsiteiy = new ExDBFieldString<>("ztyseizonkyuuhukinsiteiy", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyalmyouseizonkyhknsiteimd = new ExDBFieldString<>("ztyalmyouseizonkyhknsiteimd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x1 = new ExDBFieldString<>("ztyhktgtikkikkkn3x1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x2 = new ExDBFieldString<>("ztyhktgtikkikkkn3x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x3 = new ExDBFieldString<>("ztyhktgtikkikkkn3x3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x4 = new ExDBFieldString<>("ztyhktgtikkikkkn3x4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx1 = new ExDBFieldString<>("ztykappadkeisankbnx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx2 = new ExDBFieldString<>("ztykappadkeisankbnx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx3 = new ExDBFieldString<>("ztykappadkeisankbnx3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx4 = new ExDBFieldString<>("ztykappadkeisankbnx4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv6x3 = new ExDBFieldString<>("ztyyobiv6x3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykimatuvyoutumimasikin = new ExDBFieldNumber<>("ztykimatuvyoutumimasikin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykmtvyusnhknfundtmttkin = new ExDBFieldNumber<>("ztykmtvyusnhknfundtmttkin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x1 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x2 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x3 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x4 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x4", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykmtvyuhijynbritmttkin = new ExDBFieldNumber<>("ztykmtvyuhijynbritmttkin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykimatuvyouitjbrtmttkin = new ExDBFieldNumber<>("ztykimatuvyouitjbrtmttkin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x26 = new ExDBFieldNumber<>("ztyyobin11x26", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x27 = new ExDBFieldNumber<>("ztyyobin11x27", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x28 = new ExDBFieldNumber<>("ztyyobin11x28", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x29 = new ExDBFieldNumber<>("ztyyobin11x29", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x30 = new ExDBFieldNumber<>("ztyyobin11x30", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x31 = new ExDBFieldNumber<>("ztyyobin11x31", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x32 = new ExDBFieldNumber<>("ztyyobin11x32", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x33 = new ExDBFieldNumber<>("ztyyobin11x33", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhaitouyouloadingkijyuns = new ExDBFieldNumber<>("ztyhaitouyouloadingkijyuns", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytouduketorihouhoukbn = new ExDBFieldString<>("ztytouduketorihouhoukbn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytumitated = new ExDBFieldNumber<>("ztytumitated", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykariwariated = new ExDBFieldNumber<>("ztykariwariated", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytyokuzensiharaikijitu = new ExDBFieldString<>("ztytyokuzensiharaikijitu", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytyokuzentuusanhanteis = new ExDBFieldNumber<>("ztytyokuzentuusanhanteis", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytyokugosiharaikijitu = new ExDBFieldString<>("ztytyokugosiharaikijitu", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytyokugotuusanhanteis = new ExDBFieldNumber<>("ztytyokugotuusanhanteis", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytyokugokyuuhutaisyous = new ExDBFieldNumber<>("ztytyokugokyuuhutaisyous", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytyokugocbkingaku = new ExDBFieldNumber<>("ztytyokugocbkingaku", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyokaisiharaikijitu = new ExDBFieldString<>("ztysyokaisiharaikijitu", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysyokaituusanhanteis = new ExDBFieldNumber<>("ztysyokaituusanhanteis", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztycbnayosetuusanhanteis = new ExDBFieldNumber<>("ztycbnayosetuusanhanteis", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhitenkankeiyakusuu = new ExDBFieldString<>("ztyhitenkankeiyakusuu", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztygoukeipbubuntenkanteikis = new ExDBFieldNumber<>("ztygoukeipbubuntenkanteikis", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysaidaihktgtikkikkkn = new ExDBFieldString<>("ztysaidaihktgtikkikkkn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysisyutnknhktgkujygk = new ExDBFieldNumber<>("ztysisyutnknhktgkujygk", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x34 = new ExDBFieldNumber<>("ztyyobin11x34", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx1 = new ExDBFieldString<>("ztyhtnknkykkykymdx1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx1 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux1 = new ExDBFieldString<>("ztytnknkaiykkujytksux1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx1 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix1 = new ExDBFieldString<>("ztytenkanteikihyoujix1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx1 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx1 = new ExDBFieldString<>("ztyhktgtikkikkknx1", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx2 = new ExDBFieldString<>("ztyhtnknkykkykymdx2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx2 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux2 = new ExDBFieldString<>("ztytnknkaiykkujytksux2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx2 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix2 = new ExDBFieldString<>("ztytenkanteikihyoujix2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx2 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx2 = new ExDBFieldString<>("ztyhktgtikkikkknx2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx3 = new ExDBFieldString<>("ztyhtnknkykkykymdx3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx3 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux3 = new ExDBFieldString<>("ztytnknkaiykkujytksux3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx3 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix3 = new ExDBFieldString<>("ztytenkanteikihyoujix3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx3 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx3 = new ExDBFieldString<>("ztyhktgtikkikkknx3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx4 = new ExDBFieldString<>("ztyhtnknkykkykymdx4", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx4 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux4 = new ExDBFieldString<>("ztytnknkaiykkujytksux4", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx4 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix4 = new ExDBFieldString<>("ztytenkanteikihyoujix4", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx4 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx4 = new ExDBFieldString<>("ztyhktgtikkikkknx4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysknjyututkykkykkbn = new ExDBFieldString<>("ztysknjyututkykkykkbn", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyswingminyuuphrkekngk = new ExDBFieldNumber<>("ztyswingminyuuphrkekngk", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyswingminyuuphrkejyutuym = new ExDBFieldString<>("ztyswingminyuuphrkejyutuym", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztydftounendoitijitounyuup = new ExDBFieldNumber<>("ztydftounendoitijitounyuup", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztydfkaiyakukujyhktggk = new ExDBFieldNumber<>("ztydfkaiyakukujyhktggk", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykaiyakukoujyotukisuu = new ExDBFieldString<>("ztykaiyakukoujyotukisuu", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztydfkaiyakuhenreikin = new ExDBFieldNumber<>("ztydfkaiyakuhenreikin", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztysyuuseis = new ExDBFieldNumber<>("ztysyuuseis", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaatukaisyakeisyousisyacd = new ExDBFieldString<>("ztyaatukaisyakeisyousisyacd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaatukaisyazaisekihyouji = new ExDBFieldString<>("ztyaatukaisyazaisekihyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaatukaisyabosyuujiage = new ExDBFieldString<>("ztyaatukaisyabosyuujiage", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaatukaisyabsyjisikakucd = new ExDBFieldString<>("ztyaatukaisyabsyjisikakucd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyaatukaisyasikakucd = new ExDBFieldString<>("ztyaatukaisyasikakucd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyokyksmkuztrhkkitikbn = new ExDBFieldString<>("ztyokyksmkuztrhkkitikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhoyuusisyacd = new ExDBFieldString<>("ztyhoyuusisyacd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyokansisyacd = new ExDBFieldString<>("ztysyokansisyacd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytantousyakbn = new ExDBFieldString<>("ztytantousyakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytantousyakbnnew = new ExDBFieldString<>("ztytantousyakbnnew", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyclubsumiseikbn = new ExDBFieldString<>("ztyclubsumiseikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyfollowtantousyakbn = new ExDBFieldString<>("ztyfollowtantousyakbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytantousyajyoutaikbn = new ExDBFieldString<>("ztytantousyajyoutaikbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykihonyoteii = new ExDBFieldString<>("ztykihonyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyteikiyoteii = new ExDBFieldString<>("ztyteikiyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysonotayoteii = new ExDBFieldString<>("ztysonotayoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyitijibaraikihonyoteii = new ExDBFieldString<>("ztyitijibaraikihonyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyitijibaraiteikiyoteii = new ExDBFieldString<>("ztyitijibaraiteikiyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyitijibaraisonotayoteii = new ExDBFieldString<>("ztyitijibaraisonotayoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkankihonyoteii = new ExDBFieldString<>("ztytenkankihonyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytenkanteikiyoteii = new ExDBFieldString<>("ztytenkanteikiyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyszouyoteii = new ExDBFieldString<>("ztyszouyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyvestingyoteii = new ExDBFieldString<>("ztyvestingyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysippeitokuyakuyoteii = new ExDBFieldString<>("ztysippeitokuyakuyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyseijinbyoutokuyakuyoteii = new ExDBFieldString<>("ztyseijinbyoutokuyakuyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyjyoseitokuyakuyoteii = new ExDBFieldString<>("ztyjyoseitokuyakuyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytuuintokuyakuyoteii = new ExDBFieldString<>("ztytuuintokuyakuyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysaiteihosyoui = new ExDBFieldString<>("ztysaiteihosyoui", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyvkisoitjbrkhnyoteii = new ExDBFieldString<>("ztyvkisoitjbrkhnyoteii", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyvkisorrtzeroikahyouji = new ExDBFieldString<>("ztyvkisorrtzeroikahyouji", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin3x2 = new ExDBFieldString<>("ztysuuriyouyobin3x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhoyuusisyacd2 = new ExDBFieldString<>("ztyhoyuusisyacd2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztydftujyukujykisnkisiym = new ExDBFieldString<>("ztydftujyukujykisnkisiym", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytikikktbrijyututksu = new ExDBFieldString<>("ztytikikktbrijyututksu", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysyunyumrtikykjtigngtkbn = new ExDBFieldString<>("ztysyunyumrtikykjtigngtkbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyhhkdrtkykarihyj = new ExDBFieldString<>("ztyhhkdrtkykarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztyyobiv10x14 = new ExDBFieldString<>("ztyyobiv10x14", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx1 = new ExDBFieldNumber<>("ztykappadhktgkujygkx1", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx2 = new ExDBFieldNumber<>("ztykappadhktgkujygkx2", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx3 = new ExDBFieldNumber<>("ztykappadhktgkujygkx3", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx4 = new ExDBFieldNumber<>("ztykappadhktgkujygkx4", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztytrkzsgkaiykkjynstmtkzndk = new ExDBFieldNumber<>("ztytrkzsgkaiykkjynstmtkzndk", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztypmenkouryokuhasseiymd = new ExDBFieldString<>("ztypmenkouryokuhasseiymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin5 = new ExDBFieldString<>("ztysuuriyouyobin5", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin13 = new ExDBFieldString<>("ztysuuriyouyobin13", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x35 = new ExDBFieldNumber<>("ztyyobin11x35", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x36 = new ExDBFieldNumber<>("ztyyobin11x36", this);

    public final ExDBFieldNumber<ST_IdouMeisaiTyukeiyouItzHzn, Long> ztyyobin11x37 = new ExDBFieldNumber<>("ztyyobin11x37", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200 = new ExDBFieldString<>("ztytokuyakukoumokuv200", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x2 = new ExDBFieldString<>("ztytokuyakukoumokuv200x2", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x3 = new ExDBFieldString<>("ztytokuyakukoumokuv200x3", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x4 = new ExDBFieldString<>("ztytokuyakukoumokuv200x4", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x5 = new ExDBFieldString<>("ztytokuyakukoumokuv200x5", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x6 = new ExDBFieldString<>("ztytokuyakukoumokuv200x6", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x7 = new ExDBFieldString<>("ztytokuyakukoumokuv200x7", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x8 = new ExDBFieldString<>("ztytokuyakukoumokuv200x8", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x9 = new ExDBFieldString<>("ztytokuyakukoumokuv200x9", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x10 = new ExDBFieldString<>("ztytokuyakukoumokuv200x10", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x11 = new ExDBFieldString<>("ztytokuyakukoumokuv200x11", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x12 = new ExDBFieldString<>("ztytokuyakukoumokuv200x12", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x13 = new ExDBFieldString<>("ztytokuyakukoumokuv200x13", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x14 = new ExDBFieldString<>("ztytokuyakukoumokuv200x14", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x15 = new ExDBFieldString<>("ztytokuyakukoumokuv200x15", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x16 = new ExDBFieldString<>("ztytokuyakukoumokuv200x16", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x17 = new ExDBFieldString<>("ztytokuyakukoumokuv200x17", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x18 = new ExDBFieldString<>("ztytokuyakukoumokuv200x18", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x19 = new ExDBFieldString<>("ztytokuyakukoumokuv200x19", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x20 = new ExDBFieldString<>("ztytokuyakukoumokuv200x20", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x21 = new ExDBFieldString<>("ztytokuyakukoumokuv200x21", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x22 = new ExDBFieldString<>("ztytokuyakukoumokuv200x22", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x23 = new ExDBFieldString<>("ztytokuyakukoumokuv200x23", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x24 = new ExDBFieldString<>("ztytokuyakukoumokuv200x24", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x25 = new ExDBFieldString<>("ztytokuyakukoumokuv200x25", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x26 = new ExDBFieldString<>("ztytokuyakukoumokuv200x26", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x27 = new ExDBFieldString<>("ztytokuyakukoumokuv200x27", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x28 = new ExDBFieldString<>("ztytokuyakukoumokuv200x28", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x29 = new ExDBFieldString<>("ztytokuyakukoumokuv200x29", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x30 = new ExDBFieldString<>("ztytokuyakukoumokuv200x30", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x31 = new ExDBFieldString<>("ztytokuyakukoumokuv200x31", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x32 = new ExDBFieldString<>("ztytokuyakukoumokuv200x32", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x33 = new ExDBFieldString<>("ztytokuyakukoumokuv200x33", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x34 = new ExDBFieldString<>("ztytokuyakukoumokuv200x34", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x35 = new ExDBFieldString<>("ztytokuyakukoumokuv200x35", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x36 = new ExDBFieldString<>("ztytokuyakukoumokuv200x36", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x37 = new ExDBFieldString<>("ztytokuyakukoumokuv200x37", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x38 = new ExDBFieldString<>("ztytokuyakukoumokuv200x38", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x39 = new ExDBFieldString<>("ztytokuyakukoumokuv200x39", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x40 = new ExDBFieldString<>("ztytokuyakukoumokuv200x40", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrkouryokuhasseiymd = new ExDBFieldString<>("ztysrkouryokuhasseiymd", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrhenkousikibetukey = new ExDBFieldString<>("ztysrhenkousikibetukey", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrhoseirecordhanbetukbn = new ExDBFieldString<>("ztysrhoseirecordhanbetukbn", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrhoseihenkousikibetukey = new ExDBFieldString<>("ztysrhoseihenkousikibetukey", this);

    public final ExDBFieldString<ST_IdouMeisaiTyukeiyouItzHzn, String> ztysrteikishrtkykhukaumu = new ExDBFieldString<>("ztysrteikishrtkykhukaumu", this);
}
