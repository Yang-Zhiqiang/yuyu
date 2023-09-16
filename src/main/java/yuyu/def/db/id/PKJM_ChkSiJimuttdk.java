package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;
import yuyu.def.db.mapping.GenJM_ChkSiJimuttdk;
import yuyu.def.db.meta.GenQJM_ChkSiJimuttdk;
import yuyu.def.db.meta.QJM_ChkSiJimuttdk;

/**
 * 支払事務手続チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_ChkSiJimuttdk}</td><td colspan="3">支払事務手続チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyorijimuttdkcd syorijimuttdkcd}</td><td>処理中事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sknaiyouchkkbn</td><td>請求内容チェック区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SKNaiyouChkKbn C_SKNaiyouChkKbn}</td></tr>
 * </table>
 * @see     JM_ChkSiJimuttdk
 * @see     GenJM_ChkSiJimuttdk
 * @see     QJM_ChkSiJimuttdk
 * @see     GenQJM_ChkSiJimuttdk
 */
public class PKJM_ChkSiJimuttdk extends AbstractExDBPrimaryKey<JM_ChkSiJimuttdk, PKJM_ChkSiJimuttdk> {

    private static final long serialVersionUID = 1L;

    public PKJM_ChkSiJimuttdk() {
    }

    public PKJM_ChkSiJimuttdk(String pKinouId, String pSyorijimuttdkcd) {
        kinouId = pKinouId;
        syorijimuttdkcd = pSyorijimuttdkcd;
    }

    @Transient
    @Override
    public Class<JM_ChkSiJimuttdk> getEntityClass() {
        return JM_ChkSiJimuttdk.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private String syorijimuttdkcd;

    public String getSyorijimuttdkcd() {
        return syorijimuttdkcd;
    }

    public void setSyorijimuttdkcd(String pSyorijimuttdkcd) {
        syorijimuttdkcd = pSyorijimuttdkcd;
    }

}