package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_BosKokutisyo;
import yuyu.def.db.mapping.GenHT_BosKokutisyo;
import yuyu.def.db.meta.GenQHT_BosKokutisyo;
import yuyu.def.db.meta.QHT_BosKokutisyo;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集告知書テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosKokutisyo}</td><td colspan="3">募集告知書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sintyou</td><td>身長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>taijyuu</td><td>体重</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kituenkbn</td><td>喫煙区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KituenKbn C_KituenKbn}</td></tr>
 *  <tr><td>kituenhon</td><td>喫煙本数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kijikbn</td><td>記事区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KijiKbn C_KijiKbn}</td></tr>
 *  <tr><td>kzkkijikbn</td><td>家族記事区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkkijiKbn C_KzkkijiKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosKokutisyo
 * @see     GenHT_BosKokutisyo
 * @see     QHT_BosKokutisyo
 * @see     GenQHT_BosKokutisyo
 */
public class PKHT_BosKokutisyo extends AbstractExDBPrimaryKey<HT_BosKokutisyo, PKHT_BosKokutisyo> {

    private static final long serialVersionUID = 1L;

    public PKHT_BosKokutisyo() {
    }

    public PKHT_BosKokutisyo(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_BosKokutisyo> getEntityClass() {
        return HT_BosKokutisyo.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}