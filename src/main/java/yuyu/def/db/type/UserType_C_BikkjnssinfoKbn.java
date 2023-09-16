package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BikkjnssinfoKbn;

/**
 * {@link C_BikkjnssinfoKbn 米国人示唆情報区分} の Hibernate ユーザー定義型です。<br />
 * 米国人示唆情報区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BikkjnssinfoKbn extends AbstractUserType<C_BikkjnssinfoKbn> {

    @Override
    protected Class<C_BikkjnssinfoKbn> returnType() {
        return C_BikkjnssinfoKbn.class;
    }

    @Override
    protected C_BikkjnssinfoKbn valueOf(String pValue) {
        return C_BikkjnssinfoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BikkjnssinfoKbn pValue) {
        return pValue.getValue();
    }
}
