package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KekkacdKbn;

/**
 * {@link C_KekkacdKbn 処理結果コード区分} の Hibernate ユーザー定義型です。<br />
 * 処理結果コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KekkacdKbn extends AbstractUserType<C_KekkacdKbn> {

    @Override
    protected Class<C_KekkacdKbn> returnType() {
        return C_KekkacdKbn.class;
    }

    @Override
    protected C_KekkacdKbn valueOf(String pValue) {
        return C_KekkacdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KekkacdKbn pValue) {
        return pValue.getValue();
    }
}
