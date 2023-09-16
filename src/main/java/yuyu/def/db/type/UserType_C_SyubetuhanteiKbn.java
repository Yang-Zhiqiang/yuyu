package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyubetuhanteiKbn;

/**
 * {@link C_SyubetuhanteiKbn 種別判定区分} の Hibernate ユーザー定義型です。<br />
 * 種別判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyubetuhanteiKbn extends AbstractUserType<C_SyubetuhanteiKbn> {

    @Override
    protected Class<C_SyubetuhanteiKbn> returnType() {
        return C_SyubetuhanteiKbn.class;
    }

    @Override
    protected C_SyubetuhanteiKbn valueOf(String pValue) {
        return C_SyubetuhanteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyubetuhanteiKbn pValue) {
        return pValue.getValue();
    }
}
