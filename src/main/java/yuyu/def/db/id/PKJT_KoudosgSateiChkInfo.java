package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_KoudosgSateiChkInfo;
import yuyu.def.db.mapping.GenJT_KoudosgSateiChkInfo;
import yuyu.def.db.meta.GenQJT_KoudosgSateiChkInfo;
import yuyu.def.db.meta.QJT_KoudosgSateiChkInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 高度障害査定チェック情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_KoudosgSateiChkInfo}</td><td colspan="3">高度障害査定チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gengkumukbn</td><td>減額有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>gengkymd</td><td>減額日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gengkcomment</td><td>減額コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skisinouryokuumukbn</td><td>請求意思能力有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>skisinouryokuttdktyuuikbn</td><td>請求意思能力手続注意区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitYouhiKbn C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>skisinouryokucomment</td><td>請求意思能力コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrsakiseikyuusyakbn</td><td>支払先請求者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrsakiSeikyuusyaKbn C_ShrsakiSeikyuusyaKbn}</td></tr>
 *  <tr><td>shrsakicomment</td><td>支払先コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyhkaisyuuyouhiikbn</td><td>給付金回収要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>kyhkaisyuuyouhiicomment</td><td>給付金回収コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>danpozaikeiumukbn</td><td>団保財形有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>danpozaikeicomment</td><td>団保財形コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bengosikenkaiumukbn</td><td>弁護士見解有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>kujyouumukbn</td><td>苦情有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>jimumissumukbn</td><td>事務ミス有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>kyhgksitukaisouyouhikbn</td><td>給付金室回送要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitYouhiKbn C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_KoudosgSateiChkInfo
 * @see     GenJT_KoudosgSateiChkInfo
 * @see     QJT_KoudosgSateiChkInfo
 * @see     GenQJT_KoudosgSateiChkInfo
 */
public class PKJT_KoudosgSateiChkInfo extends AbstractExDBPrimaryKey<JT_KoudosgSateiChkInfo, PKJT_KoudosgSateiChkInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_KoudosgSateiChkInfo() {
    }

    public PKJT_KoudosgSateiChkInfo(
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
    public Class<JT_KoudosgSateiChkInfo> getEntityClass() {
        return JT_KoudosgSateiChkInfo.class;
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