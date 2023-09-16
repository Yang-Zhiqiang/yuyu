package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.mapping.GenJT_SateiJyuukasituChkInfo;
import yuyu.def.db.meta.GenQJT_SateiJyuukasituChkInfo;
import yuyu.def.db.meta.QJT_SateiJyuukasituChkInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定重過失チェック情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiJyuukasituChkInfo}</td><td colspan="3">査定重過失チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>juukasitucheckkbn1</td><td>重過失チェック区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>juukasitucheckcomment1</td><td>重過失チェックコメント１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>juukasitucheckkbn2</td><td>重過失チェック区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>juukasitucheckcomment2</td><td>重過失チェックコメント２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>juukasitucheckkbn3</td><td>重過失チェック区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>juukasitucheckcomment3</td><td>重過失チェックコメント３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>juukasitucheckkbn4</td><td>重過失チェック区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>juukasitucheckcomment4</td><td>重過失チェックコメント４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiJyuukasituChkInfo
 * @see     GenJT_SateiJyuukasituChkInfo
 * @see     QJT_SateiJyuukasituChkInfo
 * @see     GenQJT_SateiJyuukasituChkInfo
 */
public class PKJT_SateiJyuukasituChkInfo extends AbstractExDBPrimaryKey<JT_SateiJyuukasituChkInfo, PKJT_SateiJyuukasituChkInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_SateiJyuukasituChkInfo() {
    }

    public PKJT_SateiJyuukasituChkInfo(
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
    public Class<JT_SateiJyuukasituChkInfo> getEntityClass() {
        return JT_SateiJyuukasituChkInfo.class;
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