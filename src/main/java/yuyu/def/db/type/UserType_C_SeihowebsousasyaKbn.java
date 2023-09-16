package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeihowebsousasyaKbn;

/**
 * {@link C_SeihowebsousasyaKbn 生保Ｗｅｂ操作者区分} の Hibernate ユーザー定義型です。<br />
 * 生保Ｗｅｂ操作者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeihowebsousasyaKbn extends AbstractUserType<C_SeihowebsousasyaKbn> {

    @Override
    protected Class<C_SeihowebsousasyaKbn> returnType() {
        return C_SeihowebsousasyaKbn.class;
    }

    @Override
    protected C_SeihowebsousasyaKbn valueOf(String pValue) {
        return C_SeihowebsousasyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeihowebsousasyaKbn pValue) {
        return pValue.getValue();
    }
}
