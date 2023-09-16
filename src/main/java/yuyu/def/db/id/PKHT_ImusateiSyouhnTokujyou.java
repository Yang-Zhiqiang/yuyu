package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.HT_ImusateiSyouhnTokujyou;
import yuyu.def.db.mapping.GenHT_ImusateiSyouhnTokujyou;
import yuyu.def.db.meta.GenQHT_ImusateiSyouhnTokujyou;
import yuyu.def.db.meta.QHT_ImusateiSyouhnTokujyou;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 医務査定商品別特条条件付テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_ImusateiSyouhnTokujyou}</td><td colspan="3">医務査定商品別特条条件付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tknzkkbn</td><td>特約除き区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TknzkKbn C_TknzkKbn}</td></tr>
 *  <tr><td>tumahtnpkbn</td><td>妻不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumahtnpKbn C_TumahtnpKbn}</td></tr>
 *  <tr><td>kohtnpkbn</td><td>子不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KohtnpKbn C_KohtnpKbn}</td></tr>
 *  <tr><td>seigens</td><td>制限Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_ImusateiSyouhnTokujyou
 * @see     GenHT_ImusateiSyouhnTokujyou
 * @see     QHT_ImusateiSyouhnTokujyou
 * @see     GenQHT_ImusateiSyouhnTokujyou
 */
public class PKHT_ImusateiSyouhnTokujyou extends AbstractExDBPrimaryKey<HT_ImusateiSyouhnTokujyou, PKHT_ImusateiSyouhnTokujyou> {

    private static final long serialVersionUID = 1L;

    public PKHT_ImusateiSyouhnTokujyou() {
    }

    public PKHT_ImusateiSyouhnTokujyou(
        String pMosno,
        Integer pRenno,
        String pSyouhncd
    ) {
        mosno = pMosno;
        renno = pRenno;
        syouhncd = pSyouhncd;
    }

    @Transient
    @Override
    public Class<HT_ImusateiSyouhnTokujyou> getEntityClass() {
        return HT_ImusateiSyouhnTokujyou.class;
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
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

}