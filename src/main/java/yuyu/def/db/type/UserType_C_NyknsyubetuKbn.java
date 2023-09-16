package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyknsyubetuKbn;

/**
 * {@link C_NyknsyubetuKbn 入金種別区分} の Hibernate ユーザー定義型です。<br />
 * 入金種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyknsyubetuKbn extends AbstractUserType<C_NyknsyubetuKbn> {

    @Override
    protected Class<C_NyknsyubetuKbn> returnType() {
        return C_NyknsyubetuKbn.class;
    }

    @Override
    protected C_NyknsyubetuKbn valueOf(String pValue) {
        return C_NyknsyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyknsyubetuKbn pValue) {
        return pValue.getValue();
    }
}
