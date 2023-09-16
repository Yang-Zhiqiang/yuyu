package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OsiraseinjihuyouKbn;

/**
 * {@link C_OsiraseinjihuyouKbn お知らせ印字不要区分} の Hibernate ユーザー定義型です。<br />
 * お知らせ印字不要区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OsiraseinjihuyouKbn extends AbstractUserType<C_OsiraseinjihuyouKbn> {

    @Override
    protected Class<C_OsiraseinjihuyouKbn> returnType() {
        return C_OsiraseinjihuyouKbn.class;
    }

    @Override
    protected C_OsiraseinjihuyouKbn valueOf(String pValue) {
        return C_OsiraseinjihuyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OsiraseinjihuyouKbn pValue) {
        return pValue.getValue();
    }
}
