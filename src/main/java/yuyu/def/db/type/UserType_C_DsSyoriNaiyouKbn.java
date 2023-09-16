package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;

/**
 * {@link C_DsSyoriNaiyouKbn ＤＳ処理内容区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ処理内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsSyoriNaiyouKbn extends AbstractUserType<C_DsSyoriNaiyouKbn> {

    @Override
    protected Class<C_DsSyoriNaiyouKbn> returnType() {
        return C_DsSyoriNaiyouKbn.class;
    }

    @Override
    protected C_DsSyoriNaiyouKbn valueOf(String pValue) {
        return C_DsSyoriNaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsSyoriNaiyouKbn pValue) {
        return pValue.getValue();
    }
}
