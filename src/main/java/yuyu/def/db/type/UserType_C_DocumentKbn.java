package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DocumentKbn;

/**
 * {@link C_DocumentKbn ドキュメント区分} の Hibernate ユーザー定義型です。<br />
 * ドキュメント区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DocumentKbn extends AbstractUserType<C_DocumentKbn> {

    @Override
    protected Class<C_DocumentKbn> returnType() {
        return C_DocumentKbn.class;
    }

    @Override
    protected C_DocumentKbn valueOf(String pValue) {
        return C_DocumentKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DocumentKbn pValue) {
        return pValue.getValue();
    }
}
