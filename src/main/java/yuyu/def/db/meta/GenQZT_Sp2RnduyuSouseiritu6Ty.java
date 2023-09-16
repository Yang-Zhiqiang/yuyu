package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu6Ty;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＰ２連動用総成立Fテーブル６（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Sp2RnduyuSouseiritu6Ty extends AbstractExDBTable<ZT_Sp2RnduyuSouseiritu6Ty> {

    public GenQZT_Sp2RnduyuSouseiritu6Ty() {
        this("ZT_Sp2RnduyuSouseiritu6Ty");
    }

    public GenQZT_Sp2RnduyuSouseiritu6Ty(String pAlias) {
        super("ZT_Sp2RnduyuSouseiritu6Ty", ZT_Sp2RnduyuSouseiritu6Ty.class, pAlias);
    }

    public String ZT_Sp2RnduyuSouseiritu6Ty() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyktgysyrymd = new ExDBFieldString<>("ztyktgysyrymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyktgysyono = new ExDBFieldString<>("ztyktgysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyktgyfilerenno = new ExDBFieldString<>("ztyktgyfilerenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztykykjikawaserate = new ExDBFieldString<>("ztykykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztykykjikawaseratetkyuymd = new ExDBFieldString<>("ztykykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztykaigomaebaraitkykarihyj = new ExDBFieldString<>("ztykaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztysuuriyouyobin1 = new ExDBFieldString<>("ztysuuriyouyobin1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztynyuukintuukakbn = new ExDBFieldString<>("ztynyuukintuukakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyhtnknkykliveonearhyj = new ExDBFieldString<>("ztyhtnknkykliveonearhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyliveonepackagesyouhinkbn = new ExDBFieldString<>("ztyliveonepackagesyouhinkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztyhtnkngukisisttkknsnp = new ExDBFieldNumber<>("ztyhtnkngukisisttkknsnp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztywyendttargetmokuhyouritu = new ExDBFieldString<>("ztywyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztysuuriyouyobin10x3 = new ExDBFieldString<>("ztysuuriyouyobin10x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztykykymdsisuu = new ExDBFieldString<>("ztykykymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Integer> ztyyobin5 = new ExDBFieldNumber<>("ztyyobin5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Integer> ztyyobin5x2 = new ExDBFieldNumber<>("ztyyobin5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyyobiv10x6 = new ExDBFieldString<>("ztyyobiv10x6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztyyendttargetkijyunkingaku = new ExDBFieldNumber<>("ztyyendttargetkijyunkingaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztysisuurentumitatekin = new ExDBFieldNumber<>("ztysisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztytirttmtttumitatekin = new ExDBFieldNumber<>("ztytirttmtttumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztynksjitirttmttkn = new ExDBFieldNumber<>("ztynksjitirttmttkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztynendomatutirttumitatekin = new ExDBFieldNumber<>("ztynendomatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztysyuptumitatekin = new ExDBFieldNumber<>("ztysyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztygaikadatenkgns = new ExDBFieldNumber<>("ztygaikadatenkgns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztytumitatekin = new ExDBFieldNumber<>("ztytumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztykiharaikomip = new ExDBFieldNumber<>("ztykiharaikomip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Ty, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, BizNumber> ztysitivkisnyukykjikwsrate = new ExDBFieldString<>("ztysitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Ty, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);
}
