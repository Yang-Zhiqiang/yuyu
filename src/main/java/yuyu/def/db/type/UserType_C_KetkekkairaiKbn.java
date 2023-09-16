package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KetkekkairaiKbn;

/**
 * {@link C_KetkekkairaiKbn 決定結果入力依頼区分} の Hibernate ユーザー定義型です。<br />
 * 決定結果入力依頼区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KetkekkairaiKbn extends AbstractUserType<C_KetkekkairaiKbn> {

    @Override
    protected Class<C_KetkekkairaiKbn> returnType() {
        return C_KetkekkairaiKbn.class;
    }

    @Override
    protected C_KetkekkairaiKbn valueOf(String pValue) {
        return C_KetkekkairaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KetkekkairaiKbn pValue) {
        return pValue.getValue();
    }
}
