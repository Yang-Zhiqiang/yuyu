package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;
import yuyu.def.db.mapping.GenIT_BAK_KhFBSoukinData;
import yuyu.def.db.meta.GenQIT_BAK_KhFBSoukinData;
import yuyu.def.db.meta.QIT_BAK_KhFBSoukinData;

/**
 * 契約保全ＦＢ送金データバックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhFBSoukinData}</td><td colspan="3">契約保全ＦＢ送金データバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>denrenno</td><td>伝票データ連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>edano</td><td>枝番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>densyskbn</td><td>伝票用システム区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DensysKbn C_DensysKbn}</td></tr>
 *  <tr><td>gyoumucd</td><td>業務コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Gyoumucd C_Gyoumucd}</td></tr>
 *  <tr><td>tantositucd</td><td>担当室コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tantositucd C_Tantositucd}</td></tr>
 *  <tr><td>syoricd</td><td>処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrhousiteikbn</td><td>支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrhousiteiKbn C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukingk</td><td>送金金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>gaikataikagk</td><td>外貨対価額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>soukinkwsrate</td><td>送金用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhFBSoukinData
 * @see     GenIT_BAK_KhFBSoukinData
 * @see     QIT_BAK_KhFBSoukinData
 * @see     GenQIT_BAK_KhFBSoukinData
 */
public class PKIT_BAK_KhFBSoukinData extends AbstractExDBPrimaryKey<IT_BAK_KhFBSoukinData, PKIT_BAK_KhFBSoukinData> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhFBSoukinData() {
    }

    public PKIT_BAK_KhFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey) {
        fbsoukindatasikibetukey = pFbsoukindatasikibetukey;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhFBSoukinData> getEntityClass() {
        return IT_BAK_KhFBSoukinData.class;
    }

    private String fbsoukindatasikibetukey;

    public String getFbsoukindatasikibetukey() {
        return fbsoukindatasikibetukey;
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        fbsoukindatasikibetukey = pFbsoukindatasikibetukey;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}