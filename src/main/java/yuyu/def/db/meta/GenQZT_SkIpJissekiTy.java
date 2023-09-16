package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SkIpJissekiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新契約インプット実績Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkIpJissekiTy extends AbstractExDBTable<ZT_SkIpJissekiTy> {

    public GenQZT_SkIpJissekiTy() {
        this("ZT_SkIpJissekiTy");
    }

    public GenQZT_SkIpJissekiTy(String pAlias) {
        super("ZT_SkIpJissekiTy", ZT_SkIpJissekiTy.class, pAlias);
    }

    public String ZT_SkIpJissekiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymosym = new ExDBFieldString<>("ztymosym", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyatukaikojincd = new ExDBFieldString<>("ztyatukaikojincd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztydairitenatkikeitaikbn = new ExDBFieldString<>("ztydairitenatkikeitaikbn", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Integer> ztyatkiwari3keta = new ExDBFieldNumber<>("ztyatkiwari3keta", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykjsakininisetteihyj = new ExDBFieldString<>("ztykjsakininisetteihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymosno = new ExDBFieldString<>("ztymosno", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykydatkikbn = new ExDBFieldString<>("ztykydatkikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymossyoumetukbn = new ExDBFieldString<>("ztymossyoumetukbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykykktaikbn = new ExDBFieldString<>("ztykykktaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztyrendouyouharaikomip = new ExDBFieldNumber<>("ztyrendouyouharaikomip", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyatukaisosikicd = new ExDBFieldString<>("ztyatukaisosikicd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztygyousekiyouhosyous = new ExDBFieldNumber<>("ztygyousekiyouhosyous", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztygoukeikihons = new ExDBFieldNumber<>("ztygoukeikihons", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymosnyuuryokuymd = new ExDBFieldString<>("ztymosnyuuryokuymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztysyokaipryosyuymd = new ExDBFieldString<>("ztysyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyfstpnyknsyoriymd = new ExDBFieldString<>("ztyfstpnyknsyoriymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykokutiymd = new ExDBFieldString<>("ztykokutiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymossyumtkktymd = new ExDBFieldString<>("ztymossyumtkktymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztysisyaketsyoriymd = new ExDBFieldString<>("ztysisyaketsyoriymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymossyosakuseiymd = new ExDBFieldString<>("ztymossyosakuseiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhhknsakuinmeino = new ExDBFieldString<>("ztyhhknsakuinmeino", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhaitousiharaikbn = new ExDBFieldString<>("ztyhaitousiharaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhubikbn = new ExDBFieldString<>("ztyhubikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztytsinkihontikucd = new ExDBFieldString<>("ztytsinkihontikucd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyseisekiym = new ExDBFieldString<>("ztyseisekiym", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztytokusyujimutoriatukaikbn = new ExDBFieldString<>("ztytokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykyksyaskinmeino = new ExDBFieldString<>("ztykyksyaskinmeino", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymossakuseino = new ExDBFieldString<>("ztymossakuseino", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x11 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x12 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x13 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x14 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi1x15 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi2x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhokensyuruikigouyobi3x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztynstkarihyj = new ExDBFieldString<>("ztynstkarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztydai1kyktdkkbn = new ExDBFieldString<>("ztydai1kyktdkkbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztymossyouninymd = new ExDBFieldString<>("ztymossyouninymd", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztynenkansanp = new ExDBFieldNumber<>("ztynenkansanp", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztynksyuruikbn1 = new ExDBFieldString<>("ztynksyuruikbn1", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhensyuukeiyakusyamei = new ExDBFieldString<>("ztyhensyuukeiyakusyamei", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykanjitsinkaiadr = new ExDBFieldString<>("ztykanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztytsintelno = new ExDBFieldString<>("ztytsintelno", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhhknmei = new ExDBFieldString<>("ztyhhknmei", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhensyuuyoukyksyaseiymd = new ExDBFieldString<>("ztyhensyuuyoukyksyaseiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, BizNumber> ztyitijibaraipkyktuuka = new ExDBFieldString<>("ztyitijibaraipkyktuuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkIpJissekiTy, BizNumber> ztykawaseraten5 = new ExDBFieldString<>("ztykawaseraten5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyhrktuukakbn = new ExDBFieldString<>("ztyhrktuukakbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztysiteituukakbn = new ExDBFieldString<>("ztysiteituukakbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztysyksbsitihsyutkykarihyj = new ExDBFieldString<>("ztysyksbsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyskkaigomaehrtkykarihyj = new ExDBFieldString<>("ztyskkaigomaehrtkykarihyj", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztykihonskyktuuka = new ExDBFieldNumber<>("ztykihonskyktuuka", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyzenkizennouhyouji = new ExDBFieldString<>("ztyzenkizennouhyouji", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiTy, Long> ztynnknsnpssysyup = new ExDBFieldNumber<>("ztynnknsnpssysyup", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztynknsnpssyhrkkskbn = new ExDBFieldString<>("ztynknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztykzktrkservicearihyj = new ExDBFieldString<>("ztykzktrkservicearihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyyobiv250x1 = new ExDBFieldString<>("ztyyobiv250x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyyobiv250x2 = new ExDBFieldString<>("ztyyobiv250x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyyobiv250x3 = new ExDBFieldString<>("ztyyobiv250x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyyobiv250x4 = new ExDBFieldString<>("ztyyobiv250x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyyobiv250x5 = new ExDBFieldString<>("ztyyobiv250x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiTy, String> ztyyobiv213 = new ExDBFieldString<>("ztyyobiv213", this);
}
