package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkCreditTourokukekkaQrTr extends AbstractExDBTable<ZT_SkCreditTourokukekkaQrTr> {

    public GenQZT_SkCreditTourokukekkaQrTr() {
        this("ZT_SkCreditTourokukekkaQrTr");
    }

    public GenQZT_SkCreditTourokukekkaQrTr(String pAlias) {
        super("ZT_SkCreditTourokukekkaQrTr", ZT_SkCreditTourokukekkaQrTr.class, pAlias);
    }

    public String ZT_SkCreditTourokukekkaQrTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrrecordkbn = new ExDBFieldString<>("ztrrecordkbn", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrsystemjyusinymd = new ExDBFieldString<>("ztrsystemjyusinymd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrsystemjyusintime = new ExDBFieldString<>("ztrsystemjyusintime", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrcreditqrtrkkbn = new ExDBFieldString<>("ztrcreditqrtrkkbn", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrcreditqrsousinkbn = new ExDBFieldString<>("ztrcreditqrsousinkbn", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrcreditkessaiyouno = new ExDBFieldString<>("ztrcreditkessaiyouno", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztryobiv34 = new ExDBFieldString<>("ztryobiv34", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrcreditkaiinno = new ExDBFieldString<>("ztrcreditkaiinno", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrcardyuukoukigen = new ExDBFieldString<>("ztrcardyuukoukigen", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrauthorigkjyusin = new ExDBFieldString<>("ztrauthorigkjyusin", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztryobiv153 = new ExDBFieldString<>("ztryobiv153", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrtyuumonno = new ExDBFieldString<>("ztrtyuumonno", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztryobiv50 = new ExDBFieldString<>("ztryobiv50", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrbluegateshopid = new ExDBFieldString<>("ztrbluegateshopid", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztryobiv81 = new ExDBFieldString<>("ztryobiv81", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrkessaisyoriymd = new ExDBFieldString<>("ztrkessaisyoriymd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztryobiv24 = new ExDBFieldString<>("ztryobiv24", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrcreditqrerrorcd = new ExDBFieldString<>("ztrcreditqrerrorcd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrsyouninno7keta = new ExDBFieldString<>("ztrsyouninno7keta", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrbluegateerrorcd = new ExDBFieldString<>("ztrbluegateerrorcd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrhisimukekaisyacd = new ExDBFieldString<>("ztrhisimukekaisyacd", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztrbluegatejyusinymdtime = new ExDBFieldString<>("ztrbluegatejyusinymdtime", this);

    public final ExDBFieldString<ZT_SkCreditTourokukekkaQrTr, String> ztryobiv160 = new ExDBFieldString<>("ztryobiv160", this);
}
