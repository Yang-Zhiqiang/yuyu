package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * {@link C_TkiktbrisyuruiKbn 定期一括払種類区分} の Hibernate ユーザー定義型です。<br />
 * 定期一括払種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkiktbrisyuruiKbn extends AbstractUserType<C_TkiktbrisyuruiKbn> {

    @Override
    protected Class<C_TkiktbrisyuruiKbn> returnType() {
        return C_TkiktbrisyuruiKbn.class;
    }

    @Override
    protected C_TkiktbrisyuruiKbn valueOf(String pValue) {
        return C_TkiktbrisyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkiktbrisyuruiKbn pValue) {
        return pValue.getValue();
    }
}
