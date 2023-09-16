package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_JigyouIkkatuHenkin;
import yuyu.def.db.mapping.GenHT_JigyouIkkatuHenkin;
import yuyu.def.db.meta.GenQHT_JigyouIkkatuHenkin;
import yuyu.def.db.meta.QHT_JigyouIkkatuHenkin;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 事業一括返金テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JigyouIkkatuHenkin}</td><td colspan="3">事業一括返金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hnkngk</td><td>返金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hnknhoukbn</td><td>返金方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HnknhouKbn C_HnknhouKbn}</td></tr>
 *  <tr><td>hnknymd</td><td>返金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>srgohnknumu</td><td>成立後返金有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JigyouIkkatuHenkin
 * @see     GenHT_JigyouIkkatuHenkin
 * @see     QHT_JigyouIkkatuHenkin
 * @see     GenQHT_JigyouIkkatuHenkin
 */
public class PKHT_JigyouIkkatuHenkin extends AbstractExDBPrimaryKey<HT_JigyouIkkatuHenkin, PKHT_JigyouIkkatuHenkin> {

    private static final long serialVersionUID = 1L;

    public PKHT_JigyouIkkatuHenkin() {
    }

    public PKHT_JigyouIkkatuHenkin(String pDaimosno, Integer pRenno) {
        daimosno = pDaimosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_JigyouIkkatuHenkin> getEntityClass() {
        return HT_JigyouIkkatuHenkin.class;
    }

    private String daimosno;

    public String getDaimosno() {
        return daimosno;
    }

    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}