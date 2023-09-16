package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.mapping.GenHT_DakuhiKettei;
import yuyu.def.db.meta.GenQHT_DakuhiKettei;
import yuyu.def.db.meta.QHT_DakuhiKettei;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 諾否決定テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_DakuhiKettei}</td><td colspan="3">諾否決定テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDakuhiktrenno dakuhiktrenno}</td><td>諾否決定連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ketymd</td><td>決定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dakuhiktbunruikbn</td><td>諾否決定分類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DakuhiktbunruiKbn C_DakuhiktbunruiKbn}</td></tr>
 *  <tr><td>ketkekkacd</td><td>決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketkekkacd C_Ketkekkacd}</td></tr>
 *  <tr><td>ketriyuucd1</td><td>決定理由コード１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>ketriyuucd2</td><td>決定理由コード２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>ketriyuucd3</td><td>決定理由コード３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>ketriyuucd4</td><td>決定理由コード４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>syoubyoucd1</td><td>傷病コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoubyoujyoutaikbn1</td><td>傷病状態区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoubyoujyoutaiKbn C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>kantiym1</td><td>完治年月１</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoubyoucd2</td><td>傷病コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoubyoujyoutaikbn2</td><td>傷病状態区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoubyoujyoutaiKbn C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>kantiym2</td><td>完治年月２</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>ketsyacd</td><td>決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tkjysydkno</td><td>特条承諾番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tkjysydkymd</td><td>特条条件付承諾日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tkjysydksyhykbn</td><td>特条承諾書不要区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkjysydksyhyKbn C_TkjysydksyhyKbn}</td></tr>
 *  <tr><td>sntkinfosakuseiyhkbn</td><td>選択情報作成要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkinfosakuseiyhKbn C_SntkinfosakuseiyhKbn}</td></tr>
 *  <tr><td>mrriyuucdkbn</td><td>ＭＲ理由コード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MrRiyuucdKbn C_MrRiyuucdKbn}</td></tr>
 *  <tr><td>torikesisyousairiyuucd</td><td>取消詳細理由コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TorikesisyousairiyuuCd C_TorikesisyousairiyuuCd}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_DakuhiKettei
 * @see     GenHT_DakuhiKettei
 * @see     QHT_DakuhiKettei
 * @see     GenQHT_DakuhiKettei
 */
public class PKHT_DakuhiKettei extends AbstractExDBPrimaryKey<HT_DakuhiKettei, PKHT_DakuhiKettei> {

    private static final long serialVersionUID = 1L;

    public PKHT_DakuhiKettei() {
    }

    public PKHT_DakuhiKettei(String pMosno, Integer pDakuhiktrenno) {
        mosno = pMosno;
        dakuhiktrenno = pDakuhiktrenno;
    }

    @Transient
    @Override
    public Class<HT_DakuhiKettei> getEntityClass() {
        return HT_DakuhiKettei.class;
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

}