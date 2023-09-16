package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.mapping.GenHT_KykKak;
import yuyu.def.db.meta.GenQHT_KykKak;
import yuyu.def.db.meta.QHT_KykKak;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 契約確認テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KykKak}</td><td colspan="3">契約確認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykkaksyrui</td><td>契約確認種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykkaksyrui C_Kykkaksyrui}</td></tr>
 *  <tr><td>kykkaktantcd</td><td>契約確認担当者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykkakkaisyacd</td><td>契約確認会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykkakiraiymd</td><td>契約確認依頼日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykkakkanytymd</td><td>契約確認完了予定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykkakkekkbn</td><td>契約確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykkakkekKbn C_KykkakkekKbn}</td></tr>
 *  <tr><td>kykkakkanymd</td><td>契約確認完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykkakcomment</td><td>契約確認コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KykKak
 * @see     GenHT_KykKak
 * @see     QHT_KykKak
 * @see     GenQHT_KykKak
 */
public class PKHT_KykKak extends AbstractExDBPrimaryKey<HT_KykKak, PKHT_KykKak> {

    private static final long serialVersionUID = 1L;

    public PKHT_KykKak() {
    }

    public PKHT_KykKak(String pMosno, Integer pRenno) {
        mosno = pMosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_KykKak> getEntityClass() {
        return HT_KykKak.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}