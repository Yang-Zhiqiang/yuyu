package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrhkjiKakKbn;

/**
 * {@link C_TrhkjiKakKbn 取引時確認区分} の Hibernate ユーザー定義型です。<br />
 * 取引時確認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrhkjiKakKbn extends AbstractUserType<C_TrhkjiKakKbn> {

    @Override
    protected Class<C_TrhkjiKakKbn> returnType() {
        return C_TrhkjiKakKbn.class;
    }

    @Override
    protected C_TrhkjiKakKbn valueOf(String pValue) {
        return C_TrhkjiKakKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrhkjiKakKbn pValue) {
        return pValue.getValue();
    }
}
