package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CommonNyuukinErrorRiyuuKbn;

/**
 * {@link C_CommonNyuukinErrorRiyuuKbn 入金共通処理エラー理由区分} の Hibernate ユーザー定義型です。<br />
 * 入金共通処理エラー理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CommonNyuukinErrorRiyuuKbn extends AbstractUserType<C_CommonNyuukinErrorRiyuuKbn> {

    @Override
    protected Class<C_CommonNyuukinErrorRiyuuKbn> returnType() {
        return C_CommonNyuukinErrorRiyuuKbn.class;
    }

    @Override
    protected C_CommonNyuukinErrorRiyuuKbn valueOf(String pValue) {
        return C_CommonNyuukinErrorRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CommonNyuukinErrorRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
