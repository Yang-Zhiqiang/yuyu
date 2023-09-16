package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_Tokusin;
import yuyu.def.db.mapping.GenIT_BAK_Tokusin;
import yuyu.def.db.meta.GenQIT_BAK_Tokusin;
import yuyu.def.db.meta.QIT_BAK_Tokusin;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 特伸バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_Tokusin}</td><td colspan="3">特伸バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tokusinkbn</td><td>特伸区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusinKbn C_TokusinKbn}</td></tr>
 *  <tr><td>tokusinsyoriymd</td><td>特伸処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hsgymd</td><td>被災害年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tokusinendymd</td><td>特伸終了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_Tokusin
 * @see     GenIT_BAK_Tokusin
 * @see     QIT_BAK_Tokusin
 * @see     GenQIT_BAK_Tokusin
 */
public class PKIT_BAK_Tokusin extends AbstractExDBPrimaryKey<IT_BAK_Tokusin, PKIT_BAK_Tokusin> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_Tokusin() {
    }

    public PKIT_BAK_Tokusin(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_Tokusin> getEntityClass() {
        return IT_BAK_Tokusin.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
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