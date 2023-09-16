package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MultidousaKbn;

/**
 * {@link C_MultidousaKbn マルチ照会動作区分} の Hibernate ユーザー定義型です。<br />
 * マルチ照会動作区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MultidousaKbn extends AbstractUserType<C_MultidousaKbn> {

    @Override
    protected Class<C_MultidousaKbn> returnType() {
        return C_MultidousaKbn.class;
    }

    @Override
    protected C_MultidousaKbn valueOf(String pValue) {
        return C_MultidousaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MultidousaKbn pValue) {
        return pValue.getValue();
    }
}
