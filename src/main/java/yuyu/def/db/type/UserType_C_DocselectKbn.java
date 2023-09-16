package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DocselectKbn;

/**
 * {@link C_DocselectKbn ドキュメント選択区分} の Hibernate ユーザー定義型です。<br />
 * ドキュメント選択区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DocselectKbn extends AbstractUserType<C_DocselectKbn> {

    @Override
    protected Class<C_DocselectKbn> returnType() {
        return C_DocselectKbn.class;
    }

    @Override
    protected C_DocselectKbn valueOf(String pValue) {
        return C_DocselectKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DocselectKbn pValue) {
        return pValue.getValue();
    }
}
