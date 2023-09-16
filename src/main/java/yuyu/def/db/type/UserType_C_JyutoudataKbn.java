package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JyutoudataKbn;

/**
 * {@link C_JyutoudataKbn 充当データ区分} の Hibernate ユーザー定義型です。<br />
 * 充当データ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JyutoudataKbn extends AbstractUserType<C_JyutoudataKbn> {

    @Override
    protected Class<C_JyutoudataKbn> returnType() {
        return C_JyutoudataKbn.class;
    }

    @Override
    protected C_JyutoudataKbn valueOf(String pValue) {
        return C_JyutoudataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JyutoudataKbn pValue) {
        return pValue.getValue();
    }
}
