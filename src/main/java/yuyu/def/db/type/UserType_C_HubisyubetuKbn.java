package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubisyubetuKbn;

/**
 * {@link C_HubisyubetuKbn 不備種別区分} の Hibernate ユーザー定義型です。<br />
 * 不備種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubisyubetuKbn extends AbstractUserType<C_HubisyubetuKbn> {

    @Override
    protected Class<C_HubisyubetuKbn> returnType() {
        return C_HubisyubetuKbn.class;
    }

    @Override
    protected C_HubisyubetuKbn valueOf(String pValue) {
        return C_HubisyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubisyubetuKbn pValue) {
        return pValue.getValue();
    }
}
