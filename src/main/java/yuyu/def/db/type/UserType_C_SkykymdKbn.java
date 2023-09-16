package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkykymdKbn;

/**
 * {@link C_SkykymdKbn 指定契約日区分} の Hibernate ユーザー定義型です。<br />
 * 指定契約日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkykymdKbn extends AbstractUserType<C_SkykymdKbn> {

    @Override
    protected Class<C_SkykymdKbn> returnType() {
        return C_SkykymdKbn.class;
    }

    @Override
    protected C_SkykymdKbn valueOf(String pValue) {
        return C_SkykymdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkykymdKbn pValue) {
        return pValue.getValue();
    }
}
