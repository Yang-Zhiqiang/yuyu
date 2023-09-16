package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrjkhenkouKbn;

/**
 * {@link C_ShrjkhenkouKbn 支払状況変更区分} の Hibernate ユーザー定義型です。<br />
 * 支払状況変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrjkhenkouKbn extends AbstractUserType<C_ShrjkhenkouKbn> {

    @Override
    protected Class<C_ShrjkhenkouKbn> returnType() {
        return C_ShrjkhenkouKbn.class;
    }

    @Override
    protected C_ShrjkhenkouKbn valueOf(String pValue) {
        return C_ShrjkhenkouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrjkhenkouKbn pValue) {
        return pValue.getValue();
    }
}
