package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StydatasyouninsyoriKbn;

/**
 * {@link C_StydatasyouninsyoriKbn 進捗データ承認処理区分} の Hibernate ユーザー定義型です。<br />
 * 進捗データ承認処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StydatasyouninsyoriKbn extends AbstractUserType<C_StydatasyouninsyoriKbn> {

    @Override
    protected Class<C_StydatasyouninsyoriKbn> returnType() {
        return C_StydatasyouninsyoriKbn.class;
    }

    @Override
    protected C_StydatasyouninsyoriKbn valueOf(String pValue) {
        return C_StydatasyouninsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StydatasyouninsyoriKbn pValue) {
        return pValue.getValue();
    }
}
