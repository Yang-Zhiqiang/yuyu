package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjbnsyubetuKbn;

/**
 * {@link C_KjbnsyubetuKbn 掲示板情報種別区分} の Hibernate ユーザー定義型です。<br />
 * 掲示板情報種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjbnsyubetuKbn extends AbstractUserType<C_KjbnsyubetuKbn> {

    @Override
    protected Class<C_KjbnsyubetuKbn> returnType() {
        return C_KjbnsyubetuKbn.class;
    }

    @Override
    protected C_KjbnsyubetuKbn valueOf(String pValue) {
        return C_KjbnsyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjbnsyubetuKbn pValue) {
        return pValue.getValue();
    }
}
