package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SdsGizouKaizanInfo;
import yuyu.def.db.mapping.GenJT_SdsGizouKaizanInfo;
import yuyu.def.db.meta.GenQJT_SdsGizouKaizanInfo;
import yuyu.def.db.meta.QJT_SdsGizouKaizanInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 診断書偽造改竄情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SdsGizouKaizanInfo}</td><td colspan="3">診断書偽造改竄情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sindansyogizokaizanumukbn</td><td>診断書偽造改竄有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>sindansyogizokaizanjisikbn</td><td>診断書偽造改竄確認実施区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TelkknKbn C_TelkknKbn}</td></tr>
 *  <tr><td>sindansyogizokaizanriyuu</td><td>診断書偽造改竄理由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SdsGizouKaizanInfo
 * @see     GenJT_SdsGizouKaizanInfo
 * @see     QJT_SdsGizouKaizanInfo
 * @see     GenQJT_SdsGizouKaizanInfo
 */
public class PKJT_SdsGizouKaizanInfo extends AbstractExDBPrimaryKey<JT_SdsGizouKaizanInfo, PKJT_SdsGizouKaizanInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_SdsGizouKaizanInfo() {
    }

    public PKJT_SdsGizouKaizanInfo(
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
    public Class<JT_SdsGizouKaizanInfo> getEntityClass() {
        return JT_SdsGizouKaizanInfo.class;
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