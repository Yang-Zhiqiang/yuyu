package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;

/**
 * {@link C_SyoubyoujyoutaiKbn 傷病状態区分} の Hibernate ユーザー定義型です。<br />
 * 傷病状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoubyoujyoutaiKbn extends AbstractUserType<C_SyoubyoujyoutaiKbn> {

    @Override
    protected Class<C_SyoubyoujyoutaiKbn> returnType() {
        return C_SyoubyoujyoutaiKbn.class;
    }

    @Override
    protected C_SyoubyoujyoutaiKbn valueOf(String pValue) {
        return C_SyoubyoujyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoubyoujyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
