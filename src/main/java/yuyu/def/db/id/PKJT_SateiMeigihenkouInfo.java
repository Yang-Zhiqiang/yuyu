package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.mapping.GenJT_SateiMeigihenkouInfo;
import yuyu.def.db.meta.GenQJT_SateiMeigihenkouInfo;
import yuyu.def.db.meta.QJT_SateiMeigihenkouInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定名義変更情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiMeigihenkouInfo}</td><td colspan="3">査定名義変更情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>meihenyuukoumukoukbn</td><td>名義変更有効無効区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MeihenYuukouMukouKbn C_MeihenYuukouMukouKbn}</td></tr>
 *  <tr><td>meihenuktkbn</td><td>名義変更受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MeihenUktKbn C_MeihenUktKbn}</td></tr>
 *  <tr><td>meihenuktnm</td><td>名義変更受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiMeigihenkouInfo
 * @see     GenJT_SateiMeigihenkouInfo
 * @see     QJT_SateiMeigihenkouInfo
 * @see     GenQJT_SateiMeigihenkouInfo
 */
public class PKJT_SateiMeigihenkouInfo extends AbstractExDBPrimaryKey<JT_SateiMeigihenkouInfo, PKJT_SateiMeigihenkouInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_SateiMeigihenkouInfo() {
    }

    public PKJT_SateiMeigihenkouInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
    }

    @Transient
    @Override
    public Class<JT_SateiMeigihenkouInfo> getEntityClass() {
        return JT_SateiMeigihenkouInfo.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer seikyuurirekino;

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

}