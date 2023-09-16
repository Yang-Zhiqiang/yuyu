package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchKidouKbn;

/**
 * {@link C_BatchKidouKbn バッチ起動区分} の Hibernate ユーザー定義型です。<br />
 * バッチ起動区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchKidouKbn extends AbstractUserType<C_BatchKidouKbn> {

    @Override
    protected Class<C_BatchKidouKbn> returnType() {
        return C_BatchKidouKbn.class;
    }

    @Override
    protected C_BatchKidouKbn valueOf(String pValue) {
        return C_BatchKidouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchKidouKbn pValue) {
        return pValue.getValue();
    }
}
