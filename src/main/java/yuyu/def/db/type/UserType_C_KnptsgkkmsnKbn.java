package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnptsgkkmsnKbn;

/**
 * {@link C_KnptsgkkmsnKbn 健保対象外（効果未承認）区分} の Hibernate ユーザー定義型です。<br />
 * 健保対象外（効果未承認）区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnptsgkkmsnKbn extends AbstractUserType<C_KnptsgkkmsnKbn> {

    @Override
    protected Class<C_KnptsgkkmsnKbn> returnType() {
        return C_KnptsgkkmsnKbn.class;
    }

    @Override
    protected C_KnptsgkkmsnKbn valueOf(String pValue) {
        return C_KnptsgkkmsnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnptsgkkmsnKbn pValue) {
        return pValue.getValue();
    }
}
