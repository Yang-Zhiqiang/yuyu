package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 死亡率統計整備後連動Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SbRituToukeiSeibiRenTy extends AbstractExDBTable<ZT_SbRituToukeiSeibiRenTy> {

    public GenQZT_SbRituToukeiSeibiRenTy() {
        this("ZT_SbRituToukeiSeibiRenTy");
    }

    public GenQZT_SbRituToukeiSeibiRenTy(String pAlias) {
        super("ZT_SbRituToukeiSeibiRenTy", ZT_SbRituToukeiSeibiRenTy.class, pAlias);
    }

    public String ZT_SbRituToukeiSeibiRenTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyyobiv12 = new ExDBFieldString<>("ztyyobiv12", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyorikbn = new ExDBFieldString<>("ztysyorikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyoriymd = new ExDBFieldString<>("ztysyoriymd", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykykmfksnctr = new ExDBFieldNumber<>("ztykykmfksnctr", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyorino = new ExDBFieldString<>("ztysyorino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyukgu = new ExDBFieldString<>("ztysyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykykym = new ExDBFieldString<>("ztykykym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytokujyouhyouji = new ExDBFieldString<>("ztytokujyouhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyviphyouji = new ExDBFieldString<>("ztyviphyouji", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykisnkihons = new ExDBFieldNumber<>("ztykisnkihons", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykeisansibous = new ExDBFieldNumber<>("ztykeisansibous", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztyshrs = new ExDBFieldNumber<>("ztyshrs", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyshrymd = new ExDBFieldString<>("ztyshrymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysiharaisisyacd = new ExDBFieldString<>("ztysiharaisisyacd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysymtgenincd = new ExDBFieldString<>("ztysymtgenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykeikaym = new ExDBFieldString<>("ztykeikaym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysbugenincd = new ExDBFieldString<>("ztysbugenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydai2tokujyouhyouji = new ExDBFieldString<>("ztydai2tokujyouhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytignmrtisyukgu = new ExDBFieldString<>("ztytignmrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyteigenmaruteikikan = new ExDBFieldString<>("ztyteigenmaruteikikan", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztygoukeiteigenbubuns = new ExDBFieldNumber<>("ztygoukeiteigenbubuns", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyrenseimrtisyukgu = new ExDBFieldString<>("ztyrenseimrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztylivingneedsshrarihyj = new ExDBFieldString<>("ztylivingneedsshrarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztylnkeikaym = new ExDBFieldString<>("ztylnkeikaym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztylnshrgenincd = new ExDBFieldString<>("ztylnshrgenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykituenhonsuu = new ExDBFieldString<>("ztykituenhonsuu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydugktnknsntkhuhukbn = new ExDBFieldString<>("ztydugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykykjitokujyouarihyj = new ExDBFieldString<>("ztykykjitokujyouarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytokuyakukousinkbn = new ExDBFieldString<>("ztytokuyakukousinkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyteigenmaruteikisiym = new ExDBFieldString<>("ztyteigenmaruteikisiym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyunyumrtisyukgu = new ExDBFieldString<>("ztysyunyumrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyuunyuumaruteikikan = new ExDBFieldString<>("ztysyuunyuumaruteikikan", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztysyuunyuumrtinknengkn7 = new ExDBFieldNumber<>("ztysyuunyuumrtinknengkn7", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyuunyuumaruteikisiym = new ExDBFieldString<>("ztysyuunyuumaruteikisiym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysysnymd = new ExDBFieldString<>("ztysysnymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysindanymd = new ExDBFieldString<>("ztysindanymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybyoumeicd1 = new ExDBFieldString<>("ztybyoumeicd1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybyoumeicd2 = new ExDBFieldString<>("ztybyoumeicd2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyshrnaiyoukbn = new ExDBFieldString<>("ztyshrnaiyoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztygituyuknkbn1 = new ExDBFieldString<>("ztygituyuknkbn1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztygituyuknkbn2 = new ExDBFieldString<>("ztygituyuknkbn2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyeiebnri1 = new ExDBFieldString<>("ztysyeiebnri1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyeiebnri2 = new ExDBFieldString<>("ztysyeiebnri2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyminnesotacd1 = new ExDBFieldString<>("ztyminnesotacd1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyminnesotacd2 = new ExDBFieldString<>("ztyminnesotacd2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyminnesotacd3 = new ExDBFieldString<>("ztyminnesotacd3", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyminnesotacd4 = new ExDBFieldString<>("ztyminnesotacd4", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyminnesotacd5 = new ExDBFieldString<>("ztyminnesotacd5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztymnsisiensindanjiyuu = new ExDBFieldString<>("ztymnsisiensindanjiyuu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyknkuhnsindanjiyuu = new ExDBFieldString<>("ztyknkuhnsindanjiyuu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhushrkbn = new ExDBFieldString<>("ztyhushrkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhushrym = new ExDBFieldString<>("ztyhushrym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyuunyuumrtinkshrkkn = new ExDBFieldString<>("ztysyuunyuumrtinkshrkkn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytokujyousakugenkikan = new ExDBFieldString<>("ztytokujyousakugenkikan", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyharaikomihouhou = new ExDBFieldString<>("ztyharaikomihouhou", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysinsahouhou = new ExDBFieldString<>("ztysinsahouhou", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykykniyutksytioukbn = new ExDBFieldString<>("ztykykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyrnduyuryumshyutn = new ExDBFieldString<>("ztyrnduyuryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhutanpobui1 = new ExDBFieldString<>("ztyhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhtnpkkn1 = new ExDBFieldString<>("ztyhtnpkkn1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhutanpobui2 = new ExDBFieldString<>("ztyhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhtnpkkn2 = new ExDBFieldString<>("ztyhtnpkkn2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhukasyuksyu = new ExDBFieldString<>("ztyhukasyuksyu", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyoutokuyakukbn = new ExDBFieldString<>("ztysuuriyoutokuyakukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytokuyakuno = new ExDBFieldString<>("ztytokuyakuno", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykusnmetkyksykipjyutuym = new ExDBFieldString<>("ztykusnmetkyksykipjyutuym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysykikjgykbn = new ExDBFieldString<>("ztysykikjgykbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykaijyokbn = new ExDBFieldString<>("ztykaijyokbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyuruihenkouarihyouji = new ExDBFieldString<>("ztysyuruihenkouarihyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydai2hihokensyasonzokuhyj = new ExDBFieldString<>("ztydai2hihokensyasonzokuhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyukeiyakukigou = new ExDBFieldString<>("ztysyukeiyakukigou", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysymtymd = new ExDBFieldString<>("ztysymtymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytyuutohukatkhyj = new ExDBFieldString<>("ztytyuutohukatkhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyyoukigjyutigituymd = new ExDBFieldString<>("ztyyoukigjyutigituymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyyoukigjyutigeninkbn = new ExDBFieldString<>("ztyyoukigjyutigeninkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysykmtssyukahikbn = new ExDBFieldString<>("ztysykmtssyukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyfktrsmtkahikbn = new ExDBFieldString<>("ztyfktrsmtkahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhokoukahikbn = new ExDBFieldString<>("ztyhokoukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztynyykkahikbn = new ExDBFieldString<>("ztynyykkahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyihukutyakudatukahikbn = new ExDBFieldString<>("ztyihukutyakudatukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytihougeninkbn = new ExDBFieldString<>("ztytihougeninkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyukgusdkbn = new ExDBFieldString<>("ztysyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytignmrtisyukgusdkbn = new ExDBFieldString<>("ztytignmrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyrenseimrtisyukgusdkbn = new ExDBFieldString<>("ztyrenseimrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyunyumrtisyukgusdkbn = new ExDBFieldString<>("ztysyunyumrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysykyksyuruikgusdkbn = new ExDBFieldString<>("ztysykyksyuruikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypmenjikohasseiymd = new ExDBFieldString<>("ztypmenjikohasseiymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybosyuukeirokbn = new ExDBFieldString<>("ztybosyuukeirokbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyorinov2 = new ExDBFieldString<>("ztysyorinov2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykigkyhsitihsyutkykhyj = new ExDBFieldString<>("ztykigkyhsitihsyutkykhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypmenhutanpobui1 = new ExDBFieldString<>("ztypmenhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypmenhutanpokikan1 = new ExDBFieldString<>("ztypmenhutanpokikan1", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypmenhutanpobui2 = new ExDBFieldString<>("ztypmenhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypmenhutanpokikan2 = new ExDBFieldString<>("ztypmenhutanpokikan2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykanyujidatakanrino = new ExDBFieldString<>("ztykanyujidatakanrino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybnktgsnzkkykdatakanrino = new ExDBFieldString<>("ztybnktgsnzkkykdatakanrino", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybnkttnknkbn = new ExDBFieldString<>("ztybnkttnknkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybnktjisisttkarihyj = new ExDBFieldString<>("ztybnktjisisttkarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztycareneedssiharaihyouji = new ExDBFieldString<>("ztycareneedssiharaihyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztybnktjitiktkarihyj = new ExDBFieldString<>("ztybnktjitiktkarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyksnym = new ExDBFieldString<>("ztyksnym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyijitoukeiyuksnhyj = new ExDBFieldString<>("ztyijitoukeiyuksnhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyikoujisnskbn = new ExDBFieldString<>("ztyikoujisnskbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin1 = new ExDBFieldString<>("ztysuuriyouyobin1", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztyimustiyusbus = new ExDBFieldNumber<>("ztyimustiyusbus", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykeisansykykbbnkhns = new ExDBFieldNumber<>("ztykeisansykykbbnkhns", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyoubosyuukeitaikbn = new ExDBFieldString<>("ztysuuriyoubosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysysnikoujiym = new ExDBFieldString<>("ztysysnikoujiym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztygnspshrhyj = new ExDBFieldString<>("ztygnspshrhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztygnspshrkeikaym = new ExDBFieldString<>("ztygnspshrkeikaym", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztygnspshrgenincd = new ExDBFieldString<>("ztygnspshrgenincd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyngerkahikbn = new ExDBFieldString<>("ztyngerkahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyhokenhoutekiyouhyouji = new ExDBFieldString<>("ztyhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykeisansyukeiyakup = new ExDBFieldNumber<>("ztykeisansyukeiyakup", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykeisangoukeitenkans = new ExDBFieldNumber<>("ztykeisangoukeitenkans", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykeisangoukeitenkankakaku = new ExDBFieldNumber<>("ztykeisangoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztykisnwnsgukitnknkakaku = new ExDBFieldNumber<>("ztykisnwnsgukitnknkakaku", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, BizNumber> ztytnknkhnbbnjyuturt = new ExDBFieldString<>("ztytnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyharaizumiymd = new ExDBFieldString<>("ztyharaizumiymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztystdsstkjytkyuhyj = new ExDBFieldString<>("ztystdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, BizNumber> ztykeisanyoteiriritu = new ExDBFieldString<>("ztykeisanyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyseiketuseiyoukahikbn = new ExDBFieldString<>("ztyseiketuseiyoukahikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyuurouhunoukgjyoutaikbn = new ExDBFieldString<>("ztysyuurouhunoukgjyoutaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysyuurouhunoujyoutaikbn = new ExDBFieldString<>("ztysyuurouhunoujyoutaikbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysiznkyhsyoubyouhasseiymd = new ExDBFieldString<>("ztysiznkyhsyoubyouhasseiymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykyusisnknkuskgitukbn = new ExDBFieldString<>("ztykyusisnknkuskgitukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztynousottyuugaitoukbn = new ExDBFieldString<>("ztynousottyuugaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyjinhuzengaitoukbn = new ExDBFieldString<>("ztyjinhuzengaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydoumyakusikkangaitoukbn = new ExDBFieldString<>("ztydoumyakusikkangaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyknkuzusnzyrtsiyounendo = new ExDBFieldString<>("ztyknkuzusnzyrtsiyounendo", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyvittkykkaiyakuymd = new ExDBFieldString<>("ztyvittkykkaiyakuymd", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztynintisyougeninkbn = new ExDBFieldString<>("ztynintisyougeninkbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x3 = new ExDBFieldString<>("ztysuuriyouyobin8x3", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x4 = new ExDBFieldString<>("ztysuuriyouyobin8x4", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x5 = new ExDBFieldString<>("ztysuuriyouyobin8x5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x6 = new ExDBFieldString<>("ztysuuriyouyobin8x6", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x7 = new ExDBFieldString<>("ztysuuriyouyobin8x7", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x8 = new ExDBFieldString<>("ztysuuriyouyobin8x8", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x9 = new ExDBFieldString<>("ztysuuriyouyobin8x9", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8x10 = new ExDBFieldString<>("ztysuuriyouyobin8x10", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztyyobin7 = new ExDBFieldNumber<>("ztyyobin7", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztyyobin7x2 = new ExDBFieldNumber<>("ztyyobin7x2", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztyyobin7x3 = new ExDBFieldNumber<>("ztyyobin7x3", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztyyobin7x4 = new ExDBFieldNumber<>("ztyyobin7x4", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Integer> ztyyobin7x5 = new ExDBFieldNumber<>("ztyyobin7x5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyyobiv59 = new ExDBFieldString<>("ztyyobiv59", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztygaikadatekihons = new ExDBFieldNumber<>("ztygaikadatekihons", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztygaikadatesibous = new ExDBFieldNumber<>("ztygaikadatesibous", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_SbRituToukeiSeibiRenTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldString<ZT_SbRituToukeiSeibiRenTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);
}
