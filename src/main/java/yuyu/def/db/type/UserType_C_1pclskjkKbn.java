package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_1pclskjkKbn;

/**
 * {@link C_1pclskjkKbn １ＰＣＬ請求状況区分} の Hibernate ユーザー定義型です。<br />
 * １ＰＣＬ請求状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_1pclskjkKbn extends AbstractUserType<C_1pclskjkKbn> {

    @Override
    protected Class<C_1pclskjkKbn> returnType() {
        return C_1pclskjkKbn.class;
    }

    @Override
    protected C_1pclskjkKbn valueOf(String pValue) {
        return C_1pclskjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_1pclskjkKbn pValue) {
        return pValue.getValue();
    }
}
