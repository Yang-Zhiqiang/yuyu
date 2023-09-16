package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BunkatuHouhouKbn;

/**
 * {@link C_BunkatuHouhouKbn 分割方法区分} の Hibernate ユーザー定義型です。<br />
 * 分割方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BunkatuHouhouKbn extends AbstractUserType<C_BunkatuHouhouKbn> {

    @Override
    protected Class<C_BunkatuHouhouKbn> returnType() {
        return C_BunkatuHouhouKbn.class;
    }

    @Override
    protected C_BunkatuHouhouKbn valueOf(String pValue) {
        return C_BunkatuHouhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BunkatuHouhouKbn pValue) {
        return pValue.getValue();
    }
}
