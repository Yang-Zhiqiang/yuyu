package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YendthnkzeimuinfohskKbn;

/**
 * {@link C_YendthnkzeimuinfohskKbn 円建変更時税務情報補足区分} の Hibernate ユーザー定義型です。<br />
 * 円建変更時税務情報補足区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YendthnkzeimuinfohskKbn extends AbstractUserType<C_YendthnkzeimuinfohskKbn> {

    @Override
    protected Class<C_YendthnkzeimuinfohskKbn> returnType() {
        return C_YendthnkzeimuinfohskKbn.class;
    }

    @Override
    protected C_YendthnkzeimuinfohskKbn valueOf(String pValue) {
        return C_YendthnkzeimuinfohskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YendthnkzeimuinfohskKbn pValue) {
        return pValue.getValue();
    }
}
