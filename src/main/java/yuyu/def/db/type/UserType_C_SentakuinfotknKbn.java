package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SentakuinfotknKbn;

/**
 * {@link C_SentakuinfotknKbn 選択情報特認区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SentakuinfotknKbn extends AbstractUserType<C_SentakuinfotknKbn> {

    @Override
    protected Class<C_SentakuinfotknKbn> returnType() {
        return C_SentakuinfotknKbn.class;
    }

    @Override
    protected C_SentakuinfotknKbn valueOf(String pValue) {
        return C_SentakuinfotknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SentakuinfotknKbn pValue) {
        return pValue.getValue();
    }
}
