package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileHozonKikan;
import yuyu.def.db.mapping.GenAS_FileHozonKikan;
import yuyu.def.db.meta.GenQAS_FileHozonKikan;
import yuyu.def.db.meta.QAS_FileHozonKikan;

/**
 * ファイル保存期間基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_FileHozonKikan}</td><td colspan="3">ファイル保存期間基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getFileSyuruiCd fileSyuruiCd}</td><td>ファイル種類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_FileSyuruiCdKbn}</td></tr>
 *  <tr><td>hozonKikan</td><td>保存期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nengappiKbn</td><td>年月日区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NengappiKbn C_NengappiKbn}</td></tr>
 * </table>
 * @see     AS_FileHozonKikan
 * @see     GenAS_FileHozonKikan
 * @see     QAS_FileHozonKikan
 * @see     GenQAS_FileHozonKikan
 */
public class PKAS_FileHozonKikan extends AbstractExDBPrimaryKey<AS_FileHozonKikan, PKAS_FileHozonKikan> {

    private static final long serialVersionUID = 1L;

    public PKAS_FileHozonKikan() {
    }

    public PKAS_FileHozonKikan(C_FileSyuruiCdKbn pFileSyuruiCd) {
        fileSyuruiCd = pFileSyuruiCd;
    }

    @Transient
    @Override
    public Class<AS_FileHozonKikan> getEntityClass() {
        return AS_FileHozonKikan.class;
    }

    private C_FileSyuruiCdKbn fileSyuruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_FileSyuruiCdKbn")
    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return fileSyuruiCd;
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        fileSyuruiCd = pFileSyuruiCd;
    }

}