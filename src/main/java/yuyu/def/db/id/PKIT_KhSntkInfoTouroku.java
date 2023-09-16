package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.mapping.GenIT_KhSntkInfoTouroku;
import yuyu.def.db.meta.GenQIT_KhSntkInfoTouroku;
import yuyu.def.db.meta.QIT_KhSntkInfoTouroku;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全選択情報登録テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhSntkInfoTouroku}</td><td colspan="3">契約保全選択情報登録テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>huho2kykno</td><td>普保Ⅱ契約番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>huho2kyknokbn</td><td>普保Ⅱ契約番号区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Huho2kyknoKbn C_Huho2kyknoKbn}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sntkinfokankeisyakbn</td><td>選択情報関係者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KankeisyaKbn C_KankeisyaKbn}</td></tr>
 *  <tr><td>taisyounmkn</td><td>対象者氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taisyounmkj</td><td>対象者氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taisyouseiymd</td><td>対象者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>taisyouseibetu</td><td>対象者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>dakuhiketnaiyouumukbn</td><td>諾否決定内容有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>kktnaiyouumukbn</td><td>告知内容有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>kijinaiyouumukbn</td><td>記事内容有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>mrumukbn</td><td>ＭＲ有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>koudosyougaiumukbn</td><td>高度障害有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>torikaijoumukbn</td><td>取消解除有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>seiritukbn</td><td>成立区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeirituKbn C_SeirituKbn}</td></tr>
 *  <tr><td>deckbn</td><td>ＤＥＣ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DecKbn C_DecKbn}</td></tr>
 *  <tr><td>ketymd</td><td>決定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ketkekkacd</td><td>決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketkekkacd C_Ketkekkacd}</td></tr>
 *  <tr><td>ketriyuucd1</td><td>決定理由コード１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>ketriyuucd2</td><td>決定理由コード２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>ketriyuucd3</td><td>決定理由コード３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>ketriyuucd4</td><td>決定理由コード４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketriyuucd C_Ketriyuucd}</td></tr>
 *  <tr><td>ketsyacd</td><td>決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sintyou</td><td>身長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>taijyuu</td><td>体重</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoubyoucd1</td><td>傷病コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoubyoujyoutaikbn1</td><td>傷病状態区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoubyoujyoutaiKbn C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>kantiym1</td><td>完治年月１</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoubyoucd2</td><td>傷病コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoubyoujyoutaikbn2</td><td>傷病状態区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoubyoujyoutaiKbn C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>kantiym2</td><td>完治年月２</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>mrriyuucdkbn</td><td>ＭＲ理由コード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MrRiyuucdKbn C_MrRiyuucdKbn}</td></tr>
 *  <tr><td>sntkinfokyktorikesikbn</td><td>選択情報用契約取消処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkInfoKykTorikesiKbn C_SntkInfoKykTorikesiKbn}</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhSntkInfoTouroku
 * @see     GenIT_KhSntkInfoTouroku
 * @see     QIT_KhSntkInfoTouroku
 * @see     GenQIT_KhSntkInfoTouroku
 */
public class PKIT_KhSntkInfoTouroku extends AbstractExDBPrimaryKey<IT_KhSntkInfoTouroku, PKIT_KhSntkInfoTouroku> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhSntkInfoTouroku() {
    }

    public PKIT_KhSntkInfoTouroku(String pSyono, Integer pRenno) {
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_KhSntkInfoTouroku> getEntityClass() {
        return IT_KhSntkInfoTouroku.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}