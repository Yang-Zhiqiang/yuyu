package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;

/**
 * {@link C_DseisansouhusakihnsyuKbn Ｄ精算送付先編集区分} の Hibernate ユーザー定義型です。<br />
 * Ｄ精算送付先編集区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DseisansouhusakihnsyuKbn extends AbstractUserType<C_DseisansouhusakihnsyuKbn> {

    @Override
    protected Class<C_DseisansouhusakihnsyuKbn> returnType() {
        return C_DseisansouhusakihnsyuKbn.class;
    }

    @Override
    protected C_DseisansouhusakihnsyuKbn valueOf(String pValue) {
        return C_DseisansouhusakihnsyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DseisansouhusakihnsyuKbn pValue) {
        return pValue.getValue();
    }
}
