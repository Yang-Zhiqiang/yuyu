package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkuktsyubetuKbn;

/**
 * {@link C_NkuktsyubetuKbn 年金受取人種別区分} の Hibernate ユーザー定義型です。<br />
 * 年金受取人種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkuktsyubetuKbn extends AbstractUserType<C_NkuktsyubetuKbn> {

    @Override
    protected Class<C_NkuktsyubetuKbn> returnType() {
        return C_NkuktsyubetuKbn.class;
    }

    @Override
    protected C_NkuktsyubetuKbn valueOf(String pValue) {
        return C_NkuktsyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkuktsyubetuKbn pValue) {
        return pValue.getValue();
    }
}
