package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsnchkptnKbn;

/**
 * {@link C_TsnchkptnKbn 通算チェックパターン区分} の Hibernate ユーザー定義型です。<br />
 * 通算チェックパターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsnchkptnKbn extends AbstractUserType<C_TsnchkptnKbn> {

    @Override
    protected Class<C_TsnchkptnKbn> returnType() {
        return C_TsnchkptnKbn.class;
    }

    @Override
    protected C_TsnchkptnKbn valueOf(String pValue) {
        return C_TsnchkptnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsnchkptnKbn pValue) {
        return pValue.getValue();
    }
}
