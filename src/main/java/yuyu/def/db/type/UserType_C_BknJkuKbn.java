package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BknJkuKbn;

/**
 * {@link C_BknJkuKbn 備金時効区分} の Hibernate ユーザー定義型です。<br />
 * 備金時効区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BknJkuKbn extends AbstractUserType<C_BknJkuKbn> {

    @Override
    protected Class<C_BknJkuKbn> returnType() {
        return C_BknJkuKbn.class;
    }

    @Override
    protected C_BknJkuKbn valueOf(String pValue) {
        return C_BknJkuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BknJkuKbn pValue) {
        return pValue.getValue();
    }
}
