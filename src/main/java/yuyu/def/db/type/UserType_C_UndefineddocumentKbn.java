package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UndefineddocumentKbn;

/**
 * {@link C_UndefineddocumentKbn 未定義ドキュメント区分} の Hibernate ユーザー定義型です。<br />
 * 未定義ドキュメント区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UndefineddocumentKbn extends AbstractUserType<C_UndefineddocumentKbn> {

    @Override
    protected Class<C_UndefineddocumentKbn> returnType() {
        return C_UndefineddocumentKbn.class;
    }

    @Override
    protected C_UndefineddocumentKbn valueOf(String pValue) {
        return C_UndefineddocumentKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UndefineddocumentKbn pValue) {
        return pValue.getValue();
    }
}
