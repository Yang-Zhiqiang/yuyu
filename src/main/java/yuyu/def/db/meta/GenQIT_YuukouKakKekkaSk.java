package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Yuukoukakkekka;

/**
 * 有効性確認結果（新契約）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_YuukouKakKekkaSk extends AbstractExDBTable<IT_YuukouKakKekkaSk> {

    public GenQIT_YuukouKakKekkaSk() {
        this("IT_YuukouKakKekkaSk");
    }

    public GenQIT_YuukouKakKekkaSk(String pAlias) {
        super("IT_YuukouKakKekkaSk", IT_YuukouKakKekkaSk.class, pAlias);
    }

    public String IT_YuukouKakKekkaSk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_YuukouKakKekkaSk, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, String> creditcardno = new ExDBFieldString<>("creditcardno", this);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, String> cardyuukoukigen4keta = new ExDBFieldString<>("cardyuukoukigen4keta", this);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, BizDateYM> credityuukoukakym = new ExDBFieldString<>("credityuukoukakym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, C_Yuukoukakkekka> credityuukoukakkekka = new ExDBFieldString<>("credityuukoukakkekka", this, UserType_C_Yuukoukakkekka.class);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, String> creditkigyoucd = new ExDBFieldString<>("creditkigyoucd", this);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_YuukouKakKekkaSk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
