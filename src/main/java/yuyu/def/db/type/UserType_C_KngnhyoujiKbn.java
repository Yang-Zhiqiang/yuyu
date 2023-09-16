package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KngnhyoujiKbn;

/**
 * {@link C_KngnhyoujiKbn 権限表示区分} の Hibernate ユーザー定義型です。<br />
 * 権限表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KngnhyoujiKbn extends AbstractUserType<C_KngnhyoujiKbn> {

    @Override
    protected Class<C_KngnhyoujiKbn> returnType() {
        return C_KngnhyoujiKbn.class;
    }

    @Override
    protected C_KngnhyoujiKbn valueOf(String pValue) {
        return C_KngnhyoujiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KngnhyoujiKbn pValue) {
        return pValue.getValue();
    }
}
