package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;

/**
 * {@link C_JydkgmbHkKsnKbn 重度介護前払保険金計算区分} の Hibernate ユーザー定義型です。<br />
 * 重度介護前払保険金計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JydkgmbHkKsnKbn extends AbstractUserType<C_JydkgmbHkKsnKbn> {

    @Override
    protected Class<C_JydkgmbHkKsnKbn> returnType() {
        return C_JydkgmbHkKsnKbn.class;
    }

    @Override
    protected C_JydkgmbHkKsnKbn valueOf(String pValue) {
        return C_JydkgmbHkKsnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JydkgmbHkKsnKbn pValue) {
        return pValue.getValue();
    }
}
