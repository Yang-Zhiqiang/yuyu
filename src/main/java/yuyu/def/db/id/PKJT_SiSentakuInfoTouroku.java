package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.def.db.mapping.GenJT_SiSentakuInfoTouroku;
import yuyu.def.db.meta.GenQJT_SiSentakuInfoTouroku;
import yuyu.def.db.meta.QJT_SiSentakuInfoTouroku;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金選択情報登録テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiSentakuInfoTouroku}</td><td colspan="3">保険金給付金選択情報登録テーブル</td></tr>
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
 *  <tr><td>kdsssiharaijyoutaikbn</td><td>高度障害Ｓ支払状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdssSiharaiJyoutaiKbn C_KdssSiharaiJyoutaiKbn}</td></tr>
 *  <tr><td>kdsssiharaiymd</td><td>高度障害Ｓ支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kdsymd</td><td>高度障害年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kdssiharaisosikicd</td><td>高度障害支払組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiSentakuInfoTouroku
 * @see     GenJT_SiSentakuInfoTouroku
 * @see     QJT_SiSentakuInfoTouroku
 * @see     GenQJT_SiSentakuInfoTouroku
 */
public class PKJT_SiSentakuInfoTouroku extends AbstractExDBPrimaryKey<JT_SiSentakuInfoTouroku, PKJT_SiSentakuInfoTouroku> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiSentakuInfoTouroku() {
    }

    public PKJT_SiSentakuInfoTouroku(String pSyono, Integer pRenno) {
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<JT_SiSentakuInfoTouroku> getEntityClass() {
        return JT_SiSentakuInfoTouroku.class;
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