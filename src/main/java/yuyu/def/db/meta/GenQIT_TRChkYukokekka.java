package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_TRChkYukokekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 有効性確認結果ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRChkYukokekka extends AbstractExDBTable<IT_TRChkYukokekka> {

    public GenQIT_TRChkYukokekka() {
        this("IT_TRChkYukokekka");
    }

    public GenQIT_TRChkYukokekka(String pAlias) {
        super("IT_TRChkYukokekka", IT_TRChkYukokekka.class, pAlias);
    }

    public String IT_TRChkYukokekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRChkYukokekka, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TRChkYukokekka, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRChkYukokekka, String> yuukoutrrenno = new ExDBFieldString<>("yuukoutrrenno", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_TRChkYukokekka, C_UmuKbn> cardnokosumu = new ExDBFieldString<>("cardnokosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_TRChkYukokekka, C_UmuKbn> cardykkigenkosumu = new ExDBFieldString<>("cardykkigenkosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_TRChkYukokekka, String> newcreditcardno1 = new ExDBFieldString<>("newcreditcardno1", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> newcreditcardno2 = new ExDBFieldString<>("newcreditcardno2", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> newcreditcardno3 = new ExDBFieldString<>("newcreditcardno3", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> newcreditcardno4 = new ExDBFieldString<>("newcreditcardno4", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> newcreditcardykkigen = new ExDBFieldString<>("newcreditcardykkigen", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TRChkYukokekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
