package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SkIpJissekiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新契約インプット実績Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkIpJissekiRn extends AbstractExDBTable<ZT_SkIpJissekiRn> {

    public GenQZT_SkIpJissekiRn() {
        this("ZT_SkIpJissekiRn");
    }

    public GenQZT_SkIpJissekiRn(String pAlias) {
        super("ZT_SkIpJissekiRn", ZT_SkIpJissekiRn.class, pAlias);
    }

    public String ZT_SkIpJissekiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmosym = new ExDBFieldString<>("zrnmosym", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnatukaikojincd = new ExDBFieldString<>("zrnatukaikojincd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrndairitenatkikeitaikbn = new ExDBFieldString<>("zrndairitenatkikeitaikbn", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Integer> zrnatkiwari3keta = new ExDBFieldNumber<>("zrnatkiwari3keta", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkjsakininisetteihyj = new ExDBFieldString<>("zrnkjsakininisetteihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmosno = new ExDBFieldString<>("zrnmosno", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkydatkikbn = new ExDBFieldString<>("zrnkydatkikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmossyoumetukbn = new ExDBFieldString<>("zrnmossyoumetukbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkykktaikbn = new ExDBFieldString<>("zrnkykktaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrnrendouyouharaikomip = new ExDBFieldNumber<>("zrnrendouyouharaikomip", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnatukaisosikicd = new ExDBFieldString<>("zrnatukaisosikicd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrngyousekiyouhosyous = new ExDBFieldNumber<>("zrngyousekiyouhosyous", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrngoukeikihons = new ExDBFieldNumber<>("zrngoukeikihons", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmusymd = new ExDBFieldString<>("zrnmusymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmosnyuuryokuymd = new ExDBFieldString<>("zrnmosnyuuryokuymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnsyokaipryosyuymd = new ExDBFieldString<>("zrnsyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnfstpnyknsyoriymd = new ExDBFieldString<>("zrnfstpnyknsyoriymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkokutiymd = new ExDBFieldString<>("zrnkokutiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmossyumtkktymd = new ExDBFieldString<>("zrnmossyumtkktymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnsisyaketsyoriymd = new ExDBFieldString<>("zrnsisyaketsyoriymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmossyosakuseiymd = new ExDBFieldString<>("zrnmossyosakuseiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhhknsakuinmeino = new ExDBFieldString<>("zrnhhknsakuinmeino", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhaitousiharaikbn = new ExDBFieldString<>("zrnhaitousiharaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhubikbn = new ExDBFieldString<>("zrnhubikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnseisekiym = new ExDBFieldString<>("zrnseisekiym", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrntokusyujimutoriatukaikbn = new ExDBFieldString<>("zrntokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkyksyaskinmeino = new ExDBFieldString<>("zrnkyksyaskinmeino", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmossakuseino = new ExDBFieldString<>("zrnmossakuseino", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnnstkarihyj = new ExDBFieldString<>("zrnnstkarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrndai1kyktdkkbn = new ExDBFieldString<>("zrndai1kyktdkkbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnmossyouninymd = new ExDBFieldString<>("zrnmossyouninymd", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrnnenkansanp = new ExDBFieldNumber<>("zrnnenkansanp", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnnksyuruikbn1 = new ExDBFieldString<>("zrnnksyuruikbn1", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhensyuukeiyakusyamei = new ExDBFieldString<>("zrnhensyuukeiyakusyamei", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkanjitsinkaiadr = new ExDBFieldString<>("zrnkanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrntsintelno = new ExDBFieldString<>("zrntsintelno", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhhknmei = new ExDBFieldString<>("zrnhhknmei", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhensyuuyoukyksyaseiymd = new ExDBFieldString<>("zrnhensyuuyoukyksyaseiymd", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, BizNumber> zrnitijibaraipkyktuuka = new ExDBFieldString<>("zrnitijibaraipkyktuuka", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkIpJissekiRn, BizNumber> zrnkawaseraten5 = new ExDBFieldString<>("zrnkawaseraten5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnhrktuukakbn = new ExDBFieldString<>("zrnhrktuukakbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnsiteituukakbn = new ExDBFieldString<>("zrnsiteituukakbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnsyksbsitihsyutkykarihyj = new ExDBFieldString<>("zrnsyksbsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnskkaigomaehrtkykarihyj = new ExDBFieldString<>("zrnskkaigomaehrtkykarihyj", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrnkihonskyktuuka = new ExDBFieldNumber<>("zrnkihonskyktuuka", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnzenkizennouhyouji = new ExDBFieldString<>("zrnzenkizennouhyouji", this);

    public final ExDBFieldNumber<ZT_SkIpJissekiRn, Long> zrnnnknsnpssysyup = new ExDBFieldNumber<>("zrnnnknsnpssysyup", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnnknsnpssyhrkkskbn = new ExDBFieldString<>("zrnnknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnkzktrkservicearihyj = new ExDBFieldString<>("zrnkzktrkservicearihyj", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnyobiv250x1 = new ExDBFieldString<>("zrnyobiv250x1", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnyobiv250x2 = new ExDBFieldString<>("zrnyobiv250x2", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnyobiv250x3 = new ExDBFieldString<>("zrnyobiv250x3", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnyobiv250x4 = new ExDBFieldString<>("zrnyobiv250x4", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnyobiv250x5 = new ExDBFieldString<>("zrnyobiv250x5", this);

    public final ExDBFieldString<ZT_SkIpJissekiRn, String> zrnyobiv213 = new ExDBFieldString<>("zrnyobiv213", this);
}
