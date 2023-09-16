package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AngouFukugouKbn;

/**
 * {@link C_AngouFukugouKbn 暗号復号区分} の Hibernate ユーザー定義型です。<br />
 * 暗号復号区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AngouFukugouKbn extends AbstractUserType<C_AngouFukugouKbn> {

    @Override
    protected Class<C_AngouFukugouKbn> returnType() {
        return C_AngouFukugouKbn.class;
    }

    @Override
    protected C_AngouFukugouKbn valueOf(String pValue) {
        return C_AngouFukugouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AngouFukugouKbn pValue) {
        return pValue.getValue();
    }
}
