package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UnlockResultKbn;

/**
 * {@link C_UnlockResultKbn アンロック結果区分} の Hibernate ユーザー定義型です。<br />
 * アンロック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UnlockResultKbn extends AbstractUserType<C_UnlockResultKbn> {

    @Override
    protected Class<C_UnlockResultKbn> returnType() {
        return C_UnlockResultKbn.class;
    }

    @Override
    protected C_UnlockResultKbn valueOf(String pValue) {
        return C_UnlockResultKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UnlockResultKbn pValue) {
        return pValue.getValue();
    }
}
