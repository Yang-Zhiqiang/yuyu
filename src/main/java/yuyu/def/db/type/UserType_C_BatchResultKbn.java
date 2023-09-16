package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchResultKbn;

/**
 * {@link C_BatchResultKbn バッチ結果区分} の Hibernate ユーザー定義型です。<br />
 * バッチ結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchResultKbn extends AbstractUserType<C_BatchResultKbn> {

    @Override
    protected Class<C_BatchResultKbn> returnType() {
        return C_BatchResultKbn.class;
    }

    @Override
    protected C_BatchResultKbn valueOf(String pValue) {
        return C_BatchResultKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchResultKbn pValue) {
        return pValue.getValue();
    }
}
