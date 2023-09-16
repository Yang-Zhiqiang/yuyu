package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UriagesousinKbn;

/**
 * {@link C_UriagesousinKbn 売上送信区分} の Hibernate ユーザー定義型です。<br />
 * 売上送信区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UriagesousinKbn extends AbstractUserType<C_UriagesousinKbn> {

    @Override
    protected Class<C_UriagesousinKbn> returnType() {
        return C_UriagesousinKbn.class;
    }

    @Override
    protected C_UriagesousinKbn valueOf(String pValue) {
        return C_UriagesousinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UriagesousinKbn pValue) {
        return pValue.getValue();
    }
}
