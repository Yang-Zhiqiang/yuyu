package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StydatasyouninresultKbn;

/**
 * {@link C_StydatasyouninresultKbn 進捗データ承認結果区分} の Hibernate ユーザー定義型です。<br />
 * 進捗データ承認結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StydatasyouninresultKbn extends AbstractUserType<C_StydatasyouninresultKbn> {

    @Override
    protected Class<C_StydatasyouninresultKbn> returnType() {
        return C_StydatasyouninresultKbn.class;
    }

    @Override
    protected C_StydatasyouninresultKbn valueOf(String pValue) {
        return C_StydatasyouninresultKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StydatasyouninresultKbn pValue) {
        return pValue.getValue();
    }
}
