package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakujyoKbn;

/**
 * {@link C_SakujyoKbn 削除区分} の Hibernate ユーザー定義型です。<br />
 * 削除区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakujyoKbn extends AbstractUserType<C_SakujyoKbn> {

    @Override
    protected Class<C_SakujyoKbn> returnType() {
        return C_SakujyoKbn.class;
    }

    @Override
    protected C_SakujyoKbn valueOf(String pValue) {
        return C_SakujyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakujyoKbn pValue) {
        return pValue.getValue();
    }
}
