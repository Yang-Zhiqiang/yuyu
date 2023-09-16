package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;

/**
 * {@link C_TmttknhaibunjyoutaiKbn 積立金配分状態区分} の Hibernate ユーザー定義型です。<br />
 * 積立金配分状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TmttknhaibunjyoutaiKbn extends AbstractUserType<C_TmttknhaibunjyoutaiKbn> {

    @Override
    protected Class<C_TmttknhaibunjyoutaiKbn> returnType() {
        return C_TmttknhaibunjyoutaiKbn.class;
    }

    @Override
    protected C_TmttknhaibunjyoutaiKbn valueOf(String pValue) {
        return C_TmttknhaibunjyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TmttknhaibunjyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
