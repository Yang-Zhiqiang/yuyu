package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 死亡率統計整備後連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SbRituToukeiSeibiRenRn extends AbstractExDBTable<ZT_SbRituToukeiSeibiRenRn> {

    public GenQZT_SbRituToukeiSeibiRenRn() {
        this("ZT_SbRituToukeiSeibiRenRn");
    }

    public GenQZT_SbRituToukeiSeibiRenRn(String pAlias) {
        super("ZT_SbRituToukeiSeibiRenRn", ZT_SbRituToukeiSeibiRenRn.class, pAlias);
    }

    public String ZT_SbRituToukeiSeibiRenRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnyobiv12 = new ExDBFieldString<>("zrnyobiv12", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyorikbn = new ExDBFieldString<>("zrnsyorikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyoriymd = new ExDBFieldString<>("zrnsyoriymd", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkykmfksnctr = new ExDBFieldNumber<>("zrnkykmfksnctr", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyorino = new ExDBFieldString<>("zrnsyorino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyukgu = new ExDBFieldString<>("zrnsyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkykym = new ExDBFieldString<>("zrnkykym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntokujyouhyouji = new ExDBFieldString<>("zrntokujyouhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnviphyouji = new ExDBFieldString<>("zrnviphyouji", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkisnkihons = new ExDBFieldNumber<>("zrnkisnkihons", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkeisansibous = new ExDBFieldNumber<>("zrnkeisansibous", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnshrs = new ExDBFieldNumber<>("zrnshrs", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnshrymd = new ExDBFieldString<>("zrnshrymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsiharaisisyacd = new ExDBFieldString<>("zrnsiharaisisyacd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsymtgenincd = new ExDBFieldString<>("zrnsymtgenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkeikaym = new ExDBFieldString<>("zrnkeikaym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsbugenincd = new ExDBFieldString<>("zrnsbugenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndai2tokujyouhyouji = new ExDBFieldString<>("zrndai2tokujyouhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntignmrtisyukgu = new ExDBFieldString<>("zrntignmrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnteigenmaruteikikan = new ExDBFieldString<>("zrnteigenmaruteikikan", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrngoukeiteigenbubuns = new ExDBFieldNumber<>("zrngoukeiteigenbubuns", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnrenseimrtisyukgu = new ExDBFieldString<>("zrnrenseimrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnlivingneedsshrarihyj = new ExDBFieldString<>("zrnlivingneedsshrarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnlnkeikaym = new ExDBFieldString<>("zrnlnkeikaym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnlnshrgenincd = new ExDBFieldString<>("zrnlnshrgenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndugktnknsntkhuhukbn = new ExDBFieldString<>("zrndugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkykjitokujyouarihyj = new ExDBFieldString<>("zrnkykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntokuyakukousinkbn = new ExDBFieldString<>("zrntokuyakukousinkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnteigenmaruteikisiym = new ExDBFieldString<>("zrnteigenmaruteikisiym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyunyumrtisyukgu = new ExDBFieldString<>("zrnsyunyumrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyuunyuumaruteikikan = new ExDBFieldString<>("zrnsyuunyuumaruteikikan", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnsyuunyuumrtinknengkn7 = new ExDBFieldNumber<>("zrnsyuunyuumrtinknengkn7", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyuunyuumaruteikisiym = new ExDBFieldString<>("zrnsyuunyuumaruteikisiym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsysnymd = new ExDBFieldString<>("zrnsysnymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsindanymd = new ExDBFieldString<>("zrnsindanymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbyoumeicd1 = new ExDBFieldString<>("zrnbyoumeicd1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbyoumeicd2 = new ExDBFieldString<>("zrnbyoumeicd2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnshrnaiyoukbn = new ExDBFieldString<>("zrnshrnaiyoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrngituyuknkbn1 = new ExDBFieldString<>("zrngituyuknkbn1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrngituyuknkbn2 = new ExDBFieldString<>("zrngituyuknkbn2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyeiebnri1 = new ExDBFieldString<>("zrnsyeiebnri1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyeiebnri2 = new ExDBFieldString<>("zrnsyeiebnri2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnminnesotacd1 = new ExDBFieldString<>("zrnminnesotacd1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnminnesotacd2 = new ExDBFieldString<>("zrnminnesotacd2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnminnesotacd3 = new ExDBFieldString<>("zrnminnesotacd3", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnminnesotacd4 = new ExDBFieldString<>("zrnminnesotacd4", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnminnesotacd5 = new ExDBFieldString<>("zrnminnesotacd5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnmnsisiensindanjiyuu = new ExDBFieldString<>("zrnmnsisiensindanjiyuu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnknkuhnsindanjiyuu = new ExDBFieldString<>("zrnknkuhnsindanjiyuu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhushrkbn = new ExDBFieldString<>("zrnhushrkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhushrym = new ExDBFieldString<>("zrnhushrym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyuunyuumrtinkshrkkn = new ExDBFieldString<>("zrnsyuunyuumrtinkshrkkn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntokujyousakugenkikan = new ExDBFieldString<>("zrntokujyousakugenkikan", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnharaikomihouhou = new ExDBFieldString<>("zrnharaikomihouhou", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsinsahouhou = new ExDBFieldString<>("zrnsinsahouhou", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkykniyutksytioukbn = new ExDBFieldString<>("zrnkykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnrnduyuryumshyutn = new ExDBFieldString<>("zrnrnduyuryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhutanpobui1 = new ExDBFieldString<>("zrnhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhtnpkkn1 = new ExDBFieldString<>("zrnhtnpkkn1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhutanpobui2 = new ExDBFieldString<>("zrnhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhtnpkkn2 = new ExDBFieldString<>("zrnhtnpkkn2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhukasyuksyu = new ExDBFieldString<>("zrnhukasyuksyu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyoutokuyakukbn = new ExDBFieldString<>("zrnsuuriyoutokuyakukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntokuyakuno = new ExDBFieldString<>("zrntokuyakuno", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkusnmetkyksykipjyutuym = new ExDBFieldString<>("zrnkusnmetkyksykipjyutuym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsykikjgykbn = new ExDBFieldString<>("zrnsykikjgykbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntenkanminaosikbn = new ExDBFieldString<>("zrntenkanminaosikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkaijyokbn = new ExDBFieldString<>("zrnkaijyokbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyuruihenkouarihyouji = new ExDBFieldString<>("zrnsyuruihenkouarihyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndai2hihokensyasonzokuhyj = new ExDBFieldString<>("zrndai2hihokensyasonzokuhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyukeiyakukigou = new ExDBFieldString<>("zrnsyukeiyakukigou", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsymtymd = new ExDBFieldString<>("zrnsymtymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntyuutohukatkhyj = new ExDBFieldString<>("zrntyuutohukatkhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnyoukigjyutigituymd = new ExDBFieldString<>("zrnyoukigjyutigituymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnyoukigjyutigeninkbn = new ExDBFieldString<>("zrnyoukigjyutigeninkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsykmtssyukahikbn = new ExDBFieldString<>("zrnsykmtssyukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnfktrsmtkahikbn = new ExDBFieldString<>("zrnfktrsmtkahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhokoukahikbn = new ExDBFieldString<>("zrnhokoukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnnyykkahikbn = new ExDBFieldString<>("zrnnyykkahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnihukutyakudatukahikbn = new ExDBFieldString<>("zrnihukutyakudatukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntihougeninkbn = new ExDBFieldString<>("zrntihougeninkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyukgusdkbn = new ExDBFieldString<>("zrnsyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntignmrtisyukgusdkbn = new ExDBFieldString<>("zrntignmrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnrenseimrtisyukgusdkbn = new ExDBFieldString<>("zrnrenseimrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyunyumrtisyukgusdkbn = new ExDBFieldString<>("zrnsyunyumrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsykyksyuruikgusdkbn = new ExDBFieldString<>("zrnsykyksyuruikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpmenkbnv2 = new ExDBFieldString<>("zrnpmenkbnv2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpmenjikohasseiymd = new ExDBFieldString<>("zrnpmenjikohasseiymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbosyuukeirokbn = new ExDBFieldString<>("zrnbosyuukeirokbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyorinov2 = new ExDBFieldString<>("zrnsyorinov2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkigkyhsitihsyutkykhyj = new ExDBFieldString<>("zrnkigkyhsitihsyutkykhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpmenhutanpobui1 = new ExDBFieldString<>("zrnpmenhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpmenhutanpokikan1 = new ExDBFieldString<>("zrnpmenhutanpokikan1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpmenhutanpobui2 = new ExDBFieldString<>("zrnpmenhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpmenhutanpokikan2 = new ExDBFieldString<>("zrnpmenhutanpokikan2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkanyujidatakanrino = new ExDBFieldString<>("zrnkanyujidatakanrino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbnktgsnzkkykdatakanrino = new ExDBFieldString<>("zrnbnktgsnzkkykdatakanrino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbnktjisisttkarihyj = new ExDBFieldString<>("zrnbnktjisisttkarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrncareneedssiharaihyouji = new ExDBFieldString<>("zrncareneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnbnktjitiktkarihyj = new ExDBFieldString<>("zrnbnktjitiktkarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkousinkbn = new ExDBFieldString<>("zrnkousinkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnksnym = new ExDBFieldString<>("zrnksnym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnijitoukeiyuksnhyj = new ExDBFieldString<>("zrnijitoukeiyuksnhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnikoujisnskbn = new ExDBFieldString<>("zrnikoujisnskbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin1 = new ExDBFieldString<>("zrnsuuriyouyobin1", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnimustiyusbus = new ExDBFieldNumber<>("zrnimustiyusbus", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkeisansykykbbnkhns = new ExDBFieldNumber<>("zrnkeisansykykbbnkhns", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyoubosyuukeitaikbn = new ExDBFieldString<>("zrnsuuriyoubosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsysnikoujiym = new ExDBFieldString<>("zrnsysnikoujiym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrngnspshrhyj = new ExDBFieldString<>("zrngnspshrhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrngnspshrkeikaym = new ExDBFieldString<>("zrngnspshrkeikaym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrngnspshrgenincd = new ExDBFieldString<>("zrngnspshrgenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnngerkahikbn = new ExDBFieldString<>("zrnngerkahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnhokenhoutekiyouhyouji = new ExDBFieldString<>("zrnhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkeisansyukeiyakup = new ExDBFieldNumber<>("zrnkeisansyukeiyakup", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkeisangoukeitenkans = new ExDBFieldNumber<>("zrnkeisangoukeitenkans", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkeisangoukeitenkankakaku = new ExDBFieldNumber<>("zrnkeisangoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnkisnwnsgukitnknkakaku = new ExDBFieldNumber<>("zrnkisnwnsgukitnknkakaku", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, BizNumber> zrntnknkhnbbnjyuturt = new ExDBFieldString<>("zrntnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnharaizumiymd = new ExDBFieldString<>("zrnharaizumiymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, BizNumber> zrnkeisanyoteiriritu = new ExDBFieldString<>("zrnkeisanyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnseiketuseiyoukahikbn = new ExDBFieldString<>("zrnseiketuseiyoukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyuurouhunoukgjyoutaikbn = new ExDBFieldString<>("zrnsyuurouhunoukgjyoutaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsyuurouhunoujyoutaikbn = new ExDBFieldString<>("zrnsyuurouhunoujyoutaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsiznkyhsyoubyouhasseiymd = new ExDBFieldString<>("zrnsiznkyhsyoubyouhasseiymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkyusisnknkuskgitukbn = new ExDBFieldString<>("zrnkyusisnknkuskgitukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnnousottyuugaitoukbn = new ExDBFieldString<>("zrnnousottyuugaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnjinhuzengaitoukbn = new ExDBFieldString<>("zrnjinhuzengaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndoumyakusikkangaitoukbn = new ExDBFieldString<>("zrndoumyakusikkangaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndatakanrino2 = new ExDBFieldString<>("zrndatakanrino2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrndatakanrino3 = new ExDBFieldString<>("zrndatakanrino3", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsinkeiyakujivithkhyouji = new ExDBFieldString<>("zrnsinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnknkuzusnzyrtsiyounendo = new ExDBFieldString<>("zrnknkuzusnzyrtsiyounendo", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnvittkykkaiyakuymd = new ExDBFieldString<>("zrnvittkykkaiyakuymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnnintisyougeninkbn = new ExDBFieldString<>("zrnnintisyougeninkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin1x2 = new ExDBFieldString<>("zrnsuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x3 = new ExDBFieldString<>("zrnsuuriyouyobin8x3", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x4 = new ExDBFieldString<>("zrnsuuriyouyobin8x4", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x5 = new ExDBFieldString<>("zrnsuuriyouyobin8x5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x6 = new ExDBFieldString<>("zrnsuuriyouyobin8x6", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x7 = new ExDBFieldString<>("zrnsuuriyouyobin8x7", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x8 = new ExDBFieldString<>("zrnsuuriyouyobin8x8", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x9 = new ExDBFieldString<>("zrnsuuriyouyobin8x9", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8x10 = new ExDBFieldString<>("zrnsuuriyouyobin8x10", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnyobin7 = new ExDBFieldNumber<>("zrnyobin7", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnyobin7x2 = new ExDBFieldNumber<>("zrnyobin7x2", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnyobin7x3 = new ExDBFieldNumber<>("zrnyobin7x3", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnyobin7x4 = new ExDBFieldNumber<>("zrnyobin7x4", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Integer> zrnyobin7x5 = new ExDBFieldNumber<>("zrnyobin7x5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnyobiv59 = new ExDBFieldString<>("zrnyobiv59", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrngaikadatekihons = new ExDBFieldNumber<>("zrngaikadatekihons", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrngaikadatesibous = new ExDBFieldNumber<>("zrngaikadatesibous", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnsuuriyouyobin10x2 = new ExDBFieldString<>("zrnsuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);
}
