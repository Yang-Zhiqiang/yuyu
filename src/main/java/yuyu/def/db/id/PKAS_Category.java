package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.mapping.GenAS_Category;
import yuyu.def.db.meta.GenQAS_Category;
import yuyu.def.db.meta.QAS_Category;

/**
 * カテゴリ基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Category}</td><td colspan="3">カテゴリ基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getCategoryId categoryId}</td><td>カテゴリＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>categoryNm</td><td>カテゴリ名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linkImage</td><td>リンクイメージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>titleStyle</td><td>タイトルスタイル</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_Category
 * @see     GenAS_Category
 * @see     QAS_Category
 * @see     GenQAS_Category
 */
public class PKAS_Category extends AbstractExDBPrimaryKey<AS_Category, PKAS_Category> {

    private static final long serialVersionUID = 1L;

    public PKAS_Category() {
    }

    public PKAS_Category(String pCategoryId) {
        categoryId = pCategoryId;
    }

    @Transient
    @Override
    public Class<AS_Category> getEntityClass() {
        return AS_Category.class;
    }

    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String pCategoryId) {
        categoryId = pCategoryId;
    }

}