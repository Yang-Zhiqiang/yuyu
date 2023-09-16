package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.db.entity.IT_HrhnCreditCardTouroku;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_CardBrandKbn;

/**
 * 払変クレカ登録テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HrhnCreditCardTouroku extends AbstractExDBTable<IT_HrhnCreditCardTouroku> {

    public GenQIT_HrhnCreditCardTouroku() {
        this("IT_HrhnCreditCardTouroku");
    }

    public GenQIT_HrhnCreditCardTouroku(String pAlias) {
        super("IT_HrhnCreditCardTouroku", IT_HrhnCreditCardTouroku.class, pAlias);
    }

    public String IT_HrhnCreditCardTouroku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, C_AuthorijkKbn> authorijkkbn = new ExDBFieldString<>("authorijkkbn", this, UserType_C_AuthorijkKbn.class);

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, C_CardBrandKbn> cardbrandkbn = new ExDBFieldString<>("cardbrandkbn", this, UserType_C_CardBrandKbn.class);

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, String> creditkaiinnosimo4keta = new ExDBFieldString<>("creditkaiinnosimo4keta", this);

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HrhnCreditCardTouroku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
