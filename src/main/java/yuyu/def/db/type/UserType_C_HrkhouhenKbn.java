package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrkhouhenKbn;

/**
 * {@link C_HrkhouhenKbn 払方変更内容区分} の Hibernate ユーザー定義型です。<br />
 * 払方変更内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrkhouhenKbn extends AbstractUserType<C_HrkhouhenKbn> {

    @Override
    protected Class<C_HrkhouhenKbn> returnType() {
        return C_HrkhouhenKbn.class;
    }

    @Override
    protected C_HrkhouhenKbn valueOf(String pValue) {
        return C_HrkhouhenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrkhouhenKbn pValue) {
        return pValue.getValue();
    }
}
