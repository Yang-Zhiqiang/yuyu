package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Menulinkkahi;

/**
 * {@link C_Menulinkkahi メニューリンク可否} の Hibernate ユーザー定義型です。<br />
 * メニューリンク可否 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Menulinkkahi extends AbstractUserType<C_Menulinkkahi> {

    @Override
    protected Class<C_Menulinkkahi> returnType() {
        return C_Menulinkkahi.class;
    }

    @Override
    protected C_Menulinkkahi valueOf(String pValue) {
        return C_Menulinkkahi.valueOf(pValue);
    }

    @Override
    protected String toString(C_Menulinkkahi pValue) {
        return pValue.getValue();
    }
}
