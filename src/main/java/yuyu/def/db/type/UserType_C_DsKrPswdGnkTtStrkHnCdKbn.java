package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKrPswdGnkTtStrkHnCdKbn;

/**
 * {@link C_DsKrPswdGnkTtStrkHnCdKbn ＤＳ仮パスワード現況通知出力不能コード区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ仮パスワード現況通知出力不能コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKrPswdGnkTtStrkHnCdKbn extends AbstractUserType<C_DsKrPswdGnkTtStrkHnCdKbn> {

    @Override
    protected Class<C_DsKrPswdGnkTtStrkHnCdKbn> returnType() {
        return C_DsKrPswdGnkTtStrkHnCdKbn.class;
    }

    @Override
    protected C_DsKrPswdGnkTtStrkHnCdKbn valueOf(String pValue) {
        return C_DsKrPswdGnkTtStrkHnCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKrPswdGnkTtStrkHnCdKbn pValue) {
        return pValue.getValue();
    }
}
