package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkSyousyoHakkouDosKbn;

/**
 * {@link C_NkSyousyoHakkouDosKbn 年金証書発行ＤＯＳ区分} の Hibernate ユーザー定義型です。<br />
 * 年金証書発行ＤＯＳ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkSyousyoHakkouDosKbn extends AbstractUserType<C_NkSyousyoHakkouDosKbn> {

    @Override
    protected Class<C_NkSyousyoHakkouDosKbn> returnType() {
        return C_NkSyousyoHakkouDosKbn.class;
    }

    @Override
    protected C_NkSyousyoHakkouDosKbn valueOf(String pValue) {
        return C_NkSyousyoHakkouDosKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkSyousyoHakkouDosKbn pValue) {
        return pValue.getValue();
    }
}
