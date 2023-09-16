package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * {@link C_ResultCdKbn 結果コード区分} の Hibernate ユーザー定義型です。<br />
 * 結果コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ResultCdKbn extends AbstractUserType<C_ResultCdKbn> {

    @Override
    protected Class<C_ResultCdKbn> returnType() {
        return C_ResultCdKbn.class;
    }

    @Override
    protected C_ResultCdKbn valueOf(String pValue) {
        return C_ResultCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ResultCdKbn pValue) {
        return pValue.getValue();
    }
}
