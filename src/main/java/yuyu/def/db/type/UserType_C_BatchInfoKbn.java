package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchInfoKbn;

/**
 * {@link C_BatchInfoKbn バッチ情報区分} の Hibernate ユーザー定義型です。<br />
 * バッチ情報区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchInfoKbn extends AbstractUserType<C_BatchInfoKbn> {

    @Override
    protected Class<C_BatchInfoKbn> returnType() {
        return C_BatchInfoKbn.class;
    }

    @Override
    protected C_BatchInfoKbn valueOf(String pValue) {
        return C_BatchInfoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchInfoKbn pValue) {
        return pValue.getValue();
    }
}
