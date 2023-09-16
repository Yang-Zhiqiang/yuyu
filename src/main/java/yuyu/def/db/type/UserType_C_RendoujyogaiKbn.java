package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RendoujyogaiKbn;

/**
 * {@link C_RendoujyogaiKbn 連動除外区分} の Hibernate ユーザー定義型です。<br />
 * 連動除外区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RendoujyogaiKbn extends AbstractUserType<C_RendoujyogaiKbn> {

    @Override
    protected Class<C_RendoujyogaiKbn> returnType() {
        return C_RendoujyogaiKbn.class;
    }

    @Override
    protected C_RendoujyogaiKbn valueOf(String pValue) {
        return C_RendoujyogaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RendoujyogaiKbn pValue) {
        return pValue.getValue();
    }
}
