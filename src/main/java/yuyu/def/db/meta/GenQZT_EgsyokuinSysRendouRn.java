package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 営業職員システム連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_EgsyokuinSysRendouRn extends AbstractExDBTable<ZT_EgsyokuinSysRendouRn> {

    public GenQZT_EgsyokuinSysRendouRn() {
        this("ZT_EgsyokuinSysRendouRn");
    }

    public GenQZT_EgsyokuinSysRendouRn(String pAlias) {
        super("ZT_EgsyokuinSysRendouRn", ZT_EgsyokuinSysRendouRn.class, pAlias);
    }

    public String ZT_EgsyokuinSysRendouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnatukaikojincd = new ExDBFieldString<>("zrnatukaikojincd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrngyousekiyouhosyous = new ExDBFieldNumber<>("zrngyousekiyouhosyous", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkydatkikbn = new ExDBFieldString<>("zrnkydatkikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnatukaisosikicd = new ExDBFieldString<>("zrnatukaisosikicd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhensyuukeiyakusyamei = new ExDBFieldString<>("zrnhensyuukeiyakusyamei", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhnsyuknjkyksynm = new ExDBFieldString<>("zrnhnsyuknjkyksynm", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkurikosihyj = new ExDBFieldString<>("zrnkurikosihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkyksyhhknsydouituhyouji = new ExDBFieldString<>("zrnkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhaitousiharaikbn = new ExDBFieldString<>("zrnhaitousiharaikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrndairitenatkikeitaikbn = new ExDBFieldString<>("zrndairitenatkikeitaikbn", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Integer> zrndrtenegsyokuinatkiwari = new ExDBFieldNumber<>("zrndrtenegsyokuinatkiwari", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkjsakisosikisetteihyj = new ExDBFieldString<>("zrnkjsakisosikisetteihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsimetyokuzenbosyuuhyj = new ExDBFieldString<>("zrnsimetyokuzenbosyuuhyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnmosnyuuryokuymd = new ExDBFieldString<>("zrnmosnyuuryokuymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhhknsakuinmeino = new ExDBFieldString<>("zrnhhknsakuinmeino", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrntokusyujimutoriatukaikbn = new ExDBFieldString<>("zrntokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnnstkarihyj = new ExDBFieldString<>("zrnnstkarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnmosno = new ExDBFieldString<>("zrnmosno", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnnenkansanp = new ExDBFieldNumber<>("zrnnenkansanp", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkyksyaskinmeino = new ExDBFieldString<>("zrnkyksyaskinmeino", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnjissyuup = new ExDBFieldNumber<>("zrnjissyuup", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsekininkaisiymd = new ExDBFieldString<>("zrnsekininkaisiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkokutiymd = new ExDBFieldString<>("zrnkokutiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsyokaipryosyuymd = new ExDBFieldString<>("zrnsyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnseirituymd = new ExDBFieldString<>("zrnseirituymd", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Integer> zrnbosdairitentsratkiwari = new ExDBFieldNumber<>("zrnbosdairitentsratkiwari", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrndrtentsryhushrkykhyouji = new ExDBFieldString<>("zrndrtentsryhushrkykhyouji", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnmdhnaisyoumeikbn = new ExDBFieldString<>("zrnmdhnaisyoumeikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrndairitenkykkanrino = new ExDBFieldString<>("zrndairitenkykkanrino", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkanjitsinkaiadr = new ExDBFieldString<>("zrnkanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrntsintelno = new ExDBFieldString<>("zrntsintelno", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhensyuuyoukyksyaseikbn = new ExDBFieldString<>("zrnhensyuuyoukyksyaseikbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhensyuuyoukyksyaseiymd = new ExDBFieldString<>("zrnhensyuuyoukyksyaseiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhhknmei = new ExDBFieldString<>("zrnhhknmei", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnknjhhknmei = new ExDBFieldString<>("zrnknjhhknmei", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnnksyuruikbn1 = new ExDBFieldString<>("zrnnksyuruikbn1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnmusymd = new ExDBFieldString<>("zrnmusymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnmossyosakuseiymd = new ExDBFieldString<>("zrnmossyosakuseiymd", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, BizNumber> zrnitijibaraipkyktuuka = new ExDBFieldString<>("zrnitijibaraipkyktuuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, BizNumber> zrnkawaseraten5 = new ExDBFieldString<>("zrnkawaseraten5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnhrktuukakbn = new ExDBFieldString<>("zrnhrktuukakbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsiteituukakbn = new ExDBFieldString<>("zrnsiteituukakbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnsyksbsitihsyutkykarihyj = new ExDBFieldString<>("zrnsyksbsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnskkaigomaehrtkykarihyj = new ExDBFieldString<>("zrnskkaigomaehrtkykarihyj", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnkihonskyktuuka = new ExDBFieldNumber<>("zrnkihonskyktuuka", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnzenkizennouhyouji = new ExDBFieldString<>("zrnzenkizennouhyouji", this);

    public final ExDBFieldNumber<ZT_EgsyokuinSysRendouRn, Long> zrnnnknsnpssysyup = new ExDBFieldNumber<>("zrnnnknsnpssysyup", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnnknsnpssyhrkkskbn = new ExDBFieldString<>("zrnnknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnkzktrkservicearihyj = new ExDBFieldString<>("zrnkzktrkservicearihyj", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnyobiv250x1 = new ExDBFieldString<>("zrnyobiv250x1", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnyobiv250x2 = new ExDBFieldString<>("zrnyobiv250x2", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnyobiv250x3 = new ExDBFieldString<>("zrnyobiv250x3", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnyobiv250x4 = new ExDBFieldString<>("zrnyobiv250x4", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnyobiv250x5 = new ExDBFieldString<>("zrnyobiv250x5", this);

    public final ExDBFieldString<ZT_EgsyokuinSysRendouRn, String> zrnyobiv118 = new ExDBFieldString<>("zrnyobiv118", this);
}
