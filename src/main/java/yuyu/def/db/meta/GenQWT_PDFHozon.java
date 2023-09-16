package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_PDFHozon;

/**
 * ＰＤＦ保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_PDFHozon extends AbstractExDBTable<WT_PDFHozon> {

    public GenQWT_PDFHozon() {
        this("WT_PDFHozon");
    }

    public GenQWT_PDFHozon(String pAlias) {
        super("WT_PDFHozon", WT_PDFHozon.class, pAlias);
    }

    public String WT_PDFHozon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_PDFHozon, String> iwfImageId = new ExDBFieldString<>("iwfImageId", this);

    public final ExDBFieldString<WT_PDFHozon, String> pageId = new ExDBFieldString<>("pageId", this);

    public final ExDBFieldString<WT_PDFHozon, byte[]> pdfData = new ExDBFieldString<>("pdfData", this);
}
