package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyuusyoriKbn;

/**
 * {@link C_TyuusyoriKbn 抽出処理区分} の Hibernate ユーザー定義型です。<br />
 * 抽出処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyuusyoriKbn extends AbstractUserType<C_TyuusyoriKbn> {

    @Override
    protected Class<C_TyuusyoriKbn> returnType() {
        return C_TyuusyoriKbn.class;
    }

    @Override
    protected C_TyuusyoriKbn valueOf(String pValue) {
        return C_TyuusyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyuusyoriKbn pValue) {
        return pValue.getValue();
    }
}
