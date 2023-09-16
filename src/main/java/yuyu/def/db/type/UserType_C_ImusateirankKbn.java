package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ImusateirankKbn;

/**
 * {@link C_ImusateirankKbn 医務査定ランク区分} の Hibernate ユーザー定義型です。<br />
 * 医務査定ランク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ImusateirankKbn extends AbstractUserType<C_ImusateirankKbn> {

    @Override
    protected Class<C_ImusateirankKbn> returnType() {
        return C_ImusateirankKbn.class;
    }

    @Override
    protected C_ImusateirankKbn valueOf(String pValue) {
        return C_ImusateirankKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ImusateirankKbn pValue) {
        return pValue.getValue();
    }
}
