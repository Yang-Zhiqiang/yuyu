package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.mapping.GenHT_ImusateiRireki;
import yuyu.def.db.meta.GenQHT_ImusateiRireki;
import yuyu.def.db.meta.QHT_ImusateiRireki;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 医務査定履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_ImusateiRireki}</td><td colspan="3">医務査定履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sateiketsyorinmkbn</td><td>査定・決定処理名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SateiketsyorinmKbn C_SateiketsyorinmKbn}</td></tr>
 *  <tr><td>imusateikekkakbn</td><td>医務査定結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>tnsketsyacd</td><td>転送先決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ketsyacd</td><td>決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>imusateicomment</td><td>医務査定コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>sntkinfosakuseiyhkbn</td><td>選択情報作成要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkinfosakuseiyhKbn C_SntkinfosakuseiyhKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_ImusateiRireki
 * @see     GenHT_ImusateiRireki
 * @see     QHT_ImusateiRireki
 * @see     GenQHT_ImusateiRireki
 */
public class PKHT_ImusateiRireki extends AbstractExDBPrimaryKey<HT_ImusateiRireki, PKHT_ImusateiRireki> {

    private static final long serialVersionUID = 1L;

    public PKHT_ImusateiRireki() {
    }

    public PKHT_ImusateiRireki(String pMosno, Integer pRenno) {
        mosno = pMosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_ImusateiRireki> getEntityClass() {
        return HT_ImusateiRireki.class;
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