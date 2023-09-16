package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuseisybetuKbn;

/**
 * {@link C_SakuseisybetuKbn 作成種別区分} の Hibernate ユーザー定義型です。<br />
 * 作成種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuseisybetuKbn extends AbstractUserType<C_SakuseisybetuKbn> {

    @Override
    protected Class<C_SakuseisybetuKbn> returnType() {
        return C_SakuseisybetuKbn.class;
    }

    @Override
    protected C_SakuseisybetuKbn valueOf(String pValue) {
        return C_SakuseisybetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuseisybetuKbn pValue) {
        return pValue.getValue();
    }
}
