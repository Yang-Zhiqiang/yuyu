package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MousideninKbn;

/**
 * {@link C_MousideninKbn 申出人区分} の Hibernate ユーザー定義型です。<br />
 * 申出人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MousideninKbn extends AbstractUserType<C_MousideninKbn> {

    @Override
    protected Class<C_MousideninKbn> returnType() {
        return C_MousideninKbn.class;
    }

    @Override
    protected C_MousideninKbn valueOf(String pValue) {
        return C_MousideninKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MousideninKbn pValue) {
        return pValue.getValue();
    }
}
