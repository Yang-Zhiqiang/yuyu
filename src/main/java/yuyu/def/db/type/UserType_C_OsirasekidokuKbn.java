package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OsirasekidokuKbn;

/**
 * {@link C_OsirasekidokuKbn お知らせ既読区分} の Hibernate ユーザー定義型です。<br />
 * お知らせ既読区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OsirasekidokuKbn extends AbstractUserType<C_OsirasekidokuKbn> {

    @Override
    protected Class<C_OsirasekidokuKbn> returnType() {
        return C_OsirasekidokuKbn.class;
    }

    @Override
    protected C_OsirasekidokuKbn valueOf(String pValue) {
        return C_OsirasekidokuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OsirasekidokuKbn pValue) {
        return pValue.getValue();
    }
}
