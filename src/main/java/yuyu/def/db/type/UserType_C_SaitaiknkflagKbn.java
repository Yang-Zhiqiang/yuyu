package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaitaiknkflagKbn;

/**
 * {@link C_SaitaiknkflagKbn 災対環境フラグ区分} の Hibernate ユーザー定義型です。<br />
 * 災対環境フラグ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaitaiknkflagKbn extends AbstractUserType<C_SaitaiknkflagKbn> {

    @Override
    protected Class<C_SaitaiknkflagKbn> returnType() {
        return C_SaitaiknkflagKbn.class;
    }

    @Override
    protected C_SaitaiknkflagKbn valueOf(String pValue) {
        return C_SaitaiknkflagKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaitaiknkflagKbn pValue) {
        return pValue.getValue();
    }
}
