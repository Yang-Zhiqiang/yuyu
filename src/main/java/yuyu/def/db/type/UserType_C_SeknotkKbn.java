package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeknotkKbn;

/**
 * {@link C_SeknotkKbn 設計書番号体系区分} の Hibernate ユーザー定義型です。<br />
 * 設計書番号体系区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeknotkKbn extends AbstractUserType<C_SeknotkKbn> {

    @Override
    protected Class<C_SeknotkKbn> returnType() {
        return C_SeknotkKbn.class;
    }

    @Override
    protected C_SeknotkKbn valueOf(String pValue) {
        return C_SeknotkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeknotkKbn pValue) {
        return pValue.getValue();
    }
}
