package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.mapping.GenJT_BetukutiSateiInfo;
import yuyu.def.db.meta.GenQJT_BetukutiSateiInfo;
import yuyu.def.db.meta.QJT_BetukutiSateiInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 別口査定情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_BetukutiSateiInfo}</td><td colspan="3">別口査定情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>betusibouumukbn</td><td>別口死亡有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>betusiboucomment</td><td>別口死亡コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>betukdsgumukbn</td><td>別口高度障害有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>betukdsgcomment</td><td>別口高度障害コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>betusoukiumukbn</td><td>別口早期有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>betusoukicomment</td><td>別口早期コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>betusymtkykumukbn</td><td>別口消滅契約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NoinitUmuKbn C_NoinitUmuKbn}</td></tr>
 *  <tr><td>betusymtkykcomment</td><td>別口消滅契約コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_BetukutiSateiInfo
 * @see     GenJT_BetukutiSateiInfo
 * @see     QJT_BetukutiSateiInfo
 * @see     GenQJT_BetukutiSateiInfo
 */
public class PKJT_BetukutiSateiInfo extends AbstractExDBPrimaryKey<JT_BetukutiSateiInfo, PKJT_BetukutiSateiInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_BetukutiSateiInfo() {
    }

    public PKJT_BetukutiSateiInfo(
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
    public Class<JT_BetukutiSateiInfo> getEntityClass() {
        return JT_BetukutiSateiInfo.class;
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