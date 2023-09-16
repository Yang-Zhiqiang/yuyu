package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchDousaModeKbn;

/**
 * {@link C_BatchDousaModeKbn バッチ動作モード区分} の Hibernate ユーザー定義型です。<br />
 * バッチ動作モード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchDousaModeKbn extends AbstractUserType<C_BatchDousaModeKbn> {

    @Override
    protected Class<C_BatchDousaModeKbn> returnType() {
        return C_BatchDousaModeKbn.class;
    }

    @Override
    protected C_BatchDousaModeKbn valueOf(String pValue) {
        return C_BatchDousaModeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchDousaModeKbn pValue) {
        return pValue.getValue();
    }
}
