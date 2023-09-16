package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu6Rn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＰ２連動用総成立Fテーブル６（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Sp2RnduyuSouseiritu6Rn extends AbstractExDBTable<ZT_Sp2RnduyuSouseiritu6Rn> {

    public GenQZT_Sp2RnduyuSouseiritu6Rn() {
        this("ZT_Sp2RnduyuSouseiritu6Rn");
    }

    public GenQZT_Sp2RnduyuSouseiritu6Rn(String pAlias) {
        super("ZT_Sp2RnduyuSouseiritu6Rn", ZT_Sp2RnduyuSouseiritu6Rn.class, pAlias);
    }

    public String ZT_Sp2RnduyuSouseiritu6Rn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnktgysyrymd = new ExDBFieldString<>("zrnktgysyrymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnktgysyono = new ExDBFieldString<>("zrnktgysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnktgyfilerenno = new ExDBFieldString<>("zrnktgyfilerenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnkykjikawaserate = new ExDBFieldString<>("zrnkykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnkykjikawaseratetkyuymd = new ExDBFieldString<>("zrnkykjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnkaigomaebaraitkykarihyj = new ExDBFieldString<>("zrnkaigomaebaraitkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnsuuriyouyobin1 = new ExDBFieldString<>("zrnsuuriyouyobin1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnsibouhyoukbn = new ExDBFieldString<>("zrnsibouhyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnnyuukintuukakbn = new ExDBFieldString<>("zrnnyuukintuukakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnhtnknkykliveonearhyj = new ExDBFieldString<>("zrnhtnknkykliveonearhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnliveonepackagesyouhinkbn = new ExDBFieldString<>("zrnliveonepackagesyouhinkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnhtnkngukisisttkknsnp = new ExDBFieldNumber<>("zrnhtnkngukisisttkknsnp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnwyendttargetmokuhyouritu = new ExDBFieldString<>("zrnwyendttargetmokuhyouritu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnsuuriyouyobin10x2 = new ExDBFieldString<>("zrnsuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnsuuriyouyobin10x3 = new ExDBFieldString<>("zrnsuuriyouyobin10x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrntmttknzoukaritujygn = new ExDBFieldString<>("zrntmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnsetteibairitu = new ExDBFieldString<>("zrnsetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnkykymdsisuu = new ExDBFieldString<>("zrnkykymdsisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Integer> zrnyobin5 = new ExDBFieldNumber<>("zrnyobin5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Integer> zrnyobin5x2 = new ExDBFieldNumber<>("zrnyobin5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnyobiv10x6 = new ExDBFieldString<>("zrnyobiv10x6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnyendttargetkijyunkingaku = new ExDBFieldNumber<>("zrnyendttargetkijyunkingaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnsisuurentumitatekin = new ExDBFieldNumber<>("zrnsisuurentumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrntirttmtttumitatekin = new ExDBFieldNumber<>("zrntirttmtttumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnnksjitirttmttkn = new ExDBFieldNumber<>("zrnnksjitirttmttkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnnendomatutirttumitatekin = new ExDBFieldNumber<>("zrnnendomatutirttumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnsyuptumitatekin = new ExDBFieldNumber<>("zrnsyuptumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrngaikadatenkgns = new ExDBFieldNumber<>("zrngaikadatenkgns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrntumitatekin = new ExDBFieldNumber<>("zrntumitatekin", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrnkiharaikomip = new ExDBFieldNumber<>("zrnkiharaikomip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu6Rn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, BizNumber> zrnsitivkisnyukykjikwsrate = new ExDBFieldString<>("zrnsitivkisnyukykjikwsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu6Rn, String> zrnyobiv16 = new ExDBFieldString<>("zrnyobiv16", this);
}
