package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Saisateiflg;

/**
 * {@link C_Saisateiflg 再査定フラグ} の Hibernate ユーザー定義型です。<br />
 * 再査定フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Saisateiflg extends AbstractUserType<C_Saisateiflg> {

    @Override
    protected Class<C_Saisateiflg> returnType() {
        return C_Saisateiflg.class;
    }

    @Override
    protected C_Saisateiflg valueOf(String pValue) {
        return C_Saisateiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Saisateiflg pValue) {
        return pValue.getValue();
    }
}
