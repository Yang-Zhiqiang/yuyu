package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YenShrTkHnkKbn;

/**
 * {@link C_YenShrTkHnkKbn 円支払特約変更区分} の Hibernate ユーザー定義型です。<br />
 * 円支払特約変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YenShrTkHnkKbn extends AbstractUserType<C_YenShrTkHnkKbn> {

    @Override
    protected Class<C_YenShrTkHnkKbn> returnType() {
        return C_YenShrTkHnkKbn.class;
    }

    @Override
    protected C_YenShrTkHnkKbn valueOf(String pValue) {
        return C_YenShrTkHnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YenShrTkHnkKbn pValue) {
        return pValue.getValue();
    }
}
