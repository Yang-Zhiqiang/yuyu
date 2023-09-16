package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.mapping.GenJT_Toriatukaifuryouinfo;
import yuyu.def.db.meta.GenQJT_Toriatukaifuryouinfo;
import yuyu.def.db.meta.QJT_Toriatukaifuryouinfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 取扱不良情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Toriatukaifuryouinfo}</td><td colspan="3">取扱不良情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tratkihuryouumukbn</td><td>取扱不良有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>gyousinkaisouyouhikbn</td><td>業審回送要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitYouhiKbn C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>aireqdaityoukisaikbn</td><td>あいリク台帳記載区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitSyorizumiKbn C_NoinitSyorizumiKbn}</td></tr>
 *  <tr><td>tratkihuryoucomment</td><td>取扱不良コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Toriatukaifuryouinfo
 * @see     GenJT_Toriatukaifuryouinfo
 * @see     QJT_Toriatukaifuryouinfo
 * @see     GenQJT_Toriatukaifuryouinfo
 */
public class PKJT_Toriatukaifuryouinfo extends AbstractExDBPrimaryKey<JT_Toriatukaifuryouinfo, PKJT_Toriatukaifuryouinfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_Toriatukaifuryouinfo() {
    }

    public PKJT_Toriatukaifuryouinfo(
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
    public Class<JT_Toriatukaifuryouinfo> getEntityClass() {
        return JT_Toriatukaifuryouinfo.class;
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