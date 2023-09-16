package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykSyubetuKbn;

/**
 * {@link C_KykSyubetuKbn 契約種別区分} の Hibernate ユーザー定義型です。<br />
 * 契約種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykSyubetuKbn extends AbstractUserType<C_KykSyubetuKbn> {

    @Override
    protected Class<C_KykSyubetuKbn> returnType() {
        return C_KykSyubetuKbn.class;
    }

    @Override
    protected C_KykSyubetuKbn valueOf(String pValue) {
        return C_KykSyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykSyubetuKbn pValue) {
        return pValue.getValue();
    }
}
