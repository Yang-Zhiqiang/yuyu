package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KettuutilistyhKbn;

/**
 * {@link C_KettuutilistyhKbn 決定通知リスト要否区分} の Hibernate ユーザー定義型です。<br />
 * 決定通知リスト要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KettuutilistyhKbn extends AbstractUserType<C_KettuutilistyhKbn> {

    @Override
    protected Class<C_KettuutilistyhKbn> returnType() {
        return C_KettuutilistyhKbn.class;
    }

    @Override
    protected C_KettuutilistyhKbn valueOf(String pValue) {
        return C_KettuutilistyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KettuutilistyhKbn pValue) {
        return pValue.getValue();
    }
}
