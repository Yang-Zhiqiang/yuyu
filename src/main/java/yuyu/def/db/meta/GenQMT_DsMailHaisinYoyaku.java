package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsHaisinYoyakuStatusKbn;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信予約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsMailHaisinYoyaku extends AbstractExDBTable<MT_DsMailHaisinYoyaku> {

    public GenQMT_DsMailHaisinYoyaku() {
        this("MT_DsMailHaisinYoyaku");
    }

    public GenQMT_DsMailHaisinYoyaku(String pAlias) {
        super("MT_DsMailHaisinYoyaku", MT_DsMailHaisinYoyaku.class, pAlias);
    }

    public String MT_DsMailHaisinYoyaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, String> dsmailhaisinyoyakuskbtkey = new ExDBFieldString<>("dsmailhaisinyoyakuskbtkey", this);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, BizDate> dsmailhaisinyoteiymd = new ExDBFieldString<>("dsmailhaisinyoteiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, C_DsSousinMailSyubetuKbn> dssousinmailsyubetukbn = new ExDBFieldString<>("dssousinmailsyubetukbn", this, UserType_C_DsSousinMailSyubetuKbn.class);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, C_DsHaisinYoyakuStatusKbn> dshaisinyoyakustatuskbn = new ExDBFieldString<>("dshaisinyoyakustatuskbn", this, UserType_C_DsHaisinYoyakuStatusKbn.class);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, BizDate> dsmailhaisintourokuymd = new ExDBFieldString<>("dsmailhaisintourokuymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, BizDate> dsmailhaisinsyouninymd = new ExDBFieldString<>("dsmailhaisinsyouninymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, String> dsmailhaisintourokusyaid = new ExDBFieldString<>("dsmailhaisintourokusyaid", this);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, String> dsmailhaisinsyouninsyaid = new ExDBFieldString<>("dsmailhaisinsyouninsyaid", this);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsMailHaisinYoyaku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
