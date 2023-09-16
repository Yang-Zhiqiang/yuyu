package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DenshrhouKbn;

/**
 * {@link C_DenshrhouKbn 伝票用支払方法区分} の Hibernate ユーザー定義型です。<br />
 * 伝票用支払方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DenshrhouKbn extends AbstractUserType<C_DenshrhouKbn> {

    @Override
    protected Class<C_DenshrhouKbn> returnType() {
        return C_DenshrhouKbn.class;
    }

    @Override
    protected C_DenshrhouKbn valueOf(String pValue) {
        return C_DenshrhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DenshrhouKbn pValue) {
        return pValue.getValue();
    }
}
