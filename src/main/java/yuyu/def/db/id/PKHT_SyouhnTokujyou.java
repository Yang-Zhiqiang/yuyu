package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.HT_SyouhnTokujyou;
import yuyu.def.db.mapping.GenHT_SyouhnTokujyou;
import yuyu.def.db.meta.GenQHT_SyouhnTokujyou;
import yuyu.def.db.meta.QHT_SyouhnTokujyou;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 商品別特条条件付テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SyouhnTokujyou}</td><td colspan="3">商品別特条条件付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tknzkkbn</td><td>特約除き区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TknzkKbn C_TknzkKbn}</td></tr>
 *  <tr><td>tumahtnpkbn</td><td>妻不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumahtnpKbn C_TumahtnpKbn}</td></tr>
 *  <tr><td>kohtnpkbn</td><td>子不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KohtnpKbn C_KohtnpKbn}</td></tr>
 *  <tr><td>seigens</td><td>制限Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SyouhnTokujyou
 * @see     GenHT_SyouhnTokujyou
 * @see     QHT_SyouhnTokujyou
 * @see     GenQHT_SyouhnTokujyou
 */
public class PKHT_SyouhnTokujyou extends AbstractExDBPrimaryKey<HT_SyouhnTokujyou, PKHT_SyouhnTokujyou> {

    private static final long serialVersionUID = 1L;

    public PKHT_SyouhnTokujyou() {
    }

    public PKHT_SyouhnTokujyou(String pMosno, String pSyouhncd) {
        mosno = pMosno;
        syouhncd = pSyouhncd;
    }

    @Transient
    @Override
    public Class<HT_SyouhnTokujyou> getEntityClass() {
        return HT_SyouhnTokujyou.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

}