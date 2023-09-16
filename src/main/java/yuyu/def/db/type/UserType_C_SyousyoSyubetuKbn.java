package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyousyoSyubetuKbn;

/**
 * {@link C_SyousyoSyubetuKbn 証書種別区分} の Hibernate ユーザー定義型です。<br />
 * 証書種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyousyoSyubetuKbn extends AbstractUserType<C_SyousyoSyubetuKbn> {

    @Override
    protected Class<C_SyousyoSyubetuKbn> returnType() {
        return C_SyousyoSyubetuKbn.class;
    }

    @Override
    protected C_SyousyoSyubetuKbn valueOf(String pValue) {
        return C_SyousyoSyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyousyoSyubetuKbn pValue) {
        return pValue.getValue();
    }
}
