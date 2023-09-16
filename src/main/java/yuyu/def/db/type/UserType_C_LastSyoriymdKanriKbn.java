package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;

/**
 * {@link C_LastSyoriymdKanriKbn 最終処理日管理区分} の Hibernate ユーザー定義型です。<br />
 * 最終処理日管理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LastSyoriymdKanriKbn extends AbstractUserType<C_LastSyoriymdKanriKbn> {

    @Override
    protected Class<C_LastSyoriymdKanriKbn> returnType() {
        return C_LastSyoriymdKanriKbn.class;
    }

    @Override
    protected C_LastSyoriymdKanriKbn valueOf(String pValue) {
        return C_LastSyoriymdKanriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LastSyoriymdKanriKbn pValue) {
        return pValue.getValue();
    }
}
