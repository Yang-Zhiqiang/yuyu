package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkSyoukenSksKbn;

/**
 * {@link C_SkSyoukenSksKbn 新契約証券作成区分} の Hibernate ユーザー定義型です。<br />
 * 新契約証券作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkSyoukenSksKbn extends AbstractUserType<C_SkSyoukenSksKbn> {

    @Override
    protected Class<C_SkSyoukenSksKbn> returnType() {
        return C_SkSyoukenSksKbn.class;
    }

    @Override
    protected C_SkSyoukenSksKbn valueOf(String pValue) {
        return C_SkSyoukenSksKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkSyoukenSksKbn pValue) {
        return pValue.getValue();
    }
}
