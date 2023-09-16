package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * {@link C_YouhiblnkKbn ブランク付要否区分} の Hibernate ユーザー定義型です。<br />
 * ブランク付要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YouhiblnkKbn extends AbstractUserType<C_YouhiblnkKbn> {

    @Override
    protected Class<C_YouhiblnkKbn> returnType() {
        return C_YouhiblnkKbn.class;
    }

    @Override
    protected C_YouhiblnkKbn valueOf(String pValue) {
        return C_YouhiblnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YouhiblnkKbn pValue) {
        return pValue.getValue();
    }
}
