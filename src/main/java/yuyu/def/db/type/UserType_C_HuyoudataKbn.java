package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HuyoudataKbn;

/**
 * {@link C_HuyoudataKbn 不要データ区分} の Hibernate ユーザー定義型です。<br />
 * 不要データ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HuyoudataKbn extends AbstractUserType<C_HuyoudataKbn> {

    @Override
    protected Class<C_HuyoudataKbn> returnType() {
        return C_HuyoudataKbn.class;
    }

    @Override
    protected C_HuyoudataKbn valueOf(String pValue) {
        return C_HuyoudataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HuyoudataKbn pValue) {
        return pValue.getValue();
    }
}
