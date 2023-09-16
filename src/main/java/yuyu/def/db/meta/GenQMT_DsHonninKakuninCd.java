package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsKrHnnKakCdSetKbn;
import yuyu.def.db.type.UserType_C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.db.type.UserType_C_DsKrHnnKakCdTtYhKbn;

/**
 * ＤＳ本人確認コードテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsHonninKakuninCd extends AbstractExDBTable<MT_DsHonninKakuninCd> {

    public GenQMT_DsHonninKakuninCd() {
        this("MT_DsHonninKakuninCd");
    }

    public GenQMT_DsHonninKakuninCd(String pAlias) {
        super("MT_DsHonninKakuninCd", MT_DsHonninKakuninCd.class, pAlias);
    }

    public String MT_DsHonninKakuninCd() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsHonninKakuninCd, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsHonninKakuninCd, String> dskrhnnkakcd = new ExDBFieldString<>("dskrhnnkakcd", this);

    public final ExDBFieldString<MT_DsHonninKakuninCd, C_DsKrHnnKakCdSetKbn> dskrhnnkakcdsetkbn = new ExDBFieldString<>("dskrhnnkakcdsetkbn", this, UserType_C_DsKrHnnKakCdSetKbn.class);

    public final ExDBFieldString<MT_DsHonninKakuninCd, BizDate> dskrhnnkakcdsetymd = new ExDBFieldString<>("dskrhnnkakcdsetymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHonninKakuninCd, BizDate> dskrhnnkakcdyuukouymd = new ExDBFieldString<>("dskrhnnkakcdyuukouymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHonninKakuninCd, String> dshnnkakcd = new ExDBFieldString<>("dshnnkakcd", this);

    public final ExDBFieldString<MT_DsHonninKakuninCd, BizDate> dshnnkakcdsetymd = new ExDBFieldString<>("dshnnkakcdsetymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHonninKakuninCd, String> zenkaidskrhnnkakcd = new ExDBFieldString<>("zenkaidskrhnnkakcd", this);

    public final ExDBFieldString<MT_DsHonninKakuninCd, BizDate> dskrhnnkakcdttshjyhsymd = new ExDBFieldString<>("dskrhnnkakcdttshjyhsymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHonninKakuninCd, C_DsKrHnnKakCdTtYhKbn> dskrhnnkakcdttyhkbn = new ExDBFieldString<>("dskrhnnkakcdttyhkbn", this, UserType_C_DsKrHnnKakCdTtYhKbn.class);

    public final ExDBFieldString<MT_DsHonninKakuninCd, C_DsKrHnnKakCdTtTydnJyKbn> dskrhnnkakcdtttydnjykbn = new ExDBFieldString<>("dskrhnnkakcdtttydnjykbn", this, UserType_C_DsKrHnnKakCdTtTydnJyKbn.class);

    public final ExDBFieldString<MT_DsHonninKakuninCd, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsHonninKakuninCd, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_DsHonninKakuninCd, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
