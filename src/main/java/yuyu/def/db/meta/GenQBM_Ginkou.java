package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkmKanouihyj;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.db.entity.BM_Ginkou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HrkmKanouihyj;
import yuyu.def.db.type.UserType_C_Kokunaikwskameihyj;

/**
 * 銀行マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Ginkou extends AbstractExDBTable<BM_Ginkou> {

    public GenQBM_Ginkou() {
        this("BM_Ginkou");
    }

    public GenQBM_Ginkou(String pAlias) {
        super("BM_Ginkou", BM_Ginkou.class, pAlias);
    }

    public String BM_Ginkou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Ginkou, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BM_Ginkou, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<BM_Ginkou, BizDate> kousinymd = new ExDBFieldString<>("kousinymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Ginkou, BizDate> sinsetuymd = new ExDBFieldString<>("sinsetuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Ginkou, BizDate> haisiymd = new ExDBFieldString<>("haisiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Ginkou, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<BM_Ginkou, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<BM_Ginkou, String> banknmkj = new ExDBFieldString<>("banknmkj", this);

    public final ExDBFieldString<BM_Ginkou, String> sitennmkj = new ExDBFieldString<>("sitennmkj", this);

    public final ExDBFieldString<BM_Ginkou, String> banknmej = new ExDBFieldString<>("banknmej", this);

    public final ExDBFieldString<BM_Ginkou, String> sitennmej = new ExDBFieldString<>("sitennmej", this);

    public final ExDBFieldString<BM_Ginkou, BizDate> csskyouteikaisiymd = new ExDBFieldString<>("csskyouteikaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Ginkou, BizDate> csskyouteikaijyoymd = new ExDBFieldString<>("csskyouteikaijyoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Ginkou, C_Kokunaikwskameihyj> kokunaikwskameihyj = new ExDBFieldString<>("kokunaikwskameihyj", this, UserType_C_Kokunaikwskameihyj.class);

    public final ExDBFieldString<BM_Ginkou, C_HrkmKanouihyj> hrkmKanouihyj = new ExDBFieldString<>("hrkmKanouihyj", this, UserType_C_HrkmKanouihyj.class);
}
