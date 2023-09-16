package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HyoujyunteigiKbn;

/**
 * {@link C_HyoujyunteigiKbn 標準定義区分} の Hibernate ユーザー定義型です。<br />
 * 標準定義区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HyoujyunteigiKbn extends AbstractUserType<C_HyoujyunteigiKbn> {

    @Override
    protected Class<C_HyoujyunteigiKbn> returnType() {
        return C_HyoujyunteigiKbn.class;
    }

    @Override
    protected C_HyoujyunteigiKbn valueOf(String pValue) {
        return C_HyoujyunteigiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HyoujyunteigiKbn pValue) {
        return pValue.getValue();
    }
}
