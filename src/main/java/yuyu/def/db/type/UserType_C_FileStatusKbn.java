package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FileStatusKbn;

/**
 * {@link C_FileStatusKbn ファイルステータス区分} の Hibernate ユーザー定義型です。<br />
 * ファイルステータス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FileStatusKbn extends AbstractUserType<C_FileStatusKbn> {

    @Override
    protected Class<C_FileStatusKbn> returnType() {
        return C_FileStatusKbn.class;
    }

    @Override
    protected C_FileStatusKbn valueOf(String pValue) {
        return C_FileStatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FileStatusKbn pValue) {
        return pValue.getValue();
    }
}
