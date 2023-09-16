package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FiSiyouKbn;

/**
 * {@link C_FiSiyouKbn ファンドインデックス使用区分} の Hibernate ユーザー定義型です。<br />
 * ファンドインデックス使用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FiSiyouKbn extends AbstractUserType<C_FiSiyouKbn> {

    @Override
    protected Class<C_FiSiyouKbn> returnType() {
        return C_FiSiyouKbn.class;
    }

    @Override
    protected C_FiSiyouKbn valueOf(String pValue) {
        return C_FiSiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FiSiyouKbn pValue) {
        return pValue.getValue();
    }
}
