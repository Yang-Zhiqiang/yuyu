package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HonninkakKbn;

/**
 * {@link C_HonninkakKbn 法定本人確認区分} の Hibernate ユーザー定義型です。<br />
 * 法定本人確認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HonninkakKbn extends AbstractUserType<C_HonninkakKbn> {

    @Override
    protected Class<C_HonninkakKbn> returnType() {
        return C_HonninkakKbn.class;
    }

    @Override
    protected C_HonninkakKbn valueOf(String pValue) {
        return C_HonninkakKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HonninkakKbn pValue) {
        return pValue.getValue();
    }
}
