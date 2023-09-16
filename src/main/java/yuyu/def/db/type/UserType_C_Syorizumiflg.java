package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syorizumiflg;

/**
 * {@link C_Syorizumiflg 処理済フラグ} の Hibernate ユーザー定義型です。<br />
 * 処理済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syorizumiflg extends AbstractUserType<C_Syorizumiflg> {

    @Override
    protected Class<C_Syorizumiflg> returnType() {
        return C_Syorizumiflg.class;
    }

    @Override
    protected C_Syorizumiflg valueOf(String pValue) {
        return C_Syorizumiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syorizumiflg pValue) {
        return pValue.getValue();
    }
}
