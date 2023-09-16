package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykniyuhenkouKbn;

/**
 * {@link C_KykniyuhenkouKbn 契約内容変更区分} の Hibernate ユーザー定義型です。<br />
 * 契約内容変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykniyuhenkouKbn extends AbstractUserType<C_KykniyuhenkouKbn> {

    @Override
    protected Class<C_KykniyuhenkouKbn> returnType() {
        return C_KykniyuhenkouKbn.class;
    }

    @Override
    protected C_KykniyuhenkouKbn valueOf(String pValue) {
        return C_KykniyuhenkouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykniyuhenkouKbn pValue) {
        return pValue.getValue();
    }
}
