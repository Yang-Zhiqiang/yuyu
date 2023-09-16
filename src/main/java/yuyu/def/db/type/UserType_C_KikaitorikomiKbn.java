package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KikaitorikomiKbn;

/**
 * {@link C_KikaitorikomiKbn 機械取込区分} の Hibernate ユーザー定義型です。<br />
 * 機械取込区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KikaitorikomiKbn extends AbstractUserType<C_KikaitorikomiKbn> {

    @Override
    protected Class<C_KikaitorikomiKbn> returnType() {
        return C_KikaitorikomiKbn.class;
    }

    @Override
    protected C_KikaitorikomiKbn valueOf(String pValue) {
        return C_KikaitorikomiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KikaitorikomiKbn pValue) {
        return pValue.getValue();
    }
}
