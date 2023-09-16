package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Teihen;

/**
 * {@link C_Teihen 定額変額区分} の Hibernate ユーザー定義型です。<br />
 * 定額変額区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Teihen extends AbstractUserType<C_Teihen> {

    @Override
    protected Class<C_Teihen> returnType() {
        return C_Teihen.class;
    }

    @Override
    protected C_Teihen valueOf(String pValue) {
        return C_Teihen.valueOf(pValue);
    }

    @Override
    protected String toString(C_Teihen pValue) {
        return pValue.getValue();
    }
}
