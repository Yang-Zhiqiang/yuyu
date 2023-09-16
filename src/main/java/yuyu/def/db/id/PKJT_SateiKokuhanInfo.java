package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.mapping.GenJT_SateiKokuhanInfo;
import yuyu.def.db.meta.GenQJT_SateiKokuhanInfo;
import yuyu.def.db.meta.QJT_SateiKokuhanInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定告反情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiKokuhanInfo}</td><td colspan="3">査定告反情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kokuhancheckkbn1</td><td>告反チェック区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment1</td><td>告反チェックコメント１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokuhancheckkbn2</td><td>告反チェック区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment2</td><td>告反チェックコメント２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokuhancheckkbn3</td><td>告反チェック区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment3</td><td>告反チェックコメント３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokuhancheckkbn4</td><td>告反チェック区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment4</td><td>告反チェックコメント４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokuhancheckkbn5</td><td>告反チェック区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment5</td><td>告反チェックコメント５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokuhancheckkbn6</td><td>告反チェック区分６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment6</td><td>告反チェックコメント６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokuhancheckkbn7</td><td>告反チェック区分７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment7</td><td>告反チェックコメント７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokuhancheckkbn8</td><td>告反チェック区分８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokuhanchecomment8</td><td>告反チェックコメント８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiKokuhanInfo
 * @see     GenJT_SateiKokuhanInfo
 * @see     QJT_SateiKokuhanInfo
 * @see     GenQJT_SateiKokuhanInfo
 */
public class PKJT_SateiKokuhanInfo extends AbstractExDBPrimaryKey<JT_SateiKokuhanInfo, PKJT_SateiKokuhanInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_SateiKokuhanInfo() {
    }

    public PKJT_SateiKokuhanInfo(
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
    public Class<JT_SateiKokuhanInfo> getEntityClass() {
        return JT_SateiKokuhanInfo.class;
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