package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchModeKbn;

/**
 * {@link C_BatchModeKbn バッチ起動モード区分} の Hibernate ユーザー定義型です。<br />
 * バッチ起動モード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchModeKbn extends AbstractUserType<C_BatchModeKbn> {

    @Override
    protected Class<C_BatchModeKbn> returnType() {
        return C_BatchModeKbn.class;
    }

    @Override
    protected C_BatchModeKbn valueOf(String pValue) {
        return C_BatchModeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchModeKbn pValue) {
        return pValue.getValue();
    }
}
