package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchJyoutaiKbn;

/**
 * {@link C_BatchJyoutaiKbn バッチ状態区分} の Hibernate ユーザー定義型です。<br />
 * バッチ状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchJyoutaiKbn extends AbstractUserType<C_BatchJyoutaiKbn> {

    @Override
    protected Class<C_BatchJyoutaiKbn> returnType() {
        return C_BatchJyoutaiKbn.class;
    }

    @Override
    protected C_BatchJyoutaiKbn valueOf(String pValue) {
        return C_BatchJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
