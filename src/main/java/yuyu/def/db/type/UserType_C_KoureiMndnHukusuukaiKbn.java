package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;

/**
 * {@link C_KoureiMndnHukusuukaiKbn 高齢者面談複数回実施区分} の Hibernate ユーザー定義型です。<br />
 * 高齢者面談複数回実施区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoureiMndnHukusuukaiKbn extends AbstractUserType<C_KoureiMndnHukusuukaiKbn> {

    @Override
    protected Class<C_KoureiMndnHukusuukaiKbn> returnType() {
        return C_KoureiMndnHukusuukaiKbn.class;
    }

    @Override
    protected C_KoureiMndnHukusuukaiKbn valueOf(String pValue) {
        return C_KoureiMndnHukusuukaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoureiMndnHukusuukaiKbn pValue) {
        return pValue.getValue();
    }
}
