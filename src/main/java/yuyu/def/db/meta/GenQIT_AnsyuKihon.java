package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_Tkiktannaitukisuu;
import yuyu.def.db.entity.IT_AnsyuKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Kjsmhakkouzumiflg;
import yuyu.def.db.type.UserType_C_Tkiktannaitukisuu;

/**
 * 案内収納基本テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_AnsyuKihon extends AbstractExDBTable<IT_AnsyuKihon> {

    public GenQIT_AnsyuKihon() {
        this("IT_AnsyuKihon");
    }

    public GenQIT_AnsyuKihon(String pAlias) {
        super("IT_AnsyuKihon", IT_AnsyuKihon.class, pAlias);
    }

    public String IT_AnsyuKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_AnsyuKihon, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_AnsyuKihon, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_AnsyuKihon, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_AnsyuKihon, C_Tkiktannaitukisuu> tkiktannaitukisuu = new ExDBFieldString<>("tkiktannaitukisuu", this, UserType_C_Tkiktannaitukisuu.class);

    public final ExDBFieldString<IT_AnsyuKihon, C_Kjsmhakkouzumiflg> kjsmhakkouzumiflg = new ExDBFieldString<>("kjsmhakkouzumiflg", this, UserType_C_Kjsmhakkouzumiflg.class);

    public final ExDBFieldString<IT_AnsyuKihon, BizDate> syuharaimanymd = new ExDBFieldString<>("syuharaimanymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AnsyuKihon, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_AnsyuKihon, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_AnsyuKihon, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
