package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Seibetu;

/**
 * 重度介護前払特約割引期間マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_JyudkaigomebrtkWrbkkkn extends AbstractExDBTable<JM_JyudkaigomebrtkWrbkkkn> {

    public GenQJM_JyudkaigomebrtkWrbkkkn() {
        this("JM_JyudkaigomebrtkWrbkkkn");
    }

    public GenQJM_JyudkaigomebrtkWrbkkkn(String pAlias) {
        super("JM_JyudkaigomebrtkWrbkkkn", JM_JyudkaigomebrtkWrbkkkn.class, pAlias);
    }

    public String JM_JyudkaigomebrtkWrbkkkn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<JM_JyudkaigomebrtkWrbkkkn, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<JM_JyudkaigomebrtkWrbkkkn, C_Seibetu> seibetu = new ExDBFieldString<>("seibetu", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<JM_JyudkaigomebrtkWrbkkkn, BizNumber> waribikikikan = new ExDBFieldString<>("waribikikikan", this, BizNumberType.class);
}
