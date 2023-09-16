package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_KoudosgKeizenChkInfo;
import yuyu.def.db.mapping.GenJT_KoudosgKeizenChkInfo;
import yuyu.def.db.meta.GenQJT_KoudosgKeizenChkInfo;
import yuyu.def.db.meta.QJT_KoudosgKeizenChkInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 高度障害契前チェック情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_KoudosgKeizenChkInfo}</td><td colspan="3">高度障害契前チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>keizencheckkbn1</td><td>契前チェック区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizenchecomment1</td><td>契前チェックコメント１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keizencheckkbn2</td><td>契前チェック区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizenchecomment2</td><td>契前チェックコメント２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keizencheckkbn3</td><td>契前チェック区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizenchecomment3</td><td>契前チェックコメント３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keizencheckkbn4</td><td>契前チェック区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizenchecomment4</td><td>契前チェックコメント４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keizencheckkbn5</td><td>契前チェック区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizenchecomment5</td><td>契前チェックコメント５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keizencheckkbn6</td><td>契前チェック区分６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizenchecomment6</td><td>契前チェックコメント６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_KoudosgKeizenChkInfo
 * @see     GenJT_KoudosgKeizenChkInfo
 * @see     QJT_KoudosgKeizenChkInfo
 * @see     GenQJT_KoudosgKeizenChkInfo
 */
public class PKJT_KoudosgKeizenChkInfo extends AbstractExDBPrimaryKey<JT_KoudosgKeizenChkInfo, PKJT_KoudosgKeizenChkInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_KoudosgKeizenChkInfo() {
    }

    public PKJT_KoudosgKeizenChkInfo(
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
    public Class<JT_KoudosgKeizenChkInfo> getEntityClass() {
        return JT_KoudosgKeizenChkInfo.class;
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