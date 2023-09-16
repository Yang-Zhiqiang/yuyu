package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 営業職員システム連動Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_EgsyokuinSysRendouTy extends AbstractExDBTable<ZT_EgsyokuinSysRendouTy> {

    public GenQZT_EgsyokuinSysRendouTy() {
        this("ZT_EgsyokuinSysRendouTy");
    }

    public GenQZT_EgsyokuinSysRendouTy(String pAlias) {
        super("ZT_EgsyokuinSysRendouTy", ZT_EgsyokuinSysRendouTy.class, pAlias);
    }

    public String ZT_EgsyokuinSysRendouTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyatukaikojincd = new ExDBFieldString<>("ztyatukaikojincd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztygyousekiyouhosyous = new ExDBFieldNumber<>("ztygyousekiyouhosyous", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykydatkikbn = new ExDBFieldString<>("ztykydatkikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztytsinkihontikucd = new ExDBFieldString<>("ztytsinkihontikucd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyatukaisosikicd = new ExDBFieldString<>("ztyatukaisosikicd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhensyuukeiyakusyamei = new ExDBFieldString<>("ztyhensyuukeiyakusyamei", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhnsyuknjkyksynm = new ExDBFieldString<>("ztyhnsyuknjkyksynm", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykurikosihyj = new ExDBFieldString<>("ztykurikosihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztylivingneedstkykarihyj = new ExDBFieldString<>("ztylivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykyksyhhknsydouituhyouji = new ExDBFieldString<>("ztykyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhaitousiharaikbn = new ExDBFieldString<>("ztyhaitousiharaikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztydairitenatkikeitaikbn = new ExDBFieldString<>("ztydairitenatkikeitaikbn", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Integer> ztydrtenegsyokuinatkiwari = new ExDBFieldNumber<>("ztydrtenegsyokuinatkiwari", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykjsakisosikisetteihyj = new ExDBFieldString<>("ztykjsakisosikisetteihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysimetyokuzenbosyuuhyj = new ExDBFieldString<>("ztysimetyokuzenbosyuuhyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztymosnyuuryokuymd = new ExDBFieldString<>("ztymosnyuuryokuymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhhknsakuinmeino = new ExDBFieldString<>("ztyhhknsakuinmeino", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztytokusyujimutoriatukaikbn = new ExDBFieldString<>("ztytokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x11 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x12 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x13 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x14 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi1x15 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi2x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhokensyuruikigouyobi3x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztynstkarihyj = new ExDBFieldString<>("ztynstkarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztymosno = new ExDBFieldString<>("ztymosno", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztynenkansanp = new ExDBFieldNumber<>("ztynenkansanp", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykyksyaskinmeino = new ExDBFieldString<>("ztykyksyaskinmeino", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztyjissyuup = new ExDBFieldNumber<>("ztyjissyuup", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysekininkaisiymd = new ExDBFieldString<>("ztysekininkaisiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykokutiymd = new ExDBFieldString<>("ztykokutiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysyokaipryosyuymd = new ExDBFieldString<>("ztysyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyseirituymd = new ExDBFieldString<>("ztyseirituymd", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Integer> ztybosdairitentsratkiwari = new ExDBFieldNumber<>("ztybosdairitentsratkiwari", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztybosyuunincd = new ExDBFieldString<>("ztybosyuunincd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztydrtentsryhushrkykhyouji = new ExDBFieldString<>("ztydrtentsryhushrkykhyouji", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztymdhnaisyoumeikbn = new ExDBFieldString<>("ztymdhnaisyoumeikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztydairitenkykkanrino = new ExDBFieldString<>("ztydairitenkykkanrino", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykanjitsinkaiadr = new ExDBFieldString<>("ztykanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztytsintelno = new ExDBFieldString<>("ztytsintelno", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhensyuuyoukyksyaseikbn = new ExDBFieldString<>("ztyhensyuuyoukyksyaseikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhensyuuyoukyksyaseiymd = new ExDBFieldString<>("ztyhensyuuyoukyksyaseiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhhknmei = new ExDBFieldString<>("ztyhhknmei", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyknjhhknmei = new ExDBFieldString<>("ztyknjhhknmei", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztynksyuruikbn1 = new ExDBFieldString<>("ztynksyuruikbn1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztymossyosakuseiymd = new ExDBFieldString<>("ztymossyosakuseiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, BizNumber> ztyitijibaraipkyktuuka = new ExDBFieldString<>("ztyitijibaraipkyktuuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, BizNumber> ztykawaseraten5 = new ExDBFieldString<>("ztykawaseraten5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyhrktuukakbn = new ExDBFieldString<>("ztyhrktuukakbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysiteituukakbn = new ExDBFieldString<>("ztysiteituukakbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztysyksbsitihsyutkykarihyj = new ExDBFieldString<>("ztysyksbsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyskkaigomaehrtkykarihyj = new ExDBFieldString<>("ztyskkaigomaehrtkykarihyj", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztykihonskyktuuka = new ExDBFieldNumber<>("ztykihonskyktuuka", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyzenkizennouhyouji = new ExDBFieldString<>("ztyzenkizennouhyouji", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouTy, Long> ztynnknsnpssysyup = new ExDBFieldNumber<>("ztynnknsnpssysyup", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztynknsnpssyhrkkskbn = new ExDBFieldString<>("ztynknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztykzktrkservicearihyj = new ExDBFieldString<>("ztykzktrkservicearihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyyobiv250x1 = new ExDBFieldString<>("ztyyobiv250x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyyobiv250x2 = new ExDBFieldString<>("ztyyobiv250x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyyobiv250x3 = new ExDBFieldString<>("ztyyobiv250x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyyobiv250x4 = new ExDBFieldString<>("ztyyobiv250x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyyobiv250x5 = new ExDBFieldString<>("ztyyobiv250x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouTy, String> ztyyobiv118 = new ExDBFieldString<>("ztyyobiv118", this);
}
