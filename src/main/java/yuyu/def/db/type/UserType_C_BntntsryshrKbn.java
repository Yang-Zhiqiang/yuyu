package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BntntsryshrKbn;

/**
 * {@link C_BntntsryshrKbn 分担手数料支払区分} の Hibernate ユーザー定義型です。<br />
 * 分担手数料支払区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BntntsryshrKbn extends AbstractUserType<C_BntntsryshrKbn> {

    @Override
    protected Class<C_BntntsryshrKbn> returnType() {
        return C_BntntsryshrKbn.class;
    }

    @Override
    protected C_BntntsryshrKbn valueOf(String pValue) {
        return C_BntntsryshrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BntntsryshrKbn pValue) {
        return pValue.getValue();
    }
}
