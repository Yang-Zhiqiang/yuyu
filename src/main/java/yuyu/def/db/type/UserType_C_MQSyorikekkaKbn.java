package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MQSyorikekkaKbn;

/**
 * {@link C_MQSyorikekkaKbn ＭＱ処理結果区分} の Hibernate ユーザー定義型です。<br />
 * ＭＱ処理結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MQSyorikekkaKbn extends AbstractUserType<C_MQSyorikekkaKbn> {

    @Override
    protected Class<C_MQSyorikekkaKbn> returnType() {
        return C_MQSyorikekkaKbn.class;
    }

    @Override
    protected C_MQSyorikekkaKbn valueOf(String pValue) {
        return C_MQSyorikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MQSyorikekkaKbn pValue) {
        return pValue.getValue();
    }
}
