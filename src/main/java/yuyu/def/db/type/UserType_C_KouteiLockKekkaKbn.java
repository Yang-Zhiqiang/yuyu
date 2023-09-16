package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouteiLockKekkaKbn;

/**
 * {@link C_KouteiLockKekkaKbn 工程ロック結果区分} の Hibernate ユーザー定義型です。<br />
 * 工程ロック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouteiLockKekkaKbn extends AbstractUserType<C_KouteiLockKekkaKbn> {

    @Override
    protected Class<C_KouteiLockKekkaKbn> returnType() {
        return C_KouteiLockKekkaKbn.class;
    }

    @Override
    protected C_KouteiLockKekkaKbn valueOf(String pValue) {
        return C_KouteiLockKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouteiLockKekkaKbn pValue) {
        return pValue.getValue();
    }
}
