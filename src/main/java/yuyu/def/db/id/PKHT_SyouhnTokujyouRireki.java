package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.HT_SyouhnTokujyouRireki;
import yuyu.def.db.mapping.GenHT_SyouhnTokujyouRireki;
import yuyu.def.db.meta.GenQHT_SyouhnTokujyouRireki;
import yuyu.def.db.meta.QHT_SyouhnTokujyouRireki;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 商品別特条条件付履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SyouhnTokujyouRireki}</td><td colspan="3">商品別特条条件付履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDakuhiktrenno dakuhiktrenno}</td><td>諾否決定連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tknzkkbn</td><td>特約除き区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TknzkKbn C_TknzkKbn}</td></tr>
 *  <tr><td>tumahtnpkbn</td><td>妻不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumahtnpKbn C_TumahtnpKbn}</td></tr>
 *  <tr><td>kohtnpkbn</td><td>子不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KohtnpKbn C_KohtnpKbn}</td></tr>
 *  <tr><td>seigens</td><td>制限Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SyouhnTokujyouRireki
 * @see     GenHT_SyouhnTokujyouRireki
 * @see     QHT_SyouhnTokujyouRireki
 * @see     GenQHT_SyouhnTokujyouRireki
 */
public class PKHT_SyouhnTokujyouRireki extends AbstractExDBPrimaryKey<HT_SyouhnTokujyouRireki, PKHT_SyouhnTokujyouRireki> {

    private static final long serialVersionUID = 1L;

    public PKHT_SyouhnTokujyouRireki() {
    }

    public PKHT_SyouhnTokujyouRireki(
        String pMosno,
        Integer pDakuhiktrenno,
        String pSyouhncd
    ) {
        mosno = pMosno;
        dakuhiktrenno = pDakuhiktrenno;
        syouhncd = pSyouhncd;
    }

    @Transient
    @Override
    public Class<HT_SyouhnTokujyouRireki> getEntityClass() {
        return HT_SyouhnTokujyouRireki.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer dakuhiktrenno;

    public Integer getDakuhiktrenno() {
        return dakuhiktrenno;
    }

    public void setDakuhiktrenno(Integer pDakuhiktrenno) {
        dakuhiktrenno = pDakuhiktrenno;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

}