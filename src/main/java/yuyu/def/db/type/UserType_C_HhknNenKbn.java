package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HhknNenKbn;

/**
 * {@link C_HhknNenKbn 被保険者年齢区分} の Hibernate ユーザー定義型です。<br />
 * 被保険者年齢区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HhknNenKbn extends AbstractUserType<C_HhknNenKbn> {

    @Override
    protected Class<C_HhknNenKbn> returnType() {
        return C_HhknNenKbn.class;
    }

    @Override
    protected C_HhknNenKbn valueOf(String pValue) {
        return C_HhknNenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HhknNenKbn pValue) {
        return pValue.getValue();
    }
}
