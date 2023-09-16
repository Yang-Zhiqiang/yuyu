package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitoumeisaiKbn;

/**
 * {@link C_HaitoumeisaiKbn 配当明細区分} の Hibernate ユーザー定義型です。<br />
 * 配当明細区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitoumeisaiKbn extends AbstractUserType<C_HaitoumeisaiKbn> {

    @Override
    protected Class<C_HaitoumeisaiKbn> returnType() {
        return C_HaitoumeisaiKbn.class;
    }

    @Override
    protected C_HaitoumeisaiKbn valueOf(String pValue) {
        return C_HaitoumeisaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitoumeisaiKbn pValue) {
        return pValue.getValue();
    }
}
