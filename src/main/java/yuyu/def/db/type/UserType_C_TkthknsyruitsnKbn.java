package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkthknsyruitsnKbn;

/**
 * {@link C_TkthknsyruitsnKbn 特定保険種類通算区分} の Hibernate ユーザー定義型です。<br />
 * 特定保険種類通算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkthknsyruitsnKbn extends AbstractUserType<C_TkthknsyruitsnKbn> {

    @Override
    protected Class<C_TkthknsyruitsnKbn> returnType() {
        return C_TkthknsyruitsnKbn.class;
    }

    @Override
    protected C_TkthknsyruitsnKbn valueOf(String pValue) {
        return C_TkthknsyruitsnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkthknsyruitsnKbn pValue) {
        return pValue.getValue();
    }
}
