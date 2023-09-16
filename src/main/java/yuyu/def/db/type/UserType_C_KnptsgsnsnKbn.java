package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnptsgsnsnKbn;

/**
 * {@link C_KnptsgsnsnKbn 健保対象外（先進医療）区分} の Hibernate ユーザー定義型です。<br />
 * 健保対象外（先進医療）区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnptsgsnsnKbn extends AbstractUserType<C_KnptsgsnsnKbn> {

    @Override
    protected Class<C_KnptsgsnsnKbn> returnType() {
        return C_KnptsgsnsnKbn.class;
    }

    @Override
    protected C_KnptsgsnsnKbn valueOf(String pValue) {
        return C_KnptsgsnsnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnptsgsnsnKbn pValue) {
        return pValue.getValue();
    }
}
