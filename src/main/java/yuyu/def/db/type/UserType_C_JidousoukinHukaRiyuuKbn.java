package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JidousoukinHukaRiyuuKbn;

/**
 * {@link C_JidousoukinHukaRiyuuKbn 自動送金不可理由区分} の Hibernate ユーザー定義型です。<br />
 * 自動送金不可理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JidousoukinHukaRiyuuKbn extends AbstractUserType<C_JidousoukinHukaRiyuuKbn> {

    @Override
    protected Class<C_JidousoukinHukaRiyuuKbn> returnType() {
        return C_JidousoukinHukaRiyuuKbn.class;
    }

    @Override
    protected C_JidousoukinHukaRiyuuKbn valueOf(String pValue) {
        return C_JidousoukinHukaRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JidousoukinHukaRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
