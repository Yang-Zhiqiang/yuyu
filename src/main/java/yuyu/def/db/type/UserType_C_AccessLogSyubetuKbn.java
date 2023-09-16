package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AccessLogSyubetuKbn;

/**
 * {@link C_AccessLogSyubetuKbn アクセスログ種別区分} の Hibernate ユーザー定義型です。<br />
 * アクセスログ種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AccessLogSyubetuKbn extends AbstractUserType<C_AccessLogSyubetuKbn> {

    @Override
    protected Class<C_AccessLogSyubetuKbn> returnType() {
        return C_AccessLogSyubetuKbn.class;
    }

    @Override
    protected C_AccessLogSyubetuKbn valueOf(String pValue) {
        return C_AccessLogSyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AccessLogSyubetuKbn pValue) {
        return pValue.getValue();
    }
}
