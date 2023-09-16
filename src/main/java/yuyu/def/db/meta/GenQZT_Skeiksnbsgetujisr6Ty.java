package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Ty;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Skeiksnbsgetujisr6Ty extends AbstractExDBTable<ZT_Skeiksnbsgetujisr6Ty> {

    public GenQZT_Skeiksnbsgetujisr6Ty() {
        this("ZT_Skeiksnbsgetujisr6Ty");
    }

    public GenQZT_Skeiksnbsgetujisr6Ty(String pAlias) {
        super("ZT_Skeiksnbsgetujisr6Ty", ZT_Skeiksnbsgetujisr6Ty.class, pAlias);
    }

    public String ZT_Skeiksnbsgetujisr6Ty() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyktgysyrymd = new ExDBFieldString<>("ztyktgysyrymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyktgysyono = new ExDBFieldString<>("ztyktgysyono", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyktgyfilerenno = new ExDBFieldString<>("ztyktgyfilerenno", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztykaigomaebaraitkykarihyj = new ExDBFieldString<>("ztykaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztysuuriyouyobin1 = new ExDBFieldString<>("ztysuuriyouyobin1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyhtnknkykliveonearhyj = new ExDBFieldString<>("ztyhtnknkykliveonearhyj", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyliveonepackagesyouhinkbn = new ExDBFieldString<>("ztyliveonepackagesyouhinkbn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztyhtnkngukisisttkknsnp = new ExDBFieldNumber<>("ztyhtnkngukisisttkknsnp", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztywyendttargetmokuhyouritu = new ExDBFieldString<>("ztywyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztysuuriyouyobin10x3 = new ExDBFieldString<>("ztysuuriyouyobin10x3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztykykymdsisuu = new ExDBFieldString<>("ztykykymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Integer> ztyyobin5 = new ExDBFieldNumber<>("ztyyobin5", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Integer> ztyyobin5x2 = new ExDBFieldNumber<>("ztyyobin5x2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyyobiv9x2 = new ExDBFieldString<>("ztyyobiv9x2", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztyyendttargetkijyunkingaku = new ExDBFieldNumber<>("ztyyendttargetkijyunkingaku", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztytirttmtttumitatekin = new ExDBFieldNumber<>("ztytirttmtttumitatekin", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztynksjitirttmttkn = new ExDBFieldNumber<>("ztynksjitirttmttkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztynendomatutirttumitatekin = new ExDBFieldNumber<>("ztynendomatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr6Ty, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, BizNumber> ztysitivkisnyukykjikwsrate = new ExDBFieldString<>("ztysitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr6Ty, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);
}
