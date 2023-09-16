package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKeiyaku;
import yuyu.def.db.mapping.GenMT_BAK_DsKokyakuKeiyaku;
import yuyu.def.db.meta.GenQMT_BAK_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_BAK_DsKokyakuKeiyaku;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ顧客契約バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_BAK_DsKokyakuKeiyaku}</td><td colspan="3">ＤＳ顧客契約バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskykkanyuuymd</td><td>ＤＳ契約加入年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dskykhenkouymd</td><td>ＤＳ契約変更年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dskykmukouhyj</td><td>ＤＳ契約無効表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MukouHyj C_MukouHyj}</td></tr>
 *  <tr><td>dskykmukouymd</td><td>ＤＳ契約無効年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pplessrenjidssymenttdkhyj</td><td>ペーパーレス連動時ＤＳ書面手続表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSyomenTtdkHyouji C_DsSyomenTtdkHyouji}</td></tr>
 * </table>
 * @see     MT_BAK_DsKokyakuKeiyaku
 * @see     GenMT_BAK_DsKokyakuKeiyaku
 * @see     QMT_BAK_DsKokyakuKeiyaku
 * @see     GenQMT_BAK_DsKokyakuKeiyaku
 */
public class PKMT_BAK_DsKokyakuKeiyaku extends AbstractExDBPrimaryKey<MT_BAK_DsKokyakuKeiyaku, PKMT_BAK_DsKokyakuKeiyaku> {

    private static final long serialVersionUID = 1L;

    public PKMT_BAK_DsKokyakuKeiyaku() {
    }

    public PKMT_BAK_DsKokyakuKeiyaku(
        String pDskokno,
        String pSyono,
        String pTrkssikibetukey
    ) {
        dskokno = pDskokno;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<MT_BAK_DsKokyakuKeiyaku> getEntityClass() {
        return MT_BAK_DsKokyakuKeiyaku.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}