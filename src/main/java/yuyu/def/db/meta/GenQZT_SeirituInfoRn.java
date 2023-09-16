package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SeirituInfoRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 成立情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SeirituInfoRn extends AbstractExDBTable<ZT_SeirituInfoRn> {

    public GenQZT_SeirituInfoRn() {
        this("ZT_SeirituInfoRn");
    }

    public GenQZT_SeirituInfoRn(String pAlias) {
        super("ZT_SeirituInfoRn", ZT_SeirituInfoRn.class, pAlias);
    }

    public String ZT_SeirituInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnkijyunym = new ExDBFieldString<>("zrnkijyunym", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnseisekiym = new ExDBFieldString<>("zrnseisekiym", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhanbainm = new ExDBFieldString<>("zrnhanbainm", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnatkisisya = new ExDBFieldString<>("zrnatkisisya", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnsinkykryouritukbn = new ExDBFieldString<>("zrnsinkykryouritukbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnduketorihouhoukbn = new ExDBFieldString<>("zrnduketorihouhoukbn", this);

    public final ExDBFieldNumber<ZT_SeirituInfoRn, Long> zrnkihons9 = new ExDBFieldNumber<>("zrnkihons9", this);

    public final ExDBFieldNumber<ZT_SeirituInfoRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldNumber<ZT_SeirituInfoRn, Long> zrntkbriknsnhrkp = new ExDBFieldNumber<>("zrntkbriknsnhrkp", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnkyksyakikykarihyj = new ExDBFieldString<>("zrnkyksyakikykarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnsyokaipnyuukinhouhoukbn = new ExDBFieldString<>("zrnsyokaipnyuukinhouhoukbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhhknsynensyuukbn = new ExDBFieldString<>("zrnhhknsynensyuukbn", this);

    public final ExDBFieldNumber<ZT_SeirituInfoRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnmannenreihyj = new ExDBFieldString<>("zrnmannenreihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnnksyuruikbn1 = new ExDBFieldString<>("zrnnksyuruikbn1", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnnstkarihyj = new ExDBFieldString<>("zrnnstkarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnaatkioybsydrtencd = new ExDBFieldString<>("zrnaatkioybsydrtencd", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnbatkioybsydrtencd = new ExDBFieldString<>("zrnbatkioybsydrtencd", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnsinkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnsinkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnsiteituukakihons = new ExDBFieldString<>("zrnsiteituukakihons", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnhrktuukakbn = new ExDBFieldString<>("zrnhrktuukakbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnsiteituukakbn = new ExDBFieldString<>("zrnsiteituukakbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnhrktuukatukiknznhrkp = new ExDBFieldString<>("zrnhrktuukatukiknznhrkp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnsiteituukatukiknznhrkp = new ExDBFieldString<>("zrnsiteituukatukiknznhrkp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnyennyknrate = new ExDBFieldString<>("zrnyennyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrngaikanyknrate = new ExDBFieldString<>("zrngaikanyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnjyudkaigomehrtkarihyj = new ExDBFieldString<>("zrnjyudkaigomehrtkarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnsyksbyensitihsyutkykrate = new ExDBFieldString<>("zrnsyksbyensitihsyutkykrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnsjkkktyouseiriritu = new ExDBFieldString<>("zrnsjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SeirituInfoRn, Integer> zrntargettkmkht = new ExDBFieldNumber<>("zrntargettkmkht", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnteirituhaibunwari = new ExDBFieldString<>("zrnteirituhaibunwari", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnzenkizennouhyouji = new ExDBFieldString<>("zrnzenkizennouhyouji", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnpwaribikikbn = new ExDBFieldString<>("zrnpwaribikikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, BizNumber> zrnpwaribikihanteigk = new ExDBFieldString<>("zrnpwaribikihanteigk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrndai1hknkkn = new ExDBFieldString<>("zrndai1hknkkn", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnkzktrkservicetrkninzuu = new ExDBFieldString<>("zrnkzktrkservicetrkninzuu", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnteikisiharaiarihyj = new ExDBFieldString<>("zrnteikisiharaiarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);
}
