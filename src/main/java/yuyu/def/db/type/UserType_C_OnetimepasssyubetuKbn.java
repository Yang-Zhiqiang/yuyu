package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OnetimepasssyubetuKbn;

/**
 * {@link C_OnetimepasssyubetuKbn ワンタイムパスワード種別区分} の Hibernate ユーザー定義型です。<br />
 * ワンタイムパスワード種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OnetimepasssyubetuKbn extends AbstractUserType<C_OnetimepasssyubetuKbn> {

    @Override
    protected Class<C_OnetimepasssyubetuKbn> returnType() {
        return C_OnetimepasssyubetuKbn.class;
    }

    @Override
    protected C_OnetimepasssyubetuKbn valueOf(String pValue) {
        return C_OnetimepasssyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OnetimepasssyubetuKbn pValue) {
        return pValue.getValue();
    }
}
