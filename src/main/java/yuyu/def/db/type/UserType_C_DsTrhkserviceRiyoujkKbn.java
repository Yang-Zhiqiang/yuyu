package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;

/**
 * {@link C_DsTrhkserviceRiyoujkKbn ＤＳ取引サービス利用状況区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ取引サービス利用状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsTrhkserviceRiyoujkKbn extends AbstractUserType<C_DsTrhkserviceRiyoujkKbn> {

    @Override
    protected Class<C_DsTrhkserviceRiyoujkKbn> returnType() {
        return C_DsTrhkserviceRiyoujkKbn.class;
    }

    @Override
    protected C_DsTrhkserviceRiyoujkKbn valueOf(String pValue) {
        return C_DsTrhkserviceRiyoujkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsTrhkserviceRiyoujkKbn pValue) {
        return pValue.getValue();
    }
}
