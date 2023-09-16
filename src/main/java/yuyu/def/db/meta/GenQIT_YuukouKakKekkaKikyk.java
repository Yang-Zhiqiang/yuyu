package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Yuukoukakkekka;

/**
 * 有効性確認結果（既契約）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_YuukouKakKekkaKikyk extends AbstractExDBTable<IT_YuukouKakKekkaKikyk> {

    public GenQIT_YuukouKakKekkaKikyk() {
        this("IT_YuukouKakKekkaKikyk");
    }

    public GenQIT_YuukouKakKekkaKikyk(String pAlias) {
        super("IT_YuukouKakKekkaKikyk", IT_YuukouKakKekkaKikyk.class, pAlias);
    }

    public String IT_YuukouKakKekkaKikyk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, String> creditcardno = new ExDBFieldString<>("creditcardno", this);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, String> cardyuukoukigen4keta = new ExDBFieldString<>("cardyuukoukigen4keta", this);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, BizDateYM> credityuukoukakym = new ExDBFieldString<>("credityuukoukakym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, C_Yuukoukakkekka> credityuukoukakkekka = new ExDBFieldString<>("credityuukoukakkekka", this, UserType_C_Yuukoukakkekka.class);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, String> creditkigyoucd = new ExDBFieldString<>("creditkigyoucd", this);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_YuukouKakKekkaKikyk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
