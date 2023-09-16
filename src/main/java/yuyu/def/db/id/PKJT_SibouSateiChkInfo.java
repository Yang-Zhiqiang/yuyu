package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.mapping.GenJT_SibouSateiChkInfo;
import yuyu.def.db.meta.GenQJT_SibouSateiChkInfo;
import yuyu.def.db.meta.QJT_SibouSateiChkInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 死亡査定チェック情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SibouSateiChkInfo}</td><td colspan="3">死亡査定チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>bengosikenkaiumukbn</td><td>弁護士見解有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>kujyouumukbn</td><td>苦情有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>jimumissumukbn</td><td>事務ミス有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>kyhgksitukaisouyouhikbn</td><td>給付金室回送要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitYouhiKbn C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SibouSateiChkInfo
 * @see     GenJT_SibouSateiChkInfo
 * @see     QJT_SibouSateiChkInfo
 * @see     GenQJT_SibouSateiChkInfo
 */
public class PKJT_SibouSateiChkInfo extends AbstractExDBPrimaryKey<JT_SibouSateiChkInfo, PKJT_SibouSateiChkInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_SibouSateiChkInfo() {
    }

    public PKJT_SibouSateiChkInfo(
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
    public Class<JT_SibouSateiChkInfo> getEntityClass() {
        return JT_SibouSateiChkInfo.class;
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