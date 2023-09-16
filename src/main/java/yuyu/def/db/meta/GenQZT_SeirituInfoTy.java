package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SeirituInfoTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 成立情報Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SeirituInfoTy extends AbstractExDBTable<ZT_SeirituInfoTy> {

    public GenQZT_SeirituInfoTy() {
        this("ZT_SeirituInfoTy");
    }

    public GenQZT_SeirituInfoTy(String pAlias) {
        super("ZT_SeirituInfoTy", ZT_SeirituInfoTy.class, pAlias);
    }

    public String ZT_SeirituInfoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztykijyunym = new ExDBFieldString<>("ztykijyunym", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyseisekiym = new ExDBFieldString<>("ztyseisekiym", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhanbainm = new ExDBFieldString<>("ztyhanbainm", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyatkisisya = new ExDBFieldString<>("ztyatkisisya", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztysinkykryouritukbn = new ExDBFieldString<>("ztysinkykryouritukbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyduketorihouhoukbn = new ExDBFieldString<>("ztyduketorihouhoukbn", this);

    public final ExDBFieldNumber<ZT_SeirituInfoTy, Long> ztykihons9 = new ExDBFieldNumber<>("ztykihons9", this);

    public final ExDBFieldNumber<ZT_SeirituInfoTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldNumber<ZT_SeirituInfoTy, Long> ztytkbriknsnhrkp = new ExDBFieldNumber<>("ztytkbriknsnhrkp", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztykyksyaseikbn = new ExDBFieldString<>("ztykyksyaseikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztykyksyakikykarihyj = new ExDBFieldString<>("ztykyksyakikykarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztysyokaipnyuukinhouhoukbn = new ExDBFieldString<>("ztysyokaipnyuukinhouhoukbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhhknsynensyuukbn = new ExDBFieldString<>("ztyhhknsynensyuukbn", this);

    public final ExDBFieldNumber<ZT_SeirituInfoTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztystdairiseikyuutkykarihyj = new ExDBFieldString<>("ztystdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztymannenreihyj = new ExDBFieldString<>("ztymannenreihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztynksyuruikbn1 = new ExDBFieldString<>("ztynksyuruikbn1", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztynstkarihyj = new ExDBFieldString<>("ztynstkarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyaatkioybsydrtencd = new ExDBFieldString<>("ztyaatkioybsydrtencd", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztybatkioybsydrtencd = new ExDBFieldString<>("ztybatkioybsydrtencd", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztysinkeiyakujiyoteiriritu = new ExDBFieldString<>("ztysinkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztysiteituukakihons = new ExDBFieldString<>("ztysiteituukakihons", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyhrktuukakbn = new ExDBFieldString<>("ztyhrktuukakbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztysiteituukakbn = new ExDBFieldString<>("ztysiteituukakbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztyhrktuukatukiknznhrkp = new ExDBFieldString<>("ztyhrktuukatukiknznhrkp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztysiteituukatukiknznhrkp = new ExDBFieldString<>("ztysiteituukatukiknznhrkp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztyyennyknrate = new ExDBFieldString<>("ztyyennyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztygaikanyknrate = new ExDBFieldString<>("ztygaikanyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyjyudkaigomehrtkarihyj = new ExDBFieldString<>("ztyjyudkaigomehrtkarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztysyksbyensitihsyutkykrate = new ExDBFieldString<>("ztysyksbyensitihsyutkykrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztysjkkktyouseiriritu = new ExDBFieldString<>("ztysjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SeirituInfoTy, Integer> ztytargettkmkht = new ExDBFieldNumber<>("ztytargettkmkht", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyteirituhaibunwari = new ExDBFieldString<>("ztyteirituhaibunwari", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyzenkizennouhyouji = new ExDBFieldString<>("ztyzenkizennouhyouji", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztypwaribikikbn = new ExDBFieldString<>("ztypwaribikikbn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, BizNumber> ztypwaribikihanteigk = new ExDBFieldString<>("ztypwaribikihanteigk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztydai1hknkkn = new ExDBFieldString<>("ztydai1hknkkn", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztykykdrtkykarihyj = new ExDBFieldString<>("ztykykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztykzktrkservicetrkninzuu = new ExDBFieldString<>("ztykzktrkservicetrkninzuu", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyteikisiharaiarihyj = new ExDBFieldString<>("ztyteikisiharaiarihyj", this);

    public final ExDBFieldString<ZT_SeirituInfoTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);
}
