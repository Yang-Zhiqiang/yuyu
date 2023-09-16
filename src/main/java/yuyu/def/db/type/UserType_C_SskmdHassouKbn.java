package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SskmdHassouKbn;

/**
 * {@link C_SskmdHassouKbn 組織窓口用発送区分} の Hibernate ユーザー定義型です。<br />
 * 組織窓口用発送区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SskmdHassouKbn extends AbstractUserType<C_SskmdHassouKbn> {

    @Override
    protected Class<C_SskmdHassouKbn> returnType() {
        return C_SskmdHassouKbn.class;
    }

    @Override
    protected C_SskmdHassouKbn valueOf(String pValue) {
        return C_SskmdHassouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SskmdHassouKbn pValue) {
        return pValue.getValue();
    }
}
