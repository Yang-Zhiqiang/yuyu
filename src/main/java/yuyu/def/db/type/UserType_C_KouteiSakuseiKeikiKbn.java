package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouteiSakuseiKeikiKbn;

/**
 * {@link C_KouteiSakuseiKeikiKbn 工程作成契機区分} の Hibernate ユーザー定義型です。<br />
 * 工程作成契機区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouteiSakuseiKeikiKbn extends AbstractUserType<C_KouteiSakuseiKeikiKbn> {

    @Override
    protected Class<C_KouteiSakuseiKeikiKbn> returnType() {
        return C_KouteiSakuseiKeikiKbn.class;
    }

    @Override
    protected C_KouteiSakuseiKeikiKbn valueOf(String pValue) {
        return C_KouteiSakuseiKeikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouteiSakuseiKeikiKbn pValue) {
        return pValue.getValue();
    }
}
