package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkinfosakuseiriyuuKbn;

/**
 * {@link C_SntkinfosakuseiriyuuKbn 選択情報作成理由区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報作成理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkinfosakuseiriyuuKbn extends AbstractUserType<C_SntkinfosakuseiriyuuKbn> {

    @Override
    protected Class<C_SntkinfosakuseiriyuuKbn> returnType() {
        return C_SntkinfosakuseiriyuuKbn.class;
    }

    @Override
    protected C_SntkinfosakuseiriyuuKbn valueOf(String pValue) {
        return C_SntkinfosakuseiriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkinfosakuseiriyuuKbn pValue) {
        return pValue.getValue();
    }
}
