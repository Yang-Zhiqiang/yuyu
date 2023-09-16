package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DirectServiceMosKbn;

/**
 * {@link C_DirectServiceMosKbn ダイレクトサービス申込区分} の Hibernate ユーザー定義型です。<br />
 * ダイレクトサービス申込区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DirectServiceMosKbn extends AbstractUserType<C_DirectServiceMosKbn> {

    @Override
    protected Class<C_DirectServiceMosKbn> returnType() {
        return C_DirectServiceMosKbn.class;
    }

    @Override
    protected C_DirectServiceMosKbn valueOf(String pValue) {
        return C_DirectServiceMosKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DirectServiceMosKbn pValue) {
        return pValue.getValue();
    }
}
