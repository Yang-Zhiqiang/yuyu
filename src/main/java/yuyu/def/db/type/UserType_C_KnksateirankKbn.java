package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnksateirankKbn;

/**
 * {@link C_KnksateirankKbn 環境査定ランク区分} の Hibernate ユーザー定義型です。<br />
 * 環境査定ランク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnksateirankKbn extends AbstractUserType<C_KnksateirankKbn> {

    @Override
    protected Class<C_KnksateirankKbn> returnType() {
        return C_KnksateirankKbn.class;
    }

    @Override
    protected C_KnksateirankKbn valueOf(String pValue) {
        return C_KnksateirankKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnksateirankKbn pValue) {
        return pValue.getValue();
    }
}
