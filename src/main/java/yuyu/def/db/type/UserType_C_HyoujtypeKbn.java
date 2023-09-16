package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HyoujtypeKbn;

/**
 * {@link C_HyoujtypeKbn 表示形式区分} の Hibernate ユーザー定義型です。<br />
 * 表示形式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HyoujtypeKbn extends AbstractUserType<C_HyoujtypeKbn> {

    @Override
    protected Class<C_HyoujtypeKbn> returnType() {
        return C_HyoujtypeKbn.class;
    }

    @Override
    protected C_HyoujtypeKbn valueOf(String pValue) {
        return C_HyoujtypeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HyoujtypeKbn pValue) {
        return pValue.getValue();
    }
}
