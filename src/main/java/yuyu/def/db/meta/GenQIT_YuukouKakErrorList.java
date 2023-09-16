package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Yuukoukakkekka;

/**
 * 有効確認エラーリストテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_YuukouKakErrorList extends AbstractExDBTable<IT_YuukouKakErrorList> {

    public GenQIT_YuukouKakErrorList() {
        this("IT_YuukouKakErrorList");
    }

    public GenQIT_YuukouKakErrorList(String pAlias) {
        super("IT_YuukouKakErrorList", IT_YuukouKakErrorList.class, pAlias);
    }

    public String IT_YuukouKakErrorList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_YuukouKakErrorList, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_YuukouKakErrorList, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_YuukouKakErrorList, BizDateYM> syoriym = new ExDBFieldString<>("syoriym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_YuukouKakErrorList, BizDateYM> credityuukoukakym = new ExDBFieldString<>("credityuukoukakym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_YuukouKakErrorList, C_Yuukoukakkekka> credityuukoukakkekka = new ExDBFieldString<>("credityuukoukakkekka", this, UserType_C_Yuukoukakkekka.class);

    public final ExDBFieldString<IT_YuukouKakErrorList, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_YuukouKakErrorList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_YuukouKakErrorList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
