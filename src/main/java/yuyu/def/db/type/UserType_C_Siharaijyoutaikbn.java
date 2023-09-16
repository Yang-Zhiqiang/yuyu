package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Siharaijyoutaikbn;

/**
 * {@link C_Siharaijyoutaikbn 支払状態区分} の Hibernate ユーザー定義型です。<br />
 * 支払状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Siharaijyoutaikbn extends AbstractUserType<C_Siharaijyoutaikbn> {

    @Override
    protected Class<C_Siharaijyoutaikbn> returnType() {
        return C_Siharaijyoutaikbn.class;
    }

    @Override
    protected C_Siharaijyoutaikbn valueOf(String pValue) {
        return C_Siharaijyoutaikbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Siharaijyoutaikbn pValue) {
        return pValue.getValue();
    }
}
