package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrRn;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkCreditTourokukekkaQrRn extends AbstractExDBTable<ZT_SkCreditTourokukekkaQrRn> {

    public GenQZT_SkCreditTourokukekkaQrRn() {
        this("ZT_SkCreditTourokukekkaQrRn");
    }

    public GenQZT_SkCreditTourokukekkaQrRn(String pAlias) {
        super("ZT_SkCreditTourokukekkaQrRn", ZT_SkCreditTourokukekkaQrRn.class, pAlias);
    }

    public String ZT_SkCreditTourokukekkaQrRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnsystemjyusinymd = new ExDBFieldString<>("zrnsystemjyusinymd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnsystemjyusintime = new ExDBFieldString<>("zrnsystemjyusintime", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrncreditqrtrkkbn = new ExDBFieldString<>("zrncreditqrtrkkbn", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrncreditqrsousinkbn = new ExDBFieldString<>("zrncreditqrsousinkbn", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrncreditkessaiyouno = new ExDBFieldString<>("zrncreditkessaiyouno", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnyobiv34 = new ExDBFieldString<>("zrnyobiv34", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrncreditkaiinno = new ExDBFieldString<>("zrncreditkaiinno", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrncardyuukoukigen = new ExDBFieldString<>("zrncardyuukoukigen", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnauthorigkjyusin = new ExDBFieldString<>("zrnauthorigkjyusin", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnyobiv153 = new ExDBFieldString<>("zrnyobiv153", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrntyuumonno = new ExDBFieldString<>("zrntyuumonno", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnyobiv50 = new ExDBFieldString<>("zrnyobiv50", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnbluegateshopid = new ExDBFieldString<>("zrnbluegateshopid", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnyobiv81 = new ExDBFieldString<>("zrnyobiv81", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnkessaisyoriymd = new ExDBFieldString<>("zrnkessaisyoriymd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnyobiv24 = new ExDBFieldString<>("zrnyobiv24", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrncreditqrerrorcd = new ExDBFieldString<>("zrncreditqrerrorcd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnsyouninno7keta = new ExDBFieldString<>("zrnsyouninno7keta", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnbluegateerrorcd = new ExDBFieldString<>("zrnbluegateerrorcd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnhisimukekaisyacd = new ExDBFieldString<>("zrnhisimukekaisyacd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnbluegatejyusinymdtime = new ExDBFieldString<>("zrnbluegatejyusinymdtime", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrRn, String> zrnyobiv160 = new ExDBFieldString<>("zrnyobiv160", this);
}
