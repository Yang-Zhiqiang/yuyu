package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SintykKbn;

/**
 * {@link C_SintykKbn 進捗状態区分} の Hibernate ユーザー定義型です。<br />
 * 進捗状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SintykKbn extends AbstractUserType<C_SintykKbn> {

    @Override
    protected Class<C_SintykKbn> returnType() {
        return C_SintykKbn.class;
    }

    @Override
    protected C_SintykKbn valueOf(String pValue) {
        return C_SintykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SintykKbn pValue) {
        return pValue.getValue();
    }
}
