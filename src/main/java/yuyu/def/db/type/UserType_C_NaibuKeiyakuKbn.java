package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NaibuKeiyakuKbn;

/**
 * {@link C_NaibuKeiyakuKbn 内部契約区分} の Hibernate ユーザー定義型です。<br />
 * 内部契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NaibuKeiyakuKbn extends AbstractUserType<C_NaibuKeiyakuKbn> {

    @Override
    protected Class<C_NaibuKeiyakuKbn> returnType() {
        return C_NaibuKeiyakuKbn.class;
    }

    @Override
    protected C_NaibuKeiyakuKbn valueOf(String pValue) {
        return C_NaibuKeiyakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NaibuKeiyakuKbn pValue) {
        return pValue.getValue();
    }
}
