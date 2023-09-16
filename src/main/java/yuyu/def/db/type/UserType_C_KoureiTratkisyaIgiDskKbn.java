package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;

/**
 * {@link C_KoureiTratkisyaIgiDskKbn 高齢者取扱者以外同席区分} の Hibernate ユーザー定義型です。<br />
 * 高齢者取扱者以外同席区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoureiTratkisyaIgiDskKbn extends AbstractUserType<C_KoureiTratkisyaIgiDskKbn> {

    @Override
    protected Class<C_KoureiTratkisyaIgiDskKbn> returnType() {
        return C_KoureiTratkisyaIgiDskKbn.class;
    }

    @Override
    protected C_KoureiTratkisyaIgiDskKbn valueOf(String pValue) {
        return C_KoureiTratkisyaIgiDskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoureiTratkisyaIgiDskKbn pValue) {
        return pValue.getValue();
    }
}
