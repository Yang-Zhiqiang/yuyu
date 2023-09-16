package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NencalckijyunymdKbn;

/**
 * {@link C_NencalckijyunymdKbn 年齢計算基準日区分} の Hibernate ユーザー定義型です。<br />
 * 年齢計算基準日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NencalckijyunymdKbn extends AbstractUserType<C_NencalckijyunymdKbn> {

    @Override
    protected Class<C_NencalckijyunymdKbn> returnType() {
        return C_NencalckijyunymdKbn.class;
    }

    @Override
    protected C_NencalckijyunymdKbn valueOf(String pValue) {
        return C_NencalckijyunymdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NencalckijyunymdKbn pValue) {
        return pValue.getValue();
    }
}
