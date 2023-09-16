package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkskknsyubetuKbn;

/**
 * {@link C_SkskknsyubetuKbn 親権者後見人種別区分} の Hibernate ユーザー定義型です。<br />
 * 親権者後見人種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkskknsyubetuKbn extends AbstractUserType<C_SkskknsyubetuKbn> {

    @Override
    protected Class<C_SkskknsyubetuKbn> returnType() {
        return C_SkskknsyubetuKbn.class;
    }

    @Override
    protected C_SkskknsyubetuKbn valueOf(String pValue) {
        return C_SkskknsyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkskknsyubetuKbn pValue) {
        return pValue.getValue();
    }
}
