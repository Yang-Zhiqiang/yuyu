package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 保有明細中継用一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_HoyuuMeisaiTyukeiyouItzHzn extends AbstractExDBTable<ST_HoyuuMeisaiTyukeiyouItzHzn> {

    public GenQST_HoyuuMeisaiTyukeiyouItzHzn() {
        this("ST_HoyuuMeisaiTyukeiyouItzHzn");
    }

    public GenQST_HoyuuMeisaiTyukeiyouItzHzn(String pAlias) {
        super("ST_HoyuuMeisaiTyukeiyouItzHzn", ST_HoyuuMeisaiTyukeiyouItzHzn.class, pAlias);
    }

    public String ST_HoyuuMeisaiTyukeiyouItzHzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysrkijyunym = new ExDBFieldString<>("ztysrkijyunym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysrkakutyoujobcd = new ExDBFieldString<>("ztysrkakutyoujobcd", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztynenkinkaisigohyouji = new ExDBFieldString<>("ztynenkinkaisigohyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztynksgokurikosidhyj = new ExDBFieldString<>("ztynksgokurikosidhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyidojiyukbn = new ExDBFieldString<>("ztyidojiyukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzougenkbn = new ExDBFieldString<>("ztyzougenkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyidourecordkbn = new ExDBFieldString<>("ztyidourecordkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykeijyouctrlkbn = new ExDBFieldString<>("ztykeijyouctrlkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztykykmfksnctr = new ExDBFieldNumber<>("ztykykmfksnctr", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztyrecordctr = new ExDBFieldNumber<>("ztyrecordctr", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyoukouryokukaisiymd = new ExDBFieldString<>("ztysuuriyoukouryokukaisiymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztybluekeizokuhyouji = new ExDBFieldString<>("ztybluekeizokuhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytoukeikeijyoukbn = new ExDBFieldString<>("ztytoukeikeijyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzenkiidouteiseikbn = new ExDBFieldString<>("ztyzenkiidouteiseikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkangokeiyakubosyuuym = new ExDBFieldString<>("ztytenkangokeiyakubosyuuym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyidoujiyuucd = new ExDBFieldString<>("ztyidoujiyuucd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysekininteiseihyouji = new ExDBFieldString<>("ztysekininteiseihyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysihankibikinkbn = new ExDBFieldString<>("ztysihankibikinkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x3 = new ExDBFieldString<>("ztysuuriyouyobin1x3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhosyoukinoukbn = new ExDBFieldString<>("ztyhosyoukinoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydaikbn = new ExDBFieldString<>("ztydaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytyuukbn = new ExDBFieldString<>("ztytyuukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyoukbn = new ExDBFieldString<>("ztysyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysedaikbn = new ExDBFieldString<>("ztysedaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyao3tyou3sibousdatehyouji = new ExDBFieldString<>("ztyao3tyou3sibousdatehyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytkbthsyumnryuhyouji = new ExDBFieldString<>("ztytkbthsyumnryuhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyukeiyakupwaribikikbn = new ExDBFieldString<>("ztysyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanwaribikikbn = new ExDBFieldString<>("ztytenkanwaribikikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyuuhitutnknyuguryurtkbn = new ExDBFieldString<>("ztyyuuhitutnknyuguryurtkbn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysiteizukisyukeiyakup = new ExDBFieldNumber<>("ztysiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhenkougokihons = new ExDBFieldNumber<>("ztyhenkougokihons", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhenkougosibous = new ExDBFieldNumber<>("ztyhenkougosibous", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhenkouymd = new ExDBFieldString<>("ztyhenkouymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyentyoukikan = new ExDBFieldString<>("ztyentyoukikan", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyseizonkyuuhukinsiteimd = new ExDBFieldString<>("ztyseizonkyuuhukinsiteimd", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysyukeiyakusiharaikingaku = new ExDBFieldNumber<>("ztysyukeiyakusiharaikingaku", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyatukaisisyatodouhukencd = new ExDBFieldString<>("ztyatukaisisyatodouhukencd", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztytokuyakuhukasuu = new ExDBFieldNumber<>("ztytokuyakuhukasuu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydi2hknkknikoujihisyaage = new ExDBFieldString<>("ztydi2hknkknikoujihisyaage", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrimnentyoumaephrkkkn = new ExDBFieldString<>("ztyhrimnentyoumaephrkkkn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrizmjhknsyukigousdkbn = new ExDBFieldString<>("ztyhrizmjhknsyukigousdkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykrsgjhknsyukigousdkbn = new ExDBFieldString<>("ztykrsgjhknsyukigousdkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysotodasisyouhinkaiteikbn = new ExDBFieldString<>("ztysotodasisyouhinkaiteikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeitenkans = new ExDBFieldNumber<>("ztygoukeitenkans", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeipbubuntenkans = new ExDBFieldNumber<>("ztygoukeipbubuntenkans", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikisyuruikigou = new ExDBFieldString<>("ztytenkanteikisyuruikigou", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikikigousedaikbn = new ExDBFieldString<>("ztytenkanteikikigousedaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnkntiksotodasikusnkbn = new ExDBFieldString<>("ztytnkntiksotodasikusnkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnkntikstdspmenkbn = new ExDBFieldString<>("ztytnkntikstdspmenkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikikigouyobi = new ExDBFieldString<>("ztytenkanteikikigouyobi", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikikikan = new ExDBFieldString<>("ztytenkanteikikikan", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeitenkanteikis = new ExDBFieldNumber<>("ztygoukeitenkanteikis", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknteikinkshrkkn = new ExDBFieldString<>("ztytnknteikinkshrkkn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytenkansiharaikingaku = new ExDBFieldNumber<>("ztytenkansiharaikingaku", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnkntikshrkngk = new ExDBFieldNumber<>("ztytnkntikshrkngk", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeitenkankakaku = new ExDBFieldNumber<>("ztygoukeitenkankakaku", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztytnknkhnbbnjyuturt = new ExDBFieldString<>("ztytnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztywnasigoukeitenkanteikis = new ExDBFieldNumber<>("ztywnasigoukeitenkanteikis", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknteikikousinmnryouage = new ExDBFieldString<>("ztytnknteikikousinmnryouage", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykanyujidatakanrino = new ExDBFieldString<>("ztykanyujidatakanrino", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykanyujikykymd = new ExDBFieldString<>("ztykanyujikykymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykanyuujihihokensyaage = new ExDBFieldString<>("ztykanyuujihihokensyaage", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykanyuujitenkanhyouji = new ExDBFieldString<>("ztykanyuujitenkanhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhsyuikktminaosikaisu = new ExDBFieldString<>("ztyhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysknnjynbknsisnrt = new ExDBFieldString<>("ztysknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysakugenkikan = new ExDBFieldString<>("ztysakugenkikan", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysykyktkjyuryumsratehyj = new ExDBFieldString<>("ztysykyktkjyuryumsratehyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysykyktkjyuryumsrate = new ExDBFieldString<>("ztysykyktkjyuryumsrate", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2tokujyoukbn = new ExDBFieldString<>("ztydai2tokujyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2sakugenkikan = new ExDBFieldString<>("ztydai2sakugenkikan", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuteibuijyoukenhyouji = new ExDBFieldString<>("ztytokuteibuijyoukenhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuteibuino1 = new ExDBFieldString<>("ztytokuteibuino1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhtnpkkn1 = new ExDBFieldString<>("ztyhtnpkkn1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuteibuino2 = new ExDBFieldString<>("ztytokuteibuino2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhtnpkkn2 = new ExDBFieldString<>("ztyhtnpkkn2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymhituiryuyutktbijyknhyj = new ExDBFieldString<>("ztymhituiryuyutktbijyknhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyoutktbino1 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyouhtnpkkn1 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyoutktbino2 = new ExDBFieldString<>("ztymuhaitouiryouyoutktbino2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymuhaitouiryouyouhtnpkkn2 = new ExDBFieldString<>("ztymuhaitouiryouyouhtnpkkn2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysiteizukipwarimasihyouji = new ExDBFieldString<>("ztysiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztypwarimasisiteim1 = new ExDBFieldString<>("ztypwarimasisiteim1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztypwarimasisiteim2 = new ExDBFieldString<>("ztypwarimasisiteim2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysiteimsykykpbairitu = new ExDBFieldString<>("ztysiteimsykykpbairitu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysaisyuusiteiym = new ExDBFieldString<>("ztysaisyuusiteiym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysykykkitmttvkeisanym = new ExDBFieldString<>("ztysykykkitmttvkeisanym", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysykykkitmttsknnjynbkngk = new ExDBFieldNumber<>("ztysykykkitmttsknnjynbkngk", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztydftumitatekingaku = new ExDBFieldNumber<>("ztydftumitatekingaku", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztydftumimasikin = new ExDBFieldNumber<>("ztydftumimasikin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyvbubundftenkankakaku = new ExDBFieldNumber<>("ztyvbubundftenkankakaku", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztydpbubundftenkankakaku = new ExDBFieldNumber<>("ztydpbubundftenkankakaku", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztydftmttkngkitjbrbbn = new ExDBFieldNumber<>("ztydftmttkngkitjbrbbn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhendous = new ExDBFieldNumber<>("ztyhendous", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhengakujigyounendomatucv = new ExDBFieldNumber<>("ztyhengakujigyounendomatucv", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyitibitjbrshrkngk = new ExDBFieldNumber<>("ztyitibitjbrshrkngk", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeicv = new ExDBFieldNumber<>("ztygoukeicv", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyminasicv = new ExDBFieldNumber<>("ztyminasicv", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyloanfund = new ExDBFieldNumber<>("ztyloanfund", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysaiteihosyougaku = new ExDBFieldNumber<>("ztysaiteihosyougaku", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhngksitihsyuyusykykp = new ExDBFieldNumber<>("ztyhngksitihsyuyusykykp", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhijynbrivasbujsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivasbujsitihsyugk", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhijynbrivamnkjsitihsyugk = new ExDBFieldNumber<>("ztyhijynbrivamnkjsitihsyugk", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysiinkbn = new ExDBFieldString<>("ztysiinkbn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztymudkaimasikihons = new ExDBFieldNumber<>("ztymudkaimasikihons", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykaimasiymd = new ExDBFieldString<>("ztykaimasiymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykaimasikikan = new ExDBFieldString<>("ztykaimasikikan", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhikitugikaimasis = new ExDBFieldNumber<>("ztyhikitugikaimasis", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztymudkaimasisiharaikingaku = new ExDBFieldNumber<>("ztymudkaimasisiharaikingaku", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoukouryokukaisiymdx1 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszouhokensyuruikigoux1 = new ExDBFieldString<>("ztyszouhokensyuruikigoux1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoukigousedaikbnx1 = new ExDBFieldString<>("ztyszoukigousedaikbnx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoukikanx1 = new ExDBFieldString<>("ztyszoukikanx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszouhihokensyaagex1 = new ExDBFieldString<>("ztyszouhihokensyaagex1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoudai2hihknsyaagex1 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyzoukasx1 = new ExDBFieldNumber<>("ztyzoukasx1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyzennendozoukasx1 = new ExDBFieldNumber<>("ztyzennendozoukasx1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyszousiharaikingakux1 = new ExDBFieldNumber<>("ztyszousiharaikingakux1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoukouryokukaisiymdx2 = new ExDBFieldString<>("ztyszoukouryokukaisiymdx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszouhokensyuruikigoux2 = new ExDBFieldString<>("ztyszouhokensyuruikigoux2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoukigousedaikbnx2 = new ExDBFieldString<>("ztyszoukigousedaikbnx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoukikanx2 = new ExDBFieldString<>("ztyszoukikanx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszouhihokensyaagex2 = new ExDBFieldString<>("ztyszouhihokensyaagex2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoudai2hihknsyaagex2 = new ExDBFieldString<>("ztyszoudai2hihknsyaagex2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyzoukasx2 = new ExDBFieldNumber<>("ztyzoukasx2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyzennendozoukasx2 = new ExDBFieldNumber<>("ztyzennendozoukasx2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyszousiharaikingakux2 = new ExDBFieldNumber<>("ztyszousiharaikingakux2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x5 = new ExDBFieldString<>("ztysuuriyouyobin1x5", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin1x6 = new ExDBFieldString<>("ztysuuriyouyobin1x6", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrimngkizktkykpmenhyj = new ExDBFieldString<>("ztyhrimngkizktkykpmenhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymisyuustartym = new ExDBFieldString<>("ztymisyuustartym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymisyuukaisuu = new ExDBFieldString<>("ztymisyuukaisuu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyitjbrtkykkousnuktkarhyj = new ExDBFieldString<>("ztyitjbrtkykkousnuktkarhyj", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygyousekihyoujis = new ExDBFieldNumber<>("ztygyousekihyoujis", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysykykgyusekihyjs = new ExDBFieldNumber<>("ztysykykgyusekihyjs", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytenkangyousekihyoujis = new ExDBFieldNumber<>("ztytenkangyousekihyoujis", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnknteikigyousekihyjs = new ExDBFieldNumber<>("ztytnknteikigyousekihyjs", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnkndpbbngyuskhyjs = new ExDBFieldNumber<>("ztytnkndpbbngyuskhyjs", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykykjyoutai = new ExDBFieldString<>("ztykykjyoutai", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymankiyoteikbn = new ExDBFieldString<>("ztymankiyoteikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysykyktikmnkyoteikbn = new ExDBFieldString<>("ztysykyktikmnkyoteikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknsykykkhnmnkytikbn = new ExDBFieldString<>("ztytnknsykykkhnmnkytikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknsykyktikmnkytikbn = new ExDBFieldString<>("ztytnknsykyktikmnkytikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikimankiyoteikbn = new ExDBFieldString<>("ztytenkanteikimankiyoteikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoumankiyoteikbnx1 = new ExDBFieldString<>("ztyszoumankiyoteikbnx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszoumankiyoteikbnx2 = new ExDBFieldString<>("ztyszoumankiyoteikbnx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyvestingmankiyoteikbn = new ExDBFieldString<>("ztyvestingmankiyoteikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyvkeisanhyouji = new ExDBFieldString<>("ztyvkeisanhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytoukisinkeiyakuhyouji = new ExDBFieldString<>("ztytoukisinkeiyakuhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysykykhokenhoutekiyouhyj = new ExDBFieldString<>("ztysykykhokenhoutekiyouhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyytirrthndsysnmnskaisuu = new ExDBFieldString<>("ztyytirrthndsysnmnskaisuu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin3 = new ExDBFieldString<>("ztysuuriyouyobin3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin11 = new ExDBFieldString<>("ztysuuriyouyobin11", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztywnasigoukeitenkankakaku = new ExDBFieldNumber<>("ztywnasigoukeitenkankakaku", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytukibaraikansantokujyoup = new ExDBFieldNumber<>("ztytukibaraikansantokujyoup", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnkngkykkssnkijyuym = new ExDBFieldString<>("ztytnkngkykkssnkijyuym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysaiteihosyouhyouji = new ExDBFieldString<>("ztysaiteihosyouhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin8x2 = new ExDBFieldString<>("ztysuuriyouyobin8x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin14 = new ExDBFieldString<>("ztysuuriyouyobin14", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrimngtkykphrkkaisuukbn = new ExDBFieldString<>("ztyhrimngtkykphrkkaisuukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrimngtkykphrkkirkbn = new ExDBFieldString<>("ztyhrimngtkykphrkkirkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhrimngtkykpryurtkbn = new ExDBFieldString<>("ztyhrimngtkykpryurtkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv13 = new ExDBFieldString<>("ztyyobiv13", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyidoujisaiteihosyoukngk = new ExDBFieldNumber<>("ztyidoujisaiteihosyoukngk", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyidoujisaiteihosyoucost = new ExDBFieldNumber<>("ztyidoujisaiteihosyoucost", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysinhokenfundtumitatekin = new ExDBFieldNumber<>("ztysinhokenfundtumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztymsyuptusshkgkaiykhnrikn = new ExDBFieldNumber<>("ztymsyuptusshkgkaiykhnrikn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthndugtnkgetumatuv = new ExDBFieldNumber<>("ztyrrthndugtnkgetumatuv", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthndnksaiteihosyonkgns = new ExDBFieldNumber<>("ztyrrthndnksaiteihosyonkgns", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthendougatanksibous = new ExDBFieldNumber<>("ztyrrthendougatanksibous", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyalmyousohutomeisyoukbn = new ExDBFieldString<>("ztyalmyousohutomeisyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysnkyksoftmeisyoukbn = new ExDBFieldString<>("ztysnkyksoftmeisyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysoftmeisyoukbn = new ExDBFieldString<>("ztysoftmeisyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykykjitokujyouarihyj = new ExDBFieldString<>("ztykykjitokujyouarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysoujikeitenkankbn = new ExDBFieldString<>("ztysoujikeitenkankbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztynenkinkaisinendo = new ExDBFieldString<>("ztynenkinkaisinendo", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztynenkingatakbn = new ExDBFieldString<>("ztynenkingatakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyheiyoubaraikeiyakukbn = new ExDBFieldString<>("ztyheiyoubaraikeiyakukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztynenkinmaruteihukakbn = new ExDBFieldString<>("ztynenkinmaruteihukakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysinseizonmrtiarihyj = new ExDBFieldString<>("ztysinseizonmrtiarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysnkykyouibokijyukbn = new ExDBFieldString<>("ztysnkykyouibokijyukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokusitujyuusitusetkbn = new ExDBFieldString<>("ztytokusitujyuusitusetkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysiktsyuknbyugnhsyunshyj = new ExDBFieldString<>("ztysiktsyuknbyugnhsyunshyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztypmensugugtganhsyunshyj = new ExDBFieldString<>("ztypmensugugtganhsyunshyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytkykgyousekihyjszerohyj = new ExDBFieldString<>("ztytkykgyousekihyjszerohyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin7 = new ExDBFieldString<>("ztysuuriyouyobin7", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyussaikeitaikbn = new ExDBFieldString<>("ztysyussaikeitaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobiv8 = new ExDBFieldString<>("ztysuuriyouyobiv8", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysinsakbn = new ExDBFieldString<>("ztysinsakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2hihokensyasinsakbn = new ExDBFieldString<>("ztydai2hihokensyasinsakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2toukeiyousinsakbn = new ExDBFieldString<>("ztydai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyketteikijyunkanwakbn = new ExDBFieldString<>("ztyketteikijyunkanwakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykihonsibouhyoukbn = new ExDBFieldString<>("ztykihonsibouhyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyteikisibouhyoukbn = new ExDBFieldString<>("ztyteikisibouhyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysonotasibouhyoukbn = new ExDBFieldString<>("ztysonotasibouhyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymrarihyj = new ExDBFieldString<>("ztymrarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysentakujyouhouarihyouji = new ExDBFieldString<>("ztysentakujyouhouarihyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydugktnknsntkhuhukbn = new ExDBFieldString<>("ztydugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyjidoukousinkykkanyuuymd = new ExDBFieldString<>("ztyjidoukousinkykkanyuuymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysaikohtnknkykkykymd = new ExDBFieldString<>("ztysaikohtnknkykkykymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykousinmaesykyksburtkbn = new ExDBFieldString<>("ztykousinmaesykyksburtkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysaihokenno = new ExDBFieldString<>("ztysaihokenno", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2dakuhiketteikekkacd = new ExDBFieldString<>("ztydai2dakuhiketteikekkacd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysiboukyuuhukin = new ExDBFieldNumber<>("ztysiboukyuuhukin", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyjyudthumeharaitkykhkhyj = new ExDBFieldString<>("ztyjyudthumeharaitkykhkhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykituenhonsuu = new ExDBFieldString<>("ztykituenhonsuu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymusentakukeiyakukbn = new ExDBFieldString<>("ztymusentakukeiyakukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv6x2 = new ExDBFieldString<>("ztyyobiv6x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztylivingneedssiharaihyouji = new ExDBFieldString<>("ztylivingneedssiharaihyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztylnseikyuuymd = new ExDBFieldString<>("ztylnseikyuuymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztylnshrgenincd = new ExDBFieldString<>("ztylnshrgenincd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydai2dakuhiketteisyacd = new ExDBFieldString<>("ztydai2dakuhiketteisyacd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztygansapotokuyakuarihyouji = new ExDBFieldString<>("ztygansapotokuyakuarihyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztygnspshrhyj = new ExDBFieldString<>("ztygnspshrhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztygansaposeikyuuymd = new ExDBFieldString<>("ztygansaposeikyuuymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztygnspshrgenincd = new ExDBFieldString<>("ztygnspshrgenincd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytargetmokuhyouritu = new ExDBFieldString<>("ztytargetmokuhyouritu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyautoswitchmokuhyouritu = new ExDBFieldString<>("ztyautoswitchmokuhyouritu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytumitatekinitenarihyj = new ExDBFieldString<>("ztytumitatekinitenarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytumitatekinitenkaisuu = new ExDBFieldString<>("ztytumitatekinitenkaisuu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrttekinendo = new ExDBFieldString<>("ztyknkuzusnzyrttekinendo", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrtx2 = new ExDBFieldString<>("ztyknkuzusnzyrtx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyknkuzusnzyrtx3 = new ExDBFieldString<>("ztyknkuzusnzyrtx3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysinkeiyakujiknkuzusnzyrt = new ExDBFieldString<>("ztysinkeiyakujiknkuzusnzyrt", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanjiknkuzusnzyrt = new ExDBFieldString<>("ztytenkanjiknkuzusnzyrt", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykykjivithukusuukykhyj = new ExDBFieldString<>("ztykykjivithukusuukykhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin9x2 = new ExDBFieldString<>("ztysuuriyouyobin9x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x7 = new ExDBFieldString<>("ztysuuriyouyobin10x7", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x8 = new ExDBFieldString<>("ztysuuriyouyobin10x8", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x9 = new ExDBFieldString<>("ztysuuriyouyobin10x9", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytumitatekinitenbubun = new ExDBFieldNumber<>("ztytumitatekinitenbubun", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysagakusknnjynbknzndk = new ExDBFieldNumber<>("ztysagakusknnjynbknzndk", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x10 = new ExDBFieldNumber<>("ztyyobin11x10", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x11 = new ExDBFieldNumber<>("ztyyobin11x11", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x12 = new ExDBFieldNumber<>("ztyyobin11x12", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x13 = new ExDBFieldNumber<>("ztyyobin11x13", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x14 = new ExDBFieldNumber<>("ztyyobin11x14", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x15 = new ExDBFieldNumber<>("ztyyobin11x15", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x16 = new ExDBFieldNumber<>("ztyyobin11x16", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x17 = new ExDBFieldNumber<>("ztyyobin11x17", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx2 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx3 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx4 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzyrthntiyustatuskbnx5 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv15x2 = new ExDBFieldString<>("ztyyobiv15x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv15x3 = new ExDBFieldString<>("ztyyobiv15x3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv15x4 = new ExDBFieldString<>("ztyyobiv15x4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztykawaserate1 = new ExDBFieldString<>("ztykawaserate1", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykawaseratetekiyouymd1 = new ExDBFieldString<>("ztykawaseratetekiyouymd1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztykawaserate2 = new ExDBFieldString<>("ztykawaserate2", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykawaseratetekiyouymd2 = new ExDBFieldString<>("ztykawaseratetekiyouymd2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztykaiyakukoujyoritu = new ExDBFieldString<>("ztykaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztymvakeisankijyunymd = new ExDBFieldString<>("ztymvakeisankijyunymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyenkdtsbujsitihsyucost = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyucost", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyenkdtsbujsitihsyuarihyj = new ExDBFieldString<>("ztyenkdtsbujsitihsyuarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykaigomaebaraitkykarihyj = new ExDBFieldString<>("ztykaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysiharaituukakbn = new ExDBFieldString<>("ztysiharaituukakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztywyendttargetmokuhyouritu = new ExDBFieldString<>("ztywyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyteirituikouhyouji = new ExDBFieldString<>("ztyteirituikouhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin10x11 = new ExDBFieldString<>("ztysuuriyouyobin10x11", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztytykzenoutouymdsisuu = new ExDBFieldString<>("ztytykzenoutouymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztykimatusisuu = new ExDBFieldString<>("ztykimatusisuu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyenkadatekihons = new ExDBFieldNumber<>("ztyyenkadatekihons", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysitihsyumegkdtsibous = new ExDBFieldNumber<>("ztysitihsyumegkdtsibous", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyenkdtssrentumitatekin = new ExDBFieldNumber<>("ztyenkdtssrentumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztynksjitirttumitatekin = new ExDBFieldNumber<>("ztynksjitirttumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykimatutirttumitatekin = new ExDBFieldNumber<>("ztykimatutirttumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygaikadatejyuutoup = new ExDBFieldNumber<>("ztygaikadatejyuutoup", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyendttargetkijyunkingaku = new ExDBFieldNumber<>("ztyyendttargetkijyunkingaku", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysitivkisnyukykjikwsrate = new ExDBFieldString<>("ztysitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysisuurentyokugotmttkn = new ExDBFieldNumber<>("ztysisuurentyokugotmttkn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyyoteiririturironbase = new ExDBFieldString<>("ztyyoteiririturironbase", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyyoteiriritujtnyknbase = new ExDBFieldString<>("ztyyoteiriritujtnyknbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykihrkmpjtnyknbase = new ExDBFieldNumber<>("ztykihrkmpjtnyknbase", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysyuptumitatekingsc = new ExDBFieldNumber<>("ztysyuptumitatekingsc", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyjikaipjyuutouym2 = new ExDBFieldString<>("ztyjikaipjyuutouym2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Integer> ztysuuriyobin9 = new ExDBFieldNumber<>("ztysuuriyobin9", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygessitumitatekin = new ExDBFieldNumber<>("ztygessitumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygaikadatetougetujuutoup = new ExDBFieldNumber<>("ztygaikadatetougetujuutoup", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykihrkmpmsukisymbase = new ExDBFieldNumber<>("ztykihrkmpmsukisymbase", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykeisanhanteiyoutmttkn = new ExDBFieldNumber<>("ztykeisanhanteiyoutmttkn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygtmtv = new ExDBFieldNumber<>("ztygtmtv", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyzettaisibouritu = new ExDBFieldString<>("ztyzettaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysoutaisibouritu = new ExDBFieldString<>("ztysoutaisibouritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysoutaikaiyakuritu = new ExDBFieldString<>("ztysoutaikaiyakuritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyvhireilritu2 = new ExDBFieldString<>("ztyvhireilritu2", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyphireialpha = new ExDBFieldString<>("ztyphireialpha", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyphireibeta = new ExDBFieldString<>("ztyphireibeta", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyphireiganma = new ExDBFieldString<>("ztyphireiganma", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyphireilwrbkritu = new ExDBFieldString<>("ztyphireilwrbkritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyyoteiriritumsukisymbase = new ExDBFieldString<>("ztyyoteiriritumsukisymbase", this, BizNumberType.class);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu1 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu2 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu3 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkisovkisnyu4 = new ExDBFieldNumber<>("ztyrrthnduhknvkisovkisnyu4", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyrrthnduhknvkiso = new ExDBFieldNumber<>("ztyrrthnduhknvkiso", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykykkjmmvatyouseigow = new ExDBFieldNumber<>("ztykykkjmmvatyouseigow", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x39 = new ExDBFieldNumber<>("ztyyobin11x39", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x41 = new ExDBFieldNumber<>("ztyyobin11x41", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x42 = new ExDBFieldNumber<>("ztyyobin11x42", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x43 = new ExDBFieldNumber<>("ztyyobin11x43", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x44 = new ExDBFieldNumber<>("ztyyobin11x44", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x45 = new ExDBFieldNumber<>("ztyyobin11x45", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x3 = new ExDBFieldString<>("ztysuuriyouyobin15x3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x4 = new ExDBFieldString<>("ztysuuriyouyobin15x4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x5 = new ExDBFieldString<>("ztysuuriyouyobin15x5", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin15x6 = new ExDBFieldString<>("ztysuuriyouyobin15x6", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv14 = new ExDBFieldString<>("ztyyobiv14", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykyksyhhknsydouituhyouji = new ExDBFieldString<>("ztykyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykyksyaskinmeino = new ExDBFieldString<>("ztykyksyaskinmeino", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeikihons = new ExDBFieldNumber<>("ztygoukeikihons", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeigyousekihyjsibous = new ExDBFieldNumber<>("ztygoukeigyousekihyjsibous", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyalmyousibous = new ExDBFieldNumber<>("ztyalmyousibous", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysiteizukiharaikomip = new ExDBFieldNumber<>("ztysiteizukiharaikomip", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysaisyuusiteimhrkp = new ExDBFieldNumber<>("ztysaisyuusiteimhrkp", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeinenbaraikansanp = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztygyousekihyoujisrank = new ExDBFieldString<>("ztygyousekihyoujisrank", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztyteikibairitu = new ExDBFieldString<>("ztyteikibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkangodatakanrino = new ExDBFieldString<>("ztytenkangodatakanrino", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaitekykdatakanrino1 = new ExDBFieldString<>("ztyaitekykdatakanrino1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaitekykdatakanrino2 = new ExDBFieldString<>("ztyaitekykdatakanrino2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknsyokaipcashlesshyj = new ExDBFieldString<>("ztytnknsyokaipcashlesshyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyokaipannaikbn = new ExDBFieldString<>("ztysyokaipannaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzennoukaisiymd = new ExDBFieldString<>("ztyzennoukaisiymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyzennoukikan = new ExDBFieldString<>("ztyzennoukikan", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyseizonkyuuhukinsiteiy = new ExDBFieldString<>("ztyseizonkyuuhukinsiteiy", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyalmyouseizonkyhknsiteimd = new ExDBFieldString<>("ztyalmyouseizonkyhknsiteimd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x1 = new ExDBFieldString<>("ztyhktgtikkikkkn3x1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x2 = new ExDBFieldString<>("ztyhktgtikkikkkn3x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x3 = new ExDBFieldString<>("ztyhktgtikkikkkn3x3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkkn3x4 = new ExDBFieldString<>("ztyhktgtikkikkkn3x4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx1 = new ExDBFieldString<>("ztykappadkeisankbnx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx2 = new ExDBFieldString<>("ztykappadkeisankbnx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx3 = new ExDBFieldString<>("ztykappadkeisankbnx3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykappadkeisankbnx4 = new ExDBFieldString<>("ztykappadkeisankbnx4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv6x3 = new ExDBFieldString<>("ztyyobiv6x3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykimatuvyoutumimasikin = new ExDBFieldNumber<>("ztykimatuvyoutumimasikin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykmtvyusnhknfundtmttkin = new ExDBFieldNumber<>("ztykmtvyusnhknfundtmttkin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x1 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x2 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x3 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeinenkansanp3x4 = new ExDBFieldNumber<>("ztygoukeinenkansanp3x4", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykmtvyuhijynbritmttkin = new ExDBFieldNumber<>("ztykmtvyuhijynbritmttkin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykimatuvyouitjbrtmttkin = new ExDBFieldNumber<>("ztykimatuvyouitjbrtmttkin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x26 = new ExDBFieldNumber<>("ztyyobin11x26", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x27 = new ExDBFieldNumber<>("ztyyobin11x27", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x28 = new ExDBFieldNumber<>("ztyyobin11x28", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x29 = new ExDBFieldNumber<>("ztyyobin11x29", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x30 = new ExDBFieldNumber<>("ztyyobin11x30", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x31 = new ExDBFieldNumber<>("ztyyobin11x31", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x32 = new ExDBFieldNumber<>("ztyyobin11x32", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x33 = new ExDBFieldNumber<>("ztyyobin11x33", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhaitouyouloadingkijyuns = new ExDBFieldNumber<>("ztyhaitouyouloadingkijyuns", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytouduketorihouhoukbn = new ExDBFieldString<>("ztytouduketorihouhoukbn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytumitated = new ExDBFieldNumber<>("ztytumitated", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykariwariated = new ExDBFieldNumber<>("ztykariwariated", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytyokuzensiharaikijitu = new ExDBFieldString<>("ztytyokuzensiharaikijitu", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytyokuzentuusanhanteis = new ExDBFieldNumber<>("ztytyokuzentuusanhanteis", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytyokugosiharaikijitu = new ExDBFieldString<>("ztytyokugosiharaikijitu", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytyokugotuusanhanteis = new ExDBFieldNumber<>("ztytyokugotuusanhanteis", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytyokugokyuuhutaisyous = new ExDBFieldNumber<>("ztytyokugokyuuhutaisyous", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytyokugocbkingaku = new ExDBFieldNumber<>("ztytyokugocbkingaku", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyokaisiharaikijitu = new ExDBFieldString<>("ztysyokaisiharaikijitu", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysyokaituusanhanteis = new ExDBFieldNumber<>("ztysyokaituusanhanteis", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztycbnayosetuusanhanteis = new ExDBFieldNumber<>("ztycbnayosetuusanhanteis", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhitenkankeiyakusuu = new ExDBFieldString<>("ztyhitenkankeiyakusuu", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztygoukeipbubuntenkanteikis = new ExDBFieldNumber<>("ztygoukeipbubuntenkanteikis", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysaidaihktgtikkikkkn = new ExDBFieldString<>("ztysaidaihktgtikkikkkn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysisyutnknhktgkujygk = new ExDBFieldNumber<>("ztysisyutnknhktgkujygk", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x34 = new ExDBFieldNumber<>("ztyyobin11x34", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx1 = new ExDBFieldString<>("ztyhtnknkykkykymdx1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx1 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux1 = new ExDBFieldString<>("ztytnknkaiykkujytksux1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx1 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix1 = new ExDBFieldString<>("ztytenkanteikihyoujix1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx1 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx1 = new ExDBFieldString<>("ztyhktgtikkikkknx1", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx2 = new ExDBFieldString<>("ztyhtnknkykkykymdx2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx2 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux2 = new ExDBFieldString<>("ztytnknkaiykkujytksux2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx2 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix2 = new ExDBFieldString<>("ztytenkanteikihyoujix2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx2 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx2 = new ExDBFieldString<>("ztyhktgtikkikkknx2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx3 = new ExDBFieldString<>("ztyhtnknkykkykymdx3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx3 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux3 = new ExDBFieldString<>("ztytnknkaiykkujytksux3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx3 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix3 = new ExDBFieldString<>("ztytenkanteikihyoujix3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx3 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx3 = new ExDBFieldString<>("ztyhktgtikkikkknx3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhtnknkykkykymdx4 = new ExDBFieldString<>("ztyhtnknkykkykymdx4", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnkntkbtdkisnyusx4 = new ExDBFieldNumber<>("ztytnkntkbtdkisnyusx4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytnknkaiykkujytksux4 = new ExDBFieldString<>("ztytnknkaiykkujytksux4", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytnknkaiykkujygkx4 = new ExDBFieldNumber<>("ztytnknkaiykkujygkx4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikihyoujix4 = new ExDBFieldString<>("ztytenkanteikihyoujix4", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyhtnknkyknenknsnpx4 = new ExDBFieldNumber<>("ztyhtnknkyknenknsnpx4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhktgtikkikkknx4 = new ExDBFieldString<>("ztyhktgtikkikkknx4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysknjyututkykkykkbn = new ExDBFieldString<>("ztysknjyututkykkykkbn", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyswingminyuuphrkekngk = new ExDBFieldNumber<>("ztyswingminyuuphrkekngk", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyswingminyuuphrkejyutuym = new ExDBFieldString<>("ztyswingminyuuphrkejyutuym", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztydftounendoitijitounyuup = new ExDBFieldNumber<>("ztydftounendoitijitounyuup", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztydfkaiyakukujyhktggk = new ExDBFieldNumber<>("ztydfkaiyakukujyhktggk", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykaiyakukoujyotukisuu = new ExDBFieldString<>("ztykaiyakukoujyotukisuu", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztydfkaiyakuhenreikin = new ExDBFieldNumber<>("ztydfkaiyakuhenreikin", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztysyuuseis = new ExDBFieldNumber<>("ztysyuuseis", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaatukaisyakeisyousisyacd = new ExDBFieldString<>("ztyaatukaisyakeisyousisyacd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaatukaisyazaisekihyouji = new ExDBFieldString<>("ztyaatukaisyazaisekihyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaatukaisyabosyuujiage = new ExDBFieldString<>("ztyaatukaisyabosyuujiage", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaatukaisyabsyjisikakucd = new ExDBFieldString<>("ztyaatukaisyabsyjisikakucd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyaatukaisyasikakucd = new ExDBFieldString<>("ztyaatukaisyasikakucd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyokyksmkuztrhkkitikbn = new ExDBFieldString<>("ztyokyksmkuztrhkkitikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhoyuusisyacd = new ExDBFieldString<>("ztyhoyuusisyacd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyokansisyacd = new ExDBFieldString<>("ztysyokansisyacd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytantousyakbn = new ExDBFieldString<>("ztytantousyakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytantousyakbnnew = new ExDBFieldString<>("ztytantousyakbnnew", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyclubsumiseikbn = new ExDBFieldString<>("ztyclubsumiseikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyfollowtantousyakbn = new ExDBFieldString<>("ztyfollowtantousyakbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytantousyajyoutaikbn = new ExDBFieldString<>("ztytantousyajyoutaikbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykihonyoteii = new ExDBFieldString<>("ztykihonyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyteikiyoteii = new ExDBFieldString<>("ztyteikiyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysonotayoteii = new ExDBFieldString<>("ztysonotayoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyitijibaraikihonyoteii = new ExDBFieldString<>("ztyitijibaraikihonyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyitijibaraiteikiyoteii = new ExDBFieldString<>("ztyitijibaraiteikiyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyitijibaraisonotayoteii = new ExDBFieldString<>("ztyitijibaraisonotayoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkankihonyoteii = new ExDBFieldString<>("ztytenkankihonyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytenkanteikiyoteii = new ExDBFieldString<>("ztytenkanteikiyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyszouyoteii = new ExDBFieldString<>("ztyszouyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyvestingyoteii = new ExDBFieldString<>("ztyvestingyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysippeitokuyakuyoteii = new ExDBFieldString<>("ztysippeitokuyakuyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyseijinbyoutokuyakuyoteii = new ExDBFieldString<>("ztyseijinbyoutokuyakuyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyjyoseitokuyakuyoteii = new ExDBFieldString<>("ztyjyoseitokuyakuyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytuuintokuyakuyoteii = new ExDBFieldString<>("ztytuuintokuyakuyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysaiteihosyoui = new ExDBFieldString<>("ztysaiteihosyoui", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyvkisoitjbrkhnyoteii = new ExDBFieldString<>("ztyvkisoitjbrkhnyoteii", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyvkisorrtzeroikahyouji = new ExDBFieldString<>("ztyvkisorrtzeroikahyouji", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin3x2 = new ExDBFieldString<>("ztysuuriyouyobin3x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhoyuusisyacd2 = new ExDBFieldString<>("ztyhoyuusisyacd2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztydftujyukujykisnkisiym = new ExDBFieldString<>("ztydftujyukujykisnkisiym", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytikikktbrijyututksu = new ExDBFieldString<>("ztytikikktbrijyututksu", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysyunyumrtikykjtigngtkbn = new ExDBFieldString<>("ztysyunyumrtikykjtigngtkbn", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyhhkdrtkykarihyj = new ExDBFieldString<>("ztyhhkdrtkykarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztyyobiv10x14 = new ExDBFieldString<>("ztyyobiv10x14", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx1 = new ExDBFieldNumber<>("ztykappadhktgkujygkx1", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx2 = new ExDBFieldNumber<>("ztykappadhktgkujygkx2", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx3 = new ExDBFieldNumber<>("ztykappadhktgkujygkx3", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztykappadhktgkujygkx4 = new ExDBFieldNumber<>("ztykappadhktgkujygkx4", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztytrkzsgkaiykkjynstmtkzndk = new ExDBFieldNumber<>("ztytrkzsgkaiykkjynstmtkzndk", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztypmenkouryokuhasseiymd = new ExDBFieldString<>("ztypmenkouryokuhasseiymd", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin5 = new ExDBFieldString<>("ztysuuriyouyobin5", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysuuriyouyobin13 = new ExDBFieldString<>("ztysuuriyouyobin13", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x35 = new ExDBFieldNumber<>("ztyyobin11x35", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x36 = new ExDBFieldNumber<>("ztyyobin11x36", this);

    public final ExDBFieldNumber<ST_HoyuuMeisaiTyukeiyouItzHzn, Long> ztyyobin11x37 = new ExDBFieldNumber<>("ztyyobin11x37", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200 = new ExDBFieldString<>("ztytokuyakukoumokuv200", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x2 = new ExDBFieldString<>("ztytokuyakukoumokuv200x2", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x3 = new ExDBFieldString<>("ztytokuyakukoumokuv200x3", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x4 = new ExDBFieldString<>("ztytokuyakukoumokuv200x4", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x5 = new ExDBFieldString<>("ztytokuyakukoumokuv200x5", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x6 = new ExDBFieldString<>("ztytokuyakukoumokuv200x6", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x7 = new ExDBFieldString<>("ztytokuyakukoumokuv200x7", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x8 = new ExDBFieldString<>("ztytokuyakukoumokuv200x8", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x9 = new ExDBFieldString<>("ztytokuyakukoumokuv200x9", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x10 = new ExDBFieldString<>("ztytokuyakukoumokuv200x10", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x11 = new ExDBFieldString<>("ztytokuyakukoumokuv200x11", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x12 = new ExDBFieldString<>("ztytokuyakukoumokuv200x12", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x13 = new ExDBFieldString<>("ztytokuyakukoumokuv200x13", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x14 = new ExDBFieldString<>("ztytokuyakukoumokuv200x14", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x15 = new ExDBFieldString<>("ztytokuyakukoumokuv200x15", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x16 = new ExDBFieldString<>("ztytokuyakukoumokuv200x16", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x17 = new ExDBFieldString<>("ztytokuyakukoumokuv200x17", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x18 = new ExDBFieldString<>("ztytokuyakukoumokuv200x18", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x19 = new ExDBFieldString<>("ztytokuyakukoumokuv200x19", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x20 = new ExDBFieldString<>("ztytokuyakukoumokuv200x20", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x21 = new ExDBFieldString<>("ztytokuyakukoumokuv200x21", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x22 = new ExDBFieldString<>("ztytokuyakukoumokuv200x22", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x23 = new ExDBFieldString<>("ztytokuyakukoumokuv200x23", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x24 = new ExDBFieldString<>("ztytokuyakukoumokuv200x24", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x25 = new ExDBFieldString<>("ztytokuyakukoumokuv200x25", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x26 = new ExDBFieldString<>("ztytokuyakukoumokuv200x26", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x27 = new ExDBFieldString<>("ztytokuyakukoumokuv200x27", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x28 = new ExDBFieldString<>("ztytokuyakukoumokuv200x28", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x29 = new ExDBFieldString<>("ztytokuyakukoumokuv200x29", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x30 = new ExDBFieldString<>("ztytokuyakukoumokuv200x30", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x31 = new ExDBFieldString<>("ztytokuyakukoumokuv200x31", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x32 = new ExDBFieldString<>("ztytokuyakukoumokuv200x32", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x33 = new ExDBFieldString<>("ztytokuyakukoumokuv200x33", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x34 = new ExDBFieldString<>("ztytokuyakukoumokuv200x34", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x35 = new ExDBFieldString<>("ztytokuyakukoumokuv200x35", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x36 = new ExDBFieldString<>("ztytokuyakukoumokuv200x36", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x37 = new ExDBFieldString<>("ztytokuyakukoumokuv200x37", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x38 = new ExDBFieldString<>("ztytokuyakukoumokuv200x38", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x39 = new ExDBFieldString<>("ztytokuyakukoumokuv200x39", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztytokuyakukoumokuv200x40 = new ExDBFieldString<>("ztytokuyakukoumokuv200x40", this);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, BizNumber> ztysrkaiyakukoujyoritu = new ExDBFieldString<>("ztysrkaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_HoyuuMeisaiTyukeiyouItzHzn, String> ztysrteikishrtkykhukaumu = new ExDBFieldString<>("ztysrteikishrtkykhukaumu", this);
}
