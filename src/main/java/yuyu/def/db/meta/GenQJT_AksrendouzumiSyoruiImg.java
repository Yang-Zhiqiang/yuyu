package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * ＡＫＳ連動済書類情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_AksrendouzumiSyoruiImg extends AbstractExDBTable<JT_AksrendouzumiSyoruiImg> {

    public GenQJT_AksrendouzumiSyoruiImg() {
        this("JT_AksrendouzumiSyoruiImg");
    }

    public GenQJT_AksrendouzumiSyoruiImg(String pAlias) {
        super("JT_AksrendouzumiSyoruiImg", JT_AksrendouzumiSyoruiImg.class, pAlias);
    }

    public String JT_AksrendouzumiSyoruiImg() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, String> imageid = new ExDBFieldString<>("imageid", this);

    public final ExDBFieldNumber<JT_AksrendouzumiSyoruiImg, Integer> syoruiimagepagecnt = new ExDBFieldNumber<>("syoruiimagepagecnt", this);

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, String> aksrendoupdffilenm = new ExDBFieldString<>("aksrendoupdffilenm", this);

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_AksrendouzumiSyoruiImg, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
