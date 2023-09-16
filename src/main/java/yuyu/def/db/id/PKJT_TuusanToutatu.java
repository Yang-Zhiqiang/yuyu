package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_TuusanToutatu;
import yuyu.def.db.mapping.GenJT_TuusanToutatu;
import yuyu.def.db.meta.GenQJT_TuusanToutatu;
import yuyu.def.db.meta.QJT_TuusanToutatu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 通算到達テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_TuusanToutatu}</td><td colspan="3">通算到達テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyhgndkatakbn</td><td>給付限度型区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno</td><td>契約商品連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_TuusanToutatu
 * @see     GenJT_TuusanToutatu
 * @see     QJT_TuusanToutatu
 * @see     GenQJT_TuusanToutatu
 */
public class PKJT_TuusanToutatu extends AbstractExDBPrimaryKey<JT_TuusanToutatu, PKJT_TuusanToutatu> {

    private static final long serialVersionUID = 1L;

    public PKJT_TuusanToutatu() {
    }

    public PKJT_TuusanToutatu(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        String pKyuuhucd
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
        kyuuhucd = pKyuuhucd;
    }

    @Transient
    @Override
    public Class<JT_TuusanToutatu> getEntityClass() {
        return JT_TuusanToutatu.class;
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
    private String kyuuhucd;

    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }

}