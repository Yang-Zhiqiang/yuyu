package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TodouhukenKbn;

/**
 * {@link C_TodouhukenKbn 都道府県区分} の Hibernate ユーザー定義型です。<br />
 * 都道府県区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TodouhukenKbn extends AbstractUserType<C_TodouhukenKbn> {

    @Override
    protected Class<C_TodouhukenKbn> returnType() {
        return C_TodouhukenKbn.class;
    }

    @Override
    protected C_TodouhukenKbn valueOf(String pValue) {
        return C_TodouhukenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TodouhukenKbn pValue) {
        return pValue.getValue();
    }
}
