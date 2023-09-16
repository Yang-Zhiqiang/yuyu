package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LphteikeitiginKbn;

/**
 * {@link C_LphteikeitiginKbn ＬＰＨ提携地銀区分} の Hibernate ユーザー定義型です。<br />
 * ＬＰＨ提携地銀区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LphteikeitiginKbn extends AbstractUserType<C_LphteikeitiginKbn> {

    @Override
    protected Class<C_LphteikeitiginKbn> returnType() {
        return C_LphteikeitiginKbn.class;
    }

    @Override
    protected C_LphteikeitiginKbn valueOf(String pValue) {
        return C_LphteikeitiginKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LphteikeitiginKbn pValue) {
        return pValue.getValue();
    }
}
