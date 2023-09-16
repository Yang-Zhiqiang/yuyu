package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KijiKbn;

/**
 * {@link C_KijiKbn 記事区分} の Hibernate ユーザー定義型です。<br />
 * 記事区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KijiKbn extends AbstractUserType<C_KijiKbn> {

    @Override
    protected Class<C_KijiKbn> returnType() {
        return C_KijiKbn.class;
    }

    @Override
    protected C_KijiKbn valueOf(String pValue) {
        return C_KijiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KijiKbn pValue) {
        return pValue.getValue();
    }
}
