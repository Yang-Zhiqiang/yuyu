package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsMailDbSyoriKbn;
import yuyu.def.db.type.UserType_C_DsRendouTaisyouKbn;

/**
 * ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsMailAddressSpiralYyk extends AbstractExDBTable<MT_DsMailAddressSpiralYyk> {

    public GenQMT_DsMailAddressSpiralYyk() {
        this("MT_DsMailAddressSpiralYyk");
    }

    public GenQMT_DsMailAddressSpiralYyk(String pAlias) {
        super("MT_DsMailAddressSpiralYyk", MT_DsMailAddressSpiralYyk.class, pAlias);
    }

    public String MT_DsMailAddressSpiralYyk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MT_DsMailAddressSpiralYyk, Integer> dsmailaddressrenban = new ExDBFieldNumber<>("dsmailaddressrenban", this);

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, String> dsmailaddress = new ExDBFieldString<>("dsmailaddress", this);

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, C_DsRendouTaisyouKbn> dsrendoutaisyoukbn = new ExDBFieldString<>("dsrendoutaisyoukbn", this, UserType_C_DsRendouTaisyouKbn.class);

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, C_DsMailDbSyoriKbn> dsmaildbsyorikbn = new ExDBFieldString<>("dsmaildbsyorikbn", this, UserType_C_DsMailDbSyoriKbn.class);

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsMailAddressSpiralYyk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
