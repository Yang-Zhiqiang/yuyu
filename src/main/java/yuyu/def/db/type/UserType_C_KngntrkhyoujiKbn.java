package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KngntrkhyoujiKbn;

/**
 * {@link C_KngntrkhyoujiKbn 権限登録表示区分} の Hibernate ユーザー定義型です。<br />
 * 権限登録表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KngntrkhyoujiKbn extends AbstractUserType<C_KngntrkhyoujiKbn> {

    @Override
    protected Class<C_KngntrkhyoujiKbn> returnType() {
        return C_KngntrkhyoujiKbn.class;
    }

    @Override
    protected C_KngntrkhyoujiKbn valueOf(String pValue) {
        return C_KngntrkhyoujiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KngntrkhyoujiKbn pValue) {
        return pValue.getValue();
    }
}
