package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_SosikiMadoguti;
import yuyu.def.db.mapping.GenBM_SosikiMadoguti;
import yuyu.def.db.meta.GenQBM_SosikiMadoguti;
import yuyu.def.db.meta.QBM_SosikiMadoguti;

/**
 * 組織窓口情報マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SosikiMadoguti}</td><td colspan="3">組織窓口情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSskmdsosikicd sskmdsosikicd}</td><td>組織窓口用組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdhassoukbn</td><td>組織窓口用発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SskmdHassouKbn C_SskmdHassouKbn}</td></tr>
 *  <tr><td>sskmdkanjisosikinm</td><td>組織窓口用漢字組織名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdkanjisosikiadr1</td><td>組織窓口用漢字組織住所１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdkanjisosikiadr2</td><td>組織窓口用漢字組織住所２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdkanjisosikiadr3</td><td>組織窓口用漢字組織住所３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdpostalcd</td><td>組織窓口用郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdtelno</td><td>組織窓口用電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdfaxno</td><td>組織窓口用ＦＡＸ番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdsisyaharaidasikznm</td><td>組織窓口用支社払出口座名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdkouzanocd</td><td>組織窓口用口座番号ＣＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdsisyaharaidasikouzano</td><td>組織窓口用支社払出口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sskmdsosikikbnnm</td><td>組織窓口用組織区分名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SosikiMadoguti
 * @see     GenBM_SosikiMadoguti
 * @see     QBM_SosikiMadoguti
 * @see     GenQBM_SosikiMadoguti
 */
public class PKBM_SosikiMadoguti extends AbstractExDBPrimaryKey<BM_SosikiMadoguti, PKBM_SosikiMadoguti> {

    private static final long serialVersionUID = 1L;

    public PKBM_SosikiMadoguti() {
    }

    public PKBM_SosikiMadoguti(String pSskmdsosikicd) {
        sskmdsosikicd = pSskmdsosikicd;
    }

    @Transient
    @Override
    public Class<BM_SosikiMadoguti> getEntityClass() {
        return BM_SosikiMadoguti.class;
    }

    private String sskmdsosikicd;

    public String getSskmdsosikicd() {
        return sskmdsosikicd;
    }

    public void setSskmdsosikicd(String pSskmdsosikicd) {
        sskmdsosikicd = pSskmdsosikicd;
    }

}