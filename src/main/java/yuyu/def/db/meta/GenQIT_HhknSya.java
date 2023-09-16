package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.db.entity.IT_HhknSya;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;

/**
 * 被保険者テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HhknSya extends AbstractExDBTable<IT_HhknSya> {

    public GenQIT_HhknSya() {
        this("IT_HhknSya");
    }

    public GenQIT_HhknSya(String pAlias) {
        super("IT_HhknSya", IT_HhknSya.class, pAlias);
    }

    public String IT_HhknSya() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HhknSya, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HhknSya, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HhknSya, String> kokno = new ExDBFieldString<>("kokno", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknsakuinmeino = new ExDBFieldString<>("hhknsakuinmeino", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_HhknSya, C_KjkhukaKbn> hhknnmkjkhukakbn = new ExDBFieldString<>("hhknnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_HhknSya, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HhknSya, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<IT_HhknSya, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknadr1kn = new ExDBFieldString<>("hhknadr1kn", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknadr2kn = new ExDBFieldString<>("hhknadr2kn", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknadr3kn = new ExDBFieldString<>("hhknadr3kn", this);

    public final ExDBFieldString<IT_HhknSya, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<IT_HhknSya, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<IT_HhknSya, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HhknSya, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HhknSya, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
