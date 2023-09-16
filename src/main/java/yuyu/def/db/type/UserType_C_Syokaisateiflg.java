package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syokaisateiflg;

/**
 * {@link C_Syokaisateiflg 初回査定フラグ} の Hibernate ユーザー定義型です。<br />
 * 初回査定フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syokaisateiflg extends AbstractUserType<C_Syokaisateiflg> {

    @Override
    protected Class<C_Syokaisateiflg> returnType() {
        return C_Syokaisateiflg.class;
    }

    @Override
    protected C_Syokaisateiflg valueOf(String pValue) {
        return C_Syokaisateiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syokaisateiflg pValue) {
        return pValue.getValue();
    }
}
