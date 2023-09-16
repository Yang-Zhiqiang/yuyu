package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.mapping.GenAT_TyouhyouHozon;
import yuyu.def.db.meta.GenQAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouHozon;

/**
 * 帳票保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_TyouhyouHozon}</td><td colspan="3">帳票保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getReportKey reportKey}</td><td>帳票キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pdfData</td><td>ＰＤＦデータ</td><td>&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 *  <tr><td>tyouhyouJoinKey</td><td>帳票結合キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>angoukaKbn</td><td>暗号化区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 *  <tr><td>pdfHozonKbn</td><td>ＰＤＦ保存区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 *  <tr><td>zipHozonKbn</td><td>ＺＩＰ保存区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 * </table>
 * @see     AT_TyouhyouHozon
 * @see     GenAT_TyouhyouHozon
 * @see     QAT_TyouhyouHozon
 * @see     GenQAT_TyouhyouHozon
 */
public class PKAT_TyouhyouHozon extends AbstractExDBPrimaryKey<AT_TyouhyouHozon, PKAT_TyouhyouHozon> {

    private static final long serialVersionUID = 1L;

    public PKAT_TyouhyouHozon() {
    }

    public PKAT_TyouhyouHozon(String pReportKey) {
        reportKey = pReportKey;
    }

    @Transient
    @Override
    public Class<AT_TyouhyouHozon> getEntityClass() {
        return AT_TyouhyouHozon.class;
    }

    private String reportKey;

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

}