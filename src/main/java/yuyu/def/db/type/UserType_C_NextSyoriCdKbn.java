package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NextSyoriCdKbn;

/**
 * {@link C_NextSyoriCdKbn 遷移先処理コード区分} の Hibernate ユーザー定義型です。<br />
 * 遷移先処理コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NextSyoriCdKbn extends AbstractUserType<C_NextSyoriCdKbn> {

    @Override
    protected Class<C_NextSyoriCdKbn> returnType() {
        return C_NextSyoriCdKbn.class;
    }

    @Override
    protected C_NextSyoriCdKbn valueOf(String pValue) {
        return C_NextSyoriCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NextSyoriCdKbn pValue) {
        return pValue.getValue();
    }
}
