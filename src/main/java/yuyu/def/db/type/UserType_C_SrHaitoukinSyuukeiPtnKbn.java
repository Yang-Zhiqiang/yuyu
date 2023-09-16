package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn;

/**
 * {@link C_SrHaitoukinSyuukeiPtnKbn 数理配当金集計パターン区分} の Hibernate ユーザー定義型です。<br />
 * 数理配当金集計パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SrHaitoukinSyuukeiPtnKbn extends AbstractUserType<C_SrHaitoukinSyuukeiPtnKbn> {

    @Override
    protected Class<C_SrHaitoukinSyuukeiPtnKbn> returnType() {
        return C_SrHaitoukinSyuukeiPtnKbn.class;
    }

    @Override
    protected C_SrHaitoukinSyuukeiPtnKbn valueOf(String pValue) {
        return C_SrHaitoukinSyuukeiPtnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SrHaitoukinSyuukeiPtnKbn pValue) {
        return pValue.getValue();
    }
}
