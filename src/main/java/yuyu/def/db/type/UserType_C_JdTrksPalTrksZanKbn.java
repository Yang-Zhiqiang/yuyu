package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;

/**
 * {@link C_JdTrksPalTrksZanKbn 自動取消用ＰＡＬ取消残区分} の Hibernate ユーザー定義型です。<br />
 * 自動取消用ＰＡＬ取消残区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JdTrksPalTrksZanKbn extends AbstractUserType<C_JdTrksPalTrksZanKbn> {

    @Override
    protected Class<C_JdTrksPalTrksZanKbn> returnType() {
        return C_JdTrksPalTrksZanKbn.class;
    }

    @Override
    protected C_JdTrksPalTrksZanKbn valueOf(String pValue) {
        return C_JdTrksPalTrksZanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JdTrksPalTrksZanKbn pValue) {
        return pValue.getValue();
    }
}
