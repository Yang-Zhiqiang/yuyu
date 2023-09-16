package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_InfostdrskKbn;

/**
 * {@link C_InfostdrskKbn 情報系指定代理請求人区分} の Hibernate ユーザー定義型です。<br />
 * 情報系指定代理請求人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_InfostdrskKbn extends AbstractUserType<C_InfostdrskKbn> {

    @Override
    protected Class<C_InfostdrskKbn> returnType() {
        return C_InfostdrskKbn.class;
    }

    @Override
    protected C_InfostdrskKbn valueOf(String pValue) {
        return C_InfostdrskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_InfostdrskKbn pValue) {
        return pValue.getValue();
    }
}
