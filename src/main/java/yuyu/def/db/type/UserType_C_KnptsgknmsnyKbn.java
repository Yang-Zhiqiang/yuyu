package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnptsgknmsnyKbn;

/**
 * {@link C_KnptsgknmsnyKbn 健保対象外（国内未承認薬）区分} の Hibernate ユーザー定義型です。<br />
 * 健保対象外（国内未承認薬）区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnptsgknmsnyKbn extends AbstractUserType<C_KnptsgknmsnyKbn> {

    @Override
    protected Class<C_KnptsgknmsnyKbn> returnType() {
        return C_KnptsgknmsnyKbn.class;
    }

    @Override
    protected C_KnptsgknmsnyKbn valueOf(String pValue) {
        return C_KnptsgknmsnyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnptsgknmsnyKbn pValue) {
        return pValue.getValue();
    }
}
