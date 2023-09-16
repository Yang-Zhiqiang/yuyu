package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BluegatestatusKbn;

/**
 * {@link C_BluegatestatusKbn ブルーゲートステータス区分} の Hibernate ユーザー定義型です。<br />
 * ブルーゲートステータス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BluegatestatusKbn extends AbstractUserType<C_BluegatestatusKbn> {

    @Override
    protected Class<C_BluegatestatusKbn> returnType() {
        return C_BluegatestatusKbn.class;
    }

    @Override
    protected C_BluegatestatusKbn valueOf(String pValue) {
        return C_BluegatestatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BluegatestatusKbn pValue) {
        return pValue.getValue();
    }
}
