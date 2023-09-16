package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TaimenhitaimenKbn;

/**
 * {@link C_TaimenhitaimenKbn 対面非対面区分} の Hibernate ユーザー定義型です。<br />
 * 対面非対面区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TaimenhitaimenKbn extends AbstractUserType<C_TaimenhitaimenKbn> {

    @Override
    protected Class<C_TaimenhitaimenKbn> returnType() {
        return C_TaimenhitaimenKbn.class;
    }

    @Override
    protected C_TaimenhitaimenKbn valueOf(String pValue) {
        return C_TaimenhitaimenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TaimenhitaimenKbn pValue) {
        return pValue.getValue();
    }
}
