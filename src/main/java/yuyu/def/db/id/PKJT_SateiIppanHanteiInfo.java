package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.mapping.GenJT_SateiIppanHanteiInfo;
import yuyu.def.db.meta.GenQJT_SateiIppanHanteiInfo;
import yuyu.def.db.meta.QJT_SateiIppanHanteiInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定一般判定情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiIppanHanteiInfo}</td><td colspan="3">査定一般判定情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ippanhanteitensuu1</td><td>一般判定点数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteicomment1</td><td>一般判定コメント１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteitensuu2</td><td>一般判定点数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteicomment2</td><td>一般判定コメント２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteitensuu3</td><td>一般判定点数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteicomment3</td><td>一般判定コメント３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteitensuu4</td><td>一般判定点数４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteicomment4</td><td>一般判定コメント４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteitensuu5</td><td>一般判定点数５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteicomment5</td><td>一般判定コメント５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteitensuu6</td><td>一般判定点数６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteicomment6</td><td>一般判定コメント６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteitensuugoukei</td><td>一般判定点数合計</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ippanhanteigoukeicomment</td><td>一般判定合計コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiIppanHanteiInfo
 * @see     GenJT_SateiIppanHanteiInfo
 * @see     QJT_SateiIppanHanteiInfo
 * @see     GenQJT_SateiIppanHanteiInfo
 */
public class PKJT_SateiIppanHanteiInfo extends AbstractExDBPrimaryKey<JT_SateiIppanHanteiInfo, PKJT_SateiIppanHanteiInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_SateiIppanHanteiInfo() {
    }

    public PKJT_SateiIppanHanteiInfo(
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
    public Class<JT_SateiIppanHanteiInfo> getEntityClass() {
        return JT_SateiIppanHanteiInfo.class;
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