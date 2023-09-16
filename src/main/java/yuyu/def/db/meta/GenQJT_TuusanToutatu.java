package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.JT_TuusanToutatu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;

/**
 * 通算到達テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_TuusanToutatu extends AbstractExDBTable<JT_TuusanToutatu> {

    public GenQJT_TuusanToutatu() {
        this("JT_TuusanToutatu");
    }

    public GenQJT_TuusanToutatu(String pAlias) {
        super("JT_TuusanToutatu", JT_TuusanToutatu.class, pAlias);
    }

    public String JT_TuusanToutatu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_TuusanToutatu, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_TuusanToutatu, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_TuusanToutatu, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_TuusanToutatu, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<JT_TuusanToutatu, C_KyhgndkataKbn> kyhgndkatakbn = new ExDBFieldString<>("kyhgndkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldNumber<JT_TuusanToutatu, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<JT_TuusanToutatu, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<JT_TuusanToutatu, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldString<JT_TuusanToutatu, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_TuusanToutatu, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_TuusanToutatu, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_TuusanToutatu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_TuusanToutatu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
