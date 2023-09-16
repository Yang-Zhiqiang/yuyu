package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.mapping.GenHT_SentakuJyouhou;
import yuyu.def.db.meta.GenQHT_SentakuJyouhou;
import yuyu.def.db.meta.QHT_SentakuJyouhou;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 選択情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SentakuJyouhou}</td><td colspan="3">選択情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSntkinfotaisyousyakbn sntkinfotaisyousyakbn}</td><td>選択情報対象者区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SntkInfoTaisyousyaKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSntkinfono sntkinfono}</td><td>選択情報番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syscdkbn</td><td>システムコード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysCdKbn C_SysCdKbn}</td></tr>
 *  <tr><td>sntkinfokankeisyakbn</td><td>選択情報関係者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KankeisyaKbn C_KankeisyaKbn}</td></tr>
 *  <tr><td>sntkinfofkojinkbn</td><td>選択情報Ｆ個人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sntkinfokbn</td><td>選択情報区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkinfoKbn C_SntkinfoKbn}</td></tr>
 *  <tr><td>sntkinfosakuseiymd</td><td>選択情報作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mrumukbn</td><td>ＭＲ有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>decumukbn</td><td>ＤＥＣ有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>infokoukanumukbn</td><td>情報交換有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>nyuuinkyhkshrumukbn</td><td>入院給付金支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>syujyutukyhkshrumukbn</td><td>手術給付金支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>syougaikyhkshrumukbn</td><td>障害給付金支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>koudosyougaiumukbn</td><td>高度障害有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>pmenumukbn</td><td>Ｐ免有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>torikaijoumukbn</td><td>取消解除有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>soukikeakyhkshrumukbn</td><td>早期ケア給付金支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>sonotakyhkshrumukbn</td><td>その他給付金支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>kghsjjtkyhkshrumukbn</td><td>介護保障充実給付金支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>huho2mrumukbn</td><td>普保ⅡＭＲ有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>huho2decumukbn</td><td>普保ⅡＤＥＣ有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>huho2kdumukbn</td><td>普保Ⅱ高度障害有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>huho2torikaijoumukbn</td><td>普保Ⅱ取消解除有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SentakuJyouhou
 * @see     GenHT_SentakuJyouhou
 * @see     QHT_SentakuJyouhou
 * @see     GenQHT_SentakuJyouhou
 */
public class PKHT_SentakuJyouhou extends AbstractExDBPrimaryKey<HT_SentakuJyouhou, PKHT_SentakuJyouhou> {

    private static final long serialVersionUID = 1L;

    public PKHT_SentakuJyouhou() {
    }

    public PKHT_SentakuJyouhou(
        String pMosno,
        C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,
        Integer pEdano,
        String pSntkinfono
    ) {
        mosno = pMosno;
        sntkinfotaisyousyakbn = pSntkinfotaisyousyakbn;
        edano = pEdano;
        sntkinfono = pSntkinfono;
    }

    @Transient
    @Override
    public Class<HT_SentakuJyouhou> getEntityClass() {
        return HT_SentakuJyouhou.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private C_SntkInfoTaisyousyaKbn sntkinfotaisyousyakbn;

    @org.hibernate.annotations.Type(type="UserType_C_SntkInfoTaisyousyaKbn")
    public C_SntkInfoTaisyousyaKbn getSntkinfotaisyousyakbn() {
        return sntkinfotaisyousyakbn;
    }

    public void setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn) {
        sntkinfotaisyousyakbn = pSntkinfotaisyousyakbn;
    }
    private Integer edano;

    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }
    private String sntkinfono;

    public String getSntkinfono() {
        return sntkinfono;
    }

    public void setSntkinfono(String pSntkinfono) {
        sntkinfono = pSntkinfono;
    }

}