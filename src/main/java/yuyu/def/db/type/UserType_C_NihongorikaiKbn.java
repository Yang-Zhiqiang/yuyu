package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NihongorikaiKbn;

/**
 * {@link C_NihongorikaiKbn 日本語理解力区分} の Hibernate ユーザー定義型です。<br />
 * 日本語理解力区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NihongorikaiKbn extends AbstractUserType<C_NihongorikaiKbn> {

    @Override
    protected Class<C_NihongorikaiKbn> returnType() {
        return C_NihongorikaiKbn.class;
    }

    @Override
    protected C_NihongorikaiKbn valueOf(String pValue) {
        return C_NihongorikaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NihongorikaiKbn pValue) {
        return pValue.getValue();
    }
}
