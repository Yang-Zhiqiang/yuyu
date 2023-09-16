package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.mapping.GenBM_FBSoukinListKanri;
import yuyu.def.db.meta.GenQBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;

/**
 * ＦＢ送金リスト管理マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FBSoukinListKanri}</td><td colspan="3">ＦＢ送金リスト管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantositucd</td><td>担当室コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tantositucd C_Tantositucd}</td></tr>
 *  <tr><td>fbmeisaisyoruicd</td><td>ＦＢ明細書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>gkfbmeisaisyoruicd</td><td>外貨ＦＢ明細書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>fbgoukeisyoruicd</td><td>ＦＢ合計書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>gkfbgoukeisyoruicd</td><td>外貨ＦＢ合計書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 * </table>
 * @see     BM_FBSoukinListKanri
 * @see     GenBM_FBSoukinListKanri
 * @see     QBM_FBSoukinListKanri
 * @see     GenQBM_FBSoukinListKanri
 */
public class PKBM_FBSoukinListKanri extends AbstractExDBPrimaryKey<BM_FBSoukinListKanri, PKBM_FBSoukinListKanri> {

    private static final long serialVersionUID = 1L;

    public PKBM_FBSoukinListKanri() {
    }

    public PKBM_FBSoukinListKanri(String pSyoricd, String pSyorisosikicd) {
        syoricd = pSyoricd;
        syorisosikicd = pSyorisosikicd;
    }

    @Transient
    @Override
    public Class<BM_FBSoukinListKanri> getEntityClass() {
        return BM_FBSoukinListKanri.class;
    }

    private String syoricd;

    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }
    private String syorisosikicd;

    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

}