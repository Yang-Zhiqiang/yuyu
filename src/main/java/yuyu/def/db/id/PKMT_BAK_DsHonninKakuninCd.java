package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_BAK_DsHonninKakuninCd;
import yuyu.def.db.mapping.GenMT_BAK_DsHonninKakuninCd;
import yuyu.def.db.meta.GenQMT_BAK_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_BAK_DsHonninKakuninCd;

/**
 * ＤＳ本人確認コードバックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_BAK_DsHonninKakuninCd}</td><td colspan="3">ＤＳ本人確認コードバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskrhnnkakcd</td><td>ＤＳ仮本人確認コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskrhnnkakcdsetkbn</td><td>ＤＳ仮本人確認コード設定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsKrHnnKakCdSetKbn C_DsKrHnnKakCdSetKbn}</td></tr>
 *  <tr><td>dskrhnnkakcdsetymd</td><td>ＤＳ仮本人確認コード設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dskrhnnkakcdyuukouymd</td><td>ＤＳ仮本人確認コード有効年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dshnnkakcd</td><td>ＤＳ本人確認コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dshnnkakcdsetymd</td><td>ＤＳ本人確認コード設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zenkaidskrhnnkakcd</td><td>前回ＤＳ仮本人確認コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskrhnnkakcdttshjyhsymd</td><td>ＤＳ仮本人確認コード通知送付事由発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dskrhnnkakcdttyhkbn</td><td>ＤＳ仮本人確認コード通知要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn C_DsKrHnnKakCdTtYhKbn}</td></tr>
 *  <tr><td>dskrhnnkakcdtttydnjykbn</td><td>ＤＳ仮本人確認コード通知中断事由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn C_DsKrHnnKakCdTtTydnJyKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_BAK_DsHonninKakuninCd
 * @see     GenMT_BAK_DsHonninKakuninCd
 * @see     QMT_BAK_DsHonninKakuninCd
 * @see     GenQMT_BAK_DsHonninKakuninCd
 */
public class PKMT_BAK_DsHonninKakuninCd extends AbstractExDBPrimaryKey<MT_BAK_DsHonninKakuninCd, PKMT_BAK_DsHonninKakuninCd> {

    private static final long serialVersionUID = 1L;

    public PKMT_BAK_DsHonninKakuninCd() {
    }

    public PKMT_BAK_DsHonninKakuninCd(String pDskokno, String pTrkssikibetukey) {
        dskokno = pDskokno;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<MT_BAK_DsHonninKakuninCd> getEntityClass() {
        return MT_BAK_DsHonninKakuninCd.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}