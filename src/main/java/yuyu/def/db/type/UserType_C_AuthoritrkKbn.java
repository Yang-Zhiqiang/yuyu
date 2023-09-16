package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AuthoritrkKbn;

/**
 * {@link C_AuthoritrkKbn オーソリ登録区分} の Hibernate ユーザー定義型です。<br />
 * オーソリ登録区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AuthoritrkKbn extends AbstractUserType<C_AuthoritrkKbn> {

    @Override
    protected Class<C_AuthoritrkKbn> returnType() {
        return C_AuthoritrkKbn.class;
    }

    @Override
    protected C_AuthoritrkKbn valueOf(String pValue) {
        return C_AuthoritrkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AuthoritrkKbn pValue) {
        return pValue.getValue();
    }
}
