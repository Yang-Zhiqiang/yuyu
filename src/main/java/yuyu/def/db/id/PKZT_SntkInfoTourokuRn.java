package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SntkInfoTourokuRn;
import yuyu.def.db.mapping.GenZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.GenQZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.QZT_SntkInfoTourokuRn;

/**
 * 選択情報登録テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoTourokuRn}</td><td colspan="3">選択情報登録テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsntkinfono zrnsntkinfono}</td><td>（連携用）選択情報番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenno zrnrenno}</td><td>（連携用）連番</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsntkinfotourokusyskbn zrnsntkinfotourokusyskbn}</td><td>（連携用）選択情報登録システム区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoriymd</td><td>（連携用）処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhuho2kyknokbn</td><td>（連携用）普保Ⅱ契約番号区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhuho2kykno</td><td>（連携用）普保Ⅱ契約番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouhncd</td><td>（連携用）商品コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfofsegkbn</td><td>（連携用）選択情報ＦＳＥＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfofkojinkbn</td><td>（連携用）選択情報Ｆ個人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntaisyounm</td><td>（連携用）対象者姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtaisyounm</td><td>（連携用）対象者漢字姓名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntaisyouseiymd</td><td>（連携用）対象者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntaisyouseibetu</td><td>（連携用）対象者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketnaiyouarihyj</td><td>（連携用）諾否決定内容有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkktnaiyouarihyj</td><td>（連携用）告知内容有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkijinaiyouarihyj</td><td>（連携用）記事内容有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrarihyj</td><td>（連携用）ＭＲ有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkoudosyougaiarihyj</td><td>（連携用）高度障害有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntorikaijoarihyj</td><td>（連携用）取消解除有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskhuseirituhyouji</td><td>（連携用）新契約不成立表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotourokuyobi01</td><td>（連携用）選択情報登録予備０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndeckbn</td><td>（連携用）ＤＥＣ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketymd</td><td>（連携用）決定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketkekkacd</td><td>（連携用）決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketriyuucd1</td><td>（連携用）決定理由コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketriyuucd2</td><td>（連携用）決定理由コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketriyuucd3</td><td>（連携用）決定理由コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketriyuucd4</td><td>（連携用）決定理由コード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketsyacd</td><td>（連携用）決定者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotourokuyobi02</td><td>（連携用）選択情報登録予備０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfosintyou</td><td>（連携用）選択情報身長</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotaijyuu</td><td>（連携用）選択情報体重</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokutiymd</td><td>（連携用）告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotourokuyobi03</td><td>（連携用）選択情報登録予備０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoubyoucd1</td><td>（連携用）傷病コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkantiym1</td><td>（連携用）完治年月１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoubyoucd2</td><td>（連携用）傷病コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkantiym2</td><td>（連携用）完治年月２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotourokuyobi04</td><td>（連携用）選択情報登録予備０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrriyuucdkbn</td><td>（連携用）ＭＲ理由コード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotourokuyobi05</td><td>（連携用）選択情報登録予備０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfokyktorikesikbn</td><td>（連携用）選択情報用契約取消処理区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotourokuyobi06</td><td>（連携用）選択情報登録予備０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkdsssiharaijyoutaikbn</td><td>（連携用）高度障害Ｓ支払状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkdsssiharaiymd</td><td>（連携用）高度障害Ｓ支払年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkdsymd</td><td>（連携用）高度障害年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkdssiharaisosikicd</td><td>（連携用）高度障害支払組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfotourokuyobi07</td><td>（連携用）選択情報登録予備０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoTourokuRn
 * @see     GenZT_SntkInfoTourokuRn
 * @see     QZT_SntkInfoTourokuRn
 * @see     GenQZT_SntkInfoTourokuRn
 */
public class PKZT_SntkInfoTourokuRn extends AbstractExDBPrimaryKey<ZT_SntkInfoTourokuRn, PKZT_SntkInfoTourokuRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SntkInfoTourokuRn() {
    }

    public PKZT_SntkInfoTourokuRn(
        String pZrnsntkinfono,
        String pZrnrenno,
        String pZrnsntkinfotourokusyskbn
    ) {
        zrnsntkinfono = pZrnsntkinfono;
        zrnrenno = pZrnrenno;
        zrnsntkinfotourokusyskbn = pZrnsntkinfotourokusyskbn;
    }

    @Transient
    @Override
    public Class<ZT_SntkInfoTourokuRn> getEntityClass() {
        return ZT_SntkInfoTourokuRn.class;
    }

    private String zrnsntkinfono;

    public String getZrnsntkinfono() {
        return zrnsntkinfono;
    }

    public void setZrnsntkinfono(String pZrnsntkinfono) {
        zrnsntkinfono = pZrnsntkinfono;
    }
    private String zrnrenno;

    public String getZrnrenno() {
        return zrnrenno;
    }

    public void setZrnrenno(String pZrnrenno) {
        zrnrenno = pZrnrenno;
    }
    private String zrnsntkinfotourokusyskbn;

    public String getZrnsntkinfotourokusyskbn() {
        return zrnsntkinfotourokusyskbn;
    }

    public void setZrnsntkinfotourokusyskbn(String pZrnsntkinfotourokusyskbn) {
        zrnsntkinfotourokusyskbn = pZrnsntkinfotourokusyskbn;
    }

}