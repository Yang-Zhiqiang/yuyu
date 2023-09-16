package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyssyorinyKbn;

/**
 * {@link C_NyssyorinyKbn 名寄せ確定処理内容区分} の Hibernate ユーザー定義型です。<br />
 * 名寄せ確定処理内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyssyorinyKbn extends AbstractUserType<C_NyssyorinyKbn> {

    @Override
    protected Class<C_NyssyorinyKbn> returnType() {
        return C_NyssyorinyKbn.class;
    }

    @Override
    protected C_NyssyorinyKbn valueOf(String pValue) {
        return C_NyssyorinyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyssyorinyKbn pValue) {
        return pValue.getValue();
    }
}
