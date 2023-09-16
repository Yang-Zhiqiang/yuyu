package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;

/**
 * {@link C_DsTeisiRiyuuKbn ＤＳ停止理由区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ停止理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsTeisiRiyuuKbn extends AbstractUserType<C_DsTeisiRiyuuKbn> {

    @Override
    protected Class<C_DsTeisiRiyuuKbn> returnType() {
        return C_DsTeisiRiyuuKbn.class;
    }

    @Override
    protected C_DsTeisiRiyuuKbn valueOf(String pValue) {
        return C_DsTeisiRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsTeisiRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
