package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_KokutisyoVrf;
import yuyu.def.db.mapping.GenHT_KokutisyoVrf;
import yuyu.def.db.meta.GenQHT_KokutisyoVrf;
import yuyu.def.db.meta.QHT_KokutisyoVrf;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 告知書ベリファイテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KokutisyoVrf}</td><td colspan="3">告知書ベリファイテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sintyou</td><td>身長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>taijyuu</td><td>体重</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kituenkbn</td><td>喫煙区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KituenKbn C_KituenKbn}</td></tr>
 *  <tr><td>kituenhon</td><td>喫煙本数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kijikbn</td><td>記事区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KijiKbn C_KijiKbn}</td></tr>
 *  <tr><td>kzkkijikbn</td><td>家族記事区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkkijiKbn C_KzkkijiKbn}</td></tr>
 *  <tr><td>hbcmnt</td><td>不備コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KokutisyoVrf
 * @see     GenHT_KokutisyoVrf
 * @see     QHT_KokutisyoVrf
 * @see     GenQHT_KokutisyoVrf
 */
public class PKHT_KokutisyoVrf extends AbstractExDBPrimaryKey<HT_KokutisyoVrf, PKHT_KokutisyoVrf> {

    private static final long serialVersionUID = 1L;

    public PKHT_KokutisyoVrf() {
    }

    public PKHT_KokutisyoVrf(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_KokutisyoVrf> getEntityClass() {
        return HT_KokutisyoVrf.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}