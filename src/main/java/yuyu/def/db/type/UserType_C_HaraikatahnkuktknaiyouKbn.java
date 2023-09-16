package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaraikatahnkuktknaiyouKbn;

/**
 * {@link C_HaraikatahnkuktknaiyouKbn 払方変更受付内容区分} の Hibernate ユーザー定義型です。<br />
 * 払方変更受付内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaraikatahnkuktknaiyouKbn extends AbstractUserType<C_HaraikatahnkuktknaiyouKbn> {

    @Override
    protected Class<C_HaraikatahnkuktknaiyouKbn> returnType() {
        return C_HaraikatahnkuktknaiyouKbn.class;
    }

    @Override
    protected C_HaraikatahnkuktknaiyouKbn valueOf(String pValue) {
        return C_HaraikatahnkuktknaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaraikatahnkuktknaiyouKbn pValue) {
        return pValue.getValue();
    }
}
