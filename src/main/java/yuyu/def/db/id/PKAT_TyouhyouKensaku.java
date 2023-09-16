package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.mapping.GenAT_TyouhyouKensaku;
import yuyu.def.db.meta.GenQAT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;

/**
 * 帳票検索テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_TyouhyouKensaku}</td><td colspan="3">帳票検索テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>reportKey</td><td>帳票キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>categoryId</td><td>カテゴリＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinouId</td><td>機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey1</td><td>検索キー１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey2</td><td>検索キー２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey3</td><td>検索キー３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey4</td><td>検索キー４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey5</td><td>検索キー５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>firstOutYmd</td><td>初回出力年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastOutYmd</td><td>最終出力年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>outCount</td><td>出力回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lastOutUserId</td><td>最終出力ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiKetugouUmuKbn</td><td>書類結合有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>fileSize</td><td>ファイルサイズ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>pageCount</td><td>ページ数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AT_TyouhyouKensaku
 * @see     GenAT_TyouhyouKensaku
 * @see     QAT_TyouhyouKensaku
 * @see     GenQAT_TyouhyouKensaku
 */
public class PKAT_TyouhyouKensaku extends AbstractExDBPrimaryKey<AT_TyouhyouKensaku, PKAT_TyouhyouKensaku> {

    private static final long serialVersionUID = 1L;

    public PKAT_TyouhyouKensaku() {
    }

    public PKAT_TyouhyouKensaku(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_TyouhyouKensaku> getEntityClass() {
        return AT_TyouhyouKensaku.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}