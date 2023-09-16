package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DairitenInfoSyoriKbn;

/**
 * {@link C_DairitenInfoSyoriKbn 代理店情報処理区分} の Hibernate ユーザー定義型です。<br />
 * 代理店情報処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DairitenInfoSyoriKbn extends AbstractUserType<C_DairitenInfoSyoriKbn> {

    @Override
    protected Class<C_DairitenInfoSyoriKbn> returnType() {
        return C_DairitenInfoSyoriKbn.class;
    }

    @Override
    protected C_DairitenInfoSyoriKbn valueOf(String pValue) {
        return C_DairitenInfoSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DairitenInfoSyoriKbn pValue) {
        return pValue.getValue();
    }
}
