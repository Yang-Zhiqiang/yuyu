package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AuthorijkKbn;

/**
 * {@link C_AuthorijkKbn オーソリ状況区分} の Hibernate ユーザー定義型です。<br />
 * オーソリ状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AuthorijkKbn extends AbstractUserType<C_AuthorijkKbn> {

    @Override
    protected Class<C_AuthorijkKbn> returnType() {
        return C_AuthorijkKbn.class;
    }

    @Override
    protected C_AuthorijkKbn valueOf(String pValue) {
        return C_AuthorijkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AuthorijkKbn pValue) {
        return pValue.getValue();
    }
}
