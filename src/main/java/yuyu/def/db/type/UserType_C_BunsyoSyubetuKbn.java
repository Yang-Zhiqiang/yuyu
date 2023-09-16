package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BunsyoSyubetuKbn;

/**
 * {@link C_BunsyoSyubetuKbn 文書種別区分} の Hibernate ユーザー定義型です。<br />
 * 文書種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BunsyoSyubetuKbn extends AbstractUserType<C_BunsyoSyubetuKbn> {

    @Override
    protected Class<C_BunsyoSyubetuKbn> returnType() {
        return C_BunsyoSyubetuKbn.class;
    }

    @Override
    protected C_BunsyoSyubetuKbn valueOf(String pValue) {
        return C_BunsyoSyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BunsyoSyubetuKbn pValue) {
        return pValue.getValue();
    }
}
