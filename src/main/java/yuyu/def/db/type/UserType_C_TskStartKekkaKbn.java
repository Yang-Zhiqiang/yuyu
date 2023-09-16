package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TskStartKekkaKbn;

/**
 * {@link C_TskStartKekkaKbn タスク開始結果区分} の Hibernate ユーザー定義型です。<br />
 * タスク開始結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TskStartKekkaKbn extends AbstractUserType<C_TskStartKekkaKbn> {

    @Override
    protected Class<C_TskStartKekkaKbn> returnType() {
        return C_TskStartKekkaKbn.class;
    }

    @Override
    protected C_TskStartKekkaKbn valueOf(String pValue) {
        return C_TskStartKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TskStartKekkaKbn pValue) {
        return pValue.getValue();
    }
}
